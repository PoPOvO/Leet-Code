public class Solution {
    public String multiply(String num1, String num2) {
    	String res = "";
    	StringBuilder builder = new StringBuilder();
        String max = num1.length() > num2.length() ? num1 : num2;
        String min = num1.equals(max) ? num2 : num1;
        int[][] mulMatrix = new int[min.length()][max.length()+1];
        int[] resArray = new int[max.length()+min.length()];
        
        for (int i = min.length()-1; i >= 0; i--) {
        	for (int j = max.length()-1; j >= 0; j--) {
        		int mul = (int) ((min.codePointAt(i)-"0".codePointAt(0))) * (max.codePointAt(j)-"0".codePointAt(0));
        		if (mul > 9) {
        			mulMatrix[min.length()-1-i][max.length()-1-j] += (int) (mul % 10);
        			mulMatrix[min.length()-1-i][max.length()-j] += (int) (mul / 10); 
        		} else {
        			mulMatrix[min.length()-1-i][max.length()-1-j] += mul;
        		}
        	}
        }
        
        int rowIndex = 0;
        for (int i = 0; i < resArray.length; i++) {
        	if (rowIndex < mulMatrix.length) rowIndex++;
        	for (int j = 0; j < rowIndex; j++) {
	        	if (i-j >= mulMatrix[j].length) continue;
	        	resArray[i] += mulMatrix[j][i-j];
        	}
        	
        	if (resArray[i] > 9) {
        		resArray[i+1] = (int) (resArray[i] / 10);
        		resArray[i] = (int) (resArray[i] % 10);
        	}
        	builder.insert(0, resArray[i]);
        }
        
        res = builder.toString();
        return res.replaceAll("^0+(?=[0-9]+$)", "");
    }	
}