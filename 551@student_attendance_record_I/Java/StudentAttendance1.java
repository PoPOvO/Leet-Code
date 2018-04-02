package org.xli.student_attendance;

public class StudentAttendance1 {
    public boolean checkRecord(String s) {
	   	int prevCharCodePointA = -1;           //保存上一个A字符的码点
	   	
	   	for (int i = 0; i < s.length(); i++) {	   		
	   		if (s.codePointAt(i) == prevCharCodePointA) {
	   			return false;
	   		} else if (i > 1 && s.codePointAt(i-2) == s.codePointAt(i-1)
	   				&& s.codePointAt(i-1) == s.codePointAt(i) 
	   				&& s.codePointAt(i) == "L".codePointAt(0)) {
	   			return false;
	   		}
	   		
	        if (s.codePointAt(i) == "A".codePointAt(0)) {
	   			prevCharCodePointA = s.codePointAt(i);
	   		}
	   	}
       return true;
   }
    
    public static void main(String[] args) {
		boolean flag = new StudentAttendance1().checkRecord("PPALLP");
		System.out.println(flag);
	}
}
