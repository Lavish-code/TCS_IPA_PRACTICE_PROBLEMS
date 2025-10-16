package IPA9;
import java.util.*;


class ClassBook{
    private int id;
    private int pages;
    private String title;
    private String author;
    private double price;

    public ClassBook(int id , int pages , String title , String author , Double price){
        this.id = id;
        this.pages = pages;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public int getPages(){
        return pages;
    }

    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }

    public double getPrice(){
        return price;
    }
}


public class ClassProblem {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        ClassBook[]arr = new ClassBook[4];
        for(int i =0; i<arr.length; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            String c = sc.nextLine();
            String d = sc.nextLine();
            double e = sc.nextDouble();
            sc.nextLine();
            arr[i] = new ClassBook(a, b, c, d, e);
        }
        String value = sc.nextLine();


        ClassBook []ans = findBookWithMaximumPrice(arr);
        if(ans!=null){
           for(int i =0; i<ans.length; i++){
                System.out.println(ans[i].getId()+ " "+ ans[i].getTitle());
            } 
        }else{
            System.out.println( "No Book found with mentioned attribute.");
        }

        ClassBook ans2 = searchBookByTitle(arr, value);
        if(ans2!=null){
            System.out.println(ans2.getId());
            System.out.println(ans2.getPages());
        }else{
            System.out.println("No Book found with mentioned attribute.");
        }

    }

    public static ClassBook[] findBookWithMaximumPrice(ClassBook[]arr){
        double max = 0;
        List<ClassBook> list = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            if(max<arr[i].getPrice())
            max = arr[i].getPrice();
        }

        for(int i=0; i<arr.length; i++){
            if(max == arr[i].getPrice()){
               list.add(arr[i]);
            }
        }
        return list.toArray(new ClassBook[0]);
    }

    public static ClassBook searchBookByTitle(ClassBook[]arr , String value){
        for(int i =0; i<arr.length; i++){
            if(arr[i].getTitle().equalsIgnoreCase(value)){
                return arr[i];
            }
        }
        
        return null;
    }
}