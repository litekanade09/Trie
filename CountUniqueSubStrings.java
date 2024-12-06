import java.util.*;
public class CountUniqueSubStrings {
    static class Node{
        Node childern[] = new Node[26];
        boolean eow= false;

        public Node(){
            for(int i = 0;i< childern.length;i++){
                childern[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        int level = 0;
        int len = word.length();
        int idx = 0;
        Node curr = root;
        for(;level<len;level++){
            idx = word.charAt(level) - 'a';
            if(curr.childern[idx] == null){
                curr.childern[idx] = new Node();
            }
            curr = curr.childern[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key){
        Node curr= root;
        for(int i = 0;i<key.length();i++){
            int idx = key.charAt(i) - 'a';
            if(curr.childern[idx] == null){
                return false;
            }
            curr = curr.childern[idx];
        }
        return curr.eow = true;
    }
    public static int CountNode(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i = 0;i<26;i++){
            if(root.childern[i] != null){
                count += CountNode(root.childern[i]);
            }
        }
        return count + 1;
    }
    public static void main(String[] args) {
        String str = "ababa";
        for(int i = 0;i <str.length();i++){
            String suff = str.substring(i);
            insert(suff);
        }
        System.out.println(CountNode(root));

    }
}
