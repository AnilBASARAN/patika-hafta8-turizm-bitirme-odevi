package Turizm.business;

import Turizm.dao.EmployeeHotelDetailDao;
import Turizm.entity.*;
import java.util.ArrayList;

public class EmployeeHotelDetailManager{
    private EmployeeHotelDetailDao detailRepository = new EmployeeHotelDetailDao();

    public ArrayList<Season> getSeasonListByHotelID(int hotelID) {
        return detailRepository.getSeasonListByHotelID(hotelID);
    }


    public boolean addSeason(int hotelID, String seasonName, String startDate, String endDate) {
        return detailRepository.addSeason(hotelID,seasonName,startDate,endDate);
    }


    public ArrayList<Pension> getPensionList(int hotelID) {
        return detailRepository.getPensionList(hotelID);
    }


    public ArrayList<Pension> getPensionTypeList() {
        return detailRepository.getPensionTypeList();
    }


    public boolean addPensiontoHotel(int hotelID, int pensionID, String pensionName) {
        return detailRepository.addPensiontoHotel(hotelID,pensionID,pensionName);
    }


    public ArrayList<HotelFeature> getHotelFeaturesList() {
        return detailRepository.getHotelFeaturesList();
    }


    public boolean addHotelFeature(int hotelID,int featureID ,String featuretoAdd) {
        return detailRepository.addHotelFeature(hotelID,featureID,featuretoAdd);
    }


    public boolean addHotelRoom(int hotelID, int seasonID, int pensionID, String roomType, int bedNumber, int stock, int priceChildren,int priceAdult) {
        return detailRepository.addHotelRoom(hotelID,seasonID,pensionID,roomType,bedNumber,stock,priceChildren,priceAdult);
    }


    public ArrayList<HotelFeature> getHotelFeatureListByID(int hotelID) {
        return detailRepository.getHotelFeatureListByID(hotelID);
    }


    public ArrayList<Room> getHotelRoomListByID(int hotelID) {
        return detailRepository.getHotelRoomListByID(hotelID);
    }


    public String getSeasonNameByID(int seasonID) {
        return detailRepository.getSeasonNameByID(seasonID);
    }


    public String getPensionNameByID(int pensionID) {
        return detailRepository.getPensionNameByID(pensionID);
    }


    public boolean addHotelRoomProperty(int roomID, String roomProperty) {
        return detailRepository.addHotelRoomProperty(roomID,roomProperty);
    }


    public ArrayList<RoomFeature> getRoomFeatureList(int roomID) {
        return detailRepository.getRoomFeatureList(roomID);
    }


    public boolean updateRoomInfo(String roomType, int bedNumber, int stock, int priceChild, int priceAdult) {
        return detailRepository.updateRoomInfo(roomType,bedNumber,stock,priceChild,priceAdult);
    }


    public boolean deleteRoom(int roomID) {
        return detailRepository.deleteRoom(roomID);
    }


    public boolean deleteSeason(int seasonID) {
        return detailRepository.deleteSeason(seasonID);
    }


    public boolean deleteHotelFeature(int hotelID, String featureName) {
        return detailRepository.deleteHotelFeature(hotelID,featureName);
    }


    public boolean deleteHotelPension(int pensionID) {
        return detailRepository.deleteHotelPension(pensionID);
    }


    public boolean deleteRoomProperty(int roomID, String property) {
        return detailRepository.deleteRoomProperty(roomID,property);
    }

}
