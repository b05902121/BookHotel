package main;

import java.util.ArrayList;
import java.util.Date;
import main.Order;
public class UserSession {
    private UserSession() {} // private constructor
    private static UserSession instance;

    // User Property
    private String _username;
    private String _password;
    private ArrayList<Hotel> searchHotel = new ArrayList<Hotel>();
    private int[] reserveRoomNum = {0,0,0};
    private ArrayList<Date> orderDate = new ArrayList<Date>();
    private Order orderCache;

    public static UserSession getInstance(boolean isReuse) {
        if(!isReuse || instance == null){
            instance = new UserSession();
        } 
        return instance;
    }

    public void signIn(String username, String password) {
        _username = username;
        _password = password;
    }

    public void logout() {
        instance = null;
    }

    public void setResultHotel(ArrayList<Hotel> hotel) {
        this.searchHotel = hotel;
    }
    public void setOrderDate(Date checkIn, Date checkOut) {
        this.orderDate.add(checkIn);
        this.orderDate.add(checkOut);
    }

    public ArrayList<Date> getOrderDate(){
        return this.orderDate;
    }

    public void setOrderCache(Order order) {
        this.orderCache = order;
    }

    public Order getCacheOrder() {
        return this.orderCache;
    }

    public ArrayList<Hotel> getResultHotel(){
        return this.searchHotel;
    }

    public void cleanOrderCache() {
        this.searchHotel.clear();
        this.orderCache = null;
        this.orderDate.clear();
        this.reserveRoomNum[0] = 0;
        this.reserveRoomNum[1] = 0;
        this.reserveRoomNum[2] = 0;
    }

    public void setReserveRoomNum(int sNum, int dNum, int qNum) {
        this.reserveRoomNum[0] = sNum;
        this.reserveRoomNum[1] = dNum;
        this.reserveRoomNum[2] = qNum;
    }

    public int[] getReserveRoomNum() {
        return reserveRoomNum;
    }

    public String getUsername() {
        return _username;
    }

    public void testingMethod() {
        System.out.println(String.format("[Session] Tesing: U: %s, P: %s,",
                _username, _password));
    }
}
