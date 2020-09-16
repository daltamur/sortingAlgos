public class Product {
    private Long upc14Code;
    private String productName;
    private String stringUPC;

    public Product(Long upc14Code, String productName, String stringUPC){
        this.upc14Code=upc14Code;
        this.productName=productName;
        this.stringUPC=stringUPC;
    }

    public Long getUpc14Code(){
        return upc14Code;
    }

    public String getProductName(){
        return productName;
    }
    public String getStringUPC(){
        return stringUPC;
    }

}
