package generalSelenium;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please Enter a string: ");
        String input = scan.nextLine();
        while(input.isEmpty()){
            System.out.println("Empty strings not valid");
            input = scan.nextLine();
        }
        scan.close();
        System.out.println(reverseString(input));

    }

    private static String reverseString(String s) {

        String s1 = "";

        if(s.isEmpty())
            return "null";

        for (int i = s.length()-1; i >=0 ; i--)
            s1 = s1 + s.charAt(i);

        return s1.trim();
    }
}
