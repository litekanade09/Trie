import java.util.*;
public class PrefisProblem {
    static class Node{
        Node childern[] = new Node[26];
        boolean eow = false;
        int freq;

        Node(){
            for(int i = 0;i < childern.length;i++){
               childern[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int j = 0;j<word.length();j++){
            int idx = word.charAt(j) - 'a';
            if(curr.childern[idx] == null){
                curr.childern[idx] = new Node();
            }else{
                curr.childern[idx].freq++;
            }
            curr=curr.childern[idx];
        }
        curr.eow = true;
    }

    public static void prefix(Node root,String s){
        if(root == null){
            return;
        }
        if(root.freq == 1){
            System.out.println(s);
            return;
        }
        for(int i = 0;i < root.childern.length;i++){
            if(root.childern[i] != null){
                prefix(root.childern[i] , s+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        String words[] = {"zebra","dog","duck","dove"};
        for(int i = 0;i< words.length;i++){
            insert(words[i]);
        }
        root.freq = -1;
        prefix(root,"");

    }
}
