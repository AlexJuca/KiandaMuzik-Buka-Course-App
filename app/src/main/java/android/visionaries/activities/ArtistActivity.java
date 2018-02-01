package android.visionaries.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.visionaries.R;
import android.visionaries.adapters.PopularTracksConstants;
import android.visionaries.adapters.TrackAdapter;
import android.visionaries.models.Album;
import android.visionaries.models.Artist;
import android.visionaries.models.ArtistTrackList;
import android.visionaries.models.Track;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistActivity extends BaseActivity {
    ImageView capaDoArtist;
    TextView nomeArtista;
    TextView artistDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        capaDoArtist = findViewById(R.id.header);
        nomeArtista = findViewById(R.id.artistName);
        artistDescription = findViewById(R.id.artistDescription);

        Bundle musicData = getIntent().getExtras();
        if (musicData != null) {
            capaDoArtist.setImageResource(musicData.getInt(PopularTracksConstants.TRACK_COVER));
            setTitle(musicData.getString(PopularTracksConstants.ARTIST_TITLE));
            nomeArtista.setText(musicData.getString(PopularTracksConstants.ARTIST_TITLE));
            artistDescription.setText(musicData.getString(PopularTracksConstants.ARTIST_DESCRIPTION));
        }

        ArtistTrackList trackList = getArtistTrackList();
        inicializarRecycleView(trackList);

    }

    private void inicializarRecycleView(ArtistTrackList trackList) {
        RecyclerView recyclerView = findViewById(R.id.trackList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TrackAdapter artistAdapter = new TrackAdapter(trackList);
        recyclerView.setAdapter(artistAdapter);
    }

    @NonNull
    private ArtistTrackList getArtistTrackList() {
        Artist artist = new Artist(1, "Forca Suprema",
                "descricrption", R.drawable.header);
        Track track = new Track();
        track.setaName("Urna");
        track.setaArtist(artist);
        track.setaAlbum(new Album(1, "Forca", artist.getId()));
        track.setTrackCover(R.drawable.nga);
        Track a = new Track();
        a.setaName("Really");
        a.setaArtist(artist);
        a.setaAlbum(new Album(1, "Forca", artist.getId()));
        a.setTrackCover(R.drawable.fs);

        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(a);
        tracks.add(track);
        return new ArtistTrackList(1, artist.getId(), tracks);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
