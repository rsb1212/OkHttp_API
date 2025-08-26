package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)throws IOException{
//        OkHttpClient client=new OkHttpClient();
//
////        String url="https://jsonplaceholder.typicode.com/todos/1";
//        String url="https://example.com/";
//
//            Request request=new Request.Builder().url(url).build();
//
//
//        try(Response response=client.newCall(request).execute()){
//            if(!response.isSuccessful()){
//                System.out.print("Invalid Url");
//            }
//            System.out.print(response.body().string());
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoService todoService = retrofit.create(TodoService.class);
        ToDo t = todoService.getToDoById("2").execute().body();
        System.out.println(t.toString());
    }
}