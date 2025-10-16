package IPA8;
import java.util.*;

class Hotel{
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String wifiFacility;
    private double totalBill;

    public Hotel(int hotelId, String hotelName , String dateOfBooking ,  int noOFRoomsBooked, String wifiFacility , double totalBill){
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.wifiFacility = wifiFacility;
        this.noOfRoomsBooked = noOFRoomsBooked;
        this.totalBill = totalBill;
    }

    public int getHotelId(){
        return hotelId;
    }

    public String getHotelName(){
        return hotelName;
    }

    public String getDateOfBokking(){
        return dateOfBooking;
    }

    public int getNoOfRoomsBooked(){
        return noOfRoomsBooked;
    }

    public String getWifiFacility(){
        return wifiFacility;
    }

    public double getTotalBill(){
        return totalBill;
    }
}

public class HotelProblem {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Hotel[]arr = new Hotel[4] ;
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
            arr[i] = new Hotel(a,b,c,d,e,f);
        }
        String value = sc.nextLine();
        String value2 = sc.nextLine();

        int ans1 = noOfRoomsBookedInGivenMonth(arr, value);
        if(ans1!=0){
            System.out.println(ans1);
        }else{
            System.out.println("No rooms booked in the given month");
        }

        Hotel[] ans2 = searchHotelByWifiOption(arr, value2);
        if(ans2!=null){
            System.out.println(ans2[1].getHotelId());
        }else{
            System.out.println("No such option available");
        }
    }

    public static int noOfRoomsBookedInGivenMonth(Hotel[]arr , String value){
        int count =0;
        for(int i =0; i<arr.length; i++){
            if(arr[i].getDateOfBokking().contains(value)){
                count+=arr[i].getNoOfRoomsBooked();
            }
        }
        return count;
    }

    public static Hotel[] searchHotelByWifiOption(Hotel[]arr , String value2){
        List<Hotel>list = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            if(arr[i].getWifiFacility().equalsIgnoreCase(value2)){
                list.add(arr[i]);
            }
        }
        list.sort((a,b) -> Double.compare(b.getTotalBill(), a.getTotalBill()));
        return list.toArray(new Hotel[1]);
    }
}
