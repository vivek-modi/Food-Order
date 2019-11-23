package Utils;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JSpinner;

public class CheckBoxHelper {

	private JCheckBox checkbox;
	private JSpinner spinner;
	private int SpinnerValue = 1;

	public CheckBoxHelper(JCheckBox checkbox, JSpinner spinner) {
		super();
		this.checkbox = checkbox;
		this.spinner = spinner;
	}

	public void operation() {

		spinner.setEnabled(false);
		checkbox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				boolean firstTime = true;
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (firstTime) {
						spinner.setValue(SpinnerValue);
					} else {
						spinner.setValue(SpinnerValue);

					}
					spinner.setEnabled(true);
				} else {
					firstTime = false;
					SpinnerValue = (Integer) spinner.getValue();
					spinner.setValue(0);
					spinner.setEnabled(false);
				}

			}
		});
	}
}
