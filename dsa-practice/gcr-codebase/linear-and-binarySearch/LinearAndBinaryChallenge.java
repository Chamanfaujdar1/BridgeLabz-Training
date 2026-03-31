import java.util.Arrays;

public class LinearAndBinaryChallenge {

    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;

        boolean[] visited = new boolean[n + 2];

        for (int x : arr) {
            if (x > 0 && x <= n) {
                visited[x] = true;
            }
        }

        for (int i = 1; i <= n + 1; i++) {
            if (!visited[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, -1, 1, 7, 2};
        int target = 7;

        int missing = firstMissingPositive(nums);
        System.out.println("First Missing Positive: " + missing);

        Arrays.sort(nums);
        System.out.println("Sorted Array: " + Arrays.toString(nums));

        int index = binarySearch(nums, target);
        System.out.println("Target " + target + " found at index: " + index);
    }
}
