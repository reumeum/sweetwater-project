public class BidirectionalIntStack {
  private int[] stk;
  private int capacity;
  private int leftPtr;
  private int rightPtr;

  public static class EmptyBsTackException extends RuntimeException {
    public EmptyBsTackException() {}
  }

  public static class OverflowBstackException extends RuntimeException {
    public OverflowBstackException() {}
  }

  public BidirectionalIntStack(int maxlen) {
    leftPtr = 0;
    rightPtr = 0;
    capacity = maxlen;
    try {
      stk = new int[capacity];
    } catch (OutOfMemoryError e) {
      capacity = 0;
    }
  }

  public int pushLeft(int x) throws OverflowBstackException {
    if (leftPtr + rightPtr >= capacity)
      throw new OverflowBstackException();
    return stk[leftPtr++] = x;
  }

  public int pushRight(int x) throws OverflowBstackException {
    if (leftPtr + rightPtr >= capacity)
      throw new OverflowBstackException();
    return stk[capacity-1 -rightPtr++] = x;
  }

  public int popLeft() throws EmptyBsTackException {
    if (leftPtr == 0)
      throw new EmptyBsTackException();
    return stk[--leftPtr];
  }

  public int popRight() throws EmptyBsTackException {
    if (rightPtr == 0)
      throw new EmptyBsTackException();
    return stk[capacity - rightPtr--];
  }

  public int peekLeft() throws EmptyBsTackException {
    if (leftPtr == 0)
      throw new EmptyBsTackException();
    return stk[leftPtr - 1];
  }

  public int peekRight() throws EmptyBsTackException {
    if (rightPtr == 0)
      throw new EmptyBsTackException();
    return stk[capacity - rightPtr];
  }

  public void dump() {
    if (leftPtr <= 0 && rightPtr <= 0)
      System.out.println("스택이 비어 있습니다.");
    else {
      System.out.print("왼쪽 스택: ");
      for (int i = 0; i < leftPtr; i++)
        System.out.print(stk[i] + " ");
      System.out.println();
      System.out.print("오른쪽 스택: ");
      for (int i = capacity - 1; i > capacity-1 - rightPtr; i--)
        System.out.print(stk[i] + " ");
      System.out.println();
    }
  }
}
