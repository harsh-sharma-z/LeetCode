class Solution {
    public List<List<String>> partition(String s) {
        List<String> uwu=new ArrayList<>();
         List<List<String>> onichan=new ArrayList<>();
        partitioning(s,uwu,onichan);
        return onichan;
    }
    public static void partitioning(String s,List<String> uwu,List<List<String>> onichan)
    {
        if(s.length()==0)
        {
            //System.out.println(uwu);
            //uwu.add(ans);
            onichan.add(new ArrayList<>(uwu));
            return;
        }

        for(int cut=1;cut<=s.length();cut++) {
            String temp = s.substring(0, cut);
            if (isPalin(temp)) {
                uwu.add(temp);
                partitioning(s.substring(cut), uwu,onichan);
                uwu.remove(uwu.size()-1);
            }
        }
    }

    public static boolean isPalin(String temp)
    {
        int i=0;
        int j= temp.length()-1;

        while(i<j)
        {
            if(temp.charAt(i)!=temp.charAt(j))
                return false;
            i++;
            j--;

        }

        return true;
    }
}