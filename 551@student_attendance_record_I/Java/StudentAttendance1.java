public class Solution {
	public boolean checkRecord(String s) {
	   	int charACount = 0;           //保存A字符出现次数
	   	
	   	for (int i = 0; i < s.length(); i++) {	   		
	        if (s.codePointAt(i) == "A".codePointAt(0)) {
	        	charACount++;
	   		}
	   		if (charACount > 1 || i > 1 && s.codePointAt(i-2) == s.codePointAt(i-1)
	   				&& s.codePointAt(i-1) == s.codePointAt(i) && s.codePointAt(i) == "L".codePointAt(0)) {
	   			return false;
	   		}
	   	}
       return true;
    }
}