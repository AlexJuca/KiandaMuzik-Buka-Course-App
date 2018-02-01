package android.visionaries.fragments;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.visionaries.R;
import android.visionaries.api.models.PopularTracks;
import android.visionaries.widgets.PlayPauseButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by AirtonLucas on 04/01/2018.
 */

public class NowPlayingCard extends Fragment implements MediaPlayer.OnPreparedListener {
    ImageView albumArt;
    ProgressBar progressBar;
    TextView mSongTitle;
    TextView mArtistTitle;
    PlayPauseButton playPauseButton;
    MediaPlayer player;
    ArrayList<PopularTracks> tracks;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_now_controls, container, false);
        albumArt = v.findViewById(R.id.controls_album_art);
        progressBar = v.findViewById(R.id.controls_progress);
        playPauseButton = v.findViewById(R.id.controls_play_pause);
        mSongTitle = v.findViewById(R.id.controls_song_title);
        mArtistTitle = v.findViewById(R.id.controls_artist_title);

        tracks = getArguments().getParcelableArrayList("popular");
        mArtistTitle.setText(tracks.get(0).getArtist().get(0).getName());
        mSongTitle.setText(tracks.get(0).getTrackTitle());
        Picasso.with(this.getContext()).load(tracks.get(0).getTrackCoverArt()).resize(512, 512).into(albumArt);
        player = new MediaPlayer();
        prepareAudioTrack();

        return v;
    }

    private void prepareAudioTrack() {

        try {
            player.setDataSource(tracks.get(0).getTrackUrl());
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setOnPreparedListener(this);
            player.prepareAsync();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        player.start();
        playPauseButton.setPlayed(false);
    }
}
