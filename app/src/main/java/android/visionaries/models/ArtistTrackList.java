package android.visionaries.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AirtonLucas on 07/12/2017.
 */

public class ArtistTrackList {
    private int trackListId;
    private int artistId;
    private ArrayList<Track> artistTracks;

    public ArtistTrackList(int trackListId, int artistId, ArrayList<Track> artistTracks) {
        this.trackListId = trackListId;
        this.artistId = artistId;
        this.artistTracks = artistTracks;
    }

    public int getTrackListId() {
        return trackListId;
    }

    public void setTrackListId(int trackListId) {
        this.trackListId = trackListId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public ArrayList<Track> getArtistTracks() {
        return artistTracks;
    }

    public void setArtistTracks(ArrayList<Track> artistTracks) {
        this.artistTracks = artistTracks;
    }
}
