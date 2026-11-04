import java.util.*;

class Solution {
    int m;
    long[] bc, bs;

    void upd(int i, int c, long v) {
        for (; i <= m; i += i & -i) { bc[i] += c; bs[i] += v; }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] vals = new int[n + 1];
        m = 0;
        for (int i = 0; i < n; i++)
            if (i == 0 || sorted[i] != sorted[i - 1]) vals[++m] = sorted[i];

        int[] rk = new int[n];
        for (int i = 0; i < n; i++) rk[i] = Arrays.binarySearch(vals, 1, m + 1, nums[i]);

        bc = new long[m + 1];
        bs = new long[m + 1];
        int[] cntAt = new int[m + 1];
        int LOG = 32 - Integer.numberOfLeadingZeros(m);
        int need = (x + 1) / 2;
        long tot = 0;

        for (int i = 0; i < x; i++) {
            upd(rk[i], 1, nums[i]); cntAt[rk[i]]++; tot += nums[i];
        }

        long[] cost = new long[n - x + 1];
        for (int s = 0; s + x <= n; s++) {
            int pos = 0, kk = need;
            long accC = 0, accS = 0;
            for (int b = LOG; b >= 0; b--) {
                int np = pos + (1 << b);
                if (np <= m && bc[np] < kk) {
                    pos = np; kk -= bc[np]; accC += bc[np]; accS += bs[np];
                }
            }
            int p = pos + 1;
            long med = vals[p];
            long cntLE = accC + cntAt[p];
            long sumLE = accS + cntAt[p] * med;
            cost[s] = med * cntLE - sumLE + (tot - sumLE) - med * (x - cntLE);

            upd(rk[s], -1, -nums[s]); cntAt[rk[s]]--; tot -= nums[s];
            if (s + x < n) {
                upd(rk[s + x], 1, nums[s + x]); cntAt[rk[s + x]]++; tot += nums[s + x];
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];
        for (int j = 1; j <= k; j++) {
            long[] cur = new long[n + 1];
            Arrays.fill(cur, INF);
            for (int i = x; i <= n; i++) {
                long best = cur[i - 1];
                if (prev[i - x] < INF) best = Math.min(best, prev[i - x] + cost[i - x]);
                cur[i] = best;
            }
            prev = cur;
        }
        return prev[n];
    }
}