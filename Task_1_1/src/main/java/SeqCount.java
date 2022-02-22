import java.util.ArrayList;

public class SeqCount implements Prime{
    private final ArrayList<Integer> list;

    public SeqCount(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public boolean allArePrime() {
        for (var i : list) {
            if (!Num.isPrime(i))
                return false;
        }
        return true;
    }
}
