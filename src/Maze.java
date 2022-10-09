import java.util.*;
import java.io.*;
public class Maze {
    public static final char WALL = '#';
    public static final char OPEN = ' ';
    public static final char START = 'o';
    public static final char END = '*';
    public static final int MAX_ROWS = 50;
    public static final int MAX_COLUMNS = 50;
    private char[][] mazeMatrix = new char[MAX_COLUMNS][MAX_ROWS];
    private boolean[][] visited = new boolean[MAX_COLUMNS][MAX_ROWS];
    private int numRows;
    private int numColumns;
    private Point start;
    private Point end;
    public Maze (String fileName) {
        try {
            File newFile = new File(fileName);
            Scanner scnr = new Scanner(newFile);
            numRows = scnr.nextInt();
            numColumns = scnr.nextInt();
            scnr.nextLine();
            start = new Point(-1, -1);
            end = new Point(-1, -1);
            if (numRows < 0 || numRows > MAX_ROWS) {
                System.out.println("File has to many rows.");
                throw new IOException("to big");
            }
            if (numColumns < 0 || numColumns > MAX_COLUMNS) {
                System.out.println("File has to many columns.");
                throw new IOException("to big");
            }
            scanFile(scnr);
        scnr.close();
        } catch(IOException e) {
            System.out.println("File could not be found");
        }
    }
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                toReturn += mazeMatrix[i][j];
            }
            toReturn += "\n";
        }
        return toReturn;
    }
    public String toStringVisited() {
        String toReturn = "";
            for (int i = 0; i < numRows; i++) {
                for (int k = 0; k < numColumns; k++) {
                    if (visited[k][i]) {
                        toReturn += "V";
                        continue;
                    }
                    toReturn += mazeMatrix[k][i];
                }
                toReturn += "\n";
            }
        return toReturn;
    }
    public void printmaze() {
        System.out.println(toString());
    }
    public void printMazeVisited() {
        System.out.println(toStringVisited());
    }
    public void markVisited(int x, int y) {
        visited[x][y] = true;
    }
    public void markVisitedWithPoint(Point p) {
        visited[p.x][p.y] = true;
    }
    public char get(int x, int y) {
        return mazeMatrix[x][y];
    }
    public char get(Point p) {
        return mazeMatrix[p.x][p.y];
    }
    public int getNumRows() {
        return this.numRows;
    }
    public int getNumCols() {
        return this.numColumns;
    }
    public boolean hasBeenVisited(int x, int y) {
        if (visited[x][y]) {
            return true;
        }
        return false;
    }
    public boolean hasBeenVisited(Point p) {
        if (visited[p.x][p.y]) {
            return true;
        }
        return false;
    }
    public boolean isWall(int x, int y) {
        if (mazeMatrix[x][y] == WALL) {
            return true;
        }
        return false;
    }
    public boolean isWall(Point p) {
        if (mazeMatrix[p.x][p.y] == WALL) {
            return true;
        }
        return false;
    }
    public boolean isOpen(int x, int y) {
        if (mazeMatrix[x][y] != WALL && !hasBeenVisited(x, y)) {
            return true;
        }
        return false;
    }
    public boolean isOpen(Point p) {
        if (mazeMatrix[p.x][p.y] != WALL && !hasBeenVisited(p)) {
            return true;
        }
        return false;
    }
    public Point getStart() {
        return this.start;
    }
    public Point getEnd() {
        return this.end;
    }
    public void scanFile(Scanner scnr){
        String nextLine = "";
        int rowsSeen = 0;
            while (scnr.hasNextLine()) {
                nextLine = scnr.nextLine();
                if (nextLine.length() != numColumns) {
                    System.out.println("Walls Not Uniform.");
                }
                for (int j = 0; j < nextLine.length(); j++) {
                    mazeMatrix[j][rowsSeen] = nextLine.charAt(j);
                    visited[j][rowsSeen] = false;
                    if (nextLine.charAt(j) == START) {
                        start = new Point(j, rowsSeen);
                    }
                    if (nextLine.charAt(j) == END) {
                        end = new Point(j, rowsSeen);
                    }
                }
                rowsSeen++;
                if (rowsSeen > numRows) {
                    break;
                }
            }
        System.out.println(rowsSeen == numRows);
    }
}
