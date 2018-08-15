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
     * @param titl The title of the book being read
     * @param bookLength  The length in hh:mm:ss of the audiobook's run time
     * @param auth The name of the audiobook's uathor
     * @param narrat The name of the audiobook narrator
     * @param bookshelf True if on user's bookshelf, false if not
     */
    public AudioBooksOption(String titl, String bookLength, String auth, String narrat, Boolean bookshelf) {
        title = titl;
        length = bookLength;
        author = auth;
        narrator = narrat;
        addedToBookshelf = bookshelf;
    }

    /*Below are the "get" functions to retrieve the value for an audiobook item.*/

    //Returns a String containing the audiobook's author
    public String getAuthor() {
        return author;
    }

    //Returns a String containing the audiobook's length in hh:mm:ss format.
    public String getLength() {
        return length;
    }

    //Returns a String containing the audiobook's narrator
    public String getNarrator() {
        return narrator;
    }

    //Returns a String containing the audiobook's title
    public String getTitle() {
        return title;
    }


    //Returns a boolean value for if a book is on the users bookshelf. True if it is, false if it is not.
    public Boolean getAddedtoBookshelf() {
        return addedToBookshelf;
    }

    //Sets a boolean value for if a book is on the users bookshelf. True if it is, false if it is not.
    public void setAddedToBookshelf(Boolean addedBookshelf) {
        this.addedToBookshelf = addedBookshelf;
    }
}
