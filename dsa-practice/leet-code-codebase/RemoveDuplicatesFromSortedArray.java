import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args){
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();

        int[] nums = {1,1,2,2,3,3,4};
        int k = obj.removeDuplicates(nums);

        System.out.println("k = " + k);
        System.out.println("Unique array = " + Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
    }
}
