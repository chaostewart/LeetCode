
/*
Definition of valid IP address:
1. The length of the ip without '.' should be equal to the length of s;
2. The digit order of ip should be same as the digit order of s;
3. Each part separated by the '.' should not start with '0' except only '0';
4. Each part separared by the '.' should not larger than 255;
*/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
		for(int a = 1 ; a < 4 ; ++a)
		    for(int b = 1 ; b < 4 ; ++b)
	            for(int c = 1 ; c < 4 ; ++c)
		            for(int d = 1 ; d < 4 ; ++d) {
						if (a + b + c + d == s.length()) {
							int n1 = Integer.parseInt(s.substring(0, a));
							int n2 = Integer.parseInt(s.substring(a, a + b));
							int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
							int n4 = Integer.parseInt(s.substring(a + b + c));
							if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {   // make sure n is in [0, 255]
								StringBuilder ip = new StringBuilder();
								ip.append(n1).append('.').append(n2).append('.').append(n3).append('.').append(n4);
								if (ip.length() == s.length() + 3)   // make sure didn't lose zero digits 
									res.add(ip.toString());
							}
                        }
		            }
		return res;
    }
}
