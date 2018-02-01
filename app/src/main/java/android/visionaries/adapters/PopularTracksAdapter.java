package android.visionaries.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.visionaries.R;
import android.visionaries.activities.ArtistActivity;
import android.visionaries.api.models.PopularTracks;
import android.visionaries.models.Artist;
import android.visionaries.models.PopularTrackList;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by AirtonLucas on 19/12/2017.
 */
public class PopularTracksAdapter extends RecyclerView.Adapter<PopularTracksAdapter.Viewholder> {

    private static Context mContext;
    private ArrayList<PopularTracks> mPopularTrackList;

    public PopularTracksAdapter(Context context, ArrayList<PopularTracks> popularTrackList) {
        mContext = context;
        mPopularTrackList = popularTrackList;
    }

    public static class Viewholder extends RecyclerView.ViewHolder  {
        ImageView trackCover;
        ImageView verifiedArtistBadge;
        TextView artistName;
        TextView trackTitle;
        public Viewholder(View itemView) {
            super(itemView);
            trackCover = itemView.findViewById(R.id.trackCover);
            verifiedArtistBadge = itemView.findViewById(R.id.verifiedBadge);
            artistName = itemView.findViewById(R.id.artistName);
            trackTitle = itemView.findViewById(R.id.trackTitle);
        }

    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.artist_card, parent, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.trackTitle.setText(mPopularTrackList.get(position).getTrackTitle());
        holder.artistName.setText(mPopularTrackList.get(position).getArtist().get(0).getName());
        Picasso.with(mContext).load(mPopularTrackList.get(position).getTrackCoverArt()).resize(512, 512).into(holder.trackCover);
        Bundle musicData = new Bundle();
        musicData.putString(PopularTracksConstants.ARTIST_TITLE, mPopularTrackList.get(position).getArtist().get(0).getName());
        musicData.putString(PopularTracksConstants.TRACK_TITLE, mPopularTrackList.get(position).getTrackTitle());
        musicData.putString(PopularTracksConstants.TRACK_COVER, mPopularTrackList.get(position).getTrackCoverArt());
        musicData.putString(PopularTracksConstants.ARTIST_DESCRIPTION, mPopularTrackList.get(position).getArtist().get(0).getDescription());

        final Intent intent = new Intent(mContext, ArtistActivity.class);
        intent.putExtras(musicData);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPopularTrackList.size();
    }

}
