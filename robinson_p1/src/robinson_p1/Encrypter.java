/*This class encrypts the user's code that they entered 
 * then returns newly encrypted code to the main function 
 */
package robinson_p1;


import java.util.Scanner;

public class Encrypter {
	public void encrypter() {
		int user = Menu();//make user to value of the return of Menu()
		if(user == 1) {//If user = 1 enter if statement if not go to else
		Decrypter decrypt = new Decrypter();//Sets up decrypter account
		int a=0,b=0,c=0,d=0;//Initalize code variables 
	       Scanner input = new Scanner( System.in );//Input scanner 
	       System.out.print("Enter a 4 digit code to encrypt: ");//Prompt user for a 4 digit code
	       	 int code = input.nextInt();//saves the code the user enters
	       String number = String.valueOf(code);//Turns the code into a string
	     int length= codeLength(code);
	       for(int i = 0; i < number.length(); i++) {//For loop to the length of number
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
	           else if(d == 0) { //if only d is 0 run if statement
	        	   d=c;
	        	   c=b;
	        	   b=a;
	        	   a=0;  
	           }
	       }				//Encryption formula
	       a = (a + 7) % 10;//			}
	       b = (b + 7) % 10;//			}
	       c = (c + 7) % 10;//			}
	       d = (d + 7) % 10;//			}
	       					
	      int temp = a;	//saves temp to a 	
	       a = c;	// makes a the value of c		
	       c= temp;		//makes c the calue of temp 	

	       temp = b;// makes temp the value of b
	       b = d; // makes b the value of d
	       d = temp;// makes d the value of d 
	       System.out.println("Your encrypted code is:" +a+b+c+d);//Prints out the new encrypted code
	        decrypt.de(a,b,c,d);//Runs method de from Decrypter class sending the values of a b c and d 
		}
		else 
			return;//returns to main
	}
	public int Menu() {//Menu program 
		Scanner input = new Scanner(System.in);
		int user;//saves the users input 
		System.out.print("What would you like to do.\n1-Encrypt Code\n2-Decrypt code\n");//Asks the user if they would like to encrypt a code or decrypt a code 
		user = input.nextInt();//saves int value into user 
		while (user < 1 || user > 2){//While loop to catch if the user enters something that isn't an option
			System.out.print("Please select a valid option");
			System.out.print("What would you like to do.\n1-Encrypt Code\n2-Decrypt code");
			user = input.nextInt();
		}
	
		return user;//Returns user 
	}
	public int codeLength(int n) {//Gets the length of the code 
		  int count = 0;//creates int count 
		  if (n >= 1) ++count;//If n is greater than or equal to 1 count goes up by one 

		  while (n / 10 >= 1) {//While n /10 is equal to or greater than 10 do loop 
		    n /= 10;//divide n by 10 
		    ++count; //add count by 1
		  }

		  return count;// return count
		}
}//Closes Encrypter class

/*Pseudocode
 * Create 4 int varibles to save user code
 * run Menu() and save return to var user 
 * IF user equals 1 run if statement if not exit encrypter
 * ask user for 4 digit code to encrypt
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
 * Encrypt all values with formula (int +7) %10
 * make a temp value equal a then swap a with c then make c equal temp 
 * make temp equal b then swap b with d then make d equal temp
 * print encrypted code 
 * then run decrypt.de
 */
 