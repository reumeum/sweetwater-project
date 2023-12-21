public class IntDeque {
  private int[] deque;
  private int capacity;
  private int num;
  private int front;
  private int rear;

  public class EmptyIntDequeException extends RuntimeException {
    public EmptyIntDequeException() {}
  }

  public class OverflowIntDequeException extends RuntimeException {
    public OverflowIntDequeException() {}
  }

  public IntDeque(int maxlen) {
    num = front = rear = 0;
    capacity = maxlen;
    try {
      deque = new int[capacity];
    } catch (OutOfMemoryError e) {
      capacity = 0;
    }
  } 

  public int enqueFront(int x) throws OverflowIntDequeException {
  }

  public int enqueRear
}
