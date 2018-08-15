package com.example.android.audiobookapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class BookshelfActivity extends AppCompatActivity {
    ListView l;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        //Loads Current List of AudioBooksOption Available using the AudioBooksOption Class
        /*Creates a MenuAdapter which adapts an ArrayAdapter to contain a list of AudiobookOptions (4 TextViews, 2 Buttons)
        using the bookItemsBookshelf ArrayList contian the user's current list of audiobooks.*/
        AudioBookArrayAdapter bookMenu = new AudioBookArrayAdapter(this, MainActivity.getBookMenu());

        //Sets the ListView in book_list.xml to be the AudioBookArrayAdapter bookMenu.
        l = findViewById(R.id.list);
        l.setAdapter(bookMenu);

        /*Create a set of navigation buttons to be used in lieu of an Action Bar so user can navigate between activities*/

        //Highlights the current activity in the navigation menu by setting it's background to white.
        Button bookshelfButton = findViewById(R.id.shelf_nav);
        bookshelfButton.setTextColor(getResources().getColor(android.R.color.white));

        //Home button - launches the MainActivity when clicked
        Button home = findViewById(R.id.home_nav);
        home.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent homeActivity = new Intent(getBaseContext(), MainActivity.class);
                startActivity(homeActivity);
            }
        });

        //Currently Reading button - launches the Currently Reading activity when clicked
        Button current = findViewById(R.id.current_nav);
        current.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent currentActivity = new Intent(getBaseContext(), CurrentlyReadingActivity.class);
                startActivity(currentActivity);
            }
        });


        //Discover button - launches the Discover activity when clicked
        Button discover = findViewById(R.id.discover_nav);
        discover.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent discoverActivity = new Intent(getBaseContext(), DiscoverActivity.class);
                startActivity(discoverActivity);
            }
        });


    }

}
