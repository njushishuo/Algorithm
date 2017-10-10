/**
 * Created by ss14 on 2017/4/26.
 */


/**
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
 * 测试样例：
 * "abc",3,"adc",3,5,3,100
 * 返回：8
 */
public class MinimalCost {

    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        // 设d[i][j]为将字符串A的1~i位和B的1~j位变为相同时的操作代价
        // 注意题目是：A串变为B串 而不是将两个字符串变为相等
        // d[i][j] = d[i-1][j-1]， 如果A[i] = A[j]
        // 否则可以：
        // 1.A的末端插入B的最后一位
        // 2.删除A的末端
        // 3.修改A的末端为B的末端
        int[][] d = new int[n + 1][m + 1];
        // 初始化d[i][0] = i*删除代价
        for (int i = 0; i <= n; i++) {
            d[i][0] = i * c1;
        }
        // 初始化d[0][j] = j*插入代价
        for (int j = 0; j <= m; j++) {
            d[0][j] = j * c0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    int cost1 = d[i][j - 1] + c0;// 插入时的代价
                    int cost2 = d[i - 1][j] + c1;// 删除的代价
                    int cost3 = d[i - 1][j - 1] + c2;//修改的代价
                    d[i][j] = Math.min(cost1, Math.min(cost2, cost3));
                }
            }
        }
        return d[n][m];
    }


}
