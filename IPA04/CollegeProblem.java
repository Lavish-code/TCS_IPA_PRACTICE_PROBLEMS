package IPA4;

import java.util.*;

class College {
    private int Id;
    private String name;
    private int ContactNo;
    private String address;
    private int pinCode;

    public College(int Id, String name, int ContactNo, String address, int pinCode) {
        this.Id = Id;
        this.name = name;
        this.ContactNo = ContactNo;
        this.address = address;
        this.pinCode = pinCode;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getContactNo() {
        return ContactNo;
    }

    public String getAddress() {
        return address;
    }

    public int getPincode() {
        return pinCode;
    }
}

public class CollegeProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        College[] arr = new College[n];
        for (int i = 0; i < arr.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            String d = sc.nextLine();
            int e = sc.nextInt();
            sc.nextLine();
            arr[i] = new College(a, b, c, d, e);
        }
        String add = sc.nextLine();
        College ans = findCollegeWithMaximumPincode(arr);
        if (ans != null) {
            System.out.println("id" + "-" + ans.getId());
            System.out.println("name" + "-" + ans.getName());
            System.out.println("contactNo" + "-" + ans.getContactNo());
            System.out.println("address" + "-" + ans.getAddress());
            System.out.println("pincode" + "-" + ans.getPincode());
        } else {
            System.out.println("No college found with mentioned attribute");
        }

        College ans2 = searchCollegeByAddress(arr, add);
        if (ans != null) {
            System.out.println("id" + "-" + ans2.getId());
            System.out.println("name" + "-" + ans2.getName());
            System.out.println("contactNo" + "-" + ans2.getContactNo());
            System.out.println("address" + "-" + ans2.getAddress());
            System.out.println("pincode" + "-" + ans2.getPincode());
        } else {
            System.out.println("No college found with mentioned attribute");
        }
    }

    public static College findCollegeWithMaximumPincode(College[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i].getPincode());
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getPincode() == max) {
                return arr[i];
            }
        }

        return null;
    }

    public static College searchCollegeByAddress(College[] arr, String add) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAddress().equalsIgnoreCase(add)) {
                return arr[i];
            }
        }
        return null;
    }
}
