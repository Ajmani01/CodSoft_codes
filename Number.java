import java.util.*;
class Number {
    public static void main(String[] args) {
        play();
    }

    public static void play() {
        int a = 1;
        int b = 100;
        int max_attempts = 10;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int generatedNumber = random.nextInt(b) + 1;
        int attempts = 0;
        int guess;
        int score = 0;

        Scanner obj = new Scanner(System.in);
        System.out.println("Welcome to the Game");
        System.out.println("Guess a number between " + a + " and " + b);
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < generatedNumber) {
                System.out.println("Too low. Please Try again.");
            } else if (guess > generatedNumber) {
                System.out.println("Too high. Please Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number " + generatedNumber +
                        " in " + attempts + " attempts");
                score += (max_attempts  - attempts + 1);
                break;
            }
        } while (attempts < max_attempts );

        if (attempts >= max_attempts ) {
            System.out.println("Sorry, you've reached the maximum number of attempts.");
            System.out.println("The correct number was: " + generatedNumber);
        }

        System.out.println("Your current score: " + score);


        String ch;
        System.out.println("Do you want to play more?? Select" + "Y for Yes and " + "N for No");
        ch = obj.nextLine().toUpperCase();
        if (ch == "Y") {
            play();
        } else {
            System.out.println("Thanks for playing! Your final score: " + score);
        }


    }
}

