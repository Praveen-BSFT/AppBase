package com.base.appbase.http;

import com.base.appbase.config.ServerConfig;
import com.base.appbase.request.PostRequest;
import com.base.appbase.utils.AndroidUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pnarasimhaiah on 9/29/2016.
 */
public class HttpManager {

    private static final String TAG = HttpManager.class.getSimpleName();

    private static HttpManager instance;

    private Retrofit retrofit = null;

    private BaseRestInterface restInterface;

    private HttpManager() {
    }

    public static HttpManager getInstance() {
        if (instance == null) {
            instance = new HttpManager();
        }
        return instance;
    }

    public OkHttpClient.Builder getHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();//for using customizing the headers
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("User-Agent", AndroidUtils.getUserAgent())
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
        return httpClient;
    }

    private Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient client = getHttpClient().build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(ServerConfig.getBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public BaseRestInterface getRestInterface() {
        if (restInterface == null) {
            restInterface = getClient().create(BaseRestInterface.class);
        }
        return restInterface;
    }

    public void CallGetRequest()
    {
        if(getRestInterface() != null)
        {
            getRestInterface().getRequest();
        }
    }

    public void CallPostRequest(PostRequest postRequest)
    {
        if(getRestInterface() != null)
        {
            getRestInterface().postRequest(postRequest);
        }
    }


}
