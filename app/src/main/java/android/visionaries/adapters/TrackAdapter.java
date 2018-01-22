package android.visionaries.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.visionaries.R;
import android.visionaries.models.ArtistTrackList;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AirtonLucas on 28/11/2017.
 */

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {
    ArtistTrackList mSongs;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mArtistNameView;
        public TextView mSongNameView;
        public TextView mSongDurationView;
        public ImageView trackCover;
        public ImageView artistBadge;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            this.mArtistNameView = itemView.findViewById(R.id.artistName);
            this.mSongDurationView = itemView.findViewById(R.id.trackDuration);
            this.mSongNameView = itemView.findViewById(R.id.trackTitle);
            this.trackCover = itemView.findViewById(R.id.trackCover);
            this.artistBadge = itemView.findViewById(R.id.verifiedBadge);
        }
    }

    public TrackAdapter(ArtistTrackList tracks) {
        mSongs = tracks;
    }

    @Override
    public void onBindViewHolder(TrackAdapter.ViewHolder holder, int position) {
        holder.mArtistNameView.setText(mSongs.getArtistTracks().get(position).getaArtist().getName());
        holder.mSongNameView.setText(mSongs.getArtistTracks().get(position).getaName());
        holder.trackCover.setImageResource(mSongs.getArtistTracks().get(position).getTrackCover());

    }

    @Override
    public TrackAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mSongs.getArtistTracks().size();
    }
}
