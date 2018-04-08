public class Solution {
	public String addition(String num1, String num2) {
		StringBuilder builder = new StringBuilder();
		String max = num1.length() > num2.length() ? num1 : num2;
		String min = num1.equals(max) ? num2 : num1;
		int[] resArr = new int[max.length()+1];
		
		for (int i = 0; i < max.length(); i++) {
			if (i >= min.length()) {
				resArr[i] += max.codePointAt(max.length()-1-i)-"0".codePointAt(0);
				continue;
			}
			int add = max.codePointAt(max.length()-1-i)-"0".codePointAt(0) + min.codePointAt(min.length()-1-i)-"0".codePointAt(0);
			if (add > 9) {
				resArr[i+1] += add / 10;
				resArr[i] += add % 10;
			} else resArr[i] += add;
		}
		
		for (int i = 0; i < resArr.length; i++) {
			builder.insert(0, resArr[i]);
		}
		return builder.toString().replaceAll("^0+(?=[0-9]+$)", "");
	}	
}