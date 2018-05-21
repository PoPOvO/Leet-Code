public class Solution {
	public int arrayNesting(int[] nums) {
		int[] s = new int[nums.length];
		short[] repeats = new short[20000];
		int count = 0;

		s[count] = nums[count];
		repeats[s[count++]]++;
		while (count < nums.length) {
			if (repeats[nums[s[count-1]]] == 1) {
				return count;
			} else {
				s[count] = nums[s[count-1]];
				repeats[s[count++]]++;
			}
		}
		
		return count;
	}
}