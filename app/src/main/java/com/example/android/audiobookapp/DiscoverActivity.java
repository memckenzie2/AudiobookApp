package com.example.android.audiobookapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class DiscoverActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        //Loads Current List of AudioBooksOption Available using the AudioBooksOption Class
        //Create a list with all menu option items
        ArrayList<AudioBooksOption> bookItems = new ArrayList<AudioBooksOption>();

        //Add book items to list
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59","Sir Arthur Conan Doyle","LibriVox Volunteers"));
        bookItems.add(new AudioBooksOption("The Memoirs of Sherlock Holmes","Run Time: 7:33:20","Sir Arthur Conan Doyle","Eric Leach"));
        bookItems.add(new AudioBooksOption("The Return of Sherlock Holmes","Run Time: 11:51:17","Sir Arthur Conan Doyle","David Clarke"));
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59","Sir Arthur Conan Doyle","LibriVox Volunteers"));
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59","Sir Arthur Conan Doyle","LibriVox Volunteers"));
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59","Sir Arthur Conan Doyle","LibriVox Volunteers"));
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59","Sir Arthur Conan Doyle","LibriVox Volunteers"));
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59","Sir Arthur Conan Doyle","LibriVox Volunteers"));
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59","Sir Arthur Conan Doyle","LibriVox Volunteers"));
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59","Sir Arthur Conan Doyle","LibriVox Volunteers"));
        bookItems.add(new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59","Sir Arthur Conan Doyle","LibriVox Volunteers"));
        //Creates a MenuAdapter which adapts an ArrayAdapter to contain a list of MenuOptions (1 ImageView, 1 TextView)
        AudioBookArrayAdapter bookMenu = new AudioBookArrayAdapter(this, bookItems);


    }
}
