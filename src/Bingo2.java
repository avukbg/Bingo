import java.util.Arrays;
import java.util.Random;

public class Bingo2 {
    public static void main(String[] args) {
        izvlacenje(r1(), r2());
    }

    private static void izvlacenje(int[] r1, int[] r2) {

        System.out.println("Dobitni brojevi su: " + Arrays.toString(r1) + "\n" + "Vasi brojevi su: " + Arrays.toString(r2));
        int c = (int) Arrays.stream(r1)
                .filter(
                        x -> Arrays.stream(r2).anyMatch(y -> y == x))      //ovde se ukrstaju 2 streama  r1 i r2
                .count();                                                  // mi kroz svaki od 30  propustamo 6 i trazimo match
                                                                                     //   11
        System.out.println("Broj pogodaka je: " + c + ".");                          //    .         tako za svaki
    }                                                                                //   2 5 12 14 34 ...49
                                                                                     //     .      30*6 || 6*30 poredjenja
    public static int[] r2() {                                                       //   44  zapravo je svejedno samo rotirano :D
        Random r = new Random();
        return r.ints(0, 51)
                .distinct()
                .limit(6)
                .sorted()
                .toArray();
    }

    public static int[] r1() {
        Random r = new Random();
        return r.ints(0, 51)
                .distinct()
                .limit(30)
                .sorted()
                .toArray();
    }
}
