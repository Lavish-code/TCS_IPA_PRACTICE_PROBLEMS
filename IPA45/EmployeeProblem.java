package IPA45;
import java.util.*;
public class EmployeeProblem {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
            String a = sc.nextLine();
            int b = sc.nextInt();
            double c = sc.nextDouble();

        Employee arr = new Employee(a, b, c);
        double res = calculateYearlySalary(arr);
        System.out.println("yearly salary of John: "+res);

        double res2 = calculateTax(arr);
        System.out.println("Tax to be paid by John: "+res2);
    }
    public static double calculateYearlySalary(Employee arr){
             return arr.getSalary()*12;

    }
    public static double calculateTax(Employee arr){
        double sal = arr.getSalary()*12;
        if(sal<=50000){
            return (10*sal)/100 ;
        }else if((sal>50000) && (sal<= 100000)){
            return ((50000*0.10)+((sal-50000)*0.20));
        }
        return ((50000*0.10)+(50000*0.20)+((sal-100000)*0.30));
    }
}

class Employee{
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getSalary(){
        return salary;
    }
}
