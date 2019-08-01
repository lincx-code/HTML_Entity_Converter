/*
 * Author:		Chenxin Lin
 * Description: GUI component class
 * Copyright:	Chenxin Lin @2015
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class GUI extends JFrame {
	public JLabel label1;
	public JLabel label2;
	public JTextArea area1;
	public JTextArea area2;
	public JScrollPane scrollPane1;
	public JScrollPane scrollPane2;
	public JButton convertBtn;
	public JButton spanishBtn;
	public JButton textBtn;
	public JButton clearBtn;
	public JButton aboutBtn;
	public String info;
	public Color grayColor = new Color(225, 225, 225);
	public Font font;

	// Frame container
	private JPanel mainPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel subPanel;

	public GUI() {

		super("HTML Entity Converter - v1.0.5");
		this.setLayout(new FlowLayout());

		// Set font
		this.font = new Font("Calibri", Font.BOLD, 15);

		this.label1 = new JLabel("Enter your messy text copy:");
		this.label1.setFont(this.font);
		this.label2 = new JLabel("Get your new text copy:");
		this.label2.setFont(this.font);

		this.area1 = new JTextArea();
		this.area2 = new JTextArea();
		this.area1.setLineWrap(true);
		this.area2.setLineWrap(true);
		this.area2.setEditable(false);

		this.area2.setBackground(this.grayColor);

		this.scrollPane1 = new JScrollPane(this.area1);
		this.scrollPane2 = new JScrollPane(this.area2);

		this.scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.scrollPane1.setPreferredSize(new Dimension(900, 230));
		this.scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.scrollPane2.setPreferredSize(new Dimension(900, 230));

		this.convertBtn = new JButton("HTML");
		this.convertBtn.setPreferredSize(new Dimension(100, 35));
		ButtonHandler handler = new ButtonHandler();

		this.clearBtn = new JButton("Clear!");
		this.clearBtn.setPreferredSize(new Dimension(100, 35));

		this.aboutBtn = new JButton("About");
		this.aboutBtn.setPreferredSize(new Dimension(100, 35));

		this.spanishBtn = new JButton("Spanish");
		this.spanishBtn.setPreferredSize(new Dimension(100, 35));

		this.textBtn = new JButton("Text");
		this.textBtn.setPreferredSize(new Dimension(100, 35));

		// Set fonts
		this.convertBtn.setFont(this.font);
		this.spanishBtn.setFont(this.font);
		this.clearBtn.setFont(this.font);
		this.textBtn.setFont(this.font);
		this.aboutBtn.setFont(this.font);

		this.convertBtn.addActionListener(handler);
		this.spanishBtn.addActionListener(handler);
		this.clearBtn.addActionListener(handler);
		this.textBtn.addActionListener(handler);
		this.aboutBtn.addActionListener(handler);

		this.mainPanel = new JPanel(new GridLayout(2, 1, 20, 20));
		// mainPanel = new JPanel(new BorderLayout());
		this.panel1 = new JPanel(new BorderLayout(10, 10));
		this.panel2 = new JPanel(new BorderLayout(10, 10));

		JLabel emptyLabel = new JLabel("     ");

		this.subPanel = new JPanel(new GridLayout(1, 5, 20, 5));

		this.subPanel.add(this.clearBtn);
		this.subPanel.add(this.convertBtn);
		this.subPanel.add(this.spanishBtn);
		this.subPanel.add(this.textBtn);
		this.subPanel.add(this.aboutBtn);

		this.panel1.add(this.label1, BorderLayout.NORTH);
		// this.panel1.add(this.area1, BorderLayout.CENTER);
		this.panel1.add(this.scrollPane1, BorderLayout.CENTER);

		this.panel2.add(this.label2, BorderLayout.NORTH);
		// this.panel2.add(this.area2, BorderLayout.CENTER);
		this.panel2.add(this.scrollPane2, BorderLayout.CENTER);

		this.mainPanel.add(this.panel1, BorderLayout.NORTH);
		this.mainPanel.add(this.panel2, BorderLayout.CENTER);

		this.add(this.mainPanel, BorderLayout.CENTER);
		this.add(this.subPanel, BorderLayout.SOUTH);
	}

	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent event) {
			if (event.getSource() == GUI.this.convertBtn) {
				// Test
				System.out.println("Converting copy...");
				// Do the following
				String copyBefore = GUI.this.area1.getText();
				String copyAfter = "";

				Converter convertMe = new Converter();
				try {
					copyAfter = convertMe.htmlEntityConverter(copyBefore);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GUI.this.area2.setEditable(true);
				GUI.this.area2.setBackground(Color.WHITE);
				GUI.this.area2.setText(copyAfter);
				System.out.println("HTML copy converted!");
			} else if (event.getSource() == GUI.this.clearBtn) {
				GUI.this.area1.setText("");
				GUI.this.area2.setText("");
				GUI.this.area2.setEditable(false);
				GUI.this.area2.setBackground(GUI.this.grayColor);
			} else if (event.getSource() == GUI.this.aboutBtn) {
				GUI.this.info = "∩(︶▽︶)∩\nHTML Entity Converter - v1.0.5" + "\n© 2016 Chenxin Lin"
						+ "\nThemes by JTattoo © MH Software-Entwicklung" + "\n\n**************************************************"
						+ "\nUpdate Notes: \n" + "- Added feature to trim leading and trailing spaces\n"
						+ "- Added feature to remove extra spaces between words\n" + "- Added feature to add space between sentences\n"
						+ "- Added fuction to convert copy to plain text\n" + "**************************************************\n"
						+ "Updated on 09/15/2016";
				JOptionPane.showMessageDialog(null, GUI.this.info, "About", JOptionPane.INFORMATION_MESSAGE);
			} else if (event.getSource() == GUI.this.spanishBtn) {
				String copyBefore = GUI.this.area1.getText();
				String copyAfter = "";

				Converter convertSpanish = new Converter();
				try {
					copyAfter = convertSpanish.spanishEntityConverter(copyBefore);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GUI.this.area2.setEditable(true);
				GUI.this.area2.setBackground(Color.WHITE);
				GUI.this.area2.setText(copyAfter);
				System.out.println("Spanish copy converted!");
			} else if (event.getSource() == GUI.this.textBtn) {
				String copyBefore = GUI.this.area1.getText();
				String copyAfter = "";

				Converter convertText = new Converter();
				try {
					copyAfter = convertText.textConverter(copyBefore);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GUI.this.area2.setEditable(true);
				GUI.this.area2.setBackground(Color.WHITE);
				GUI.this.area2.setText(copyAfter);
				System.out.println("Text copy converted!");
			}
		}
	}

}
