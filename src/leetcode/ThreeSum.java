package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        HashMap<Integer,Boolean> visited = new HashMap<>();

        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int target = -nums[i];
            int lo = i+1;
            int hi = n-1;
            if (!visited.containsKey(nums[i])) {
                HashMap<Integer,Boolean> numvisited = new HashMap<>();

                while (lo < hi) {
                    int sum = nums[lo] + nums[hi];
                    if (sum == target) {
                        List<Integer> pair = new ArrayList<>();

                        pair.add(nums[i]);
                        pair.add(nums[lo]);
                        pair.add(nums[hi]);
                        if (!numvisited.containsKey(nums[hi]) &&
                        !numvisited.containsKey(nums[lo])) {
                            pairs.add(pair);
                            numvisited.put(nums[lo], true);
                            numvisited.put(nums[hi], true);
                        }

                    }

                    if (sum < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
                visited.put(nums[i], true);
            }
        }
        return pairs;
    }
}
