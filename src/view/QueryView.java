package view;

import java.awt.EventQueue;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import view.BaseView;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import com.toedter.calendar.*;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.Date;
import main.UserSession;
import controller.QueryController;
import javax.swing.JButton;
import main.Hotel;
import javax.swing.table.*;

public class QueryView extends BaseView {
    private JFrame frame;
    private QueryController controller;
    private int selectHotelStar = 3;
    private int selectSingleNum;
    private int selectDoubleNum;
    private int selectQuadNum;
    private JTextField textField;
    private JTable jt;
    private Object[][] data;
    private SimpleDateFormat myFormat = new SimpleDateFormat("MM/dd");
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QueryView window = new QueryView(true);
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
    private QueryView(Boolean testFlag) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize();
    }
    public QueryView() {}

    public void setProperty(QueryController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initialize();
    }
    public Object[][] getHotel(){
        Object [][] resultObject = new Object[1500][5];
        ArrayList<Hotel> resultHotel = controller.hotelInfo;
        for(int i=0; i<resultHotel.size(); i++) {
            Hotel tmpHotel = resultHotel.get(i);
            int totalPrice = tmpHotel.calPrice(1, 1, 1);
            resultObject[i] = new Object[]{tmpHotel.getHotelId(), tmpHotel.getHotelStar(), tmpHotel.getAddress(), tmpHotel.getLocality(), totalPrice};
        }
        return resultObject;
    }
    /**
     * Initialize the contents of the frame.
     */

    protected void initialize() {
        data=getHotel();
        String[] columns={"HotelID","星級","地點","地址","價位"};
        DefaultTableModel model = new DefaultTableModel(data, columns);
        jt=new JTable(model);
        jt.setShowHorizontalLines(true);
        jt.setShowVerticalLines(true);
        //		jt.setPreferredScrollableViewportSize(new Dimension(400,300));
        //		frame.getContentPane().add(list);

        JScrollPane scrollPane = new JScrollPane(jt);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(6, 133, 418, 214);
        frame.getContentPane().add(scrollPane);

        JLabel searchTitleLabel = new JLabel("搜尋條件");
        searchTitleLabel.setBounds(6, 6, 70, 24);
        frame.getContentPane().add(searchTitleLabel);

        JLabel filterLabel = new JLabel("篩選條件");
        filterLabel.setBounds(19, 105, 61, 16);
        frame.getContentPane().add(filterLabel);

        JRadioButton []starButtons = new JRadioButton[4]; 
        JRadioButton starFiveButton = new JRadioButton("五星級");
        starFiveButton.setBounds(76, 99, 80, 30);
        starButtons[0] = starFiveButton;
        frame.getContentPane().add(starFiveButton);

        JRadioButton starFourButton = new JRadioButton("四星級");
        starFourButton.setBounds(156, 99, 80, 30);
        starButtons[1] = starFourButton;
        frame.getContentPane().add(starFourButton);

        JRadioButton starThreeButton = new JRadioButton("三星級");
        starThreeButton.setBounds(236, 99, 80, 30);
        starButtons[2] = starThreeButton;
        frame.getContentPane().add(starThreeButton);

        JRadioButton starTwoButton = new JRadioButton("二星級");
        starTwoButton.setBounds(316, 99, 80, 30);
        starButtons[3] = starTwoButton;
        frame.getContentPane().add(starTwoButton);



        class RadioButtonActionListener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<4; i++) {
                    if (e.getSource() == starButtons[i]) {
                        for(int j=0; j<4; j++) {
                            if (j != i) {
                                starButtons[j].setSelected(false);
                            }
                        }
                        controller.getHotelByStar(5-i);
                        data = getHotel();
                        DefaultTableModel dm = (DefaultTableModel)jt.getModel();
                        dm.getDataVector().removeAllElements();
                        dm.fireTableDataChanged();
                        for(int k=0; k<data.length; k++) {
                            dm.addRow(data[k]);
                        }
                    }
                }
            }
        }

        starButtons[0].addActionListener(new RadioButtonActionListener());
        starButtons[1].addActionListener(new RadioButtonActionListener());
        starButtons[2].addActionListener(new RadioButtonActionListener());
        starButtons[3].addActionListener(new RadioButtonActionListener());


        JComboBox hotelStarComboBox = new JComboBox();
        hotelStarComboBox.setBounds(133, 6, 52, 27);
        hotelStarComboBox.addItem("請選擇星級(預設三星級)");
        hotelStarComboBox.addItem("二星級");
        hotelStarComboBox.addItem("三星級");
        hotelStarComboBox.addItem("四星級");
        hotelStarComboBox.addItem("五星級");
        frame.getContentPane().add(hotelStarComboBox);

        JLabel checkInLabel = new JLabel("住房日期");
        checkInLabel.setBounds(197, 10, 61, 16);
        frame.getContentPane().add(checkInLabel);

        JDateChooser checkInDateChooser = new JDateChooser();
        checkInDateChooser.setBounds(250, 10, 20, 20);
        frame.getContentPane().add(checkInDateChooser);

        JDateChooser checkOutDateChooser = new JDateChooser();
        checkOutDateChooser.setBounds(382, 10, 20, 20);
        frame.getContentPane().add(checkOutDateChooser);

        JLabel checkOutLabel = new JLabel("退房日期");
        checkOutLabel.setBounds(327, 10, 61, 16);
        frame.getContentPane().add(checkOutLabel);

        JLabel hotelStarLabel = new JLabel("飯店星級");
        hotelStarLabel.setBounds(76, 10, 61, 16);
        frame.getContentPane().add(hotelStarLabel);

        JLabel singleRoomLabel = new JLabel("單人房數量");
        singleRoomLabel.setBounds(76, 38, 77, 16);
        frame.getContentPane().add(singleRoomLabel);

        JTextField singleRoomField = new JTextField("0");
        singleRoomField.setBounds(143, 34, 52, 25);
        frame.getContentPane().add(singleRoomField);

        JLabel doubleRoomLabel = new JLabel("雙人房數量");
        doubleRoomLabel.setBounds(197, 38, 81, 16);
        frame.getContentPane().add(doubleRoomLabel);

        JTextField doubleRoomField = new JTextField("0");
        doubleRoomField.setBounds(265, 34, 52, 25);
        frame.getContentPane().add(doubleRoomField);

        JLabel quadRoomLabel = new JLabel("四人房數量");
        quadRoomLabel.setBounds(327, 38, 70, 16);
        frame.getContentPane().add(quadRoomLabel);

        JTextField quadRoomField = new JTextField("0");
        quadRoomField.setBounds(392, 34, 52, 25);
        frame.getContentPane().add(quadRoomField);

        JButton searchHotelButton = new JButton("搜尋飯店");
        searchHotelButton.setBounds(327, 66, 120, 30);
        frame.getContentPane().add(searchHotelButton);

        JButton returnMenuButton = new JButton("回首頁");
        returnMenuButton.setBounds(0, 343, 120, 30);
        frame.getContentPane().add(returnMenuButton);
        
        JLabel checkInDataLabel = new JLabel("");
        checkInDataLabel.setBounds(270, 8, 61, 20);
        frame.getContentPane().add(checkInDataLabel);
        
        JLabel checkOutDateLabel = new JLabel("");
        checkOutDateLabel.setBounds(394, 10, 61, 16);
        frame.getContentPane().add(checkOutDateLabel);

        hotelStarComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie){
                JComboBox localCombo = (JComboBox)ie.getSource();
                selectHotelStar = localCombo.getSelectedIndex();
            }
        });
        searchHotelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int singleNum =  Integer.parseInt(singleRoomField.getText());
                int doubleNum =  Integer.parseInt(doubleRoomField.getText());
                int quadNum = Integer.parseInt(quadRoomField.getText());
                System.out.println("User Book "+singleNum+" single room and "+doubleNum+" double room and "+quadNum+" quad room");
                Date checkInDate = checkInDateChooser.getDate();
                Date checkOutDate = checkOutDateChooser.getDate();
                System.out.println(checkInDate);
                System.out.println(checkOutDate);
                UserSession.getInstance(true).setReserveRoomNum(singleNum, doubleNum, quadNum);
                try {
                    controller.searchMatchHotel(selectHotelStar, singleNum, doubleNum, quadNum, checkInDate, checkOutDate);
                } catch (ParseException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        returnMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.returnMenu();
            }
        });
        
        checkInDateChooser.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName())) {
                            Date newDate = (Date) e.getNewValue();
                            checkInDataLabel.setText(myFormat.format(newDate));
                        }
                    }
                });
        checkOutDateChooser.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName())) {
                            Date newDate = (Date) e.getNewValue();
                            checkOutDateLabel.setText(myFormat.format(newDate));
                        }
                    }
                });
        
        
        
    }
}
