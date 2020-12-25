import java.util.Arrays;

public class Code455_findContentChildren {
    public static int findContentChildren(int[] g, int[] s) {
        int child = 0;
        int cookie = 0;
        int res = 0;
        if (g.length == 0 || s.length == 0){
            return res;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        while (child < g.length && cookie < s.length){
            if (s[cookie] >= g[child]){
                child++;
                res++;
            }
            cookie++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        System.out.println(findContentChildren(g, s));
    }
}
