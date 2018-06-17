/*********** Please note that I did utilize JOptionPanes so it might not perfectly run at times
  * Class: DealOrNoDealV2.java
  * Name: Anis Tariq
  * Date: Jan 13, 2016
  * Desc: The following program will replicate the game deal or no deal
  ***********/
import java.util.*; // Allows the user to input values
import java.util.concurrent.TimeUnit; // Imports the time delayer package
import javax.swing.*; // Import Java swing
import java.lang.Object; // Import java lang object

public class DealOrNoDealFinal // Class name
{
  public static double bankOffer(ArrayList<Integer> casevalue) // This calculates the average for the banker's offer. This was from the website https://www.daniweb.com/programming/game-development/threads/286244/deal-or-no-deal-in-java
  {
    // 'average' is undefined if there are no elements in the list.
    if (casevalue == null || casevalue.isEmpty())
      return 0.0;
    // Calculate the summation of the elements in the list
    long sum = 0;
    int n = casevalue.size();
    // Iterating manually is faster than using an enhanced for loop.
    for (int i = 0; i < n; i++)
      sum += casevalue.get(i);
    // We don't want to perform an integer division, so the cast is mandatory.
    return ((double) sum) / n;
  }
  public static void finalCases(ArrayList<Integer> casevalue, ArrayList<Integer> casenum) //Method not returning value
  {
    Scanner input = new Scanner(System.in); // Allows user to input values
    // Declaring variables
    int userpickcase = 0;
    int amountcase6 = 1;
    // For loop
    for(int n = 0; n < 1; n++)
    {
      // Prompts user to pick case
      System.out.println("Now pick " + amountcase6 + " more case");
      // Collects input
      userpickcase = input.nextInt();
      amountcase6--; // Amount case is decremented by 1
      if ((userpickcase > 26) || (userpickcase < 0) || (userpickcase == 0) || (casenum.get(userpickcase-1) == 0)) // If condition
      {
        n--; // n decremented by 1
        amountcase6++; // Amount case 6 incremented by 1
        continue; // Skips everything after in this for loop making the iteration not exist
      }
      while (casenum.get(userpickcase-1) != 0) // While loop when element in Array List casenum does not equal 0
      {
        // Variable amountcase is decremented by 1
        System.out.println("Case number " + casenum.get(userpickcase-1) + " had $" + casevalue.get(userpickcase-1)); // Outputs the case number and the value
        // Sets user's input to the matched index value (which in this case is 1 less) to -1
        casenum.set(userpickcase-1, 0); 
        casevalue.set(userpickcase-1, 0);
        // Prints Array List
        System.out.println(casenum); 
        System.out.println(casevalue);       
      }
    }
  }
  public static void elseCase(int usercase, ArrayList<Integer> casevalue) throws InterruptedException // Interrupted execption for time delay
  {
    
    // Thanks user
    System.out.println("\nThank you for playing deal or No Deal!");
    System.out.println("Your case held: $" + casevalue.get(usercase-1)); //Displays player's case value
    //Delays program by 5 seconds
    TimeUnit.SECONDS.sleep(5);
    System.exit(0); // Exits out of the code
  }
  public static void main(String [] args) throws InterruptedException // Main method, Interrupted execption for time delay
  {
    Scanner input = new Scanner(System.in); // Allows user to input values
    // Declaring Arrays
    int[] choice = new int [10]; 
    int[] bankoffer = new int[11];
    int[] userpickcases = new int [6];
    // Array List declaration 
    ArrayList <Integer> casenum = new ArrayList<Integer>();
    ArrayList <Integer> casevalue = new ArrayList<Integer>();
    Object [] arr = {"Deal", "No Deal"};
    // Declaring variables
    int usercase = 0;
    int userswitchcase = 0;
    int usernewcase = 0;
    int swapcases = 0;
    int amountcase1 = 6,amountcase2 = 5, amountcase3 = 4,amountcase4 = 3, amountcase5 = 2; // An array here could not have been used as numbers 1 to 5 (inclusive) do not have the same values
    
    // Adds all values in Array List
    Collections.addAll(casenum, 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26); 
    Collections.addAll(casevalue,1,5,10,50,100,200,300,400,500,750,1000,5000,10000,50000,100000,150000,200000,250000,300000,350000,400000,450000,500000,750000,1000000,1500000);
    Collections.shuffle(casevalue); // Shuffles the Array List
    
    // Welcomes user
    System.out.println("Welcome to Deal or No deal! I am your host Anis Tariq. We will get started in a bit. There will be 26 cases. The game is very interesting. ");
    //Prompts user to either click deal or no deal using the JOptionPane   
    choice[0] = JOptionPane.showOptionDialog(null,"Deal or No Deal","Deal or No Deal", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,arr,arr[0]);
    
    if (choice[0] == 0) // If statement, if choice[6] equals 1
    {
      // Welcomes and explains rules
      System.out.println("Once again welcome! Now pick your case and we will get started! Each of these case will contain cash!\n");
      System.out.println("Numbered Cases"); // Numbered Cases
      System.out.println(casenum); // Prints Array List
      System.out.println("\nMoney Available"); // Money Available
      System.out.println(casevalue); // Prints Array List
      System.out.print("Please select your case number:"); // Prompts user to select a number
      usercase = input.nextInt(); // Collects Value
      // Sets user's input to the matched index value (which in this case is 1 less) to -1
      casenum.set(usercase-1, 0); 
      //Prints Array List
      System.out.println(casenum);
      System.out.println(casevalue);
      
      // For loop
      for(int i = 0; i < 6; i++)
      { 
        // Prompts user to pick case
        System.out.println("Now pick " + amountcase1 + " more cases");
        // Collects input
        userpickcases[i] = input.nextInt();
        amountcase1--; // Amount case is decremented by 1
        if ((userpickcases[i] > 26) || (userpickcases[i] < 1) || (casenum.get(userpickcases[i]-1) == 0)) // If statement
        {
          i--; // i decremented by 1
          amountcase1++; // i incremented by 1      
          continue; // Skips everything after 
        }
        while (casenum.get(userpickcases[i]-1) != 0) // While loop when element in Array List casenum does not equal -1
        {
          // Variable amountcase is decremented by 1
          System.out.println("Case number " + casenum.get(userpickcases[i]-1) + " had $" + casevalue.get(userpickcases[i]-1)); // Outputs the case number and the value      
          // Sets user's input to the matched index value (which in this case is 1 less) to -1
          casenum.set(userpickcases[i]-1, 0); 
          casevalue.set(userpickcases[i]-1, 0);
          // Prints Array List
          System.out.println(casenum); 
          System.out.println(casevalue);
        }
      }
      // Calculates Banker's offer
      bankoffer[0] = (int)(bankOffer(casevalue));
      System.out.println("Its the banker, he's making you an offer of $" + bankoffer[0]); // Displays offer
      //Delays program
      TimeUnit.SECONDS.sleep(5);
      //Shows button for deal or no deal
      choice[1] = JOptionPane.showOptionDialog(null,"Deal or No Deal?","Deal or No Deal?", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,arr,arr[0]);
      // Deal = 0, No Deal = 1
      if (choice[1] == 1) // If statement, if choice[1] equals 1
      {
        // For loop
        for(int j = 0; j < 5; j++)
        { 
          // Prompts user to pick case
          System.out.println("Now pick " + amountcase2 + " more cases");
          // Collects input
          userpickcases[j] = input.nextInt();
          amountcase2--; // Amount case is decremented by 1
          if ((userpickcases[j] > 26) || (userpickcases[j] < 1) || (casenum.get(userpickcases[j]-1) == 0)) // If statement
          {
            j--; // j decremented by 1
            amountcase2++; // amount case 2 incremented by 1       
            continue; // Skips everything after in this for loop making the iteration not exist
          }
          while (casenum.get(userpickcases[j]-1) != 0) // While loop when element in Array List casenum does not equal -1
          {
            // Variable amountcase is decremented by 1
            System.out.println("Case number " + casenum.get(userpickcases[j]-1) + " had $" + casevalue.get(userpickcases[j]-1)); // Outputs the case number and the value
            // Sets user's input to the matched index value (which in this case is 1 less) to -1
            casenum.set(userpickcases[j]-1, 0); 
            casevalue.set(userpickcases[j]-1, 0);
            // Prints Array List
            System.out.println(casenum); 
            System.out.println(casevalue);
          }
        }  
      } 
      else
      {
        elseCase(usercase,casevalue); // Calls Method
      }
      bankoffer[1] = (int)(bankOffer(casevalue));// Banker's offer
      System.out.println("Its the banker, he's making you an offer of $" + bankoffer[1]); // Outputs offer
      //Delays program by 5 seconds
      TimeUnit.SECONDS.sleep(5);
      //Choice[1] equals deal or no deal, JOption Pane method used here
      choice[2] = JOptionPane.showOptionDialog(null,"Deal or No Deal?","Deal or No Deal?", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,arr,arr[0]);
      // Deal = 0, No Deal = 1
      if (choice[2] == 1) // If statement Choice[2] equals 1
      {
        // For loop
        for(int k = 0; k < 4; k++)
        { 
          // Prompts user to pick case
          System.out.println("Now pick " + amountcase3 + " more cases");
          // Collects input
          userpickcases[k] = input.nextInt(); // Collects input in array list
          amountcase3--; // Amount case is decremented by 1
          if ((userpickcases[k] > 26) || (userpickcases[k] < 1) || (casenum.get(userpickcases[k]-1) == 0)) // If statement
          {
            k--; // k decremented by 1
            amountcase3++; // amount case 3 incremented by 1
            continue; // Skips everything after in this for loop making the iteration not exist
          }
          while (casenum.get(userpickcases[k]-1) != 0) // While loop when element in Array List casenum does not equal -1 
          {
            // Variable amountcase is decremented by 1
            System.out.println("Case number " + casenum.get(userpickcases[k]-1) + " had $" + casevalue.get(userpickcases[k]-1)); // Outputs the case number and the value
            // Sets user's input to the matched index value (which in this case is 1 less) to -1
            casenum.set(userpickcases[k]-1, 0); 
            casevalue.set(userpickcases[k]-1, 0);
            // Prints Array List
            System.out.println(casenum); 
            System.out.println(casevalue);
          }
        }
      }
      else
      {
        elseCase(usercase,casevalue); // Calls Method
      }
      // Banker's offer
      bankoffer[2] = (int)(bankOffer(casevalue));
      System.out.println("Its the banker, he's making you an offer of $" + bankoffer[2]); // Displays value
      //Delays program by 5 seconds
      TimeUnit.SECONDS.sleep(5);
      // Choice[3] will be deal or no deal, JOption Pane method again used here
      choice[3] = JOptionPane.showOptionDialog(null,"Deal or No Deal?","Deal or No Deal?", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,arr,arr[0]);
      // Deal = 0, No Deal = 1
      if (choice[3] == 1) // If statement choice[3] = 1
      {
        // For loop
        for(int l = 0; l < 3; l++)
        { 
          // Prompts user to pick case
          System.out.println("Now pick " + amountcase4 + " more cases");
          // Collects input
          userpickcases[l] = input.nextInt();
          amountcase4--; // Amount case is decremented by 1
          if ((userpickcases[l] > 26) || (userpickcases[l] < 1) || (casenum.get(userpickcases[l]-1) == 0))
          {
            // If statement     
            l--; // L decremented by 1
            amountcase4++; // Amount case 4 incremented by 1      
            continue; // Skips everything after in this for loop making the iteration not exist
          }
          while (casenum.get(userpickcases[l]-1) != 0) // While loop when element in Array List casenum does not equal -1
          {
            // Variable amountcase is decremented by 1
            System.out.println("Case number " + casenum.get(userpickcases[l]-1) + " had $" + casevalue.get(userpickcases[l]-1)); // Outputs the case number and the value
            // Sets user's input to the matched index value (which in this case is 1 less) to -1
            casenum.set(userpickcases[l]-1, 0); 
            casevalue.set(userpickcases[l]-1, 0);
            // Prints Array List
            System.out.println(casenum); 
            System.out.println(casevalue);       
          }
        }
      }
      else
      {
        elseCase(usercase,casevalue); // Calls method
      }
      // Banker's offer
      bankoffer[3] = (int)(bankOffer(casevalue));
      System.out.println("Its the banker, he's making you an offer of $" + bankoffer[3]); // Display's offer
      // Delays program by 5 seconds
      TimeUnit.SECONDS.sleep(5);
      // Choice[4] equals deal or no deal
      choice[4] = JOptionPane.showOptionDialog(null,"Deal or No Deal?","Deal or No Deal?", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,arr,arr[0]);
      // Deal = 0, No deal = 1
      if (choice[4] == 1) // If statement, if choice[4] equals 1
      {
        // For loop
        for(int m = 0; m < 2; m++)
        { 
          // Prompts user to pick case
          System.out.println("Now pick " + amountcase5 + " more cases");
          // Collects input
          userpickcases[m] = input.nextInt();
          amountcase5--; // Amount case is decremented by 1
          if ((userpickcases[m] > 26) || (userpickcases[m] < 1) || (casenum.get(userpickcases[m]-1) == 0)) // If statement 
          {
            m--; // m decremented by 1
            amountcase5++; // Amount case 5 incremented by 1
            continue; // Skips everything after in this for loop making the iteration not exist
          }
          while (casenum.get(userpickcases[m]-1) != 0) // While loop when element in Array List casenum does not equal -1
          {
            // Variable amountcase is decremented by 1
            System.out.println("Case number " + casenum.get(userpickcases[m]-1) + " had $" + casevalue.get(userpickcases[m]-1)); // Outputs the case number and the value
            // Sets user's input to the matched index value (which in this case is 1 less) to -1
            casenum.set(userpickcases[m]-1, 0); 
            casevalue.set(userpickcases[m]-1, 0);
            // Prints Array List
            System.out.println(casenum); 
            System.out.println(casevalue);       
          }
        }
      }
      else
      {
        elseCase(usercase,casevalue); // Calls method
      }
      // Generates banker's offer to buy the case. 
      bankoffer[4] = (int)(bankOffer(casevalue));
      System.out.println("Its the banker, he's making you an offer of $" + bankoffer[4]); // DIsplays offer
      // Delays time by 5 seconds
      TimeUnit.SECONDS.sleep(5);
      // Choice[5] equals deal or no deal, JOption Pane method used
      choice[5] = JOptionPane.showOptionDialog(null,"Deal or No Deal?","Deal or No Deal?", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,arr,arr[0]);
      // Deal = 0, No Deal = 1
      if (choice[5] == 1) // If statement when choice[5] equals 1
      {
        finalCases(casevalue,casenum); // final Cases method used
      }
      else
      {
        elseCase(usercase,casevalue); // elseCase method used
      }
      // Generates banker's offer to buy the case.
      bankoffer[5] = (int)(bankOffer(casevalue));
      System.out.println("Its the banker, he's making you an offer of $" + bankoffer[5]); // DIsplays offer
      // Delays program by 5 seconds
      TimeUnit.SECONDS.sleep(5);
      choice[6] = JOptionPane.showOptionDialog(null,"Deal or No Deal?","Deal or No Deal?", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,arr,arr[0]);
      // Deal = 0, No Deal = 1
      if (choice[6] == 1) // If statement when choice[6] equals 1
      {
        finalCases(casevalue,casenum); // Calls method finalCases
      }
      else
      {
        elseCase(usercase,casevalue); // Calls method elseCase
      }
      // Generates banker's offer to buy the case.
      bankoffer[6] = (int)(bankOffer(casevalue));
      System.out.println("Its the banker, he's making you an offer of $" + bankoffer[6]); // Displays offer
      //Delays time by 5 seconds
      TimeUnit.SECONDS.sleep(5);
      // Choice[7] equals deal or no deal, JOption Pane method used
      choice[7] = JOptionPane.showOptionDialog(null,"Deal or No Deal?","Deal or No Deal?", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,arr,arr[0]);
      // Deal = 0, No Deal = 1
      if (choice[7] == 1) // If statement when choice[7] equals 1
      {
        finalCases(casevalue,casenum); // Calls Method finalCases
      }
      else
      {
        elseCase(usercase,casevalue); // Calls Method elseCase
      }
      // Generates banker's offer to buy the case
      bankoffer[7] = (int)(bankOffer(casevalue));
      System.out.println("Its the banker, he's making you an offer of $" + bankoffer[7]); // Displays offer
      // Delays program by 5 seconds
      TimeUnit.SECONDS.sleep(5);
      // Choice[8] equals deal or no deal JOption Pane method
      choice[8] = JOptionPane.showOptionDialog(null,"Deal or No Deal?","Deal or No Deal?", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,arr,arr[0]);
      // Deal = 0, No Deal = 1
      if (choice[8] == 1) // If statement when choice[8] equals 1
      {
        finalCases(casevalue,casenum); // Calls method finalCases
      }
      else
      {
        elseCase(usercase,casevalue); // Calls method elseCase
      }
      // Generates banker's offer to buy the case. This basically takes the maximum value available and divides it by 2.25
      bankoffer[8] = (int)(bankOffer(casevalue));
      System.out.println("Its the banker, he's making you an offer of $" + bankoffer[8]); // Displays offer
      // Delays time by 5 seconds
      TimeUnit.SECONDS.sleep(5);
      // Choice[9] equals deal or no deal, JOption Pane method
      choice[9] = JOptionPane.showOptionDialog(null,"Deal or No Deal?","Deal or No Deal?", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,arr,arr[0]);
      // Deal = 0, No Deal = 1
      if (choice[9] == 1) // If statement when choice[9] equals 1
      {
        swapcases = JOptionPane.showConfirmDialog(null,"Would you like to swapcases?","Please choose an option:", JOptionPane.YES_NO_OPTION); // Option ot swap cases    
        // Yes = 0, No = 1
        if (swapcases == 0) // If swapcases = 0
        {
          casevalue.set(usercase-1, 0); // Setting user's case in the value section to 0 so only 1 case remains not 0
          for(int z = 0; z < 26; z++) // For loop
          {
            userswitchcase = casevalue.get(z); // Finding that value through the for loop
            if (userswitchcase != 0 )
            {
              usernewcase = userswitchcase; // New case equals swapped case
            }
          }
          System.out.println("\nYour case has $" + usernewcase); // Outputs current cases' value
          System.out.println("Thank you for playing deal or no deal!"); // Thanks user
        }
        else
        {
          // Else statement branch, outputs user's case value
          System.out.println("\nYour case has $" + usercase); 
          // Thanks user
          System.out.println("Thank you for playing deal or no deal!");
        }
      }
    }
  }
}
