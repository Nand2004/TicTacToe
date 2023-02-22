package FinalProject;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board d = new Board();

        {
            System.out.println("HI! Ready to play TicTacToe ?\nDo you want to play with human or robot ?");
            System.out.println("Type 'human' or 'robot'");
            String choose = in.nextLine();

            if (choose.equals("human")) {
                d.introduction();
                d.initialize(); //Will call the method initialize.
                d.humanGame();

                System.out.println("The winning board is : ");
                d.print();
            }
            if (choose.equals("robot")) {

                d.initialize();
                d.computerGame();

                System.out.println("The winning board is : ");
                d.print();
            }
        }
    }
}
