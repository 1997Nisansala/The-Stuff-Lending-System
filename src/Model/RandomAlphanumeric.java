package Model;
import java.util.Random;

public class RandomAlphanumeric {
    private final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private final char[] ALPHANUMERIC = (LETTERS + LETTERS.toUpperCase() + "0123456789").toCharArray();

    public String generateRandomAlphanumeric(int length){
        StringBuilder result = new StringBuilder();

        for(int i=0; i<length; i++){
            result.append(ALPHANUMERIC[new Random().nextInt(ALPHANUMERIC.length)]);
        }
        return result.toString();
    }
}
