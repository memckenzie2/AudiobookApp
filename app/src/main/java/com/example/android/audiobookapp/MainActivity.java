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

        l.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> p, View view, int position, long id) {

                if (position==0) {
                    Intent myIntent = new Intent(getBaseContext(), DiscoverActivity.class);
                    startActivity(myIntent);
                }
            }
        });


    }
}
