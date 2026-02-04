import java.util.*;
import java.util.stream.*;

public class TopFiveTrendingMovies {
    static class Movie{
        String name;
        double rating;
        int releaseYear;

        public Movie(String name, double rating, int releaseYear){
            this.name = name;
            this.rating = rating;
            this.releaseYear = releaseYear;
        }

        @Override
        public String toString(){
            return "Name: " + name + ", Rating: " + rating + ", Release Year: " + releaseYear;
        }


    }
    public static void main(String[] args){
        List<Movie> movies = List.of(
            new Movie("3 Idiots", 8.5, 2009),
            new Movie("Border 2", 7.5, 2026),
            new Movie("Dangal", 9.0, 2016),
            new Movie("Lakshya", 8.8, 2010),
            new Movie("Uri the surgical strike", 8.6, 2014),
            new Movie("Shershah", 8.4, 2015),
            new Movie("KGF chapter 2", 9.1, 2022),
            new Movie("RRR", 9.3, 2022),
            new Movie("Bahubali 2", 9.2, 2017),
            new Movie("Avengers Endgame", 8.9, 2019)
        );

        List<Movie> top5TrendingMovies = movies.stream()
            .filter(movie -> movie.rating>= 8.0).sorted((m1, m2) -> {
                if(m2.releaseYear != m1.releaseYear){
                    return m2.releaseYear - m1.releaseYear;
                }
                return Double.compare(m2.rating, m1.rating);
            })
            .limit(5).toList();

            System.out.println("Top 5 trending movies: ");
            top5TrendingMovies.forEach(System.out::println);
    }
}
