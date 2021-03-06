package com.example.android.audiobookapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/* The AudioBookArrayAdapter was adapted from example of the WordAdapter.java file found in the Android Basic Nano Degree Miwok app.
The source code for that project can be found here: https://github.com/udacity/ud839_Miwok/tree/lesson-one/app/src/main/java/com/example/android/miwok
 */


public class AudioBookArrayAdapter extends ArrayAdapter<AudioBooksOption> {
    /**
     * Create a new {AudioBookArrayAdapter} object.
     *
     * @param context   is the activity that the MenuArrayAdapter is bein created for/in.
     * @param audioBook is the list of audioBook list items to be displayed in the final list.
     */
    public AudioBookArrayAdapter(Context context, ArrayList<AudioBooksOption> audioBook) {
        super(context, 0, audioBook);
    }

    @Override
    public View getView(final int audioBookPosition, View convertableView, ViewGroup parentView) {

        View audioBookView = convertableView;

        //Inflates a view if no view has been made or reuses current view if it has.
        //Check to see if view exists
        if (audioBookView == null) {
            //inflates view
            audioBookView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_item, parentView, false);
        }

        // Get the AudioBooksOption object for the given position in the menu list
        final AudioBooksOption currentBookItem = getItem(audioBookPosition);

        // Find the TextView in the book_item.xml layout with the ID narrator.
        TextView narratorTextView = audioBookView.findViewById(R.id.narrator);
        // Get the narrator text info and set is as the textView with ID narrator
        narratorTextView.setText(currentBookItem.getNarrator());

        // Find the TextView in the book_item.xml layout with the ID title.
        TextView titleTextView = audioBookView.findViewById(R.id.book_current);
        // Get the title text info and set is as the textView with ID title
        titleTextView.setText(currentBookItem.getTitle());

        // Find the TextView in the book_item.xml layout with the ID author.
        TextView authorTextView = audioBookView.findViewById(R.id.author);
        // Get the author text info and set is as the textView with ID author
        authorTextView.setText(currentBookItem.getAuthor());

        // Find the TextView in the book_item.xml layout with the ID length.
        TextView lengthTextView = audioBookView.findViewById(R.id.length);
        // Get the length text info and set is as the textView with ID length
        lengthTextView.setText(currentBookItem.getLength());


        //If the item is marked as being on the bookshelf, don't display an add to bookshelf button
        if (currentBookItem.getAddedtoBookshelf() == true) {
            //Hide all the add to bookshelf buttons
            Button addButton = audioBookView.findViewById(R.id.add_bookshelf);
            addButton.setVisibility(View.GONE);
        }

        //The "play" button that should launch the Currently Listening activity using the selected audiobook's data
        Button play = audioBookView.findViewById(R.id.play);

        //Set a listener that loads the selected audiobook's data in into MainActivity.currentlyReading and launches the Currently Reading activity.
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.setCurrentBook(currentBookItem);
                Intent reading = new Intent(getContext(), CurrentlyReadingActivity.class);
                reading.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(reading);
            }

        });


        //The "Add to Booksheld" button that when clicked adds the currently selected audiobook's data into the ArrayList containing all audiobooks on the user's Bookshelf
        Button bookshelf = audioBookView.findViewById(R.id.add_bookshelf);

        //Set a listener that loads the selected audiobook's data in into MainActivity.bookItemsBookshelf and marks the book as added to the booksehlf by changing the addedToBookshelf parameter to true
        bookshelf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                currentBookItem.setAddedToBookshelf(true);
                MainActivity.setBookMenu(currentBookItem);
            }

        });

        // Return the whole audiobook list item (containing 4 TextViews and two buttons (with one set non-visible) so that it can be shown in
        // the ListView.
        return audioBookView;
    }


}
