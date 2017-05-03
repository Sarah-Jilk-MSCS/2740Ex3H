package sjilk2740Ex3H;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RainfallForm extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JLabel totalLabel;
	private JLabel averageLabel;
	private JLabel maxLabel;
	private JLabel minLabel;
	private JTextField inputMonthTextField;
	private String [] strRainfall = {
			"1.2", "2.7", "2.2", "3.1", "2.9", "5.1",
			"3.2", "2.7", "3.6", "1.8", "2.2", "1.7" };
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallForm frame = new RainfallForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RainfallForm() {
		setTitle("Sjilk 2740 Ex3H");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Monthly Rainfall");
		lblNewLabel.setBounds(12, 13, 112, 16);
		contentPane.add(lblNewLabel);
		
		JList monthList = new JList();
		monthList.setBackground(UIManager.getColor("Label.background"));
		monthList.setEnabled(false);
		monthList.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 Jun", "07 Jul", "08 Aug", "09 Sep", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		monthList.setBounds(12, 44, 55, 229);
		contentPane.add(monthList);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_rainfallList_valueChanged(arg0);
			}
		});
		rainfallList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rainfallList.setBounds(79, 42, 46, 228);
		contentPane.add(rainfallList);
		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setLabelFor(lblTotal);
		lblTotal.setBounds(157, 42, 96, 16);
		contentPane.add(lblTotal);
		
		JLabel lblAverage = new JLabel("Average: ");
		lblAverage.setLabelFor(lblAverage);
		lblAverage.setBounds(157, 93, 96, 16);
		contentPane.add(lblAverage);
		
		JLabel lblMaximum = new JLabel("Maximum:");
		lblMaximum.setLabelFor(lblMaximum);
		lblMaximum.setBounds(157, 136, 96, 16);
		contentPane.add(lblMaximum);
		
		JLabel lblMinimum = new JLabel("Minimum:");
		lblMinimum.setLabelFor(lblMinimum);
		lblMinimum.setBounds(157, 186, 96, 16);
		contentPane.add(lblMinimum);
		
		totalLabel = new JLabel("0.0");
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setBounds(274, 38, 99, 24);
		totalLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(totalLabel);
		
		averageLabel = new JLabel("0.0");
		averageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		averageLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		averageLabel.setBounds(274, 93, 99, 24);
		contentPane.add(averageLabel);
		
		maxLabel = new JLabel("0.0");
		maxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		maxLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		maxLabel.setBounds(274, 136, 99, 24);
		contentPane.add(maxLabel);
		
		minLabel = new JLabel("0.0");
		minLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		minLabel.setBounds(274, 186, 99, 24);
		contentPane.add(minLabel);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCalculate_actionPerformed(e);
			}
		});
		btnCalculate.setBounds(274, 262, 97, 25);
		contentPane.add(btnCalculate);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnUpdate_actionPerformed(arg0);
			}
		});
		btnUpdate.setBounds(35, 358, 97, 25);
		contentPane.add(btnUpdate);
		
		inputMonthTextField = new JTextField();
		inputMonthTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputMonthTextField.setText("0.0");
		inputMonthTextField.setBounds(59, 320, 46, 25);
		contentPane.add(inputMonthTextField);
		inputMonthTextField.setColumns(10);
	}
	
	protected void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		int selectedIndex = rainfallList.getSelectedIndex();
		double r = Double.parseDouble(inputMonthTextField.getText());
		strRainfall[selectedIndex] = Double.toString(r);
		rainfallList.repaint();
		
		inputMonthTextField.setText("0.0");
		btnUpdate.setEnabled(false);
		totalLabel.setText("0.0");
		averageLabel.setText("0.0");
		minLabel.setText("0.0");
		maxLabel.setText("0.0");
		
	}
	
	protected void do_btnCalculate_actionPerformed(ActionEvent e) {
		Rainfall rainfallArray = new Rainfall(strRainfall);
		
		DecimalFormat fmt = new DecimalFormat("0.0");
		totalLabel.setText(fmt.format(rainfallArray.getTotal()));
		averageLabel.setText(fmt.format(rainfallArray.getAverage()));
		maxLabel.setText(fmt.format(rainfallArray.getHighest()));
		minLabel.setText(fmt.format(rainfallArray.getLowest()));
	}
	
	protected void do_rainfallList_valueChanged(ListSelectionEvent arg0) {
		btnUpdate.setEnabled(true);
		inputMonthTextField.setText((String) rainfallList.getSelectedValue());
		inputMonthTextField.requestFocus();
		inputMonthTextField.selectAll();
	}
}
