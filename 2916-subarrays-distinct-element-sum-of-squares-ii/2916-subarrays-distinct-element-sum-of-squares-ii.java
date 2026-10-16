class Solution {
    private static final int MOD = 1_000_000_007;

    static class SegmentTree {
        int n;
        long[] treeSum;
        long[] treeSqSum;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            this.treeSum = new long[4 * n];
            this.treeSqSum = new long[4 * n];
            this.lazy = new long[4 * n];
        }

        private void apply(int node, int l, int r, long val) {
            val %= MOD;
            long len = r - l + 1;
            
            // new_sq = old_sq + 2 * val * old_sum + val^2 * len
            long term1 = treeSqSum[node];
            long term2 = (2 * val % MOD) * treeSum[node] % MOD;
            long term3 = (val * val % MOD) * len % MOD;
            treeSqSum[node] = (term1 + term2 + term3) % MOD;

            // new_sum = old_sum + val * len
            treeSum[node] = (treeSum[node] + val * len) % MOD;

            lazy[node] = (lazy[node] + val) % MOD;
        }

        private void pushDown(int node, int l, int r) {
            if (lazy[node] != 0) {
                int mid = l + (r - l) / 2;
                apply(2 * node, l, mid, lazy[node]);
                apply(2 * node + 1, mid + 1, r, lazy[node]);
                lazy[node] = 0;
            }
        }

        private void pushUp(int node) {
            treeSum[node] = (treeSum[2 * node] + treeSum[2 * node + 1]) % MOD;
            treeSqSum[node] = (treeSqSum[2 * node] + treeSqSum[2 * node + 1]) % MOD;
        }

        public void update(int node, int l, int r, int ql, int qr, int val) {
            if (ql <= l && r <= qr) {
                apply(node, l, r, val);
                return;
            }
            pushDown(node, l, r);
            int mid = l + (r - l) / 2;
            if (ql <= mid) {
                update(2 * node, l, mid, ql, qr, val);
            }
            if (qr > mid) {
                update(2 * node + 1, mid + 1, r, ql, qr, val);
            }
            pushUp(node);
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);
        Map<Integer, Integer> lastPos = new HashMap<>();
        
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            int prev = lastPos.getOrDefault(nums[i], -1);
            
            // Add 1 to range [prev + 1, i]
            st.update(1, 0, n - 1, prev + 1, i, 1);
            
            // treeSqSum[1] stores the sum of squares of distinct counts for all subarrays ending at index i
            totalSum = (totalSum + st.treeSqSum[1]) % MOD;
            
            lastPos.put(nums[i], i);
        }

        return (int) totalSum;
    }
}