public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length <= 0)
			return false;
		return VerifySquenceOfBSTCore(sequence, 0, sequence.length-1);
    }
	public boolean VerifySquenceOfBSTCore(int [] sequence, int head, int tail){
		if(head >= tail)
			return true;
		int tailNum = sequence[tail];
		int i = 0;
		for(; i < tail; i++){
			if(sequence[i] > tailNum)
				break;
		}
		int j = i;
		for(; j < tail; j++){
			if(sequence[j] < tailNum)
				return false;
		}
		return VerifySquenceOfBSTCore(sequence, head, i-1) && VerifySquenceOfBSTCore(sequence, i, tail-1);
	}
}