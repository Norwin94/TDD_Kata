import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class CalcTests {
	
	@Test
	public void emptyStringTest() {
		Calc calc = new Calc();
		assertEquals(calc.Add(""), 0);
	}

	@Test
	public void oneDigitTest() {
		Calc calc = new Calc();
		assertEquals(calc.Add("12"), 12);
	}
	
	@Test
	public void twoDigitsTest() {
		Calc calc = new Calc();
		assertEquals(calc.Add("3,52"), 55);
	}
	
	@Test
	public void multipleDigitsTest() {
		Calc calc = new Calc();
		assertEquals(calc.Add("0,4,12,3,5,6"), 30);
	}
	
	@Test
	public void multipleDigitsWithNewLineTest() {
		Calc calc = new Calc();
		assertEquals(calc.Add("0\n4,12\n3,5\n6"), 30);
	}
	
	@Test
	public void newKindOfDelimiterTest() {
		Calc calc = new Calc();
		assertEquals(calc.Add("//;\n1;4;2\n3;5\n6"), 21);
	}
}
