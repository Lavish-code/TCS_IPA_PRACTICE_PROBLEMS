import java.util.*;

public class Hackathon2 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        DepartmentalStores[]arr = new DepartmentalStores[4];
        for(int i =0; i<arr.length; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            int e = sc.nextInt();
            sc.nextLine();
            arr[i] = new DepartmentalStores(a, b, c, d, e);
        }
        String startsWithInput = sc.nextLine();
        String location = sc.nextLine();
        
        int ans = findAverageWorkersInSpecificLocation(arr, startsWithInput);
        if(ans>0){
            System.out.println(ans);
        }else{
            System.out.println("No stores are available with the given input");
        }
        DepartmentalStores[]ans2 = findStoreDetailsForGivenLocation(arr, location);

        if(ans2!=null){
            for (int i = 0; i < ans2.length; i++) {
                System.out.println(ans2[i].getStoreName());
            }
        }else{
            System.out.println("No stores present in the given location");
        }
    }

    public static int findAverageWorkersInSpecificLocation(DepartmentalStores [] arr, String startsWithInput){
        int sum =0;
        int count=0; 
        for(int i =0; i<arr.length; i++){
            if(arr[i].getStoreId().startsWith(startsWithInput)){
                sum+=arr[i].getNumberOfWorkers();
                count++;
            }
        }
        
        return sum/count;
    }

    public static DepartmentalStores[] findStoreDetailsForGivenLocation(DepartmentalStores[]arr, String location){
        int j =0;
        DepartmentalStores[]temp = new DepartmentalStores[arr.length];
        for(int i =0; i<arr.length; i++){
            if(arr[i].getLocation().equalsIgnoreCase(location)){
                temp[j++] = arr[i];
            }
        }
        if (j==0) return null;
        DepartmentalStores[] result = new DepartmentalStores[j];
        for (int i = 0; i < j; i++) {
            result[i] = temp[i];
        }
        Arrays.sort(result, new Comparator<DepartmentalStores>() {
            public int compare(DepartmentalStores s1, DepartmentalStores s2) {
                return s1.getRating() - s2.getRating();
            }
        });

        return result;
    }


}

class DepartmentalStores{
    private String storeId;
    private String storeName;
    private String location;
    private int numberOfWorkers;
    private int rating;

    public DepartmentalStores(String storeId ,String storeName, String location, int numberOfWorkers ,int rating){
        this.storeId = storeId;
        this.storeName = storeName;
        this.location = location;
        this.numberOfWorkers = numberOfWorkers;
        this.rating = rating; 
    }
    public String getStoreId(){
        return storeId;
    }

    public void setStoreId(String storeId){
        this.storeId = storeId;
    } 

    public String getStoreName(){
        return storeName;
    }

    public void setStoreName(String storeName){
        this.storeName = storeName;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public int getNumberOfWorkers(){
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(int numberOfWorkers){
        this.numberOfWorkers = numberOfWorkers;
    }

    public int getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }
}
