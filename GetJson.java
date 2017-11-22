package it.itspiemonte.pietro.newsapplication;

/**
 * Created by Pietro on 22/11/2017.
 */



        import java.io.IOException;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.Response;



public class GetJson {
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


}