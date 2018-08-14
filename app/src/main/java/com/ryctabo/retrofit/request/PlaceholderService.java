package com.ryctabo.retrofit.request;

import com.ryctabo.retrofit.domain.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0
 */
public interface PlaceholderService {

    @GET("users")
    Observable<List<User>> getUsers();

    @GET("users/{id}")
    Observable<User> getUserById(@Path("id") Long id);

}
