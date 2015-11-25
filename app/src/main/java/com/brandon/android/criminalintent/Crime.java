package com.brandon.android.criminalintent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;
import java.util.Date;

public class Crime {

    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_SOLVED = "solved";
    private static final String JSON_DATE = "date";

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        //Generate a unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }//end Crime()

    public UUID getId() {
        return mId;
    }//end getId()

    public void setTitle(String title) {
        mTitle = title;
    }//end setTitle(String)

    public String getTitle() {
        return mTitle;
    }//end getTitle()

    public void setDate(Date date) {
        mDate = date;
    }//end setDate(Date)

    public Date getDate() {
        return mDate;
    }//end getDate()

    public boolean isSolved() {
        return mSolved;
    }//end isSolved()

    public void setSolved(boolean solved) {
        mSolved = solved;
    }//end setSolved(boolean)

    @Override
    public String toString(){
        return mTitle;
    }//end toString()

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_ID, mId.toString());
        json.put(JSON_TITLE, mTitle);
        json.put(JSON_SOLVED, mSolved);
        json.put(JSON_DATE, mDate.getTime());
        return json;
    }//end toJSON()
}//end Crime class
