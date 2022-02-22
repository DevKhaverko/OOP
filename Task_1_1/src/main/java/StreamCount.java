import java.util.ArrayList;

public class StreamCount implements Prime{
    private final ArrayList<Integer> list;

    public StreamCount(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public boolean allArePrime() {
        return list.parallelStream().allMatch(Num::isPrime);
    }
}
