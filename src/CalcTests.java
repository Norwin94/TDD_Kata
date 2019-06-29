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
}
