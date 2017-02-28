package com.base.appbase.http;

import com.base.appbase.request.PostRequest;
import com.base.appbase.response.GetResponse;
import com.base.appbase.response.PostResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by pnarasimhaiah on 9/29/2016.
 */
public interface BaseRestInterface {

    @GET("config")
    Call<GetResponse> getRequest();

    @POST("search")
    Call<PostResponse> postRequest(@Body PostRequest postRequest);


}
