package algorithms.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Longest_palindrome {

	public static void main(String[] args) {
		String s="civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//		String s="abcmalayalamcdad";
		new Longest_palindrome().longestPalindrome(s);
	}
	
	public String longestPalindrome(String s) {
		Map<Integer,String> map=new HashMap<>();
		String ss=longest_string(s,0,s.length(),map);
		System.out.println(ss);
        return ss;
    }
    
	String longest_string(String s,int begin,int end,Map<Integer,String>count){
        String sub=s.substring(begin,end);
        if(sub.isEmpty())
        	return null;
        if(sub.length()==1)
        	return sub;
        
        //System.out.println(sub);
        if(isPalindrome(sub)){
            if(!count.containsKey(sub.length()))
                count.put(sub.length(),sub);
            return sub;
        }else{
            if(!count.containsKey(s.length())){
                
                String s1=longest_string(s,begin,end-1,count);
                if(!count.containsKey(end-begin-1)){
                    String s2=longest_string(s,begin+1,end,count);
                    if(s1.length()>=s2.length())
                        count.put(s1.length(),s1);
                    else
                        count.put(s2.length(),s2);
                    return s1.length()>=s2.length()?s1:s2;
                }
                return s1;
            }else
                return count.get(s.length());
        }
    }
	
    
    boolean isPalindrome(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }

}
