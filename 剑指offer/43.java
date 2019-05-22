public class Solution {
    //方法1
	public int NumberOf1Between1AndN_Solution(int n) {
		if(n < 1)
			return 0;
		int result = 0;
		for(int i=1; i<=n; i++)
			result += numberOf1(i);
		return result;
    }
	
	public int numberOf1(int n){
		int num = 0;
		while(n > 0){
			if(n%10 == 1){
				num++;
			}
			n = n/10;
		}
		return num;
	}
	
	//方法2
	public int NumberOf1Between1AndN_Solution(int n){
		StringBuffer sb = new StringBuffer();
		for(int i=1; i<=n; i++)
			sb.append(i);
		String str = sb.toString();
		int result = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == '1')
				result++;
		}
		return result;
	}
}