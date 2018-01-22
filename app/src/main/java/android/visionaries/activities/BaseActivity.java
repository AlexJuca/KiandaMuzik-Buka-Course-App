package android.visionaries.activities;

import android.app.FragmentManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.visionaries.R;
import android.visionaries.fragments.NowPlayingCard;
import android.visionaries.fragments.QuickControlsFragment;

/**
 * Created by AirtonLucas on 19/12/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public class initQuickControls extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            // TODO: Initialize QuickControlsFragment
            NowPlayingCard nowPlayingCard = new NowPlayingCard();
            android.support.v4.app.FragmentManager fragmentManager =
                    getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.quick_controls_container, nowPlayingCard)
                    .commitAllowingStateLoss();
            return  "Executed";
        }
    }

    public void showMiniController() {
        // TODO: Implememt by overiding in activities
    }

    public void hideMiniController() {
        // TODO: implement by overiding in activities
    }

}
