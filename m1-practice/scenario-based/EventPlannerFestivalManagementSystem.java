import java.time.LocalDate;
import java.util.*;

abstract class Festival{
    String name;
    String location;
    LocalDate date;

    public Festival(String name, String location, LocalDate date){
        this.name = name;
        this.location = location;
        this.date = date;
    }

    abstract void displayDetails();
}

class MusicFestival extends Festival{
    String headliner;
    String musicGenre;
    double ticketPrice;

    public MusicFestival(String name, String location, LocalDate date, String headliner, String musicGenre, double ticketPrice){
        super(name, location, date);
        this.headliner = headliner;
        this.musicGenre = musicGenre;
        this.ticketPrice = ticketPrice;
    }

    @Override
    void displayDetails(){
        System.out.println("Music Festival: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + musicGenre);
        System.out.println("Ticket Price: $" + ticketPrice);
    }

}

class FoodFestival extends Festival{
    String cuisine;
    int numStalls;
    int entryFee;

    public FoodFestival(String name, String location, LocalDate date, String cuisine, int numStalls, int entryFee){
        super(name, location, date);
        this.cuisine = cuisine;
        this.numStalls = numStalls;
        this.entryFee = entryFee;
    }

    @Override
    void displayDetails(){
        System.out.println("Food Festival: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + numStalls);
        System.out.println("Entry Fee: $" + entryFee);
    }
}

class ArtFestival extends Festival{
    String artType;
    int numArtists;
    int exhibitionFee;

    public ArtFestival(String name, String location, LocalDate date, String artType, int numArtists, int exhibitionFee){
        super(name, location, date);
        this.artType = artType;
        this.numArtists = numArtists;
        this.exhibitionFee = exhibitionFee;
    }

    @Override
    void displayDetails(){
        System.out.println("Art Festival: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + numArtists);
        System.out.println("Exhibition Fee: $" + exhibitionFee);
    }
}

public class EventPlannerFestivalManagementSystem {
    static Map<String, Festival> festivals = new HashMap<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            String input = sc.nextLine();
            String[] parts = input.split(" ");

            if(parts[0].equals("ADD_FESTIVAL")){
                addFestival(parts);
            }else if(parts[0].equals("DISPLAY_DETAILS")){
                displayFestival(parts[1]);
            }else if(parts[0].equals("EXIT")){
                break;
            }
        }
    }

    public static void addFestival(String[] parts){
        String type = parts[1];

        if (type.equals("MUSIC")) {
            Festival f = new MusicFestival(
                    parts[2], parts[3], Integer.parseInt(parts[4]),
                    parts[5], parts[6], Integer.parseInt(parts[7])
            );
            festivalMap.put(parts[2], f);

        } else if (type.equals("FOOD")) {
            Festival f = new FoodFestival(
                    parts[2], parts[3], Integer.parseInt(parts[4]),
                    parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7])
            );
            festivalMap.put(parts[2], f);

        } else if (type.equals("ART")) {
            Festival f = new ArtFestival(
                    parts[2], parts[3], Integer.parseInt(parts[4]),
                    parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7])
            );
            festivalMap.put(parts[2], f);
        }
    }

    public static void displayFestival(String name){
        if(festivalMap.containsKey(name)){
            festivalMap.get(name).displayDetails();
        }
    }
}
