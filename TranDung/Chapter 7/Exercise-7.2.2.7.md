Exercise 7.2.2.7
The graph defined by the following sets:
* N = {1, 2, 3}
* N0 = {1}
* Nf = {3}
* E = {(1, 2), (1, 3), (2, 1), (2, 3), (3, 1)}
	
Also consider the following (candidate) test paths:
* p1 = [1, 2, 3, 1]
* p2 = [1, 3, 1, 2, 3]
* p3 = [1, 2, 3, 1, 2, 1, 3]
* p4 = [2, 3, 1, 3]
* p5 = [1, 2, 3, 2, 3]
	
a) Draw a graph. Which of the listed paths are test paths? For any path that is not a test path, explain why not.
- p1 and p4 are not test paths. They don't start at 1 or end at 3.
- p5 is not a path because there is not edge (3,2).
	
b) List the eight test requirements for Edge-Pair Coverage (only the length two subpaths).
The eigth test requirements for Edge-Pair Coverage are:
[1,3,1] [1,2,3] [1,2,1] [2,3,1] [2,1,3] [2,1,2] [3,1,3] [3,1,2]
	
C) Does the set of test paths from part (a) above satisfy Edge-Pair Coverage? If not, state what is missing
T = {p2, p3} does not satifies Edge-Pair Coverage since [2,1,2] and [3, 1, 3] is not covered.
	
d) Consider the prime path [3, 1, 3] and path p2. Does p2 tour the prime path directly? With a sidetrip?
p2 does not tour prime path [3,1,3] directly, it tour with a sidetrip [3,1,2,3].