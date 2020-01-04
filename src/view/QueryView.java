package view;

import java.awt.EventQueue;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.JFrame;
import view.BaseView;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import com.toedter.calendar.*;
import javax.swing.JTextField;
import java.util.Date;
import main.UserSession;
import controller.QueryController;
import javax.swing.JButton;

public class QueryView extends BaseView {
    private JFrame frame;
    private QueryController controller;
    private int selectHotelStar = 3;
    private int selectSingleNum;
    private int selectDoubleNum;
    private int selectQuadNum;
    private JTextField textField;

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

    /**
     * Initialize the contents of the frame.
     */

    protected void initialize() {
        Object[][] data={
                {"1","hotel1","台北","你媽區你媽路","2000"},
                {"2","hotel2","高雄","你爸街你爸區","3000"},
                {"3","hotel3","高雄","你阿公路你阿公道","1000"},
                {"4","hotel4","台中","你妹妹區","300000"}};
        String[] columns={"HotelID","HotelName","地點","地址","價位"};
        JTable jt=new JTable(data,columns);
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

        JRadioButton starFiveButton = new JRadioButton("五星級");
        starFiveButton.setBounds(76, 99, 80, 30);
        frame.getContentPane().add(starFiveButton);

        JRadioButton starFourButton = new JRadioButton("四星級");
        starFourButton.setBounds(156, 99, 80, 30);
        frame.getContentPane().add(starFourButton);

        JRadioButton starThreeButton = new JRadioButton("三星級");
        starThreeButton.setBounds(236, 99, 80, 30);
        frame.getContentPane().add(starThreeButton);

        JRadioButton starTwoButton = new JRadioButton("二星級");
        starTwoButton.setBounds(316, 99, 80, 30);
        frame.getContentPane().add(starTwoButton);

        JComboBox hotelStarComboBox = new JComboBox();
        hotelStarComboBox.setBounds(133, 6, 52, 27);
        hotelStarComboBox.addItem("請選擇星級(預設三星級)");
        hotelStarComboBox.addItem("一星級");
        hotelStarComboBox.addItem("二星級");
        hotelStarComboBox.addItem("三星級");
        hotelStarComboBox.addItem("四星級");
        hotelStarComboBox.addItem("五星級");
        frame.getContentPane().add(hotelStarComboBox);

        JLabel checkInLabel = new JLabel("住房日期");
        checkInLabel.setBounds(197, 10, 61, 16);
        frame.getContentPane().add(checkInLabel);

        JDateChooser checkInDateChooser = new JDateChooser();
        checkInDateChooser.setBounds(266, 10, 20, 20);
        frame.getContentPane().add(checkInDateChooser);

        JDateChooser checkOutDateChooser = new JDateChooser();
        checkOutDateChooser.setBounds(402, 10, 20, 20);
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
                //            	System.out.println(checkInDate.getTime());
                //            	System.out.println(checkOutDate.getTime());
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
        
    }
}
