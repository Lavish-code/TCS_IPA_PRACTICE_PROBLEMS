import java.util.*;

class Institution{
    int institutionId;
    String institutionName;
    int noOfStudentsPlaces;
    int noOfStudentsCleared;
    String location;
    String grade;

    public Institution(int institutionId , String institutionName, int noOfStudentsPlaces , int noOfStudentsCleared, String location ){
        this. institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaces = noOfStudentsPlaces;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
    }
    public int getInstitutionId(){
        return institutionId;
    }

    public String getInstitutionName(){
        return institutionName;
    }

    public int getNoOfStudentsPlaces(){
        return noOfStudentsPlaces;
    }

    public int getNoOfStudentsCleared(){
        return noOfStudentsCleared;
    }

    public String getLocation(){
        return location;
    }

    public String getGrade(){
        return grade;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }
}



public class InstitutionProblem {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);

        Institution[]arr = new Institution[4];
        for(int i =0; i<arr.length; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();
            arr[i] = new Institution(a,b,c,d,e);

        }
        String location = sc.nextLine();
        String institutionName = sc.nextLine();

        int sum = FindNumClearancedByLoc(arr,location);
        System.out.println(sum);
        

        Institution institute = UpdateInstitutionGrade(arr, institutionName);
        if(institute!=null){
            System.out.println(institute.institutionName+ ":" + institute.grade);
        }else{
            System.out.println("No Institute is available with the specified name");
        }
    }


    public static int FindNumClearancedByLoc(Institution[]arr , String location){
        int sum =0;
        for(int i =0;i<arr.length; i++){
            if(arr[i].location.equalsIgnoreCase(location)){
                sum+=arr[i].noOfStudentsCleared;
            }
        }
        return sum;
    }

    public static Institution UpdateInstitutionGrade(Institution[]arr, String institutionName){
        for(int i =0; i<arr.length; i++){
            if(arr[i].institutionName.equalsIgnoreCase(institutionName)){
                int Rating=(arr[i].noOfStudentsPlaces * 100)/arr[i].noOfStudentsCleared;
                if(Rating>=80){
                    arr[i].setGrade("A");
                }else{
                    arr[i].setGrade("B");
                }
                return arr[i];
            }
        }
        return null;
    }
}
