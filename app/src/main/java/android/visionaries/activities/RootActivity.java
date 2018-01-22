package android.visionaries.activities;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.visionaries.R;
import android.visionaries.fragments.NowPlayingFragment;

/**
 * Created by AirtonLucas on 04/01/2018.
 */

public class RootActivity extends AppCompatActivity{

    public class initializeControls extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            NowPlayingFragment nowPlayingFragment = new NowPlayingFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.quick_controls_container, nowPlayingFragment)
                    .commitAllowingStateLoss();
            return "Execute";
        }
    }

}
