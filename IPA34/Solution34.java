package IPA34;

import java.util.*;

class Player3{
    private int id;
    private String name;
    private String Country;
    private int matchesPlayed;
    private int runsScored;

    public Player3(int id, String name, String Country, int matchesPlayed, int runsScored){
        this.id = id;
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

public class Solution34 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Player3[]arr = new Player3[n];
        for(int i =0; i<n; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            int e = sc.nextInt();
            sc.nextLine();
            arr[i] = new Player3(a, b, c, d, e);
        }

        String val = sc.nextLine();
        int val2 = sc.nextInt();

        Player3[]res = findPlayerName(arr, val, val2);
        if(res!=null){
            for(int i =0; i<res.length; i++){
                System.out.println(res[i].getId()+":"+res[i].getName());
            }
        }else{
            System.out.println("No player found");
        }

    }

    public static Player3[] findPlayerName(Player3[]arr , String val, int val2){
        List<Player3>list = new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            if(arr[i].getCountry().equalsIgnoreCase(val)  && arr[i].getRunsScored()>val2){
                list.add(arr[i]);
            }

        }
        
        return list.toArray(new Player3[0]);
    }
}
