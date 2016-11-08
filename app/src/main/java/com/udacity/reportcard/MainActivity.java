package com.udacity.reportcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar(toolbar);
        ImageView imageView = (ImageView) findViewById(R.id.imageHead);
        showHeaderBackgroud(getString(R.string.main_head), imageView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        setupFabOnClick(fab);
    }


    private void setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
    }


    public void showHeaderBackgroud(String url, ImageView image) {
        try {
            Picasso.with(this).load(url).into(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setupFabOnClick(FloatingActionButton fab) {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ItemListActivity.class));
            }
        });
    }



}
