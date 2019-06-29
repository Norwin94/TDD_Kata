import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
	
		public int Add(String text) {
	        if(text.isEmpty()) return 0;
	        
			String[] splitText = text.split(",");
	        if (splitText.length == 1) return Integer.parseInt(text);
	        else {
		    int sum = 0;
	        sum = Integer.parseInt(splitText[0]) + Integer.parseInt(splitText[1]);
	        return sum;
	        }
		}
		
	public static void main(String[] args) {
		Calc calc = new Calc();
		System.out.println(calc.Add("0,4"));
	}
}
