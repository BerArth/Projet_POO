package Thread;

public class Countdown extends Thread {

    private static final int COUNTDOWN = 20 * 60 * 1000; // 20 min en millisecondes (20 * 60 * 1000)
    private int timeRemaining;
    private boolean running;

    public Countdown() {
        timeRemaining = COUNTDOWN;
        running = true;
    }

    @Override
    public void run() {
        while (timeRemaining > 0 && running) {
            try {
                //System.out.println("Temps restant: " + timeRemaining + " secondes");
                timeRemaining -= 1000; // -1s
                Thread.sleep(1000); // Attendre 1 sec
            } catch (InterruptedException e) {
                System.out.println("Countdown interrupted (error).");
            }
        }

        if (timeRemaining <= 0) {
            System.out.println("\nTime is over! You lost !\n");
        }
    }

    public void TimeRemaining() {
        int minutes = timeRemaining / 1000 / 60;
        int seconds = (timeRemaining / 1000) % 60;

        System.out.println("\nTime remaining: " + minutes + " minutes + " + seconds + " seconds.\n");
    }

    public void Stop(){
        running = false;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }
}