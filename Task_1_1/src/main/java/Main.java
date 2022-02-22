import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(34344577);
        }
        /*StreamCount streamCount = new StreamCount(list);
        Instant start = Instant.now();
        System.out.println(streamCount.allArePrime());
        System.out.println(Duration.between(start, Instant.now()));
        SeqCount seqCount = new SeqCount(list);
        start = Instant.now();
        System.out.println(seqCount.allArePrime());
        System.out.println(Duration.between(start, Instant.now()));*/
        ParallelCount parallelCount = new ParallelCount(list, 16);
        Instant start = Instant.now();
        System.out.println(parallelCount.allArePrime());
        System.out.println(Duration.between(start, Instant.now()));
    }
}
