import java.util.*;

class Movie{
    String movieName;
    String company;
    String genre;
    int budget;

    public Movie(String movieName , String company , String genre , int budget){
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }

    public String getMovieName(){
        return movieName;
    }

    public String getCompany(){
        return company;
    }

    public String getGenre(){
        return genre;
    }

    public  int getBudget(){
        return budget;
    }
}

public class MovieProblem {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Movie[]arr = new Movie[4];
        for(int i =0; i<arr.length; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();

            arr[i] = new Movie(a,b,c,d);
        }
        String searchGenre = sc.nextLine();

        Movie []res = getMovieByGenre(arr, searchGenre);
        for(int i =0 ; i<res.length; i++){
            if(res[i].getBudget()>80000000){
                System.out.println("High Budget Movie");
            }else{
                System.out.println("Low Budget Movie");
            }  
        }
    }


    public static Movie[] getMovieByGenre(Movie[]arr , String searchGenre){
        ArrayList<Movie> list = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            if(searchGenre.equalsIgnoreCase(arr[i].genre)){
                list.add(arr[i]);
            }
        }
        return list.toArray(new Movie[0]);
    }
}
