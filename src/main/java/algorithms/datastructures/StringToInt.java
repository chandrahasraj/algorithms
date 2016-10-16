package algorithms.datastructures;

public class StringToInt {
	
	public int myAtoi(String str) {
        String int_string = "(^[\\+-])?[0-9]+(((e)?[\\+-]?)[0-9]+)?";
        str = str.trim();
        if(str.matches(int_string)){
            char[] values=str.toCharArray();
            return convert_array_to_value(values);
        }else 
            return 0;
    }
    
    int convert_array_to_value(char[] arr){
        int sum=0;
        int rem=1;
        boolean isNegative=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='-')
                isNegative=true;
            if(arr[i]!='+' && arr[i]!='-')
                sum = sum*10 + (arr[i] - '0');
            if(arr[i]=='e'){
                rem=get_decimal_part(arr,i+1);
                System.out.println("decimal:"+rem);
                break;
            }
        }
        return isNegative?(-1)*sum*rem:sum*rem;
    }
    
    int get_decimal_part(char[]arr,int index){
        int sum=0;
        boolean isPart=true;
        for(int i=index;i<arr.length;i++){
            if(arr[i]=='-'){
                isPart=false;
            }
            if(arr[i]!='+' && arr[i]!='-')
                sum = sum*10 + (arr[i] - '0');
        }
        if(isPart)
            return (int)Math.pow(10,sum);
        else
            return (int)Math.pow(10,-1*sum);
    }

}
