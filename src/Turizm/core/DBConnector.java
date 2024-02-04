package Turizm.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
    private Connection connection = null;
    private static DBConnector instance = null;

    private DBConnector() {
        try{
            this.connection = DriverManager.getConnection(
                    Config.DB_URL,
                    Config.DB_USERNAME,
                    Config.DB_PASSWORD);

        }catch (Exception e){
            Helper.s_Msg("Hata","error: Veritabanı Baglantı Hatası");
        }

    }
    public Connection getConnection(){
        return connection;
    }
    public static Connection getConnectionInstance() {
        try {
            if(instance==null || instance.getConnection().isClosed()){
                instance = new DBConnector();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return instance.getConnection();
    }
    public static PreparedStatement getPreparedStatement(String query){
        PreparedStatement ps=null;
        try{
            ps = DBConnector.getConnectionInstance().prepareStatement(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ps;
    }

    public static ResultSet getResultset(String query){
        ResultSet rs = null;
        try{
            rs =  DBConnector.getConnectionInstance().createStatement().executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

}
