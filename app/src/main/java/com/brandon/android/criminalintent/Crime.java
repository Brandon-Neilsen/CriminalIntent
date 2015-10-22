package com.brandon.android.criminalintent;

import java.util.UUID;

public class Crime
{
    private UUID mId;
    private String mTitle;

    public Crime()
    {
        //Generate a unique identifier
        mId = UUID.randomUUID();
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
}
