package 원석.ch17;

public class MergeSort {

    public static void mergeSort(int DataSet[], int StartIndex, int EndIndex) {
        if (StartIndex < EndIndex) {
            int MiddleIndex = (StartIndex + EndIndex) / 2;

            mergeSort(DataSet, StartIndex, MiddleIndex);
            mergeSort(DataSet, MiddleIndex + 1, EndIndex);
            merge(DataSet, StartIndex, MiddleIndex, EndIndex);
        }
    }

    public static void merge(int DataSet[], int StartIndex, int MiddleIndex, int EndIndex) {
        int i, j, k;
        int n1 = MiddleIndex - StartIndex + 1;
        int n2 = EndIndex - MiddleIndex;

        int LeftArray[] = new int[n1];
        int RightArray[] = new int[n2];

        for (i = 0; i < n1; ++i)
            LeftArray[i] = DataSet[StartIndex + i];

        for (j = 0; j < n2; ++j)
            RightArray[j] = DataSet[MiddleIndex + 1 + j];

        i = 0;
        j = 0;
        k = StartIndex;

        while (i < n1 && j < n2) {
            if (LeftArray[i] <= RightArray[j]) {
                DataSet[k] = LeftArray[i];
                i++;
            } else {
                DataSet[k] = RightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            DataSet[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            DataSet[k] = RightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int DataSet[] = {334, 6, 4, 2, 3, 1, 5, 117, 12, 34};
        int Length = DataSet.length;

        mergeSort(DataSet, 0, Length - 1);

        for (int i = 0; i < Length; i++) {
            System.out.print(DataSet[i]+" ");
        }
    }
}
