package IPA12;
import java.util.*;
class Medicine{
    private String MedicineName;
    private String batch;
    private String disease;
    private int price;

    public Medicine(String MedicineName, String batch, String disease, int price){
        this.MedicineName = MedicineName;
        this.batch = batch ;
        this.disease= disease;
        this.price = price;
    }
    public String getMedicineName (){
        return MedicineName;
    }
    public String getBatch(){
        return batch;
    }
    public String getDisease(){
        return disease;
    }
    public int getPrice(){
        return price;
    }
}

public class SolutionMedicine {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Medicine[]arr = new Medicine[4];
        for(int i =0; i<arr.length; i++){
            String a= sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d= sc.nextInt();
            sc.nextLine();
            arr[i] = new Medicine(a,b,c,d);
        }

        String val = sc.nextLine();
        Medicine res[] = getPriceByDisease(arr, val);
        for(int i =0; i<res.length; i++){
            System.out.println(res[i].getPrice());
        }
    }

    public static Medicine[] getPriceByDisease(Medicine[]arr , String val){
        List<Medicine>list = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            if(arr[i].getDisease().equalsIgnoreCase(val)){
                list.add(arr[i]);
            }
        }
        
        return list.toArray(new Medicine[0]);
    }
}
