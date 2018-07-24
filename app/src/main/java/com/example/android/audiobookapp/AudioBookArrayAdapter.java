package com.example.android.audiobookapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/* The AudioBookArrayAdapter was adapted from example of the WordAdapter.java file found in the Android Basic Nano Degree Miwok app.
The source code for that project can be found here: https://github.com/udacity/ud839_Miwok/tree/lesson-one/app/src/main/java/com/example/android/miwok
 */


public class AudioBookArrayAdapter extends ArrayAdapter<AudioBooksOption>{
    /**
     * Create a new {AudioBookArrayAdapter} object.
     *
     * @param context is the activity that the MenuArrayAdapter is bein created for/in.
     * @param audioBook is the list of audioBook list items to be displayed in the final list.
     */
    public AudioBookArrayAdapter(Context context, ArrayList<AudioBooksOption> audioBook) {
        super(context, 0, audioBook);
    }

    @Override
    public View getView(int audioBookPosition, View convertableView, ViewGroup parentView) {

        View audioBookView = convertableView;

        //Inflates a view if no view has been made or reuses current view if it has.
        //Check to see if view exists
        if (audioBookView == null) {
            //inflates view
            audioBookView = LayoutInflater.from(getContext()).inflate(
                    R.layout.option_list_item, parentView, false);
        }

        // Get the AudioBooksOption object for the given position in the menu list
        AudioBooksOption currentBookItem = getItem(audioBookPosition);

        // Find the TextView in the book_item.xml layout with the ID narrator.
        TextView narratorTextView = (TextView) audioBookView.findViewById(R.id.narrator);
        // Get the narrator text info and set is as the textView with ID narrator
       narratorTextView.setText(currentBookItem.getNarrator());

        // Find the TextView in the book_item.xml layout with the ID title.
        TextView titleTextView = (TextView) audioBookView.findViewById(R.id.bookTitle);
        // Get the title text info and set is as the textView with ID title
        titleTextView.setText(currentBookItem.getTitle());

        // Find the TextView in the book_item.xml layout with the ID author.
        TextView authorTextView = (TextView) audioBookView.findViewById(R.id.author);
        // Get the author text info and set is as the textView with ID author
        authorTextView.setText(currentBookItem.getAuthor());

        // Find the TextView in the book_item.xml layout with the ID length.
        TextView lengthTextView = (TextView) audioBookView.findViewById(R.id.length);
        // Get the length text info and set is as the textView with ID length
        lengthTextView.setText(currentBookItem.getLength());

        // Return the whole audiobook list item (containing 4 TextViews) so that it can be shown in
        // the ListView.
        return audioBookView;
    }
}
