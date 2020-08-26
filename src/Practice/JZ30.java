package Practice;
//连续子数组的最大和
//题目描述
//给一个数组，返回它的最大连续子序列的和。
//知识点：动态规划
//思路：
public class JZ30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null||array.length==0)
            return 0;
        int dp[] = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = array[i] + dp[i-1];
            if (dp[i] < array[i])
                dp[i] = array[i];
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
        /*空间复杂度0(1)
        if (array==null||array.length==0)
            return 0;
        int dp = array[0];
        int max = dp;
        for (int i = 1; i < array.length; i++) {
            dp += array[i];
            if (dp < array[i])
                dp = array[i];
            if (dp > max)
                max = dp;
        }
        return max;
        */
    }
}
