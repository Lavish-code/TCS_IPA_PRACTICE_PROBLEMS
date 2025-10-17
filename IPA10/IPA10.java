package IPA10;
import java.util.*;
class Employee{
    private int employeeID;
    private String name;
    private String branch;
    private double rating;
    private boolean companyTransport;


    public Employee(int employeeID, String name, String branch, double rating, boolean companyTransport){
        this.employeeID = employeeID;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.companyTransport = companyTransport;
    }

    public int getEmployeeID(){
        return employeeID;
    }
    public String getName(){
        return name;
    }
    public String getBranch(){
        return branch;
    }
    public double getRating(){
        return rating;
    }
    public boolean getCompanyTransport(){
        return companyTransport;
    }
}

public class IPA10{
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        Employee[]arr = new Employee[4];
        for(int i =0;i<4;i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            boolean e = sc.nextBoolean();
            sc.nextLine();
            arr[i] = new Employee(a,b,c,d,e);
        }
        String value = sc.nextLine();
        int res = findCountEmployeesUsingCompanyTransport(arr, value);
        if(res>0){
            System.out.println(res);
        }else{
            System.out.println("No such Employees");
        }


        Employee res2 = findEmployeeWithSecondHighestRating(arr);
        if(res2 == null){
            System.out.println("All Employees using company transport");
        }else{
            System.out.println(res2.getEmployeeID());
            System.out.println(res2.getName());
        }
    }



    public static int findCountEmployeesUsingCompanyTransport(Employee[]arr , String value){
        int count = 0;
        for(int i =0; i<arr.length; i++){
            if(arr[i].getBranch().equalsIgnoreCase(value) && arr[i].getCompanyTransport()==true){
                count++;
            }
        }
        return count;
    }


    public static Employee findEmployeeWithSecondHighestRating(Employee[]arr){
        List<Employee>list = new ArrayList<>();
        for(Employee e : arr){
            if(e.getCompanyTransport()==false){
                list.add(e);
            }
        }

        if(list.size()<2){
            return null;
        }
        
        Collections.sort(list , (a,b) ->Double.compare(b.getRating(), a.getRating()));
        return list.get(1);
    }
}