package view;

import java.awt.EventQueue;

import javax.swing.table.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

import controller.QueryController;
import controller.SearchResultController;
import main.Hotel;
import java.util.ArrayList;
import main.UserSession;

public class SearchResultView extends BaseView {
    private JFrame frame;
    private SearchResultController controller;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchResultView window = new SearchResultView(true);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    private SearchResultView(Boolean testFlag) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize();
    }
    public SearchResultView() {}

    public void setProperty(SearchResultController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initialize();
    }
    /**
     * Initialize the contents of the frame.
     */
    public Object[][] getHotel(){
    	ArrayList<Hotel> resultHotel = UserSession.getInstance(true).getResultHotel();
    	int[] reserveRoomNum = UserSession.getInstance(true).getReserveRoomNum();
    	Object [][] resultObject = new Object[1500][5];
    	for(int i=0; i<resultHotel.size(); i++) {
    		Hotel tmpHotel = resultHotel.get(i);
    		int totalPrice = tmpHotel.calPrice(reserveRoomNum[0], reserveRoomNum[1], reserveRoomNum[2]);
    		resultObject[i] = new Object[]{tmpHotel.getHotelId(), tmpHotel.getHotelStar(), tmpHotel.getAddress(), tmpHotel.getLocality(), totalPrice};
    	}
    	return resultObject;
    }
    protected void initialize() {
        JLabel titleLabel = new JLabel("Hotels matched");
        titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(76, 6, 290, 51);
        frame.getContentPane().add(titleLabel);

        class customButton extends JButton {
            public customButton(String text) {
                super(text);
                this.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Been Pushed");
                    }
                });
            }
        }
        Object[][] data=getHotel();
        System.out.println("Total Result: "+data.length);
        String[] columns={"HotelID","star","Address","Locality","Price"};
        JTable table=new JTable(data,columns);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(18, 70, 365, 267);
        frame.getContentPane().add(scrollPane);

        JButton bookHotelButton = new JButton("Book");
        bookHotelButton.setBounds(327, 343, 120, 30);
        frame.getContentPane().add(bookHotelButton);
        
        JButton returnLastPageButton = new JButton("Last page");
        returnLastPageButton.setBounds(212, 343, 120, 30);
        frame.getContentPane().add(returnLastPageButton);
        
        JButton returnMenuButton = new JButton("Menu");
        returnMenuButton.setBounds(98, 343, 120, 30);
        frame.getContentPane().add(returnMenuButton);
        
        JLabel hintLabel = new JLabel("");
        if (UserSession.getInstance(true).getResultHotel().size() == 0) {
        	hintLabel.setText("No Hotels Match");
        }
        hintLabel.setHorizontalAlignment(SwingConstants.CENTER);
        hintLabel.setForeground(Color.RED);
        hintLabel.setBounds(120, 46, 200, 16);
        frame.getContentPane().add(hintLabel);
        
        bookHotelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hotel Number " + table.getSelectedRow() + " is choosed");
                Object[][] hotelList = getHotel();
                int id = table.getSelectedRow();
                int choosedHotelId = (int)hotelList[id][0];
                int totalPrice = (int)hotelList[id][4];
                controller.confirmOrder(choosedHotelId, totalPrice);
            }
        });
        returnLastPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               try {
				controller.returnLastPage();
			} catch (ParseException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            }
        });
        returnMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.returnMenuPage();
            }
        });
        
    }
}
