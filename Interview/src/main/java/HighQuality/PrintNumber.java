package HighQuality;

/**
 * Created by ss14 on 2017/5/3.
 * 输入n
 * 要求打印从0到 n位的最大数
 * 例如输入2,则要打印
 * 0 1 2 3 ...99
 *
 */
public class PrintNumber {
    public void printOneToMaxNDigits(int n){
        if(n<=0){
            return;
        }

        char [] number= new char[n];
        printOneToMaxNDigitsRecursively(0,number);
    }
    /**
     *采用递归的方式实现0-999的枚举
     * @param index  当前需要赋值的下标
     * @param number 待赋值的char数组
     */
    private void printOneToMaxNDigitsRecursively(int index ,char[] number) {
        if(index > number.length-1){
            printNumber(number);
            return;
        }
        for(int i=0;i<=9;i++){
            number[index]= (char) (i+'0');
            printOneToMaxNDigitsRecursively(index+1,number);
        }
    }
    public void printNumber(char [] number){
        int i=0;
        while(i<number.length && number[i]=='0'){
            i++;
        }
        if(i==number.length){
            System.out.print("0 ");
            return;
        }
        while(i<number.length){
            System.out.print(number[i]);
            i++;
        }
        System.out.print(" ");
    }
}
