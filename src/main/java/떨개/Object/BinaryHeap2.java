package 떨개.Object;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap2 {

    // 힙의 엘리먼트를 담아둘 리스트 변수
    public List<Integer> elems;

    public BinaryHeap2() {
        // 클래스 생성 시 빈 리스트를 선언하고, 첫 번째 값은 널을 삽입하여 사용하지 않음
        elems = new ArrayList<>();
        elems.add(null);
    }

    // 두 엘리먼트의 값을 교환해주는 메서드
    public void swap(int i , int j) {
        int temp = elems.get(i);
        elems.set(i, elems.get(j));
        elems.set(j, temp);
    }

    public void insert(int k) {
        elems.add(k);
        percolateUp();
    }

    public int extract() {
        int extracted = elems.get(1);

        elems.set(1, elems.get(elems.size() - 1));
        elems.remove(elems.size() - 1);
        maxHeapify(1);

        return extracted;
    }

    public void percolateUp() {
        int idx = elems.size() - 1;

        int parentIdx = idx / 2;

        while(parentIdx > 0) {
            if(elems.get(idx) > elems.get(parentIdx)) {
                swap(idx, parentIdx);
            }

            idx = parentIdx;
            parentIdx = idx / 2;
        }
    }

    public void maxHeapify(int i) {
        int left = i * 2;
        int right = i * 2 + 1;
        int biggest = i;

        if(left <= elems.size() - 1 && elems.get(left) > elems.get(biggest))
            biggest = left;

        if(right <= elems.size() - 1 && elems.get(right) > elems.get(biggest))
            biggest = right;

        if(biggest != i) {
            swap(biggest, i);
            maxHeapify(biggest);
        }


    }

    @Override
    public String toString() {
        return "BinaryHeap2{" +
                "elems=" + elems +
                '}';
    }

}
