/* This program reads in a 4-digit code from the user
 * and encrypts it using a set formula and then prints it out
 * then decrypts the encrypted code back to its orignal state
 * then printing it out to show the user.
 */
package robinson_p1;

public class Application {
	public static void main(String[] args) {
		Encrypter Encrypter = new Encrypter();
		Decrypter Decrypter = new Decrypter();
		Encrypter.encrypter();//Runs encrypter from Encrypter class
		Decrypter.decrypter();//Runs decrypter from Decrypter class
	}//closes main
}//closes Application class
/*Create account values for Encrypter class and Decrypter class
 *run Encrypter.encrypter
 *run Decrypter.decrypter 
 */
 
