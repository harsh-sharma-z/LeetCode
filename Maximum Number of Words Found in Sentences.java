class Solution {
    public int mostWordsFound(String[] sentences) {
        
        int length=sentences.length;
        int max=0;
        for(int i=0;i<length;i++)
        {
            String[] str=sentences[i].split(" ");
            
            if(str.length>max)
                max=str.length;
        }
        
        return max;
        
    }
}
