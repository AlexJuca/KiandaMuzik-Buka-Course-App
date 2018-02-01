package android.visionaries.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.visionaries.Base2Activity;
import android.visionaries.R;
import android.visionaries.activities.AboutActivity;
import android.visionaries.adapters.PopularTracksAdapter;
import android.visionaries.api.Client;
import android.visionaries.api.ServiceGenerator;
import android.visionaries.api.models.PopularTracks;
import android.visionaries.models.Album;
import android.visionaries.models.Artist;
import android.visionaries.models.PopularTrackList;
import android.visionaries.models.Track;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    Context context = this;
    ArrayList<PopularTracks> popularTrackzs;
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    ImageView destque;
    ProgressBar progressBar;
    TextView artistNameDestaque;
    TextView trackTitleDestaque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        destque = findViewById(R.id.destaque_cover);
        recyclerView = findViewById(R.id.artistList);
        artistNameDestaque = findViewById(R.id.destaque_artista);
        progressBar = findViewById(R.id.progressBar);

        getTracks();


    }

    private void getTracks() {
        Client.PopularTracks client = ServiceGenerator.createService(Client.PopularTracks.class);
        client.getPopularTracks().enqueue(new Callback<ArrayList<PopularTracks>>() {
            @Override
            public void onResponse(Call<ArrayList<PopularTracks>> call, Response<ArrayList<PopularTracks>> response) {
                if (response.code() == 200) {
                    popularTrackzs = response.body();
                    Bundle songInfo = new Bundle();
                    songInfo.putParcelableArrayList("popular", popularTrackzs);
                    updateViews();
                    progressBar.setVisibility(View.GONE);
                    new initQuickControls().doInBackground(songInfo);

                } else {
                    Log.d(TAG, "onResponse: numeros de musicas => " + popularTrackzs.size());
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PopularTracks>> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
                progressBar.setVisibility(View.GONE);
            }
        });

    }

    private void updateViews() {
        artistNameDestaque.setText(popularTrackzs.get(0).getArtist().get(0).getName());
        trackTitleDestaque.setText(popularTrackzs.get(0).getTrackTitle());
        Picasso.with(this).load(popularTrackzs.get(0).getTrackCoverArt()).into(destque);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PopularTracksAdapter tracksAdapter = new PopularTracksAdapter(this, popularTrackzs);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(tracksAdapter);
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
