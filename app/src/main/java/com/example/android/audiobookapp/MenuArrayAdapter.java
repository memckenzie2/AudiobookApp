package com.example.android.audiobookapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/* The MenuAdapter was adapted from example of the WordAdapter.java file found in the Android Basic Nano Degree Miwok app.
The source code for that project can be found here: https://github.com/udacity/ud839_Miwok/tree/lesson-one/app/src/main/java/com/example/android/miwok
 */

public class MenuArrayAdapter extends ArrayAdapter<MenuOption> {
    /**
     * Create a new {MenuArrayAdapter} object.
     *
     * @param context is the activity that the MenuArrayAdapter is bein created for/in.
     * @param menuOpt is the list of menu option items to be displayed in the final list.
     */
    public MenuArrayAdapter(Context context, ArrayList<MenuOption> menuOpt) {
        super(context, 0, menuOpt);
    }

    @Override
    public View getView(int menuPosition, View convertableView, ViewGroup parentView) {

        View menuItemView = convertableView;

        //Inflates a view if no view has been made or reuses current view if it has.
        //Check to see if view exists
        if (menuItemView == null) {
            //inflates view
            menuItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.option_list_item, parentView, false);
        }

        // Get the menuOption object for the given position in the menu list
        MenuOption currentMenuItem = getItem(menuPosition);

        // Find the TextView in the option_list_item.xml layout with the ID menu_text_view.
        TextView menuTextView = menuItemView.findViewById(R.id.menu_text_view);
        // Get the menu option text and set is as the textView with ID menu_text_view
        menuTextView.setText(currentMenuItem.getOptionTitle());

        // Find the ImageView in the option_list_item.xml layout with the ID menu_image_view.
        ImageView menuImageView = menuItemView.findViewById(R.id.menu_image_view);

        // Get the menu option image using the resource ID int  and set is as the imageView with ID menu_image_view
        menuImageView.setImageResource(currentMenuItem.getOptionImage());

        // Return the whole option list item (containing 1 TextView and 1 image) so that it can be shown in
        // the ListView.
        return menuItemView;
    }
}
