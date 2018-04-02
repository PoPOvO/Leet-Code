public class Solution {
    public boolean checkRecord(String s) {
	   	int prevCharCodePointA = -1;           //保存上一个A字符的码点
	   	
	   	for (int i = 0; i < s.length(); i++) {	   		
	   		if (s.codePointAt(i) == prevCharCodePointA || i > 1 && s.codePointAt(i-2) == s.codePointAt(i-1)
	   				&& s.codePointAt(i-1) == s.codePointAt(i) && s.codePointAt(i) == "L".codePointAt(0)) {
	   			return false;
	   		}
	        if (s.codePointAt(i) == "A".codePointAt(0)) {
	   			prevCharCodePointA = s.codePointAt(i);
	   		}
	   	}
       return true;
   }
}