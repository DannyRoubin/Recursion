/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Recursion assignment

Purpose of this file/class is to be a custom Exception that is thrown if an item was not found
*/
public class ItemNotFoundException extends Exception {
    // empty constructor since I don't want it to do anything
    public ItemNotFoundException() {
    }

    // constructor that takes in the message
    public ItemNotFoundException(String errorMsg) {
        // looks to the super constructor in the Exception class and passes the error message over there to deal with
        super(errorMsg);

    }

}
