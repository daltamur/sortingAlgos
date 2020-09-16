import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String [] args) throws IOException {
        firstChoice();

    }

    private static void firstChoice() throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("How do you want to sort the list? CHOOSE: Quicksort, Heapsort, Radixsort, or Exit");
        String firstChoice=scanner.next();
        sortChoice(firstChoice);
        if(firstChoice.equalsIgnoreCase("Exit")){
            System.out.println("Thank you for using this sorter.");
        }
    }


    private static void sortChoice(String firstChoice) throws IOException {
        CSVReader reader=new CSVReader();
        System.out.println("How large do you want the array to be? WRITE: Full, Half, Quarter, or the integer amount you want the size to be.");
        Scanner scanner=new Scanner(System.in);
        String size=scanner.next();
        Product[]unsortedArray=reader.run(size);
        if(firstChoice.equalsIgnoreCase("Quicksort")){
            quickSort qs=new quickSort(unsortedArray);
            System.out.println("Unsorted array: ");
            unsortedArray=qs.sort();
            sortedQuickSort(unsortedArray);
        }else if(firstChoice.equalsIgnoreCase("Heapsort")){
            heapSort hs=new heapSort(unsortedArray);
            System.out.println("Unsorted array: ");
            unsortedArray=hs.sort();
            sortedHeapSort(unsortedArray);
        }else if(firstChoice.equalsIgnoreCase("Radixsort")){
            radixSort rs=new radixSort(unsortedArray);
            System.out.println("Unsorted array: ");
            unsortedArray=rs.sort();
            sortedRadixSort(unsortedArray);
        }
    }

    private static void sortedRadixSort(Product[] unsortedArray) throws IOException {
        Scanner scanner=new Scanner(System.in);
        radixSort rs=new radixSort(unsortedArray);
        System.out.println("Sort the already sorted list?");
        String choice=scanner.next();
        if(choice.equalsIgnoreCase("yes")){
            System.out.println("Sorted Array: ");
            unsortedArray=rs.sortSorted();
            printRadixSort(unsortedArray);
        }else if(choice.equalsIgnoreCase("no")){
            printRadixSort(unsortedArray);
        }
    }

    private static void sortedHeapSort(Product[] unsortedArray) throws IOException {
        Scanner scanner=new Scanner(System.in);
        heapSort rs=new heapSort(unsortedArray);
        System.out.println("Sort the already sorted list?");
        String choice=scanner.next();
        if(choice.equalsIgnoreCase("yes")){
            System.out.println("Sorted Array: ");
            rs.sortSorted();
            printHeapSort(unsortedArray);
        }else if(choice.equalsIgnoreCase("no")){
            printHeapSort(unsortedArray);
        }
    }

    private static void sortedQuickSort(Product[] unsortedArray) throws IOException {
        Scanner scanner=new Scanner(System.in);
        quickSort rs=new quickSort(unsortedArray);
        System.out.println("Sort the already sorted list?");
        String choice=scanner.next();
        if(choice.equalsIgnoreCase("yes")){
            System.out.println("Sorted Array: ");
            rs.sortSorted();
            printQuickSort(unsortedArray);
        }else if(choice.equalsIgnoreCase("no")){
            printQuickSort(unsortedArray);
        }
    }

    private static void printQuickSort(Product[] unsortedArray) throws IOException {
        System.out.println("Do you want the sorted array saved? CHOOSE: Yes or No");
        Scanner scanner=new Scanner(System.in);
        String choice=scanner.next();
        if(choice.equalsIgnoreCase("yes")){
           CSVReader reader=new CSVReader();
           reader.writequicksort(unsortedArray);
            firstChoice();
        }else if(choice.equalsIgnoreCase("no")){
            firstChoice();

        }
    }

    private static void printRadixSort(Product[] unsortedArray) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Do you want the sorted array saved? CHOOSE: Yes or No");
        String choice=scanner.next();
        if(choice.equalsIgnoreCase("yes")){
            CSVReader reader=new CSVReader();
            reader.writeradixsort(unsortedArray);
            firstChoice();
        }else if(choice.equalsIgnoreCase("no")){
            firstChoice();

        }
    }

    private static void printHeapSort(Product[] unsortedArray) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Do you want the sorted array saved? CHOOSE: Yes or No");
        String choice=scanner.next();
        if(choice.equalsIgnoreCase("yes")){
            CSVReader reader=new CSVReader();
            reader.writeheapsort(unsortedArray);
            firstChoice();
        }else if(choice.equalsIgnoreCase("no")){
            firstChoice();

        }
    }
}
