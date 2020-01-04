package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import controller.ModifyOrderDateController;
import main.Order;
import main.UserSession;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class ModifyOrderDateView extends BaseView {
    private JFrame frame;
    private ModifyOrderDateController controller;
    private Order checkingOrder;
    private SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");

    private JTextField textFieldStartOrigin;
    private JTextField textFieldStartNew;
    private JTextField textFieldEndOrigin;
    private JTextField textFieldEndNew;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ModifyOrderDateView window = new ModifyOrderDateView(true);
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
    private ModifyOrderDateView(Boolean testFlag) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize();
    }
    public ModifyOrderDateView() {}

    public void setProperty(ModifyOrderDateController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        checkingOrder = UserSession.getInstance(true).getCacheOrder();
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    protected void initialize() {
        JLabel lblChangeSingleRoom = new JLabel("Change Start Date From");
        lblChangeSingleRoom.setBounds(45, 60, 160, 16);
        frame.getContentPane().add(lblChangeSingleRoom);

        JLabel lblChangeDoubleRoom = new JLabel("Change End Date From");
        lblChangeDoubleRoom.setBounds(45, 160, 160, 16);
        frame.getContentPane().add(lblChangeDoubleRoom);


        JLabel lblToS = new JLabel("To");
        lblToS.setBounds(163, 100, 42, 16);
        frame.getContentPane().add(lblToS);

        JLabel lblToE = new JLabel("To");
        lblToE.setBounds(163, 200, 42, 16);
        frame.getContentPane().add(lblToE);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(70, 296, 117, 29);
        frame.getContentPane().add(btnBack);

        JButton btnNext = new JButton("Next");
        btnNext.setBounds(251, 296, 117, 29);
        frame.getContentPane().add(btnNext);

        textFieldStartOrigin = new JTextField();
        textFieldStartOrigin.setEditable(false);
        textFieldStartOrigin.setBounds(260, 55, 160, 25);
        textFieldStartOrigin.setText(controller.getDateString(checkingOrder.getStartDate()));
        frame.getContentPane().add(textFieldStartOrigin);
        textFieldStartOrigin.setColumns(10);

        textFieldStartNew = new JTextField();
        textFieldStartNew.setEditable(false);
        textFieldStartNew.setColumns(10);
        textFieldStartNew.setBounds(260, 95, 160, 25);
        textFieldStartNew.setText(controller.getDateString(checkingOrder.getStartDate()));
        frame.getContentPane().add(textFieldStartNew);

        textFieldEndOrigin = new JTextField();
        textFieldEndOrigin.setEditable(false);
        textFieldEndOrigin.setColumns(10);
        textFieldEndOrigin.setBounds(260, 155, 160, 25);
        textFieldEndOrigin.setText(controller.getDateString(checkingOrder.getEndDate()));
        frame.getContentPane().add(textFieldEndOrigin);

        textFieldEndNew = new JTextField();
        textFieldEndNew.setEditable(false);
        textFieldEndNew.setColumns(10);
        textFieldEndNew.setBounds(260, 195, 160, 25);
        textFieldEndNew.setText(controller.getDateString(checkingOrder.getEndDate()));
        frame.getContentPane().add(textFieldEndNew);

        JDateChooser checkInDateChooser = new JDateChooser();
        checkInDateChooser.setBounds(230, 95, 20, 20);
        frame.getContentPane().add(checkInDateChooser);

        JDateChooser checkOutDateChooser = new JDateChooser();
        checkOutDateChooser.setBounds(230, 195, 20, 20);
        frame.getContentPane().add(checkOutDateChooser);

        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.didTapNextButton(checkInDateChooser.getDate(), checkOutDateChooser.getDate());           
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showCheckOrderResult();
            }
        });

        checkInDateChooser.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName())) {
                            Date newDate = (Date) e.getNewValue();
                            textFieldStartNew.setText(myFormat.format(newDate));
                        }
                    }
                });

        checkOutDateChooser.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName())) {
                            Date newDate = (Date) e.getNewValue();
                            textFieldEndNew.setText(myFormat.format(newDate));
                        }
                    }
                });
    }
}
