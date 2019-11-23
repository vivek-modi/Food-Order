package MainClass;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Custom.RoundedButton;
import Utils.DataHelper;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class BillScreen extends JFrame {

	static ArrayList<DataHelper> manuplate;
	JFrame frame;
	private JTable table;
	private Properties configProps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillScreen frame = new BillScreen(manuplate);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BillScreen(ArrayList<DataHelper> me) {

		manuplate = me;

		frame = new JFrame("Bill Reciept");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 394);
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

		JLabel lblNewLabel = new JLabel("Your item List");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(145, 25, 100, 28);
		panel.add(lblNewLabel);

		String[] columns = new String[] { "Id", "Name", "Hourly Rate", "Part Time" };

		// actual data for the table in a 2d array
		Object[][] data = new Object[][] { { 1, "John", 40.0, false }, { 2, "Rambo", 70.0, false },
				{ 3, "Zorro", 60.0, true }, };

		DefaultTableModel model = new DefaultTableModel(columns, 0);

		Color c = Color.decode("#e2e2e2");
		table = new JTable(model);
		table.setForeground(c);
		table.setGridColor(Color.black);
		setCellsAlignment(table, SwingConstants.CENTER);
		table.setBackground(Color.BLACK);
		for (DataHelper datah : manuplate) {
			Object[] rowData = new Object[4];
			rowData[0] = datah.getItemName();
			rowData[1] = datah.getRate();
			rowData[2] = datah.getQuantity();
			rowData[3] = datah.getTotal();
			model.addRow(rowData);
		}

		table.setBounds(10, 112, 380, 111);
		panel.add(table);

		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setForeground(c);
		lblItemName.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblItemName.setBounds(10, 73, 80, 28);
		panel.add(lblItemName);

		JLabel lblItemQuantity = new JLabel("Item Quantity");
		lblItemQuantity.setForeground(c);
		lblItemQuantity.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblItemQuantity.setBounds(115, 73, 80, 28);
		panel.add(lblItemQuantity);

		JLabel lblItemRate = new JLabel("Item Rate");
		lblItemRate.setForeground(c);
		lblItemRate.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblItemRate.setBounds(227, 73, 69, 28);
		panel.add(lblItemRate);

		JLabel lblTotak = new JLabel("Total");
		lblTotak.setForeground(c);
		lblTotak.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblTotak.setBounds(331, 73, 59, 28);
		panel.add(lblTotak);

		JLabel label = new JLabel(
				"---------------------------------------------------------------------------------------------------");
		label.setForeground(Color.WHITE);
		label.setBounds(0, 247, 400, 14);
		panel.add(label);

		JLabel label_1 = new JLabel("Total");
		label_1.setForeground(new Color(226, 226, 226));
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		label_1.setBounds(227, 259, 37, 28);
		panel.add(label_1);

		int sum = 0;

		for (DataHelper total : manuplate) {
			sum += total.getTotal();
		}

		JLabel lblValue = new JLabel(String.valueOf(sum));
		lblValue.setForeground(new Color(226, 226, 226));
		lblValue.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblValue.setBounds(342, 259, 37, 28);
		panel.add(lblValue);

		JLabel label_2 = new JLabel(
				"---------------------------------------------------------------------------------------------------");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(0, 286, 400, 14);
		panel.add(label_2);

		JButton btnCloseButton = new RoundedButton("Close", 20, Color.white);
		btnCloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(frame, "Thanks For Visiting Online Food Order");

			}
		});
		btnCloseButton.setBounds(290, 319, 89, 23);
		btnCloseButton.setOpaque(false);
		btnCloseButton.setForeground(UIManager.getColor("Button.background"));
		btnCloseButton.setBorderPainted(false);
		panel.add(btnCloseButton);

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

	public static void setCellsAlignment(JTable table, int alignment) {
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(alignment);

		TableModel tableModel = table.getModel();

		for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
			if (columnIndex == 0) {

			} else {
				table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);

			}
		}
	}

}
