package MainClass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

import Custom.RoundedButton;
import DataBase.InsertData;
import Interface.DatabaseInterface;

public class SignUpScreen extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private boolean checking = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpScreen frame = new SignUpScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUpScreen() {
		frame = new JFrame("SignUp");

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 360);
		frame.setLocationRelativeTo(null);

		UIDefaults uiDefaults = UIManager.getDefaults();
		uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.white));
		JFrame.setDefaultLookAndFeelDecorated(true);

		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		frame.setContentPane(panel);
		panel.setLayout(null);

		JLabel lblSignup = new JLabel("SignUp");
		lblSignup.setBounds(192, 21, 85, 32);
		lblSignup.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblSignup.setForeground(Color.WHITE);
		panel.add(lblSignup);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(102, 101, 72, 18);
		lblUsername.setFont(new Font("Arial", Font.BOLD, 15));
		lblUsername.setForeground(Color.WHITE);
		panel.add(lblUsername);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setBounds(267, 101, 102, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblPassword.setBounds(102, 162, 72, 18);
		panel.add(lblPassword);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(267, 162, 102, 20);
		panel.add(textField_1);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmail.setBounds(102, 223, 72, 18);
		panel.add(lblEmail);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.BLACK);
		textField_2.setBounds(267, 223, 102, 20);
		panel.add(textField_2);

		JLabel note = new JLabel("*password more than 4 word...");
		note.setBounds(267, 181, 136, 23);
		note.setForeground(Color.RED);
		note.setVisible(false);
		note.setFont(new Font("Calibri", Font.PLAIN, 10));
		panel.add(note);

		JLabel lblfieldsAreEmpty = new JLabel("*Fields are Empty ");
		lblfieldsAreEmpty.setBounds(192, 262, 85, 14);
		lblfieldsAreEmpty.setForeground(Color.RED);
		lblfieldsAreEmpty.setVisible(false);
		lblfieldsAreEmpty.setFont(new Font("Calibri", Font.PLAIN, 10));
		panel.add(lblfieldsAreEmpty);

		JTextField[] CheckingTextField = { textField, textField_1, textField_2 };

		JButton btnSignUp = new RoundedButton("Sign Up", 20, Color.white);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("") || textField_1.getText().equals("")
						|| textField_2.getText().equals("")) {
					note.setVisible(false);
					lblfieldsAreEmpty.setVisible(true);
				} else {
					InsertData insertData = new InsertData(textField.getText().toString(),
							textField_1.getText().toString(), textField_2.getText().toString());
					if (insertData.checklength()) {
						insertData.insertdata();
						new LoginScreen().setVisible(true);
						frame.setVisible(false);
						note.setVisible(false);
						lblfieldsAreEmpty.setVisible(false);
					} else {
						note.setVisible(true);
						lblfieldsAreEmpty.setVisible(false);
					}
				}

			}
		});
		btnSignUp.setBounds(192, 287, 89, 23);
		btnSignUp.setForeground(UIManager.getColor("Button.background"));
		btnSignUp.setOpaque(false);
		btnSignUp.setBorderPainted(false);
		panel.add(btnSignUp);

		DefaultMetalTheme z = new DefaultMetalTheme() {

			@Override
			public ColorUIResource getControlHighlight() {
				return new ColorUIResource(Color.DARK_GRAY);
			}

			// border color
			@Override
			public ColorUIResource getPrimaryControlDarkShadow() {
				return new ColorUIResource(Color.DARK_GRAY);
			}

			// close button color
			@Override
			public ColorUIResource getPrimaryControl() {
				return new ColorUIResource(new Color(175, 175, 175));
			}

			// click
			@Override
			public ColorUIResource getControl() {
				return new ColorUIResource(Color.DARK_GRAY);
			}

			// Window Title background color
			@Override
			public ColorUIResource getWindowTitleBackground() {
				return new ColorUIResource(Color.DARK_GRAY);
			}

			// Window inactive Title background color
			@Override
			public ColorUIResource getWindowTitleInactiveBackground() {
				return new ColorUIResource(Color.DARK_GRAY);
			}

			// Inactive TextColor
			@Override
			public ColorUIResource getWindowTitleInactiveForeground() {
				return new ColorUIResource(Color.white);
			}

			// start ActiveBumps
			@Override
			public ColorUIResource getPrimaryControlHighlight() {
				return new ColorUIResource(Color.DARK_GRAY);
			}

			// inactive ActiveBumps
			@Override
			public ColorUIResource getControlDarkShadow() {
				return new ColorUIResource(Color.DARK_GRAY);
			}

			// title backgroundline color
			@Override
			public ColorUIResource getPrimaryControlShadow() {
				return new ColorUIResource(Color.gray);
			}

		};

		MetalLookAndFeel.setCurrentTheme(z);
		try {
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(frame);
		frame.setVisible(true);
	}

}
