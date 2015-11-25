package com.brandon.android.criminalintent;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;

public class CriminalIntentJSONSerializer {
    private Context mContext;
    private String mFileName;

    public CriminalIntentJSONSerializer(Context c, String f){
        mContext = c;
        mFileName = f;
    }//end CriminalIntentJSONSerializer(Context, String)

    public ArrayList<Crime> loadCrimes() throws JSONException, IOException {
        ArrayList<Crime> crimes = new ArrayList<>();
        BufferedReader reader = null;
        try {
            //Open and read th file into a StringBuilder
            InputStream in = mContext.openFileInput(mFileName);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                //Line breaks are omitted and irrelevant
                jsonString.append(line);
            }
            //Pare the JSON using JSONTokener
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            //Build the array of crimes from JSONObjects
            for (int i = 0; i< array.length(); i++){
                crimes.add(new Crime(array.getJSONObject(i)));
            }
        }catch (FileNotFoundException e){
            //Ignore this one; it happens when starting fresh.
        }finally {
            if (reader != null){
                reader.close();
            }
        }
        return crimes;
    }//end loadCrimes()

    public void saveCrimes(ArrayList<Crime> crimes) throws JSONException, IOException {
        //Build an array in JSON
        JSONArray array = new JSONArray();
        for (Crime c: crimes){
            array.put(c.toJSON());
        }

        //Write the file to disk
        Writer writer = null;
        try{
            OutputStream out = mContext.openFileOutput(mFileName, Context.MODE_PRIVATE);
        }finally{
            if (writer != null)
                writer.close();
        }
    }//end saveCrimes(ArrayList<Crime>)
}//end CriminalIntentJSONSerializer class