package mc.challenge.analyzers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@SuppressWarnings({ "static-access" })
public class FindLongestWordTest {
	
	private static SentenceAnalyzer sa ;
	
	@Before
	public void setup(){
		sa = new SentenceAnalyzer();
	}
	
	@Test
	public void testFindLongestWord_ValidInput() {
			sa.findLongestWord("Look forward to meet the team");
			assertEquals("forward",sa.longest_word);
			assertEquals(7,sa.lword_length);
	}
	
	// as per assumption the first matching to return 
	@Test
	public void testFindLongestWord_two_words_with_same_length() {
			sa.findLongestWord("Looking forward to meet the team");
			assertEquals("Looking",sa.longest_word);
			assertEquals(7,sa.lword_length);
	}
	
	// as per assumption the its expected to be trimmed
	@Test
	public void testFindLongestWord_OneSpace() {
			sa.findLongestWord(" ");
			assertEquals(" ",sa.longest_word);
			assertEquals(0,sa.lword_length);
	}
	
	@Test
	public void testFindLongestWord_OneWord() {
			sa.findLongestWord("X");
			assertEquals("X",sa.longest_word);
			assertEquals(1,sa.lword_length);
	}
	
	// as per assumption the its expected to be trimmed
	@Test
	public void testFindLongestWord_OneWord_and_Space() {
			sa.findLongestWord("X ");
			assertEquals("X",sa.longest_word);
			assertEquals(1,sa.lword_length);
	}
	
	// testing Null pointer exception 
	@Test(expected=NullPointerException.class)
	public void testFindLongestWord_null_exception() {
			sa.findLongestWord(null);
	}
	
	@Test
	public void testFindLongestWord_Sentence_with_tab_delimited() {
			sa.findLongestWord("tab	delimited	expecting	no				failure");
			assertEquals("delimited",sa.longest_word);
			assertEquals(9,sa.lword_length);
	}
	
	// as per assumption csv is not a valid delimiter 
	@Test
	public void testFindLongestWord_Sentence_with_csv() {
			sa.findLongestWord("I;have;a;sentence;with;csv");
			assertEquals("I;have;a;sentence;with;csv",sa.longest_word);
			assertEquals(26,sa.lword_length);
	}
	
	// as per assumption '|' is not a valid delimiter 
	@Test
	public void testFindLongestWord_Sentence_with_pipe_delimiter() {
			sa.findLongestWord("I|have|a|sentence|with|csv");
			assertEquals("I|have|a|sentence|with|csv",sa.longest_word);
			assertEquals(26,sa.lword_length);
	}
	
	@Test
	public void testFindLongestWord_Sentence_with_special_chars() {
			sa.findLongestWord("When I said 'validate' I meant test'");
			assertEquals("'validate'",sa.longest_word);
			assertEquals(10,sa.lword_length);
	}
	
	@Test
	public void testFindLongestWord_Sentence_with_hyphen() {
			sa.findLongestWord("OOMPA-LOOMPA");
			assertEquals("OOMPA-LOOMPA",sa.longest_word);
			assertEquals(12,sa.lword_length);
	}
	
	@Test
	public void testFindLongestWord_Sentence_with_bigword() {
			sa.findLongestWord("Supercalifragilisticexpialidocious is a long word");
			assertEquals("Supercalifragilisticexpialidocious",sa.longest_word);
			assertEquals(34,sa.lword_length);
	}
	
	// making sure the performance is not very bad , this test sets a baseline for 100 milliseconds
	@Test(timeout=100)
	public void testFindLongestWord_long_sentence_performance() {
			sa.findLongestWord("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. "
					+ "Aenean commodo ligula eget dolor. Aenean massa. "
					+ "Cum sociis natoque penatibus et magnis dis parturient montes, "
					+ "nascetur ridiculus mus. Donec quam felis, ultricies nec, "
					+ "pellentesque eu, pretium quis, sem. "
					+ "Nulla consequat massa quis enim. Donec pede justo, "
					+ "fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, "
					+ "rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis "
					+ "eu pede mollis pretium. Integer tincidunt. Cras dapibus."
					+ " Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. "
					+ "Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. "
					+ "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. "
					+ "Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. "
					+ "Aenean imperdiet. Etiam ultricies nisi vel augue."
					+ " Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. "
					+ "Maecenas tempus, tellus eget condimentum rhoncus, "
					+ "sem quam semper libero, sit amet adipiscing sem neque sed ipsum. "
					+ "Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. "
					+ "Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis "
					+ "faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. "
					+ "Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. "
					+ "Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,");
			assertEquals("consectetuer",sa.longest_word);
			assertEquals(12,sa.lword_length);
	}
	
	@After
	public void teardown(){
		sa = null ;
	}

}
