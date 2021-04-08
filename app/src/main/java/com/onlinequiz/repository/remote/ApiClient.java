package com.onlinequiz.repository.remote;

import com.onlinequiz.model.AnswerPostModel;
import com.onlinequiz.model.Category;
import com.onlinequiz.model.OptionList;
import com.onlinequiz.model.Question;
import com.onlinequiz.repository.IRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class ApiClient implements IApiClient{
    private final String BASE_URL = "http://78.24.223.72/";

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

    @Override
    public void getQuestions(IRepository.CallBack<List<Question>> callBack) {
        Call<List<Question>> call = client.getQuestions();
        call.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        callBack.onSuccess(response.body());
                    }else {
                        callBack.onFailure(new Exception("Question response is empty"));
                    }
                }else {
                    callBack.onFailure(new Exception("Response code Question" + response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                callBack.onFailure(new Exception(t));
            }
        });
    }

    @Override
    public void getOptionListById(List<Integer> id, IRepository.CallBack<List<OptionList>> callBack) {
        Call<List<OptionList>> call = client.getOptionListsById(new AnswerPostModel(id));
        call.enqueue(new Callback<List<OptionList>>() {
            @Override
            public void onResponse(Call<List<OptionList>> call, Response<List<OptionList>> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        callBack.onSuccess(response.body());
                    }else {
                        callBack.onFailure(new Exception("Response is empty"));
                    }
                }else {
                    callBack.onFailure(new Exception("Response code getProfessionsTypeId" + response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<OptionList>> call, Throwable t) {
                callBack.onFailure(new Exception(t));
            }
        });
    }

    @Override
    public void getOptionList(IRepository.CallBack<List<OptionList>> callBack) {

    }

//    @Override
//    public void getOptionList(IRepository.CallBack<List<OptionList>> callBack) {
////        Call<List<OptionList>> call = client.getOptionLists();
////        call.enqueue(new Callback<List<OptionList>>() {
////            @Override
////            public void onResponse(Call<List<OptionList>> call, Response<List<OptionList>> response) {
////                if (response.isSuccessful()){
////                    if (response.body() !=null){
////                        callBack.onSuccess(response.body());
////                    }else {
////                        callBack.onFailure(new Exception("Option List is empty"));
////                    }
////                }else {
////                    callBack.onFailure(new Exception("Response code Option List" + response.code()));
////                }
////            }
////
////            @Override
////            public void onFailure(Call<List<OptionList>> call, Throwable t) {
////                callBack.onFailure(new Exception(t));
////            }
////        });
//    }



    private interface QuizNetworkClient{
        @GET("/api/quiz/")
        Call<List<Category>> getAllCategories();

        @GET("/api/quiz/questions/")
        Call<List<Question>> getQuestions();
//
//        @POST("api/answers/")
//        Call<List<OptionList>> getOptionLists(@Field("ids") List<Integer> listOfIds);


        @POST("api/answers/")
        Call<List<OptionList>> getOptionListsById(
                @Body AnswerPostModel getOptionListsById
        );
    }
}
