package 떨개.Object;

public class Sort {

    public int[] BubbleSort(int[] A) {
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < A.length - 1; j++) {
                if(A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                }
            }
        }
        return A;
    }

    public int partition(int[] A, int lo, int hi) {
        int pivot = A[hi];
        int left = lo;
        for(int right = lo; right < hi; right++) {
            if(A[right] < pivot) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
            }
        }

        int temp = A[left];
        A[left] = A[hi];
        A[hi] = temp;
        return left;
    }

    public int[] QuickSort(int[] A, int lo, int hi) {
        if(lo < hi) {
            int pivot = partition(A, lo, hi);
            QuickSort(A, lo, pivot - 1);
            QuickSort(A, pivot + 1, hi);
        }
        return A;
    }

}
