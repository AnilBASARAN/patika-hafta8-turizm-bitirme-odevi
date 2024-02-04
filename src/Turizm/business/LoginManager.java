package Turizm.business;

import Turizm.dao.LoginDao;
import Turizm.entity.User;
import Turizm.view.AdminGUI;
import Turizm.view.EmployeeGUI;

public class LoginManager{
    private LoginDao loginRepository;
    public LoginManager(LoginDao loginRepository) {
        this.loginRepository = loginRepository;
    }


    public boolean login(String userName_tcNo, String password) {
        int id;
        if((id = loginRepository.login(userName_tcNo,password)) != -1){
            // Kullanıcı tipine göre login olacak
            User user = loginRepository.getUserByID(id);
            switch (user.getUserType()){
                case "admin":
                    AdminGUI admin = new AdminGUI(user);
                    break;
                case "employee":
                    EmployeeGUI e = new EmployeeGUI(user);
                    break;
            }
            return true;
        }
        return false;
    }
}
