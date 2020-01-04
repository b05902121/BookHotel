package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controller.ModifyOrderRoomController;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ModifyOrderRoomView extends BaseView {
    private JFrame frame;
    private ModifyOrderRoomController controller;
    private JTextField textFieldSingleOrigin;
    private JTextField textFieldSingleNew;
    private JTextField textFieldDoubleOrigin;
    private JTextField textFieldDoubleNew;
    private JTextField textFieldQuadOrigin;
    private JTextField textFieldQuadNew;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ModifyOrderRoomView window = new ModifyOrderRoomView(true);
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
    private ModifyOrderRoomView(Boolean testFlag) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize();
    }
    public ModifyOrderRoomView() {}

    public void setProperty(ModifyOrderRoomController controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    protected void initialize() {
        JLabel lblChangeSingleRoom = new JLabel("Change Single Room From");
        lblChangeSingleRoom.setBounds(45, 87, 176, 16);
        frame.getContentPane().add(lblChangeSingleRoom);

        JLabel lblChangeDoubleRoom = new JLabel("Change Double Room From");
        lblChangeDoubleRoom.setBounds(45, 142, 176, 16);
        frame.getContentPane().add(lblChangeDoubleRoom);

        JLabel lblChangeQuadRoom = new JLabel("Change Quad Room From");
        lblChangeQuadRoom.setBounds(45, 200, 176, 16);
        frame.getContentPane().add(lblChangeQuadRoom);

        JLabel lblToS = new JLabel("To");
        lblToS.setBounds(289, 87, 42, 16);
        frame.getContentPane().add(lblToS);

        JLabel lblToD = new JLabel("To");
        lblToD.setBounds(289, 142, 42, 16);
        frame.getContentPane().add(lblToD);

        JLabel lblToQ = new JLabel("To");
        lblToQ.setBounds(289, 200, 42, 16);
        frame.getContentPane().add(lblToQ);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(70, 296, 117, 29);
        frame.getContentPane().add(btnBack);

        JButton btnNext = new JButton("Next");
        btnNext.setBounds(251, 296, 117, 29);
        frame.getContentPane().add(btnNext);

        textFieldSingleOrigin = new JTextField();
        textFieldSingleOrigin.setEditable(false);
        textFieldSingleOrigin.setBounds(219, 82, 58, 26);
        frame.getContentPane().add(textFieldSingleOrigin);
        textFieldSingleOrigin.setColumns(10);

        textFieldSingleNew = new JTextField();
        textFieldSingleNew.setColumns(10);
        textFieldSingleNew.setBounds(321, 82, 58, 26);
        frame.getContentPane().add(textFieldSingleNew);

        textFieldDoubleOrigin = new JTextField();
        textFieldDoubleOrigin.setEditable(false);
        textFieldDoubleOrigin.setColumns(10);
        textFieldDoubleOrigin.setBounds(219, 137, 58, 26);
        frame.getContentPane().add(textFieldDoubleOrigin);

        textFieldDoubleNew = new JTextField();
        textFieldDoubleNew.setColumns(10);
        textFieldDoubleNew.setBounds(321, 137, 58, 26);
        frame.getContentPane().add(textFieldDoubleNew);

        textFieldQuadOrigin = new JTextField();
        textFieldQuadOrigin.setEditable(false);
        textFieldQuadOrigin.setColumns(10);
        textFieldQuadOrigin.setBounds(219, 195, 58, 26);
        frame.getContentPane().add(textFieldQuadOrigin);

        textFieldQuadNew = new JTextField();
        textFieldQuadNew.setColumns(10);
        textFieldQuadNew.setBounds(321, 195, 58, 26);
        frame.getContentPane().add(textFieldQuadNew);

        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.didTapNextButton();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showCheckOrderResult();
            }
        });
    }
}
