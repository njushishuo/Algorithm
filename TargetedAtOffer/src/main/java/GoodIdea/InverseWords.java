package GoodIdea;

/**
 * Created by ss14 on 2017/5/18.
 * 输入: String 是一个英文句子
 * 输出: 打印 反转字符串中所有单词的顺序后的结果
 * 例:  I am a man.
 *      man. a am I
 */
public class InverseWords {


    public void inverseWords(String sentence){

        if(sentence==null|sentence.length()==0){
            return;
        }

        char[] array = sentence.toCharArray();
        inverse(array,0,array.length-1);

        int start=0;
        int end=0;

//        for(int i=0;i<array.length;i++){
//
//            if(array[start]==' '){
//                start++;
//                end++;
//            }else if(array[i]==' '){
//                end=i-1;
//                inverse(array,start,end);
//                start=i+1;
//            }else{
//                end++;
//            }
//        }

        int i=0;
        while(i<array.length){

            while(i<array.length&&array[i]==' '){
                i++;
            }
            start = i;
            while(i<array.length&&array[i]!=' '){
                i++;
            }
            end = i-1;
            inverse(array,start,end);
        }

        printArray(array);

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
