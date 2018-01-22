package android.visionaries.models;

import java.util.ArrayList;

/**
 * Created by AirtonLucas on 19/12/2017.
 */

public class PopularTrackList {
    private int trackListId;
    private ArrayList<Track> popularTracks;

    public int getTrackListId() {
        return trackListId;
    }

    public void setTrackListId(int trackListId) {
        this.trackListId = trackListId;
    }

    public ArrayList<Track> getPopularTracks() {
        return popularTracks;
    }

    public void setPopularTracks(ArrayList<Track> popularTracks) {
        this.popularTracks = popularTracks;
    }
}
