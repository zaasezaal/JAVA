/**
 * Kyle Zeller
 * 1/13/14
 * The purpose of this program, is to generate random passwords from  
 * which the user should be able to select the character set and the 
 * length. (5 options are given)
 */

import java.util.Random;
import java.util.Scanner;

public class Password
{
    public static void main (String [ ] args)
    {
        //Declare and initialize variables and objects
        
        int   punctStart = 58;    // these come from ascii tables
        int   punctEnd = 64;
        int   numStart = 48;
        int   numEnd = 57;
        int   lcStart = 97;
        int   lcEnd = 122;
        int   ucStart = 65;
        int   ucEnd = 90;
        
        int typeSelection;
        int passwordLength;
        
        // create objects for keyboard input and to generate random numbers
        Scanner input = new Scanner(System.in);
        Random randValue = new Random();
               
       // print menu header
        System.out.println("\t\tPassword Generation Menu");
        System.out.println("*********************************************************");
        System.out.println("*   [1] Lowercase Letters                               *");
        System.out.println("*   [2] Lowercase & Uppercase Letters                   *");
        System.out.println("*   [3] Lowercase, Uppercase, and Numbers               *");
        System.out.println("*   [4] Lowercase, Uppercase, Numbers, and Punctuation  *");
        System.out.println("*   [5] Quit                                            *");
        System.out.println("*********************************************************");
        
        // Input password type selection
        System.out.print("Enter Selection (1-5): ");
        typeSelection = input.nextInt();
        
        // Get password length
        System.out.println("");
        System.out.print("Password Length (1-14): ");
        passwordLength = input.nextInt();
              
        // generate password based on length and selection
        
        String  passwordString = "";
        int i;                          // loop counter
        int aChar;                      // character for next password digit
        
        for( i = 0; i < passwordLength; i++ )
        {
            aChar = 0;              // make char invalid
            if( typeSelection == 1 )    // lower case only
            {
                while( !((aChar >= lcStart) && (aChar <= lcEnd)) )
                {
                    aChar = randValue.nextInt(255);
                }
            }
            else if ( typeSelection == 2 )  // lower and uppercase
            {
                while( !((aChar >= lcStart) && (aChar <= lcEnd)) && !((aChar >= ucStart) && (aChar <= ucEnd)))
                {
                    aChar = randValue.nextInt(255);
                }
            }
            else if ( typeSelection == 3 )  // lower and uppercase and numbers
            {
                while( !((aChar >= lcStart) && (aChar <= lcEnd)) && !((aChar >= ucStart) && (aChar <= ucEnd)) && 
                       !((aChar >= numStart) && (aChar <= numEnd)))
                {
                    aChar = randValue.nextInt(255);
                }
            }
            else if ( typeSelection == 4 )   // lower and uppercase and numbers and punctuation
            {
                while( !((aChar >= lcStart) && (aChar <= lcEnd)) && !((aChar >= ucStart) && (aChar <= ucEnd)) && 
                       !((aChar >= numStart) && (aChar <= numEnd)) && !((aChar >= punctStart) && (aChar <= punctEnd)))
                {
                    aChar = randValue.nextInt(255);
                }
            }
            if( aChar != 0 )        // handle the quit case
            {
                passwordString = passwordString + (char)aChar;
            }
        }

        // and print the result
        if( typeSelection != 5 )
        {
            System.out.println("");
            System.out.println(passwordString);
        }
    }
}