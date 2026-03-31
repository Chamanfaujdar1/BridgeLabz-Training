public class PeakElementBinarySearch {

    public static int findPeakIndex(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeakIndex(arr);

        System.out.println("Peak Index: " + peakIndex);
        System.out.println("Peak Element: " + arr[peakIndex]);
    }
}
