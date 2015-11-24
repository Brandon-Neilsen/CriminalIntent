package com.brandon.android.criminalintent;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

public class CrimeLab {
    private ArrayList<Crime> mCrimes;
    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for (int i = 0; i < 100;i++){
            Crime c = new Crime();
            c.setTitle("Crime #" +(i + 1));
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

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
}//end CrimeLab class
