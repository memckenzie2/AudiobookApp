package com.example.android.audiobookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class BookshelfActivity  extends AppCompatActivity  {
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);



        //Loads Current List of AudioBooksOption Available using the AudioBooksOption Class
        //Create a list with all menu option items
        ArrayList<AudioBooksOption> bookItems = new ArrayList<AudioBooksOption>();

        //Add book items to list
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59 ","Sir Arthur Conan Doyle","LibriVox Volunteers", true));
        bookItems.add(new AudioBooksOption("The Memoirs of Sherlock Holmes","Run Time: 7:33:20 ","Sir Arthur Conan Doyle","Narrated by Eric Leach",true));
        bookItems.add(new AudioBooksOption("The Return of Sherlock Holmes","Run Time: 11:51:17 ","Sir Arthur Conan Doyle","Narrated by David Clarke",true));


        //Creates a MenuAdapter which adapts an ArrayAdapter to contain a list of MenuOptions (1 ImageView, 1 TextView)
        AudioBookArrayAdapter bookMenu = new AudioBookArrayAdapter(this, MainActivity.getBookMenu());

        //Figure out how to make a list clickable
        l = (ListView) findViewById(R.id.list);
        l.setAdapter(bookMenu);
    }

    public void onClickPlay(View view){
        int position = l.getPositionForView((View) view.getParent());
        AudioBooksOption bookClicked = (AudioBooksOption) l.getItemAtPosition(position);
        AudioBooksOption book = new AudioBooksOption(bookClicked.getTitle(),bookClicked.getLength(),bookClicked.getAuthor(),bookClicked.getNarrator(), true);
        MainActivity.setCurrentBook(book);
        Intent reading = new Intent(getBaseContext(), CurrentlyReadingActivity.class);
        startActivity(reading);
    }
}
