import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
	public static void main(String[] args) {
		

        String text = "0,23";
        String num = "";
        String delimiter = "";
		int result = 0;
		int signsCounter = 0;
		Pattern signPattern = Pattern.compile("\\D+");
        Matcher signMatcher = signPattern.matcher(text);
        
        Pattern digitPattern = Pattern.compile("\\d+");
        Matcher digitMatcher = digitPattern.matcher(text);
        
        while (signMatcher.find()) {
        	delimiter = signMatcher.group();
  	        if (!delimiter.equals(",")) {
  	        	System.out.println("Not allowed signs");
  	        	System.exit(0);
  	        }
  	        else {
  	        	signsCounter++;
  	        }

        }
        
        if(signsCounter > 1) {
	        	System.out.println("Too much digits");
	        	System.exit(0);;
        }
		
		
        while (digitMatcher.find()) {
        	 num = digitMatcher.group();
        	 result += Integer.parseInt(num);
        }
        System.out.println(result);
	
	}
}
