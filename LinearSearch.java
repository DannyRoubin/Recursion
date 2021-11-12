/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Recursion assignment

Purpose of this file/class is to perform 
*/
public class LinearSearch extends SearchAlgorithm {

    @Override
    public int iterativeSearch(String[] ListOfWords, String target) throws ItemNotFoundException {
        resetCount();
        return (Search(ListOfWords, target));
    }

    private int Search(String[] ListOfWords, String target) throws ItemNotFoundException {
        if (ListOfWords.length <= 0) {
            throw new ItemNotFoundException("Please give an array larger than 0");
        } else {

            for (int i = 0; i < ListOfWords.length; i++) {
                incrementCount();

                if (ListOfWords[i].equals(target)) {
                    return i;
                }
            }
            throw new ItemNotFoundException("'" + target + "' not found");
        }
    }

    @Override
    public int recursiveSearch(String[] ListOfWords, String target) throws ItemNotFoundException {
        // TODO Auto-generated method stub
        resetCount();
        return (recSearch(ListOfWords, target, 0));
    }

    private int recSearch(String[] ListOfWords, String target, int index) throws ItemNotFoundException {
        if (ListOfWords.length == index) {
            throw new ItemNotFoundException("End of file reached, word not found");
        } else if (ListOfWords[index].equals(target)) {
            return index;
        } else {
            incrementCount();
            return recSearch(ListOfWords, target, index+1);

        }

    }

}
