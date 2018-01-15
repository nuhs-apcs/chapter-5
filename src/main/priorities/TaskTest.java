package priorities;

public class TaskTest {
	public static void sortInts(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i, temp = arr[i];
			while (j > 0 && arr[j - 1] > temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] arr) {
		// TODO
	}
	
	public static void main(String[] args) {
		// TODO
	}
}
