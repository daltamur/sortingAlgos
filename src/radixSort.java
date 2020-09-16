public class radixSort extends searchingAlgos {
    public radixSort(Product[] unsortedList) {
        super(unsortedList);
    }

    @Override
    public Product[] sort() {
        double average=0.0;
        CSVReader reader=new CSVReader();
        Product[]avgArray=getUnsortedList();

        for(int i=0; i<10;i++) {
            Long start = System.currentTimeMillis();
            radixSort(avgArray);
            Long end = System.currentTimeMillis();
            average+=(end-start);
            avgArray=reader.run(String.valueOf(getUnsortedList().length));
        }
        average=average/10;
        System.out.println("Average runtime: "+average+" ms");
        Product[] workArray = getUnsortedList();
        Product[] sorted = radixSort(workArray);
        return sorted;
    }

    @Override
    public Product[] sortSorted() {
        double average=0.0;
        for(int i=0; i<10;i++) {
            Long start = System.currentTimeMillis();
            radixSort(getUnsortedList());
            Long end = System.currentTimeMillis();
            average+=(end-start);
        }
        average=average/10;
        System.out.println("Average runtime: "+average+" ms");
        Product[] workArray = getUnsortedList();
        Product[] sorted = radixSort(workArray);
        return sorted;
    }

    private Product[] radixSort(Product[] array){
        Integer[]key=new Integer[10];
        for(int i=13;i>=0;i--){
           array= collectionSort(i,array, key);
        }
        return array;
    }

    private Product[] collectionSort(int i, Product[] array, Integer[] key) {
        Product[]newSorted=new Product[array.length];
        for(int t=0;t<key.length;t++){
            key[t]=0;
        }
        for(int j=0;j<array.length;j++){
            int digitValue;
            char digit = array[j].getStringUPC().charAt(i);
            digitValue = Integer.parseInt(String.valueOf(digit));
            key[digitValue]=key[digitValue]+1;
        }

        for(int l=1;l<10;l++){
            key[l]=key[l]+key[l-1];
        }

        for(int f= array.length-1;f>=0;f--){
            int digitValue;
            char digit = array[f].getStringUPC().charAt(i);
            digitValue=Integer.parseInt(String.valueOf(digit));
            newSorted[key[digitValue]-1]=array[f];
            key[digitValue]=key[digitValue]-1;
        }
        return newSorted;
    }
}
