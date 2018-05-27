# WeightWatchersAssignment
Question 1:

There is a file containing a word and its possible meanings (like a Dictionary). The contents of the file look like this:

Apple – a fruit, a tech firm
Table – an object, contains rows and columns when used in context of computers
Orange – a fruit

Given a path to the file, do the following:

a)	Create a method called doesFileExist(String path) which takes the path of the file and tells the user if the file exists at that path or not. Assume all paths are relative to your project structure. If the file does not exist, catch the requisite exception.
b)	Read each word and its possible meanings and print them out. Your output should look like this:

Word1
Meaning 1
Meaning 2
Word2
Meaning1
Meaning2

Use appropriate data structures wherever necessary.

Question 2:

The following exercise does not require user login. Please use ID or class as selectors. 

Steps:
1.	Navigate to https://www.weightwatchers.com/us/

2. Verify loaded page title matches “Weight Loss Program, Recipes & Help | Weight Watchers”
3. On the right corner of the page, click on “Find a Meeting”
4. Verify loaded page title contains “Get Schedules & Times Near You”
5. In the search field, search for meetings for zip code: 10011
6. Print the title of the first result and the distance (located on the right of location title/name)
7. Click on the first search result and then, verify displayed location name matches with the name of the first searched result that was clicked.
8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)

Write an automated test for this scenario using WebDriver.

Question 3:

Generate 500 random numbers and print the nth smallest number in a programming language of your choice.

