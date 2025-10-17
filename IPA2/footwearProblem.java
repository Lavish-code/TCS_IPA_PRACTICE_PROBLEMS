package IPA2;

import java.util.*;

class Footwear {
    private int footwearId;
    private String footwearName;
    private String footwearType;
    private int price;

    public Footwear(int footwearId, String footwearName, String footwearType, int price) {
        this.footwearId = footwearId;
        this.footwearName = footwearName;
        this.footwearType = footwearType;
        this.price = price;
    }

    public int getFootwearId() {
        return footwearId;
    }

    public String getFootwearName() {
        return footwearName;
    }

    public String getFootwearType() {
        return footwearType;
    }

    public int getPrice() {
        return price;
    }

}

public class footwearProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Footwear[] arr = new Footwear[5];
        for (int i = 0; i < arr.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            arr[i] = new Footwear(a, b, c, d);
        }
        String value = sc.nextLine();
        int ans = getCountByType(arr, value);
        String val2 = sc.nextLine();
        if (ans > 0) {
            System.out.println(ans);
        } else {
            System.out.println("Footwear not available");
        }

        Footwear ans2 = getSecondHighestPriceByBrand(arr, val2);
        if (ans2 != null) {
            System.out.println(ans2.getFootwearId());
            System.out.println(ans2.getFootwearName());
            System.out.println(ans2.getPrice());
        } else {
            System.out.println("Brand not available");
        }
    }

    public static int getCountByType(Footwear[] arr, String value) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getFootwearType().equalsIgnoreCase(value)) {
                count++;
            }
        }
        return count;
    }

    public static Footwear getSecondHighestPriceByBrand(Footwear[] arr, String val2) {
        List<Footwear> list = new ArrayList<>();
        for (Footwear f : arr) {
            if (f.getFootwearName().equalsIgnoreCase(val2)) {
                list.add(f);
            }
        }

        if (list.size() < 2) {
            return null;
        }

        list.sort((a, b) -> b.getPrice() - a.getPrice());
        return list.get(1);
    }

}
