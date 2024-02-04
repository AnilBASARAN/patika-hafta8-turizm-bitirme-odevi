package Turizm.business;

import Turizm.dao.AdminDao;
import Turizm.entity.User;

import java.util.ArrayList;

public class AdminManager{

    private AdminDao adminRepository = new AdminDao();

    public AdminManager(){

    }


    public boolean addUser(String tcNo, String username, String password, String name, String surname, String userType) {
        return adminRepository.addUser(tcNo,username,password,name,surname,userType);
    }


    public boolean updateUser(int userID,String tcNo, String username, String password, String name, String surname, String userType) {
        return adminRepository.updateUser(userID,tcNo,username,password,name,surname,userType);
    }


    public boolean deleteUser(int userID) {
        return adminRepository.deleteUser(userID);
    }


    public ArrayList<User> getUserList() {
        return adminRepository.getUserList();
    }
}
