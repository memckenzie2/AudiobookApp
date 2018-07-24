package com.example.android.audiobookapp;

public class MenuOption {
    private String optionTitle;
    private int optionImage;


    /**
     * Create a new MenuOption object to display an image and text combo on a menu.
     *
     * @param menuOpt is the text to display
     * @param imgOption is the int identifier for the image to display
     */
    public MenuOption(String menuOpt, int imgOption){
        optionTitle = menuOpt;
        optionImage = imgOption;
    }

    public int getOptionImage() {
        return optionImage;
    }

    public String getOptionTitle() {
        return optionTitle;
    }
}
