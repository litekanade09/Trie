import java.util.*;
public class StartsWithProblem {
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

    public static boolean startsWith(String perfix){
        Node curr = root;
        for(int i = 0;i<perfix.length();i++){
            int idx = perfix.charAt(i) - 'a';
            if(curr.childern[idx] == null){
                return false;
            }
            curr = curr.childern[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        String words[] = {"apple","app","mango","man","women"};
        String perfix1 = "app";
        String perfix2 = "moon";
        for(int i = 0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(startsWith(perfix1));
        System.out.println(startsWith(perfix2));
    }
}
