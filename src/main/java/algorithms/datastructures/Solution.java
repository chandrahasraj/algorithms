package algorithms.datastructures;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String args[]) throws Exception {
		int val=new Solution().lengthOfLongestSubstring("abcabcbbdef");
		System.out.println(val);
	}
	
	public int lengthOfLongestSubstring(String s) {
        int[] ab=new int[200];
        HashMap<String,Integer> map=new HashMap<>();
        char arr[]=s.toCharArray();
        String store="";
        int prev_index=-1,cur_length=1,max_length=1;
        for(int i=0;i<arr.length;i++){
            int val=(int)arr[i];
            if(prev_index==-1)
            	prev_index=i+1;
            if(ab[val]==0){
                ab[val]=val;
                //ab.add(val,val);
                store+=arr[i];
                cur_length++;
            }else{
                System.out.println(store);
                ab=new int[200];
                map.put(store,store.length());
                store="";
                if(cur_length>max_length){
                    max_length=cur_length;
                    cur_length=1;
                    i=prev_index-1;
                    prev_index=-1;
                }
                //ab[val]=val;
            }
            
        }
        map.put(store, store.length());
        int max=0;
        for(Map.Entry<String,Integer> m: map.entrySet()){
            if(max<m.getValue())
                max=m.getValue();
        }
        return max;
    }
}


