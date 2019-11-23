package Custom;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class RoundedButton extends JButton {

	Color color;
	int round;

	public RoundedButton(String btnText, int rounded, Color colorName) {
		super(btnText);
		setFocusable(false);
		super.setContentAreaFilled(false);
		color = colorName;
		round = rounded;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		Color lightwight = Color.decode("#d8d8d8");
		RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHints(qualityHints);
		if (getModel().isPressed()) {
			g2.setPaint(new GradientPaint(new Point(0, 0), color, new Point(0, getHeight()), lightwight));
			g2.fillRoundRect(0, 0, getWidth(), getHeight(), round, round);
		} else {
			g2.setPaint(new GradientPaint(new Point(0, 0), color, new Point(0, getHeight()), color));
			g2.fillRoundRect(0, 0, getWidth(), getHeight(), round, round);
		}
		g2.dispose();
		super.paintComponent(g);
	}

}