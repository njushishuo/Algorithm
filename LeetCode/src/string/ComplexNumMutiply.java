package string;

import list.InsertSort;

/**
 *https://leetcode.com/problems/complex-number-multiplication/description/
 */
public class ComplexNumMutiply {



    public String complexNumberMultiply(String input1, String input2) {
        int a=0,b=0,c=0,d=0,e,f;

        input1 = this.prePare(input1);
        input2 = this.prePare(input2);
        String [] temp1 = input1.split("\\+");
        String [] temp2 = input2.split("\\+");
        for(int i=0;i<temp1.length;i++){
            //不包含
            if(temp1[i].indexOf("i")==-1){
                a = Integer.parseInt(temp1[i]);
            }else{
                b = Integer.parseInt(temp1[i].substring(0,temp1[i].length()));
            }
        }

        for(int i=0;i<temp2.length;i++){
            //不包含
            if(temp1[i].indexOf("i")==-1){
                c = Integer.parseInt(temp2[i]);
            }else{
                d = Integer.parseInt(temp2[i].substring(0,temp2[i].length()));
            }
        }

        e = a*c - b*d;
        f = a*d + b*c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e+"");
        stringBuilder.append("+");
        stringBuilder.append(f+"");
        stringBuilder.append("i");
        return stringBuilder.toString();

    }

    public String prePare(String a) {
        if(a.indexOf("+")==-1){

            if(a.indexOf("i")==-1){
                return a+ "0i";
            }else{
                return "0"+a;
            }
        }else{
            return a;
        }
    }
}
