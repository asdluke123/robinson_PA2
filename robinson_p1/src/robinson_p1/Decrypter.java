/* This class decrypts the user's already encrypted code and 
 * then returns the code back to the main function.
 */
package robinson_p1;

import java.util.Scanner;

public class Decrypter {
	
		public void decrypter() {
			
		
		int a=0,b=0,c=0,d=0;//Initalize code variables 
	 	 Scanner input = new Scanner( System.in );//Input scanner
		    System.out.print("Enter a 4 digit code to decrypt: ");//Prompt user for a 4 digit code
		       	 int num = input.nextInt();//saves the code the user enter
	       String number = String.valueOf(num);//Turns the num into a string
	       int length= codeLength(num); //int length= codeLength(num);
	       for(int i = 0; i < number.length(); i++) {//For loop to the number of length 
	           if(i == 0 ) //if I = 0 then it sets a to the character digit at number i
	               a = Character.digit(number.charAt(i), 10);
	           if(i==1)//if I = 1 then it sets b to the character digit at number i
	        	   b = Character.digit(number.charAt(i), 10);
	           if(i==2)//if I = 2 then it sets c to the character digit at number i
	        	   c  = Character.digit(number.charAt(i), 10);
	           if(i==3)//if I = 3 then it sets d to the character digit at number i
	        	   d = Character.digit(number.charAt(i), 10);
	       }
	       if(length !=4) {//if the value of length isnt 4 enter if statement
	       if(b == 0&&c==0&&d==0) {//if the value of b c and d are 0 run if statement
	        	  d = a;
	          		a = 0;
	          }
	           else if(c== 0 && d == 0) {//else if c and d = 0 run if statement
	        	  c = a;
	        	  d =b;
	        	  a = 0;
	        	  b = 0;
	          }
	           else if(d == 0) {//if only d is 0 run if statement
	        	   d=c;
	        	   c=b;
	        	   b=a;
	        	   a=0;
	        	   
	           }
	       }			//Decryption formula
		int d1 = (a + 3) % 10;
        int d2 = (b + 3) % 10; 
        int d3 = (c + 3) % 10; 
        int d4 = (d + 3) % 10;
 
        
         int temp = d1;//saves temp to d3	
         d1 = d3;// makes d3 the value of d1
        d3 = temp;// makes d1 the value of temp
        
        temp = d2;//saves temp to d4
        d2 = d4;//saves d4 to d2
        d4 = temp;//saves d2 to temp
		System.out.printf("Your decrypted code is %d%d%d%d", d1,d2,d3,d4);//Prints out decrypte code
		input.close();//closes input scanner
		}
		public void de(int a, int b, int c, int d) {//Decryption method for Encrypter class
			
			int d1 = (a + 3) % 10; 
	        int d2 = (b + 3) % 10; 
	        int d3 = (c + 3) % 10; 
	        int d4 = (d + 3) % 10;
	
	        	
	        int dummy = d1;
	         d1 = d3;
	        d3 = dummy;
	 
	        int dummy1 = d2;
	        d2 = d4;
	        d4 = dummy1;
	        
	        System.out.println("Your decrypted code is:" + d1 + d2 +d3 +d4);
			
		}
		public int codeLength(int n) {
			  int count = 0;
			  if (n >= 1) ++count;

			  while (n / 10 >= 1) {
			    n /= 10;
			    ++count;
			  }

			  return count;
			}
	}//Closes Decrypter class

/*Psuedocode 
 * ask user for 4 digit code to decrypt
 * save to 4 digit code to int code
 * convert code to string number
 * get length of code from codeLength 
 * FOR i equals to zero while i is less then the length of number update value i + 1
 * IF i = 0 turn charcter of number at the i'th iteration to a int value saved to a 
 * IF i = 1 turn charcter of number at the i'th iteration to a int value saved to b
 * IF i = 2turn charcter of number at the i'th iteration to a int value saved to c 
 * IF i = 3 turn charcter of number at the i'th iteration to a int value saved to d
 * IF the value of length doesn't equal for run if statement. if it does go to encryption formula 
 * IF value b,c, and d equal zero swap d with a and make a equal zero 
 * IF values c and D equal zero swap c with a and d with b and make a and b equal zero 
 * IF value d equals zero swap d with c, c with b, b with a and make a equal zero 
 * Encrypt all values with formula (int +3) %10
 * make a temp value equal d1 then swap d1 with d3 then make d3 equal temp 
 * make temp equal d2 then swap d2 with d4 then make d4 equal temp
 * print decrypted code 
 * exit Decrypt.decrypt
 * 
 * de class 
 * Encrypt all values with formula (int +3) %10
 * make a temp value equal d1 then swap d1 with d3 then make d3 equal temp 
 * make temp equal d2 then swap d2 with d4 then make d4 equal temp
 * print decrypted code  
 */
