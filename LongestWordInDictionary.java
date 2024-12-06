import java.util.*;
public class LongestWordInDictionary {
    static class Node {
        Node children[] = new Node[26];
        boolean endofWords = false;

        public Node() {
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

    public static String ans= " ";
    public static void longestWord(Node root,StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i= 0;i<26;i++){
            if(root.children[i] != null && root.children[i].endofWords == true){
                char ch = (char)(i + 'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i],temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
    public static void main(String[] args) {
        String words[] = {"a","banana","app","appl","ap","apple","apply"};
        for(int i = 0;i<words.length;i++){
            insertNode(words[i]);
        }
        longestWord(root,new StringBuilder(" "));
        System.out.println(ans);

    }
}