package com.example.manue.numbertrivia;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NumbersApiService {
    //Base url (common to all requests)
    String BASE_URL = "http://numbersapi.com/";

    //Create a retrofit client
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //Now we need to add this to our request
    // I had to add the app looks very bad with really big numbers.
    @GET("/random/trivia?json&max=999")

    //Now we define the get method
    Call<TriviaQuoteItem> getRandomQuote();
}
