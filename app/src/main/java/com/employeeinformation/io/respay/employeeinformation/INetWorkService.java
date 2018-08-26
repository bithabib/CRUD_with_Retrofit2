package com.employeeinformation.io.respay.employeeinformation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface INetWorkService {
    @FormUrlEncoded
    @POST("/webapp/insert.php")
    Call<Employee> insertData(@Field("name") String name, @Field("type") String type ,@Field("id") String id , @Field("address") String address , @Field("date_of_joining") String date_of_joining , @Field("password") String password);
    @FormUrlEncoded
    @POST("/webapp/login.php")
    Call<Employee> login(@Field("id") String id , @Field("password") String password);

    @GET("/webapp/get.php")
    Call<List<Employee>>getData();

    @FormUrlEncoded
    @POST("/webapp/delete.php")
    Call<Employee> deleteData(@Field("id") String id);

    @FormUrlEncoded
    @POST("/webapp/update.php")
    Call<Employee> updateData(@Field("name") String name, @Field("type") String type ,@Field("id") String id , @Field("address") String address , @Field("date_of_joining") String date_of_joining);
}
