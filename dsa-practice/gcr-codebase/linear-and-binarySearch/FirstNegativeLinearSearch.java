public class FirstNegativeLinearSearch {

    public static int firstNegativeIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 0, -7, 9, -3};

        int index = firstNegativeIndex(arr);

        System.out.println("First Negative Index: " + index);
    }
}
