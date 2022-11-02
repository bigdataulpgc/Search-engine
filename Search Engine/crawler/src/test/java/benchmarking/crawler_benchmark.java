package benchmarking;
import org.openjdk.jmh.annotations.*;
import web_connection.GutenbergSource;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class crawler_benchmark {
    private static ArrayList notValidId = new ArrayList();
    private static  GutenbergSource gutenbergSource = new GutenbergSource();

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 3, time = 1)
    @Warmup(iterations = 3, time = 1)
    public static void book_loader_1_book() {
        int end_id = 1;
        for (int id = 1; id <= end_id; id++) {
            try {
                gutenbergSource.bookLoader(id);
            } catch (Exception e) {
                notValidId.add(id);
            }
        }
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 3, time = 1)
    @Warmup(iterations = 3, time = 1)
    public static void book_loader_5_book() {
        int end_id = 5;
        for (int id = 1; id <= end_id; id++) {
            try {
                gutenbergSource.bookLoader(id);
            } catch (Exception e) {
                notValidId.add(id);
            }
        }
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 3, time = 1)
    @Warmup(iterations = 3, time = 1)
    public static void book_loader_10_book() {
        int end_id = 10;
        for (int id = 1; id <= end_id; id++) {
            try {
                gutenbergSource.bookLoader(id);
            } catch (Exception e) {
                notValidId.add(id);
            }
        }
    }


    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 3, time = 1)
    @Warmup(iterations = 3, time = 1)
    public static void book_loader_20_book() {
        int end_id = 20;
        for (int id = 1; id <= end_id; id++) {
            try {
                gutenbergSource.bookLoader(id);
            } catch (Exception e) {
                notValidId.add(id);
            }
        }
    }

}



