import java.util.HashSet;

public class PairSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> visited = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (visited.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }

            visited.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int target = 16;

        if (!hasPairWithSum(arr, target)) {
            System.out.println("No pair exists with the given sum.");
        }
    }
}