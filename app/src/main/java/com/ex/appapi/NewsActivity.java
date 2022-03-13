package com.ex.appapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.ex.appapi.models.News;

import org.w3c.dom.Text;

import java.net.URL;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_datail);
        Intent intent = getIntent();
        News news =(News)intent.getSerializableExtra("news");
        ImageView image = findViewById(R.id.imag);
        TextView name = findViewById(R.id.newsname);
        TextView title=findViewById(R.id.newstitle);
        TextView content = findViewById(R.id.content);
        TextView date = findViewById(R.id.datepublish);
        name.setText(news.getSource().getName());
        title.setText(news.getTitle());
        content.setText(news.getContent());
        date.setText(news.getPublishedAt());
        Runnable thread= new Runnable(){
            @Override
            public void run() {
                try {

                    URL url=new URL(news.getUrlToImage());
                    Bitmap bitmap= BitmapFactory.decodeStream(url.openStream());
                    image.setImageBitmap(bitmap);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t=new Thread(thread);
        t.start();
    }
}