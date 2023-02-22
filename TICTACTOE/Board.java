package FinalProject;

import java.util.Random;
import java.util.Scanner;

public class Board {
    private char[][] board = new char[3][3];   //Initialized Array
    Scanner in = new Scanner(System.in);
    private boolean isPlayer1 = true;
    private String player1;
    private String player2;


    public void introduction() {
        System.out.println("What is the name of player one ?");
        player1 = in.nextLine(); //WIll Save the player name in variable player1.

        System.out.println("What is the name of player two ?");
        player2 = in.nextLine();

        System.out.println("The name of player one is : " + player1 + ".");
        System.out.println("The name of player two is : " + player2 + ".");
    }

    public void initialize() //Will Draw the board
    {
        for (int r = 0; r < 3; r++) //Three lines for row. And then three lines for columns.
        {
            for (int c = 0; c < 3; c++) {
                board[r][c] = '-';
            }
        }
    }

    public void humanGame() {
        boolean rematch = true;
        boolean gameOn = true;
        int player1WinningCounter = 0;
        int player2WinningCounter = 0;
        String reGame;

        print();
        while (rematch) {
            while (gameOn) {

                if (isPlayer1) {
                    System.out.println(player1 + "'s turn. (x)");
                    humanMove('x');
                    print();
                } else {
                    System.out.println(player2 + "'s turn. (o)");
                    humanMove('o');
                    print();
                }
                if (Winner.won(board) == 'x') {
                    System.out.println(player1 + " has won!!!!");
                    gameOn = false;
                    player1WinningCounter++;
                    System.out.println("Do you want to start a new game (Y/N)?");
                } else if (Winner.won(board) == 'o') {
                    System.out.println(player2 + " has won!!!!");
                    player2WinningCounter++;
                    gameOn = false;
                    System.out.println("Do you want to start a new game (Y/N)?");
                } else if (Winner.tie(board)) {
                    System.out.println("It's a tie.");
                    gameOn = false;
                    System.out.println("Do you want to start a new game (Y/N)?");
                } else {
                    isPlayer1 = !isPlayer1;
                }
            }
            reGame = in.nextLine();

            if (reGame.equals("Y") || reGame.equals("y")) {
                initialize();
                gameOn = true;
                System.out.println("The winning counter is : ");
                System.out.println(player1 + " : " + player1WinningCounter + "  |  " + player2 + " : " + player2WinningCounter);
            } else if (reGame.equals("N") || reGame.equals("n")) {
                rematch = false;
                System.out.println("The winning counter is : ");
                System.out.println(player1 + " : " + player1WinningCounter + "  |  " + player2 + " : " + player2WinningCounter);
            }
        }
    }

    public void computerGame() {
        boolean rematch = true;
        boolean gameOn = true;
        int humanWinningCounter = 0;
        int robotWinningCounter = 0;
        String reGame;

        while (rematch) {
            while (gameOn) {

                if (isPlayer1) {
                    System.out.println("Your turn. (x)");
                    humanMove('x');
                    print();
                } else {
                    System.out.println("Robot's turn. (o)");
                    robotMove('o');
                    print();
                }
                if (Winner.won(board) == 'x') {
                    System.out.println("You won!!!! HOOORAY!!!!");
                    gameOn = false;
                    humanWinningCounter++;
                    System.out.println("Do you want to start a new game (Y/N)?");
                } else if (Winner.won(board) == 'o') {
                    System.out.println("Robot Won!!!!");
                    gameOn = false;
                    robotWinningCounter++;
                    System.out.println("Do you want to start a new game (Y/N)?");
                } else if (Winner.tie(board)) {
                    System.out.println("It's a tie.");
                    gameOn = false;
                    System.out.println("Do you want to start a new game (Y/N)?");
                } else {
                    isPlayer1 = !isPlayer1; //Just rotates between human and AI.
                }
            }
                reGame = in.nextLine();
                if (reGame.equals("Y") || reGame.equals("y")) {
                    initialize();
                    gameOn = true;
                    System.out.println("The winning counter is : ");
                    System.out.println("Human : " + humanWinningCounter + "  | Robot : " + robotWinningCounter);
                } else if (reGame.equals("N") || reGame.equals("n")) {
                    rematch = false;
                    System.out.println("The Final score is : ");
                    System.out.println("Human : " + humanWinningCounter + "  | Robot : " + robotWinningCounter);
                }
          }
    }

    private void robotMove(char token) {
        boolean needMove = true;

        while (needMove) {

            Random randomGenerator = new Random();
            int randomRow = randomGenerator.nextInt(3);
            int randomColumn = randomGenerator.nextInt(3);

            if (board[randomRow][randomColumn] == '-') //'-' (this means the spot is empty).
            {
                board[randomRow][randomColumn] = token;
                needMove = false;
            }
        }
    }

    private void humanMove(char token) {
        int row = 0;
        int column = 0;
        boolean needMove = true;
        //Human Turn
        while (needMove) {
            System.out.println("Enter the spot number for row (0, 1, or 2.)");
            row = in.nextInt(); //Scanner class, the amount will be stored in var row.

            System.out.println("Enter the spot number for column (0, 1, or 2.)");
            column = in.nextInt();

            if (row < 0 || row > 2 || column < 0 || column > 2) {
                System.out.println("The spot number is out of area");
            } else if (board[row][column] != '-') //'-' (this means the spot is taken).
            {
                System.out.println("Someone has already taken this spot");
            } else {
                board[row][column] = token;
                needMove = false;
            }
        }
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
}






