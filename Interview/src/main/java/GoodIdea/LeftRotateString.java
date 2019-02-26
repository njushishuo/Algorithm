package GoodIdea;

/**
 * Created by ss14 on 2017/5/18.
 *
 * 输入: String a;  int m;
 * 输出：打印 将字符串左旋转m位之后的结果
 * 例如:  abcde 2     abcde 3
 *       cdeab        deabc
 *       deabc        cdeab
 * 思路： 我们观察左旋转的实质：例如做旋转2位
 *       其实就是把数组的前两位放到数组的末尾，然后把剩下的元素向左移动2位
 *       更像是 "ab"与"cde"交换了位置
 *       如果我们把数字全部反转呢？
 *       edcba 我们发现左半部分ab的位置变为右边；右半部分cde出现在了左边
 *       与我们想要的结果的差距在于，左右两个部分内部也被反转了。
 */
public class LeftRotateString {


    public void leftRotateString (String input , int m){

        if(input==null||input.length()==0){
            return;
        }

        if(m>=input.length()){
            m%=input.length();
        }

        char [] chars = input.toCharArray();
        inverse(chars,0,chars.length-1);
        inverse(chars,0, (chars.length-m-1));
        inverse(chars,chars.length-m,chars.length-1);
        printArray(chars);
    }



    private void inverse(char [] sentence, int begin , int end  ){

        int i=begin;
        int j=end;

        while(i<j){
            char temp = sentence[i];
            sentence[i] = sentence[j];
            sentence[j] = temp;
            i++;
            j--;

        }
    }


    private  void printArray(char [] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
        }
        System.out.print('\n');
    }
}
