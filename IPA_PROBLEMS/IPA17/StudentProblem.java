import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StudentProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] arr = new Student[4];

        for (int i = 0; i < 4; i++) {
            int rollNo = sc.nextInt();
            sc.nextLine(); // consume leftover newline
            String name = sc.nextLine();
            String subject = sc.nextLine();
            char grade = sc.nextLine().charAt(0);
            String date = sc.nextLine();
            arr[i] = new Student(rollNo, name, subject, grade, date);
        }

        char gradeWanted = sc.next().charAt(0);
        int monthWanted = sc.nextInt();

        Student[] result = findStudentByGradeAndMonth(arr, gradeWanted, monthWanted);
        if (result.length > 0) {
            for (Student s : result) {
                System.out.println(s.getName());
                System.out.println(s.getSubject());
            }
            System.out.println(result.length);
        } else {
            System.out.println("No Student found");
        }

    }

    public static Student[] findStudentByGradeAndMonth(Student[] arr, char grade, int month) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Student> matches = new ArrayList<>();

        for (Student s : arr) {
            if (s.getGrade() == grade) {
                LocalDate date = LocalDate.parse(s.getDate(), fmt);
                if (date.getMonthValue() == month) {
                    matches.add(s);
                }
            }
        }

        return matches.toArray(new Student[0]);
    }
}

class Student {
    private int rollNo;
    private String name;
    private String subject;
    private char grade;
    private String date;

    public Student(int rollNo, String name, String subject, char grade, String date) {
        this.rollNo = rollNo;
        this.name = name;
        this.subject = subject;
        this.grade = grade;
        this.date = date;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public char getGrade() {
        return grade;
    }

    public String getDate() {
        return date;
    }
}
