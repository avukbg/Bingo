import java.util.Arrays;
import java.util.Random;

public class Bingo3TheTightest {
    public static void main(String[] args) {
        izvlacenje(izgenerisi(30), izgenerisi(6));
    }

    public static void izvlacenje(int[] n1, int[] n2) {
        System.out.printf("Broj pogodaka je: %d", (int) Arrays.stream(n1)
                .filter(x -> Arrays.stream(n2).anyMatch(y -> y == x))
                .count());
    }

    public static int[] izgenerisi(int brEl) {
        Random r = new Random();
        return r.ints(0, 51)
                .distinct()
                .limit(brEl)
                .sorted()
                .toArray();
    }
}