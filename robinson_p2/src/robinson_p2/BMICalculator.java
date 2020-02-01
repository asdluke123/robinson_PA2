package robinson_p2;

import java.util.Scanner;//Import java scanner

public class BMICalculator {
	private double userHeight;
	private double userWeight;
	private int UnitType;//What measurment system they would like to use 
	private double BMI;// Total BMI Score
	private int BMIC;//BMI category they are in
	private int flag;
	Scanner input = new Scanner(System.in);//Set scanner function to the name input
	private void setFlag(int flag) {
		this.flag = flag;//Sets private flag var to value of integer flag
	}
	public int getFlag() {
		return this.flag;//Returns value of private flag
	}
	private void setBMI(double BMI) {
		this.BMI = BMI;//Sets private BMI var to value of double BMI
	}
	private void setBMIC(int BMIC) {
		this.BMIC = BMIC;//Sets private BMI category to value of BMIC
	}
	private void setHeight(double userHeight) {// method to set the users height
		this.userHeight = userHeight;
	}
	private void setWeight(double userWeight) {//method to set the users weight 
		this.userWeight = userWeight;
	}
	public double getHeight() {////method to get the user height value
		return this.userHeight;
	}
	public double getWeight() {//method to get the users weight value
		return this.userWeight;
	}
	private void setUser(int UnitType) {//Sets users measurement type
		this.UnitType = UnitType;
	}
	public int getType() {
		return this.UnitType;//Gets users measurement type
	}
	public double getBMI() {
		return this.BMI;//Gets users BMI total
	}
	public int getBMIC() {
		return this.BMIC;//Gets users BMI category 
	}
	public void readUserData( ) {
		System.out.println("How would you like to calculate your Body Mass Index?");//Prompts user asking them what system they would like to calculate their BMI in 
		System.out.println("1-Imperial System\n2-Metric System");//Prompt's user with their options and what numbers to enter 
		int choice = input.nextInt();//Saves user input to int variable choice
		while(choice < 1 || choice > 2) {//Creates a while loop to keep asking the user to enter a valid option until they do so 
			System.out.println("Please enter a valid option");//Prompts user that the option they picked isnt valid 
			System.out.println("How would you like to calculate your Body Mass Index?");
			System.out.println("1-Imperial System\n2-Metric System");
			choice = input.nextInt();
			
	}
		readUnitType(choice);//Calls method readUnitType with the parameter choice
	}
	private void readUnitType(int choice) {//Method to set UserType to value of choice
		if(choice == 1) {
			setUser(choice);
			}
		if(choice == 2) {
			setUser(choice);
		}
	}
	private double readMeasurementData(){//Method uses the users type of measurment they want to measure their BMI with and calculates it accordingly
		int user = getType();//Sets user to the value of getType
		double total=0;
		if(user == 1) {//If user equals 1 run if statement
			total  = (703 * getWeight() ) / (getHeight() * getHeight() );//Calculates the user BMI/ Imperial formula
		}
		if(user == 2) {//if user equals 2 run if statement
			total  = (getWeight()) / (getHeight() * getHeight() );//Calculates the user BMI/Metric Formula
		}
		return total;//Returns the BMI total
	}
	public void calculateBmi() {//Method that goes to the corrisponding method depending on the value of getType
		if(getType() == 1) {
			readImperialData();
		}
		if(getType() == 2) {
			readMetricData();
		}
	}
	private void readImperialData() {//method that reads in user's height and weight with Imperial measurements
		double height,weight,a;//Set height and weight double variables 
		System.out.print("What is your height in inches: ");//Prints out statement asking for users height in inches 
		height = input.nextDouble();//Saves user's input to variable height
		if (height < 0) {//If height is less then zero it exit's terminal
			setFlag(1);//Sets flag to 1 if user enters a negative height
			return;}
		setHeight(height);//Use's method setHeight to set height to userHeight
		System.out.print("What is your weight in pounds: ");//Prints out statement asking for user's weight in pounds
		weight = input.nextDouble();//Saves user input variable weight
		if(weight < 0) {
			setFlag(1);//Sets flag to 1 if user enters a negative weight 
			return;}
		setWeight(weight);//Uses setWeight method to save var weight to userWeight
		a = readMeasurementData();//sets a to the value of readMeasurementData
		setBMI(a);//Set BMI to a
	}
	
	private void readMetricData() {
		double a;//Set's user variable to 2 
		System.out.print("What is your height in meters?");//Prints out statement asking for users height in meter's
		double height = input.nextDouble();//Saves user's input to variable height
		if (height < 0) {//If height is less then zero it exit's terminal
			setFlag(1);//Sets flag to 1 if user enters a negative weight
			return;}
		System.out.print("What is your wieght in kilograms");//Prints out statement asking for user's weight in kilograms
		double weight = input.nextDouble();//Saves user input variable weight
		if (weight < 0) {//If weight is under zero exits terminal
			setFlag(1);//Sets flag to 1 if user enters a negative weight
			return;}
		setHeight(height);//Use's method setHeight to set height to userHeight
		setWeight(weight);//Uses setWeight method to save var weight to userWeight
		a = readMeasurementData();//sets a to the value of readMeasurementData
		setBMI(a);//Set BMI to a
	}

	private void BmiCategory() {
		double BMI = getBMI();//Creates int value category
		int cat=0;//initilizes cat 
		if(BMI <18.5) { //If BMI is less than 18.5 makes category equals 1 and returns category 
			cat = 1;//sets cat 1
			setBMIC(cat);}//Sets BMI category to the value of at
		else if(BMI <24.9) {//If BMI is less than 24.9 it makes category equal 2 and returns cateogry 
			cat = 2;
			setBMIC(cat);}
		else if (BMI < 29.9) { //If BMI is less than 29.9 it makes category 3 and returns category 
			cat = 3;
			setBMIC(cat);}
		else { //If category is over 30 it makes category equal 4 and returns category 
			cat = 4;
			setBMIC(cat);}
	}
	public void displayBmi() {
		if(getFlag() == 1) {//If flag equals 1 prints statement and terminates displayBmi
			System.out.print("You entered a negative number resulting in termination of program. Please run again");
			return;
		}
		BmiCategory();//Runs method BmiCategory
		switch(getBMIC()) {//Creates a switch statement according to the value of cat 
			case 1:{//If cat is 1 prints underweight statement
				System.out.printf("You have  a BMI score of %.1f%nYour BMI Category is: Underweight.%n", getBMI());
				break;//breaks switch loop
				}
			case 2:{//If cat is 2 prints out normal weight statement
				System.out.printf("You have  a BMI score of %.1f%nYour BMI Category is: Normal weight%n", getBMI());
				break;
				}
			case 3:{//Id cat is 3 prints out Overweight statement
				System.out.printf("You have  a BMI score of %.1f%nYour BMI Category is: Overweight%n", getBMI());
				break;
				}
			case 4:{//If cat is 4 prints out Obese statement
				System.out.printf("You have  a BMI score of %.1f%nYour BMI Category is: Obese%n", getBMI());
				break;
				}
			}//end of switch loop 
		}
	}//End of BMI Calculator class 






/*Pseudocode
 * Create private instances for user height,weight, BMI total, BMI category and a flag to terminate application
 *Create methods to set and get those instances
 *create readUserData to prompt the user what kind of measurement they want to use 
 *	readUnitType to save the user's choice to UnitType
 *calculateBMI sends control to either readImperalData or readMetricData depending on value of UnitTyoe
 *		readImperialData and readMetricData used to prompt user for their height and weight depending on UnitType then saves their values to userHeight and userWeight
 * 		readMeasurementdata calculates for user's BMI with userHeight and userWeight. Formula used depends on value of UnitType
 * 		saves a to value of readMeasurementData then sets BMI to value of a
 * displayBMI prompts user with error statement then terminates app IF flag equals 1
 * 	runs BmiCateogry which uses BMI to find what BMI category they are in
 * 		if BMI is less than 18.4 make cat equal 1 run setBMIC with variable cat
 * 		else if BMI is less than 24.9 make cat equal 2 run setBMIC with variable cat
 * 		else if BMI is less than 29.9 make cat equaol 3 run setBMIC with variable cat
 * 		else make cat equal 4 then run setBMIC with variable cat
 * switch statement equal to value of getBMIC
 * 		if case is 1 then print Underweight print statement
 * 		if case is 2 then print Normal weight statement
 * 		if case is 3 then print Overweight statement
 * 		if case is 4 then print Obese statement
 */
