
import java.util.*;
public class securelock{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n-->0){
            String PIN = sc.nextLine();
            int sum =0;
            for(char ch : PIN.toCharArray()){
                sum += ch-'0';
            }


            if(sum%4 ==0){
                System.out.println("OPEN");
            }else{
                System.out.println("CLOSED");
            }
        }
    }
}