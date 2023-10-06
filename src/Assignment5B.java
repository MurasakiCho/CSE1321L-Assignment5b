/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Gayathri, Yella
Name: Briana O'Neal
Lab#: CSE1321L.Assignment5B
*/

import java.util.Scanner;
public class Assignment5B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("[Maze game]");

        char[][] maze = {{'_', 'X', '_', 'X', 'X'}, {'_', 'X', '_', 'X', 'W'}, {'_', '_', '_', 'X', '_'}, {'X', 'X', '_', '_', '_'}, {'_', '_', '_', 'X', 'X'}};

        int [] hero = {0,0};
        boolean printMaze = true;

        do {
            if (printMaze) {
                for (int row = 0; row < 5; row++) {
                    for (int column = 0; column < 5; column++) {
                        if (row == hero[0] && column == hero[1]) {
                            System.out.print("O.");
                        } else {
                            System.out.print(maze[row][column] + ".");
                        }
                    }
                    System.out.println();
                }
            }

            System.out.print("Which direction do you want to move? ");
            String userInput = scan.nextLine();

            printMaze = true;

            switch (userInput) {
                case "Up":
                    hero[0]--;
                    System.out.println();
                    break;
                case "Down":
                    hero[0]++;
                    System.out.println();
                    break;
                case "Left":
                    hero[1]--;
                    System.out.println();
                    break;
                case "Right":
                    hero[1]++;
                    System.out.println();
                    break;
                default:
                    System.out.println("That is not a valid direction!");
                    printMaze = false;
                    break;
            }
            if (hero [0] < 0) {
                System.out.println("You can't move there - it's out of bounds!");
                hero[0]++;
                printMaze =false;
            }
            else if (hero [1] < 0){
                System.out.println("You can't move there - it's out of bounds!");
                hero[1]++;
                printMaze = false;
            }
            else if (hero[0] > 4){
                System.out.println("You can't move there - it's out of bounds!");
                hero[0]--;
                printMaze = false;
            }
            else if (hero[1] > 4){
                System.out.println("You can't move there - it's out of bounds!");
                hero[1]--;
                printMaze = false;
            }
            else if (maze[hero[0]][hero[1]] == 'X'){
                System.out.println("You hit a wall - Game Over!");
                System.exit(0);
            }
            else if (maze[hero[0]][hero[1]] == 'W'){
                System.out.println("You win!");
                System.exit(0);
            }
        } while (true);
    }
}
