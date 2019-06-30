import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
	
		public int Add(String text) {
	        if(text.isEmpty()) return 0;
	        
	        String newDelimeter = ",";
	        Matcher signMatcher = Pattern.compile("^//(.)\n([\\s\\S]*)").matcher(text);
	        if(signMatcher.matches()) {
	        	newDelimeter = signMatcher.group(1);
	        	text = signMatcher.group(2);
	        }
	        String textSplitSigns = newDelimeter + "|\n";
			String[] splitText = text.split(textSplitSigns);
			int digitsLength = splitText.length;
			
	        if (digitsLength == 1) return toInt(text);
	        
			else {
		    int sum = 0;
		    for(int i = 0; i < digitsLength; i++)
	        sum += toInt(splitText[i]);
	        return sum;
	        }
		}

		private int toInt(String text) {
			return Integer.parseInt(text);
		}
	
}
