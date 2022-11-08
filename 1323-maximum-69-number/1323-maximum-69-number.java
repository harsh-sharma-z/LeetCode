class Solution {
    public int maximum69Number (int num) {
        String s=new String(num+"");
        s=s.replaceFirst("[6]","9");
        return Integer.parseInt(s);
    }
}