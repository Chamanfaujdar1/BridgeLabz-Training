import java.util.*;

public class MissingNumber {
    public static int missingNumber(int[] nums){
        int n = nums.length;
        int sum = n*(n+1)/2;
        int sum1 = 0;

        for(int num : nums){
            sum1 += num;
        }

        return sum - sum1;
    }

    public static void main(String[] args){
        int[] nums = {2,3,0};

        int result = missingNumber(nums);
        System.out.println("Missing number: " + result);
    }
}
