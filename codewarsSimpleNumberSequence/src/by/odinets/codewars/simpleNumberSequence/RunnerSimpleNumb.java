package by.odinets.codewars.simpleNumberSequence;

public class RunnerSimpleNumb {

	public static void main(String[] args) {
	
		String[] rowStr = {"123567",
							//"899091939495",
							//"9899101102",
							//"599600601602",
							//"8990919395",
							//"998999100010011003",
							//"99991000110002",
							//"979899100101102",
							//"9394969798",
							"92939495969798100101102103",
							"900001900002900004900005900006"};
		/*
		 * assertEquals(4,Solution.missing("123567"));
        assertEquals(92,Solution.missing("899091939495"));
        assertEquals(100,Solution.missing("9899101102"));
        assertEquals(-1,Solution.missing("599600601602"));
        assertEquals(-1,Solution.missing("8990919395"));
        assertEquals(1002,Solution.missing("998999100010011003"));
        assertEquals(10000,Solution.missing("99991000110002"));
        assertEquals(-1,Solution.missing("979899100101102"));
        assertEquals(900003,Solution.missing("900001900002900004900005900006"));
		 */
		for(String el : rowStr) {
			System.out.println("********************************************");
			System.out.println("rowStr :: " + el);
			int result = Solution.missing(el);
			System.out.println("result solution :: " + result);
		}
		
		/*for(String el : rowStr) {
			System.out.println("********************************************");
			int result = Solution1.missing(el);
			System.out.println("rowStr :: " + el);
			System.out.println("result solution :: " + result);
		}*/
		
	}
	
}
