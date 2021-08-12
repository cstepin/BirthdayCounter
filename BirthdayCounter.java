import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BirthdayCounter {

    public static Boolean determineEquals (String input, String toCompare, String toCompareShort){
        return input.toLowerCase().equals(toCompare.toLowerCase()) || input.toLowerCase().equals(toCompareShort.toLowerCase());
    }

    public static String determineIntMonth(String month){
        String monthInt = "0";

        if(determineEquals(month, "january", "jan"))
            monthInt = "01";
        else if(determineEquals(month, "february", "feb")) {
            monthInt = "02";
        }
        else if(determineEquals(month, "march", "mar")) {
            monthInt = "03";
        }
        else if(determineEquals(month, "april", "apr")){
           monthInt  = "04";
        }
        else if(determineEquals(month, "may", "may")){
            monthInt = "05";
        }
        else if(determineEquals(month, "june", "jun")){
            monthInt = "06";
        }
        else if(determineEquals(month, "july", "jul")){
            monthInt = "07";
        }
        else if(determineEquals(month, "august", "aug")){
            monthInt = "08";
        }
        else if(determineEquals(month, "september", "sep")){
            monthInt = "09";
        }
        else if(determineEquals(month, "october", "oct")){
            monthInt = "10";
        }
        else if(determineEquals(month, "november", "nov")){
            monthInt = "11";
        }
        else if(determineEquals(month, "december", "dec")){
            monthInt = "12";
        }
        return monthInt;
    }

    public static void main(String [] args) throws ParseException {
        Scanner scan = new Scanner(System.in);

        String userMonthInt = "0";
        String currMonthInt = "0";

        Boolean checkUserMonth = true;
        Boolean checkCurrMonth = true;

        while (checkUserMonth) {
            System.out.println("Hello, please enter your month of birth: ");
            userMonthInt = determineIntMonth(scan.next());
            if (userMonthInt.equals("0"))
                System.out.println("Please try again, make sure the month is spelled correctly.");
            else
                checkUserMonth = false;
        }

        System.out.println("Please enter your date of birth: ");
        String userDate = scan.next();

        while(checkCurrMonth) {
            System.out.println("Please print the current month: ");
            currMonthInt = determineIntMonth(scan.next());
            if (currMonthInt.equals("0"))
                System.out.println("Please try again, make sure the month is spelled correctly.");
            else
                checkCurrMonth = false;
        }

        System.out.println("Please print the current date: ");
        String currDate = scan.next();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM");

        if (Integer.parseInt(userDate) < 10)
            userDate = "0" + userDate;
        if (Integer.parseInt(currDate) < 10)
            userDate = "0" + currDate;

        try {
            Date curr_date = sdf.parse(currDate + "-" + currMonthInt);
            Date user_date = sdf.parse(userDate + "-" + userMonthInt);

            long differenceTime = user_date.getTime() - curr_date.getTime();

            long numDaysBetween = TimeUnit.MILLISECONDS.toDays(differenceTime) % 365;

            if(numDaysBetween < 0)
                numDaysBetween = numDaysBetween + 364;

            System.out.println(numDaysBetween + " days until your birthday!");

        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
