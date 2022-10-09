public abstract class PointAgenda {

    // isEmpty (pure virtual)
    // Checks if the agenda is empty
    public abstract boolean isEmpty();

    // add (pure virtual)
    // adds a Point to the agenda.
    public abstract void add(Point item);

    // remove (pure virtual)
    // removes the next Point from the agenda.
    public abstract void remove();

    // peek (pure virtual)
    // Returns the next Point from the agenda without removing it from the agenda.
    public abstract Point peek();

    // size (pure virtual)
    // Returns the number of Points in the agenda.
    public abstract int size();
}
