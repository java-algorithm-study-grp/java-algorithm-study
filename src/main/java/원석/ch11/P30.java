package 원석.ch11;

class P30 {
    private static final int SIZE = 10000;
    private Node[] nodes;

    public P30() {
        nodes = new Node[SIZE];
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        if (nodes[index] == null) {
            nodes[index] = new Node(-1, -1); // Placeholder node
        }
        Node prev = findPrev(nodes[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        if (nodes[index] == null) {
            return -1;
        }
        Node prev = findPrev(nodes[index], key);
        return (prev.next != null) ? prev.next.value : -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (nodes[index] == null) {
            return;
        }
        Node prev = findPrev(nodes[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    private Node findPrev(Node head, int key) {
        Node current = head;
        Node prev = null;
        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        return prev;
    }

    private static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        P30 myHashMap = new P30();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1)); // Output: 1
        System.out.println(myHashMap.get(3)); // Output: -1
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2)); // Output: 1
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2)); // Output: -1
    }
}