package android.visionaries.api;

import android.visionaries.api.models.PopularTracks;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by AirtonLucas on 01/02/2018.
 */

public class Client {
    public interface PopularTracks {
        @GET("popular")
        Call<ArrayList<android.visionaries.api.models.PopularTracks>> getPopularTracks();
    }
}
