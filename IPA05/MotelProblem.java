import java.util.*;

class Motel{
    private int motelId;
    private String motelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String cabFacility;
    private double totalBill;
   
   
    public Motel(int motelId, String motelName , String dateOfBooking , int noOFRoomsBooked , String cabFacility , double totalBill){
        this.motelId = motelId;
        this.motelName = motelName ;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOFRoomsBooked;
        this.cabFacility = cabFacility;
        this.totalBill = totalBill;
    }

    public int getMotelId(){
        return motelId;
    }

    public String getMotelName(){
        return motelName;
    }
    
    public String getDateOfBooking(){
        return dateOfBooking;
    }

    public int getNoOfRoomsBooked(){
        return noOfRoomsBooked;
    }

    public String getCabFacility(){
        return cabFacility;
    }

    public double getTotalBill(){
        return totalBill;
    }
}

public class MotelProblem {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Motel[]arr = new Motel[4];
        for(int i =0; i<arr.length; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();
            double f = sc.nextDouble();
            sc.nextLine();
            arr[i] = new Motel(a,b,c,d,e,f);
        }
        String value = sc.nextLine();

        int ans = totalNoOfRoomsBooked(arr, value);
        if(ans>0){
            System.out.println(ans);
        }else{
            System.out.println("no such rooms booked");
        }
    }

    public static int totalNoOfRoomsBooked(Motel[]arr , String value){
        int count =0;
        for(int i =0; i<arr.length ; i++){
            if(arr[i].getCabFacility().equalsIgnoreCase(value) && arr[i].getNoOfRoomsBooked()>5){
                count += arr[i].getNoOfRoomsBooked();
            }
        }
        return count;
    }

}
