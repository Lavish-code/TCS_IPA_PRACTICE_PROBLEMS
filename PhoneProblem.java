import java.util.*;

class Phone {
    int phoneId;
    String os;
    String brand;
    int price;

    public Phone(int phoneId, String os, String brand, int price) {
        this.phoneId = phoneId;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }

    public int getPhoneId() { 
        return phoneId; 
    }
    
    public String getOs() { 
        return os; 
    }

    public String getBrand() { 
        return brand; 
    }

    public int getPrice() { 
        return price; 
    }
}

public class PhoneProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Phone[] arr = new Phone[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            arr[i] = new Phone(a, b, c, d);
        }
        
        String brand = sc.nextLine();
        String os = sc.nextLine();

        // First method call
        int sum = findpriceForGivenBrand(arr, brand);
        System.out.println(sum == 0 ? "The given Brand is not available" : sum);

        // Second method call
        Phone phone = getPhoneIdBasedOnOs(arr, os);
        System.out.println(phone == null ? 
            "No phones are available with specified os and price range" : 
            phone.phoneId);
    }

    public static int findpriceForGivenBrand(Phone[] arr, String brand) {
        int sum = 0;
        for (Phone p : arr) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                sum += p.getPrice();
            }
        }
        return sum;
    }

    public static Phone getPhoneIdBasedOnOs(Phone[] arr, String os) {
        for (Phone p : arr) {
            if (p.getOs().equalsIgnoreCase(os) && p.getPrice() >= 50000) {
                return p;
            }
        }
        return null;
    }
}