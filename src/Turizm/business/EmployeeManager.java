package Turizm.business;

import Turizm.core.DBConnector;
import Turizm.dao.EmployeeDao;
import Turizm.entity.Reservation;
import Turizm.entity.Hotel;
import Turizm.entity.HotelFeature;
import Turizm.entity.RoomFeature;
import Turizm.entity.SearchResult;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class EmployeeManager{
    private EmployeeDao employeeRepository = new EmployeeDao();


    public ArrayList<Hotel> getHotelList() {
        return employeeRepository.getHotelList();
    }


    public Hotel getHotelByID(int hotelID) {
        return employeeRepository.getHotelByID(hotelID);
    }



    public boolean addHotel(String hotelName,String city,String region,String address, String hotelEmail, String hotelPhone, int star) {
        return employeeRepository.addHotel(hotelName,city,region,address,hotelEmail,hotelPhone,star);
    }


    public boolean updateHotel(int hotelID,String hotelName,String city,String region,String address, String hotelEmail, String hotelPhone, int star) {
        return employeeRepository.updateHotel(hotelID,hotelName,city,region,address,hotelEmail,hotelPhone,star);
    }


    public boolean deleteHotel(int hotelID) {
        return employeeRepository.deleteHotel(hotelID);
    }


    public String searchQuery(String city,String region,String hotelName, String startDate, String endDate, int bedCount) {
        startDate = (startDate.isEmpty()) ? startDate : formatDate(startDate);
        endDate = (endDate.isEmpty()) ? endDate : formatDate(endDate);
        return employeeRepository.searchQuery(city,region,hotelName,startDate,endDate,bedCount);
    }


    public ArrayList<SearchResult> search(String query) {
        return employeeRepository.search(query);
    }
    public ArrayList<SearchResult> search(){
        String query = "SELECT s.season_name,s.start_date,s.end_date,h.hotel_id,h.name,h.city,h.region,h.address,h.email,h.phoneNumber,h.stars,r.season_id,r.pension_id,r.room_id,r.room_type,r.bed_number,r.stock,r.price_child,r.price_adult\n" +
                "FROM tbl_season AS s\n" +
                "INNER JOIN tbl_hotel_room AS r ON s.season_id = r.season_id\n" +
                "INNER JOIN tbl_hotel AS h ON r.hotel_id = h.hotel_id\n"+
                "WHERE r.stock > 0\n";
        return employeeRepository.search(query);
    }


    public ArrayList<HotelFeature> getHotelFeatures(int hotelID) {
        return employeeRepository.getHotelFeatures(hotelID);
    }


    public ArrayList<RoomFeature> getRoomFeatures(int roomID) {
        return employeeRepository.getRoomFeatures(roomID);
    }


    public boolean addReservation(int hotelID, int roomID, String customerName, String customerTc, String customerPhone, String customerEmail, int childNumber, int adultNumber) {
        return employeeRepository.addReservation(hotelID,roomID,customerName,customerTc,customerPhone,customerEmail,childNumber,adultNumber);
    }


    public boolean decreaseStock(int roomID) {
        return employeeRepository.decreaseStock(roomID);
    }


    public boolean increaseStock(int roomID) {
        return employeeRepository.increaseStock(roomID);
    }


    public ArrayList<Reservation> getReservationList() {
        return employeeRepository.getReservationList();
    }


    public boolean updateReservation(int reservationID,String customerName, String customerTc, String customerPhone, String customerEmail, int childNumber, int adultNumber) {
        return employeeRepository.updateReservation(reservationID,customerName,customerTc,customerPhone,customerEmail,childNumber,adultNumber);
    }


    public boolean deleteReservation(int reservationID) {
        return employeeRepository.deleteReservation(reservationID);
    }


    public void deleteRoomByHotelID(int hotelID) {
    }


    public void deleteSeasonByHotelID(int hotelID) {
    }

    public Boolean isValidDates(String dateToCheck1,String dateToCheck2){
        if(dateToCheck1.isEmpty()&&dateToCheck2.isEmpty()){return true;}
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = null;
        try {
            if(!dateToCheck1.isEmpty()){
                date = LocalDate.parse(dateToCheck1,DATE_TIME_FORMATTER);
            }
            if(!dateToCheck2.isEmpty()){
                date = LocalDate.parse(dateToCheck2,DATE_TIME_FORMATTER);
            }
            return true;
        }catch (Exception e){

        }
        return false;
    }
    private String formatDate(String input){
        String[] arr = input.split("/");
        return arr[2]+"-"+arr[1]+"-"+arr[0];
    }
    public String formatDateBack(String input){
        String[] arr = input.split("-");
        return arr[2]+"/"+arr[1]+"/"+arr[0];
    }
    public int calculateDay(String startDate,String endDate){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date1 = LocalDate.parse(startDate,dtf);
            LocalDate date2 = LocalDate.parse(endDate,dtf);
            return (int)ChronoUnit.DAYS.between(date1,date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getPensionNameByID(int pensionID) {
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT pension_name FROM tbl_pensiontype WHERE id="+pensionID).executeQuery()) {
            if(rs.next()){
                return rs.getString("pension_name");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
