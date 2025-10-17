package IPA18;
import java.util.*;
class Antenna{
    private int antId;
    private String antName;
    private String proLead;
    private double antVSWR;

    public Antenna(int antId, String antName, String proLead, double antVSWR){
        this.antId = antId;
        this.antName = antName;
        this.proLead = proLead;
        this.antVSWR = antVSWR;
    }
    public int getAntId(){
        return antId;
    }
    public String getAntname(){
        return antName;
    }
    public String getProlead(){
        return proLead;
    }
    public double getAntVSWR(){
        return antVSWR;
    }
}
public class SolutionAntenna {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Antenna[]arr = new Antenna[4];
        for(int i =0; i<arr.length; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            arr[i] = new Antenna(a,b,c,d);
        }
        String val = sc.nextLine();
        double val2 = sc.nextDouble();
        int res = searchAntennaByName(arr, val);
        if(res>0){
            System.out.println(res);
        }else{
            System.out.println("There is no antenna with the given parameter");
        }

        Antenna[]res2 = sortAntennaByVSWR(arr, val2);
        if(res2!=null){
            for(int i =0;i<res2.length; i++){
                System.out.println(res2[i].getProlead());
            }
        }else{
            System.out.println("No Antenna found");
        }

    }

    public static int searchAntennaByName(Antenna[]arr, String val){
        for(int i =0; i<arr.length; i++){
            if(arr[i].getAntname().equalsIgnoreCase(val)){
                return arr[i].getAntId();
            }
        }
        return 0;
    }

    public static Antenna[] sortAntennaByVSWR(Antenna[]arr ,double val2){
        List<Antenna>list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i].getAntVSWR()< val2){
                list.add(arr[i]);
            }
        }
        Collections.sort(list,(a,b) -> Double.compare(a.getAntVSWR(), b.getAntVSWR()));
        
        return list.toArray(new Antenna[0]);
    }
}
