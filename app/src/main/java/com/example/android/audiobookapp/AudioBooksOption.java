package com.example.android.audiobookapp;

public class AudioBooksOption {
    //Defines the values associated with an audiobook - title, author, narrator, and book length in time
    private String title;
    private String length;
    private String author;
    private String narrator;

    //Boolean value for if a book is on the users bookshelf. True if it is, false if it is not.
    private Boolean addedToBookshelf;

    /**
     * Create a new AudioBooksOption object to display the text for the various value related to an audiobook
     *
     * @param
     * @param
     * @param
     * @param
     */

    public AudioBooksOption(String titl, String bookLength, String auth, String narrat, Boolean bookshelf){
        title = titl;
        length = bookLength;
        author = auth;
        narrator = narrat;
        addedToBookshelf = bookshelf;
    }

    /*Below are the "get" functions to retrieve the value for an audio.*/

    //Returns a boolean value for if a book is on the users bookshelf. True if it is, false if it is not.

    public String getAuthor() {
        return author;
    }

    public String getLength() {
        return length;
    }

    public String getNarrator() {
        return narrator;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getAddedtoBookshelf(){
        return addedToBookshelf;
    }

    public void setAddedToBookshelf(Boolean addedBookshelf) {
        this.addedToBookshelf = addedBookshelf;
    }
}
