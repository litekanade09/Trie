import java.util.*;
public class WordBreakProblem {
    static class Node {
        main.Node children[] = new main.Node[26];
        boolean endofWords = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static main.Node root = new main.Node();

    public static void insertNode(String word) { // O(L)
        main.Node curr = root;
        for (int j = 0; j < word.length(); j++) {
            int idx = word.charAt(j) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new main.Node();
            }
            curr = curr.children[idx];
        }
        curr.endofWords = true;
    }

    public static boolean search(String key) {
        main.Node curr = root;
        for (int j = 0; j < key.length(); j++) {
            int idx = key.charAt(j) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endofWords;
    }

    public static boolean WordBreak(String key){
        if(key.length() == 0){
            return true;
        }
        for(int i = 1; i <= key.length() ; i++){
            if(search(key.substring(0,i)) && WordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "thee", "their", "any"};
        for (int i = 0; i < words.length; i++) {
            insertNode(words[i]);
        }
        System.out.println(search("thee"));
        System.out.println(search("thor"));
        System.out.println(WordBreak("theanythere"));
    }

}
