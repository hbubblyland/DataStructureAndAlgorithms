public class CountSort{
	public static void countSort(int array[]){
		int fanwei = 99;
		int count[] = new int[100];
		for(int i=0; i<array.length; i++)
			count[array[i]]++;
		int index = 0;
		for(int i=0; i<count.length; i++){
			for(int j=0; j<count[i]; j++)
				array[index++] = i;
		}
	}
}