import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
	
	public ArrayList<Integer> printMatrix(int [][] matrix){
		if(matrix == null)
			return list;
		int rows = matrix.length;
		int columns = matrix[0].length;
		int start = 0;
		while(columns > start*2 && rows > start*2){
			printMatrixInCircle(matrix,rows,columns,start);
			start++;
		}
		return list;
	}
	
	public void printMatrixInCircle(int [][] matrix,int rows,int columns, int start){
		int endX = columns -1 -start;
		int endY = rows -1 - start;
		for(int i=start; i<=endX; i++){
			list.add(matrix[start][i]);
		}
		if(start < endY){
			for(int j = start+1; j <= endY; j++){
				list.add(matrix[j][endX]);
			}
		}
		if(start < endY && start < endX){
			for(int i = endX - 1; i >= start; i--){
				list.add(matrix[endY][i]);
			}
		}
		if(start < endX && start+1 < endY){
			for(int j = endY-1; j>= start+1; j--){
				list.add(matrix[j][start]);
			}
		}
	}
}