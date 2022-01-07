import java.util.Scanner;

public class luckyNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ans = "";
        boolean nextGame = false;
        int totalGame = 0;
        int guess;
        int bestGame = Integer.MAX_VALUE;
        int totalGuesses = 0;

        do {
            guess = play();
            totalGame++;
            System.out.println("Do you want to play again? ");
            ans = input.nextLine();
            if (ans.equals("YES") || ans.equals("Y") || ans.equals("Yes") || ans.equals("yes") || ans.equals("y")) {
                nextGame = true;
            } else {
                nextGame = false;
            }
            if ( bestGame > guess) {
                bestGame = guess;
            }
            totalGuesses += guess;

        } while (nextGame);

        System.out.println("Overall results:");
        System.out.println("Total Games: " + totalGame);
        System.out.println("Total Guesses " + totalGuesses);
        System.out.println("Guesses/Games: " + (double) totalGuesses / totalGame);
        System.out.println("Best game: " + bestGame);

    }

    // hàm play

    public static int play() {
        int guess = 0;
        Scanner input = new Scanner(System.in);
        //máy tính chọn số
        int luckyNumber = (int)(Math.random()*100) + 1;
        System.out.println("Lucky number is form 0 to 100" );

        //Ngưởi chơi đoán số
        int guessNumber ;

        // dự đoán con số may mắn
        do {
            System.out.println("What is your number? ");
            guessNumber = input.nextInt();

            guess++;
            if (guessNumber > luckyNumber) {
                System.out.println("Your number is higher than Lucky Number.");
            } else  if (guessNumber < luckyNumber) {
                System.out.println("Your number is lower than Lucky Number.");
            } else  {
                System.out.println("You got it right with " + guess + " guesses");
            }

        } while (guessNumber != luckyNumber);

        return guess;
    }

}

