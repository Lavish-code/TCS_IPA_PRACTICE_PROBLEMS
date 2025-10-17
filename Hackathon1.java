import java.lang.reflect.Array;
import java.util.*;

public class Hackathon1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Theatre[] arr = new Theatre[4];
        for (int i = 0; i < arr.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            double d = sc.nextDouble();
            int e = sc.nextInt();
            arr[i] = new Theatre(a, b, c, d, e);
        }
        int value = sc.nextInt();
        String ans = findTheatreCategory(arr, value);
        if (ans != null) {
            System.out.println(ans);
        } else {
            System.out.println("There is no theatre with the given theatreId");
        }

        Theatre ans2 = findSecondHighestTicket(arr);
        if(ans!=null){
            System.out.println(ans2.getThreatreName());
        }else{
            System.out.println("Only low rating theatres are available");
        }
    }

    public static String findTheatreCategory(Theatre[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i].getThreatreId()) {
                if ((arr[i].getSeatCapacity() > 1000) && (arr[i].getThreatreRating() >= 4)) {
                    return "Premium";
                } else {
                    return "Non Premium";
                }
            }
        }
        return null;
    }

    public static Theatre findSecondHighestTicket(Theatre[] arr) {
        ArrayList<Theatre> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getThreatreRating() >= 2) {
                list.add(arr[i]);
            }
        }

        list.sort((a, b) -> Double.compare(b.getTicketRate(), a.getTicketRate()));

        if (list.size() < 2) {
            return null;
        }

        return list.get(1);
    }

}

class Theatre {
    private int threatreId;
    private String threatreName;
    private int seatCapacity;
    private double ticketRate;
    private int threatreRating;

    public Theatre(int threatreId, String threatreName, int seatCapacity, double ticketRate, int threatreRating) {
        this.threatreId = threatreId;
        this.threatreName = threatreName;
        this.seatCapacity = seatCapacity;
        this.ticketRate = ticketRate;
        this.threatreRating = threatreRating;
    }

    public int getThreatreId() {
        return threatreId;
    }

    public String getThreatreName() {
        return threatreName;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public double getTicketRate() {
        return ticketRate;
    }

    public int getThreatreRating() {
        return threatreRating;
    }
}
