import java.util.Random;
import java.util.Scanner;

public class JavaSlotMachine {
        public static void main(String[] args){
            System.out.println("************************");
            System.out.println(" WELCOME TO JAVA SLOT!");
            System.out.println("Symbols: 🍒 🥭 🍉 ⭐ 🎰");
            System.out.println("************************");

            Scanner scanner = new Scanner(System.in);
            int balance = 100;
            int bet;
            int payout;
            String[] row;
            String playAgain;

            while(balance > 0) {
                System.out.println("Current Balance: $" + balance);
                System.out.print("Enter amount to BET: $");
                bet = scanner.nextInt();
                scanner.nextLine();

                if(bet > balance) {
                    System.out.println("Insufficent Balance!");
                    continue;
                } else if (bet <= 0) {
                    System.out.println("Enter the amount to bet should greater than 0!");
                    continue;
                } else {
                    balance -= bet;
                }
                System.out.println("Spinning....");
                row = spinRow();
                printRow(row);
                payout = getPayout(row,bet);

                if(payout > 0){
                    System.out.println("You won: "+payout);
                    balance += payout;
                }else{
                    System.out.println("Sorry you lost this round!");
                }
                System.out.println("Do you want to Play Again:(Y/N): ");
                playAgain = scanner.nextLine().toUpperCase();
                if(!playAgain.equals ("Y")){
                    break;
                }
            }

            System.out.println("GAME OVER, YOUR CURRENT BALANCE IS: $"+ balance);
            // display exit message
        }
        static String[] spinRow(){
            String[] symbols = {"🍒","🥭","🍉","⭐", "🎰"};
            String[] row = new String[3];
            Random random = new Random();

            for(int i = 0; i < 3; i++){
                row[i] = symbols[random.nextInt(symbols.length)];
            }
            return row;
        }
        static void printRow(String[] row){
            System.out.println("***************");
            System.out.println(" "+String.join(" | ",row));
            System.out.println("***************");

        }
        static int getPayout(String[] row, int bet){
            if( row[0].equals(row[1]) &&row[1].equals(row[2])) {
                return switch (row[0]) {
                    case "🍒" -> bet * 5;
                    case "🥭" -> bet * 6;
                    case "🍉" -> bet * 8;
                    case "⭐" -> bet * 10;
                    case "🎰" -> bet * 20;
                    default -> 0;
                };
            } else if (row[0].equals(row[1])) {
                return switch (row[0]) {
                    case "🍒" -> bet * 2;
                    case "🥭" -> bet * 3;
                    case "🍉" -> bet * 4;
                    case "⭐" -> bet * 5;
                    case "🎰" -> bet * 10;
                    default -> 0;
                };
            }else if (row[1].equals(row[2])) {
                return switch (row[1]) {
                    case "🍒" -> bet * 2;
                    case "🥭" -> bet * 3;
                    case "🍉" -> bet * 4;
                    case "⭐" -> bet * 5;
                    case "🎰" -> bet * 10;
                    default -> 0;
                };
            }
            return 0;
        }
}

