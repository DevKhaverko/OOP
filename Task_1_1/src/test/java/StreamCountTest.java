import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StreamCountTest {
    ArrayList<Integer> gen() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(34344577);
        }
        return list;
    }

    @Test
    void allArePrimeTrue() {
        Assertions.assertTrue(new StreamCount(gen()).allArePrime());
    }

    @Test
    void allArePrimeFalse() {
        ArrayList<Integer> t = gen();
        t.add(88);
        Assertions.assertFalse(new StreamCount(t).allArePrime());
    }
}