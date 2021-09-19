# text-simplifier-api
Advanced Object Oriented Software Development Java project 

The application contains one interface:
* APIWordParser


One enumeration:
* ConsoleColour – which was provided by the lecturer. I used this enum to change the colour of the text in the GUI to WHITE_BOLD_BRIGHT, as well as changing the colour of the inputted and outputted text to YELLOW_BOLD_BRIGHT.


Three classes:
A. WordParser – which implements the APIWordParser interface. This class contains 4 methods:
1. +mapGoogleWord(): void
2. +mapThesaurus(): void
3. +addAll(String[] words, String googleWord): void
4. +getGoogleWord(String word): String

These methods are used to parse information from 2 files, a list of 1000 most commonly used Google words and a Thesaurus. The words are mapped using a TreeMap – the Google words as keys and the thesaurus words as values. The getGoogleword method returns the String value mapped to the key word passed in as a parameter.

B. Input – which contains one method:
1. +start(): void

A class that outputs the Text Simplifier GUI and allows the user to input text via a Scanner. The words, parsed and mapped by the WordParser class, are swopped with Google 1000 words synonyms and output to the console. ANSI escape codes from the ConsloleColour enum are used for colouring the text seen in the terminal window. Ten words only output to the terminal before a new line is printed.

C. Runner – which contains one method:
1. +main(String[] args): void
A class containing the main method is used to launch the application. An Input object is instantiated and used to call the start method from the Input class which launches the application. Run the application from this class.


