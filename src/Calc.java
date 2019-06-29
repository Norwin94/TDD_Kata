
public class Calc {
	
		public int Add(String text) {
	        if(text.isEmpty()) return 0;
	        
			String[] splitText = text.split(",");
			int digitsLength = splitText.length;
	        if (digitsLength == 1) return Integer.parseInt(text);
	        else {
		    int sum = 0;
		    for(int i = 0; i < digitsLength; i++)
	        sum += Integer.parseInt(splitText[i]);
	        return sum;
	        }
		}
		
}
