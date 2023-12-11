package salerGUI;

import static java.util.Arrays.asList;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import login.LoginLayout;

public class SalerMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel headPanel;
	private JLabel lblBrand;
	private JPanel sidePanel;
	private JPanel centerPanel;
	private JPanel registerPanel;
	private JPanel managerPanel;
	private JPanel customerPanel;
	private JPanel reportPanel;
	private JPanel brandPanel;
	private JPanel contactPanel;
	private Saler_ManagerLayout managerLayout;
	private Saler_CustomerLayout customerLayout;
	private JButton btnManager;
	private JButton btnCustomer;
	private JButton btnPayment;
	private JButton btnReport;
	private JButton btnRegister;
	private JPanel paymentPanel;
	private Saler_PaymentLayout paymentLayout;
	private Saler_RegisterLayout registerLayout;
	private Saler_ReportLayout reportLayout;
	private JButton btnLogOut;
	private JButton btnExit;

	public SalerMain() {
		setUndecorated(true);
		setResizable(false);
		setTitle("Green Home");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SalerMain.class.getResource("/icons/jframeIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 62, 80));
		contentPane.setMaximumSize(new Dimension(1280, 900));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		headPanel = new JPanel();
		headPanel.setBackground(new Color(44, 62, 80));
		
		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(44, 62, 80));
		
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 253, 231));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(headPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(sidePanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(centerPanel, GroupLayout.PREFERRED_SIZE, 1360, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(headPanel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(sidePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(centerPanel, GroupLayout.PREFERRED_SIZE, 748, Short.MAX_VALUE))
					.addContainerGap())
		);
		centerPanel.setLayout(new CardLayout(0, 0));
		
		registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 253, 231));
		centerPanel.add(registerPanel, "register_panel");
		registerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		registerLayout = new Saler_RegisterLayout();
		registerPanel.add(registerLayout);
		
		managerPanel = new JPanel();
		managerPanel.setBackground(new Color(255, 253, 231));
		centerPanel.add(managerPanel, "manager_panel");
		managerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		managerLayout = new Saler_ManagerLayout();
		managerPanel.add(managerLayout);
		
		customerPanel = new JPanel();
		customerPanel.setBackground(new Color(255, 253, 231));
		centerPanel.add(customerPanel, "customer_panel");
		customerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		customerLayout = new Saler_CustomerLayout();
		customerPanel.add(customerLayout);

		reportPanel = new JPanel();
		reportPanel.setBackground(new Color(255, 253, 231));
		centerPanel.add(reportPanel, "report_panel");
		reportPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		reportLayout = new Saler_ReportLayout();
		reportPanel.add(reportLayout);
		
		paymentPanel = new JPanel();
		paymentPanel.setBackground(new Color(255, 253, 231));
		centerPanel.add(paymentPanel, "payment_panel");
		paymentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		paymentLayout = new Saler_PaymentLayout();
		paymentPanel.add(paymentLayout);
	
		btnManager = new JButton("Manager");
		btnManager.setAutoscrolls(true);
		btnManager.setIconTextGap(10);
		btnManager.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnManager.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnManager.setDisabledIcon(new ImageIcon(SalerMain.class.getResource("/icons/disabled.png")));
		btnManager.addActionListener(this::btnManagerActionPerformed);
		btnManager.setForeground(new Color(255, 253, 231));
		btnManager.setBackground(new Color(61, 75, 89));
		btnManager.setHorizontalAlignment(SwingConstants.LEFT);
		btnManager.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnManager.setBorder(null);
		btnManager.setIcon(new ImageIcon(SalerMain.class.getResource("/icons/manager.png")));
		
		btnCustomer = new JButton("Customer");
		btnCustomer.setIconTextGap(10);
		btnCustomer.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCustomer.setDisabledIcon(new ImageIcon(SalerMain.class.getResource("/icons/disabled.png")));
		btnCustomer.addActionListener(this::btnCustomerActionPerformed);
		btnCustomer.setForeground(new Color(255, 253, 231));
		btnCustomer.setBackground(new Color(61, 75, 89));
		btnCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomer.setIcon(new ImageIcon(SalerMain.class.getResource("/icons/customer.png")));
		btnCustomer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCustomer.setBorder(null);
		
		btnPayment = new JButton("Payment");
		btnPayment.addActionListener(this::btnPaymentActionPerformed);
		btnPayment.setIconTextGap(10);
		btnPayment.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPayment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPayment.setDisabledIcon(new ImageIcon(SalerMain.class.getResource("/icons/disabled.png")));
		btnPayment.setForeground(new Color(255, 253, 231));
		btnPayment.setBackground(new Color(61, 75, 89));
		btnPayment.setHorizontalAlignment(SwingConstants.LEFT);
		btnPayment.setIcon(new ImageIcon(SalerMain.class.getResource("/icons/payment.png")));
		btnPayment.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnPayment.setBorder(null);
		
		btnReport = new JButton("Report");
		btnReport.addActionListener(this::btnReportActionPerformed);
		btnReport.setIconTextGap(10);
		btnReport.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReport.setDisabledIcon(new ImageIcon(SalerMain.class.getResource("/icons/disabled.png")));
		btnReport.setForeground(new Color(255, 253, 231));
		btnReport.setBackground(new Color(61, 75, 89));
		btnReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnReport.setIcon(new ImageIcon(SalerMain.class.getResource("/icons/report.png")));
		btnReport.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReport.setBorder(null);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(this::btnRegisterActionPerformed);
		btnRegister.setIconTextGap(10);
		btnRegister.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setDisabledIcon(new ImageIcon(SalerMain.class.getResource("/icons/disabled.png")));
		btnRegister.setIcon(new ImageIcon(SalerMain.class.getResource("/icons/register.png")));
		btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegister.setForeground(new Color(255, 253, 231));
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRegister.setBorder(null);
		btnRegister.setBackground(new Color(61, 75, 89));
		GroupLayout gl_sidePanel = new GroupLayout(sidePanel);
		gl_sidePanel.setHorizontalGroup(
			gl_sidePanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnManager, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnCustomer, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnReport, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnRegister, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(btnPayment, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
		);
		gl_sidePanel.setVerticalGroup(
			gl_sidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sidePanel.createSequentialGroup()
					.addComponent(btnManager, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCustomer, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnReport, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPayment, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(455, Short.MAX_VALUE))
		);
		sidePanel.setLayout(gl_sidePanel);
		
		brandPanel = new JPanel();
		brandPanel.setBackground(new Color(44, 62, 80));
		
		contactPanel = new JPanel();
		contactPanel.setBackground(new Color(44, 62, 80));
		
		btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(this::btnLogOutActionPerformed);
		btnLogOut.setIconTextGap(10);
		btnLogOut.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogOut.setForeground(new Color(44, 62, 80));
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(156, 204, 101));
		btnLogOut.setAutoscrolls(true);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this::btnExitActionPerformed);
		btnExit.setIconTextGap(10);
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExit.setForeground(new Color(44, 62, 80));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnExit.setBorder(null);
		btnExit.setBackground(new Color(156, 204, 101));
		btnExit.setAutoscrolls(true);
		GroupLayout gl_headPanel = new GroupLayout(headPanel);
		gl_headPanel.setHorizontalGroup(
			gl_headPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_headPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(brandPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
					.addComponent(contactPanel, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
		);
		gl_headPanel.setVerticalGroup(
			gl_headPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_headPanel.createSequentialGroup()
					.addGroup(gl_headPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_headPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_headPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(brandPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(contactPanel, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
						.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		GroupLayout gl_contactPanel = new GroupLayout(contactPanel);
		gl_contactPanel.setHorizontalGroup(
			gl_contactPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 664, Short.MAX_VALUE)
		);
		gl_contactPanel.setVerticalGroup(
			gl_contactPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 61, Short.MAX_VALUE)
		);
		contactPanel.setLayout(gl_contactPanel);
		
		lblBrand = new JLabel("G R E E N   H O M E");
		lblBrand.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrand.setForeground(new Color(156, 204, 101));
		lblBrand.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_brandPanel = new GroupLayout(brandPanel);
		gl_brandPanel.setHorizontalGroup(
			gl_brandPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_brandPanel.createSequentialGroup()
					.addComponent(lblBrand)
					.addContainerGap(127, Short.MAX_VALUE))
		);
		gl_brandPanel.setVerticalGroup(
			gl_brandPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblBrand, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
		);
		brandPanel.setLayout(gl_brandPanel);
		headPanel.setLayout(gl_headPanel);
		contentPane.setLayout(gl_contentPane);
	}

	protected void btnExitActionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	protected void btnLogOutActionPerformed(ActionEvent e) {
		LoginLayout frame = new LoginLayout();
		frame.setVisible(true);
		this.dispose();
	}
	
	// Hiển thị panel Manager
	protected void btnManagerActionPerformed(ActionEvent e) {
		var cp = (CardLayout)centerPanel.getLayout();
		cp.show(centerPanel, "manager_panel");
		
	    ((JButton)e.getSource()).setForeground(new Color(156, 204, 101));
	    asList(btnCustomer, btnReport, btnRegister, btnPayment)
	            .forEach(button -> button.setForeground(new Color(255, 253, 231)));
	}
	
	// Hiển thị panel Customer
	protected void btnCustomerActionPerformed(ActionEvent e) {
		var cp = (CardLayout)centerPanel.getLayout();
		cp.show(centerPanel, "customer_panel");
		
	    ((JButton)e.getSource()).setForeground(new Color(156, 204, 101));
	    asList(btnManager, btnReport, btnRegister, btnPayment)
	            .forEach(button -> button.setForeground(new Color(255, 253, 231)));
	}
	
	// Hiển thị panel Report
	protected void btnReportActionPerformed(ActionEvent e) {
		var cp = (CardLayout)centerPanel.getLayout();
		cp.show(centerPanel, "report_panel");
		
	    ((JButton)e.getSource()).setForeground(new Color(156, 204, 101));
	    asList(btnManager, btnCustomer, btnRegister, btnPayment)
	            .forEach(button -> button.setForeground(new Color(255, 253, 231)));
	}
	
	// Hiển thị panel Register
	protected void btnRegisterActionPerformed(ActionEvent e) {
		var cp = (CardLayout)centerPanel.getLayout();
		cp.show(centerPanel, "register_panel");
		
	    ((JButton)e.getSource()).setForeground(new Color(156, 204, 101));
	    asList(btnManager, btnCustomer, btnReport, btnPayment)
	            .forEach(button -> button.setForeground(new Color(255, 253, 231)));
	}
	
	// Hiển thị panel Payment
	protected void btnPaymentActionPerformed(ActionEvent e) {
		var cp = (CardLayout)centerPanel.getLayout();
		cp.show(centerPanel, "payment_panel");
		
	    ((JButton)e.getSource()).setForeground(new Color(156, 204, 101));
	    asList(btnManager, btnCustomer, btnReport, btnRegister)
	            .forEach(button -> button.setForeground(new Color(255, 253, 231)));
	}
}
