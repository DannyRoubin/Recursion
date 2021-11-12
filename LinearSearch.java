/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Recursion assignment

Purpose of this file/class is to perform 
*/
public class LinearSearch extends SearchAlgorithm {

    // overrides the iterativeSearch method to match what is being given on the driver
    @Override
    public int iterativeSearch(String[] ListOfWords, String target) throws ItemNotFoundException {
        // resets the count so the count is up to date
        resetCount();
        // runs a private method search to find the index of the word
        return (Search(ListOfWords, target));
    }

    // private method that searches through the array and finds out if the target word matches the word at the current index
    private int Search(String[] ListOfWords, String target) throws ItemNotFoundException {
        // if the array length is less than or = to 0, throw an error
        if (ListOfWords.length <= 0) {
            throw new ItemNotFoundException("Please give an array larger than 0");
            // else we have a valid array and can move through it
        } else {
            // for loop to go through each index of the array 
            for (int i = 0; i < ListOfWords.length; i++) {
                // each loop through we wanna increment the count
                incrementCount();

                // if the target word is the same as the current word in the index
                if (ListOfWords[i].equals(target)) {
                    // return the index at which the word was found
                    return i;
                }
            }
            // we hit this itemNotFoundException if we have gone through the entire for loop without hitting the target word
            throw new ItemNotFoundException("Target word not found");
        }
    }

    // Override of the recursiveSearch to make it match what is given in the driver
    @Override
    public int recursiveSearch(String[] ListOfWords, String target) throws ItemNotFoundException {
        // reset the count so we get an accurate count for the comparison
        resetCount();
        // runs my private method recSearch
        return (recSearch(ListOfWords, target, 0));
    }

    // method that attempts to recursively search through the array of words
    private int recSearch(String[] ListOfWords, String target, int index) throws ItemNotFoundException {
        // checks to see if i hit the end of the file
        if (ListOfWords.length <= index) {
            // if we hit the end were going to throw an exception
            throw new ItemNotFoundException("End of file reached, word not found");
            // otherwise, lets check if we have a match
        } else if (ListOfWords[index].equals(target)) {
            // if we do return the index
            return index;
        } else {
            // otherwise, increment the count and run it again but increase the index by 1
            incrementCount();
            return recSearch(ListOfWords, target, index++);

        }

    }

}
