import java.util.Arrays;

public class Code135_candy {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(candy(arr));
    }

    public static int candy1(int[] ratings) {
        // 贪心算法
        // 满足规则：
        // 规则定义： 设学生 A 和学生 B 左右相邻，A 在 B 左边；
        // 左规则：当 ratings[i−1]<ratings[i] 时，i 号学生的糖果数量将比 i - 1号孩子的糖果数量多。
        // 右规则：当 ratings[i]>ratings[i+1] 时，i 号学生的糖果数量将比 i + 1号孩子的糖果数量多。
        // 先从左到右遍历
        // 再从右往左遍历
        // 取最后两次遍历最大值就能满足左右规则
        int len = ratings.length;
        if (len == 0){
            return 0;
        }

        if (len == 1){
            return 1;
        }

        int candyLeft[] = new int[len];
        // 从左向右遍历
        for (int i = 1; i <len;i ++){
            if (ratings[i] > ratings[i - 1]){
                candyLeft[i] = candyLeft[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(candyLeft));

        int res = candyLeft[len - 1];
        int candyRight[] = new int[len];
        // 从右往左遍历
        for (int i = len - 2; i >= 0;i --){
            if (ratings[i] > ratings[i + 1]){
                candyRight[i] = candyRight[i + 1] + 1;
            }
            res += Math.max(candyLeft[i], candyRight[i]);
        }
        System.out.println(Arrays.toString(candyRight));

        return res + ratings.length;

    }
    public static int candy(int[] ratings) {
        // 贪心算法
        // 满足规则：
        // 规则定义： 设学生 A 和学生 B 左右相邻，A 在 B 左边；
        // 左规则：当 ratings[i−1]<ratings[i] 时，i 号学生的糖果数量将比 i - 1号孩子的糖果数量多。
        // 右规则：当 ratings[i]>ratings[i+1] 时，i 号学生的糖果数量将比 i + 1号孩子的糖果数量多。
        // 先从左到右遍历
        // 再从右往左遍历
        // 取最后两次遍历最大值就能满足左右规则
        int len = ratings.length;
        if (len == 0){
            return 0;
        }

        if (len == 1){
            return 1;
        }

        int candyLeft[] = new int[len];
        // 从左向右遍历
        for (int i = 1; i <len;i ++){
            if (ratings[i] > ratings[i - 1]){
                candyLeft[i] = candyLeft[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(candyLeft));

        int res = candyLeft[len - 1];
        int right = 0;
        // 从右往左遍历
        for (int i = len - 2; i >= 0;i --){
            if (ratings[i] > ratings[i + 1]){
                right += 1;
            }else {
                right = 0;
            }
            System.out.print(right + " ");
            res += Math.max(candyLeft[i], right);
        }

        return res + ratings.length;

    }
}
