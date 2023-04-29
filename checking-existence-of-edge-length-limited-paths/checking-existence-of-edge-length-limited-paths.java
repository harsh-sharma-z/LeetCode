class Solution {

    class UnionFind {
        private int[] group;
        private int[] rank;
        public UnionFind(int size) {
            rank = new int[size];
            group = new int[size];
            for(int i = 0; i < size; i++) {
                group[i] = i;
            }
        }

        public boolean areConnected(int n1, int n2) {
            int g1 = findGroup(n1);
            int g2 = findGroup(n2);
            return g1 == g2;
        }

        public void join(int n1, int n2) {
            int g1 = findGroup(n1);
            int g2 = findGroup(n2);
            // if already in the same group
            if(g1 == g2) return;

            if(rank[g1] > rank[g2]) group[g2] = g1;
            else if(rank[g2] > rank[g1]) group[g1] = g2;
            else {
                // choose one of the group and increase its rank
                group[g1] = g2;
                rank[g2]++;
            }
        }

        private int findGroup(int n) {
            if(group[n] != n) {
                // if n has been assigned to a different group
                // update n to its new group
                group[n] = findGroup(group[n]);
            }

            return group[n];
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // backup query index
        int queryCount = queries.length;
        int[][] queriesWithIndex = new int[queryCount][4];
        for(int i = 0; i < queryCount; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }
        
        sort(edgeList);
        sort(queriesWithIndex);

        boolean[] ans = new boolean[queryCount];
        int edgeIdx = 0;
        UnionFind uf = new UnionFind(n);

        for(int[] query : queriesWithIndex) {
            int start = query[0], end = query[1], limit = query[2], originalIdx = query[3];
            while(edgeIdx < edgeList.length && edgeList[edgeIdx][2] < limit) {
                uf.join(edgeList[edgeIdx][0], edgeList[edgeIdx][1]);
                edgeIdx++;
            }
            ans[originalIdx] = uf.areConnected(start, end);
        }

        return ans;
    }

    private void sort(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[2] - a2[2];
            }
        });
    }
}