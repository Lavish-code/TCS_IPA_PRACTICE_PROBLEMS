package IPA19;

import java.util.*;

class Flower {
    private int flowerId;
    private String flowerName;
    private int price;
    private int rating;
    private String type;

    public Flower(int flowerId, String flowerName, int price, int rating, String type) {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.price = price;
        this.rating = rating;
        this.type = type;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public String getType() {
        return type;
    }
}

public class SolutionFlower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Flower[] arr = new Flower[4];
        for (int i = 0; i < arr.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();
            arr[i] = new Flower(a, b, c, d, e);
        }
        String val = sc.nextLine();
        Flower flower = findMinPriceByType(arr, val);
        if (flower != null) {
            System.out.println(flower.getFlowerId());
        } else {
            System.out.println("There is no flower with given type");
        }
    }

    public static Flower findMinPriceByType(Flower[] arr, String val) {
        Flower minFlower = null;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getType().equalsIgnoreCase(val) && arr[i].getRating() > 3) {
                if (arr[i].getPrice() < minPrice) {
                    minPrice = arr[i].getPrice();
                    minFlower = arr[i];
                }
            }
        }

        return minFlower;
    }

}
