module com.example.todo {
    requires javafx.controls;
    requires javafx.fxml;
    requires jlfgr;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.todo to javafx.fxml;
    exports com.example.todo;
}