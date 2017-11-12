package Palindrome;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * A palindrome date is one that reads the same numerically forwards and backwards.
 * IE:
 *  10 02 2001
 * Given a string representing a start date and a string end date, both in the format MM/dd/yyyy,
 * return a Set of LocalDates in chronological order containing all palindrome dates in that range inclusively.
 */
public class PalindromeDateDetector {
    public static Set<LocalDate> findPalindromeDates(String start, String end) {
        Set<LocalDate> palindromeDateSet = new LinkedHashSet<>();

        // Used to parse the strings into dates
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter plainFormat = DateTimeFormatter.ofPattern("MMddyyyy");

        // Convert start and end date strings to actual LocalDate objects
        LocalDate startDate = LocalDate.from(inputFormat.parse(start));
        LocalDate endDate = LocalDate.from(inputFormat.parse(end));
        LocalDate reversedDate;

        // Buffers used to reverse the year and construct the reversed date
        StringBuilder reversedDateBuffer = new StringBuilder(" ");
        StringBuilder yearBuffer = new StringBuilder(" ");

        // check all years between the start and end years for palindrome dates
        for(int year = startDate.getYear(); year <= endDate.getYear(); year++ ){
            // reset buffers
            yearBuffer.replace(0, yearBuffer.length(), "");
            reversedDateBuffer.replace(0, reversedDateBuffer.length(), "");

            // append the reversed year, then the year
            yearBuffer.append(year);
            reversedDateBuffer.append(yearBuffer.reverse()).append(year);
            try{
                // attempt to construct a date from reversedDateBuffer
                reversedDate = LocalDate.from(plainFormat.parse(reversedDateBuffer));

                // ensure reversed date lies within the start and end dates (if either is the same year as the palindrome, need to ensure it is within the boundaries)
                if(reversedDate == startDate || reversedDate == endDate || (reversedDate.isAfter(startDate) && reversedDate.isBefore(endDate))) {
                    palindromeDateSet.add(reversedDate);
                }
            } catch(DateTimeParseException dateTimeParseException){
                // this exception means it was not a valid date
            }
        }

        return palindromeDateSet;
    }
}