import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Bingo4TheEfficient {
    public static void main(String[] args) {
        izvlacenje(izgenerisi(30), izgenerisi(6));
    }

    public static void izvlacenje(int[] n1, int[] n2) {
        Set<Integer> set = new HashSet<>();   //Bingo3TheTightest O(n1*n2) vs Bingo4TheEfficient O(n1+n2)
        Arrays.stream(n2).forEach(set::add);
        System.out.printf("Broj pogodaka je: %d", (int) Arrays.stream(n1).filter(set::contains).count());
    }

    public static int[] izgenerisi(int brEl) {
        Random rand = new Random();
        return rand.ints(0, 51)
                .distinct()
                .limit(brEl)
                .sorted()
                .toArray();
    }
}
