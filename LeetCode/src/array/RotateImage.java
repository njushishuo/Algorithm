package array;


/**
 * https://leetcode.com/problems/rotate-image/description/
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {


    public static void main(String args[]){
        int [][] matrix = new int [][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        RotateImage ri = new RotateImage();
        ri.rotate(matrix);
    }


    public void rotate(int[][] matrix) {

        int loop = matrix.length/2;
        int len = matrix.length;
        for( int i = 0; i < loop; i++){
            for( int j = i; j < len-i-1; j++){
                int save = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
                matrix[j][len-1-i] = save;
            }
        }
    }
}
