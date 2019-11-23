package MainClass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.Naming;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
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
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

import Custom.RoundedButton;
import Interface.DatabaseInterface;
import Utils.LoginData;

public class LoginScreen extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	static LoginData loginData;
	private LoginData temp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		frame = new JFrame("Login");

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

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(209, 27, 67, 29);
		lblLogin.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblLogin.setForeground(Color.WHITE);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(114, 110, 72, 30);
		lblUsername.setFont(new Font("Arial", Font.BOLD, 15));
		lblUsername.setForeground(Color.WHITE);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setBounds(304, 116, 86, 20);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(114, 175, 72, 30);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));

		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(304, 181, 86, 20);
		textField_1.setColumns(10);

		JLabel lblUsernameAndPassword = new JLabel("*UserName and password Not Match");
		lblUsernameAndPassword.setBounds(159, 296, 170, 14);
		lblUsernameAndPassword.setForeground(Color.RED);
		lblUsernameAndPassword.setVisible(false);
		lblUsernameAndPassword.setFont(new Font("Calibri", Font.PLAIN, 10));
		panel.add(lblUsernameAndPassword);

		JButton btnLogin = new RoundedButton("Login", 20, Color.white);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean trueorfalse;

					if (textField.getText().equals("") || textField_1.getText().equals("")) {

					} else {
						LoginData lo = new LoginData();
						trueorfalse = lo.checkLogin(textField.getText().toString(), textField_1.getText().toString());
						if (trueorfalse) {
							new MainScreen().setVisible(true);
							lblUsernameAndPassword.setVisible(false);
							frame.setVisible(false);
						} else {
							lblUsernameAndPassword.setVisible(true);
						}
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnLogin.setBounds(187, 255, 100, 30);
		btnLogin.setForeground(UIManager.getColor("Button.background"));
		btnLogin.setOpaque(false);
		btnLogin.setBorderPainted(false);

		panel.setLayout(null);
		panel.add(lblLogin);
		panel.add(lblUsername);
		panel.add(lblPassword);
		panel.add(textField_1);
		panel.add(textField);
		panel.add(btnLogin);

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
