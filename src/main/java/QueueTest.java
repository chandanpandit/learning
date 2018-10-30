import java.util.Stack;

/**
 * Created by chandan on 25/10/18.
 */
public class QueueTest {
   public static void main(String[] args) {
      Queue q = new Queue();
      q.enQueue(1);
      q.enQueue(2);
      q.enQueue(3);
      q.enQueue(4);

      System.out.println(q.deQueue());
      System.out.println(q.deQueue());
      System.out.println(q.deQueue());
      System.out.println(q.deQueue());
   }
}

class Queue {
   Stack<Integer> s1 = new Stack<Integer>();
   Stack<Integer> s2 = new Stack<Integer>();

   void enQueue(int x) {
      while (!s1.isEmpty()) {
         s2.push(s1.pop());
      }

      s1.push(x);

      while (!s2.isEmpty()) {
         s1.push(s2.pop());
      }
   }

   int deQueue() {
      // if first stack is empty
      if (s1.isEmpty()) {
         System.out.println("Q is Empty");
         System.exit(0);
      }

      // Return top of s1
      int x = s1.peek();
      s1.pop();
      return x;
   }
}