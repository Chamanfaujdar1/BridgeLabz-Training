import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Program {

    public void registerCreator(CreatorStats record) {
        CreatorStats.engagementBoard.add(record);
    }

    public Dictionary<String, Integer> getTopPostCounts(
            List<CreatorStats> records, double likeThreshold) {

        Dictionary<String, Integer> result = new Hashtable<>();

        for (CreatorStats creator : records) {
            int count = 0;

            for (double likes : creator.getWeeklyLikes()) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }

            if (count > 0) {
                result.put(creator.getCreatorName(), count);
            }
        }
        return result;
    }

    public double calculateAverageLikes() {
        double sum = 0;
        int totalCount = 0;

        for (CreatorStats creator : CreatorStats.engagementBoard) {
            for (double likes : creator.getWeeklyLikes()) {
                sum += likes;
                totalCount++;
            }
        }

        if (totalCount == 0) {
            return 0;
        }
        return sum / totalCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Program program = new Program();
        int choice;

        do {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    CreatorStats creator = new CreatorStats();

                    System.out.println("Enter Creator Name:");
                    creator.setCreatorName(sc.nextLine());

                    double[] weeklyLikes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");

                    for (int i = 0; i < 4; i++) {
                        weeklyLikes[i] = sc.nextDouble();
                    }

                    creator.setWeeklyLikes(weeklyLikes);
                    program.registerCreator(creator);

                    System.out.println("Creator registered successfully");
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double threshold = sc.nextDouble();

                    Dictionary<String, Integer> result =
                            program.getTopPostCounts(
                                    CreatorStats.engagementBoard, threshold);

                    if (result.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        Enumeration<String> keys = result.keys();
                        while (keys.hasMoreElements()) {
                            String name = keys.nextElement();
                            System.out.println(name + " - " + result.get(name));
                        }
                    }
                    break;

                case 3:
                    double avg = program.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + avg);
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    break;
            }

        } while (choice != 4);

        sc.close();
    }
}
