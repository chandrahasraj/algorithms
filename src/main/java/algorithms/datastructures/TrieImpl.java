package algorithms.datastructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TrieImpl {
	private static TrieNode root;
	
	TrieImpl(){
		root = new TrieNode();
		root.children = new HashMap<>();
	}
	
	public static void main(String[] args) {
//		String data = "team";
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\chand\\Desktop\\WordChallenge\\words for problem.txt")));
			
			String word = br.readLine();
			while(word!=null){
				
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
 
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
 
            TrieNode t;
            if(children.containsKey(c)){
                    t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c, t);
            }
 
            children = t.children;
 
            //set leaf node
            if(i==word.length()-1)
                t.isLeaf = true;    
        }
    }
 
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
 
        if(t != null && t.isLeaf) 
            return true;
        else
            return false;
    }
 
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null) 
            return false;
        else
            return true;
    }
 
    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children; 
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }
 
        return t;
    }

}

class TrieNode{
	char character;
	boolean isLeaf;
	HashMap<Character,TrieNode> children = new HashMap<>();
	
	TrieNode(){
		
	}
	
	TrieNode(char c){
		character = c;
	}
}
