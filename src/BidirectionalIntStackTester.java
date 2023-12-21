import java.util.Scanner;

public class BidirectionalIntStackTester {

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    BidirectionalIntStack s = new BidirectionalIntStack(4);

    while (true) {
      System.out.println();
      System.out.print("(1) 푸시  (2) 팝  (3) 피크  (4) 덤프  (0) 종료: ");

      int menu = stdIn.nextInt();
      if (menu == 0) break;

      int x;
      int subMenu;
      switch (menu) {
        case 1:
          System.out.print("(1) 왼쪽 스택  (2) 오른쪽 스택: ");
          subMenu = stdIn.nextInt();
          System.out.print("데이터: ");
          x = stdIn.nextInt();

          if (subMenu == 1) {
            try {
              s.pushLeft(x);
            } catch (BidirectionalIntStack.OverflowBstackException e) {
              System.out.println("스택이 가득 찼습니다.");
            }
          } else if (subMenu == 2) {
            try {
              s.pushRight(x);
            } catch (BidirectionalIntStack.OverflowBstackException e) {
              System.out.println("스택이 가득 찼습니다.");
            }
          }
          break;
        case 2:
          System.out.print("(1) 왼쪽 스택  (2) 오른쪽 스택: ");
          subMenu = stdIn.nextInt();

          if (subMenu == 1) {
            try {
              x = s.popLeft();
              System.out.println("팝한 데이터는 " + x + "입니다.");
            } catch (BidirectionalIntStack.EmptyBsTackException e) {
              System.out.println("스택이 비어 있습니다.");
            }
          } else if (subMenu == 2) {
            try {
              x = s.popRight();
              System.out.println("팝한 데이터는 " + x + "입니다.");
            } catch (BidirectionalIntStack.EmptyBsTackException e) {
              System.out.println("스택이 비어 있습니다.");
            }
          }
          break;
        case 3:
          System.out.print("(1) 왼쪽 스택  (2) 오른쪽 스택: ");
          subMenu = stdIn.nextInt();

          if (subMenu == 1) {
            try {
              x = s.peekLeft();
              System.out.println("피크한 데이터는 " + x + "입니다.");
            } catch (BidirectionalIntStack.EmptyBsTackException e) {
              System.out.println("스택이 비어 있습니다.");
            }
          } else if (subMenu == 2) {
            try {
              x = s.peekRight();
              System.out.println("피크한 데이터는 " + x + "입니다.");
            } catch (BidirectionalIntStack.EmptyBsTackException e) {
              System.out.println("스택이 비어 있습니다.");
            }
          }
          break;
        case 4:
          s.dump();
          break;
      }
    }
  }
}
