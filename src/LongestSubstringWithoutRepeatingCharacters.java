import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                result = Math.max(result, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
//        System.out.println(set.contains("c"));
        System.out.println(lengthOfLongestSubstring(s));
    }
}
