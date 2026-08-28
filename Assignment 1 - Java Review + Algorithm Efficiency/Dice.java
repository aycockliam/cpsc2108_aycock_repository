import java.util.Scanner;

public class Dice{
    public int numFaces;      // Specify the number of faces a dice has.
    public int minimumFace;   // Specify the minimum value a dice can have.
    public int minimumStreak; // Specify the minimum value to count towards a streak.
    public int[] streakCount; // The present count of dice rolls in succession.

    public static void main(String[] args) {
        System.out.println("Welcome to my dice roller!"); // Welcome message.
        boolean loop = true;
        Scanner myScanner = new Scanner(System.in); // Instantiate a scanner object.
        Dice myDice = new Dice(); // Instantiate a Dice object.
        int numRolls;

        while(loop == true){ // Loop while the loop variable is true.
        System.out.print("How many rounds would you like to roll: ");
        int numRounds = myScanner.nextInt();

        System.out.print("What is the minimum die value: ");
        myDice.setMinimumFace(myScanner.nextInt());

        System.out.print("How many faces would you like: ");
        myDice.setNumFaces(myScanner.nextInt() + myDice.minimumFace);
        
        System.out.print("How many times would you like to roll the die: ");
        numRolls = myScanner.nextInt();
        
        // myScanner.close();
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
}
