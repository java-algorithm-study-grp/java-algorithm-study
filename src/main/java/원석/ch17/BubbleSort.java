package 원석.ch17;

public class BubbleSort {
    private static void BubbleSort(int DataSet[], int length) {
        int i = 0;
        int j = 0;
        int tmp = 0;

        for (i=0; i<length-1; i++) {
            for (j=0; j<length-(i+1); j++) {
                if(DataSet[j] > DataSet[j+1]) {
                    tmp = DataSet[j+1];
                    DataSet[j+1] = DataSet[j];
                    DataSet[j] = tmp;
                }
            }
        }
    }

    public static void main(String args[]) {
        int DataSet[] = {6, 4, 2, 3, 1, 5};
        int Length = DataSet.length;

        BubbleSort(DataSet, Length);

        for (int i = 0; i < Length; i++) {
            System.out.print(DataSet[i] + "-> ");
        }
        System.out.println();

    }
}
