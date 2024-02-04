package Turizm.dao;

import Turizm.core.DBConnector;
import Turizm.core.Helper;
import Turizm.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminDao {

    public boolean addUser(String tcNo, String username, String password, String name, String surname, String userType) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("INSERT INTO tbl_user (tcNo,username,password,name,surname,usertype) VALUES(?,?,?,?,?,?)")){
            ps.setString(1,tcNo);
            ps.setString(2,username);
            ps.setString(3,password);
            ps.setString(4,name);
            ps.setString(5,surname);
            ps.setString(6,userType);
            ps.executeUpdate();
            ps.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean updateUser(int userID,String tcNo, String username, String password, String name, String surname, String userType) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("UPDATE tbl_user SET tcNo=?,username=?,password=?,name=?,surname=?,usertype=? WHERE id=?")) {
            ps.setString(1,tcNo);
            ps.setString(2,username);
            ps.setString(3,password);
            ps.setString(4,name);
            ps.setString(5,surname);
            ps.setString(6,userType);
            ps.setInt(7,userID);
            ps.executeUpdate();
            ps.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteUser(int userID) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_user WHERE id="+userID)) {
            int result = ps.executeUpdate();
            ps.close();
            return result != -1;
        }catch (Exception e){
            Helper.s_Msg("Hata","Veri Tabanı Hatası!!!");
        }
        return false;
    }


    public ArrayList<User> getUserList() {
        ArrayList<User> list = new ArrayList<>();
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT * FROM tbl_user").executeQuery()) {
            while(rs.next()){
                list.add(new User(rs.getInt("id"),
                        rs.getString("tcNo"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("usertype")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
