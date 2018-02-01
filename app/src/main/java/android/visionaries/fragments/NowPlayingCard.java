package android.visionaries.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.visionaries.R;
import android.visionaries.widgets.PlayPauseButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by AirtonLucas on 04/01/2018.
 */

public class NowPlayingCard extends Fragment {
    ImageView albumArt;
    ProgressBar progressBar;
    TextView mSongTitle;
    TextView mArtistTitle;
    PlayPauseButton playPauseButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_now_controls, container, false);
        albumArt = v.findViewById(R.id.controls_album_art);
        progressBar = v.findViewById(R.id.controls_progress);
        playPauseButton = v.findViewById(R.id.controls_play_pause);
        mSongTitle = v.findViewById(R.id.controls_song_title);
        mArtistTitle = v.findViewById(R.id.controls_artist_title);
        return v;
    }
}
