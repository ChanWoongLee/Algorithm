package LeetCode;

import java.util.*;

public class L15 {

	public static void main(String[] args) {
		List<List<Integer>> result = new LinkedList<>();
		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(1);
		ar.add(3);
		ar.add(4);
		ArrayList<Integer> ar2 = new ArrayList<>();
		ar2.add(3);
		ar2.add(1);
		ar2.add(4);
		result.add(ar);
		Solution s = new Solution();
		s.threeSum(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
		System.out.println(result.containsAll(ar2));
	}

	static class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> result = new LinkedList<>();
			for (int i = 0; i < nums.length; i++) {
				int target = -nums[i];
				HashMap<Integer, Integer> hm = new HashMap<>();
				for (int j = i + 1; j < nums.length; j++) {
					if (hm.containsKey(nums[j])) {
						ArrayList<Integer> ar = new ArrayList<>();
						ar.add(nums[i]);
						ar.add(nums[j]);
						ar.add(nums[hm.get(nums[j])]);
						boolean pos = true;
						for (List<Integer> r : result) {
							if (r.containsAll(ar)) {
								pos = false;
								break;
							}
						}
						if (pos)
							result.add(ar);
					} else
						hm.put(target - nums[j], j);
				}
			}
			return result;
		}
	}
}
