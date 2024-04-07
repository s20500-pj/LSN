import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = convertArgsToArray(args);
        Arrays.sort(nums);
        StringBuilder output = new StringBuilder();

        for (int i = 0, j = nums.length - 1; nums[i] < nums[j]; i++) {
            for (int k = j; k > i; k--) {
                if (nums[i] + nums[k] == 13) {
                    output.append(String.format("%d %d\n", nums[i], nums[k]));
                    j = k;
                }
            }
        }

        System.out.println(output);
    }

    public static int[] convertArgsToArray(String[] args) {
        int[] nums = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            try {
                nums[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid argument: " + args[i]);
            }
        }

        return nums;
    }
}