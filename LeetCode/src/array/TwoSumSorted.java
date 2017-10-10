package array;

public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {

        int i=0 , j= numbers.length-1;
        while(i<j){
            int temp = numbers[i]+numbers[j];
            if(temp > target){
                j--;
            }else if(temp < target){
                i++;
            }else{
                return new int[]{i+1,j+1};
            }
        }

        return new  int []{-1,-1};
    }
}
