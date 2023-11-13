class Solution {
    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
    public String sortVowels(String s) {
        Map<Character , Integer> map = new HashMap<>();

        for(char ch : s.toCharArray())
            if(isVowel(ch))
                map.put(ch , map.getOrDefault(ch , 0) + 1);

        String vowels = "AEIOUaeiou";
        int j = 0;

        char res[] = s.toCharArray();

        for(int i = 0 ; i < s.length() ; i++){
            if(isVowel(s.charAt(i))){
                while(map.getOrDefault(vowels.charAt(j) , 0 ) == 0)
                    j++;

                res[i] = vowels.charAt(j);

                map.put(vowels.charAt(j) , map.get(vowels.charAt(j)) - 1);
            }
        }

        return new String(res);
        
    }
}