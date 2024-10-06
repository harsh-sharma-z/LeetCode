class Solution {
    private String[] splitIntoWords(String sentence) {
        return sentence.split(" ");
    }
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = splitIntoWords(sentence1);
        String[] words2 = splitIntoWords(sentence2);

        if(words1.length < words2.length) {
            String[] temp = words1;
            words1 = words2;
            words2 = temp;
        }

        int begin = 0 , end = 0;
        int n1 = words1.length , n2 = words2.length;

        while(begin < n2 && words1[begin].equals(words2[begin])) {
            begin++;
        }

        while(end < n2 && words1[n1 - end - 1].equals(words2[n2 - end - 1])) {
            end++;
        }

        return begin + end >= n2;
    }
}