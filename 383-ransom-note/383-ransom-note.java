class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character,Integer> uwu= new HashMap<>();
        
        for(int i=0;i<magazine.length();i++)
        {
            if(uwu.containsKey(magazine.charAt(i)))
            {
                uwu.put(magazine.charAt(i),uwu.get(magazine.charAt(i))+1);
            }
            else      
                uwu.put(magazine.charAt(i),1);

        }
        
        for(int i=0;i<ransomNote.length();i++)
        {
            
            
            if(uwu.containsKey(ransomNote.charAt(i)))
            {         
 if(uwu.get(ransomNote.charAt(i))>0)               uwu.put(ransomNote.charAt(i),uwu.get(ransomNote.charAt(i))-1);
                else
                    return false;
                
            }
            else
                return false;
            
        }
        
        return true;
        
        
    }
}