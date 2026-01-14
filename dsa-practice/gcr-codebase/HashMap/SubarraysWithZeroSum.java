import java.util.*;

public class SubarraysWithZeroSum {
    
    static class Subarray {
        int start, end;
        Subarray(int s, int e) {
            this.start = s;
            this.end = e;
        }
        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public static List<Subarray> findAllZeroSumSubarrays(int[] arr) {
        List<Subarray> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == 0) {
                result.add(new Subarray(0, i));
            }

            if (map.containsKey(currentSum)) {
                List<Integer> prevIndices = map.get(currentSum);
                for (Integer prevIndex : prevIndices) {
                    result.add(new Subarray(prevIndex + 1, i));
                }
            }

            map.putIfAbsent(currentSum, new ArrayList<>());
            map.get(currentSum).add(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<Subarray> subarrays = findAllZeroSumSubarrays(arr);
        
        System.out.println("Zero Sum Subarrays found at indices:");
        for (Subarray s : subarrays) {
            System.out.println(s);
        }
    }
}