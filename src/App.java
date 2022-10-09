import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Maze Solver, what is the name of your file?");
        Scanner scnr = new Scanner(System.in);
        String file = scnr.nextLine();
        System.out.println("would you like to use a FIFO or a LIFO point agenda to solve your maze? Input F or L.");
        String LIFOorFIFO = scnr.next();
        Maze thomas = new Maze(file);
        PointAgenda martha;
        if (LIFOorFIFO.equalsIgnoreCase("F")) {
            martha = new FIFOPointAgenda();
        } else {
            martha = new LIFOPointAgenda();
        }
        MazeSolver bruce = new MazeSolver(thomas, martha);
        scnr.close();
        bruce.solve(true);
    }
}
