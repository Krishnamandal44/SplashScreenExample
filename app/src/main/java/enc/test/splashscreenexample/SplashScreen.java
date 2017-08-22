package enc.test.splashscreenexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    private UserSessionManager session;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        session = UserSessionManager.getInstance(SplashScreen.this);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        prefs = session.getSharedPref();
        if (prefs.getBoolean(UserSessionManager.KEY_FIRST_RUN, true)) {
            // Do first run stuff here
            Intent firstRunIntent = new Intent(this, ImageGridView.class);
            firstRunIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            firstRunIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(firstRunIntent);
            //overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out);

            prefs.edit().putBoolean(UserSessionManager.KEY_FIRST_RUN, false).apply();
        }else {
            Intent firstRunIntent = new Intent(this, ImageGridView.class);
            firstRunIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(firstRunIntent);
            overridePendingTransition(R.anim.anim_fade_out, R.anim.anim_fade_in);
        }
    }
}
