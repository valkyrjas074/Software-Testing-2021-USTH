Exercise 5.1
Suppose that coverage criterion C1 subsumes coverage criterion C2. Further suppose that test set T1 satisfies C1 on program P, and test set T2 satisfies C2, also on P.
	
(a) Does T1 necessarily satisfy C2? Explain.
Yes. T1 satisfies C1 and C1 subsumes C2.
	
b) Does T2 necessarily satisfy C1?
No. T2 satifies C2 but C2 is smaller than C1.
	
c) If P contains a fault, and T2 reveals the fault, T1 does not necessarily also reveal the fault?
T2 is not required to be subset of T1 so T2 may contains the test that reveals the fault but T1 does not.