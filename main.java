import java.util.*;

public class main {
    static class Node {
        Node children[] = new Node[26];
        boolean endofWords = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insertNode(String word) { // O(L)
        Node curr = root;
        for (int j = 0; j < word.length(); j++) {
            int idx = word.charAt(j) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endofWords = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int j = 0; j < key.length(); j++) {
            int idx = key.charAt(j) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endofWords;
    }

    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "thee", "their", "any"};
        for (int i = 0; i < words.length; i++) {
            insertNode(words[i]);
        }
        System.out.println(search("thee"));
        System.out.println(search("thor")); 
    }
}
