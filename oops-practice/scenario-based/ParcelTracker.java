import java.util.Scanner;

class StageNode {
    String stageName;
    StageNode next;

    StageNode(String stageName) {
        this.stageName = stageName;
        this.next = null;
    }
}

class Parcel {
    private String parcelId;
    private StageNode head; 
    private StageNode current; 

    Parcel(String parcelId) {
        this.parcelId = parcelId;
        initializeDefaultStages();
    }

    private void initializeDefaultStages() {
        head = new StageNode("Packed");
        head.next = new StageNode("Shipped");
        head.next.next = new StageNode("In Transit");
        head.next.next.next = new StageNode("Delivered");

        current = head;
    }

    public String getParcelId() {
        return parcelId;
    }

    public void printTrackingChain() {
        if (head == null) {
            System.out.println("Parcel tracking chain is missing (NULL). Parcel might be LOST!");
            return;
        }

        System.out.println("\n Tracking Chain for Parcel: " + parcelId);
        StageNode temp = head;

        while (temp != null) {
            if (temp == current) {
                System.out.println( + temp.stageName + " (CURRENT)");
            } else {
                System.out.println("   " + temp.stageName);
            }
            temp = temp.next;
        }
    }

    public void moveNextStage() {
        if (current == null) {
            System.out.println("Current pointer is NULL! Parcel tracking is broken/missing.");
            return;
        }

        if (current.next == null) {
            System.out.println("Parcel already at FINAL stage: " + current.stageName);
            return;
        }

        current = current.next;
        System.out.println("Parcel moved to next stage: " + current.stageName);
    }

    public void addCheckpointAfter(String existingStage, String newCheckpoint) {
        if (head == null) {
            System.out.println("Chain is NULL. Can't insert checkpoint. Parcel LOST!");
            return;
        }

        StageNode temp = head;

        while (temp != null) {
            if (temp.stageName.equalsIgnoreCase(existingStage)) {
                StageNode newNode = new StageNode(newCheckpoint);

                newNode.next = temp.next;
                temp.next = newNode;

                System.out.println("Added checkpoint '" + newCheckpoint + "' after '" + existingStage + "'");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Stage not found: " + existingStage);
    }

    public void markLost() {
        head = null;
        current = null;
        System.out.println("Parcel " + parcelId + " marked as LOST! Tracking pointers are now NULL.");
    }

    public void repairTracking() {
        initializeDefaultStages();
        System.out.println("Parcel " + parcelId + " tracking chain repaired & reset to default stages.");
    }
}

public class ParcelTracker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Parcel ID to Start Tracking: ");
        String parcelId = sc.nextLine();

        Parcel parcel = new Parcel(parcelId);

        while (true) {
            System.out.println("\n===ParcelTracker Menu ====");
            System.out.println("1. Print Tracking Chain");
            System.out.println("2. Move to Next Stage");
            System.out.println("3. Add Custom Checkpoint After a Stage");
            System.out.println("4. Mark Parcel as LOST (Null Pointer)");
            System.out.println("5. Repair Tracking (Reset Default Stages)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    parcel.printTrackingChain();
                    break;

                case 2:
                    parcel.moveNextStage();
                    break;

                case 3:
                    System.out.print("Enter Existing Stage Name: ");
                    String stage = sc.nextLine();

                    System.out.print("Enter New Checkpoint Name: ");
                    String checkpoint = sc.nextLine();

                    parcel.addCheckpointAfter(stage, checkpoint);
                    break;

                case 4:
                    parcel.markLost();
                    break;

                case 5:
                    parcel.repairTracking();
                    break;

                case 6:
                    System.out.println("Exiting ParcelTracker. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
