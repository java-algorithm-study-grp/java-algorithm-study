package 우형.ch19;

public class P79 {

    public boolean check(int[] data, int start, int size) {
        for (int i = start + 1; i < start + size + 1; i++) {
            if (i >= data.length || data[i] >> 6 != 0b10) {
                return false;
            }
        }
        return true;
    }
    public boolean validUtf8(int[] data) {
        int start = 0;

        while (start < data.length) {
            int first = data[start];

            if (first >> 3 == 0b11110 && check(data, start, 3)) {
                start += 4;
            } else if (first >> 4 == 0b1110 && check(data, start, 2)) {
                start += 3;
            } else if (first >> 5 == 0b110 && check(data, start, 1)) {
                start += 2;
            } else if (first >> 7 == 0) {
                start++;
            }
            else return false;
        }
        return true;
    }
}
