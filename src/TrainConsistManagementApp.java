import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Base class for Bogies
class Bogie {
    private String id;
    private int capacity;

    public Bogie(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // 1. Prepare a collection of bogies
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("B" + i, (int) (Math.random() * 100)));
        }

        System.out.println("--- Performance Benchmarking: Loop vs Streams ---");

        // 2. Loop-Based Filtering [cite: 1]
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = filterWithLoop(bogies, 60);
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        // 3. Stream-Based Filtering [cite: 1]
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = filterWithStream(bogies, 60);
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // Display results and execution times [cite: 1]
        System.out.println("Loop Filtered Count: " + loopFiltered.size());
        System.out.println("Loop Execution Time: " + loopDuration + " ns");

        System.out.println("Stream Filtered Count: " + streamFiltered.size());
        System.out.println("Stream Execution Time: " + streamDuration + " ns");

        System.out.println("Results Match: " + (loopFiltered.size() == streamFiltered.size()));
    }

    // Logic for traditional loop filtering [cite: 1]
    public static List<Bogie> filterWithLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // Logic for stream-based filtering [cite: 1]
    public static List<Bogie> filterWithStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }
}