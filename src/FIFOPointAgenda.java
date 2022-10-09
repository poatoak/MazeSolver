public class FIFOPointAgenda extends PointAgenda{
    Queue<Point> jerry = new Queue<Point>();
    public boolean isEmpty() {
        return jerry.isEmpty();
    };

    // add (pure virtual)
    // adds a Point to the agenda.
    public void add(Point item) {
        jerry.enQueue(item);
    };

    // remove (pure virtual)
    // removes the next Point from the agenda.
    public void remove() {
        jerry.deQueue();
    };

    // peek (pure virtual)
    // Returns the next Point from the agenda without removing it from the agenda.
    public Point peek() {
        return jerry.peek();
    };

    // size (pure virtual)
    // Returns the number of Points in the agenda.
    public int size() {
        return jerry.length;
    };
}
