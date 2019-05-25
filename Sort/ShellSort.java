public class ShellSort{
	public void ShellSort0(int array[]){
		for(int increase=(array.length+1)/2; increase>0; increase /= 2){
			for(int i=increase; i<array.length; i++){
				int j = i;
				int target = array[i];
				whlie(j>0 && target<array[j-increase]){
					array[j] = array[j-increase];
					j -= increase;
				}
				array[j] = target;
			}
		}
	}
}