class Solution {
    static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);
        HashMap<Integer, Integer> last = new HashMap<>();
        long result = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = last.getOrDefault(x, 0);

            // Increase distinct counts for subarrays
            // starting after the previous occurrence.
            st.update(prev, i, 1);

            // Sum of squared distinct counts for subarrays
            // ending at index i.
            result = (result + st.query(0, i)) % MOD;

            last.put(x, i + 1);
        }

        return (int) result;
    }

    class SegmentTree {
        int n;
        long[] sum;
        long[] lazy;
        long[] sumSq;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void update(int l, int r, long val) {
            update(1, 0, n - 1, l, r, val);
        }

        void update(int node, int start, int end,
                    int l, int r, long val) {
            if (l > end || r < start)
                return;

            if (l <= start && end <= r) {
                long len = end - start + 1;
                sumSq[node] = (sumSq[node]
                        + 2 * val % MOD * sum[node] % MOD
                        + len * val % MOD * val % MOD) % MOD;

                sum[node] = (sum[node] + len * val) % MOD;
                lazy[node] += val;
                return;
            }

            push(node, start, end);

            int mid = (start + end) / 2;
            update(node * 2, start, mid, l, r, val);
            update(node * 2 + 1, mid + 1, end, l, r, val);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sumSq[node] = (sumSq[node * 2]
                    + sumSq[node * 2 + 1]) % MOD;
        }

        void push(int node, int start, int end) {
            if (lazy[node] == 0 || start == end)
                return;

            int mid = (start + end) / 2;
            apply(node * 2, start, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, end, lazy[node]);
            lazy[node] = 0;
        }

        void apply(int node, int start, int end, long val) {
            long len = end - start + 1;

            sumSq[node] = (sumSq[node]
                    + 2 * val % MOD * sum[node] % MOD
                    + len * val % MOD * val % MOD) % MOD;

            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] += val;
        }

        long query(int l, int r) {
            return query(1, 0, n - 1, l, r);
        }

        long query(int node, int start, int end, int l, int r) {
            if (l > end || r < start)
                return 0;

            if (l <= start && end <= r)
                return sumSq[node];

            push(node, start, end);

            int mid = (start + end) / 2;
            return (query(node * 2, start, mid, l, r)
                    + query(node * 2 + 1, mid + 1, end, l, r)) % MOD;
        }
    }
}