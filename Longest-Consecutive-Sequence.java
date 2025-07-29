class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int i : nums)
            set.add(i);

        for(int n : set)
        {
            if(!set.contains(n - 1))
            {
                int m = n + 1;
                while(set.contains(m))
                    m++;
                max = Math.max(max, m - n);
            }
        }
        return max;
    }
}