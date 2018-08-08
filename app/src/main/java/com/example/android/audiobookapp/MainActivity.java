package com.example.android.audiobookapp;

/* The implementation for the ListView, MenuAdapter, and ArrayAdapter were adapted from example of the WordAdapter.java file found in the Android Basic Nano Degree Miwok app.
The source code for that project can be found here: https://github.com/udacity/ud839_Miwok/tree/lesson-one/app/src/main/java/com/example/android/miwok
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<AudioBooksOption> bookItemsBookshelf;
    private static AudioBooksOption currentBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a list with all menu option items
        ArrayList<MenuOption> menuItems = new ArrayList<MenuOption>();

        //Find ID for image view for Currently Reading menu view
        int imgIdReading = getResources().getIdentifier("reading_from_pixabay", "drawable", getPackageName());
        menuItems.add(new MenuOption("Currently Reading", imgIdReading));

        //Find ID for image view for Bookshelf menu view
        int imgIdBookshelf = getResources().getIdentifier("small_stack_from_pixabay", "drawable", getPackageName());
        menuItems.add(new MenuOption("Bookshelf", imgIdBookshelf));

        //Find ID for image view for Discover menu view
        int imgIdDiscover = getResources().getIdentifier("book_w_lamp_from_pixabay", "drawable", getPackageName());
        menuItems.add(new MenuOption("Discover a Book", imgIdDiscover));

        //Creates a MenuAdapter which adapts an ArrayAdapter to contain a list of MenuOptions (1 ImageView, 1 TextView)
        MenuArrayAdapter adapterMenu = new MenuArrayAdapter(this, menuItems);


        //Figure out how to make a list clickable
        ListView l = (ListView) findViewById(R.id.menu_list);
        l.setAdapter(adapterMenu);


        //Loads Current List of AudioBooksOption on bookshelf using the AudioBooksOption Class
        //Create a list with all menu option items
        bookItemsBookshelf = new ArrayList<AudioBooksOption>();

        currentBook =  new AudioBooksOption("The Adventures of Sherlock Holmes","Run Time: 10:17:59 ","Sir Arthur Conan Doyle","LibriVox Volunteers", true);
        //Add book items to bookshelf list
        bookItemsBookshelf.add(currentBook);
        bookItemsBookshelf.add(new AudioBooksOption("The Memoirs of Sherlock Holmes","Run Time: 7:33:20 ","Sir Arthur Conan Doyle","Narrated by Eric Leach",true));



        //Creates a MenuAdapter which adapts an ArrayAdapter to contain a list of MenuOptions (1 ImageView, 1 TextView)
        AudioBookArrayAdapter bookMenu = new AudioBookArrayAdapter(this, bookItemsBookshelf);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> p, View view, int position, long id) {

                switch(position){
                    case 0:
                        Intent reading = new Intent(getBaseContext(), CurrentlyReadingActivity.class);
                        startActivity(reading);
                        break;
                    case 1:
                        Intent bookshelf = new Intent(getBaseContext(), BookshelfActivity.class);
                        startActivity(bookshelf);
                        break;
                    case 2:
                        Intent discover = new Intent(getBaseContext(), DiscoverActivity.class);
                        startActivity(discover);
                        break;
                    default:
                        break;

                }



            }
        });
    }

    public static ArrayList<AudioBooksOption> getBookMenu(){
        return bookItemsBookshelf;
    }

    public static void setBookMenu(AudioBooksOption book){
        bookItemsBookshelf.add(book);
    }

    public static AudioBooksOption getcurrentBook(){
        return currentBook;
    }

    public static void setCurrentBook(AudioBooksOption book1){
        currentBook = book1;
    }
}
