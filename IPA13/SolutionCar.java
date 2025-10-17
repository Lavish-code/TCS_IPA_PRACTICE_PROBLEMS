package IPA13;
import java.util.*;

class Car{
    private int cardId;
    private String brand;
    private int noOfTestsConducted;
    private int noOfTestsPassed;
    private String environment;

    public Car(int cardId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment){
        this.cardId = cardId;
        this.brand = brand ;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }

    public int getCardId(){
        return cardId;
    }
    public String getBrand(){
        return brand;
    }
    public int getNoOfTestsConducted(){
        return noOfTestsConducted;
    }
    public int getNoOfTestsPassed(){
        return noOfTestsPassed;
    }
    public String getEnvironment(){
        return environment;
    }
}

public class SolutionCar {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        Car[]arr = new Car[4];
        for(int i =0; i<arr.length; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();
            arr[i] = new Car(a,b,c,d,e);
        }
        String val = sc.nextLine();
        String val2 = sc.nextLine();

        int res = findTestPassedByEnv(arr, val);
        if(res>0){
            System.out.println(res);
        }else{
            System.out.println("There are no tests passed in this particular environment ");
        }

        Car res2 = updateCarGrade(arr, val2);
        if(res2!=null){
            if((res2.getNoOfTestsPassed()*100)/ res2.getNoOfTestsConducted() >=80){
                System.out.println(res2.getBrand()+"::"+"A1");
            }else{
                System.out.println(res2.getBrand()+"::"+"B2");
            }
        }else{
            System.out.println("No Car is available with the specified brand");
        }
    }

    public static int findTestPassedByEnv(Car[]arr , String val){
        int count = 0;
        for(int i =0; i<arr.length; i++){
            if(arr[i].getEnvironment().equalsIgnoreCase(val)){
                count+=arr[i].getNoOfTestsPassed();
            }
        }
        return count;
    }


    public static Car updateCarGrade(Car[]arr , String val2){
        for(int i =0; i<arr.length; i++){
            if(arr[i].getBrand().equalsIgnoreCase(val2)){
                return arr[i];
            }
        }
        return null;
    }
}
