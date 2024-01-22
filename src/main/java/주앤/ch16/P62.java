package 주앤.ch16;
/*
문제 : L208. 트라이 구현
풀이 : [책] 참고
자식 노드를 담는 배열의 인덱스를 알파벳 순서로 정한다.
자식 노드 배열에서 알파벳 위치에 자식 노드를 생성 및 저장하여 연결하는 식으로 구현한다.

트라이 자료구조 개념 :
	트라이는 트리 구조를 사용하여 문자열을 표현하는 데 사용되는 자료 구조이다.
	효율적으로 문자열을 저장하기 때문에, 일반적으론 문자열 탐색에 선형이 아닌 상수 시간 복잡도를 가진다.
	따라서, 효율적인 문자열 탐색을 위해 사용되곤 한다.
 */
public class P62 {
	class Trie {
	    TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    public void insert(String word) {

	        char[] spells = word.toCharArray();
	        TrieNode current = root;

	        for (char spell : spells){

	            if(current.children[spell - 'a'] == null){
	                current.children[spell - 'a'] = new TrieNode();
	            }

	            current = current.children[spell - 'a'];
	        }
	        current.word = true;
	    }

	    public boolean search(String word) {

	        char[] spells = word.toCharArray();
	        TrieNode current = root;

	        for (char spell : spells){
	            if (current.children[spell - 'a'] == null){
	                return false;
	            }
	            current = current.children[spell - 'a'];
	        }

	        if(!current.word){
	            return false;
	        }

	        return true;
	    }

	    public boolean startsWith(String prefix) {
	        char[] spells = prefix.toCharArray();
	        TrieNode current = root;

	        for (char spell : spells){
	            if (current.children[spell - 'a'] == null){
	                return false;
	            }
	            current = current.children[spell - 'a'];
	        }

	        return true;

	    }

	    class TrieNode {
	        boolean word;
	        TrieNode[] children;

	        TrieNode() {
	            children = new TrieNode[26];
	            word = false;
	        }
	    }
	}
}
