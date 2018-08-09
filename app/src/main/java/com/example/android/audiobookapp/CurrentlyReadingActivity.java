package com.example.android.audiobookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CurrentlyReadingActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currently_reading);

        AudioBooksOption book = MainActivity.getcurrentBook();
        TextView title = (TextView) findViewById(R.id.book_current);
        title.setText(book.getTitle());

        TextView author= (TextView) findViewById(R.id.author_current);
        author.setText(book.getNarrator());

        TextView narrator = (TextView) findViewById(R.id.narrator_current);
        narrator.setText(book.getAuthor());

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
