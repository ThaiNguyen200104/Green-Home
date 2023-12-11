package salerGUI;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.ReportDAO;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Saler_ReportLayout extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel headPanel;
	private JPanel headInfo;
	private JLabel lblREP;
	private JPanel centerPanel;
	private JPanel applicationPanel;
	private JPanel detailPanel;
	private JButton btnExportMonth;
	private JLabel lblFooterBrand;
	private JPanel tablePanel;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private JScrollPane scrollPane;
	private JTable reportTable;
	private JTextField txtFromMonth;
	private JPanel function;
	private JTextField txtToMonth;
	private JTextField txtShowProfit;
	private JLabel lblProfit;

	public Saler_ReportLayout() {
		setBounds(new Rectangle(0, 0, 1360, 748));
		setLayout(new BorderLayout(0, 0));
		
		headPanel = new JPanel();
		headPanel.setBackground(new Color(255, 253, 231));
		add(headPanel, BorderLayout.NORTH);
		
		headInfo = new JPanel();
		headInfo.setBackground(new Color(44, 62, 80));
		
		lblREP = new JLabel("R E P O R T");
		lblREP.setForeground(new Color(156, 204, 101));
		lblREP.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_headInfo = new GroupLayout(headInfo);
		gl_headInfo.setHorizontalGroup(
			gl_headInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headInfo.createSequentialGroup()
					.addGap(587)
					.addComponent(lblREP)
					.addContainerGap(587, Short.MAX_VALUE))
		);
		gl_headInfo.setVerticalGroup(
			gl_headInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblREP, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
					.addContainerGap())
		);
		headInfo.setLayout(gl_headInfo);
		GroupLayout gl_headPanel = new GroupLayout(headPanel);
		gl_headPanel.setHorizontalGroup(
			gl_headPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(headInfo, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_headPanel.setVerticalGroup(
			gl_headPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_headPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(headInfo, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
					.addContainerGap())
		);
		headPanel.setLayout(gl_headPanel);
		
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 253, 231));
		add(centerPanel, BorderLayout.CENTER);
		
		applicationPanel = new JPanel();
		applicationPanel.setBackground(new Color(44, 62, 80));
		
		detailPanel = new JPanel();
		detailPanel.setBackground(new Color(44, 62, 80));
		GroupLayout gl_applicationPanel = new GroupLayout(applicationPanel);
		gl_applicationPanel.setHorizontalGroup(
			gl_applicationPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(detailPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
		);
		gl_applicationPanel.setVerticalGroup(
			gl_applicationPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(detailPanel, GroupLayout.PREFERRED_SIZE, 613, Short.MAX_VALUE)
		);
		
		tablePanel = new JPanel();
		
		lblFooterBrand = new JLabel("Copyright © 2023 Green Home. All rights reserved.");
		lblFooterBrand.setHorizontalAlignment(SwingConstants.CENTER);
		lblFooterBrand.setForeground(new Color(156, 204, 101));
		lblFooterBrand.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		
		function = new JPanel();
		function.setBackground(new Color(44, 62, 80));
		GroupLayout gl_detailPanel = new GroupLayout(detailPanel);
		gl_detailPanel.setHorizontalGroup(
			gl_detailPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_detailPanel.createSequentialGroup()
					.addComponent(function, GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFooterBrand, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
				.addComponent(tablePanel, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
		);
		gl_detailPanel.setVerticalGroup(
			gl_detailPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_detailPanel.createSequentialGroup()
					.addComponent(tablePanel, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_detailPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFooterBrand, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(function, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		GridBagLayout gbl_function = new GridBagLayout();
		gbl_function.columnWidths = new int[]{0, 15, 0, 30, 0, 15, 0, 0};
		gbl_function.rowHeights = new int[]{0, 15, 0, 0};
		gbl_function.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_function.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		function.setLayout(gbl_function);
		
		lblStartDate = new JLabel("From month:");
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.anchor = GridBagConstraints.EAST;
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate.gridx = 0;
		gbc_lblStartDate.gridy = 0;
		function.add(lblStartDate, gbc_lblStartDate);
		lblStartDate.setForeground(new Color(255, 255, 255));
		lblStartDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtFromMonth = new JTextField();
		txtFromMonth.setToolTipText("From month");
		GridBagConstraints gbc_txtFromMonth = new GridBagConstraints();
		gbc_txtFromMonth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFromMonth.insets = new Insets(0, 0, 5, 5);
		gbc_txtFromMonth.gridx = 2;
		gbc_txtFromMonth.gridy = 0;
		function.add(txtFromMonth, gbc_txtFromMonth);
		txtFromMonth.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtFromMonth.setColumns(10);
		
		lblProfit = new JLabel("Profit:");
		lblProfit.setForeground(Color.WHITE);
		lblProfit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblProfit = new GridBagConstraints();
		gbc_lblProfit.anchor = GridBagConstraints.EAST;
		gbc_lblProfit.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfit.gridx = 4;
		gbc_lblProfit.gridy = 0;
		function.add(lblProfit, gbc_lblProfit);
		
		txtShowProfit = new JTextField();
		txtShowProfit.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_txtShowProfit = new GridBagConstraints();
		gbc_txtShowProfit.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowProfit.fill = GridBagConstraints.BOTH;
		gbc_txtShowProfit.gridx = 6;
		gbc_txtShowProfit.gridy = 0;
		function.add(txtShowProfit, gbc_txtShowProfit);
		txtShowProfit.setColumns(10);
		
		lblEndDate = new JLabel("To month:");
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.anchor = GridBagConstraints.EAST;
		gbc_lblEndDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblEndDate.gridx = 0;
		gbc_lblEndDate.gridy = 2;
		function.add(lblEndDate, gbc_lblEndDate);
		lblEndDate.setForeground(Color.WHITE);
		lblEndDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtToMonth = new JTextField();
		txtToMonth.setToolTipText("To month");
		txtToMonth.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtToMonth.setColumns(10);
		GridBagConstraints gbc_txtToMonth = new GridBagConstraints();
		gbc_txtToMonth.insets = new Insets(0, 0, 0, 5);
		gbc_txtToMonth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtToMonth.gridx = 2;
		gbc_txtToMonth.gridy = 2;
		function.add(txtToMonth, gbc_txtToMonth);
		
		btnExportMonth = new JButton("Calculate");
		btnExportMonth.addActionListener(this::btnExportMonthActionPerformed);
		GridBagConstraints gbc_btnExportMonth = new GridBagConstraints();
		gbc_btnExportMonth.gridx = 6;
		gbc_btnExportMonth.gridy = 2;
		function.add(btnExportMonth, gbc_btnExportMonth);
		btnExportMonth.setForeground(new Color(44, 62, 80));
		btnExportMonth.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnExportMonth.setBackground(UIManager.getColor("Button.background"));
		tablePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPane = new JScrollPane();
		tablePanel.add(scrollPane);
		
		reportTable = new JTable();
		reportTable.setFillsViewportHeight(true);
		reportTable.setSurrendersFocusOnKeystroke(true);
		reportTable.setRowHeight(30);
		reportTable.setForeground(new Color(44, 62, 80));
		reportTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		reportTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reportTable.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(reportTable);
		detailPanel.setLayout(gl_detailPanel);
		applicationPanel.setLayout(gl_applicationPanel);
		GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
		gl_centerPanel.setHorizontalGroup(
			gl_centerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(applicationPanel, GroupLayout.PREFERRED_SIZE, 1026, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_centerPanel.setVerticalGroup(
			gl_centerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addComponent(applicationPanel, GroupLayout.PREFERRED_SIZE, 613, Short.MAX_VALUE)
					.addContainerGap())
		);
		centerPanel.setLayout(gl_centerPanel);
		
		// -------------------------------------------------------------------------------------
		loadPaymentInfoForReport();
		reportTable.setSurrendersFocusOnKeystroke(true);
		reportTable.setAutoCreateRowSorter(true);
		var centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.LEFT);
		reportTable.setDefaultRenderer(Object.class, centerRenderer);
	}
	
	public void loadPaymentInfoForReport() {
		var LPIFR_model = new DefaultTableModel() {
			@Override
			public Class getColumnClass(int column){
				switch (column) {
				case 0: return String.class;	// payment_no
				case 1: return Integer.class;	// months
				case 2: return Integer.class;	// last_month
				case 3: return Integer.class;	// current_month
				case 4: return Double.class;	// profit
				case 5: return String.class;	// mng_name
				default:return String.class;
				}
			}
		};
		
		LPIFR_model.addColumn("Payment No.");
		LPIFR_model.addColumn("Month");
		LPIFR_model.addColumn("Last Month");
		LPIFR_model.addColumn("Current Month");
		LPIFR_model.addColumn("Profit");
		LPIFR_model.addColumn("Manager Name");
		
		var rp_dao = new ReportDAO();
		
		rp_dao.showReport().forEach(
			rp->LPIFR_model.addRow(new Object[] {
					rp.getRp_payment_no(), rp.getRp_months(), rp.getRp_lastMonth(), rp.getRp_currentMonth(), rp.getRp_totalPrice(), 
					rp.getRp_mngName()
			})
		);
		reportTable.setModel(LPIFR_model);
		
		reportTable.getColumnModel().getColumn(2).setMinWidth(0);
		reportTable.getColumnModel().getColumn(2).setMaxWidth(0);
		reportTable.getColumnModel().getColumn(2).setPreferredWidth(0);
		
		reportTable.getColumnModel().getColumn(3).setMinWidth(0);
		reportTable.getColumnModel().getColumn(3).setMaxWidth(0);
		reportTable.getColumnModel().getColumn(3).setPreferredWidth(0);
	}

	protected void btnExportMonthActionPerformed(ActionEvent e) {
		var gmDAO = new ReportDAO();
		try {
			var totalProfit = gmDAO.getProfit(Integer.parseInt(txtFromMonth.getText()), Integer.parseInt(txtToMonth.getText()));
			var tem = totalProfit.get(0).getTotal_price();
			txtShowProfit.setText(String.format("%02f",tem).toString());
			JOptionPane.showMessageDialog(null, "Here is the profit from " + txtFromMonth.getText() + " to " + txtToMonth.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
	}
}
