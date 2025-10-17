package IPA11;
import java.util.*;
public class PlayerSolution {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Player[]arr = new Player[4]; 
        for(int i =0; i<arr.length; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c= sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            arr[i] = new Player(a, b , c, d);
        }
        String val = sc.nextLine();
        String val2 = sc.nextLine();
        int res= findPointsForGivenSkill(arr, val);
        if(res>0){
            System.out.println(res);
        }else{
            System.out.println("The given Skill is not available");
        }

        Player res2 = getPlayerBasedOnLevel(arr, val, val2);
        if(res2!=null){
            System.out.println(res2.getPlayerId());
        }else{
            System.out.println("No player is available with specified level, skill and eligibility points");
        }
    }

    public static int findPointsForGivenSkill(Player[]arr, String val){
        int count =0;
        for(int i =0; i<arr.length; i++){
            if(arr[i].getSkill().equalsIgnoreCase(val)){
                count+=arr[i].getPoints();
            }
        }
        
        return count;
    }

    public static Player getPlayerBasedOnLevel(Player[]arr, String val, String val2){
        for(int i =0; i<arr.length;i++){
            if(arr[i].getSkill().equalsIgnoreCase(val) 
                && arr[i].getLevel().equalsIgnoreCase(val2) 
                && arr[i].getPoints()>=20){
                    return arr[i];
            }
        }
        
        return null;
    }
    
}

class Player{
    private int playerId;
    private String skill;
    private String level;
    private int points;

    public Player(int playerId, String skill, String level, int points){
        this.playerId =playerId;
        this.skill = skill;
        this.level = level ;
        this.points = points;
    }

    public int getPlayerId(){
        return playerId;
    }
    public String getSkill(){
        return skill;
    }
    public String getLevel(){
        return level;
    }
    public int getPoints(){
        return points;
    }
}
