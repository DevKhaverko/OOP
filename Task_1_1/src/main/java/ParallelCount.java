import java.util.ArrayList;

public class ParallelCount implements Prime{
    private final ArrayList<Integer> list;
    private final int n;

    public ParallelCount(ArrayList<Integer> list, int n) {
        this.list = list;
        this.n = n;
    }

    @Override
    public boolean allArePrime() {
        ArrayList<ArrayList<Integer>> dataForThreads = new ArrayList<>();
        for(int i = 0; i < n; i++){
            dataForThreads.add(new ArrayList<>());
        }
        for(int i = 0; i < list.size(); i++){
            dataForThreads.get(i % n).add(list.get(i));
        }

        ArrayList<Checker> threadsList = new ArrayList<>();
        for(var it : dataForThreads){
            threadsList.add(new Checker(it));
            threadsList.get(threadsList.size() - 1).start();
        }

        for(var it : threadsList){
            try {
                it.join();
            } catch (Exception e){
                e.printStackTrace();
            }
            if (!it.getResult())
                return false;
        }
        return true;
    }
    public static class Checker extends Thread {
        private final ArrayList<Integer> list;
        private boolean result;

        public Checker(ArrayList<Integer> g) {
            this.list = g;
            this.result = true;
        }

        @Override
        public void run() {
            for (var t : list) {
                if (!Num.isPrime(t)) {
                    result = false;
                    return;
                }
            }
        }

        public boolean getResult() {
            return result;
        }
    }
}
