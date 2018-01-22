package android.visionaries.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.visionaries.Base2Activity;
import android.visionaries.R;
import android.visionaries.activities.AboutActivity;
import android.visionaries.adapters.PopularTracksAdapter;
import android.visionaries.models.Album;
import android.visionaries.models.Artist;
import android.visionaries.models.PopularTrackList;
import android.visionaries.models.Track;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Base2Activity {
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView destque = findViewById(R.id.destaque_cover);
        RecyclerView recyclerView = findViewById(R.id.artistList);
        Artist artist = new Artist();
        artist.setArtistCoverImage(R.drawable.big_shaq_track);
        artist.setId(0);
        artist.setDescription("Michael Dapaah (born January 1991[2]) is an English rapper, actor, and comedian of Ghanaian descent, best known for portraying the fictional road rapper Big Shaq (also known as Roadman Shaq). He is also known for his mockumentary SWIL (Somewhere in London), which focuses on four characters" +
                " and their journey to success.");
        artist.setMusicStyle("RNB");
        artist.setName("Big Shaq");
        artist.setVerified(false);

        Album bigOne = new Album(0, "Big One", artist.getId());
        Track track = new Track();
        track.setaAlbum(bigOne);
        track.setaArtist(artist);
        track.setaName("Mans Bot Hot");
        track.setTrackCover(R.drawable.big_shaq_track);

        Artist artist1 = new Artist();
        artist1.setName("Forca Suprema");
        artist1.setId(0);
        artist1.setDescription("FS");
        artist1.setMusicStyle("RNB");
        artist1.setVerified(true);

        Track track2 = new Track();
        track2.setaName("Urna");
        track2.setaArtist(artist1);
        track2.setaAlbum(new Album(1, "Forca", artist1.getId()));
        track2.setTrackCover(R.drawable.nga);

        Track track3 = new Track();
        track3.setaName("Urna");
        track3.setaArtist(artist1);
        track3.setaAlbum(new Album(1, "Forca", artist1.getId()));
        track3.setTrackCover(R.drawable.nga);

        Track track4 = new Track();
        track4.setaName("Urna");
        track4.setaArtist(artist1);
        track4.setaAlbum(new Album(1, "Forca", artist1.getId()));
        track4.setTrackCover(R.drawable.nga);

        Track track5 = new Track();
        track5.setaName("Urna");
        track5.setaArtist(artist1);
        track5.setaAlbum(new Album(1, "Forca", artist1.getId()));
        track5.setTrackCover(R.drawable.nga);


        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(track);
        tracks.add(track2);
        tracks.add(track3);
        tracks.add(track4);
        tracks.add(track5);


        PopularTrackList popularTrackList = new PopularTrackList();
        popularTrackList.setPopularTracks(tracks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PopularTracksAdapter tracksAdapter = new PopularTracksAdapter(this, popularTrackList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(tracksAdapter);
        new initNowPlayingControls().execute("");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
