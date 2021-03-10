package com.onlinequiz.repository.remote;

import com.onlinequiz.model.Category;
import com.onlinequiz.repository.IRepository;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiClient implements IApiClient{
    private final String BASE_URL = "http://185.43.5.50:8001";

    private OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(provideLoggingInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();



    private HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        return httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL + "/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

    QuizNetworkClient client = retrofit.create(QuizNetworkClient.class);

    public String getBASE_URL(){
        return BASE_URL;
    }

    @Override
    public void getCategories(IRepository.CategoryCallback categoryCallback) {
        Call<List<Category>> call = client.getAllCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        categoryCallback.onSuccess(response.body());
                    }else {
                        categoryCallback.onFailure(new Exception("Category response is empty"));
                    }
                }else {
                    categoryCallback.onFailure(new Exception("Response code getCategory " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                categoryCallback.onFailure(new Exception(t));
            }
        });
    }

    private interface QuizNetworkClient{
        @GET("/api/quiz/")
        Call<List<Category>> getAllCategories();
    }

}
