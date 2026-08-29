import java.util.Random;
import java.util.Scanner;

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
        Scanner myScanner = new Scanner(System.in); // Instantiate a scanner object.
        Dice myDice = new Dice(); // Instantiate a Dice object.
        int numRolls;
        Random randomInt = new Random();
        int randomNumber;
        String thresholdCheck;

        // Ask how many rounds to play.
        System.out.print("How many rounds would you like to roll: ");
        int numRounds = myDice.returnInt(myScanner);

        for (int i = 0; i < numRounds; i++){ // Loop while the loop for the number of rounds.
            // Ask for minimum die value.
            System.out.print("What is the minimum die value: ");
            myDice.setMinimumFace(myDice.returnInt(myScanner));

            // Ask for how many faces the die should have.
            System.out.print("How many faces would you like: ");
            myDice.setNumFaces(myDice.returnInt(myScanner) + myDice.minimumFace);

            // How many times should the die be rolled
            System.out.print("How many times would you like to roll the die: ");
            numRolls = myScanner.nextInt();

            myScanner.nextLine(); // Clear out line in.

            // Check if the user has a minimum number. Default to the lowest die value otherwise.
            System.out.print("Is there a threshold you only want to count for (y/n): ");
            thresholdCheck = myScanner.nextLine();

            // If the user says yes, prompt. If the number given is too big, repeat until a valid number is given.
            if (thresholdCheck.equals("y")){
                boolean check = true;
                while (check == true){
                    System.out.print("What is the number: ");
                    myDice.setMinimumStreak(myScanner.nextInt());
                        if (myDice.minimumStreak > (myDice.minimumFace + myDice.numFaces)){
                            System.out.println("Number too big! Try again!");
                        }
                        else{
                            check = false;
                        }
                }
            }
            // Set to the minimum face value if rejected.
            else {
                myDice.setMinimumStreak(myDice.minimumFace);
            }
            // Roll the die numRolls times.
            for (int j = 0; j < numRolls; j++ ){
                // For each roll, generate a random number within the bounds of the lowest die number and the highest.
                randomNumber = randomInt.nextInt(myDice.minimumFace - 1, (myDice.numFaces));
                // If the number is greater than the threshold value, add it to the array.
                if (randomNumber > myDice.getMinimumStreak()){
                    myDice.streakCount = myDice.addStreak(myDice.streakCount, randomNumber);
                }
            }

            // Print out the Array.
            System.out.println("This round rolled the following numbers above " + myDice.getMinimumStreak() + ": " + printArray(myDice.streakCount, myDice.streakCount.length));
            myDice.streakCount = new int[0]; // reset the array for further loops.
        }
        System.out.println("Goodbye!");
        myScanner.close();
    }

    // Getter methods
    public int getNumFaces(){return numFaces;}
    public int getMinimumFace(){return minimumFace;}
    public int getMinimumStreak(){return minimumStreak;}
  
    // Setter methods
    public void setNumFaces(int num){numFaces = num;}
    public void setMinimumFace(int num){minimumFace = num;}
    public void setMinimumStreak(int num){minimumStreak = num;}
 
    // Add a number to the streak array.
    public int[] addStreak(int[] array, int number){ 
        int[] newArray = new int[array.length + 1]; // Make a new array with a length one greater than the original.
        for (int i = 0; i < array.length; i++){ // Iterate through the new array adding values from the last one.
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = number; // Add the new value.
        return newArray;
    }

    // Method to print the array.
    public static String printArray(int[] object, int length){
        String arrayList = "" + object[0];
        for (int i = 1; i < length; i++)
            arrayList = arrayList + ", " + object[i];
        return arrayList;
    }

    // SUPER important method that checks for if the input was an integer or not.
    public int returnInt(Scanner scannerObject){
        int integer = 0;
        boolean validInput = false;
        while (validInput == false){
        try{
            integer = scannerObject.nextInt();
            validInput = true;
        }
        catch (Exception e){
            System.out.print("Please type an integer: ");
            scannerObject.next(); // Clear invalid input.
        }
        }
        return integer;
    }
}