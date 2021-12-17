import java.util.Random;

public class Lab2 {
    public static void main(String[] a) {
        System.out.println(piSimulation(1000000));
        printPrimes(20);

    }

    static double piSimulation(int n) {
        int hitCount = 0;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            if (distance <= 1)
                hitCount++;
        }
        return 4.0 * hitCount / n;
    }

    static void printPrimes(int n) {
        boolean[] composite = new boolean[n + 1];

        composite[0] = true;
        composite[1] = true;

        for (int p = 2; p <= n; p++) {
            if (composite[p] == false) {
                for (int multipulesP = 2 * p; multipulesP <= n; multipulesP += p) {
                    composite[multipulesP] = true;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (!composite[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
