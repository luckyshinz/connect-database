/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketbioskop;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SMK TELKO
 */
public class HomeController implements Initializable {
FXMLDocumentController cinemaku=new FXMLDocumentController();
    @FXML
    private Button daftar;
    @FXML
    private RadioButton s1;
    @FXML
    private ToggleGroup studio;
    @FXML
    private RadioButton s2;
    @FXML
    private RadioButton s3;
    @FXML
    private RadioButton sv;
    @FXML
    private RadioButton svv;
    @FXML
    private JFXComboBox<String> code;
    @FXML
    private JFXComboBox<String> jam;
    @FXML
    private JFXComboBox<String> hari;
    @FXML
    private DatePicker tanggal;
    @FXML
    private JFXTextField jumlah;
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField no_telp;
    @FXML
    private JFXTextField email;
    @FXML
    private Button lanjutkan;
    @FXML
    private Button hapus;
    @FXML
    private Button keluar;
    
    ObservableList<String>  jamvalue = FXCollections
            .observableArrayList(
                    "13:00",
                    "14:30",
                    "16:10",
                    "17:30",
                    "18:30",
                    "20:10");
    ObservableList<String>  harivalue = FXCollections
            .observableArrayList(
                    "Minggu",
                    "Senin",
                    "Selasa",
                    "Rabo",
                    "Kamis",
                    "Jumat",
                    "Sabtu");
    ObservableList<String>  codevalue = FXCollections
            .observableArrayList(
                    "A11C",
                    "B31D",
                    "C15A",
                    "D20A");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String Default="jam tayang";
        jam.setValue(Default);
        jam.setItems(jamvalue);
        hari.setItems(harivalue);
        code.setItems(codevalue);
    }    

    @FXML
    private void daftar(ActionEvent event) throws IOException {
         // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("Film.fxml"));
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

    @FXML
    private void lanjutkan(ActionEvent event) throws IOException {
        String Nama = nama.getText();
        String Telp = no_telp.getText();
        String Email = email.getText();
        String Code = code.getValue();
        String Judul = null;
        String Jam = jam.getValue();
        String Hari = hari.getValue();
        LocalDate tgl = tanggal.getValue();
        String Jumlah = jumlah.getText();
        int harga = 30000;
        int biaya = 0;
        int total;
        int JumlahIn=Integer.parseInt(Jumlah);
        
        if(sv.isSelected()){
            harga = harga + 10000;
        }
        else if(svv.isSelected()){
            harga = harga + 25000;
        }
        
       if(null != Hari)
           switch(Hari){
               case "Senin":
                   biaya = harga += 0;
                   break;
                case "Selasa":
                   biaya = harga += 0;
                   break;
                case "Rabo":
                   biaya = harga += 0;
                   break;
                case "Kamis":
                   biaya = harga += 0;
                   break;
                   
                case "Jumat":
                   biaya = harga += 5000;
                   break;
                   
                case "Sabtu":
                   biaya = harga += 15000;
                   break;
                case "Minggu":
                   biaya = harga += 15000;
                   break;
                default:
                    break;
           }
       
       if(null != Code)
           switch(Code){
               case "A11C":
                   Judul = "OverDrive";
                   break;
                case "B31D":
                   Judul = "Pengabdi Setan";
                   break;
                case "C15A":
                   Judul = "The Mummy";
                   break;
                case "D20A":
                   Judul = "Transformers The Last Knight";
                   break;
                default:
                    break;
           }
       
       total = JumlahIn * biaya;
     
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Verifikasi.fxml"));   
            Parent root = (Parent) loader.load();
            VerifikasiController Control = loader.getController();
          ((Node)(event.getSource())).getScene().getWindow().hide();
            Control.myFunc(biaya, total, Jumlah, Judul, Hari, tgl, Nama, Telp, Email);
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setTitle("EnterKomputer");
            stage.setScene(new Scene(root));
            stage.show();
       
    }
    String nm;
    
    public void setjng(String nama) {
        nm = nama;
    }

    @FXML
    private void hapus(ActionEvent event) {
        code.setValue("Code");
        jam.setValue("Jam");
        hari.setValue("Hari");
        tanggal.setValue(null);
        s1.setSelected(false);
        s2.setSelected(false);
        s3.setSelected(false);
        sv.setSelected(false);
        svv.setSelected(false);
        jumlah.setText("");
    }

    @FXML
    private void keluar(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
          FXMLLoader fxmlLoader = new FXMLLoader();
          fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
          Scene scene = new Scene (fxmlLoader.load(),460,300);
          Stage stage = new Stage();
          stage.setScene(scene);
          stage.setTitle("");
          stage.show();
    }
    
}
