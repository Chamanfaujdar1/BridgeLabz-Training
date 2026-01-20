import java.util.ArrayList;
import java.util.List;

class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

class CinemaTimeManager {

    private final List<String> movieTitles;
    private final List<String> showTimes;

    public CinemaTimeManager() {
        movieTitles = new ArrayList<>();
        showTimes = new ArrayList<>();
    }

    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid Time Format: " + time + " (Expected HH:MM)");
        }

        movieTitles.add(title);
        showTimes.add(time);

        System.out.println("Movie Added: " + title + " at " + time);
    }

    public void searchMovie(String keyword) {
        System.out.println("\n🔍 Search Results for: \"" + keyword + "\"");

        boolean found = false;

        for (int i = 0; i < movieTitles.size(); i++) {
            if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                String formatted = String.format("✅ %d) %s - %s", i, movieTitles.get(i), showTimes.get(i));
                System.out.println(formatted);
                found = true;
            }
        }

        if (!found) {
            System.out.println(" No movie found with keyword: " + keyword);
        }

        try {
            System.out.println("\n(Testing invalid index access...)");
            System.out.println("Movie at index 999: " + movieTitles.get(999));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index while searching movies!");
        }
    }

    public void displayAllMovies() {
        System.out.println("\n🎬 All Movies Schedule:");

        if (movieTitles.isEmpty()) {
            System.out.println("No movies available!");
            return;
        }

        for (int i = 0; i < movieTitles.size(); i++) {
            String formatted = String.format("%d) %s  | Time: %s", i + 1, movieTitles.get(i), showTimes.get(i));
            System.out.println(formatted);
        }
    }

    public void generatePrintableReport() {
        System.out.println("\n📝 Printable Movie Report:");

        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = showTimes.toArray(new String[0]);

        for (int i = 0; i < titlesArray.length; i++) {
            System.out.println((i + 1) + ". " + titlesArray[i] + " --> " + timesArray[i]);
        }
    }

    private boolean isValidTime(String time) {
        if (time == null || !time.matches("\\d{2}:\\d{2}")) {
            return false;
        }

        String[] parts = time.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);

        return hh >= 0 && hh <= 23 && mm >= 0 && mm <= 59;
    }
}

public class CinemaTime {
    public static void main(String[] args) {

        CinemaTimeManager manager = new CinemaTimeManager();

        try {
            manager.addMovie("Avengers: Endgame", "18:30");
            manager.addMovie("Interstellar", "21:15");
            manager.addMovie("KGF Chapter 2", "14:00");

            manager.addMovie("Invalid Movie", "25:99");

        } catch (InvalidTimeFormatException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        manager.displayAllMovies();

        manager.searchMovie("star");
        manager.searchMovie("KGF");

        manager.generatePrintableReport();
    }
}
