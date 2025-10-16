import java.util.*;

class TravelAgencies {
    int price;
    String packageType;
    String agencyName;
    int regNo;
    boolean flightFacility;

    public TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.flightFacility = flightFacility;
        this.price = price;
        this.packageType = packageType;
    }

    public int getRegNo() {
        return regNo;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public String getPackageType() {
        return packageType;
    }

    public boolean getFlightFacility() {
        return flightFacility;
    }

    public int getPrice() {
        return price;
    }
}

public class TravelAgenciesProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelAgencies[] arr = new TravelAgencies[4];
        
        for (int i = 0; i < 4; i++) {
            int regNo = sc.nextInt(); sc.nextLine();
            String agencyName = sc.nextLine();
            String packageType = sc.nextLine();
            int price = sc.nextInt();
            boolean flightFacility = sc.nextBoolean();
            sc.nextLine();  // consume newline after boolean
            arr[i] = new TravelAgencies(regNo, agencyName, packageType, price, flightFacility);
        }

        int regNo = sc.nextInt(); sc.nextLine();
        String packageType = sc.nextLine();

        int maxPrice = findAgencyWithHighestPackagePrice(arr);
        System.out.println(maxPrice);

        TravelAgencies result = agencyDetailsForGivenIdAndType(arr, regNo, packageType);
        if (result != null) {
            System.out.println(result.getAgencyName() + ":" + result.getPrice());
        }
    }

    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] arr) {
        int max = arr[0].getPrice();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getPrice() > max) {
                max = arr[i].getPrice();
            }
        }
        return max;
    }

    public static TravelAgencies agencyDetailsForGivenIdAndType(TravelAgencies[] arr, int regNo, String packageType) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getFlightFacility()) {
                if (arr[i].getRegNo() == regNo &&
                    arr[i].getPackageType().equalsIgnoreCase(packageType)) {
                    return arr[i];
                }
            }
        }
        return null;
    }
}
