class Solution(object):
    def maxSum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        MOD = 10**9 + 7
        
        # Step 1: Count total set bits at each position (0 to 30)
        bit_counts = [0] * 31
        for num in nums:
            for i in range(31):
                if (num >> i) & 1:
                    bit_counts[i] += 1
        
        # Step 2: Form the k largest possible numbers and sum their squares
        total_sum_squares = 0
        for _ in range(k):
            current_num = 0
            for i in range(31):
                if bit_counts[i] > 0:
                    current_num |= (1 << i)
                    bit_counts[i] -= 1
            
            # Step 3: Add to total sum modulo 10^9 + 7
            total_sum_squares = (total_sum_squares + current_num * current_num) % MOD
            
        return total_sum_squares
