class Solution {
     public boolean validUtf8(int[] data) {
         
        int c = 0;
         
        for (int i : data) {
            
            if (c == 0) {
                
                if (i >> 3 == 0b11110) {
                    c = 3;
                } 
                else 
                    if (i >> 4 == 0b1110) {
                    c = 2;
                } 
                else 
                    if (i >> 5 == 0b110) {
                    c = 1;
                } 
                else 
                    if (i >> 7 == 0b0) {
                    c = 0;
                } 
                else {
                    return false;
                }
            } 
            else {
                
                if (i >> 6 == 0b10) {
                    c--;
                } 
                else {
                    return false;
                }
            }
        }
       if(c==0)
           return true;
         return false;
    }
}