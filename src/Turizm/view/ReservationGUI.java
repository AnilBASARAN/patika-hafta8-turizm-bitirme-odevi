package Turizm.view;

import Turizm.core.Helper;
import Turizm.business.EmployeeManager;

import javax.swing.*;

public class ReservationGUI extends Layout {
    private EmployeeManager repository;
    private JPanel wrapper;
    private JTextField txt_customerName;
    private JTextField txt_customerTcNo;
    private JTextField txt_customerPhone;
    private JTextField txt_customerEmail;
    private JButton btn_reservation;
    private JLabel txt_totalPrice;
    private JLabel cocuk_number;
    private JLabel adult_sayisi;
    private JLabel yetiskin_fyt;
    private JLabel cocuk_fyt;


    public ReservationGUI(EmployeeGUI gui, EmployeeManager repository, int hotelID, int roomID, int childNumber, int adultNumber, int totalPrice,int childPrice, int adultPrice) {
        add(wrapper);
        setGUILayout(500,500);
        this.repository = repository;

        txt_totalPrice.setText(String.valueOf(totalPrice));
        cocuk_number.setText(String.valueOf(childNumber));
        adult_sayisi.setText(String.valueOf(adultNumber));
        cocuk_fyt.setText(String.valueOf(childPrice));
        yetiskin_fyt.setText(String.valueOf(adultPrice));



        // Değerlendirme Formu 16
        btn_reservation.addActionListener(e -> {
            if(Helper.isFieldEmpty(txt_customerName) || Helper.isFieldEmpty(txt_customerTcNo) || Helper.isFieldEmpty(txt_customerPhone) || Helper.isFieldEmpty(txt_customerEmail)){
                Helper.s_Msg("Uyarı","Lütfen Bilgilerinizi Eksiksiz Doldurunuz");
            }else{
                if(repository.addReservation(
                        hotelID,
                        roomID,
                        txt_customerName.getText(),
                        txt_customerTcNo.getText(),
                        txt_customerPhone.getText(),
                        txt_customerEmail.getText(),
                        childNumber,
                        adultNumber)){
                    // Değerlendirme Formu 17
                    repository.decreaseStock(roomID);
                    gui.loadRezervationList();
                    Helper.s_Msg("Başarılı","Rezervasyon Yapıldı");
                    dispose();
                }
            }
        });
    }
}
