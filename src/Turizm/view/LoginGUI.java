package Turizm.view;

import Turizm.core.Helper;
import Turizm.business.LoginManager;

import javax.swing.*;

public class LoginGUI extends Layout {
    private JPanel wrapper;
    private JTextField txt_username_tcno;
    private JPasswordField txt_password;
    private JButton btn_login;
    private JCheckBox pass_show;

    // We will call business operations from here, such as adding, deleting, etc.
    private LoginManager loginManager;

    public LoginGUI(LoginManager loginManager) {
        this.loginManager = loginManager;

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

            add(wrapper);
            setGUILayout(350, 250);

            // Action listener for the login button
            btn_login.addActionListener(e -> {
                // Check if the username/TC No or password fields are empty
                if (Helper.isFieldEmpty(txt_username_tcno) || Helper.isFieldEmpty(txt_password)) {
                    Helper.s_Msg("Error", "Please fill in all fields");
                } else {
                    // Try to log in with the provided credentials
                    if (loginManager.login(txt_username_tcno.getText(), txt_password.getText())) {
                        dispose(); // Close the login window upon successful login
                    } else {
                        Helper.s_Msg("Warning", "Incorrect username or password!!!");
                    }
                }
            });


        pass_show.addActionListener(e -> { //parolayı göstermeye yarayacak.
            if (pass_show.isSelected()){
                txt_password.setEchoChar((char)0);
            }else {
                txt_password.setEchoChar('*');
            }
        });


    }
}