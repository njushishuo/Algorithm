package array;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *  nums1: size m;
 *  nums2: size n;
 *
 *  O(log min(m,n))
 *  Amazing solution: the point is to understand the meaning of median
 *
 *  Find i where :
 *    (1)len(left_part) == len(right_part)
 *    (2)max(left_part) <= min(right_part)
 *  That is :
 *    (1)i+j = m-1 + n-j ;    i+j = m-i + n-j + 1 (when m+n is odd)
 *        j = (m+n+1)/2 - i,  we need j>=0, therefore (m+n)>=2i>=2m  => n>=m;
 *        Since when m+n is even "+1" makes no difference ,so we can always make j = (m+n+1)/2 -i;
 *
 *    (2)B[j-1] <= A[i] && A[i-1] <= B[j]
 *  TODO:
 *   Searching i in [0, m], to find an object `i` that:
 *        B[j-1] <= A[i] and A[i-1] <= B[j], ( where j = (m + n + 1)/2 - i )
 *
 *   median = (max(left_part) + min(right_part))/2
 */
public class MedianOfTwoSortedArrays {


    public static void main(String arg[]){
        MedianOfTwoSortedArrays ma = new MedianOfTwoSortedArrays();
        int [] a = {1,3};
        int [] b = {2};
        System.out.println(ma.findMedianSortedArraysMy(a,b));


    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] A ,B;
        int m ,n;
        if(nums1.length <= nums2.length){
            A = nums1; m = nums1.length;
            B = nums2; n = nums2.length;
        }else{
            B = nums1; n = nums1.length;
            A = nums2; m = nums2.length;
        }

        if(n==0){
            return -1;
        }


        int Imin = 0; int Imax = m;
        int leftMax=0 , rightMin=0;

        while(Imin <= Imax){
            int i = (Imax+Imin)/2;
            int j = (m+n+1)/2 -i;
            // A[i] >= A[i-1] > B[j] >= B[j-1]  i>0 => j<n
            if(i>0 && A[i-1] > B[j]){
                Imax = i-1;
                // B[j] >= B[j-1] > A[i] >= A[i-1]  i<m => j>0
            }else if(i<m && B[j-1] > A[i]){
                Imin = i+1;
            }else{
                if(i==0){
                    leftMax = B[j-1];
                }else if(j==0){
                    leftMax = A[i-1];
                }else{
                    leftMax = Math.max(A[i-1],B[j-1]);
                }

                if((m+n)%2==1){
                    return leftMax;
                }


                if(i==m){
                    rightMin = B[j];
                }else if(j==n){
                    rightMin = A[i];
                }else{
                    rightMin = Math.min(A[i],B[j]);
                }
                return (leftMax+rightMin)/2.0;
            }
        }
        return (leftMax+rightMin)/2.0;
    }

    public double findMedianSortedArraysMy(int[] nums1, int[] nums2) {

        if(nums1.length==0){
            return findMedian(nums2);
        }

        if(nums2.length==0){
            return findMedian(nums1);
        }

        int [] A ,B;
        int m ,n;
        if(nums1.length <= nums2.length){
            A = nums1; m = nums1.length;
            B = nums2; n = nums2.length;
        }else{
            B = nums1; n = nums1.length;
            A = nums2; m = nums2.length;
        }

        int Imin = 0; int Imax = m;
        int leftMax=0 , rightMin=0;

        while(Imin <= Imax){
            int i = (Imax+Imin)/2;
            int j = (m+n+1)/2 -i;
            // A[i] >= A[i-1] > B[j] >= B[j-1]  i>0 => j<n
            if(i>0 && A[i-1] > B[j]){
                Imax = i-1;
                // B[j] >= B[j-1] > A[i] >= A[i-1]  i<m => j>0
            }else if(i<m && B[j-1] > A[i]){
                Imin = i+1;
            }else{

                if(i==0){
                    leftMax = B[j-1];
                    if(j == n){
                        rightMin = A[i];
                    }else{
                        rightMin = Math.min(A[i],B[j]);
                    }
                }else if(i==m) {
                    rightMin = B[j];
                    if (j == 0) {
                        leftMax = A[i - 1];
                    }else{
                        leftMax = Math.max(A[i - 1], B[j - 1]);
                    }
                }else{
                    rightMin = Math.min(A[i],B[j]);
                    leftMax = Math.max(A[i - 1], B[j - 1]);
                }

                if((m+n)%2==1){
                    return leftMax;
                }

                return (leftMax+rightMin)/2.0;
            }
        }
        return (leftMax+rightMin)/2.0;
    }


    private double findMedian(int [] nums){
        if(nums.length%2==0){
            int mid = nums.length/2-1;
            return (nums[mid]+nums[mid+1])/2.0;
        }else{
            int mid = nums.length/2;
            return nums[mid];
        }
    }
}
