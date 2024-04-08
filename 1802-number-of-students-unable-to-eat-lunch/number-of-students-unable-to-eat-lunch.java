class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ones = 0;
        int zeros = 0;

        for(int s : students){
            if(s == 0){
                zeros++;
            }
            else{
                ones++;
            }
        }

        for(int s : sandwiches){
            if(s == 0){
                if(zeros == 0){
                    return ones;
                }
                zeros--;
            }
            else{
                if(ones == 0){
                    return zeros;
                }
                ones--;
            }
        }
        return 0;
    }
}