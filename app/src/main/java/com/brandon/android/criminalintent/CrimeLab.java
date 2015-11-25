package com.brandon.android.criminalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

public class CrimeLab {

    private static final String TAG = "CrimeLab";
    private static final String FILENAME = "crimes.json";

    private CriminalIntentJSONSerializer mSerializer;
    private ArrayList<Crime> mCrimes;
    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        mSerializer = new CriminalIntentJSONSerializer(mAppContext, FILENAME);
    }//end CrimeLab(Context)

    public static CrimeLab get(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }

        return sCrimeLab;
    }//end CrimeLab(Context)

    public void addCrime(Crime c){
        mCrimes.add(c);
    }//end addCrime(Crime)

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }//end getCrimes()

    public Crime getCrime(UUID id){
        for (Crime c: mCrimes){
            if (c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }//end getCrime(UUID)

    public boolean saveCrimes() {
        try {
            mSerializer.saveCrimes(mCrimes);
            Log.d(TAG, "Crimes saved to file.");
            return true;
        } catch (Exception e){
            Log.e(TAG, "Error saving crimes", e);
            return false;
        }
    }
}//end CrimeLab class
