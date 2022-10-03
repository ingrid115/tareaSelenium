package utilities;

public class Utilities {
    private final Logs log = new Logs();

    public void waitSeconds(int n) {
        try {
            Thread.sleep(n * 1000L);
        } catch (InterruptedException interruptedException) {
            log.error(interruptedException.getLocalizedMessage());
        }
    }
}
