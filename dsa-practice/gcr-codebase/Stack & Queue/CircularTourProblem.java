public class CircularTourProblem {
    static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0; 
        int surplus = 0;    
        int totalDeficit = 0;

        for (int i = 0; i < pumps.length; i++) {
            surplus += (pumps[i].petrol - pumps[i].distance);

            if (surplus < 0) {
                totalDeficit += surplus;
                start = i + 1;          
                surplus = 0;      
            }
        }

        return (surplus + totalDeficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int result = findStartingPoint(pumps);
        
        if (result == -1) {
            System.out.println("No circular tour possible.");
        } else {
            System.out.println("Start at pump index: " + result);
        }
    }
}