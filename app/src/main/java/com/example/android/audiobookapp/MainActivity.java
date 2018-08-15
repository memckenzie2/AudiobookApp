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
    //The items on the user's bookshelf (i.e. playlist). Declared static to allow it to be accessed across activities.
    private static ArrayList<AudioBooksOption> bookItemsBookshelf;

    //The details for the audiobook currently playing when the Currently Reading activity loads (i.e. now playing). Declared static to allow it to be accessed across activities.
    private static AudioBooksOption currentBook;

    /*
    Returns the current ArrayList of audiobooks on the users bookshelf (i.e. playlist)
    */
    public static ArrayList<AudioBooksOption> getBookMenu() {
        return bookItemsBookshelf;
    }

    /*
    @param AudioBooksOption book is an audiobook to be added to the bookshelf
     Adds a new audiobook to the users bookshelf (i.e. playlist)
    */
    public static void setBookMenu(AudioBooksOption book) {
        bookItemsBookshelf.add(book);
    }

    /*
   Returns the current audiobook that the user is listening to on the Currently Reading screen.
   */
    public static AudioBooksOption getcurrentBook() {
        return currentBook;
    }

    /*
    @param AudioBooksOption book is an audiobook to be loaded into Currently Reading (i.e. now playing)
     Adds a new audiobook to the users Currently Playing activity
    */
    public static void setCurrentBook(AudioBooksOption book1) {
        currentBook = book1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a list to store all the menu option items for navigating around app
        ArrayList<MenuOption> menuItems = new ArrayList<MenuOption>();

        //Find ID for image view for Currently Reading menu view and create a new menu option for it
        int imgIdReading = getResources().getIdentifier("reading_from_pixabay", "drawable", getPackageName());
        menuItems.add(new MenuOption("Currently Reading", imgIdReading));

        //Find ID for image view for Bookshelf menu view and create a new menu option for it
        int imgIdBookshelf = getResources().getIdentifier("small_stack_from_pixabay", "drawable", getPackageName());
        menuItems.add(new MenuOption("Bookshelf", imgIdBookshelf));

        //Find ID for image view for Discover menu view and create a new menu option for it
        int imgIdDiscover = getResources().getIdentifier("book_w_lamp_from_pixabay", "drawable", getPackageName());
        menuItems.add(new MenuOption("Discover a Book", imgIdDiscover));

        //Creates a MenuAdapter which adapts an ArrayAdapter to contain a list of MenuOptions (1 ImageView, 1 TextView per option)
        MenuArrayAdapter adapterMenu = new MenuArrayAdapter(this, menuItems);

        //Loads the adapterMenu with the navigation menu options into the ListView in activity_main.xml on the frontend
        ListView l = findViewById(R.id.menu_list);
        l.setAdapter(adapterMenu);


        /* Initialize Bookshelf and Currently Reading audiobooks*/

        //Creates and ArrayList with the Current List of AudioBooksOption on bookshelf using the AudioBooksOption Class
        bookItemsBookshelf = new ArrayList<AudioBooksOption>();

        /*Creates an audiobook with all parameters (title,  audiobook play length, author, narrator, and a variable to determine if the item is already on the bookshelf).
        Add the item to the user's Bookshelf AND to the Currently Reading Activity
         */
        AudioBooksOption defaultBook = new AudioBooksOption("The Adventures of Sherlock Holmes", "Run Time: 10:17:59 ", "Sir Arthur Conan Doyle", "LibriVox Volunteers", true);
        //Add book items to bookshelf list
        setBookMenu(defaultBook);
        setCurrentBook(defaultBook);

        /*Create a listener for the Listview l with all the navigation menu options
        3 Options - Currently Reading (i.e. Now Playing, Bookshelf (i.e. Playlist), or Discover (Find New Audiobooks)*/
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> p, View view, int position, long id) {

                switch (position) {

                    //Launch the Currently Reading Activity
                    case 0:
                        Intent reading = new Intent(getBaseContext(), CurrentlyReadingActivity.class);
                        startActivity(reading);
                        break;

                    //Launch the Bookshelf Activity
                    case 1:
                        Intent bookshelf = new Intent(getBaseContext(), BookshelfActivity.class);
                        startActivity(bookshelf);
                        break;

                    //Launch the Discover Activity
                    case 2:
                        Intent discover = new Intent(getBaseContext(), DiscoverActivity.class);
                        startActivity(discover);
                        break;
                    //Any other selection, do nothing.
                    default:
                        break;

                }
            }
        });
    }
}
