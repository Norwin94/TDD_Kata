import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//just adding comment to see if i can upload this by Eclipse
public class Calc {
	
		public int Add(String text) throws Exception {
	        if(text.isEmpty()) return 0;
	        
	        String newDelimiter = ",";
	        
	        Matcher signMatcher = Pattern.compile("^//(.*)\n([\\s\\S]*)").matcher(text);
	        Matcher multiSignMatcher = Pattern.compile("^//\\[(.*)\\]\n([\\s\\S]*)").matcher(text);
	        
	        if(multiSignMatcher.matches()) {
		        String multiDelimiters = "";
	        	newDelimiter = multiSignMatcher.group(1);
	    		String[] dell = newDelimiter.split("\\]\\[");
			    for(int i = 0; i < dell.length; i++) {
			    	if(i == dell.length - 1)	multiDelimiters +=  dell[i];
			    	else multiDelimiters +=  dell[i] + "|";
			    }     
			    newDelimiter = multiDelimiters;
			    text = multiSignMatcher.group(2);
	        }
	        else  {
	        	if(signMatcher.matches()) {
		        	newDelimiter = signMatcher.group(1);
		        	text = signMatcher.group(2);
		        }
	        }
	        
	        String textSplitSigns = newDelimiter + "|\n";
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
	
		public static void main(String[] args) throws Exception {
			Calc calc = new Calc();
			System.out.println(calc.Add("//[l][n][;;]\n1l2n3;;4"));
		}
		
}