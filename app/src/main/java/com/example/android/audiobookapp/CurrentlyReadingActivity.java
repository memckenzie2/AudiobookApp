package com.example.android.audiobookapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    }
}
