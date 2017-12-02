/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketbioskop;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SMK TELKO
 */
public class FXMLDaftarController implements Initializable {

    @FXML
    private Button daftar;
    @FXML
    private JFXTextField Dusername;
    @FXML
    private JFXPasswordField Dpassword;
    @FXML
    private Button signIn;
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField telp;
    @FXML
    private JFXTextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void daftar(ActionEvent event) {
        if(Dusername.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tulisan Username Anda");
        }
        else if(nama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tulisan Nama Anda");
        }
        else if(telp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tulisan No Telfon Anda");
        }
        else if(email.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tulisan Email Anda");
        }
                else if(Dpassword.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tulisan Password Anda");
        }
        else{
         try {
            String sql = "INSERT INTO member VALUES('"+Dusername.getText()+"', '"+nama.getText()+"',  '"+telp.getText()+"', '"+email.getText()+"',  '"+Dpassword.getText()+"')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            }
       
    }
    
    @FXML
    private void signIn(ActionEvent event) throws IOException {

          FXMLLoader fxmlLoader = new FXMLLoader();
          fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
          Scene scene = new Scene (fxmlLoader.load(),460,300);
          ((Node)(event.getSource())).getScene().getWindow().hide();
          Stage stage = new Stage();
          stage.setScene(scene);
          stage.setTitle("");
          stage.show();
    }
    
}
