package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;

import controller.CheckOrderController;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
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
                    CheckOrderView window = new CheckOrderView();
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
    public CheckOrderView() {
        //        initialize();
    }

    public void setProperty(CheckOrderController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        //        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTheFollowingAre = new JLabel("The following are your orders:");
        lblTheFollowingAre.setBounds(30, 37, 206, 16);
        frame.getContentPane().add(lblTheFollowingAre);

        JTable jt = new JTable();
        jt.setShowHorizontalLines(true);
        jt.setShowVerticalLines(true);

        DefaultTableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jt.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(jt);
        scrollPane.setBounds(30, 65, 390, 250);
        frame.getContentPane().add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton btnNext = new JButton("Next");
        btnNext.setBounds(314, 332, 117, 29);
        frame.getContentPane().add(btnNext);
        
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("[Order List] Hotel Number " + jt.getSelectedRow() + " is choosed");
                controller.showCheckOrderResult(jt.getSelectedRow());
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(199, 332, 117, 29);
        frame.getContentPane().add(btnCancel);
    }
}