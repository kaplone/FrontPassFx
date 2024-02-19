package fr.acelys.frontpassfx;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class HelloController implements Initializable {

    @FXML
    private Button reload;

    @FXML
    private TextField length;

    @FXML
    private TextField count;

    @FXML
    private ListView<String> pass_in;

    @FXML
    private ListView<Integer> pass_out;

    private final char COMA = 7;
    private final char EQ = 0;
    private final char QUOTES = 26;

    ObservableList<String> list_pass_in = FXCollections.observableArrayList();
    ObservableList<Integer> list_pass_out = FXCollections.observableArrayList();


    protected void onButtonClick() {
        PassCaller passCaller = new PassCaller();
        Integer l = Integer.parseInt(length.getText());
        Integer c = Integer.parseInt(count.getText());
        String res = passCaller.passCall(c, l);
        String strip = res.substring(12, res.length() - 1);
        List<String[]> m = Arrays.stream(strip.split(",")).map(a -> a.split("=")).toList();
        Map<String, Integer> out = new HashMap<>();
        list_pass_in.clear();
        list_pass_out.clear();
        for (String[] s : m){
            String pass = s[0].substring(1, s[0].length() - 1).replace(COMA, ',').replace(QUOTES, '"').replace(EQ, '=');
            Integer score = Integer.parseInt(s[1]);
            out.put(pass, score);
            list_pass_in.add(pass);
            list_pass_out.add(score);
        }
        Collections.shuffle(list_pass_in);
        Collections.sort(list_pass_out);
        System.out.println(out);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        reload.setOnAction(e -> onButtonClick());
        pass_in.setItems(list_pass_in);
        pass_out.setItems(list_pass_out);
    }
}