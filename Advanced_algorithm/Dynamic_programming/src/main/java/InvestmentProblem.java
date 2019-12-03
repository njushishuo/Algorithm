public class InvestmentProblem{

    /**
     * Profit [i][j] = m :  the profit for invest i dollar for project j; where i:[0,m] j:[0,n]
     * notice: for each project you can invest at most m dollars, that is you can invest [0,m] dollars for a project
     */
    public static int findMaxOutput(int [][] P , int m , int n, int money ){
        if(money > m | money < 0){
            return -1;
        }

        int [][] M = new int [m+1][n+1];
        for(int i=0; i<=m ; i++){
            M[i][0] = 0;
        }

        for(int i=0; i<=n; i++){
            M[0][i] = 0;
        }

        // consider project: 1,2,,,i<=n
        for(int i=1; i<=n; i++){
            // invest money: 1,2,,,j<=m
            for(int j=1; j<=m; j++){
                int temp = 0;
                for(int k=0; k<=j; k++){
                    temp = M[j-k][i-1] + P[k][i];
                    if(temp > M[j][i])
                        M[j][i] = temp;
                }
            }
        }

        return M[money][n];
    }

    public static void main(String args[]){
        int [][] P = {
            {0,0,0,0,0},{0,11,0,2,20},{0,12,5,10,21},{0,13,10,30,22},{0,14,15,32,23},{0,15,20,40,24}
        };
        for(int i=0; i<=5 ; i++){
            System.out.println( findMaxOutput(P,5,4,i));
        }
    }


}