import java.util.Objects;

public class Main {
    private static final String pathToData = "src/main/resources/data.json";

    public static void main(String[] args) {
        new PizzaSpot(Objects.requireNonNull(DataForSystem.getDataForSystemFromFile(pathToData)));
    }
}
