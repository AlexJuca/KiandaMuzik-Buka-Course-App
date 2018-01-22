package android.visionaries.models;

/**
 * Created by AirtonLucas on 28/11/2017.
 */

public class Track {
    private int trackId;
    private String aPath;
    private String aName;
    private Album aAlbum;
    private Artist aArtist;
    private int trackCover;

    public String getaPath() {
        return aPath;
    }

    public void setaPath(String aPath) {
        this.aPath = aPath;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public Album getaAlbum() {
        return aAlbum;
    }

    public void setaAlbum(Album aAlbum) {
        this.aAlbum = aAlbum;
    }

    public Artist getaArtist() {
        return aArtist;
    }

    public void setaArtist(Artist aArtist) {
        this.aArtist = aArtist;
    }

    @Override
    public String toString() {
        return getaArtist().getName();
    }

    public int getTrackCover() {
        return trackCover;
    }

    public void setTrackCover(int trackCover) {
        this.trackCover = trackCover;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }
}
