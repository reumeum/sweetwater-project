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
    if (num >= capacity)
      throw new OverflowIntDequeException();
    deque[--front] = x;
    num++;
    if (front <= 0) {
      front = capacity;
    }
    return x;
  }

  public int enqueRear(int x) throws OverflowIntDequeException {
    if (num >= capacity)
      throw new OverflowIntDequeException();
    deque[rear++] = x;
    num++;
    if (rear == capacity)
      rear = 0;
    return x;
  }

  public int dequeFront(int x) throws EmptyIntDequeException {
    if (num<=0)
      throw new EmptyIntDequeException();
    x = deque[front++];
    num--;
    if (front == capacity)
      front = 0;
    return x;
  }

  public int dequeRear(int x) throws EmptyIntDequeException {
    if (num <= 0)
      throw new EmptyIntDequeException();
    x = deque[--rear];
    num--;
    if (rear == 0)
      rear = capacity;
    return x;
  }

	//--- 덱의 맨앞 데이터를 피크(맨앞 데이터를 들여다봄 ) ---*/
	public int peekFront() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException();				// 덱이 비어있음
		return deque[front];
	}

	//--- 덱의 맨끝에서 데이터를 피크(맨끝 데이터를 들여다봄 ) ---*/
	public int peekRear() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException();				// 덱이 비어있음
		return deque[rear == 0 ? capacity - 1 : rear - 1];
	}

	//--- 덱에서 x를 검색하여 인덱스(발견하지 못하면 -1)를 반환합니다 ---//
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (deque[idx] == x)											// 검색 성공
				return idx;
		}
		return -1;														// 검색 실패
	}

	//--- 덱에서 x를 검색하여 맨앞에서 몇 번째인가(발견하지 못하면 0)를 반환합니다 ---//
	public int search(int x) {
		for (int i = 0; i < num; i++)
			if (deque[(i + front) % capacity]  == x)	// 검색 성공
				return i + 1;
		return 0;																	// 검색 실패
	}

	//--- 덱을 비웁니다 ---//
	public void clear() {
		num = front = rear = 0;
	}

	//--- 덱의 용량을 반환합니다 ---//
	public int getCapacity() {
		return capacity;
	}

	//--- 덱에 쌓여있는 데이터수를 반환합니다 ---//
	public int size() {
		return num;
	}

	//--- 덱이 비어 있는가? ---//
	public boolean isEmpty() {
		return num <= 0;
	}

	//--- 덱이 가득 찼는가? ---//
	public boolean isFull() {
		return num >= capacity;
	}

	//--- 덱 안의 모든 데이터를 맨앞 → 맨끝의 순서로 출력 ---//
	public void dump() {
		if (num <= 0)
			System.out.println("덱이 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(deque[(i + front) % capacity] + " ");
			System.out.println();
		}
	}
}
