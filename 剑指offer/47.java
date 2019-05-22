class solution{
	public int getMax(int values[][], int rows, int cols){
		if(values == null || rows <= 0 || cols <= 0)
			return 0;
		int maxVal [][] = new int[rows][cols];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				int up = 0;
				int left = 0;
				if(i > 0)
					up = maxVal[i-1][j];
				if(j > 0)
					left = maxVal[i][j-1];
				maxVal[i][j] = Math.max(up,left)+values[i][j];
			}
		}
		return maxVal[rows-1][cols-1];
	}
	
}