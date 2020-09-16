public class heapSort extends searchingAlgos {

    public heapSort(Product[] unsortedList) {
        super(unsortedList);
    }

    @Override
    public Product[] sort() {
        double average=0.0;
        CSVReader reader=new CSVReader();
        Product[]avgArray=getUnsortedList();

        for(int i=0; i<10;i++) {
            Long start = System.currentTimeMillis();
            heapSortNoReturn(avgArray);
            Long end = System.currentTimeMillis();
            average+=(end-start);
            avgArray=reader.run(String.valueOf(getUnsortedList().length));
        }
        average=average/10;
        System.out.println("Average runtime: "+average+" ms");
        Product[] workArray =reader.run(String.valueOf(getUnsortedList().length));
        System.out.println(workArray[0].getStringUPC());
        Product[] sorted = heapSort(workArray);
        return sorted;
    }

    @Override
    public Product[] sortSorted() {
        double average=0.0;
        for(int i=0; i<100;i++) {
            Long start = System.currentTimeMillis();

            heapSort(getUnsortedList());
            Long end = System.currentTimeMillis();
            average+=(end-start);
        }
        average=average/100;
        System.out.println("Average runtime: "+average+" ms");
        Product[] workArray = getUnsortedList();
        Product[] sorted = heapSort(workArray);
        return sorted;
    }

    private void heapSortNoReturn(Product[] array) {
        int heapSize=array.length;
        buildMaxHeap(array, heapSize);
        for(int i=heapSize-1;i>0;i--){
            Product initialZeroValue=array[0];
            array[0]=array[i];
            array[i]=initialZeroValue;
            maxHeapify(array,0, i);
        }
    }

    private Product[] heapSort(Product[]array){
        int heapSize=array.length;
        buildMaxHeap(array, heapSize);
        for(int i=heapSize-1;i>0;i--){
            Product initialZeroValue=array[0];
            array[0]=array[i];
            array[i]=initialZeroValue;
            maxHeapify(array,0, i);
        }
        return array;

    }

    private void maxHeapify(Product[] array, int i, int heapsize) {
        int largest=i;
        int l=left(i);
        int r=right(i);
        if(l<heapsize&&(array[l].getUpc14Code()>array[largest].getUpc14Code())){
            largest=l;
        }
        if(r<heapsize&&(array[r].getUpc14Code()>array[largest].getUpc14Code())){
            largest=r;
        }
        if(largest!=i){
            Product initialIValue=array[i];
            array[i]=array[largest];
            array[largest]=initialIValue;
            maxHeapify(array, largest, heapsize);
        }
    }

    private int left(int i) { return ((2*i)+1); }

    private int right(int i) {return ((2*i)+2); }

    private void buildMaxHeap(Product[] array, int heapsize) {
        for (int i = ((heapsize/ 2)-1); i >=0; i--) {
            maxHeapify(array, i, heapsize);
        }
    }


}
