class Solution {
    public boolean isPowerOfFour(int n) {
        // AAJ aap log seekhoge power of four nikalna
        // bkl diwakar dekhle seekhle placement hojayega

        //Pehle m krnga loop vale logic se
         
         /*
        if(n == 0) 
            return false;
        while(n % 4 == 0)
            n /= 4;
        return n == 1;
        */
        
        // lekin ye upar vala logic jhantu hai to ab him ise krnge log n vale logic se

        /*
        if(n <=0 )
            return false;
        int x = (int)(Math.log(n) / Math.log(4));
        return Math.pow(4 , x) == n;
        */


        //Pr agar tjhe interviewer ki kachhi geeli krni h to krna padega bit-magic

        if(n <= 0) 
            return false;
        return (((n &(n - 1)) == 0) && ((n - 1) % 3 == 0));


    }
}