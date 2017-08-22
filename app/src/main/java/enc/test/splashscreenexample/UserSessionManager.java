package enc.test.splashscreenexample;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class UserSessionManager {

    public static final String KEY_EMAIL = "email";
    public static final String KEY_USERID = "userId";

    public static final String KEY_FIRST_RUN = "firstRun";

    public static final String DEVICE_ID = "deviceid";
    private static final String PREFER_NAME = "FikarrNot";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    private static UserSessionManager instance = null;
    private SharedPreferences pref;
    private Context sessionContext;

    // Constructor
    private UserSessionManager(){}

    public static UserSessionManager getInstance(Context context) {
        if(instance == null) {
            instance = new UserSessionManager();
        }
        instance.sessionContext = context;
        instance.pref = instance.sessionContext.getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);
        return instance;
    }

    /**
     * Get stored session data
     *
     */
    public HashMap<String, String> getSessionDetails(){
        HashMap<String, String> session = new HashMap<String, String>();
        session.put(KEY_USERID, pref.getString(KEY_USERID, null));
        session.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        session.put(DEVICE_ID, pref.getString(DEVICE_ID, null));
        return session;
    }


    public void setSessionValue(String key, String value)
    {
        SharedPreferences.Editor editor = pref.edit();
    }

    public String getSessionValue(String key)
    {
        return pref.getString(KEY_USERID, null);
    }

    public void firstRun(boolean isFirstRun){
        SharedPreferences.Editor editor = pref.edit();
        if (pref.getBoolean(KEY_FIRST_RUN, true)) {
            // Do first run stuff here then set 'firstrun' as false
            // using the following line to edit/commit prefs
            editor.putBoolean(KEY_FIRST_RUN, false).apply();
        }
    }

    public SharedPreferences getSharedPref(){
        return pref;
    }
    //Create login session
    public void createUserLoginSession(String userId, String email, String deviceid){
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(KEY_USERID, userId);
        editor.putString(KEY_EMAIL, email);
        editor.putString(DEVICE_ID, deviceid);
        editor.apply();
    }

    public boolean checkLogin(){

        if(!this.isUserLoggedIn()){
            return true;
        }
        else {
            return false;
        }
    }

    public void logoutUser(){
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
//        editor.apply();
        editor.commit();
    }
    // Check for login
    public boolean isUserLoggedIn(){
        return pref.getBoolean(DEVICE_ID, false);
    }
}
