package MainClass;

import java.awt.Color;
import java.awt.Font;

import javax.security.auth.login.LoginContext;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;

import Custom.RoundedButton;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Food_Order {

	public static void main(final String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	public static void createAndShowGUI() {

		JFrame frame = new JFrame("Online Food Order");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(550, 380);
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

		JLabel lblWelcomeToOnline = new JLabel("Welcome To Online Food Order", SwingConstants.CENTER);
		lblWelcomeToOnline.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblWelcomeToOnline.setBounds(49, 26, 452, 50);
		lblWelcomeToOnline.setForeground(Color.WHITE);
		panel.add(lblWelcomeToOnline);

		JButton btnLogIn = new RoundedButton("Login", 20, Color.white);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoginScreen().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnLogIn.setForeground(UIManager.getColor("Button.background"));

		btnLogIn.setBounds(226, 166, 100, 30);
		btnLogIn.setOpaque(false);
		btnLogIn.setBorderPainted(false);
		panel.add(btnLogIn);

		JButton rndbtnSignup = new RoundedButton("SignUp", 20, Color.WHITE);
		rndbtnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SignUpScreen().setVisible(true);
				frame.dispose();
			}
		});
		rndbtnSignup.setBounds(226, 226, 100, 30);
		rndbtnSignup.setOpaque(false);
		rndbtnSignup.setForeground(UIManager.getColor("Button.background"));
		rndbtnSignup.setBorderPainted(false);
		panel.add(rndbtnSignup);

		DefaultMetalTheme z = new DefaultMetalTheme() {

			// border color
			public ColorUIResource getPrimaryControlDarkShadow() {
				return new ColorUIResource(Color.DARK_GRAY);
			}

			// close button color
			public ColorUIResource getPrimaryControl() {
				return new ColorUIResource(new Color(175, 175, 175));
			}

			// click
			public ColorUIResource getControl() {
				return new ColorUIResource(Color.DARK_GRAY);
			}

			// Window Title background color
			public ColorUIResource getWindowTitleBackground() {
				return new ColorUIResource(Color.DARK_GRAY);
			}

			// start ActiveBumps
			public ColorUIResource getPrimaryControlHighlight() {
				return new ColorUIResource(Color.DARK_GRAY);
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