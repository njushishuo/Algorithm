package string;

/**
 * https://leetcode.com/problems/add-binary/description/
 */
public class AddBinary {


    public static void main(String args[]){
        AddBinary addBinary = new AddBinary();
        String a = "1010";
        String b = "1011";

        System.out.println(addBinary.addBinary(a,b));
    }


    public String addBinary(String a, String b) {
        if(a == null || a.length()==0){
            return b;
        }

        if(b == null || b.length()==0){
            return a;
        }

        if(a.length() < b.length()){
            String temp = a;
            a = b;
            b = temp;
        }

        StringBuilder builder = new StringBuilder();

        int i = a.length()-1 , j = b.length()-1;
        int add = 0;
        while(i>=0 && j>=0){
            int a1 = a.charAt(i)-'0';
            int a2 = b.charAt(j)-'0';
            int temp = a1+a2+add;
            add = temp/2;
            temp = temp%2;
            builder.insert(0,temp);
            i--;
            j--;
        }

        while( i>=0 ){
            int a1 = a.charAt(i)-'0';
            int temp = a1+add;
            add = temp/2;
            temp = temp%2;
            builder.insert(0,temp);
            i--;
        }

        if(add > 0){
            builder.insert(0,'1');
        }

        return builder.toString();
    }

}
