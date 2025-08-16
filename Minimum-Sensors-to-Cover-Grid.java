class Solution {
    public int minSensors(int n, int m, int k) {
        int temp = 2 * k + 1;

        int sn = (n + temp - 1) / temp;

        int sm = (m + temp - 1) / temp;

        return  sn * sm;
    }
}