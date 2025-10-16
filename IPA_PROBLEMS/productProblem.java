import java.util.*;

class Product{
    private int id;
    private String name;
    private int availability;
     private double price;

    public Product(int id, String name, int availability , double price){
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public int getAvailability(){
        return availability;
    }

    public double getPrice(){
        return price;
    }
}



public class productProblem {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Product[]arr = new Product[n];
        for(int i =0; i<n; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            double d = sc.nextDouble();
            arr[i] = new Product(a, b, c, d);
        }

        double ans1 = averagePriceOfAvailability(arr);
        if(ans1!=0){
            System.out.println(ans1);
        }else{
            System.out.println("No available product found");
        }

    }

    public static double averagePriceOfAvailability(Product[]arr ){
        double average =0;
        double count=0;
        for(int i =0; i<arr.length;i++){
            if(arr[i].getAvailability()>0){
                average+=arr[i].getPrice();
                count++;
            }
        }
        return average/count;
    }

    public static Product findTheProduct(Prodcut[]arr , ){
        return null;
    }
}
