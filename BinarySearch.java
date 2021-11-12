public class BinarySearch extends SearchAlgorithm {

    @Override
    public int iterativeSearch(String[] ListOfWords, String target) throws ItemNotFoundException {
        resetCount();
        return (Search(ListOfWords, target));
    }

    private int Search(String[] ListOfWords, String target) throws ItemNotFoundException {
        int left = 0;
        int mid;
        int right = ListOfWords.length - 1;

        while (right >= left) {
            incrementCount();
            mid = ((left + right) / 2);

            if (target.compareTo(ListOfWords[mid]) > 0) {
                left = mid + 1;

            } else if (target.compareTo(ListOfWords[mid]) < 0) {
                right = mid - 1;

            } else if (ListOfWords[mid].equals(target)) {
                return mid;
            }
        }
        throw new ItemNotFoundException("The item was not found");

    }

    @Override
    public int recursiveSearch(String[] ListOfWords, String target) throws ItemNotFoundException {
        // TODO Auto-generated method stub
        resetCount();
        return (recSearch(ListOfWords, target, 0, ListOfWords.length - 1 ));
    }

    private int recSearch(String[] ListOfWords, String target, int left, int right) throws ItemNotFoundException {
        incrementCount();
        int mid = ((left + right)/2);
        

    }

}