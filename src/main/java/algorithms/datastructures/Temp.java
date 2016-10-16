package algorithms.datastructures;

public class Temp {

	public static void main(String as[]){
		int a[]=new Temp().countBits(7);
		for(int i:a)
			System.out.print(i+"\t");
	}
	
	public int[] countBits(int num) {
        int[] ar=new int[num+1];
        for(int i=0;i<=num;i++){
            if(i!=0 && i!=1){
                int pw=(int)(Math.log(i)/Math.log(2));
                if(Math.pow(2,pw)==i){
                    ar[i]=1;
                }else{
                    int nearest=(int)Math.floor(pw);
                    int extra=i-(int)Math.pow(2,nearest);
                    System.out.println(extra);
                    ar[i]=1+ar[extra];
                }
            }else{
                if(i==0)
                    ar[0]=0;
                else
                    ar[1]=1;
            }
        }
        return ar;
    }
	
}

