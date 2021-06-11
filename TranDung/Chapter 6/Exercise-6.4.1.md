Exercise 6.4.1
The restriction on interleaving next() and remove() calls is quite complex. The JUnit tests in IteratorTest.java only devote onetest for this situation, which may not be enough. Refine the input domain model with one or more additional characteristics to probe this behavior, and implement these tests in JUnit.
	
The following characteristics have been identified and are used to generate tests for the methods:
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class IteratorTest {
	
   private List<String> lst;      
   private Iterator<String> itr;   

   @Before public void setUp()  
   {
      lst = new ArrayList<String>();
      lst.add ("cat");
      lst.add ("dog");
      itr = lst.iterator();
   }
}
	
Every characteristic has a boolean partition.
	
Iterator method next()
    // Test 1 of next(): testNext_BaseCase(): C1-T, C2-T, C5-T
    @Test public void testNext_BaseCase()
    {
        assertEquals ("cat", itr.next());
    }

    // Test 2 of next(): testNext_C1(): C1-F, C2-F, C5-T
    @Test(expected=NoSuchElementException.class)
    public void testNext_C1()
    {
        itr.next(); itr.next();        // consume the cat and the dog
        itr.next();                    // now empty
    }

    // Test 3 of next(): testNext_C2(): C1-T, C2-F, C5-T
    @Test public void testNext_C2()
    {
        list = new ArrayList<String>();
        list.add (null);
        itr = list.iterator();
        assertNull (itr.next());
    }

    // Test 4 of next(): testNext_C5(): C1-T, C2-F, C5-F
    @Test(expected=ConcurrentModificationException.class)
    public void testNext_C5()
    {
        list.add ("elephant");
        itr.next();
    }
C3 and C4 characteristics are not associated. C2 is not satisfied in second test case where next value is null. In the last test cast C2 is also not satisfied because of inconsistencies.
	
Iterator method remove()
 // C1-T, C2-T, C3-T, C4-T, C5-T
   @Test public void testRemove_BaseCase()
   {
      itg.next();
      itg.remove();
      assertFalse (lst.contains ("cat"));
   }
   
   // C1-F, C2-F, C3-T, C4-T, C5-T
   @Test public void testRemove_C1()
   {
      itg.next(); itg.next();        // consume the cat and the dog
      itg.remove();                  // remove dog from list.
      assertFalse (lst.contains ("dog"));
   }
   
   // C1-T, C2-F, C3-T, C4-T, C5-T
   @Test public void testRemove_C2()
   {
      lst.add (null);
      lst.add ("elephant");
      itg = lst.iterator();
      itg.next(); itg.next();        // consume the cat and the dog
      itg.next();        // consume null; iterator not empty
      itg.remove();      // remove null from list
      assertFalse (lst.contains (null));
   }
   
   // C1-T, C2-T, C3-F, C4-T, C5-T
   @Test(expected=UnsupportedOperationException.class)
   public void testRemove_C3()
   {
      lst = Collections.unmodifiableList (lst);
      itg = lst.iterator();
      itg.next();   // consume first element to make C4 true
      itg.remove();
   }
   
   // C1-T, C2-T, C3-T, C4-F, C5-T
   @Test (expected=IllegalStateException.class)
   public void testRemove_C4()
   {
      itg.remove();
   }
      
   // C1-T, C2-T, C3-T, C4-T, C5-F
   @Test (expected=ConcurrentModificationException.class)
   public void testRemove_C5()
   {
      itg.next();
      lst.add ("elephant");
      itg.remove();
   }
All the characteristics are associated with the remove() method and each of them is removed while keeping the others. C2 has to be False in second test case because the return value is null.