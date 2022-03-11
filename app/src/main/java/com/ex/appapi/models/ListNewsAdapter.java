package com.ex.appapi.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ex.appapi.R;

import java.net.URL;
import java.util.List;

public class ListNewsAdapter extends ArrayAdapter<News> {
private int ressource;


    public ListNewsAdapter(@NonNull Context context, int resource, @NonNull List<News> objects) {

        super(context, resource, objects);
        this.ressource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View myView = convertView;
        if(myView == null){
            myView= LayoutInflater.from(getContext()).inflate(ressource,parent,false);
        }
TextView name = myView.findViewById(R.id.name);
        TextView title = myView.findViewById(R.id.titre);
        ImageView image = myView.findViewById(R.id.image);
name.setText(String.valueOf(getItem(position).getSource().getName()));
title.setText(String.valueOf(getItem(position).getTitle()));
        Runnable thread= new Runnable(){
            @Override
            public void run() {
                try {
                    //Log.i("info",getItem(position).getAvatarUrl());
                    URL url=new URL(getItem(position).getUrlToImage());
                    Bitmap bitmap= BitmapFactory.decodeStream(url.openStream());
                    image.setImageBitmap(bitmap);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t=new Thread(thread);
        t.start();

        return myView;
    }
}
