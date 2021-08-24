public interface Iterator
{
    public void next();
    public boolean isDone();
    public Student current();
    public void reset();
}