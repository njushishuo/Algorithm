package tree;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * 前置思路：
 * 给定了1-n这么多的自然数，我们需要来构造BST，事实上可能的BST可以分为n类，每类都以i为根节点(1<= i <= n)， 1-i全部被划分到左子树 ， (i+1) - n 全部被划分到右子树；
 * 并且，每一个可能的构造都是唯一的；e.g. 213 231的问题将不存在；
 *
 * 动态规划：
 * G(n) 表示序列1-n可以构造的结构唯一的二叉搜索树的数量； F(i,n)表示以长度为n的递增序列中第i位置的数字为根节点可以构造的唯一的二叉树的数量
 * G(n) = F(1,n) + F(2,n) + ... + F(n-1, n) + F(n,n)
 *
 * 考虑 F (i,n) 的值等于 用1- (i-1)构造的唯一BST的数量 *  用(i+1) - n构造的唯一BST的数量
 * 即 F(i,n) = G(i-1) * G(n-i);
 * G(n) = G(0)*G(n-1) + G(1)*G(n-2) + ... + G(n-1 ,0)
 * G(0) = 1; G(1) = 1; 因为计算F(1,n)时，实际上就是计算G(n-1)，不能让0*G(n-1)
 *
 *
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int [n+1];
        dp[0] = dp[1] =1;

        for( int i = 2; i <= n; i++){
            for(int j = 1; j <= i ; j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }

        return dp[n];
    }


}
