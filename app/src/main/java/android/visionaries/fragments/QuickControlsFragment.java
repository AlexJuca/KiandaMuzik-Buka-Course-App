package android.visionaries.fragments;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.visionaries.R;
import android.visionaries.widgets.PlayPauseButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


public class QuickControlsFragment extends Fragment implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener{

    private ProgressBar mProgress;
    private PlayPauseButton mPlayPause;
    private TextView mTitle;
    private TextView mArtist;
    private ImageView mAlbumArt;
    private View rootView;
    private View playPauseWrapper;
    private boolean isPlayingTrack = false;
    MediaPlayer mediaPlayer;
    int overflowcounter = 0;
    String mTag = this.getClass().getSimpleName();
    private String[] urls = {"http://www.naijalumia.com/wp-content/uploads/2017/10/Big_Shaq_-_Mans_No" +
            "t_Hot(NaijaLumia.com).mp3"};

    public Runnable mUpdateProgress = new Runnable() {
        @Override
        public void run() {
            long position = mediaPlayer.getCurrentPosition();
            mProgress.setProgress((int) position);
            overflowcounter--;
            int delay = (int) (1500 - (position % 1000));
            if (overflowcounter < 0) {
                overflowcounter++;
                mProgress.postDelayed(mUpdateProgress, delay);
            }
        }

    };



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quick_controls, container, false);
        this.rootView = view;
        mPlayPause = rootView.findViewById(R.id.play_pause);
        playPauseWrapper = rootView.findViewById(R.id.play_pause_wrapper);
        mProgress = rootView.findViewById(R.id.song_progress_normal);
        mTitle = rootView.findViewById(R.id.title);
        mArtist = rootView.findViewById(R.id.artist);
        mAlbumArt = rootView.findViewById(R.id.album_art_nowplayingcard);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mProgress.getLayoutParams();
        mProgress.measure(0, 0);
        layoutParams.setMargins(0, -(mProgress.getMeasuredHeight() / 2), 0, 0);
        mProgress.setLayoutParams(layoutParams);
        mProgress.setProgress(0);
        String url = urls[0];
        mediaPlayer = null;

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mPlayPause.setOnClickListener(mPlayPauseListener);

         return view;

    }


    private final View.OnClickListener mPlayPauseListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!mPlayPause.isPlayed()) {
                mPlayPause.setPlayed(true);
                mPlayPause.startAnimation();
                Log.d(mTag, "Playing");
            } else {
                Log.d(mTag, "Paused");
                mPlayPause.setPlayed(false);
                mPlayPause.startAnimation();
            }
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(!isPlayingTrack) {
                        mediaPlayer.start();
                        isPlayingTrack = true;
                    } else {
                        mediaPlayer.pause();
                        isPlayingTrack = false;
                    }
                }
            }, 200);

        }
    };


    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        mPlayPause.setPlayed(true);
        mPlayPause.startAnimation();
        mTitle.setText("Mans Not Hot");
        mArtist.setText("Big Shaq");
        isPlayingTrack = true;
        mProgress.setMax((int) mediaPlayer.getDuration());
        mProgress.postDelayed(mUpdateProgress, 10);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mPlayPause.setPlayed(false);
        mPlayPause.startAnimation();
        Toast.makeText(this.getContext(), "Song completed", Toast.LENGTH_SHORT).show();
    }
}
