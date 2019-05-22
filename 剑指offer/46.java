class solution{
	public static int getTranslation(int number){
		if(number < 0)
			return 0;
		String str = String.valueOf(number);
		int counts[] = new count[str.length()];
		int count = 0;
		for(i=str.length()-1; i>=0; i--){
			if(i<str.length()-1){
				count = counts[i+1];
			}else{
				count = 1;
			}
			if(i<str.length()-1){
				int digit1 = str.charAt(i)-'0';
				int digit2 = str.charAt(i+1)-'0';
				int converted = digit1*10+digit2;
				if(converted >= 10 && converted <= 25){
					if(i<str.length()-2)
						count+=counts[i+2];
					else
						count+=1;
				}
			}
			counts[i] = count;
		}
		return counts[0];
	}
}