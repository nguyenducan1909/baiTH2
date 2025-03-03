package com.nda.fxenglishapp;

import com.nda.pojo.Question;
import com.nda.services.QuestionServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

public class PrimaryController implements Initializable {
    @FXML private Text txtContent;
    @FXML private RadioButton rdoA;
    @FXML private RadioButton rdoB;
    @FXML private RadioButton rdoC;
    @FXML private RadioButton rdoD;
    private List<Question> questions;
    private int currentIdx = 0;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    public void checkHandler( ActionEvent e) throws SQLException {
        QuestionServices s = new QuestionServices();
        List<Question> questions = s.getQuestions(2);
        
        Alert a= new Alert(Alert.AlertType.INFORMATION, questions.get(0).getContent(), ButtonType.OK);
        a.show();
                                                 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        QuestionServices s = new QuestionServices();        
        try {
            this.questions = s.getQuestions(3);
            loadQuestionToUI();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadQuestionToUI() {
        Question q = this.questions.get(currentIdx);
        txtContent.setText(q.getContent());
    }
}
