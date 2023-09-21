
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class coc {

    public static void main(String[] args){
        //Массивы vectorSizes и vectorCounts определяют различные размеры векторов и количество потоков, которые будут использоваться для обработки.
        int[] vectorSizes = {10, 100, 1000, 10000};
        int[] vectorCounts = {2, 3, 4, 5, 10};

        System.out.println("Mul\tN\tm\tTime (ms)");
        //Один за другим, циклы for проходят по всем комбинациям размеров векторов (из vectorSizes) и количества потоков (из vectorCounts). Для каждой комбинации, генерируется случайный вектор целых чисел, и выполняется его обработка как параллельно, так и последовательно.

        for (int N : vectorSizes) {
            for (int M : vectorCounts){
                int[] vector = generateRandomVector(N);
                boolean Mul = true;

                long startTime = System.currentTimeMillis();
                processVectorInParallel(vector, M);
                long endTime = System.currentTimeMillis();

                System.out.println(Mul + "\t" + N + "\t" + M + "\t" + (endTime - startTime));

                Mul = false;

                startTime = System.currentTimeMillis();
                processVectorInNotParallel(vector);
                endTime = System.currentTimeMillis();

                System.out.println(Mul + "\t" + N + "\t" + M + "\t" + (endTime - startTime));
            }
        }
    }
    //Метод generateRandomVector генерирует случайные целые числа и заполняет ими вектор заданного размера N.
    private static int[] generateRandomVector(int N) {
        Random random = new Random();
        int[] vector = random.ints(N, 0, 100).toArray();
        return vector;
    }

    //Метод processVectorInParallel выполняет параллельную обработку вектора с использованием заданного количества потоков threadCount. Для этого, создается пул исполнителей executorService с фиксированным числом потоков. Затем, вектор разбивается на несколько сегментов, и для каждого сегмента создается задача task, которая будет выполнена в параллельном потоке. Задачи добавляются в список tasks, и после этого все задачи выполняются одновременно с помощью метода invokeAll. После завершения выполнения всех задач, пул исполнителей закрывается.
    private static void processVectorInParallel(int[] vector, int threadCount) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        int segmentSize = vector.length / threadCount;

        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            int start = i * segmentSize;
            int end = (i == threadCount - 1) ? vector.length : (i + 1) * segmentSize;

            final int[] segment = Arrays.copyOfRange(vector, start, end);

            Runnable task = () -> {
                for (int j = 0; j < segment.length; j++) {
                    segment[j] = (int) Math.sqrt(factorial(segment[j])) * 123423243;
                }
            };

            tasks.add(task);
        }

        try {
            executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    //Метод processVectorInNotParallel выполняет последовательную обработку вектора, где каждый элемент вектора возводится в квадрат и затем вычисляется факториал с использованием метода factorial.
    private static void processVectorInNotParallel(int[] vector){
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) Math.sqrt(factorial(vector[i]));
        }
    }
    //Метод factorial рекурсивно вычисляет факториал заданного числа n. Если число равно нулю, возвращается единица. В противном случае, выполняется рекурсивный вызов метода, умножение на n и на большое число 123423243.
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        else {
            return n * factorial(n - 1) * 123423243;
        }
    }
}
/*
Ответы на вопросы:
Эффект от распараллеливания наблюдается при большем числе элементов, потому что параллельная обработка включает в себя некоторые накладные расходы, связанные с созданием, управлением и синхронизацией потоков (или процессов), которые могут быть сравнительно большими по сравнению с вычислительной нагрузкой. Поэтому, чтобы оправдать эти накладные расходы и получить прирост производительности, необходимо иметь достаточно большой объем работы, который может быть разделен между потоками.

Увеличение сложности обработки может повысить эффективность многопоточной обработки, потому что в более сложных задачах обычно есть больше возможностей для распараллеливания

Оптимальное число потоков обычно определяется экспериментально для конкретной задачи и системы.

Если потоки выполняют разные части задачи и некоторые из них завершаются раньше, чем другие из-за различных нагрузок или характеристик данных, это может привести к тому, что некоторые потоки будут простаивать, ожидая завершения других.

Чтобы увеличить равномерность загрузки потоков, можно использовать другие методы декомпозиции задачи, такие как декомпозиция данных или декомпозиция задачи на подзадачи с более равномерной нагрузкой.

Круговая декомпозиция (или деление на равные части) может не обеспечивать равномерную загрузку потоков, если задача имеет неравномерную структуру данных или требует неравномерных вычислений.
 */