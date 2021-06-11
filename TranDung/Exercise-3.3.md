Exercise 3.3
Develop JUnit tests for the BoundedQueue class. A compilable version is available on the book website in the file BoundedQueue.java. Make sure your tests check every method, but we will not evaluate the quality of your test designs and do not expect you to satisfy any test criteria. Turn in a printout of your JUnit tests and either a printout or a screen shot showing the results of each tests
	
BoundedQueue.java
public class BoundedQueue {
	
	private int size;
	private int[] values;
	private int count;
	
	public BoundedQueue(int size) {
		this.size = size;
		values = new int[size];
		count = 0;
	}
	
	public void enqueue(int element) throws QueueFullException {
		
		/* Checking if the BoundedQueue is full */
		if (count == size) {
			throw new QueueFullException();
		} else {
			
			values[count] = element;
			++count;
			
		} 
	}
	
	/*
	 * @return int of the element removed
	 * Returns the first number in the queue
	 * Checks if the queue is empty and throws QueueEmptyException
	 */
	public int dequeue() throws QueueEmptyException {
		
		/* Checking if the BoundedQueue is empty */
		if (count == 0) {
			throw new QueueEmptyException();
		} else {
			
			int returnVal = values[0];
			
			/* Shift indices down to stay 0-based */
			for (int i = 0; i < 4; i++)
				values[i] = values[i+1];
			
			--count;
			
			return returnVal;
			
		}
	}
	
	/*
	 * Prints the queue for debugging/testing purposes
	 */
	public String print() {
		String queue = "";
		for (int i = 0; i < count; i++) 
			queue += Integer.toString(values[i]) + " " ;
		return queue.trim();
	}
	
}
	
BoundedQueueTest.java
import static org.junit.Assert.*;
import org.junit.*;
import junit.framework.JUnit4TestAdapter;

public class BoundedQueueTest {

	@Test
	public void testEnqueueToFull() throws QueueFullException {
		
		/* Test should not throw QueueFullException */
		
		BoundedQueue q = new BoundedQueue(5);
		for (int i = 1; i < 6; i++)
			q.enqueue(i);
		
		assertTrue(q.print().equals("1 2 3 4 5"));
		
	}
	
	@Test
	public void testDequeueToEmpty() throws QueueFullException, QueueEmptyException {
		
		/* Test should not throw QueueEmptyException */

		BoundedQueue q = new BoundedQueue(5);
		for (int i = 1; i < 6; i++)
			q.enqueue(i);
		
		assertEquals(1, q.dequeue());
		assertEquals(2, q.dequeue());
		assertEquals(3, q.dequeue());
		assertEquals(4, q.dequeue());
		assertEquals(5, q.dequeue());
		
	}
	
	@Test(expected = Exception.class)
	public void testEnqueuePastCapacity() throws QueueFullException {
		
		/* Test should throw QueueFUllException */
		
		BoundedQueue q = new BoundedQueue(5);
		for (int i = 1; i < 7; i++)
			q.enqueue(i);
		
	}
	
	@Test(expected = Exception.class)
	public void testDequeuePastEmpty() throws QueueFullException, QueueEmptyException {
		
		/* Test should throw QueueEmptyException */
		
		BoundedQueue q = new BoundedQueue(5);
		for (int i = 1; i < 6; i++)
			q.enqueue(i);
		
		assertEquals(1, q.dequeue());
		assertEquals(2, q.dequeue());
		assertEquals(3, q.dequeue());
		assertEquals(4, q.dequeue());
		assertEquals(5, q.dequeue());
		
		q.dequeue();
	}
	
	@Test(expected = Exception.class)
	public void testPotpourri() throws QueueFullException, QueueEmptyException {

		/* JUnit for various test cases involving enqueue and dequeue together */
		
		BoundedQueue q = new BoundedQueue(5);
		BoundedQueue q2 = new BoundedQueue(1000000);
		
		for (int i = 1; i < 6; i++)
			q.enqueue(i);
		
		assertEquals(1, q.dequeue());
		
		q.enqueue(6);
		
		assertTrue(q.print().equals("2 3 4 5 6"));
		
		for (int i = 2; i < 6; i++)
			assertEquals(i, q.dequeue());
		
		assertTrue(q.print().equals("6"));
		
		/* Testing on size of 1000000 */
		
		for (int i = 1; i < 100001; i++) {
			q2.enqueue(100001-i);
			assertEquals(100001-i, q2.dequeue());
		}
		
		assertTrue(q2.print().equals(""));
		
		q2.dequeue();
		
		
	}

	public static junit.framework.Test suite(){
  		return new JUnit4TestAdapter(BoundedQueueTest.class);
 	}

}