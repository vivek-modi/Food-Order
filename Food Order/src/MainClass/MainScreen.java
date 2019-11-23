package MainClass;

import Data.RefinedData;
import Utils.CheckBoxHelper;
import Utils.DataHelper;
import Utils.PriceHelper;

import java.awt.*;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import Custom.RoundedButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

	private JFrame frame;
	int[] priceofmeal = { 2, 5, 6, 8, 12, 8, 11, 20 };
	private String[] nameofmeal = { "Cheese Burger", "Quarter Pounder", "Chicken Pounder", "Fillet Burger", "Samosa",
			"Pakora", "Mixed Platter", "Onion Bhaji" };
	private ArrayList<PriceHelper> mealarraylist;
	private Properties configProps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		frame = new JFrame("Menu");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 600);
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

		mealarraylist = new ArrayList<PriceHelper>();
		for (int i = 0; i < priceofmeal.length; i++) {
			mealarraylist.add(new PriceHelper(nameofmeal[i], priceofmeal[i]));
		}

		JLabel lblNewLabel = new JLabel("Choose Your Preference");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(229, 44, 446, 54);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setOpaque(true);
		panel_1.setBounds(58, 146, 291, 286);
		panel_1.setBackground(Color.BLACK);
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder(null, "Meal Deal", TitledBorder.LEFT, TitledBorder.TOP,
				new Font("Century Gothic", Font.BOLD, 20), Color.WHITE));

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(true);
		panel_2.setBorder(BorderFactory.createTitledBorder(null, "Vegetarian Starters", TitledBorder.LEFT,
				TitledBorder.TOP, new Font("Century Gothic", Font.BOLD, 20), Color.WHITE));
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(434, 146, 291, 286);
		panel.add(panel_2);

		JSpinner chessespinner = new JSpinner();
		chessespinner.setBounds(218, 62, 44, 20);
		((SpinnerNumberModel) chessespinner.getModel()).setMinimum(0);
		panel_1.add(chessespinner);

		JSpinner quarterspinner = new JSpinner();
		quarterspinner.setBounds(218, 116, 44, 20);
		((SpinnerNumberModel) quarterspinner.getModel()).setMinimum(0);
		panel_1.add(quarterspinner);

		JSpinner chickenspinner = new JSpinner();
		chickenspinner.setBounds(218, 165, 44, 20);
		((SpinnerNumberModel) chickenspinner.getModel()).setMinimum(0);
		panel_1.add(chickenspinner);

		JSpinner filletspinner = new JSpinner();
		filletspinner.setBounds(218, 216, 44, 20);
		((SpinnerNumberModel) filletspinner.getModel()).setMinimum(0);
		panel_1.add(filletspinner);

		JSpinner samosaspinner = new JSpinner();
		samosaspinner.setBounds(218, 62, 44, 20);
		((SpinnerNumberModel) samosaspinner.getModel()).setMinimum(0);
		panel_2.add(samosaspinner);

		JSpinner pakoraspinner = new JSpinner();
		pakoraspinner.setBounds(218, 116, 44, 20);
		((SpinnerNumberModel) pakoraspinner.getModel()).setMinimum(0);
		panel_2.add(pakoraspinner);

		JSpinner mixedspinner = new JSpinner();
		mixedspinner.setBounds(218, 165, 44, 20);
		((SpinnerNumberModel) mixedspinner.getModel()).setMinimum(0);
		panel_2.add(mixedspinner);

		JSpinner onionspinner = new JSpinner();
		onionspinner.setBounds(218, 216, 44, 20);
		((SpinnerNumberModel) onionspinner.getModel()).setMinimum(0);
		panel_2.add(onionspinner);

		JCheckBox chckbxCheeseBurger = new JCheckBox("Cheese Burger");
		chckbxCheeseBurger.setBackground(Color.BLACK);
		chckbxCheeseBurger.setForeground(Color.WHITE);
		chckbxCheeseBurger.setBounds(23, 61, 133, 23);
		panel_1.add(chckbxCheeseBurger);
		new CheckBoxHelper(chckbxCheeseBurger, chessespinner).operation();

		JCheckBox chckbxQuarterPounder = new JCheckBox("Quarter Pounder");
		chckbxQuarterPounder.setForeground(Color.WHITE);
		chckbxQuarterPounder.setBackground(Color.BLACK);
		chckbxQuarterPounder.setBounds(23, 115, 133, 23);
		panel_1.add(chckbxQuarterPounder);
		new CheckBoxHelper(chckbxQuarterPounder, quarterspinner).operation();

		JCheckBox chckbxChickenPounder = new JCheckBox("Chicken Pounder");
		chckbxChickenPounder.setForeground(Color.WHITE);
		chckbxChickenPounder.setBackground(Color.BLACK);
		chckbxChickenPounder.setBounds(23, 164, 133, 23);
		panel_1.add(chckbxChickenPounder);
		new CheckBoxHelper(chckbxChickenPounder, chickenspinner).operation();

		JCheckBox chckbxFilletBurger = new JCheckBox("Fillet Burger");
		chckbxFilletBurger.setForeground(Color.WHITE);
		chckbxFilletBurger.setBackground(Color.BLACK);
		chckbxFilletBurger.setBounds(23, 215, 133, 23);
		panel_1.add(chckbxFilletBurger);
		new CheckBoxHelper(chckbxFilletBurger, filletspinner).operation();

		JCheckBox chckbxSamosa = new JCheckBox("Samosa");
		chckbxSamosa.setForeground(Color.WHITE);
		chckbxSamosa.setBackground(Color.BLACK);
		chckbxSamosa.setBounds(23, 61, 128, 23);
		panel_2.add(chckbxSamosa);
		new CheckBoxHelper(chckbxSamosa, samosaspinner).operation();

		JCheckBox chckbxPakora = new JCheckBox("Pakora");
		chckbxPakora.setForeground(Color.WHITE);
		chckbxPakora.setBackground(Color.BLACK);
		chckbxPakora.setBounds(23, 115, 109, 23);
		panel_2.add(chckbxPakora);
		new CheckBoxHelper(chckbxPakora, pakoraspinner).operation();

		JCheckBox chckbxMixedPlatter = new JCheckBox("Mixed Platter");
		chckbxMixedPlatter.setForeground(Color.WHITE);
		chckbxMixedPlatter.setBackground(Color.BLACK);
		chckbxMixedPlatter.setBounds(23, 164, 109, 23);
		panel_2.add(chckbxMixedPlatter);
		new CheckBoxHelper(chckbxMixedPlatter, mixedspinner).operation();

		JCheckBox chckbxOnionBhaji = new JCheckBox("Onion Bhaji");
		chckbxOnionBhaji.setForeground(Color.WHITE);
		chckbxOnionBhaji.setBackground(Color.BLACK);
		chckbxOnionBhaji.setBounds(23, 215, 109, 23);
		panel_2.add(chckbxOnionBhaji);
		new CheckBoxHelper(chckbxOnionBhaji, onionspinner).operation();

		JSpinner[] jspinnername = { chessespinner, quarterspinner, chickenspinner, filletspinner, samosaspinner,
				pakoraspinner, mixedspinner, onionspinner };

		JButton btnCalculate = new RoundedButton("Order", 20, Color.white);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> clickedData = manageCheckedCheckboxes(panel_1, panel_2);

				RefinedData refine = new RefinedData(mealarraylist, clickedData, jspinnername);
				ArrayList<DataHelper> manuplate = refine.manuplateData();

				new BillScreen(manuplate).setVisible(true);
				frame.setVisible(false);

			}
		});
		btnCalculate.setBounds(677, 508, 89, 23);
		btnCalculate.setOpaque(false);
		btnCalculate.setForeground(UIManager.getColor("Button.background"));
		btnCalculate.setBorderPainted(false);

		panel.add(btnCalculate);

		DefaultMetalTheme z = new DefaultMetalTheme() {

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

			// click and spinner arrow color
			@Override
			public ColorUIResource getControl() {
				return new ColorUIResource(Color.white);
			}

			// Window Title background color
			@Override
			public ColorUIResource getWindowTitleBackground() {
				return new ColorUIResource(Color.DARK_GRAY);
			}

			// start ActiveBumps
			@Override
			public ColorUIResource getPrimaryControlHighlight() {
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

	public static ArrayList<String> manageCheckedCheckboxes(final Container c, final Container c1) {
		Component[] comps = c.getComponents();
		Component[] comps1 = c1.getComponents();

		ArrayList<String> checkedTexts = new ArrayList<String>();

		for (Component comp : comps) {
			if (comp instanceof JCheckBox) {
				JCheckBox box = (JCheckBox) comp;
				if (box.isSelected()) {

					String text = box.getText();
					checkedTexts.add(text);
				}
			}
		}

		for (Component comp : comps1) {
			if (comp instanceof JCheckBox) {
				JCheckBox box = (JCheckBox) comp;
				if (box.isSelected()) {

					String text = box.getText();
					checkedTexts.add(text);
				}
			}
		}
		return checkedTexts;
	}
	


}
