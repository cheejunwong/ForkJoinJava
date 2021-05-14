// Insertion sort
public class InsertionSort {
	public InsertionSort(int f[], int lb, int ub) {
		for (int i = lb; i < ub; i++) {
			int j = i;
			int k = f[i];

			while ((j > 0) && (f[j - 1] > k)) {
				f[j] = f[j - 1];
				j--;
			}

			f[j] = k;
		}
	}
}
