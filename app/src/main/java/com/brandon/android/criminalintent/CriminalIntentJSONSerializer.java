package com.brandon.android.criminalintent;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;

public class CriminalIntentJSONSerializer {
    private Context mContext;
    private String mFileName;

    public CriminalIntentJSONSerializer(Context c, String f){
        mContext = c;
        mFileName = f;
    }//end CriminalIntentJSONSerializer(Context, String)

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