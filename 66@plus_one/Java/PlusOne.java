public class Solution {
    public int[] plusOne(int[] digits) {
    	int index = digits.length-1;
    	
    	while (index >= 0) {
    		if (digits[index] < 9) {
        		digits[index--]++;
        		return digits;	
    		} else digits[index--] = 0;
    	}
		int[] temp = new int[digits.length+1];        //处理全9情况
		temp[0] = 1;
		for (int i = 0; i < digits.length; i++) {
			temp[i+1] = digits[i];
		}
    	return temp;
    }	
}