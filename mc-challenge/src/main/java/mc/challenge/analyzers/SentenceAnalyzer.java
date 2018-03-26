package mc.challenge.analyzers;

/**
* The SentenceAnalyzer class implements functions related with read and analyze the given sentence
* function - findLongestWord simply returns the longest word and the length of the given sentence
*
* @author  Rajmohan Ponnaiah
* @version 1.0
* @since   2018-03-25 
*/

public class SentenceAnalyzer {
	
	public static String longest_word ;
	public static int lword_length;
	
	public void findLongestWord(String sentence){	
	/* Splits the sentence - based on regex,  picks the longest word 
	 * gets word length and sets to class variables 
	 */
		if(sentence.trim().length() > 0){
				String regex = "[\\s\\t\\r\\n\\f]";
				String bigword =  "";				
				for (int i = 0; i < sentence.split(regex).length; i ++){		
					if(sentence.split(regex)[i].length() > bigword.length()){	
						bigword = sentence.split(regex)[i];		
					}
				}
				setLongestword(bigword);
				setLwordlength(bigword.length());
			}
		else{
			setLongestword(sentence);
			setLwordlength(0);
              }
		
   }

/* Scope modifier of the getters and setters can be altered in the future 
 * expose the methods if needed in the future  
 * Class variables scope also needs to be changed 
 */
/**
		 * @return the longest_word
		 */
		private static String getLongestword() {
			return longest_word;
		}
		
		/**
		 * @param longestword the longest_word to set
		 */
		private static void setLongestword(String longest_word) {
			SentenceAnalyzer.longest_word = longest_word;
		}
		
		/**
		 * @return the lword_length
		 */
		private static int getLwordlength() {
			return lword_length;
		}
		
		/**
		 * @param lwordlength the lword_length to set
		 */
		private static void setLwordlength(int lword_length) {
			SentenceAnalyzer.lword_length = lword_length;
		}

}
