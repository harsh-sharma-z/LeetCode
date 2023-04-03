class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int c=0;
        Arrays.sort(people);
        int l=0,r=people.length-1;
        while(l<=r)
        {
            int sum=people[l]+people[r];
            if(sum<=limit)
            {
                l++;
                r--;
                c++;
            }
            else
            {
                c++;
                r--;
            }
        }
        return c;
    }
}