import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * class for rightly start of pizza spot simulation
 * all threads will run just in time of object construction
 */

public class PizzaSpot {
    private final DataForSystem dataForSystem;
    private final BlockingQueue ordersQueue;
    private final BlockingQueue storage;
    private final WorkingDay workingDay;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    PizzaSpot(DataForSystem dataForSystem){
        this.dataForSystem = dataForSystem;
        workingDay = new WorkingDay(dataForSystem.getWorkingTime());
        ordersQueue = new OrdersQueue(workingDay);
        storage = new Storage(dataForSystem.getStorageSize());

        openPizzaSpot();
        startWorkers();

        executorService.shutdown();
    }

    private void openPizzaSpot(){
        workingDay.start();
        executorService.execute(new NewOrders(ordersQueue,workingDay));
    }

    private void startWorkers(){
        for(int i = 0 ; i < dataForSystem.getCooksCount(); i++)
            executorService.execute(new Cook(ordersQueue, storage, workingDay));

        int[] deliveries = dataForSystem.getCapacitiesOfDeliveriesBags();
        for(int i = 0; i < deliveries.length; i++)
            executorService.execute(new DeliveryMan(storage, deliveries[i]));
    }
}