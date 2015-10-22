package com.brandon.android.criminalintent;

import java.util.UUID;
import java.util.Date;

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        //Generate a unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }//end Crime

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
    }//end toString
}//end Crime class
