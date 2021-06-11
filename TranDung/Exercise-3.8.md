Exercise 3.8
Develop a set of data-driven JUnit tests for the Min program. These tests should be for normal, not exceptional, returns. Make your @Parameters method produce both String and Integer values.
	
Min class
import java.util.*;

public class Min
{
    /**
     * Returns the mininum element in a list
     * @param list Comparable list of elements to search
     * @return the minimum element in the list
     * @throws NullPointerException if list is null or
     *         if any list elements are null
     * @throws ClassCastException if list elements are not mutually comparable
     * @throws IllegalArgumentException if list is empty
     */
    public static <T extends Comparable<? super T>> T min (List<? extends T> list)
    {
        if (list.size() == 0)
        {
            throw new IllegalArgumentException ("Min.min");
        }

        Iterator<? extends T> itr = list.iterator();
        T result = itr.next();

        if (result == null) throw new NullPointerException ("Min.min");

        while (itr.hasNext())
        {   // throws NPE, CCE as needed
            T comp = itr.next();
            if (comp.compareTo (result) < 0)
            {
                result = comp;
            }
        }
        return result;
    }
}
	
Test Min class
package com.company;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class TestMin {
    private List<String> list;
    @Before
    public void setUp()
    {
        list = new ArrayList<String>();
    }

    @After
    public void tearDown()
    {
        list = null;
    }

    @Test public void testForNullList()
    {
        list = null;
        try {
            Min.min (list);
        } catch (NullPointerException e) {
            return;
        }
        fail ("NullPointerException expected");
    }

    @Test (expected = NullPointerException.class)
    public void testForNullElement() {
        list.add(null);
        list.add("Dung");
        Min.min(list);
    }

    @Test (expected = NullPointerException.class)
    public void testForSoloNullElement()
    {
        list.add (null);
        Min.min (list);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyList()
    {
        Min.min (list);
    }

    @Test
    public void testSingleElement()
    {
        list.add ("Dung");
        Object obj = Min.min (list);
        assertEquals("Single Element List", "Dung", obj);
    }

    @Test
    public void testDoubleElement()
    {
        list.add ("Tran");
        list.add ("Dung");
        Object obj = Min.min (list);
        assertEquals("Double Element List", "Dung", obj);
    }
}