package Prime;

/**
 * Given a number, determine if it is prime or not, returning a boolean representing if it is prime.
 */
public class PrimeNumberFinder {
    public static boolean isPrime(Integer number){
        // iterate no further than the square root looking for factors
        for(int i = 2; i <= Math.sqrt(number); i++){
            // if the number is a factor then modulo is 0 and it is not prime
            if(number % i == 0){
                return false;
            }
        }

        // otherwise if it is not 1 or 0, it is prime
        return (number != 1 && number != 0);
    }
}