package back_tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by ss14 on 2017/11/21.
 */
public class Sudoku {

    private final HashSet<Integer> fullSet;
    private List<int [][]> result;
    private int [][] a;
    private int [][] copy;
    private int m,n;
    private final int size = 9;


    public static void main(String args[]){
        Sudoku sudoku = new Sudoku();
        int [][] input = {
                {5,0,3,0,6,0,0,7,0},
                {4,6,7,2,0,9,1,3,0},
                {1,0,8,0,0,0,0,6,0},
                {8,0,9,6,2,0,3,0,7},
                {0,1,2,9,0,0,8,4,6},
                {0,0,6,0,0,8,2,0,9},
                {9,7,4,0,0,0,6,2,3},
                {6,8,5,4,3,2,7,9,1},
                {2,3,1,7,9,6,5,8,4}
        };

        int [][] input1 = {
                {0,5,0,0,2,0,0,0,0},
                {8,0,0,0,7,0,0,4,5},
                {0,2,7,0,5,0,9,0,3},
                {0,0,1,0,3,0,5,9,0},
                {5,0,0,6,0,1,0,3,0},
                {0,3,4,0,9,0,1,0,0},
                {7,0,5,0,6,0,3,8,0},
                {0,6,0,0,0,0,0,0,7},
                {0,0,0,0,1,0,0,5,0},

        };

        int [][] input2 = {
                {8,0,0,0,0,0,0,0,0},
                {0,0,3,6,0,0,0,0,0},
                {0,7,0,0,9,0,2,0,0},
                {0,5,0,0,0,7,0,0,0},
                {0,0,0,0,4,5,7,0,0},
                {0,0,0,1,0,0,0,3,0},
                {0,0,1,0,0,0,0,6,8},
                {0,0,8,5,0,0,0,1,0},
                {0,9,0,0,0,0,4,0,0}

        };
        List<int [][]> result = sudoku.solve(input2);
        for(int i = 0; i < result.size();i++){
            System.out.println("solution "+(i+1)+":");
            sudoku.prettyPrint(result.get(i));
        }
    }



    public Sudoku(){
        this.fullSet = new HashSet<>();
        for(int i = 1; i <= size; i++ ){
            this.fullSet.add(i);
        }
        this.result = new ArrayList<>();
    }

    public List<int [][]> solve(int [][]a){
        this.a = a;
        this.copy = a.clone();
        this.m =  a.length;
        this.n = a[0].length;
        backTracking(0);
        return  this.result;
    }

    private void backTracking(int index){
        if(index >= m*n){
            if(this.checkValid(a)){
                //this.prettyPrint(this.a);
                this.result.add(this.deepCopy(this.a));
            }
            return;
        }

        int i = index/size;
        int j = index - (index/size)*size;
        if(this.a[i][j] != 0){
            backTracking(index+1);
        }else{
            Integer [] choices = this.getChoice(i ,j);
            if(choices == null){
                return;
            }

            for(int k = 0; k < choices.length; k++){

                this.a[i][j] = choices[k];
                //System.out.println("set a["+i+"]["+j+"] = "+choices[k]);
                backTracking(index+1);
                this.a[i][j] = 0;
                //System.out.println("set a["+i+"]["+j+"] = "+0);
            }
        }
    }

    private Integer[] getChoice(int i , int j){

        HashSet<Integer> horizonal = new HashSet<>();
        HashSet<Integer> horizonalCan = new HashSet<>();
        HashSet<Integer> vertical = new HashSet<>();
        HashSet<Integer> verticalCan = new HashSet<>();
        HashSet<Integer> square = new HashSet<>();
        HashSet<Integer> squareCan = new HashSet<>();

        for(int k = 0; k < n; k++){
            if(a[i][k] != 0){
                horizonal.add(a[i][k]);
            }
        }
        horizonalCan = this.getCandidate(horizonal);
        if(horizonalCan.size() == 0){
            return null;
        }


        for(int k = 0; k < m; k++){
            if(a[k][j] != 0){
                vertical.add(a[k][j]);
            }
        }
        verticalCan = this.getCandidate(vertical);
        if(verticalCan.size() == 0){
            return null;
        }

        int topLeftH = (i/3)*3;
        int topLeftV = (j/3)*3;
        for(int k = topLeftH; k <= topLeftH+2; k++){
            for(int l = topLeftV; l <= topLeftV+2; l++){
                if(a[k][l] != 0){
                    square.add(a[k][l]);
                }
            }
        }
        squareCan = this.getCandidate(square);
        if(squareCan.size() == 0){
            return null;
        }

        HashSet<Integer> joinSet = this.join(horizonalCan,verticalCan);
        joinSet = this.join(joinSet,squareCan);

        if(joinSet.size() == 0){
            return null;
        }

        Integer [] result = new Integer [joinSet.size()];
        return joinSet.toArray(result);
    }


    private HashSet<Integer> getCandidate(HashSet<Integer> input){
        HashSet<Integer> candidate = new HashSet<>();
        for(Integer item : fullSet){
          if(!input.contains(item)){
              candidate.add(item);
          }
        }
        return candidate;
    }

    private HashSet<Integer> join(HashSet<Integer> a , HashSet<Integer> b){
        HashSet<Integer> joinSet = new HashSet<>();
        for(Integer item : a){
            if(b.contains(item)){
                joinSet.add(item);
            }
        }
        return joinSet;
    }

    private int [][] deepCopy(int [][]a){
        int [][] b = new int [a.length][a[0].length];
        for(int i =0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++) {
                b[i][j] = a[i][j];
            }
        }
        return b;
    }

    private void prettyPrint(int [][] a){
        for(int i =0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+", ");
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

    private boolean checkRow(int [][]a , int i){
        HashSet<Integer> set = new HashSet<>();
        for(int j = 0; j < a[0].length ; j++ ){
            set.add(a[i][j]);
        }
        return set.size() == size;
    }

    private boolean checkColumn(int [][]a , int j){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < a.length ; i++ ){
            set.add(a[i][j]);
        }
        return set.size() == size;
    }

    private boolean checkSquare(int [][]a, int i, int j){
        HashSet<Integer> set = new HashSet<>();
        for(int k = i; k <= i+2 ; k++ ){
            for(int l = j; l <= j+2; l++){
                set.add(a[k][l]);
            }
        }
        return set.size() == size;
    }

    private boolean checkValid(int [][]a){
        for(int i = 0;i < size; i++){
            if(!(checkRow(a,i)&&checkColumn(a,i))){
                return false;
            }
        }

        for(int i = 0; i < size; i+=3){
            for(int j = 0; j < size; j+=3 ){
                if(!checkSquare(a,i,j)){
                    return false;
                }
            }
        }
        return true;
    }

}
