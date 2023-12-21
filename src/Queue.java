public class Queue<E> {

  private E[] que;
  private int capacity;
  private int num;
  private int front;
  private int rear;

  public static class EmptyGQueueException extends RuntimeException {

    public EmptyGQueueException() {}
  }

  public static class OverflowGQueueException extends RuntimeException {

    public OverflowGQueueException() {}
  }

  public Queue(int maxlen) {
    num = front = rear = 0;
    capacity = maxlen;
    try {
      que = (E[]) new Object[capacity];
    } catch (OutOfMemoryError e) {
      capacity = 0;
    }
  }

  public E enque(E x) throws OverflowGQueueException {
    if (num >= capacity)
      throw new OverflowGQueueException();
    que[rear++] = x;
    num++;
    if (rear == capacity)
      rear = 0;
    return x;
  }

  public E deque() throws EmptyGQueueException {
    if (num <= 0)
      throw new EmptyGQueueException();
    E x = que[front++];
    num--;
    if (front == capacity)
      front = 0;
    return x;
  }

  public E peek() throws EmptyGQueueException {
    if (num <= 0)
      throw new EmptyGQueueException();
    return que[front];
  }

  public void clear() {
    front = rear = num = 0;
  }

  public int indexOf(E x) {
    for (int i=0;i<num;i++) {
      int idx = (i + front) % capacity;
      if (que[idx] == x)
        return idx;
    }
    return -1;
  }

  public int search(E x) {
    for (int i = 0; i < num; i++) {
      int idx = (i + front) % capacity;
      if (que[idx] == x)
        return i + 1;
    }
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
      for (int i=0; i < num; i++) {
        System.out.print(que[(i + front) % capacity] + " ");
      }
      System.out.println();
    }
  }
}
