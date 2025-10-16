import java.util.*;

class course {
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;

    public course(int courseId, String courseName, String courseAdmin, int quiz, int handson) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }

    public int getcourseId() {
        return courseId;
    }

    public String getcourseName() {
        return courseName;
    }

    public String getcourseAdmin() {
        return courseAdmin;
    }

    public int getquiz() {
        return quiz;
    }

    public int gethandson() {
        return handson;
    }

}

public class IPA_1_CourseProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        course[] arr = new course[4];
        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            int e = sc.nextInt();
            sc.nextLine(); 

            arr[i] = new course(a, b, c, d, e);
        }

        String value = sc.nextLine(); 
        int val = sc.nextInt();       

        int ans1 = findAvgOfQuizByAdmin(arr, value);
        if (ans1 > 0) {
            System.out.println(ans1);
        } else {
            System.out.println("No Course found");
        }

        course[] ans2 = sortCourseByHandsOn(arr, val);
        if (ans2 != null && ans2.length > 0) {
            for (course c : ans2) {
                System.out.println(c.getcourseName());
            }
        } else {
            System.out.println("No Course found with mentioned attribute.");
        }

        sc.close();
    }

    public static int findAvgOfQuizByAdmin(course[] arr, String value) {
        int total = 0;
        int count = 0;
        for (course c : arr) {
            if (c.getcourseAdmin().equalsIgnoreCase(value)) {
                total += c.getquiz();
                count++;
            }
        }
        if (count>0){
            return total/count;
        }
        return 0;
    }

    public static course[] sortCourseByHandsOn(course[] arr, int limit) {
        TreeMap<Integer, List<course>> map = new TreeMap<>();
        int totalCount = 0;

        for (course c : arr) {
            if (c.gethandson() < limit) {
                map.putIfAbsent(c.gethandson(), new ArrayList<>());
                map.get(c.gethandson()).add(c);
                totalCount++;
            }
        }

        if (totalCount == 0) {
            return null;
        }

        course[] result = new course[totalCount];
        int index = 0;

        for (Map.Entry<Integer, List<course>> entry : map.entrySet()) {
            for (course c : entry.getValue()) {
                result[index++] = c;
            }
        }

        return result;
    }
}
