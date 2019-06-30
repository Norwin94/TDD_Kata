import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
	
		public int Add(String text) throws Exception {
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
			
	        	List <String> negativeNumbers = new ArrayList<String>();
			    int sum = 0;
			    for(int i = 0; i < digitsLength; i++) {
			    	if(toInt(splitText[i]) < 0) negativeNumbers.add(splitText[i]);
			    	if(toInt(splitText[i]) > 1000) continue;
			        sum += toInt(splitText[i]);
			    }
			    if(!negativeNumbers.isEmpty()) throw new RuntimeException("negatives not allowed: " + negativeNumbers.toString());
		        return sum;
		}

		private int toInt(String text) {
			return Integer.parseInt(text);
		}
}
