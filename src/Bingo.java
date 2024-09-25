import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args)
    {
        izvlacenje(izgenerisi(), unesiSvoje());
    }

    public static void izvlacenje(int[] g, int[] u) {
        System.out.println("Dobitni brojevi su: " + Arrays.toString(g));  //moze i (int x : a) sout za ispis
        int c = 0;
        for (int i = 0; i < u.length; i++) {        //vrti unete
            for (int j = 0; j < g.length; j++) {    //vrti generisane
                if (u[i] == g[j]) {
                    c++;
                    break;
                }
            }
        }
        System.out.println("Broj pogodaka je: " + c + ".");
    }

    public static int[] unesiSvoje() {
        Scanner s = new Scanner(System.in);
        int[] n = new int[6];
        for (int i = 0; i < n.length; i++) {
            System.out.print("Unesite " + (i + 1) + "." + " broj: ");
            int br = s.nextInt();
            if (br > 50 || br < 0) {            //limiti
                System.out.println("Unesite broj izmedju 0 i 50.");
                i--;
                continue;
            }
            boolean d = false;                  //provera da nije prethodno uneo
            for (int j = 0; j < i; j++) {
                if (n[j] == br) {
                    d = true;
                    break;
                }
            }
            if (d) {
                System.out.println("Unesite drugi broj.");
                i--;
                continue;
            }
            n[i] = br;

        }
        return n;
    }

    public static int[] izgenerisi() {
        Random r = new Random();
        return r.ints(0, 51)    //51 je da bi 50 bilo u opsegu
                .distinct()
                .limit(30)
                .sorted()                                       //meni je lakse da vidim u outputu i proverim, ne mora
                .toArray();
    }
}
