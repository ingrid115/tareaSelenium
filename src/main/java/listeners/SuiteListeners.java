package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.DriverMananger;
import utilities.Logs;

public class SuiteListeners implements ISuiteListener {
    private final Logs log = new Logs();

    @Override
    public void onStart(ISuite suite) {
        new DriverMananger().deleteScreenshotDirectory();
        log.startSuite(suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        log.info("Terminando la suite");
    }
}
