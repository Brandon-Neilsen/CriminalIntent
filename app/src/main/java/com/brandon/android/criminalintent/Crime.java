package com.brandon.android.criminalintent;

import java.util.UUID;
import java.util.Date;

public class Crime
{
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime()
    {
        //Generate a unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId()
    {
        return mId;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public void setDate(Date date)
    {
        mDate = date;
    }

    public Date getDate()
    {
        return mDate;
    }

    public boolean isSolved()
    {
        return mSolved;
    }

    public void setSolved(boolean solved)
    {
        mSolved = solved;
    }
}
