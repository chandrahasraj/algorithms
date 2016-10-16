package algorithms.strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcatenatedStringOutOfFile {
	
	static List<String> words_list=new ArrayList<>(15000);
	public static void main(String[] args) {

		try {
			BufferedReader br=new BufferedReader(new FileReader
					(new File("C:\\Users\\chand\\Documents\\Workspace"
							+ "\\Varun Work\\WordChallenge\\words for problem.txt")));
			String word=br.readLine();
			while(word!=null){
				words_list.add(word);
				word=br.readLine();
			}
			Collections.sort(words_list, new Comparator<String>(){
				@Override
				public int compare(String o1, String o2) {
				    return Integer.compare(o2.length(),o1.length());
				  }
			});
			boolean exit=false;
			String save_word=null;
			for(int i=0;i<words_list.size();i++){
				String longest_word=words_list.get(0);
				boolean status=create_all_substrings(longest_word);
				if(status){
					save_word=longest_word;
					break;
				}
				words_list.remove(0);
			}
			if(exit)
				System.out.println(save_word);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	static boolean create_all_substrings(String str){
	    int size = str.length()-1;
	    if (size == 0)   return true;
	 
	    // Create the DP table to store results of subroblems. The value wb[i]
	    // will be true if str[0..i-1] can be segmented into dictionary words,
	    // otherwise false.
	    boolean wb[]=new boolean[size+1];
	 
	    for (int i=1; i<=size; i++)
	    {
	        // if wb[i] is false, then check if current prefix can make it true.
	        // Current prefix is "str.substr(0, i)"
	        if (wb[i] == false && words_list.contains( str.substring(0, i) ))
	            wb[i] = true;
	 
	        // wb[i] is true, then check for all substrings starting from
	        // (i+1)th character and store their results.
	        if (wb[i] == true)
	        {
	            // If we reached the last prefix
	            if (i == size)
	                return true;
	 
	            for (int j = i+1; j <= size; j++)
	            {
	                // Update wb[j] if it is false and can be updated
	                // Note the parameter passed to dictionaryContains() is
	                // substring starting from index 'i' and length 'j-i'
	            	try{
	                if (wb[j] == false && i<(j-i) && words_list.contains( str.substring(i, j-i) ))
	                    wb[j] = true;
	            	}catch(Exception e){
	            		System.err.println(e);
	            	}
	                // If we reached the last character
	                if (j == size && wb[j] == true)
	                    return true;
	            }
	        }
	    }
	 
	    /* Uncomment these lines to print DP table "wb[]"
	     for (int i = 1; i <= size; i++)
	        cout << " " << wb[i]; */
	 
	    // If we have tried all prefixes and none of them worked
	    return false;
	}

}

