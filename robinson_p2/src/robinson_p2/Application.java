/*
This program takes in the user's height in either inches or meters and the users weight in either 
pounds or kilograms. The app. then takes the user input, runs it through the BMI(Body Mass Index) calculator and
and tells them 
*/



package robinson_p2;

public class Application {//Opens Application class
	public static void main(String[] args) {//Opens main function
		BMICalculator BmiCalc= new BMICalculator();//Adds a BMI Calculator account.
	
		BmiCalc.readUserData();//Calls  readUserData method in BMICalculator class.
		BmiCalc.calculateBmi();//Calls calculateBmi method in BMICalculator class
		BmiCalc.displayBmi();//Calls displayBmi method in BMICalculator class
		
			
	}//Closes main function
}//Closes Application class

/* Run readUserData
 * Run calculateBmi 
 * run displayBmi
 */
