package com.example.android.audiobookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DiscoverActivity  extends AppCompatActivity {
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        //Loads Current List of AudioBooksOption Available using the AudioBooksOption Class
        //Create a list with all menu option items
        ArrayList<AudioBooksOption> bookItems = new ArrayList<AudioBooksOption>();

        //Add book items to list
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59 ","Sir Arthur Conan Doyle","LibriVox Volunteers", false));
        bookItems.add(new AudioBooksOption("The Memoirs of Sherlock Holmes","Run Time: 7:33:20 ","Sir Arthur Conan Doyle","Narrated by Eric Leach", false));
        bookItems.add(new AudioBooksOption("The Return of Sherlock Holmes","Run Time: 11:51:17 ","Sir Arthur Conan Doyle","Narrated by David Clarke", false));
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59 ","Sir Arthur Conan Doyle","Narrated by LibriVox Volunteers", false));

        //Creates a MenuAdapter which adapts an ArrayAdapter to contain a list of MenuOptions (1 ImageView, 1 TextView)
        AudioBookArrayAdapter bookMenu = new AudioBookArrayAdapter(this, bookItems);

        //Figure out how to make a list clickable
        l = (ListView) findViewById(R.id.list);
        l.setAdapter(bookMenu);

        Button home = (Button) findViewById(R.id.home_nav);
        home.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent homeActivity = new Intent(getBaseContext(), MainActivity.class);
                startActivity(homeActivity);
            }
        });

        Button current = (Button) findViewById(R.id.current_nav);
        current.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent currentActivity = new Intent(getBaseContext(), CurrentlyReadingActivity.class);
                startActivity(currentActivity);
            }
        });

        Button bookshelfButton = (Button) findViewById(R.id.shelf_nav);
        bookshelfButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bookshelfActivity = new Intent(getBaseContext(), BookshelfActivity.class);
                startActivity(bookshelfActivity);
            }
        });

        Button discover = (Button) findViewById(R.id.discover_nav);
        discover.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent discoverActivity = new Intent(getBaseContext(), DiscoverActivity.class);
                startActivity(discoverActivity);
            }
        });

    }


}
