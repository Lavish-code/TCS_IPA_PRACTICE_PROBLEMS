package IPA16;

import java.util.*;

class Vessel {
    private int vesselId;
    private String vesselName;
    private int noOfVoyagesPlanned;
    private int noOfVoyagesCompleted;
    private String purpose;

    public Vessel(int vesselId, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.purpose = purpose;
    }

    public int getVesselId() {
        return vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public int getNoOfVoyagesCompleted() {
        return noOfVoyagesCompleted;
    }

    public int getNoOfVoyaesPlanned() {
        return noOfVoyagesPlanned;
    }

    public String getPurpose() {
        return purpose;
    }
}

public class SolutionVessel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vessel[] arr = new Vessel[4];
        for (int i = 0; i < arr.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();
            arr[i] = new Vessel(a, b, c, d, e);
        }

        int val = sc.nextInt();
        sc.nextLine();
        String val2 = sc.nextLine();

        int res = findAvgVoyagesByPc(arr, val);
        if (res > 0) {
            System.out.println(res);
        }

        Vessel[] res2 = findVesselByGrade(val2, arr);
        if (res2 != null) {
            for (int i = 0; i < arr.length; i++) {
                int per = (res2[i].getNoOfVoyagesCompleted() * 100) / res2[i].getNoOfVoyaesPlanned();
                if ( per == 100) {
                    System.out.println(res2[i].getVesselName() + "%" + "Star");
                } else if ((99< per) && (per >80)) {
                     System.out.println(res2[i].getVesselName() + "%" + "Leader");
                } else if ((79< per) && (per >55)) {
                     System.out.println(res2[i].getVesselName() + "%" + "Inspire");
                }else{
                    System.out.println(res2[i].getVesselName() + "%" + "Striver");
                }
            }

        }else{
            System.out.println("No Naval Vessel is available with the specified purpose");
        }
    }

    public static int findAvgVoyagesByPc(Vessel[] arr, int val) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i].getNoOfVoyagesCompleted() * 100) / arr[i].getNoOfVoyaesPlanned() >= val) {
                count++;
                sum += arr[i].getNoOfVoyagesCompleted();
            }
        }
        return sum / count;
    }

    public static Vessel[] findVesselByGrade(String val2, Vessel[] arr) {
        List<Vessel> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getPurpose().equalsIgnoreCase(val2)) {
                list.add(arr[i]);
            }
        }

        return list.toArray(new Vessel[0]);
    }
}
