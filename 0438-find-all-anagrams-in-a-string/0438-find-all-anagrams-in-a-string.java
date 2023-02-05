class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> uwu=new ArrayList<>();
        int hash[]=new int[26];
        int phash[]=new int[26];
        int window=p.length();
        int len=s.length();
        if(window>len)
            return uwu;
        for(int i=0;i<window;i++){
				hash[s.charAt(i)-'a']++;
			    phash[p.charAt(i)-'a']++;
			}
			for(int i=0;i<=len-window;i++){
			    if(isSame(hash,phash)){
                    uwu.add(i);
                }
				hash[s.charAt(i)-'a']--;
				if(i+window < len){
                    hash[s.charAt(i+window)-'a']++;
                }
			}
			return uwu;
    }
    public boolean isSame(int[] a,int[] b)
    {
        for(int i=0;i<26;i++) if(a[i]!=b[i]) return false;
        return true;
    }
}