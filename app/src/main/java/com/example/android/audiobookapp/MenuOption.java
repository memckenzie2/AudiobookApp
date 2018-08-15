package com.example.android.audiobookapp;

public class MenuOption {

    //Variables to content the elements of a navigation menu item (menu option and menu option's image)
    private String optionTitle;
    private int optionImage;


    /**
     * Create a new MenuOption object to display an image and text combo on a menu.
     *
     * @param menuOpt   is the text to display for the navigation menu
     * @param imgOption is the int identifier for the image to display
     */
    public MenuOption(String menuOpt, int imgOption) {
        optionTitle = menuOpt;
        optionImage = imgOption;
    }

    //Returns the navigation menu item's text
    public int getOptionImage() {
        return optionImage;
    }

    //Returns the navigation menu item's image
    public String getOptionTitle() {
        return optionTitle;
    }
}
