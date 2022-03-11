package com.ex.appapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.ex.appapi.models.ListNews;
import com.ex.appapi.models.ListNewsAdapter;
import com.ex.appapi.models.News;
import com.ex.appapi.services.RestServiceAPI;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listViewNews=findViewById(R.id.listnews);
        EditText keyword=findViewById(R.id.keyword);
        EditText date = findViewById(R.id.date);
        Button chercher=findViewById(R.id.chercher);
        List<News> data=new ArrayList<>();
        //ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,data);
        ListNewsAdapter adapter=new ListNewsAdapter(this,R.layout.list_item,data);
        listViewNews.setAdapter(adapter);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        RestServiceAPI serviceAPI=retrofit.create(RestServiceAPI.class);
        chercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data.clear();
                Call<ListNews> callUsers=serviceAPI.listNewsByKey(keyword.getText().toString(), date.getText().toString(),"9a73c97d1a2044e7b51339c2600418f2");
                callUsers.enqueue(new Callback<ListNews>() {
                    @Override
                    public void onResponse(Call<ListNews> call, Response<ListNews> response) {
                ListNews news = response.body();
                for(News n : news.getArticles()){
                    data.add(n);
                }
                adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<ListNews> call, Throwable t) {

                    }
                });
            }
        });
    }
}