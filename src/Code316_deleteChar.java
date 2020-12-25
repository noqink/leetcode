import java.util.Arrays;
import java.util.Stack;

public class Code316_deleteChar {
    public static String removeDuplicateLetters(String s){
        int len = s.length();
        if (len < 2){
            return s;
        }

        // abca
        char[] chars = s.toCharArray();
        int[] place = new int[26]; // 记录chars中字符出现的最后一次位置
        boolean[] visited = new boolean[26]; // 记录chars中字符是否保存在栈中
        for (int i = 0; i < len; i++){
            // place[ a - a] = 0;
            place[chars[i] - 'a'] = i;
            // ....
            // place [ a - a] = 4
        }
        System.out.println(Arrays.toString(place));

        Stack stack = new Stack();
        for (int i = 0; i < len; i++){

            char currentChar = chars[i];
            if (visited[currentChar - 'a']){
                continue;
            }
            // 弹出条件:
            // 1.栈不为空
            // 2.栈顶元素字典序 大于 当前元素
            // 3.栈顶元素 在后序会再次出现
            while (!stack.isEmpty() && (char)stack.peek() > currentChar && place[(char)stack.peek()  - 'a'] > i){
                visited[(char)stack.pop() - 'a'] = false;
            }
            stack.push(currentChar);
            visited[currentChar - 'a'] = true;

        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
