package com.tree.www.algorithm;

import java.util.*;

/**
 * Created by pysh on 2018/8/21.
 */
public class Algorithm {
    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 5, 6, 4};
        //System.out.println(firstMissingPositive(nums));
        //int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 9};
        ////int[] height = {4, 3, 1, 1, 1, 0};
        //System.out.println(trap(height));
        //int[][] height2 = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        //System.out.println(trap2(height2));
        //System.out.println(canJump(nums));
        //System.out.println(jump(height));
        //int[] stones = {0, 1, Integer.MAX_VALUE};
        //System.out.println(canCross(stones));
        //System.out.println(smallestGoodBase("1000000000000000000"));
        //System.out.println(longestValidParentheses("(()()))(()()))"));
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(findNthDigit(1000000000));
        //System.out.println(findNthDigit(125615));
        //System.out.println(findNthDigit(125616));
        //System.out.println(findNthDigit(125617));
        //System.out.println(findNthDigit(125618));
        //System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        //System.out.println(lengthOfLongestSubstring("ajsadajsaj"));
        //System.out.println(convert("abcdefghijklmn", 4));
        //System.out.println(countAndSay(6));
        //System.out.println(reverse(-2147483648));
        //System.out.println(Arrays.toString(fairCandySwap(new int[]{1, 3, 4, 5, 2}, new int[]{1, 2, 2, 4})));
        System.out.println(superEggDrop(2, 4));
    }

    /**
     * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
     * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
     * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，
     * 从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
     * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
     * 你的目标是确切地知道 F 的值是多少。
     * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
     * <p>
     * 假设我们有k个鸡蛋第m步时，在第X层扔鸡蛋。这时候，会有两种结果，鸡蛋碎了，或者没碎。
     * 如果鸡蛋没碎，我们接下来会在更高的楼层扔，最多能确定 X + dp[k][m-1] 层的结果；
     * 如果鸡蛋碎了，我们接下来会在更低的楼层扔，最多能确定 Y + dp[k-1][m-1] 层的结果 (假设在第X层上还有Y层)。
     * 因此，这次扔鸡蛋，我们最多能测出 dp[k-1][m-1] (摔碎时能确定的层数) + dp[k][m-1] (没摔碎时能确定的层数) + 1 (本层) 层的结果。
     * 另外，我们知道一个鸡蛋一次只能测一层，没有鸡蛋一层都不能测出来。
     * 因此我们可以列出完整的递推式:
     * dp[k][0] = 0
     * dp[1][m] = m (m > 0)
     * dp[k][m] = dp[k-1][m-1] + dp[k][m-1] + 1 (k > 0, m>0)
     *
     * @param K 1
     * @param N 2
     * @return 2
     */
    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 2][K + 2];
        dp[0][0] = 0;
        for (int m = 1; m <= N; m++) {
            dp[m][0] = 0;
            for (int k = 1; k <= K; k++) {
                dp[m][k] = dp[m - 1][k] + dp[m - 1][k - 1] + 1;
                if (dp[m][k] >= N) {
                    return m;
                }
            }
        }
        return N;
    }

    /**
     * 公平的糖果交换
     * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
     * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。
     *
     * @param A [1,2,5]
     * @param B [2, 4]
     * @return [5, 4]
     */
    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Set<Integer> setA = new HashSet<>();
        for (int i : A) {
            sumA += i;
            setA.add(i);
        }
        for (int i : B) {
            sumB += i;
        }
        if ((sumA - sumB) % 2 != 0) {
            throw new IllegalArgumentException("无解");
        }
        int delta = (sumA - sumB) / 2;
        for (int i : B) {
            if (setA.contains(i + delta)) {
                return new int[]{i + delta, i};
            }
        }
        throw new IllegalArgumentException("无解");
    }

    /**
     * 给定一个 32 位有符号整数，将整数中的数字进行反转。
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long num = x;
        boolean flag = false;
        if (x < 0) {
            num = x * -1L;
            flag = true;
        }
        long ret = Long.valueOf(new StringBuffer(String.valueOf(num)).reverse().toString()) * (flag ? -1 : 1);
        if (ret < Integer.MIN_VALUE || ret > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) ret;
    }

    /**
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String last = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder("");
            int index = 0;
            while (index < last.length()) {
                int cur = index;
                while (cur < last.length() && last.charAt(index) == last.charAt(cur)) {
                    cur++;
                }
                sb.append(cur - index).append(last.charAt(index));
                index = cur;
            }
            last = sb.toString();
        }
        return last;
    }

    /**
     * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int n = s.length(), cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                res.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    res.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return res.toString();
    }

    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，
     * 它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     *
     * @param l1 (2 -> 4 -> 3)
     * @param l2 (5 -> 6 -> 4)
     * @return 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = (l1.val + l2.val) % 10, ca = (l1.val + l2.val) / 10;
        ListNode res = new ListNode(val);
        ListNode temp = res;
        while (l1.next != null || l2.next != null) {
            l1 = l1.next == null ? new ListNode(0) : l1.next;
            l2 = l2.next == null ? new ListNode(0) : l2.next;
            val = (l1.val + l2.val + ca) % 10;
            ca = (l1.val + l2.val + ca) / 10;
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        if (ca != 0) temp.next = new ListNode(ca);
        return res;
    }

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * @param nums [-1, 0, 1, 2, -1, -4]
     * @return [[-1, 0, 1], [-1, -1, 2]]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1] || nums[i] > 0) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return list;
    }

    /**
     * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
     * 9+(99-9)*2+(999-99)*3+...
     *
     * @param n 11
     * @return 0
     */
    public static int findNthDigit(int n) {
        int i = 0, sum = 0, next;
        while (true) {
            next = (int) (Math.pow(10, i++) * 9 * i);
            if (sum > n - next)
                break;
            sum += next;
        }
        int index = n - sum;
        int num = (int) (index / i + Math.pow(10, (i - 1)) - 1);
        int r = index % i;
        if (r != 0) {
            return String.valueOf(num + 1).toCharArray()[r - 1] - '0';
        } else {
            return num % 10;
        }
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * @param s "([)]"
     * @return false
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> m = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            switch (chars[i]) {
                case ')':
                    if (m.empty()) return false;
                    char c1 = m.pop();
                    if (c1 != '(') return false;
                    break;
                case '}':
                    if (m.empty()) return false;
                    char c2 = m.pop();
                    if (c2 != '{') return false;
                    break;
                case ']':
                    if (m.empty()) return false;
                    char c3 = m.pop();
                    if (c3 != '[') return false;
                    break;
                default:
                    m.push(chars[i]);
            }
        }
        return m.empty();
    }

    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     *
     * @param s ")()())"
     * @return 4
     */
    public static int longestValidParentheses(String s) {
        int res = 0, start = 0;
        char[] chars = s.toCharArray();
        Stack<Integer> m = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (chars[i] == '(') {
                m.push(i);
            } else {
                if (m.empty()) {
                    start = i + 1;
                } else {
                    m.pop();
                    res = m.empty() ? Math.max(res, i - start + 1) : Math.max(res, i - m.lastElement());
                }
            }
        }
        return res;
    }

    /**
     * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
     * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
     *
     * @param n
     * @return
     */
    public static String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        int maxIndex = (int) (Math.log(num) / Math.log(2) + 1);
        for (int i = maxIndex; i >= 3; i--) {
            long base = (long) Math.pow(num, 1.0 / (i - 1)), sum = 1, cur = 1;
            for (int j = 1; j < i; j++) {
                sum += (cur *= base);
            }
            if (sum == num) return String.valueOf(base);
        }
        return String.valueOf(num - 1);
    }

    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数
     * 要求时间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        byte[] temp = new byte[nums.length + 1];
        for (int num : nums) {
            if (num > 0 && num < temp.length) {
                temp[num] = 1;
            }
        }
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 0) {
                return i;
            }
        }
        return temp.length;
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
     * 计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        //两根指针一头一尾向中间进发
        int left = 0;
        int right = height.length - 1;
        //两个变量存储左右两边的局部最大高度
        int leftMax = 0;
        int rightMax = 0;

        int area = 0;

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            //小的那边可以存水
            if (leftMax <= rightMax) {
                if (leftMax > height[left]) {
                    area += leftMax - height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]) {
                    area += rightMax - height[right];
                }
                right--;
            }
        }

        return area;
    }

    /**
     * 给定一个m x n的矩阵，其中的值均为正整数，
     * 代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
     *
     * @param height
     * @return
     */
    public static int trap2(int[][] height) {
        return TrapRainWater.trapRainWater(height);
    }

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int n = nums.length, reach = 0;// 最远可达
        for (int i = 0; i < n; ++i) {
            if (i > reach || reach >= n - 1) break;
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= n - 1;
    }

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int n = nums.length;
        int ret = 0;
        int last = 0; // 上一次覆盖的范围
        int curr = 0; // 当前可覆盖的范围
        for (int i = 0; i < n; ++i) {
            if (i > last) {
                last = curr;
                ++ret;
            }
            curr = Math.max(curr, i + nums[i]);
        }

        return ret;
    }

    /**
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     *
     * @param num
     * @return
     */
    public static int maximumSwap(int num) {
        String string = String.valueOf(num);
        if (string.length() == 1) return num;
        char[] chars = string.toCharArray();
        int[] indexMax = new int[chars.length];
        for (int i = 0; i < indexMax.length; i++) {
            indexMax[i] = i;
        }
        int index = 0, i = chars.length - 1;
        while (true) {
            if (chars[i] > chars[indexMax[index]]) {
                indexMax[index] = i;
            }
            if (i == index + 1) {
                if (index != indexMax[index]) {
                    char temp = chars[index];
                    chars[index] = chars[indexMax[index]];
                    chars[indexMax[index]] = temp;
                    break;
                }
                index++;
                i = chars.length - 1;
            } else {
                --i;
            }
            if (index == chars.length - 1) break;
        }
        return Integer.valueOf(String.valueOf(chars));
    }


    /**
     * 一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。
     * 给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。
     * 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。
     * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
     *
     * @param stones
     * @return
     */
    public static boolean canCross(int[] stones) {
        if (stones.length == 0) return false;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>()); // 记录位置和跳到该位置时k的集合
        }

        map.get(0).add(0);
        for (int stone : stones) {
            for (int lastJump : map.get(stone)) {
                for (int nextJump = lastJump - 1; nextJump <= lastJump + 1; nextJump++) {
                    if (nextJump > 0 && map.containsKey(stone + nextJump)) {
                        map.get(stone + nextJump).add(nextJump);
                    }
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }

    /**
     * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
     * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
     * <p>
     * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
     *
     * @param nums1 [3,4,6,5,5,6,7]
     * @param nums2 [9,1,2,5,8,3]
     * @param k     8
     * @return [9, 8, 6, 5, 5, 6, 7, 3]
     */
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = null;
        for (int i = 0; i <= k && i <= nums1.length; i++) {
            int j = k - i;
            if (j > nums2.length) continue;
            int[] max1 = max(nums1, i);
            int[] max2 = max(nums2, j);
            int[] merged = merge(max1, max2);
            if (max == null || greater(merged, 0, max, 0)) max = merged;
        }
        return max;
    }

    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     *
     * @param nums [3,30,34,5,9]
     * @return 9534330
     */
    public static String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (o1, o2) -> { // 因为 有时候3排在30前面 所以不能单纯用字符串顺序来排。
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str2.compareTo(str1); // 倒序
        });

        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string);
        }
        return result.toString();
    }

    private static int[] max(int[] nums, int k) {
        int[] max = new int[k];
        int from = 0;
        for (int i = 0; i < k; i++) {
            for (int j = from + 1; j + (k - i) <= nums.length; j++) {
                if (nums[j] > nums[from]) from = j;
            }
            max[i] = nums[from];
            from++;
        }
        return max;
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0, k = 0; k < merged.length; k++) {
            merged[k] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return merged;
    }

    private static boolean greater(int[] nums1, int f1, int[] nums2, int f2) {
        while (f1 < nums1.length && f2 < nums2.length && nums1[f1] == nums2[f2]) {
            f1++;
            f2++;
        }
        return f2 == nums2.length || (f1 < nums1.length && nums1[f1] > nums2[f2]);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
