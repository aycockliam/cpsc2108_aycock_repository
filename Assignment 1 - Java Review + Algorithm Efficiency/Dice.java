import java.util.Scanner;
import java.util.Random;

public class Dice{
    public int numFaces;      // Specify the number of faces a dice has.
    public int minimumFace;   // Specify the minimum value a dice can have.
    public int minimumStreak; // Specify the minimum value to count towards a streak.
    public int[] streakCount; // The present count of dice rolls in succession.

    public Dice(){
        numFaces = 0;
        minimumFace = 0;
        minimumStreak = 0;
        streakCount = new int[0];
    }
    public static void main(String[] args) {
        System.out.println("Welcome to my dice roller!"); // Welcome message.
        boolean loopCheck = true;
        boolean check = true;
        Scanner myScanner = new Scanner(System.in); // Instantiate a scanner object.
        Dice myDice = new Dice(); // Instantiate a Dice object.
        int numRolls;
        Random randomInt = new Random();
        int randomNumber;
        String thresholdCheck;
        int[] rolls; // All rolls done.

        while(check == true){ // Loop while the loop variable is true.
            System.out.print("How many rounds would you like to roll: ");
            int numRounds = myScanner.nextInt();

            System.out.print("What is the minimum die value: ");
            myDice.setMinimumFace(myScanner.nextInt());

            System.out.print("How many faces would you like: ");
            myDice.setNumFaces(myScanner.nextInt() + myDice.minimumFace);
        
            System.out.print("How many times would you like to roll the die: ");
            numRolls = myScanner.nextInt();
            rolls = new int[numRolls];
        
            System.out.print("Is there a threshold you only want to count for (y/n): ");
            thresholdCheck = myScanner.nextLine();

           if (thresholdCheck == "y"){
                check = true;
                while (check == true){
                    System.out.print("What is the number: ");
                    myDice.setMinimumStreak(myScanner.nextInt());
                        if (myDice.getMinimumStreak() > (myDice.getMinimumFace() + myDice.getNumFaces())){
                            System.out.println("Number too big! Try again!");
                        }
                        else{
                            check = false;
                        }
                }
            }
            else {
                myDice.setMinimumStreak(myDice.minimumFace);
            }
            for (int i = 0; i < numRolls; i++ ){
                randomNumber = randomInt.nextInt(myDice.minimumFace + 1, (myDice.minimumFace + myDice.numFaces) + 1); // Generate a random number that the dice can roll.
                if (randomNumber >= myDice.getMinimumStreak()){ // Check if the number is greater than the specified threshold.
                    myDice.addStreak(rolls, randomNumber); // Send to addStreak method.
                }
            }
        }
    }
    // Getter methods.
    public int getNumFaces(){return numFaces;}           // Get the value in numFaces
    public int getMinimumFace(){return minimumFace;}     // Get the value in minimumFace.
    public int getMinimumStreak(){return minimumStreak;} // Get the value in minimumStreak.
    // Setter methods.
    public void setNumFaces(int num){numFaces = num;}           // Get the value in numFaces
    public void setMinimumFace(int num){minimumFace = num;}     // Get the value in minimumFace.
    public void setMinimumStreak(int num){minimumStreak = num;} // Get the value in minimumStreak.
    // Add a number to the streak array.
    public int[] addStreak(int[] array, int number){
        int[] newArray = new int[array.length + 1]; // Make a new array with a length one greater than the original.
        for (int i = 0; i < array.length; i++){ // Iterate through the new array adding values from the last one.
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = number; // Add the new value.
        return newArray;
    }
}