import java.util.*;

class Person{
    private String firstName;
    private String lastName;
    private int age;
    private char gender;

    public Person(String firstName, String lastName , int age, char gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }
    public char getGender(){
        return gender;
    }

}

class Student extends Person{
    private String rollNo;
    private String course;
    private int semester;
    private double GPA;

    public Student(String firstName, String lastName , int age, char gender ,String rollNo, String course, int semester, double GPA){
        super(firstName, lastName,age, gender);
        this.rollNo = rollNo;
        this.course = course;
        this.semester = semester;
        this.GPA = GPA;
    }
    public String getRollNo(){
        return rollNo;
    }
    public String getCourse(){
        return course;
    }
    public int getSemester(){
        return semester;
    }
    public double getGPA(){
        return GPA;
    }
}
class Faculty extends Person{
    private String eId;
    private String depart;
    private String designation;
    private double salary;

    public Faculty(String firstName, String lastName , int age, char gender , String eId, String depart,  String designation, double salary){
        super(firstName, lastName, age, gender);
        this.eId = eId;
        this.depart = depart;
        this.designation = designation;
        this.salary = salary;
    }
    public String getEId(){
        return eId;
    }
    public String getDepart(){
        return depart;
    }
    public String getDesignation(){
        return designation;
    }
    public double getSalary(){
        return salary;
    }
}

public class PersonProblem {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Student[]arr = new Student[2];
        Faculty[]arr2 = new Faculty[2];

        for(int i =0; i<arr.length; i++){
            String a= sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            String f = sc.nextLine();
            int g = sc.nextInt();
            double h = sc.nextDouble();
            sc.nextLine();
            arr[i] = new Student(a, b, c, d, e, f, g, h);
        }
        for(int i =0; i<arr2.length; i++){
            String a= sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            String f = sc.nextLine();
            String g = sc.nextLine();
            double h = sc.nextDouble();
            arr2[i] = new Faculty(a,b,c,d,e,f,g,h);
        }

        Student stu = findHighestGPAStudent(arr);
        if(stu!=null){
            System.out.println(stu.getRollNo());
            System.out.println(stu.getCourse());
            System.out.println(stu.getGPA());
        }else{
            System.out.println("Sorry - No student is available");
        }
        Faculty fac = findHighestPaidFaculty(arr2);
        if(fac!=null){
            System.out.println(fac.getEId());
            System.out.println(fac.getDepart());
            System.out.println(fac.getSalary());
        }else{
            System.out.println("Sorry - No faculty is available");
        }
    }

    public static Student findHighestGPAStudent(Student[]arr){
        double max = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            max = Math.max(max, arr[i].getGPA());
        }
        for(int i =0; i<arr.length; i++){
            if(arr[i].getGPA()==max){
                return arr[i];
            }
        }
        return null;
    }
    public static Faculty findHighestPaidFaculty(Faculty[]arr2){
        double max = Integer.MIN_VALUE;
        for(int i =0; i<arr2.length; i++){
            max = Math.max(max, arr2[i].getSalary());
        }
        for(int i =0; i<arr2.length; i++){
            if(arr2[i].getSalary()==max){
                return arr2[i];
            }
        }
        return null;
    }
}
