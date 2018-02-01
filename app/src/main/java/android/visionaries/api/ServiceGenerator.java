package android.visionaries.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AirtonLucas on 01/02/2018.
 */

public class ServiceGenerator {
    private static final String TEST_URL = "http://192.168.0.104:3000/";
    private static final Retrofit.Builder builder = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create()).baseUrl(TEST_URL);

    private final static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> s) {
        return retrofit.create(s);
    }
}
