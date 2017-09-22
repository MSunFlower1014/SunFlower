package Test;

import java.util.Random;

public class Random_Hello {
	public static String randomString(int i)
	{
	   Random ran = new Random(i);
	   StringBuilder sb = new StringBuilder();
	   while (true)
	   {
	       int k = ran.nextInt(27);
	        if (k == 0)
	           break;
	           
	       sb.append((char)('`' + k));   // `  代表96    ```````
	       /*
	        * new Random(-229985452).nextInt(27)
	        * 
	        * 首6个生成的数字一定是:
	        * 8,5,12,12,15,0
	        * 
	        * 8  + 96 = 104 --> h
	        * 5  + 96 = 101 --> e
	        * 12 + 96 = 108 --> l
	        * 12 + 96 = 108 --> l
	        * 15 + 96 = 111 --> o
	        * 23 + 96 = 119 --> w
	        * 15 + 96 = 111 --> o
	        * 18 + 96 = 114 --> r
	        * 12 + 96 = 108 --> l
	        * 4  + 96 = 100 --> d
	        */
	   }
	   return sb.toString();
	}
	public static void main(String[] args) {
		
		System.out.println(randomString(-229985452) + " " + randomString(-147909649));
}

}
