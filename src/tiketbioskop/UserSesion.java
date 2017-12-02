/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketbioskop;

/**
 *
 * @author SMK TELKO
 */
public class UserSesion {
    private static String username;
    private static String nama;
    private static int no_telp;
    private static String email;
    private static String password;
    
    public static String getUsername() {
        return username;
    }
    
    public static void setUsername(String username) {
        UserSesion.username = username;
    }
    
    public static String getNama() {
        return nama;
    }
    public static void setNama(String nama) {
        UserSesion.nama = nama;
    }
    
    public static int getNo_telp() {
        return no_telp;
    }
    public static void setNo_telp(int no_telp) {
        UserSesion.no_telp = no_telp;
    }
    
    public static String Email() {
        return email;
    }
    public static void setEmail(String email) {
        UserSesion.email = email;
    }
    
    public static String getPassword() {
        return password;
    }
    public static void setPassword(String password) {
        UserSesion.password = password;
    }
}
