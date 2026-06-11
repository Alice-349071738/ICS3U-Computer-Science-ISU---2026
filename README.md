# ICS3U-Computer-Science-ISU-2026

**Preparation:**

Variables:
- ArrayList <String> title = new ArrayList <>(); dynamically stores all song titles
- ArrayList <String> artist = new ArrayList <>(); dynamically stores all artist names
- ArrayList <Integer> rating = new ArrayList <>(); dynamically stores all ratings
- boolean mainLoop is initialized and used with the while (mainLoop) to bring the user back to the main menu continuously 
int userInput = Integer.parseInt(input.nextLine()); is used to  store the user input and avoid empty spaces being consumed as input

Logic:
- 3 ArrayLists are established to keep track of title, artist, and ratings 
- A boolean is used with a while loop to bring the user back to the main menu continuously
- An if, else if structure is used to compare the user input and move to the necessary part of the code

**Option 1:**

Variables:
- int songsAdded = 0; is initialized and used to keep track of the number of songs added
- boolean songsAddedLoop is initialized and used with the while (songsAddedLoop) to continue asking the user to add songs
- String variables songTitle, artistName, and songRating are used to add user input to the corresponding ArrayList

Logic:
- The program prompts users to input the title, artist, and rating of the song they would like to add while the variable songsAdded keeps track of the number of songs added 
- The boolean and while loop with songsAddedLoop continuously ask the user if they would like to add songs
- This loop is terminated by setting the boolean to false when the number of songs added is greater than two or the user inputs “no”

**Option 2:**

Variables:
- double averageRating is initialized to keep track of the sum of all ratings 
- for (int i = 0; i < rating.size(); i++) is used to iterate through the rating ArrayList
- roundedRating is initialized and used to hold onto the rounded value of averageRating 
- Math.round is used to round the averageRating to 2 decimal places

Logic:
- The program checks if there are any songs in the library before running using an if statement, checking if title.size() is equal to 0
- The for loop iterates through the rating ArrayList, adding each rating to averageRating
- Math.round is used to round averageRating 
- The rounded value is stored in roundedRating and then printed

**Option 3:**

Variables:
- int highestRating/lowestRating is set to the smallest/largest possible number and used for comparisons
- int indexMax/Min is set to 0 → the program assumes the smallest number is at index 0
- for (int i = 0; i < rating.size(); i++) iterates through the rating ArrayList 
- int current is used to hold the current rating at index i

Logic:
- The program iterates through the rating ArrayList with a for loop, comparing int current with the highestRating
- If the current rating is higher, the highestRating is replaced with the current rating
- If the highestRating is replaced, the index is also replaced to be the index of the current rating

**Option 4:**

Variables:
- boolean subMenuLoop is initialized and used with the while (subMenuLoop) to bring the user back to the sub menu continuously 
- int subMenuInput is used to hold the user input for the sub menu
- int index is used to hold the index of the song the user wishes to edit/remove
- String whatToEdit is used to hold what will be changed 
- String variables replaceTitle, replaceArtist, and replaceRating are used to hold what the title/artist/rating will be changed into

Logic:
- The user is prompted to enter what they want to do
- The user is then prompted to enter what they would like to change (title/artist/rating) 
- User is then prompted to enter what they want to change the title/artist/rating to
- .set is used to make the change 
- If user chooses to remove a song, .remove is used to remove the song across all ArrayLists

**Option 5:**

Variables:
- int fiveStarCounter/int fourStarCounter/int threeStarCounter/ int twoStarCounter/int oneStarCounter initialized to keep track of the amount of five/four/three/two/one star songs
- String line = "" is used to create each row of the graph

Logic:
- The for loop iterates through the rating ArrayList, sorting the songs by their rating and updating the counters
- The highest counter (tallest bar in graph) is determined by comparing the counters
- The second for loop creates each row of the bar graph, checking to see if each bar is high enough to have a # in that row
- Once all “bars” have been passed through, the completed line is printed all at once 

**Option 6:**

Variables:
- String search saves with the user wants to search
- int foundCounter keeps track of how many times a song/artist is found within the title ArrayList and artist ArrayList

Logic:
- What the user wishes to search for saved and then compared against each title/artist in title ArrayList and artist ArrayList 
- The average rating of the library is found and saved in roundedRating
- Each time an occurrence of what the user wishes to search for is found, the foundCounter increases. 
- The rating of the match is compared with the average rating and the corresponding message of above/below/equal is printed
- One for loop iterates through the title ArrayList, the second for loop iterates through the artist ArrayList
- Program checks if any songs were found → If counter = 0, no songs were found

**Option 7:**

Variables:
- ArrayList <String> sortTitle/sortArtist/sortRating initialized to copy over values from original ArrayLists
- int current = sortRating.get(j) holds number at index j
- int next = sortRating.get(j + 1) holds number at next index from j
- String tempTitle = sortTitle.get(j) saves current title at index j
- int percent20 saves how much 20 percent is within the current ArrayList sortRating

Logic:
- Copies of ArrayList title/artist/rating are made to rearrange everything without affecting the original ArrayLists 
- ArrayList rating is rearranged using two for loops that iterate through the ArrayList, comparing and swapping as needed 
- If a swap occurs in ArrayList sortRating, a swap also occurs in ArrayList sortTitle and ArrayList sortArtist to ensure data is aligned 
- If statement is used to ensure a song is still displayed even when there are limited songs and thus no “top 20%”
- Two for loops are used to print from 0 to last bottom twenty percent song, and from first top twenty percent song to last song in ArrayList

**Option 8:**

Logic:
- Exits the mainMenu by setting the boolean mainLoop to false

