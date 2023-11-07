class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        for(int i = 0 ; i < dist.length ; i++){
            dist[i] = (int)(Math.ceil((double)dist[i] / (double)speed[i]));
        }
        Arrays.sort(dist);
        int c = 0;
        for(int i = 0 ; i < dist.length ; i++){
            if(dist[i] - i > 0){
                c++;
            }
            else{
                break;
            }
        }
        return c;
    }
}