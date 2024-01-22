package 떨개.ch16;

import 떨개.Object.Trie;

public class P62 {

    public static void main(String[] args) {
        // Ch16. 트라이
        //  - 62. 트라이 구현
        //   1) 트라이의 insert, search, startWith 메소드를 구현하라.

        trieMethod();
    }

    private static void trieMethod() {
        // 1. 트라이 구현
        //  - TrieNode와 Trie Insert만 구현하고 나서 바로 이해가 되었습니다.
        //  - 이후 search와 startWith은 스스로 풀어서 답이 정상적으로 출력됨을 확인.

        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}
