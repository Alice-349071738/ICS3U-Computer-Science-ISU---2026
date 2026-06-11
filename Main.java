//NAME: Alice Long
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        Scanner input = new Scanner (System.in);

        ArrayList <String> title = new ArrayList <>();
        ArrayList <String> artist = new ArrayList <>();
        ArrayList <Integer> rating = new ArrayList <>(); //Establishes ArrayLists to track title, artist, and rating

        title.add("HYPNOTIZE"); artist.add("XG"); rating.add(96);
        title.add("Wildest Dreams"); artist.add("Taylor Swift"); rating.add(72);
        title.add("Madwoman"); artist.add("Laufey"); rating.add(87);
        title.add("party 4 u"); artist.add("Charli xcx"); rating.add(79);
        title.add("Gabriela"); artist.add("Katseye"); rating.add(73); //Add 5 songs to the catalogue

        System.out.println("Welcome to the Music Library Manager (MLM)!"); //Greeting message

        boolean mainLoop = true; //Establishes main loop to return to main menu after each time

        while (mainLoop) {
            
            System.out.println("\n===Main Menu===\n1. Add a song\n2. Average rating of the library\n3. Highest and Lowest rated songs\n4. Display the list of songs\n5. Display the Rating Distribution\n6. Search a song\n7. Display the top and bottom 20%\n8. Exit the program\n\nWhat would you like to do? (Enter a number between 1-8): "); //Prints menu
            int userInput = Integer.parseInt(input.nextLine());

            if (userInput < 1 || userInput > 8) {
                System.out.println("INVALID INPUT. Please try again."); //Checks if input is valid
            }

            else if (userInput == 1) { //Option 1

                System.out.println("Thank you for picking Option 1: Add a song");

                int songsAdded = 0; //Counter to keep track of number of songs added
                boolean songsAddedLoop = true; //Loop to be terminated by user or after number of songs added > 2

                while (songsAddedLoop) {
                    System.out.println("What is the title of the song you would like to add?");
                    String songTitle = input.nextLine();
                    title.add(songTitle); //Add title to ArrayList

                    System.out.println("What is the artist of the song you would to add?");
                    String artistName = input.nextLine();
                    artist.add(artistName); //Add artist to ArrayList

                    System.out.println("What is the rating of the song you would to add? (0-100)");
                    int songRating = Integer.parseInt(input.nextLine());

                    rating.add(songRating); //Add rating to ArrayList;

                    songsAdded++; //Increase counter

                    if (songsAdded ==2) {
                        songsAddedLoop = false; //Break loop if number of added songs > 2
                    }
                    else {
                        System.out.println("Would you like to add another song? (Yes/No): ");
                        String yesNo = input.nextLine().toLowerCase();

                        if (yesNo.equals("no")) {
                            songsAddedLoop = false; //Terminate loop if user does not want to add more songs
                        }
                    }
                }

            }

            else if (userInput == 2) { //Option 2

                System.out.println("Thank you for picking Option 2: Average rating of the library\nPlease wait, calculating the average rating of all songs...");

                if (title.size() == 0) {
                    System.out.println("There are no songs in the library. Please add songs in the main menu."); //Checks if there are songs
                } else {
                    double averageRating = 0; //Initialize variable to keep track of all ratings added together
                    for (int i = 0; i < rating.size(); i++) {
                        averageRating += rating.get(i);
                    }

                    averageRating = averageRating / rating.size(); //Find average rating

                    double roundedRating = Math.round(averageRating * 100.0) / 100.0; //Round average rating to 2 decimals

                    System.out.println("The average rating of all songs is: " + roundedRating);
                }

            }

            else if (userInput == 3) { //Option 3

                System.out.println("Thank you for picking Option 3: Highest and lowest rated songs");

                if (title.size() == 0) {
                    System.out.println("There are no songs in the library. Please add songs in the main menu.");
                } else {
                    int highestRating = Integer.MIN_VALUE; //Variable to track highest rated song
                    int indexMax = 0; //Variable to track index of highest rated song

                    for (int i = 0; i < rating.size(); i++) { //For loop to find highest rated song through comparison
                        int current = rating.get(i);

                        if (current > highestRating) {
                            highestRating = current; //Replace highestRating if new highest is found
                            indexMax = i; //Replace indexMax with the current index
                        }
                    }

                    int lowestRating = Integer.MAX_VALUE; //Variable to track lowest rated song
                    int indexMin = 0; //Variable to track index of lowest rated song

                    for (int i = 0; i < rating.size(); i++) {
                        int current = rating.get(i);

                        if (current < lowestRating) {
                            lowestRating = current; //Replace lowestRating if new lowest is found
                            indexMin = i; //Replace indexMin with the current index
                        }
                    }

                    System.out.println("\nThe highest rated song is:\nTitle: " + title.get(indexMax)+ "\nArtist: " + artist.get(indexMax) + "\nRating: " + rating.get(indexMax)); //Prints song with highest rating
                    System.out.println("\nThe lowest rated song is:\nTitle: " + title.get(indexMin)+ "\nArtist: " + artist.get(indexMin) + "\nRating: " + rating.get(indexMin)); //Prints song with lowest rating
                }

            }

            else if (userInput == 4) { //Option 4

                System.out.println("Thank you for picking Option 4: Display the list of songs");

                if (title.size() == 0) {
                    System.out.println("There are no songs in the library. Please add songs in the main menu."); //Checks if there are songs
                } else {
                    for (int i = 0; i < title.size(); i++) { //For loop to display all songs using their index
                        System.out.println("Song ID: " + i);
                        System.out.println("Title: " + title.get(i) + "\nArtist: " + artist.get(i) + "\nRating: " + rating.get(i) + "\n");
                    }

                    boolean subMenuLoop = true; //Creates submenu loop to loop submenu until user is finished

                    while (subMenuLoop) {
                        System.out.println("\n\t===Sub Menu===\n\t1. Edit a Song\n\t2. Remove a Song\n\t3. Return to the main menu\n\nWhat would you like to do from this submenu? (Enter a number between 1-3): ");
                        int subMenuInput = Integer.parseInt(input.nextLine());

                        if (subMenuInput < 1 || subMenuInput > 3) { //Check for invalid input for sub menu
                            System.out.println("INVALID INPUT. Please try again.");
                        } else if (subMenuInput == 1) {

                            if (title.size() == 0) {
                                System.out.println("There are no songs to be edited. Please add songs in the main menu.");
                            }
                            else {

                                System.out.println("What is the ID of the song you would like to edit?"); //Get song index
                                int index = Integer.parseInt(input.nextLine());

                                System.out.println("What would you like to edit: the title, artist or rating?"); //Get what part user wishes to edit
                                String whatToEdit = input.nextLine().toLowerCase();

                                if (whatToEdit.equals("title")) { //Replaces title
                                    System.out.println("What would you like to replace the title with?");
                                    String replaceTitle = input.nextLine();

                                    title.set(index, replaceTitle);

                                    System.out.println("\nSuccessful! The title was replaced."); //Prints messages to show the updated song
                                    System.out.println("\nThe song at ID " + index + " is now: ");
                                    System.out.println("Title: " + title.get(index) + "\nArtist: " + artist.get(index) + "\nRating: " + rating.get(index));

                                } else if (whatToEdit.equals("artist")) { //Replaces artist
                                    System.out.println("What would you like to replace the artist with?");
                                    String replaceArtist = input.nextLine();

                                    artist.set(index, replaceArtist);

                                    System.out.println("\nSuccessful! The artist was replaced."); //Prints messages to show the updated song
                                    System.out.println("\nThe song at ID " + index + " is now: ");
                                    System.out.println("Title: " + title.get(index) + "\nArtist: " + artist.get(index) + "\nRating: " + rating.get(index));

                                } else if (whatToEdit.equals("rating")) { //Replaces rating
                                    System.out.println("What would you like to replace the rating with?");
                                    int replaceRating = Integer.parseInt(input.nextLine());

                                    rating.set(index, replaceRating);

                                    System.out.println("\nSuccessful! The rating was replaced."); //Prints messages to show the updated song
                                    System.out.println("\nThe song at ID " + index + " is now: ");
                                    System.out.println("Title: " + title.get(index) + "\nArtist: " + artist.get(index) + "\nRating: " + rating.get(index));
                                }
                            }
                        }
                        else if (subMenuInput == 2) {

                            if (title.size() == 0) {
                                System.out.println("There are no more songs to be removed. Please add songs in the main menu.");
                            }
                            else {
                                System.out.println("What is the ID of the song you would like to remove?"); //Get song index
                                int index = Integer.parseInt(input.nextLine());

                                title.remove(index);
                                artist.remove(index);
                                rating.remove(index);

                                System.out.println("\nThe song at ID " + index + " is now removed.");

                                System.out.println("\nThe updated list is: ");
                                for (int i = 0; i < title.size(); i++) { //For loop to display all songs using their index
                                    System.out.println("Song ID: " + i);
                                    System.out.println("Title: " + title.get(i) + "\nArtist: " + artist.get(i) + "\nRating: " + rating.get(i) + "\n");
                                }
                            }
                        }
                        else if (subMenuInput == 3) {
                            subMenuLoop = false;
                        }
                    }
                }
            }

            else if (userInput == 5) {

                System.out.println("Thank you for picking Option 5: Display the rating distribution chart\nThe rating distribution chart is: ");

                if (title.size() == 0) {
                    System.out.println("There are no songs in the library. Please add songs in the main menu."); //Checks if there are songs
                } else {
                    int fiveStarCounter = 0; //Initialize counters
                    int fourStarCounter = 0;
                    int threeStarCounter = 0;
                    int twoStarCounter = 0;
                    int oneStarCounter = 0;

                    for (int i = 0; i < rating.size(); i++) {
                        int current = rating.get(i);

                        if (current >= 90 && current <= 100) {
                            fiveStarCounter++;
                        } else if (current >= 75) {
                            fourStarCounter++;
                        } else if (current >= 60) {
                            threeStarCounter++;
                        } else if (current >= 40) {
                            twoStarCounter++;
                        } else
                            oneStarCounter++;
                    }

                    int tallest = fiveStarCounter; //Set tallest to any variable
                    if (fourStarCounter > tallest) //Check if next counter is greater, if it is, replace current tallest with that counter
                        tallest = fourStarCounter;
                    if (threeStarCounter > tallest)
                        tallest = threeStarCounter;
                    if (twoStarCounter > tallest)
                        tallest = twoStarCounter;
                    if (oneStarCounter > tallest)
                        tallest = oneStarCounter;

                    for (int i = tallest; i >= 1; i--) { //Starting graph from greatest "row" and go down
                        String line = ""; //Empty string for each line
                        for (int j = 0; j < 5; j++) { //Within each line, check each "column" from left to right

                            if (j == 0 && fiveStarCounter >= i) { //If in first column, and counter >= i (bar is tall enough), draw #
                                line += "  #  ";
                            } else if (j == 1 && fourStarCounter >= i) {
                                line += "  #  ";
                            } else if (j == 2 && threeStarCounter >= i) {
                                line += "  #  ";
                            } else if (j == 3 && twoStarCounter >= i) {
                                line += "  #  ";
                            } else if (j == 4 && oneStarCounter >= i) {
                                line += "  #  ";
                            } else
                                line += "     "; //Otherwise, if counter < i (aka bar not tall enough to have a # in this row), enter a space
                        }

                        System.out.println(line); //Prints the whole row in one go

                    }

                    System.out.println("_________________________"); //Prints labels of graph
                    System.out.println("  5*   4*   3*   2*   1* ");
                }

            }

            else if (userInput == 6) {

                System.out.println("Thank you for picking Option 6: Search for a song");

                if (title.size() == 0) {
                    System.out.println("There are no songs in the library. Please add songs in the main menu."); //Checks if there are songs
                } else {
                    System.out.println("What song title/artist would you like to search for?"); //Prompt for user input
                    String search = input.nextLine().toLowerCase();

                    int foundCounter = 0; //Initialize counter to track number of times song/artist is found

                    double averageRating = 0; //Initialize variable to keep track of all ratings added together
                    for (int i = 0; i < rating.size(); i++) {
                        averageRating += rating.get(i);
                    }
                    averageRating = averageRating / rating.size(); //Find average rating
                    double roundedRating = Math.round(averageRating * 100.0) / 100.0; //Round average rating to 2 decimals

                    for (int i = 0; i < title.size(); i++) { //For loop to check if the ArrayList title contains the search
                        String current = title.get(i).toLowerCase();
                        
                        if (current.contains(search)) {
                            System.out.println("\nThe song can be found at ID " + i + "\nTitle: " + title.get(i) + "\nArtist: " + artist.get(i) + "\nRating: " + rating.get(i));
                            foundCounter++;
                            
                            if (rating.get(i) > roundedRating) //Check if rating is above, below, or equal to the average rating of the library
                                System.out.println("This song is above the library average rating of " + roundedRating);
                            
                            else if (rating.get(i) < roundedRating)
                                System.out.println("This song is below the library average rating of " + roundedRating);
                            
                            else
                                System.out.println("This song is equal to the library average rating of " + roundedRating);
                        }
                    }

                    for (int i = 0; i < artist.size(); i++) { //For loop to check if the ArrayList artist contains the search
                        String current = artist.get(i).toLowerCase();
                        
                        if (current.contains(search)) {
                            System.out.println("\nThe artist can be found at song ID " + i + "\nTitle: " + title.get(i) + "\nArtist: " + artist.get(i) + "\nRating: " + rating.get(i));
                            foundCounter++;
                            
                            if (rating.get(i) > roundedRating) //Check if rating is above, below, or equal to the average rating of the library
                                System.out.println("This song is above the library average rating of " + roundedRating);
                            
                            else if (rating.get(i) < roundedRating)
                                System.out.println("This song is below the library average rating of " + roundedRating);
                            
                            else
                                System.out.println("This song is equal to the library average rating of " + roundedRating);
                        }
                    }

                    if (foundCounter == 0)
                        System.out.println("The song cannot be found.");
                }

            }

            else if (userInput == 7) {

                System.out.println("Thank you for picking Option 7: Display the top 20%/bottom 20%");

                ArrayList <String> sortTitle = new ArrayList<>(); //Initialize new ArrayList
                for (int i = 0; i < title.size(); i++) { //Fill ArrayList by copying over from original title ArrayList
                    sortTitle.add(title.get(i));
                }

                ArrayList <String> sortArtist = new ArrayList<>(); //Initialize new ArrayList
                for (int i = 0; i < artist.size(); i++) { //Fill ArrayList by copying over from original artist ArrayList
                    sortArtist.add(artist.get(i));
                }

                ArrayList <Integer> sortRating = new ArrayList<>(); //Initialize new ArrayList
                for (int i = 0; i < rating.size(); i++) { //Fill ArrayList by copying over from original rating ArrayList
                    sortRating.add(rating.get(i));
                }

                for (int i = 0; i < rating.size(); i++) { //How many "passes" are needed to sort the ArrayList
                    for (int j = 0; j < rating.size() - 1; j++) { //"Walks through" the numbers, Must be -1, otherwise error when .get(j+1)
                        int current = sortRating.get(j); //Initializes variable to store what ArrayList rating is at index j
                        int next = sortRating.get(j + 1); //Initializes variable to store what ArrayList rating is at index j + 1

                        if (current > next) { //Compares, if true swap places
                            sortRating.set(j, next);
                            sortRating.set(j+1, current);

                            //If a swap occurs in rating list, swap must ALSO occur in the other two lists

                            String tempTitle = sortTitle.get(j); //MUST MUST MUST SAVE otherwise error, it will have already been swapped
                            sortTitle.set(j, sortTitle.get(j + 1)); //Swap
                            sortTitle.set(j + 1, tempTitle);

                            String tempArtist = sortArtist.get(j); //Save
                            sortArtist.set(j, sortArtist.get(j + 1)); //Swap
                            sortArtist.set(j + 1, tempArtist);
                        }

                    }
                }

                if (sortRating.size() == 0) {
                    System.out.println("There are no songs in the library. Please add songs in the main menu."); //Checks if there are songs
                } else {

                    int percent20 = (int)(sortRating.size() * 0.20); //Find 20 percent

                    if (percent20 == 0) { //If list small and int 20 percent is 0 when there are NOT 0 songs, manually assign percent20
                        percent20 = 1;
                    }

                    System.out.println("\nThe songs in the bottom 20% of ratings are:");
                    for (int i = 0; i < percent20; i++) { //For loop to print from first song to last of bottom 20%
                        System.out.println("Title: " + sortTitle.get(i)+ "\nArtist: " + sortArtist.get(i) + "\nRating: " + sortRating.get(i) + "\n");

                    }

                    System.out.println("The songs in the top 20% of ratings are:");
                    for (int i = sortRating.size() - percent20; i < sortRating.size(); i++) { //For loop to print from first of top 20% until end of the list
                        System.out.println("Title: " + sortTitle.get(i)+ "\nArtist: " + sortArtist.get(i) + "\nRating: " + sortRating.get(i) + "\n");
                    }
                }

            }

            else if (userInput == 8) {
                mainLoop = false;
            }
        }

        System.out.println("Thank you so much for using the Music Library Manager (MLM)! We hope to see you again soon."); //Final message
        input.close();
    }

} //It's been super fun learning how to code with you this semester Ms. Rastegar!! Hope you have a wonderful summer break:)
