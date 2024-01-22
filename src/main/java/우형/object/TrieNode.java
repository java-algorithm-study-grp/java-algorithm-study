package src.main.java.우형.object;

public class TrieNode {

    public boolean word;
    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
        word = false;
    }
}
