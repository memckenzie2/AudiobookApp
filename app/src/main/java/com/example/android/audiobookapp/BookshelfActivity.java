package com.example.android.audiobookapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BookshelfActivity  extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        //Loads Current List of AudioBooksOption Added to Reading List using the AudioBook Class
    }
}
