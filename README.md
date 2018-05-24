# ESNameGenerator

This is a Java program that generates random, lore-friendly names for Elder Scrolls games. These names appeared at some point during the history of the Elder Scrolls game series. The Elder Scrolls II: Daggerfall used procedural generation, hence some first and last names are formulated using prefixes and suffixes.

Some races, such as argonians and the Khajiit don't have surnames while some other races, such as nords bear titles instead of traditional surnames. Both argonians and the Khajiit have unique naming conventions, argonians bear names that are in either argonian language or cyrodilic, while the Khajiit bear unique khajiiti names or cyrodilic names (very similar to argonians, but slightly different).

The program uses over 70 plain text files to generate the name that suits the character's identity defined by the user (race, gender). 

The Drives class instantiates the Input and NameGenerator classes. The Input class takes the user input and using those variables identifies the necessary files from the directory and passes strings on to the Combiner class and ExistingNames class. The Combiner class creates all possible combinations of prefixes and suffixes stored in the text file identified by the Input class. The ExistingNames class reads a file and builds strings of names. Both the Combiner and ExistingName class store their results in ArrayLists which is accessed by the NameGenerator class.
