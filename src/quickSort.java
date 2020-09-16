import java.util.Random;

public class quickSort extends searchingAlgos{
    public quickSort(Product[] unsortedList) {
        super(unsortedList);
    }

    @Override
    public Product[] sort() {
        double average=0.0;
        CSVReader reader=new CSVReader();
        Product[]avgArray=getUnsortedList();
        for(int i=0; i<10;i++) {
            Long start = System.currentTimeMillis();
            quickSort(avgArray, 0, avgArray.length - 1);
            Long end = System.currentTimeMillis();
            average+=(end-start);
            avgArray=reader.run(String.valueOf(getUnsortedList().length));
        }
        average=average/10;
        System.out.println("Average runtime: "+average+" ms");
        Product[] workArray =reader.run(String.valueOf(getUnsortedList().length));
        Product[] sorted = quickSort(workArray, 0, avgArray.length - 1);
        return sorted;
    }

    @Override
    public Product[] sortSorted() {
        double average=0.0;
        for(int i=0; i<10;i++) {
            Long start = System.currentTimeMillis();
            quickSort(getUnsortedList(), 0, getUnsortedList().length - 1);
            Long end = System.currentTimeMillis();
            average+=(end-start);
        }
        average=average/10;
        System.out.println("Average runtime: "+average+" ms");
        Product[] workArray = getUnsortedList();
        Product[] sorted = quickSort(getUnsortedList(), 0, getUnsortedList().length - 1);
        return sorted;
    }

    private Product[] quickSort(Product[] array, int initialIndex, int endIndex){
        if(initialIndex<endIndex){
            int newBound=partition(array, initialIndex, endIndex);
            quickSort(array, initialIndex, newBound-1);
            quickSort(array,newBound+1,endIndex);
        }
        return array;

    }

    private int partition(Product[] array, int initialIndex, int endIndex) {
        random(array, initialIndex, endIndex);
        Product x=array[endIndex];
        int i=initialIndex-1;
        for(int j=initialIndex;j<endIndex;j++){
            if(array[j].getUpc14Code()<=x.getUpc14Code()){
                i++;
                Product initialI=array[i];
                array[i]=array[j];
                array[j]=initialI;
            }
        }
        Product initialIPlusOne=array[i+1];
        array[i+1]=array[endIndex];
        array[endIndex]=initialIPlusOne;
        return i+1;

    }

    private void random(Product[] array, int initialIndex, int endIndex) {
        Random random=new Random();
        Product initialendValue=array[endIndex];
        int end=endIndex-initialIndex;
        int randomInt=random.nextInt(end);
        int randomPivot=initialIndex+randomInt;
        array[endIndex]=array[randomPivot];
        array[randomPivot]=initialendValue;
     }

}
