package GoodIdea;

/**
 * Created by ss14 on 2017/5/12.
 * 顺时针打印二维数组
 */
public class ArrayClock {

    public void printArrayInClockWise(int [][] a){
        int rows = a.length;
        int columns = a[0].length;
        int min = Math.min(rows,columns);
        int loop = min/2;
        if(min%2==1){
            loop++;
        }
        for(int i=0;i<loop;i++){

            int endX = columns-i-1;
            int endY = rows-i-1;

            //left->right
            for(int j=i; j<=endX; j++){
                System.out.print(a[i][j]+" ");
            }

            //up->down
            if(i<endY){
                for(int j=i+1;j<=endY;j++){
                    System.out.print(a[j][endX]+" ");
                }
            }else{
                break;
            }

            //right->left
            if(i<endX){
                for(int j=endX-1; j>=i ;j--){
                    System.out.print(a[endY][j]+" ");
                }
            }

            //down->up
            if(i+1<endY){
                for(int j=endY-1; j>i;j--){
                    System.out.print(a[j][i]+" ");
                }
            }
        }
        System.out.print('\n');



    }


}
