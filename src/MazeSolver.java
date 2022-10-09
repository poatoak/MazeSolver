import java.io.*;
public class MazeSolver {
   Maze atrocitus;
   PointAgenda hannah;
   int pointsChecked;
   public MazeSolver(Maze x, PointAgenda y) {
    atrocitus = x;
    hannah = y;
   }
   public boolean solve(boolean trace) throws InterruptedException, IOException {
    hannah.add(atrocitus.getStart());
    pointsChecked += 1;
    boolean end = false;
    while (!hannah.isEmpty() && !end) {
      Point p = new Point(hannah.peek().x, hannah.peek().y);
      hannah.remove();
      if (!atrocitus.hasBeenVisited(p)) {
         end = visit(p);
      }
      tracePoints(trace);
      System.out.println(pointsChecked);
    }
    printSolvable(end);
    return end;
   }
   public void printSolvable(boolean b) {
      if (b) {
         System.out.println("We found the end!");
      } else {
         System.out.println("This maze is unsolvable.");
      }
      System.out.println("We visited " + pointsChecked + " spots.");
   }
   public void tracePoints(boolean trace) throws InterruptedException, IOException {
      if (trace) {
          System.out.flush();
          //Runtime.getRuntime().exec("clear");
          atrocitus.printMazeVisited();
          Thread.sleep(100);
      }
   }   
   public void visitNeighbors(Point p) {
      if (atrocitus.isOpen(p.x - 1, p.y)) {
         Point x = new Point(p.x - 1, p.y);
         hannah.add(x);
         pointsChecked++;
      }
      if(atrocitus.isOpen(p.x + 1, p.y)) {
         Point x = new Point(p.x + 1, p.y);
         hannah.add(x);
         pointsChecked++;
      }
      if(atrocitus.isOpen(p.x, p.y - 1)) {
         Point x = new Point(p.x, p.y - 1);
         hannah.add(x);
         pointsChecked++;
      }
      if(atrocitus.isOpen(p.x, p.y + 1)) {
         Point x = new Point(p.x, p.y + 1);
         hannah.add(x);
         pointsChecked++;
      }
   }
   public boolean visit(Point p) {
      if (p.x == atrocitus.getEnd().x && p.y == atrocitus.getEnd().y) {
         return true;
      }
      atrocitus.markVisitedWithPoint(p);
      System.out.println("(" + p.x + "," + p.y + ")");
      visitNeighbors(p);
      return false;
   }
}

