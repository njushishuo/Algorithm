package data_structure.BinaryTree;

/**
 * Created by ss14 on 2017/5/14.
 * 输入：int[] a
 * 输出: boolean 判断输入是否是一颗二叉搜索树的后序遍历序列
 * 思路： 后序即先访问左子女再访问右子女，最后访问当前节点。
 *  {5,7,6,9,11,10,8}  true;
 */
public class PostSeqOfBST {

    public static boolean isPostSeqOfBST(int a[] , int start, int end){
        if(a==null || start>end){
            System.err.println("error");
            return false;
        }

        int root = a[end];

        //找到右子数的开始下标i
        int i = start;
        while(i<end && a[i]<root){
            i++;
        }

        int j=i;
        //如果右子树中出现了比root小的元素，则判断false;
        while(j<end){
            if(a[j]<root){
                return false;
            }
            j++;
        }

        boolean left = true;
        //只有当存在左子树，即i被移动过，且子树至少有3个节点时才需要判断;该条件可以退化成i>start
        if(i>start+2){
            left = isPostSeqOfBST(a,start,i-1);
        }

        //该条件可以退化成j<end-1
        boolean right = true;
        if(i+2<end){
            right= isPostSeqOfBST(a,i,end-1);
        }


        return left&&right;

    }

}
