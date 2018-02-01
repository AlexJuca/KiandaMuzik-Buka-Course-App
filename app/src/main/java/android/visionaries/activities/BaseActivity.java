package android.visionaries.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.visionaries.R;
import android.visionaries.fragments.NowPlayingCard;

/**
 * Created by AirtonLucas on 19/12/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public class initQuickControls extends AsyncTask<Bundle, Void, String> {
        @Override
        protected String doInBackground(Bundle... bundles) {
            // TODO: Initialize QuickControlsFragment
            NowPlayingCard nowPlayingCard = new NowPlayingCard();
            nowPlayingCard.setArguments(bundles[0]);
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
