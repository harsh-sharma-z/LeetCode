class Solution {
    public int myAtoi(String s) {
       if (s == null || s.length() < 1)
		return 0;
 

	s = s.trim();
 
	char flag = '+';
 
	int i = 0;
	if (s.charAt(0) == '-') {
		flag = '-';
		i++;
	} else if (s.charAt(0) == '+') {
		i++;
	}

	double result = 0;
 
	
	while (s.length() > i && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
		result = result * 10 + (s.charAt(i) - '0');
		i++;
	}
 
	if (flag == '-')
		result = -result;
 
	
	if (result > Integer.MAX_VALUE)
		return Integer.MAX_VALUE;
 
	if (result < Integer.MIN_VALUE)
		return Integer.MIN_VALUE;
 
	return (int) result;
    }
}
