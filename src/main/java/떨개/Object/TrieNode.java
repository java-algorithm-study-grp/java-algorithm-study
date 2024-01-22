package 떨개.Object;

import java.util.Arrays;
import java.util.Objects;

public class TrieNode {

    boolean word;
    TrieNode[] children;

    TrieNode() {
        children = new TrieNode[26]; // 알파벳 총 개수
        word = false;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "word=" + word +
                ", children=" + Arrays.toString(children) +
                '}';
    }
}
