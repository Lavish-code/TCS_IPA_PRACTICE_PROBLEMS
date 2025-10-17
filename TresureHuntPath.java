import java.util.*;
public class TresureHuntPath {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n-->0){
            String path = sc.nextLine();
            int x=0,y=0;
            for(char ch: path.toCharArray()){
                if(ch=='U') y++;
                else if(ch=='D') y--;
                else if(ch=='L') x--;
                else if(ch=='R') x++;
            }

            System.out.println(x +" "+ y);
        }
    }
}
