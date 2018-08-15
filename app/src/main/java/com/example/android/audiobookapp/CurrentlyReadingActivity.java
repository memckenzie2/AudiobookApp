package com.example.android.audiobookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CurrentlyReadingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currently_reading);

        //Takes the data from MainActivity.currentBook and uses it to fill the textviews to display the audiobook's information
        AudioBooksOption book = MainActivity.getcurrentBook();

        //Get the title TextView, title's string and set the title textview to it's string
        TextView title = findViewById(R.id.book_current);
        title.setText(book.getTitle());

        //Get the title TextView, title's string and set the title textview to it's string
        TextView author = findViewById(R.id.author_current);
        author.setText(book.getAuthor());

        //Get the narrator's TextView, narrator's string and set the narrator's textview to it's string
        TextView narrator = findViewById(R.id.narrator_current);
        narrator.setText(book.getNarrator());


        /*Create a set of navigation buttons to be used in lieu of an Action Bar so user can navigate between activities*/

        //Highlights the current activity in the navigation menu by setting it's background to white.
        Button current = findViewById(R.id.current_nav);
        current.setTextColor(getResources().getColor(android.R.color.white));

        //Home button - launches the MainActivity when clicked
        Button home = findViewById(R.id.home_nav);
        home.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent homeActivity = new Intent(getBaseContext(), MainActivity.class);
                startActivity(homeActivity);
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
