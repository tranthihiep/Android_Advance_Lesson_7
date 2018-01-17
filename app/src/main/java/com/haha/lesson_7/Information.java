package com.haha.lesson_7;

/**
 * Created by trant on 17/01/2018.
 */

public class Information {
    private String mID;
    private String mName;
    private String mFullName;

    public Information(String mID, String mName, String mFullName) {
        this.mID = mID;
        this.mName = mName;
        this.mFullName = mFullName;
    }

    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }
}
