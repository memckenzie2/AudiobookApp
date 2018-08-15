package com.example.android.audiobookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DiscoverActivity extends AppCompatActivity {
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        //Loads Current List of AudioBooksOption Available using the AudioBooksOption Class
        //Create a list with all the aduiobooks available to the user listed, both those on the bookshelf already and those not.
        ArrayList<AudioBooksOption> bookItems = new ArrayList<AudioBooksOption>();

        //Generates a list of audiobook items for the user to "discover"
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes", "Run Time: 10:17:59 ", "Sir Arthur Conan Doyle", "LibriVox Volunteers", false));
        bookItems.add(new AudioBooksOption("The Memoirs of Sherlock Holmes", "Run Time: 7:33:20 ", "Sir Arthur Conan Doyle", "Narrated by Eric Leach", false));
        bookItems.add(new AudioBooksOption("The Return of Sherlock Holmes", "Run Time: 11:51:17 ", "Sir Arthur Conan Doyle", "Narrated by David Clarke", false));
        bookItems.add(new AudioBooksOption("The Tale of Earning a Udacity NanoDegree", "Run Time: 92:00:06 ", "M. McKenzie", "Narrated by Udacity Mentors", false));
        bookItems.add(new AudioBooksOption("Generic Audiobook 1", "Run Time: 12:00:06 ", "Spooky McGhost", "Narrated by Ghosts", false));
        bookItems.add(new AudioBooksOption("Generic Audiobook 1", "Run Time: 34:00:06 ", "Rainbow Star", "Narrated by Unicorns", false));

        /*Creates a MenuAdapter which adapts an ArrayAdapter to contain a list of AudiobookOptions (4 TextViews, 2 Buttons)
        using the bookItemsBookshelf ArrayList contian the user's current list of audiobooks.*/
        AudioBookArrayAdapter bookMenu = new AudioBookArrayAdapter(this, bookItems);

        //Sets the ListView in discover.xml to be the AudioBookArrayAdapter bookItems created above.
        l = findViewById(R.id.list);
        l.setAdapter(bookMenu);

        /*Create a set of navigation buttons to be used in lieu of an Action Bar so user can navigate between activities*/

        //Highlights the current activity in the navigation menu by setting it's background to white.
        Button discover = findViewById(R.id.discover_nav);
        discover.setTextColor(getResources().getColor(android.R.color.white));

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

        //Bookshelf button - launches the Bookshelf activity when clicked
        Button bookshelfButton = findViewById(R.id.shelf_nav);
        bookshelfButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bookshelfActivity = new Intent(getBaseContext(), BookshelfActivity.class);
                startActivity(bookshelfActivity);
            }
        });


    }


}
