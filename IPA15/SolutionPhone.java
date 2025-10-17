package IPA15;
import java.util.*;


class Phone{
    private int phoneId;
    private String os;
    private String brand;
    private int price;

    public Phone(int phoneId, String os, String brand, int price){
        this.phoneId = phoneId;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }
    public int getPhoneId(){
        return phoneId;
    }
    public String getOs(){
        return os;
    }
    public String getBrand(){
        return brand;
    }
    public int getPrice(){
        return price;
    }
}


public class SolutionPhone {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Phone[]arr = new Phone[4];
        for(int i =0; i<4; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            arr[i] = new Phone(a, b, c, d);
        }

        String val = sc.nextLine();
        String val2 = sc.nextLine();

        int res = findPriceForGivenBrand(arr, val);
        if(res>0){
            System.out.println(res);
        }else{
            System.out.println("The given Brand is not available");
        }


        Phone res2 = getPhoneIdBasedOnOs(arr, val2);
        if(res2!=null){
            System.out.println(res2.getPhoneId());
        }else{
            System.out.println("No phones are available with specified os and price range");
        }
    }


    public static int findPriceForGivenBrand(Phone[]arr,String val){
        int count =0; 
        for(int i =0; i<arr.length; i++){
            if(arr[i].getBrand().equalsIgnoreCase(val)){
                count+=arr[i].getPrice();
            }
        }
        return count;
    }

    public static Phone getPhoneIdBasedOnOs(Phone[]arr, String val2){
        Phone result = null;
        for(int i =0; i<arr.length; i++){
            if(arr[i].getOs().equalsIgnoreCase(val2) && arr[i].getPrice()>=50000){
                result = arr[i];
            }
        }
        return result;
    }
}
