
SentenceAnalyzer 	
 is a POJO with a function to read the string and find the longest word and its count.As a part of good practice and to support early testing SentenceAnalyzer has Unit tests support using JUnit. Upon execution of the tests it also produces a nice html report.
 
 
Getting Started 
 
 SentenceAnalyzer is delivered as a maven package which has dependencies of  java 7.0, Junit and Surefire referenced in the POM. Package can be cloned from https://github.com/win-coder/passion-projects.git. 

-	to execute the tests use - "mvn test" 
-	to generate html reports along with test execution use - "mvn surefire-report:report" 

  Assumptions 

-	The supplied sentence has standard delimiters limited to [\\t\\r\\n\\f]
-	Only the first matching word is returned

Future enhancements 

The following are a few of the possible enhancements suggested 

-	SentenceAnalyzer findLongestWord function can be changed to use Pairs and Array streaming using Java 8 to avoid loops.

-	Testing.xml to be added so the tests can be configured and can be used with a CI tool
