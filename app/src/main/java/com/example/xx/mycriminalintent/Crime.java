package com.example.xx.mycriminalintent;

import java.util.StringTokenizer;
import java.util.UUID;

/**
 * Created by XX on 2017/3/8.
 */

public class Crime {
    private UUID mId;
    private String mTitle;

    public Crime()
    {
        mId=UUID.randomUUID();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {

        return mId;
    }
}
