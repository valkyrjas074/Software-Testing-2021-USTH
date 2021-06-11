Exercise 3.5
Find the flaw of a given testSort() method, and describe it using the RIPR model.
	
@Test
public void testSort()
{
  names.add("Adam");
  names.add("Eva");
  names.add("Jack");
  names.add("Emily");
  names.sort();
  assertTrue("Sort method", names.getFirst().equals ("Jack"));
}
	
This test shows limited access because it only checks for the first element on the list. The test will skip errors when the elements are from second or not sorted, that's why it does not reach the RIPR model's criteria.
Reachable: Yes, if the fault is first element.
Infection: Yes.
Propagation: No.
Reveal: No.