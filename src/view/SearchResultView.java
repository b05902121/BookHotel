package view;

import java.awt.EventQueue;

import javax.swing.table.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

import controller.QueryController;
import controller.SearchResultController;

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
    protected void initialize() {
        JLabel titleLabel = new JLabel("以下顯示符合條件的飯店");
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
        Object[][] data={
                {"1","hotel1","台北","你媽區你媽路","2000"},
                {"2","hotel2","高雄","你爸街你爸區","3000"},
                {"3","hotel3","高雄","你阿公路你阿公道","1000"},
                {"4","hotel4","台中","你妹妹區","300000",}};
        String[] columns={"HotelID","HotelName","地點","地址","價位"};
        JTable table=new JTable(data,columns);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(18, 70, 365, 267);
        frame.getContentPane().add(scrollPane);

        JButton bookHotelButton = new JButton("訂房");
        bookHotelButton.setBounds(327, 343, 117, 29);
        frame.getContentPane().add(bookHotelButton);

        bookHotelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hotel Number " + table.getSelectedRow() + " is choosed");
            }
        });
    }
}
