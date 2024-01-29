package 원석.ch17;

public class InsertSort {
    private static void InsertSort(int[] DataSet) {
        for (int i = 1; i < DataSet.length; i++) {

            int value = DataSet[i];

            int j = i - 1;

            while (j >= 0 && DataSet[j] > value) {
                DataSet[j + 1] = DataSet[j];
                j--;
            }
            DataSet[j + 1] = value;
        }
    }

    public static void main(String args[]) {
        int[] DataSet = {6, 4, 2, 3, 1, 5};

        InsertSort(DataSet);

        for (int i : DataSet) {
            System.out.print(i + " ");
        }
    }
}
