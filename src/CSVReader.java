import java.io.*;
import java.util.ArrayList;

public class CSVReader {
        String path;
        String line;
        Product[]UPCCodeArray;

        CSVReader(){
            path="/Users/theif/Downloads/Grocery_UPC_Database.csv";
            line="";
        }

        public Product[] run(String size){
        try {
            BufferedReader br=bufferedReader(path);
            ArrayList<Long>UPCCodes=new ArrayList<>();
            ArrayList<String>productNames=new ArrayList<>();
            ArrayList<String>UPCCodesString=new ArrayList<>();
            while ((line=br.readLine())!=null) {
                if (!(line.equals("grp_id,upc14,upc12,brand,name"))) {
                    String[] stringValues = line.split(",");
                    if (stringValues.length == 5) {
                        UPCCodes.add(Long.parseLong(stringValues[1]));
                        productNames.add(stringValues[4]);
                        UPCCodesString.add(stringValues[1]);
                    } else {
                        UPCCodes.add(Long.parseLong(stringValues[1]));
                        UPCCodesString.add(stringValues[1]);
                        for (int i = 3; i < stringValues.length; i++) {
                                if (stringValues[i].startsWith("\"")&&i==3) {
                                    for (int x = i; x < stringValues.length; x++) {
                                        if (stringValues[x].endsWith("\"")) {
                                            int y=x+1;
                                            productNames.add(getName(y, stringValues));
                                            x = 100;
                                        }
                                    }
                                    i=100;
                                } else if (stringValues[i].startsWith("\"")&&i==4){
                                productNames.add(getNameFourLength(i, stringValues));
                                i=100;
                            }

                        }
                    }
                }

                if (line.equals("grp_id,upc14,upc12,brand,name")) {

                }
            }
        if(size.equalsIgnoreCase("full")) {
             UPCCodeArray = new Product[UPCCodes.size()];//UPCCodes.size
             for (int i = 0; i < UPCCodeArray.length; i++) {//UPCCodeArray.length
                Product product = new Product(UPCCodes.get(i), productNames.get(i), UPCCodesString.get(i));
                UPCCodeArray[i] = product;
              }
        }else if(size.equalsIgnoreCase("half")){
            UPCCodeArray = new Product[UPCCodes.size()/2];//UPCCodes.size
            for (int i = 0; i < UPCCodeArray.length; i++) {//UPCCodeArray.length
                Product product = new Product(UPCCodes.get(i), productNames.get(i), UPCCodesString.get(i));
                UPCCodeArray[i] = product;
            }

        }else if(size.equalsIgnoreCase("quarter")){
            UPCCodeArray = new Product[UPCCodes.size()/4];//UPCCodes.size
            for (int i = 0; i < UPCCodeArray.length; i++) {//UPCCodeArray.length
                Product product = new Product(UPCCodes.get(i), productNames.get(i), UPCCodesString.get(i));
                UPCCodeArray[i] = product;
            }
        }else{
            int size1=Integer.parseInt(size);
            UPCCodeArray = new Product[size1];//UPCCodes.size
            for (int i = 0; i < UPCCodeArray.length; i++) {//UPCCodeArray.length
                Product product = new Product(UPCCodes.get(i), productNames.get(i), UPCCodesString.get(i));
                UPCCodeArray[i] = product;
            }
        }
            return UPCCodeArray;



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
return UPCCodeArray;
        }

    private String getNameFourLength(int i, String[] stringValues) {
            String beginning;
            if(i==stringValues.length-1){
                beginning=stringValues[i];
            }
            else{
                beginning=stringValues[i]+",";
                for(int x=i+1;i<stringValues.length;i++){
                    if(x!=stringValues.length) {
                        String addition = stringValues[x] + ",";
                        beginning = beginning.concat(addition);
                    }else{
                        String addition=stringValues[x];
                        beginning=beginning.concat(addition);
                    }
                }
            }
            return beginning;
    }

    private String getName(int y, String[] stringValues) {
            String beginning=stringValues[y]+",";
            for(int z=y+1;z<stringValues.length;z++){
                if(z!=stringValues.length-1) {
                    String addition = stringValues[z] + ",";
                    beginning = beginning.concat(addition);
                }else{
                    String addition=stringValues[z];
                    beginning=beginning.concat(addition);
                }

            }
            return beginning;
    }

    public void writeheapsort (Product[] sortedArray) throws IOException {
            BufferedWriter outputWriter = null;
            outputWriter = new BufferedWriter(new FileWriter("/Users/theif/outputCSV/outpuths.txt"));
            outputWriter.write("Product Name,UPC14 Code");// Here I know i cant just write x[0] or anything. Do i need
            outputWriter.newLine();
            for(int i=0;i<sortedArray.length;i++){
                Product x=sortedArray[i];
                outputWriter.write(x.getProductName()+","+x.getStringUPC());
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
        }

    public void writeradixsort (Product[] sortedArray) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("/Users/theif/outputCSV/outputrs.txt"));
        outputWriter.write("Product Name,UPC14 Code");// Here I know i cant just write x[0] or anything. Do i need
        outputWriter.newLine();
        for(int i=0;i<sortedArray.length;i++){
            Product x=sortedArray[i];
            outputWriter.write(x.getProductName()+","+x.getStringUPC());
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }

    public void writequicksort (Product[] sortedArray) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("/Users/theif/outputCSV/outputqs.txt"));
        outputWriter.write("Product Name,UPC14 Code");// Here I know i cant just write x[0] or anything. Do i need
        outputWriter.newLine();
        for(int i=0;i<sortedArray.length;i++){//sorted array.length
            Product x=sortedArray[i];
            outputWriter.write(x.getProductName()+","+x.getStringUPC());
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }


    private static BufferedReader  bufferedReader(String path) throws FileNotFoundException {
            BufferedReader br=new BufferedReader(new FileReader(path));
            return br;
    }
}
