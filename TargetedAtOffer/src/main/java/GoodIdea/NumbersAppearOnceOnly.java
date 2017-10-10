package GoodIdea;

/**
 * Created by ss14 on 2017/5/17.
 * 输入： int [] a 数组中只有两个数字只出现了一次，而其他数字全都出现了两次；
 * 输出:  打印那些只出现一次的数字
 * 要求： 时间复杂度为O(n) 空间复杂度为O(1)
 *
 * 思路： 首先考虑,整个数组中只有一个数字只出现了一次的情况,我们如何找出这个数字呢？
 * 有没有什么方式，可以“抵消”掉两个相同的数字，从而只剩下那个只出现一次的数字呢？
 * ^有的，异或操作； 对相同的数字做异或操作，结果为0；如果我们对整个数组的所有数字依次做异或操作，结果就等于剩下的数字
 * a^b^a =b ;  a^b^c = a^(b^c)=(a^b)^c
 *
 * 那么我们再考虑有两个只出现一次的数字的情况， 有没有办法把问题拆解成只有一个数字的情况呢？
 * 加入我们对输入进行异或，结果就等于那两个只出现一次的数字(假设为mn)异或的结果即 m^n
 * 如果我们可以按照一个标准将所有数字分开就好了。
 * 按照什么标准划分呢？
 * m^n这个结果本身就提供了线索，我们可以找到m^n中最低位的1的位置，然后以这个位置取0还是取1来划分数组；
 * 首先m和n一定被划分到不同的部分中去了；接下来所有的数字都出现了两次，同一个数字一定会被分到同一个部分；问题也就被拆解了
 *
 */
public class NumbersAppearOnceOnly {

    public void printNumbersAppearOnceOnly(int [] a){

        //计算 m^n
        int result =0;
        for(int i=0;i<a.length;i++){
            result^=a[i];
        }

        //计算tem,满足tem的第i位为1,其中i是m^n中1出现的最低位
        int tem=1;
        while( (result&tem)==0){
            tem=tem<<1;
        }

        //对于任意一个数a，如果i位是0，则a&tem=0; 否则的话 a&tem =tem;
        //注意当i位是1时，a&tem的结果是tem而不一定是简单的1
        int first = findNumberWithBit(a,tem,0);
        int second = findNumberWithBit(a,tem,tem);

        System.out.println(first+" "+second);
    }

    private int findNumberWithBit(int [] a , int tem , int target){

        int result=0;
        for(int i=0;i<a.length;i++){
            if((a[i]&tem)==target){
                result^=a[i];
            }
        }
        return result;
    }



}
