//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2)
			return;
		int temp = 0;
		for(int i=0; i<array.length; i++)
			temp ^= array[i];
		int indexOf1 = findFirstBitIs1(temp);
		for(int i=0; i<array.length; i++){
			if(isBit(array[i], indexOf1))
				num1[0] ^= array[i];
			else
				num2[0] ^= array[i];
		}
    }
	
	public int findFirstBitIs1(int temp){//找到二进制中从右开始第一位1的位置
		int indexBit = 0;
		while(((temp & 1) == 0) && (indexBit < 8*4)){
			temp = temp>>1;
			indexBit++;
		}
		return indexBit;
	}
	
	public boolean isBit(int num, int index){
		num = num >> index;
		return (num & 1) == 1;
	}
}