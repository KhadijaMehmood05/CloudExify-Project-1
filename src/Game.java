import java.util.Random;

public class Game {

    private int targetNumber;
    private int attempts;
    private int maxAttempts;
    private final int maxNumber = 100;
    private int previousGuess = -1;

    public Game(String difficulty) {

        Random random = new Random();
        targetNumber = random.nextInt(maxNumber) + 1;
        attempts = 0;

        if (difficulty.equalsIgnoreCase("Easy")) {
            maxAttempts = 10;
        } else {
            maxAttempts = 7;
        }
    }

    public String checkGuess(int guess) {
    	String hint = "";

 
        if (guess < 1 || guess > 100) {
            return "Enter number between 1 and 100";
        }
        attempts++;
        int currentDistance = Math.abs(targetNumber - guess);


        if(previousGuess != -1){

            int previousDistance = 
                    Math.abs(targetNumber - previousGuess);


            if(currentDistance < previousDistance){

                hint = "Warmer!";

            }

            else if(currentDistance > previousDistance){

                hint = "Cooler!";

            }

        }

        if (guess < targetNumber) {
            
            previousGuess = guess;
            return "Too Low! " + hint;
        } 
        else if (guess > targetNumber) {
            previousGuess = guess;
            return "Too High! " + hint;
        } 
        else {
        	 previousGuess = guess;
            return "Correct!";
        }
    }

    public boolean isGameOver() {
        return attempts >= maxAttempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getRemainingAttempts() {
        return maxAttempts - attempts;
    }
}