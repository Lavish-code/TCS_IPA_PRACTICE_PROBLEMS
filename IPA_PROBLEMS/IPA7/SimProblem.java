package IPA7;

import java.util.*;

class Sim {
    private int simId;
    private String customerName;
    private double balance;
    private double ratePerSecond;
    private String circle;

    public Sim(int simId, String customernName, double balance, double ratePerSecond, String circle) {
        this.simId = simId;
        this.customerName = customernName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

    public int getSimId() {
        return simId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }
}

public class SimProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim[] arr = new Sim[5];
        for (int i = 0; i < arr.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            double c = sc.nextDouble();
            double d = sc.nextDouble();
            sc.nextLine();
            String e = sc.nextLine();
            arr[i] = new Sim(a, b, c, d, e);
        }
        String circle1 = sc.nextLine();
        String circle2 = sc.nextLine();
        Sim[] ans = transferCustomerCircle(arr, circle1, circle2);
        for (Sim sim : ans) {
            System.out.println(sim.getSimId() + " " + sim.getCustomerName() + " " + sim.getCircle() + " "
                    + sim.getRatePerSecond());
        }
    }

    public static Sim[] transferCustomerCircle(Sim[] arr, String circle1, String circle2) {
        List<Sim> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getCircle().equalsIgnoreCase(circle1)) {
                arr[i].setCircle(circle2);
                list.add(arr[i]);
            }
        }

        list.sort((a, b) -> Double.compare(b.getRatePerSecond(), a.getRatePerSecond()));
        return list.toArray(new Sim[0]);
    }
}
