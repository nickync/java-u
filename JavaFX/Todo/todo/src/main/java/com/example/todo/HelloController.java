package com.example.todo;

import com.example.todo.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    private List<TodoItem> todoItems;
    @FXML
    private ListView todoListView;

    @FXML
    private TextArea itemDetails;

    @FXML
    private Label deadlineLabel;

    public void initialize() {
        TodoItem item1 = new TodoItem("Todo 1", "First todo", LocalDate.of(2023,2,1));
        TodoItem item2 = new TodoItem("Todo 2", "second todo", LocalDate.of(2023,3,1));
        TodoItem item3 = new TodoItem("Todo 3", "Third todo", LocalDate.of(2023,4,1));
        TodoItem item4 = new TodoItem("Todo 4", "Fourth todo", LocalDate.of(2023,4,8));
        TodoItem item5 = new TodoItem("Todo 5", "Fifth todo", LocalDate.of(2023,5,1));
        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);
        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handleClickListView(){
        TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
        itemDetails.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: " + item.getDeadline().toString());
//        itemDetails.setText(sb.toString());
    }


}