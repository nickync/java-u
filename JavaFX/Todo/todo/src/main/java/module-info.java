module com.example.todo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.todo to javafx.fxml;
    exports com.example.todo;
}