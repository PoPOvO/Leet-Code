public class FractionAddition {
   public String fractionAddition(String expression) {
    	expression = expression.replaceAll("\\+", ":+");
    	expression = expression.replaceAll("-", ":-");
    	String[] items = expression.split(":");
    	int up = 0;
    	int down = 1;
    	int gcd = -1;
    	
    	if (expression.codePointAt(0) == ":".codePointAt(0)) {       //第一个数为负
    		items = Arrays.copyOfRange(items, 1, items.length);
    	}
    	
    	for (int i = 0; i < items.length; i++) {                     //分子相加如a/b+c/d = (ad + bc)/bd
    		String[] item = items[i].split("/");
    		up = up * Integer.valueOf(item[1]) + down * Integer.valueOf(item[0]);
    		down *= Integer.valueOf(item[1]);
    	}
    	
    	gcd = greatestCommonDivisor(Math.abs(up), down);
    	up /= gcd;
    	down /= gcd;
    	return up + "/" + down;
    }
    
    //最大公约数
    private int greatestCommonDivisor(int m, int n) {
        int r = 0 ;
        while(n != 0){
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
}
