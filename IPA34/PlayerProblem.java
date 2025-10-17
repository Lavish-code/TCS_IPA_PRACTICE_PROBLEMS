package IPA34;
import java.util.*;

public class PlayerProblem {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Player3 [] arr = new Player3[n];
        for(int i =0; i<n; i++){
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String Country = sc.nextLine();
            int matchesPlayed = sc.nextInt();
            int runsScored = sc.nextInt();
            sc.nextLine();

            arr[i] = new Player3(id, name, Country, matchesPlayed, runsScored);
        }
        String value = sc.nextLine();
        int value2 = sc.nextInt();
        Player3[]ans = findPlayerName(arr, value, value2);
        for(int i =0; i<ans.length; i++){
            System.out.println(ans[i].getId() + ":" +ans[i].getName());
        }
    }

    public static Player3[] findPlayerName(Player3[]arr , String value, int value2){
        ArrayList<Player3> list = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            if(arr[i].getCountry().equalsIgnoreCase(value)  && arr[i].getRunsScored()>value2){
                list.add(arr[i]);
            }
        }        
        return list.toArray(new Player3[0]);
    }
}

class Player3{
    private int id;
    private String name;
    private String Country;
    private int matchesPlayed;
    private int runsScored;

    public Player3(int id , String name, String Country, int matchesPlayed , int runsScored){
        this. id = id;
        this.name = name;
        this.Country = Country;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return Country;
    }

    public int getMatchesPlayed(){
        return matchesPlayed;
    }

    public int getRunsScored(){
        return runsScored;
    }
}
