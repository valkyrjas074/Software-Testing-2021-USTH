Exercise 3.10
Replace each occurrence of a set with a list in the JUnit theory removeThenAddDoesNotChangeSet. Is the resulting theory valid or invalid? How many of the tests that pass the precondition also pass the postcondition? Explain
	
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

import java.util.*;

@RunWith(Theories.class)
public class SetTheoryTest {
    @DataPoints
    public static String[] string = {"ant", "bat", "cat"};

    @DataPoints
    public static Set[] sets = {
            new HashSet(Arrays.asList("ant", "bat")),
            new HashSet(Arrays.asList("bat", "cat", "dog", "elk")),
            new HashSet(Arrays.asList("Snap", "Crackle", "Pop"))
    };


    @Theory
    public void removeThenAddDoesNotChangeSet(Set<String> set, String string) {  // Parameters!
        assumeTrue(set != null);            // Assume
        assumeTrue(set.contains(string));  // Assume
        // Uncomment the following line to see which tests that pass the precondition
        // System.out.println ("Set, string: " + set + ", " + string);
        Set<String> copy = new HashSet<String>(set);   // Act
        copy.remove(string);
        copy.add(string);
        assertTrue(set.equals(copy));      // Assert
    }
}
	
The resulting theory is invalid. Only one of three cases can pass the test. When we remove and then add an element, its position in the list could have been changed therefore the list is different. The JUnit theory failed.