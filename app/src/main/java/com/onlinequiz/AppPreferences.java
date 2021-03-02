package com.onlinequiz;

import com.onlinequiz.utils.ISharedStorage;

public class AppPreferences {
    private static final String PREF_IS_FIRST_LAUNCH = "is_first_launch";
    private ISharedStorage iSharedStorage;

    public AppPreferences(ISharedStorage iSharedStorage){
        this.iSharedStorage = iSharedStorage;
    }
    boolean isFirstLaunch(){
        return iSharedStorage.get(PREF_IS_FIRST_LAUNCH,true);
    }
    void setLaunched(){
        iSharedStorage.set(PREF_IS_FIRST_LAUNCH,false);
    }
}
