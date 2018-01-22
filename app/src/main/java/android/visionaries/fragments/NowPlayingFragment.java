package android.visionaries.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.visionaries.R;
import android.visionaries.widgets.PlayPauseButton;
import android.visionaries.widgets.SquareImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by AirtonLucas on 04/01/2018.
 */

public class NowPlayingFragment extends Fragment {

    ProgressBar mProgressBar;
    SquareImageView mAlbumCoverArt;
    TextView mArtistTitle;
    TextView mSongTitle;
    PlayPauseButton playPauseButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quick_controls, container, false);
        mAlbumCoverArt = v.findViewById(R.id.controls_album_art);
        mSongTitle = v.findViewById(R.id.controls_song_title);
        mArtistTitle = v.findViewById(R.id.controls_artist_title);
        mProgressBar = v.findViewById(R.id.controls_progress);
        playPauseButton = v.findViewById(R.id.controls_play_pause);

        return v;
    }


}
