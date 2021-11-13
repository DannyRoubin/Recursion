/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Recursion assignment

Purpose of this file/class is to perform both an iterative and a recursive search to perform a binary search
*/
public class BinarySearch extends SearchAlgorithm {

    // Overriding the iterativeSearch to match what is given in the driver
    @Override
    public int iterativeSearch(String[] ListOfWords, String target) throws ItemNotFoundException {
        // calling resetCount() to reset the count
        resetCount();
        // runs the iterative method named search
        return (Search(ListOfWords, target));
    }

    // allows us to iteratively search through a list of words in a binary fashion
    private int Search(String[] ListOfWords, String target) throws ItemNotFoundException {

        // checks to make sure that the array given is larger than 0
        if (ListOfWords.length <= 0) {
            throw new ItemNotFoundException("Please give an array larger than 0");
            // else we have a valid array and can move through it
        } else {

            // we know that the starting index has to be 0
            int left = 0;
            int mid;
            // we also know that the rightmost index has to be the length -1
            int right = ListOfWords.length - 1;

            // while we are still in bounds
            while (right >= left) {
                // we'll increment the count
                incrementCount();
                // we'll set the count = left and right /2 
                mid = ((left + right) / 2);

                // we're gonna check if we are on the left of the target word
                if (target.compareTo(ListOfWords[mid]) > 0) {
                    // if we are move the left over to the middle +1
                    left = mid + 1;

                    // next we're gonna check if we're on the right of the target word
                } else if (target.compareTo(ListOfWords[mid]) < 0) {
                    // if we are move the right over to the middle -1
                    right = mid - 1;

                    // otherwise check if the targetr and current word are equal
                } else if (ListOfWords[mid].equals(target)) {
                    return mid;
                }
            }
            // we only get here if the left and right have crossed over each other without finding the word
            throw new ItemNotFoundException("'" + target + "' not found");

        }
    }

    // Override of the recursiveSearch method to match what is given to us in the driver
    @Override
    public int recursiveSearch(String[] ListOfWords, String target) throws ItemNotFoundException {
        // we run reset count to reset the count to 0 prior to do anything else
        resetCount();
        // we then run private method recSearch
        return (recSearch(ListOfWords, target, 0, ListOfWords.length - 1));
    }

    // goes through and
    private int recSearch(String[] ListOfWords, String target, int left, int right) throws ItemNotFoundException {
        // checks to make sure that the array given is larger than 0
        if (ListOfWords.length <= 0) {
            throw new ItemNotFoundException("Please give an array larger than 0");
            // else we have a valid array and can move through it
        } else {
            // we increment the count after checking this is a valid array
            incrementCount();
            // we set the mid = to left + right/2
            int mid = ((left + right) / 2);

            // if the words are the same 
            if (ListOfWords[mid].equals(target)) {
                // then return mid
                return mid;
                // otherwise check if we are out of bounds
            } else if (left >= right) {
                throw new ItemNotFoundException("'" + target + "' not found");
                // if we are in bounds we will check if we're on the left of the target
            } else if (target.compareTo(ListOfWords[mid]) > 0) {
                // if we are then run the method again but replace the starting point with mid+1
                return recSearch(ListOfWords, target, mid + 1, right);
                // next we're going to check if were on the right side of the target
            } else if (target.compareTo(ListOfWords[mid]) < 0) {
                // if we are then  run the method again but replace the end point with mid -1
                return recSearch(ListOfWords, target, left, mid - 1);

            }
            // if we don't hit any of those if statements, then the target is not found
            throw new ItemNotFoundException("'" + target + "' not found");

        }
    }

}
