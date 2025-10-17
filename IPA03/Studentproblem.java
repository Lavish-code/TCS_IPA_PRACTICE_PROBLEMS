package IPA3;
import java.util.*;

class Student{
    private int rollNo;
    private String name;
    private String branch;
    private double score;
    private boolean dayScholar;

    public Student(int rollNo, String name , String branch , double score, boolean dayScholar){
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.dayScholar = dayScholar;
    }

    public int getRollNo(){
        return rollNo;
    }

    public String getName(){
        return name;
    }

    public String getBranch(){
        return branch;
    }

    public double getScore(){
        return score;
    }

    public boolean getDayScholar(){
        return dayScholar;
    }
}



public class Studentproblem {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Student[] arr = new Student[4];
        for(int i =0; i<arr.length; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            boolean e = sc.nextBoolean();
            sc.nextLine();
            arr[i] = new Student(a,b,c,d,e);
        }

        int ans = findCountOfDayScholarStudents(arr);
        if(ans>0){
            System.out.println(ans);
        }else{
            System.out.println("There are no such dayscholar students");
        }

        Student ans2 = findStudentwithSecondHighestscore(arr);
        
        if(ans2!=null){
            System.out.print(ans2.getRollNo()+"#"+ans2.getName()+"#"+ans2.getScore());
        }
    }

    public static int findCountOfDayScholarStudents(Student[]arr ){
        int count =0;
        for(int i =0; i<arr.length; i++){
            if(arr[i].getScore()>80 && arr[i].getDayScholar()){
                count++;
            }
        }
        return count;
    }

    public static Student findStudentwithSecondHighestscore(Student[]arr){
        List<Student>list = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            if(!arr[i].getDayScholar()){
                list.add(arr[i]);
            }
        }
         if (list.size() < 2) {
            return null;
        }

        list.sort((a,b) -> Double.compare(b.getScore() , a.getScore()));
        return list.get(1);
    }
}
