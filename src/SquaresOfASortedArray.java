import java.util.Arrays;

public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int resultPointer = 0;
        int leftPointer = -2;
        int rightPointer = 1; // main pointer

        while (leftPointer >= 0 || rightPointer < nums.length) {
            if (leftPointer == -2) { // inflection point not found?
                if (Math.pow(nums[rightPointer - 1], 2) < Math.pow(nums[rightPointer], 2)) { // checking for inflection point
                    leftPointer = rightPointer - 1; // inflection point found
                } else {
                    rightPointer++; // keep searching
                }
            } else { // inflection point found
                if (leftPointer >= 0 && (rightPointer == nums.length || Math.pow(nums[leftPointer], 2) <= Math.pow(nums[rightPointer], 2))) { // left value smaller?
                    result[resultPointer] = (int) Math.pow(nums[leftPointer], 2);
                    resultPointer++;
                    leftPointer--;
                } else if (rightPointer < nums.length) { // right value smaller?
                    result[resultPointer] = (int) Math.pow(nums[rightPointer], 2);
                    resultPointer++;
                    rightPointer++;
                }
            }
        }

        if (leftPointer == -2) { // squared array is strictly descending
            for (int i = nums.length - 1; i >= 0; i--) {
                result[resultPointer] = (int) Math.pow(nums[i], 2);
                resultPointer++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-3,0,2};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

}
