import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class CalcTests {
	 @Rule
	  public final ExpectedException exception = ExpectedException.none();
	 
	@Test
	public void emptyStringTest() throws Exception {
		Calc calc = new Calc();
		assertEquals(calc.Add(""), 0);
	}

	@Test
	public void oneDigitTest() throws Exception {
		Calc calc = new Calc();
		assertEquals(calc.Add("12"), 12);
	}
	
	@Test
	public void twoDigitsTest() throws Exception {
		Calc calc = new Calc();
		assertEquals(calc.Add("3,52"), 55);
	}
	
	@Test
	public void multipleDigitsTest() throws Exception {
		Calc calc = new Calc();
		assertEquals(calc.Add("0,4,12,3,5,6"), 30);
	}
	
	@Test
	public void multipleDigitsWithNewLineTest() throws Exception {
		Calc calc = new Calc();
		assertEquals(calc.Add("0\n4,12\n3,5\n6"), 30);
	}
	
	@Test
	public void newKindOfDelimiterTest() throws Exception {
		Calc calc = new Calc();
		assertEquals(calc.Add("//;\n1;4;2\n3;5\n6"), 21);
	}
	
	@Test
	public void negativesExceptionTest() throws Exception {
		Calc calc = new Calc();
		 assertThrows(Exception.class, () -> calc.Add("//;\n1;-4;2\n3;-5\n6"));
	}
	
	@Test
	public void ignoreBigNumbers() throws Exception {
		Calc calc = new Calc();
		 assertEquals(calc.Add("//;\n1;4;2\n3000;5\n10001"), 12);
	}
	
	@Test
	public void delimetersLengthExtentionTest() throws Exception {
		Calc calc = new Calc();
		 assertEquals(calc.Add("//;;;\n1;;;4\n2"), 7);
	}
	
	@Test
	public void longMultipleDelimetersTest() throws Exception {
		Calc calc = new Calc();
		 assertEquals(calc.Add("//[l][n][;]\n1l2n3;4"), 10);
	}
	
}
