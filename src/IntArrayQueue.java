public class IntArrayQueue {

  private int[] que;
  private int capacity;
  private int num;

  public static class EmptyIntArrayQueueException extends RuntimeException {

    public EmptyIntArrayQueueException() {}
  }

  public static class OverflowIntArrayQueueException extends RuntimeException {

    public OverflowIntArrayQueueException() {}
  }

  public IntArrayQueue(int maxlen) {
    num = 0;
    capacity = maxlen;

    try {
      que = new int[capacity];
    } catch (OutOfMemoryError e) {
      capacity = 0;
    }
  }

  public int enque(int x) throws OverflowIntArrayQueueException {
    if (num >= capacity) throw new OverflowIntArrayQueueException();
    return que[num++] = x;
  }

  public int deque() throws EmptyIntArrayQueueException {
    if (num <= 0) throw new EmptyIntArrayQueueException();
    int result = que[0];
    for (int i = 1; i < num; i++) {
      que[i - 1] = que[i];
    }
    num--;
    return result;
  }

  public int peek() throws EmptyIntArrayQueueException {
    if (num <= 0) throw new EmptyIntArrayQueueException();
    return que[num - 1];
  }

  public void clear() {
    num = 0;
  }

  public int indexOf(int x) {
    for (int i = 0; i < num; i++) 
      if (que[i] == x) 
        return i;
    return -1;
  }

  public int getCapacity() {
    return capacity;
  }

  public int size() {
    return num;
  }

  public boolean isEmpty() {
    return num <= 0;
  }

  public boolean isFull() {
    return num >= capacity;
  }

  public void dump() {
    if (num <= 0) 
      System.out.println("큐가 비어 있습니다.");
    else {
      for (int i = 0; i < num; i++) 
        System.out.print(que[i] + " ");
      System.out.println();
    }
  }
}
