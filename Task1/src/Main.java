import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] nums = convertArgsToArray(args);
        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[nums.length - 1];
        int length = nums.length;

        Set<Integer> sortedSet = toSet(nums);
        int distinctLength = sortedSet.size();

        System.out.printf("%s\ncount: %d\ndistinct: %d\nmin: %d\nmax: %d%n",
                formatSet(sortedSet), length, distinctLength, min, max);
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

    public static Set<Integer> toSet(int[] nums) {
        Set<Integer> sortedSet = new TreeSet<>();

        for (int num : nums) {
            sortedSet.add(num);
        }

        return sortedSet;
    }

    public static String formatSet(Set<Integer> set) {
        return set.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}