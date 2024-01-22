package src.main.java.우형.ch16;

import src.main.java.우형.object.TrieNode;

public class P62 {

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }

                cur = cur.children[c - 'a'];
            }
            cur.word = true;
        }

        public boolean search(String word) {
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }

            return cur.word == true;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;

            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }

            return true;
        }
    }


}
