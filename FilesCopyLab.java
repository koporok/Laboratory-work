import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesCopyLab{

    public static void sequentialCopy(String sourcePath, String destinationPath) {
        try (FileReader reader = new FileReader(sourcePath);
             FileWriter writer = new FileWriter(destinationPath)) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            System.out.println("Sequential copy completed successfully!");
        } catch (IOException e) {
            System.err.println("Error occurred during sequential copy: " + e.getMessage());
        }
    }

    public static void parallelCopy(String sourcePath, String destinationPath) {
        Thread copyThread = new Thread(() -> {
            try (FileReader reader = new FileReader(sourcePath);
                 FileWriter writer = new FileWriter(destinationPath)) {
                int character;
                while ((character = reader.read()) != -1) {
                    writer.write(character);
                }
                System.out.println("Parallel copy completed successfully!");
            } catch (IOException e) {
                System.err.println("Error occurred during parallel copy: " + e.getMessage());
            }
        });

        copyThread.start();
        try {
            copyThread.join();
        } catch (InterruptedException e) {
            System.err.println("Error occurred while waiting for parallel copy thread: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourceFile1 = "src/abcd";
        String destinationFile1 = "src/abcd_copy";
        String sourceFile2 = "src/bcde";
        String destinationFile2 = "src/bcde_copy";

        long startTime = System.currentTimeMillis();
        sequentialCopy(sourceFile1, destinationFile1);
        sequentialCopy(sourceFile2, destinationFile2);
        long endTime = System.currentTimeMillis();
        long sequentialTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        parallelCopy(sourceFile1, destinationFile1);
        parallelCopy(sourceFile2, destinationFile2);
        endTime = System.currentTimeMillis();
        long parallelTime = endTime - startTime;

        System.out.println("Sequential copy time: " + sequentialTime + " ms");
        System.out.println("Parallel copy time: " + parallelTime + " ms");
    }
}
