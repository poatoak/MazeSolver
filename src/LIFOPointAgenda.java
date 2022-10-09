public class LIFOPointAgenda extends PointAgenda{
    Stack<Point> timothy = new Stack<Point>();
    public boolean isEmpty() {
        return timothy.isEmpty();
    }

    // add (pure virtual)
    // adds a Point to the agenda.
    public void add(Point item) {
        timothy.push(item);
    }

    // remove (pure virtual)
    // removes the next Point from the agenda.
    public void remove() {
        timothy.pop();
    }

    // peek (pure virtual)
    // Returns the next Point from the agenda without removing it from the agenda.
    public Point peek() {
        return timothy.peek();
    }

    // size (pure virtual)
    // Returns the number of Points in the agenda.
    public int size() {
        return timothy.length;
    }
}
