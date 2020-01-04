package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controller.CheckOrderController;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class CheckOrderView extends BaseView {
    private JFrame frame;

    Object[][] data = {
            {"qwertyuiop", "1", "hotel1", 1, 2, 3, 2000},
            {"qwertyuiop", "1", "hotel1", 1, 2, 3, 2000},
            {"qwertyuiop", "1", "hotel1", 1, 2, 3, 2000},
    };
    String[] columns = {"OrderID", "HotelID", "HotelName", "Single", "Double", "Quad", "Total Prize"};

    private CheckOrderController controller;

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

        DefaultTableModel tableModel = new DefaultTableModel(data, columns);
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
                System.out.println("[Order List] Hotel Number " + jt.getSelectedRow() + " is choosed");
                controller.showCheckOrderResult(jt.getSelectedRow());
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
