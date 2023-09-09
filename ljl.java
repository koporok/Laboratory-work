import java.util.Timer;
import java.util.TimerTask;

public class ljl {
    public static void main(String[] args) {
        Timer timer = new Timer();
        int numberOfRuns = 10;
        int intervalInSeconds = 5;

        TimerTask task = new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                if (count < numberOfRuns) {
                    count++;
                    try {
                        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
                        pb.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    timer.cancel();
                }
            }
        };

        timer.schedule(task, 0, intervalInSeconds * 1000);
    }
}
