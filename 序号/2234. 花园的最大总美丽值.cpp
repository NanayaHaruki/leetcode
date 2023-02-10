class Solution {

public:

    long long maximumBeauty(vector<int> &flowers, long long newFlowers, int target, int full, int partial) {

        sort(flowers.begin(), flowers.end());

        long n = flowers.size();

        if (flowers[0] >= target) return n * full; // 剪枝，此时所有花园都是完善的



        long leftFlowers = newFlowers - target * n; // 填充后缀后，剩余可以种植的花

        for (int i = 0; i < n; ++i) {

            flowers[i] = min(flowers[i], target); // 去掉多余的花

            leftFlowers += flowers[i]; // 补上已有的花

        }



        long ans = 0L, sumFlowers = 0L;

        for (int i = 0, x = 0; i <= n; ++i) { // 枚举后缀长度 n-i

            if (leftFlowers >= 0) {

                // 计算最长前缀的长度

                while (x < i && (long) flowers[x] * x - sumFlowers <= leftFlowers)

                    sumFlowers += flowers[x++]; // 注意 x 只增不减，二重循环的时间复杂度为 O(n)

                long beauty = (n - i) * full; // 计算总美丽值

                if (x) beauty += min((leftFlowers + sumFlowers) / x, (long) target - 1) * partial;

                ans = max(ans, beauty);

            }

            if (i < n) leftFlowers += target - flowers[i];

        }

        return ans;

    }

};

