public class GenericStack<E> {

  private E[] stk;
  private int capacity;
  private int ptr;

  public static class EmptyGStackException extends RuntimeException {

    public EmptyGStackException() {}
  }

  public static class OverflowGStackException extends RuntimeException {

    public OverflowGStackException() {}
  }

  public GenericStack(int maxlen) {
    ptr = 0;
    capacity = maxlen;
    try {
      stk = (E[])new Object[capacity];
    } catch (OutOfMemoryError e) {
      capacity = 0;
    }
  }

  public E push(E x) throws OverflowGStackException {
    if (ptr >= capacity)
      throw new OverflowGStackException();
    return stk[ptr++] = x;
  }

  public E pop() throws EmptyGStackException {
    if (ptr <= 0)
      throw new EmptyGStackException();
    return stk[--ptr];
  }

  public E peek() throws EmptyGStackException {
    if (ptr <= 0)
      throw new EmptyGStackException();
    return stk[ptr-1];
  }

  public void clear() {
    ptr = 0;
  }

  public int indexOf(E x) {
    for (int i = ptr - 1; i >= 0; i--)
      if (stk[i] == x)
        return i;
    return -1;
  }

  public int size() {
    return ptr;
  }

  public boolean isEmpty() {
    return ptr <= 0;
  }

  public boolean isFull() {
    return ptr >= capacity;
  }

  public void dump() {
    if (ptr <= 0)
      System.out.println("스택이 비어 있습니다.");
    else {
      for (int i=0;i<ptr;i++)
        System.out.print(stk[i] + " ");
      System.out.println();
    }
  }

}
