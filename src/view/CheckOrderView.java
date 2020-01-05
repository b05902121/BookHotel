package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.CheckOrderController;
import main.Order;
import main.UserSession;
import model.OrderModel;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class CheckOrderView extends BaseView {
    private JFrame frame;
    private String[] columns = {"OrderID", "HotelID", "Single", "Double", "Quad", "Total Prize"};
    private DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    private CheckOrderController controller;
    private ArrayList<Order> orderlist;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckOrderView window = new CheckOrderView(true);
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

    private CheckOrderView(Boolean testFlag) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize();
    }
    public CheckOrderView() {}

    public void setProperty(CheckOrderController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initialize();
    }

    public void setContent(ArrayList<Order> orderlist) {
        this.orderlist = orderlist;
        if (orderlist == null || orderlist.isEmpty()) {
            showPopOutMessage("You have no orders.");
        } else {
            System.out.println(orderlist);
            for (Order order: orderlist) {
                Object[] objs = {order.getOrderId(), order.getHotelId(), 
                        order.getsNum(), order.getdNum(), order.getqNum(), order.getTotalPrice()};
                tableModel.addRow(objs);
            }
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        JLabel lblTheFollowingAre = new JLabel("The following are your orders:");
        lblTheFollowingAre.setBounds(30, 37, 206, 16);
        frame.getContentPane().add(lblTheFollowingAre);

        JTable jt = new JTable();
        jt.setShowHorizontalLines(true);
        jt.setShowVerticalLines(true);
        jt.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(jt);
        scrollPane.setBounds(30, 65, 390, 250);
        frame.getContentPane().add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton btnNext = new JButton("Next");
        btnNext.setBounds(320, 330, 120, 30);
        frame.getContentPane().add(btnNext);

        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jt.getSelectedRow() < 0) {
                    showPopOutMessage("Please select an order.");
                } else {
                    UserSession.getInstance(true).setOrderCache(orderlist.get(jt.getSelectedRow()));
                    controller.showCheckOrderResult();
                }
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 330, 120, 30);
        frame.getContentPane().add(btnCancel);

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showMenu();
            }
        });
    }
}
