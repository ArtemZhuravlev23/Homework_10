import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Lottery {

    public static void main(String[] args) {

        int[] computerTickets = generateNumbers();
        int[] userTickets = generateNumbers();

        System.out.println("Computer tickets: " + Arrays.toString(computerTickets));
        System.out.println("User tickets: " + Arrays.toString(userTickets));

        Arrays.sort(computerTickets);
        Arrays.sort(userTickets);

        System.out.println("Sorted computer tickets: " + Arrays.toString(computerTickets));
        System.out.println("Sorted user tickets: " + Arrays.toString(userTickets));

        System.out.println("Number of matches: " +
                countCoincidence(computerTickets, userTickets));
    }

    public static int[] generateNumbers() {

        int[] computerTickets = new int[7];
        for (int i = 0; i < computerTickets.length; i++) {
            computerTickets[i] = ThreadLocalRandom.current().nextInt(10);
        }
        return computerTickets;
    }

    public static int countCoincidence(int[] computerTickets, int[] userTickets) {
        int coincidence = 0;
        for (int i = 0; i < Math.min(computerTickets.length, userTickets.length); i++) {
            if (computerTickets[i] == userTickets[i]) {
                coincidence++;
            }
        }
        return coincidence;
    }
}