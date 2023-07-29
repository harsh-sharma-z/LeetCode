class Solution {
    public double soupServings(int n) {
        if(n >= 5000)
            return 1.0;
        double[][] dp = new double[n + 1][n + 1];
        for(double i[] : dp)
            Arrays.fill(i , -1.0);
        return probOfA(n , n , dp);
    }
    private int[][] serves = { {100 , 0} , {75 , 25} , {50 , 50} , {25 , 75} };
    private double probOfA(int A , int B , double[][] dp){
        if(A <= 0 && B <= 0)
            return 0.5;
        if(A <= 0)
            return 1.0;
        if(B <= 0)
            return 0.0;

        if(dp[A][B] != -1.0)
            return dp[A][B];
        
        double prob = 0.0;

        for(int i[] : serves){
            int takenA = i[0];
            int takenB = i[1];
            prob += probOfA(A - takenA , B - takenB , dp);
        }
        return dp[A][B] = 0.25 * prob;
    }
}