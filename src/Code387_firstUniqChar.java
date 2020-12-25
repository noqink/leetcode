import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Code387_firstUniqChar {
    /**
     * 找到字符串中的第一个唯一字符
     * @param s
     * @return
     */
    public static int firstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map =  new HashMap<>();
        for (int i = 0;i < chars.length;i++){
            if (map.containsKey(chars[i])){
                map.put(chars[i], map.get(chars[i]) + 1);
            }else {
                map.put(chars[i], 1);
            }
        }
        for (int i = 0;i < chars.length;i++){
            if (map.get(chars[i]) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    private static int firstUniqChar(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++){
            arr[chars[i] - 'a']++;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0;i < chars.length;i++){
            if (arr[chars[i] - 'a'] == 1){
                return i;
            }
        }
        return - 1;
    }
}
