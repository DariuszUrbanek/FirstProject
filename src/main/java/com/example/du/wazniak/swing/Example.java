package com.example.du.wazniak.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//Zadanie domowe: narysuj wszystkie przek�tne wielok�ta.

public class Example {

	private static void utworzGUI() {
		// tworzenie nowego okna
		JFrame frame = new JFrame("Regular polygon drawing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.setContentPane(panel); // ustawiamy g��wny panel

		// wymuszamy rozmiar frame'a
		Dimension dimension = new Dimension(300, 400);
		frame.setSize(dimension);
		frame.setPreferredSize(dimension);
		frame.setMinimumSize(dimension);
		frame.setMaximumSize(dimension);

		BorderLayout layout = new BorderLayout();
		panel.setLayout(layout);

		JPanel northPanel = new JPanel(new GridBagLayout()); // layout - grid
		panel.add(northPanel, BorderLayout.NORTH);

		JLabel label = new JLabel("How many sides: ");

		northPanel.add(label, new GridBagConstraints(1, 1, 1, 1, 0, 1, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(3, 3, 3, 3), 0, 0));
		JTextField textBox = new JTextField();
		northPanel.add(textBox, new GridBagConstraints(2, 1, 1, 1, 5, 1, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
		northPanel.add(new JPanel(), new GridBagConstraints(3, 1, 1, 1, 5, 1, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));

		JLabel labelRadius = new JLabel("Radius: ");
		northPanel.add(labelRadius, new GridBagConstraints(1, 2, 1, 1, 0, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(3, 3, 3, 3), 0, 0));
		JTextField textBoxRadius = new JTextField();
		northPanel.add(textBoxRadius, new GridBagConstraints(2, 2, 1, 1, 5, 1, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));

		// tworzenie panelu
		PolygonPanel centralPanel = new PolygonPanel(textBox, textBoxRadius);
		panel.add(centralPanel, BorderLayout.CENTER);
		centralPanel.setBackground(Color.WHITE);

		// tworzenie przycisku i ustawianie akcji dla niego, tekstu (wazna jest
		// kolejnosc)
		JButton button = new JButton();
		button.setAction(new DrawPolygonAction(frame, textBox, textBoxRadius, centralPanel));
		button.setText("Draw polygon");
		northPanel.add(button, new GridBagConstraints(1, 3, 3, 1, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));

		// co to robi?: frame.pack();

		// powiadamia interfejsc ze jest gotowy do wyswietlenia
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		// aby unikn�� zakleszcze� tworzenie GUI zawsze zlecamy dla w�tku obs�ugi
		// zdarze�
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				utworzGUI();
			}
		});
	}

	public static class DrawPolygonAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private JFrame frame;
		private JTextField textBox;
		private JPanel panel;
		private JTextField textBoxRadius;

		public DrawPolygonAction(JFrame frame, JTextField textBox, JTextField textBoxRadius, JPanel panel) {
			this.frame = frame;
			this.textBox = textBox;
			this.panel = panel;
			this.textBoxRadius = textBoxRadius;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (Integer.valueOf(textBox.getText()) <= 2) {
					JOptionPane.showMessageDialog(frame, "The smallest polygon has 3 sides!");
					return;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(frame, "This is not an integer: " + textBox.getText());
				return;
			}
			try {
				if (Double.valueOf(textBoxRadius.getText()) <= 0) {
					JOptionPane.showMessageDialog(frame, "Radius must be positive number.");
					return;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(frame, "This is not a number: " + textBoxRadius.getText());
				return;
			}

			panel.repaint();
		}

	}

	private static class PolygonPanel extends JPanel {

		private static final long serialVersionUID = 1L;
		private JTextField textField;
		private JTextField textFieldRadius;

		public PolygonPanel(JTextField textField, JTextField textFieldRadius) {
			this.textField = textField;
			this.textFieldRadius = textFieldRadius;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			int numberOfSides;
			Double radius;
			try {
				numberOfSides = Integer.valueOf(textField.getText());
			} catch (NumberFormatException e) {
				return;
			}
			try {
				radius = Double.valueOf(textFieldRadius.getText());
			} catch (NumberFormatException e) {
				return;
			}

			int centerX = getWidth() / 2;
			int centerY = getHeight() / 2;

			Polygon polygon = new Polygon();

			for (int i = 0; i < numberOfSides; i++) {
				// i, numberOfSides, centerX, centerY, RADIUS
				Double a = 2 * Math.PI / numberOfSides * i;

				int x = (int) (centerX + radius * Math.cos(a));
				int y = (int) (centerY + radius * Math.sin(a));

				polygon.addPoint(x, y);
			}

			g.setColor(Color.MAGENTA);
			g.fillOval((int) (centerX - radius), (int) (centerY - radius), (int) (2 * radius), (int) (2 * radius));
			g.setColor(Color.BLACK);
			g.drawOval((int) (centerX - radius), (int) (centerY - radius), (int) (2 * radius), (int) (2 * radius));
			g.setColor(Color.GREEN);
			g.fillPolygon(polygon);
			g.setColor(Color.black);
			g.drawPolygon(polygon);

		}

	}
}