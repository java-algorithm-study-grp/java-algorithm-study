package 원석.ch17;

public class QuickSort {

    public static void quickSort(int[] DataSet, int low, int high) {
        if (low > high)
            return;

        int pivotIndex = partition(DataSet, low, high);

        quickSort(DataSet, low, pivotIndex);
        quickSort(DataSet, pivotIndex + 1, high);

    }

    private static int partition(int[] DataSet, int left, int right) {
        int low = left - 1;
        int high = right + 1;
        int pivot = DataSet[(left + right) / 2];

        while (true) {

            /*
             * 1 증가시키고 난 뒤의 lo 위치의 요소가 pivot보다 큰 요소를
             * 찾을 떄 까지 반복한다.
             */
            do {
                low++;
            } while (DataSet[low] < pivot);


            /*
             * 1 감소시키고 난 뒤의 hi 위치가 lo보다 크거나 같은 위치이면서
             * hi위치의 요소가 pivot보다 작은 요소를 찾을 떄 까지 반복한다.
             */
            do {
                high--;
            } while (DataSet[high] > pivot && low <= high);


            /*
             * 만약 hi가 lo보다 크지 않다면(엇갈린다면) swap하지 않고 hi를 리턴한다.
             */
            if (low >= high) {
                return high;
            }


            // 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
            swap(DataSet, low, high);
        }
    }

    private static void swap(int[] DataSet, int i, int j) {
        int temp = DataSet[i];
        DataSet[i] = DataSet[j];
        DataSet[j] = temp;
    }



    public static void main(String[] args) {
        int[] DataSet = {6, 5, 4, 1, 3, 2};

    }
}
