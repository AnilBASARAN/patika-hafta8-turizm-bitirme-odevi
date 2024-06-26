package Turizm.core;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void showMessage(String str) { //Değerlendirme formu 19 ve 20!
        String msg;
        String msgTitle;
        switch (str) {
            case "fill":
                msg = "Please fill all fields!";
                msgTitle = "Error!";
                break;
            case "success":
                msg = "Operation Successful!";
                msgTitle = "Conclusion";
                break;
            case "loginSuccess":
                msg = "Connection successful!";
                msgTitle = "Connection situation";
                break;
            case "login":
                msg = "Invalid Username or Password!";
                msgTitle = "LoginErr";
                break;
            case "date":
                msg = "Please enter a valid date!";
                msgTitle = "date format error";
                break;
            case "dateRange":
                msg = "Reservation date ranges cannot be in two different seasons.";
                msgTitle = "Season range error";
                break;
            case "fillcombo":
                msg = "Please Fill all comboboxes";
                msgTitle = "Empty combobox Error";
                break;
            case "filldate":
                msg = "Please fill all check in and check out dates";
                msgTitle = "Empty date Error";
                break;
            case "select":
                msg = "Select an user!";
                msgTitle = "User selection error";
                break;
            case "hotelIdNotExist":
                msg = "There is no hotel with that id in the system";
                msgTitle="Hotel_id error";
                break;
            default:
                msg = str;
                msgTitle = "Message";
        }
        JOptionPane.showMessageDialog(null, msg, msgTitle, JOptionPane.INFORMATION_MESSAGE);

    }

    public static void s_Msg(String title, String message){
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);

    }
    public static boolean isFieldEmpty(JTextField field){
        return field.getText().isEmpty();
    }

    public static boolean confirm(String str){
        String msg;
        switch (str){
            case "sure":
                msg = "Bu işlemi gerçekleştirmek istediginizden emin misiniz?";
                break;
            default:
                msg=str;
                break;
        }
        return JOptionPane.showConfirmDialog(null,msg,"İşlemi yapmak istediginize emin misiniz?",JOptionPane.YES_NO_OPTION)==0;
    }

    public static int screenCenter(String axis, Dimension size) {    //Ekranı ortalatacak olan metot
        int point = 0;
        switch (axis) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }
        return point;
    }


    public static boolean isComboBoxEmpty(JComboBox comboBox) { //bu metot ile comboboxlarımın içini kontrol edeceğim boş mu diye!
        return comboBox.getItemCount() == 0; //Çünkü eğer boş olursa disable edeceğim yerler olacak!
    }



}
