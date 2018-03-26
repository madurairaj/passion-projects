SentenceAnalyzer has the following dependencies 
		- Java 7 
		- JUnit 
		- Surfire-reports 

	Functions and features 
		- Reads the sentence and finds the longest word and length 
		- Unit tests are added to verify the functionality
		- A html report is generated in the end of test execution

	  The following assumptions are made 
		- The first matching word is return 
		- The supplied sentence has standard delimiters [\\s\\t\\r\\n\\f]
		- Design comprises a class which can be used to add more functions in the future 
	
	  Getting started 

		 After cloning the repo from https://github.com/win-coder/passion-projects.git
	
	 	  - to Execute the tests "mvn test" command is used 

	 	  - to generate html reports "mvn surefire-report:report" command is used - report is located at /mc-challenge/target/site/surefire-report.html

	Future enhancements 
		
		- SentenceAnalyzer findLongestWord can be refactored to use Pairs and Array Streaming using Java 8 to avoid loops 
		- Testing.xml to be added so the tests can be configred to be used with a CI tool 
