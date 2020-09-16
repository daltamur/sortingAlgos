public abstract class searchingAlgos {
    private Product[] unsortedList;

    public searchingAlgos(Product[] unsortedList){
        this.unsortedList=unsortedList;
    }

    public abstract Product[] sort();
    public abstract Product[] sortSorted();
    public Product[] getUnsortedList(){
        return unsortedList;
    }
}
