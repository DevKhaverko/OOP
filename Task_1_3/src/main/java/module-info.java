module nsu.khaverko.v.snake {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens nsu.khaverko.v.snake to javafx.fxml;
    exports nsu.khaverko.v.snake;
    exports nsu.khaverko.v.snake.model;
    opens nsu.khaverko.v.snake.model to javafx.fxml;
    exports nsu.khaverko.v.snake.graphics;
    opens nsu.khaverko.v.snake.graphics to javafx.fxml;
}