/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketbioskop;

import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
public class VerifikasiController implements Initializable {
FXMLDocumentController cinemaku=new FXMLDocumentController();
   String nm;
    @FXML
    private JFXTextArea hasil;
    @FXML
    private Button pesan;
    @FXML
    private Button batal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setjeneng(String nam){
        nm = nam;
    }
   
    public void myFunc(int biaya, int total, String Jumlah, String Judul, String Hari, LocalDate tgl, String Nama, String Telp, String Email){
        
         hasil.setText("  Nama    : "+Nama+"\n"+
                       "  Telp      : "+Telp+"\n"+
                       "  Email    : "+Email+"\n"+
                       "________________________________________________________"+"\n\n"+
                       "  Judul Film                       : "+Judul+"\n\n"+
                       "  Hari, Tanggal                   : "+Hari+","+tgl+"\n\n"+
                       "  Biaya 1 tiket                    : Rp."+biaya+"\n\n"+
                       "  jumlah tiket                     : "+Jumlah+"\n"+
                       "________________________________________________________"+"\n"+
                       "  Total Biaya                      : Rp."+total);
     }
    @FXML
    private void pesan(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Terimakasih Telah Memesan.\n"
                                            + "Tiket akan kami kirim ke Email anda..");
    }

    @FXML
    private void batal(ActionEvent event) throws IOException {
        
            // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("Home.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 681, 493);
            // Hide this current window (if this is what you want)
                    ((Node)(event.getSource())).getScene().getWindow().hide();
            // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("Cinemaku");
                    stage.show();
    }
    
}
