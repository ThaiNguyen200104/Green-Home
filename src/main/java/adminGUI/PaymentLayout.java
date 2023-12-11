package adminGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.CustomerDAO;
import dao.PaymentDAO;
import dao.PaymentDetailsDAO;
import dao.PaymentInfoDAO;
import dao.RoomDAO;
import entity.PaymentDetails;
import entity.Payment_no;
import entity.Payments;
import entity.RoomList;

public class PaymentLayout extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel headPanel;
	private JPanel sidePanel;
	private JPanel centerPanel;
	private JPanel headInfo;
	private JLabel lblCategory;
	private JPanel infoPanel;
	private JScrollPane scrollPane;
	private JPanel applicationPanel;
	private JTable showPaymentTable;
	private JButton btnShowCheckOut;
	private JButton btnShowMonthlyCheck;
	private JPanel showPaymentPanel;
	private JPanel centerShowPanel;
	private JLabel lblShowAmount;
	private JLabel lblShowPrice;
	private JLabel lblShowSubTotal;
	private JLabel lblShowElectricity;
	private JTextField txtShow_E_Amount;
	private JTextField txtShow_E_Price;
	private JTextField txtShow_E_Total;
	private JLabel lblShowWater;
	private JTextField txtShow_W_Amount;
	private JTextField txtShow_W_Price;
	private JTextField txtShow_W_Total;
	private JLabel lblShowInternet;
	private JTextField txtShow_I_Total;
	private JLabel lblShowParking;
	private JTextField txtShow_P_Total;
	private JLabel lblShowGarbage;
	private JTextField txtShow_G_Total;
	private JLabel lblShowOthers;
	private JTextField txtShow_O_Price;
	private JTextField txtShow_O_Total;
	private JLabel lblShowTotal;
	private JTextField txtShow_Total;
	private JPanel topShowPanel;
	private JLabel lblShowRoomId;
	private JLabel lblShowCusName;
	private JTextField txtShowName;
	private JLabel lblShowAddress;
	private JTextField txtShowAddress;
	private JLabel lblShowPhoneNum;
	private JTextField txtShowPhoneNum;
	private JLabel lblShowStartDate;
	private JDateChooser startDate;
	private JLabel lblShowEndDate;
	private JDateChooser endDate;
	private JPanel monthlyCheckPanel;
	private JPanel topMCPanel;
	private JLabel lblMCId;
	private JComboBox cbbMCId;
	private JLabel lblMCUsername;
	private JTextField txtMCUsername;
	private JLabel lblMCAddress;
	private JTextField txtMCAddress;
	private JLabel lblMCPhoneNum;
	private JTextField txtMCPhoneNum;
	private JLabel lblMCDateStart;
	private JDateChooser MCStartDate;
	private JPanel checkOutPanel;
	private JPanel topCOPanel;
	private JLabel lblCOId;
	private JComboBox cbbCOId;
	private JLabel lblCOUsername;
	private JTextField txtCOUsername;
	private JLabel lblCOAddress;
	private JTextField txtCOAddress;
	private JLabel lblCOPhoneNum;
	private JTextField txtCOPhoneNum;
	private JLabel lblCODateStart;
	private JDateChooser COStartDate;
	private JLabel lblCODateEnd;
	private JDateChooser COEndDate;
	private JLabel lblShowRoom;
	private JTextField txtShow_R_Price;
	private JTextField txtShow_R_Total;
	private JPanel centerMCPanel;
	private JLabel lblMCAmount;
	private JLabel lblMCPrice;
	private JLabel lblMCSubTotal;
	private JLabel lblMCRoom;
	private JLabel lblMCElectricity;
	private JLabel lblMCWater;
	private JLabel lblMCInternet;
	private JLabel lblMCGarbage;
	private JTextField txtMC_R_Price;
	private JTextField txtMC_R_Total;
	private JTextField txtMC_E_Amount;
	private JTextField txtMC_E_Price;
	private JTextField txtMC_E_Total;
	private JTextField txtMC_W_Amount;
	private JTextField txtMC_W_Price;
	private JTextField txtMC_W_Total;
	private JTextField txtMC_I_Total;
	private JTextField txtMC_P_Total;
	private JTextField txtMC_G_Total;
	private JLabel lblMCOthers;
	private JTextField txtMC_O_Price;
	private JTextField txtMC_O_Total;
	private JLabel lblMCTotal;
	private JButton btnMonthlyCheck;
	private JTextField txtMC_Total;
	private JLabel lblMaintainSecurityNotify;
	private JButton btnCalculate;
	private JCheckBox chckbxShowParking;
	private JLabel lblMaintainSecurityNotify_1;
	private JCheckBox chckbxMCParking;
	private JLabel lbMCParking;
	private JPanel centerCOPanel;
	private JLabel lblCOAmount;
	private JLabel lblCOPrice;
	private JLabel lblCOSubTotal;
	private JLabel lblCORoom;
	private JTextField txtCO_R_Price;
	private JTextField txtCO_R_Total;
	private JLabel lblCOElectricity;
	private JTextField txtCO_E_Amount;
	private JTextField txtCO_E_Price;
	private JTextField txtCO_E_Total;
	private JLabel lblCOWater;
	private JTextField txtCO_W_Amount;
	private JTextField txtCO_W_Price;
	private JTextField txtCO_W_Total;
	private JLabel lblCOOthers;
	private JTextField txtCO_O_Price;
	private JTextField txtCO_O_Total;
	private JLabel lblMaintainSecurityNotify_2;
	private JLabel lbCOParking;
	private JCheckBox chckbxCOParking;
	private JTextField txtCO_P_Total;
	private JLabel lblCOInternet;
	private JTextField txtCO_I_Total;
	private JLabel lblCOGarbage;
	private JTextField txtCO_G_Total;
	private JButton btnCheckOut;
	private JLabel lblCOTotal;
	private JTextField txtCO_Total;
	private JCheckBox chckbxCO_Total;
	private JTextField txtCO_Check_Total_Status;
	private JTextField txtGetRa_no;
	private JButton btnCalculate_1;
	private JButton btnCalculate_2;
	private JTextField txt_MC_GetRANO;
	private JCheckBox chckbxMC_Total;
	private JTextField txtCheck_MC_Total;
	private JTextField txtShowRa_no;
	private JTextField txtShowRoomId;
	private JTextField txtPayment_no;
	private JTextField txtMonths;

	public PaymentLayout() {
		setLayout(new BorderLayout(0, 0));
		
		headPanel = new JPanel();
		headPanel.setBackground(new Color(255, 253, 231));
		add(headPanel, BorderLayout.NORTH);
		
		headInfo = new JPanel();
		headInfo.setBackground(new Color(44, 62, 80));
		
		lblCategory = new JLabel("P A Y M E N T");
		lblCategory.setForeground(new Color(156, 204, 101));
		lblCategory.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_headInfo = new GroupLayout(headInfo);
		gl_headInfo.setHorizontalGroup(
			gl_headInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headInfo.createSequentialGroup()
					.addGap(570)
					.addComponent(lblCategory)
					.addContainerGap(570, Short.MAX_VALUE))
		);
		gl_headInfo.setVerticalGroup(
			gl_headInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCategory, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
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
			gl_headPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_headPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(headInfo, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		headPanel.setLayout(gl_headPanel);
		
		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(255, 253, 231));
		add(sidePanel, BorderLayout.WEST);
		
		infoPanel = new JPanel();
		infoPanel.setBackground(new Color(61, 75, 89));
		
		scrollPane = new JScrollPane();
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel.setHorizontalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
		);
		gl_infoPanel.setVerticalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
		);
		
		showPaymentTable = new JTable();
		showPaymentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPaymentTableMouseClicked(e);
			}
		});
		showPaymentTable.setRowHeight(30);
		showPaymentTable.setFillsViewportHeight(true);
		showPaymentTable.setForeground(new Color(44, 62, 80));
		showPaymentTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showPaymentTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setViewportView(showPaymentTable);
		infoPanel.setLayout(gl_infoPanel);
		
		btnShowCheckOut = new JButton("Show check out");
		btnShowCheckOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowCheckOut.addActionListener(this::btnShowCheckOutActionPerformed);
		btnShowCheckOut.setForeground(new Color(44, 62, 80));
		btnShowCheckOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnShowCheckOut.setBackground(UIManager.getColor("Button.background"));
		
		btnShowMonthlyCheck = new JButton("Monthly Check");
		btnShowMonthlyCheck.addActionListener(this::btnShowMonthlyCheckActionPerformed);
		btnShowMonthlyCheck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowMonthlyCheck.setForeground(new Color(44, 62, 80));
		btnShowMonthlyCheck.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnShowMonthlyCheck.setBackground(UIManager.getColor("Button.background"));
		GroupLayout gl_sidePanel = new GroupLayout(sidePanel);
		gl_sidePanel.setHorizontalGroup(
			gl_sidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sidePanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_sidePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_sidePanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnShowMonthlyCheck, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(btnShowCheckOut)
							.addContainerGap())
						.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)))
		);
		gl_sidePanel.setVerticalGroup(
			gl_sidePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_sidePanel.createSequentialGroup()
					.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
					.addGap(13)
					.addGroup(gl_sidePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnShowMonthlyCheck, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShowCheckOut, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		sidePanel.setLayout(gl_sidePanel);
		
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 253, 231));
		add(centerPanel, BorderLayout.CENTER);
		
		applicationPanel = new JPanel();
		applicationPanel.setBackground(new Color(44, 62, 80));
		GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
		gl_centerPanel.setHorizontalGroup(
			gl_centerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(applicationPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_centerPanel.setVerticalGroup(
			gl_centerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addComponent(applicationPanel, GroupLayout.PREFERRED_SIZE, 613, Short.MAX_VALUE)
					.addContainerGap())
		);
		applicationPanel.setLayout(new CardLayout(0, 0));
		
		showPaymentPanel = new JPanel();
		showPaymentPanel.setBackground(new Color(255, 253, 231));
		applicationPanel.add(showPaymentPanel, "show_payment");
		
		centerShowPanel = new JPanel();
		centerShowPanel.setBackground(new Color(44, 62, 80));
		GridBagLayout gbl_centerShowPanel = new GridBagLayout();
		gbl_centerShowPanel.columnWidths = new int[]{0, 15, 48, 15, 0, 15, 0, 0};
		gbl_centerShowPanel.rowHeights = new int[]{30, 0, 25, 25, 30, 25, 0, 25, 20, 10, 30, 0, 0, 0};
		gbl_centerShowPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_centerShowPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerShowPanel.setLayout(gbl_centerShowPanel);
		
		lblShowAmount = new JLabel("Amount:");
		lblShowAmount.setForeground(Color.WHITE);
		lblShowAmount.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowAmount.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowAmount = new GridBagConstraints();
		gbc_lblShowAmount.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowAmount.gridx = 2;
		gbc_lblShowAmount.gridy = 0;
		centerShowPanel.add(lblShowAmount, gbc_lblShowAmount);
		
		lblShowPrice = new JLabel("Price:");
		lblShowPrice.setForeground(Color.WHITE);
		lblShowPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowPrice.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowPrice = new GridBagConstraints();
		gbc_lblShowPrice.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowPrice.gridx = 4;
		gbc_lblShowPrice.gridy = 0;
		centerShowPanel.add(lblShowPrice, gbc_lblShowPrice);
		
		lblShowSubTotal = new JLabel("Sub Total:");
		lblShowSubTotal.setForeground(Color.WHITE);
		lblShowSubTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowSubTotal.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowSubTotal = new GridBagConstraints();
		gbc_lblShowSubTotal.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowSubTotal.insets = new Insets(0, 0, 5, 0);
		gbc_lblShowSubTotal.gridx = 6;
		gbc_lblShowSubTotal.gridy = 0;
		centerShowPanel.add(lblShowSubTotal, gbc_lblShowSubTotal);
		
		lblShowElectricity = new JLabel("Electrictity:");
		lblShowElectricity.setForeground(Color.WHITE);
		lblShowElectricity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowElectricity.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowElectricity = new GridBagConstraints();
		gbc_lblShowElectricity.anchor = GridBagConstraints.EAST;
		gbc_lblShowElectricity.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowElectricity.gridx = 0;
		gbc_lblShowElectricity.gridy = 1;
		centerShowPanel.add(lblShowElectricity, gbc_lblShowElectricity);
		
		txtShow_E_Amount = new JTextField();
		txtShow_E_Amount.setToolTipText("kW/h");
		txtShow_E_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		txtShow_E_Amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtShow_E_AmountKeyReleased(e);
			}
		});
		txtShow_E_Amount.setForeground(new Color(44, 62, 80));
		txtShow_E_Amount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_E_Amount.setColumns(10);
		GridBagConstraints gbc_txtShow_E_Amount = new GridBagConstraints();
		gbc_txtShow_E_Amount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_E_Amount.insets = new Insets(0, 0, 5, 5);
		gbc_txtShow_E_Amount.gridx = 2;
		gbc_txtShow_E_Amount.gridy = 1;
		centerShowPanel.add(txtShow_E_Amount, gbc_txtShow_E_Amount);
		
		txtShow_E_Price = new JTextField();
		txtShow_E_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_E_Price.setForeground(new Color(44, 62, 80));
		txtShow_E_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_E_Price.setColumns(10);
		GridBagConstraints gbc_txtShow_E_Price = new GridBagConstraints();
		gbc_txtShow_E_Price.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_E_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtShow_E_Price.gridx = 4;
		gbc_txtShow_E_Price.gridy = 1;
		centerShowPanel.add(txtShow_E_Price, gbc_txtShow_E_Price);
		
		txtShow_E_Total = new JTextField();
		txtShow_E_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_E_Total.setForeground(new Color(44, 62, 80));
		txtShow_E_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_E_Total.setColumns(10);
		GridBagConstraints gbc_txtShow_E_Total = new GridBagConstraints();
		gbc_txtShow_E_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_E_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtShow_E_Total.gridx = 6;
		gbc_txtShow_E_Total.gridy = 1;
		centerShowPanel.add(txtShow_E_Total, gbc_txtShow_E_Total);
		
		lblShowWater = new JLabel("Water:");
		lblShowWater.setForeground(Color.WHITE);
		lblShowWater.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowWater.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowWater = new GridBagConstraints();
		gbc_lblShowWater.anchor = GridBagConstraints.EAST;
		gbc_lblShowWater.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowWater.gridx = 0;
		gbc_lblShowWater.gridy = 2;
		centerShowPanel.add(lblShowWater, gbc_lblShowWater);
		
		txtShow_W_Amount = new JTextField();
		txtShow_W_Amount.setToolTipText("cm3");
		txtShow_W_Amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtShow_W_AmountKeyReleased(e);
			}
		});
		txtShow_W_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		txtShow_W_Amount.setForeground(new Color(44, 62, 80));
		txtShow_W_Amount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_W_Amount.setColumns(10);
		GridBagConstraints gbc_txtShow_W_Amount = new GridBagConstraints();
		gbc_txtShow_W_Amount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_W_Amount.insets = new Insets(0, 0, 5, 5);
		gbc_txtShow_W_Amount.gridx = 2;
		gbc_txtShow_W_Amount.gridy = 2;
		centerShowPanel.add(txtShow_W_Amount, gbc_txtShow_W_Amount);
		
		txtShow_W_Price = new JTextField();
		txtShow_W_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_W_Price.setForeground(new Color(44, 62, 80));
		txtShow_W_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_W_Price.setColumns(10);
		GridBagConstraints gbc_txtShow_W_Price = new GridBagConstraints();
		gbc_txtShow_W_Price.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_W_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtShow_W_Price.gridx = 4;
		gbc_txtShow_W_Price.gridy = 2;
		centerShowPanel.add(txtShow_W_Price, gbc_txtShow_W_Price);
		
		txtShow_O_Price = new JTextField();
		txtShow_O_Price.setToolTipText("");
		txtShow_O_Price.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtShow_O_PriceKeyReleased(e);
			}
		});
		
		txtShow_W_Total = new JTextField();
		txtShow_W_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_W_Total.setForeground(new Color(44, 62, 80));
		txtShow_W_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_W_Total.setColumns(10);
		GridBagConstraints gbc_txtShow_W_Total = new GridBagConstraints();
		gbc_txtShow_W_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_W_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtShow_W_Total.gridx = 6;
		gbc_txtShow_W_Total.gridy = 2;
		centerShowPanel.add(txtShow_W_Total, gbc_txtShow_W_Total);
		
		lblShowOthers = new JLabel("Maintain & Security:");
		lblShowOthers.setForeground(Color.WHITE);
		lblShowOthers.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowOthers.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowOthers = new GridBagConstraints();
		gbc_lblShowOthers.anchor = GridBagConstraints.EAST;
		gbc_lblShowOthers.gridwidth = 3;
		gbc_lblShowOthers.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowOthers.gridx = 0;
		gbc_lblShowOthers.gridy = 4;
		centerShowPanel.add(lblShowOthers, gbc_lblShowOthers);
		txtShow_O_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_O_Price.setForeground(new Color(44, 62, 80));
		txtShow_O_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_O_Price.setColumns(10);
		GridBagConstraints gbc_txtShow_O_Price = new GridBagConstraints();
		gbc_txtShow_O_Price.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_O_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtShow_O_Price.gridx = 4;
		gbc_txtShow_O_Price.gridy = 4;
		centerShowPanel.add(txtShow_O_Price, gbc_txtShow_O_Price);
		
		txtShow_O_Total = new JTextField();
		txtShow_O_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_O_Total.setForeground(new Color(44, 62, 80));
		txtShow_O_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_O_Total.setColumns(10);
		GridBagConstraints gbc_txtShow_O_Total = new GridBagConstraints();
		gbc_txtShow_O_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_O_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtShow_O_Total.gridx = 6;
		gbc_txtShow_O_Total.gridy = 4;
		centerShowPanel.add(txtShow_O_Total, gbc_txtShow_O_Total);
		
		topShowPanel = new JPanel();
		topShowPanel.setBackground(new Color(44, 62, 80));
		GridBagLayout gbl_topShowPanel = new GridBagLayout();
		gbl_topShowPanel.columnWidths = new int[]{0, 10, 161, 30, 0, 10, 0, 0};
		gbl_topShowPanel.rowHeights = new int[]{30, 15, 30, 15, 30, 0};
		gbl_topShowPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_topShowPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		topShowPanel.setLayout(gbl_topShowPanel);
		
		lblShowRoomId = new JLabel("Room ID:");
		lblShowRoomId.setForeground(Color.WHITE);
		lblShowRoomId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowRoomId.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowRoomId = new GridBagConstraints();
		gbc_lblShowRoomId.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowRoomId.anchor = GridBagConstraints.EAST;
		gbc_lblShowRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowRoomId.gridx = 0;
		gbc_lblShowRoomId.gridy = 0;
		topShowPanel.add(lblShowRoomId, gbc_lblShowRoomId);
		
		txtShowRoomId = new JTextField();
		txtShowRoomId.setEditable(false);
		txtShowRoomId.setForeground(new Color(44, 62, 80));
		txtShowRoomId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShowRoomId.setColumns(10);
		GridBagConstraints gbc_txtShowRoomId = new GridBagConstraints();
		gbc_txtShowRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowRoomId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowRoomId.gridx = 2;
		gbc_txtShowRoomId.gridy = 0;
		topShowPanel.add(txtShowRoomId, gbc_txtShowRoomId);
		
		lblShowCusName = new JLabel("Customer Name:");
		lblShowCusName.setForeground(Color.WHITE);
		lblShowCusName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowCusName.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowCusName = new GridBagConstraints();
		gbc_lblShowCusName.anchor = GridBagConstraints.EAST;
		gbc_lblShowCusName.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowCusName.gridx = 4;
		gbc_lblShowCusName.gridy = 0;
		topShowPanel.add(lblShowCusName, gbc_lblShowCusName);
		
		txtShowName = new JTextField();
		txtShowName.setEditable(false);
		txtShowName.setForeground(new Color(44, 62, 80));
		txtShowName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShowName.setColumns(10);
		GridBagConstraints gbc_txtShowName = new GridBagConstraints();
		gbc_txtShowName.fill = GridBagConstraints.BOTH;
		gbc_txtShowName.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowName.gridx = 6;
		gbc_txtShowName.gridy = 0;
		topShowPanel.add(txtShowName, gbc_txtShowName);
		
		txtShowRa_no = new JTextField();
		txtShowRa_no.setVisible(false);
		txtShowRa_no.setEditable(false);
		GridBagConstraints gbc_txtShowRa_no = new GridBagConstraints();
		gbc_txtShowRa_no.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowRa_no.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowRa_no.gridx = 2;
		gbc_txtShowRa_no.gridy = 1;
		topShowPanel.add(txtShowRa_no, gbc_txtShowRa_no);
		txtShowRa_no.setColumns(10);
		
		txtPayment_no = new JTextField();
		txtPayment_no.setVisible(false);
		txtPayment_no.setEditable(false);
		txtPayment_no.setColumns(10);
		GridBagConstraints gbc_txtPayment_no = new GridBagConstraints();
		gbc_txtPayment_no.insets = new Insets(0, 0, 5, 0);
		gbc_txtPayment_no.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPayment_no.gridx = 6;
		gbc_txtPayment_no.gridy = 1;
		topShowPanel.add(txtPayment_no, gbc_txtPayment_no);
		
		lblShowAddress = new JLabel("Address:");
		lblShowAddress.setForeground(Color.WHITE);
		lblShowAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowAddress.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowAddress = new GridBagConstraints();
		gbc_lblShowAddress.anchor = GridBagConstraints.EAST;
		gbc_lblShowAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowAddress.gridx = 0;
		gbc_lblShowAddress.gridy = 2;
		topShowPanel.add(lblShowAddress, gbc_lblShowAddress);
		
		txtShowAddress = new JTextField();
		txtShowAddress.setEditable(false);
		txtShowAddress.setForeground(new Color(44, 62, 80));
		txtShowAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShowAddress.setColumns(10);
		GridBagConstraints gbc_txtShowAddress = new GridBagConstraints();
		gbc_txtShowAddress.fill = GridBagConstraints.BOTH;
		gbc_txtShowAddress.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowAddress.gridx = 2;
		gbc_txtShowAddress.gridy = 2;
		topShowPanel.add(txtShowAddress, gbc_txtShowAddress);
		
		lblShowPhoneNum = new JLabel("Phone Number:");
		lblShowPhoneNum.setForeground(Color.WHITE);
		lblShowPhoneNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowPhoneNum.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowPhoneNum = new GridBagConstraints();
		gbc_lblShowPhoneNum.anchor = GridBagConstraints.EAST;
		gbc_lblShowPhoneNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowPhoneNum.gridx = 4;
		gbc_lblShowPhoneNum.gridy = 2;
		topShowPanel.add(lblShowPhoneNum, gbc_lblShowPhoneNum);
		
		txtShowPhoneNum = new JTextField();
		txtShowPhoneNum.setEditable(false);
		txtShowPhoneNum.setForeground(new Color(44, 62, 80));
		txtShowPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShowPhoneNum.setColumns(10);
		GridBagConstraints gbc_txtShowPhoneNum = new GridBagConstraints();
		gbc_txtShowPhoneNum.fill = GridBagConstraints.BOTH;
		gbc_txtShowPhoneNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowPhoneNum.gridx = 6;
		gbc_txtShowPhoneNum.gridy = 2;
		topShowPanel.add(txtShowPhoneNum, gbc_txtShowPhoneNum);
		
		txtMonths = new JTextField();
		txtMonths.setVisible(false);
		txtMonths.setEditable(false);
		txtMonths.setColumns(10);
		GridBagConstraints gbc_txtMonths = new GridBagConstraints();
		gbc_txtMonths.insets = new Insets(0, 0, 5, 5);
		gbc_txtMonths.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMonths.gridx = 2;
		gbc_txtMonths.gridy = 3;
		topShowPanel.add(txtMonths, gbc_txtMonths);
		
		lblShowStartDate = new JLabel("Date Start:");
		lblShowStartDate.setForeground(Color.WHITE);
		lblShowStartDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowStartDate.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowStartDate = new GridBagConstraints();
		gbc_lblShowStartDate.anchor = GridBagConstraints.EAST;
		gbc_lblShowStartDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblShowStartDate.gridx = 0;
		gbc_lblShowStartDate.gridy = 4;
		topShowPanel.add(lblShowStartDate, gbc_lblShowStartDate);
		
		startDate = new JDateChooser();
		startDate.setBounds(new Rectangle(0, 0, 0, 50));
		startDate.setPreferredSize(new Dimension(100, 20));
		startDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		startDate.setForeground(new Color(44, 62, 80));
		startDate.setDateFormatString("yyyy-MM-dd");
		startDate.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_startDate = new GridBagConstraints();
		gbc_startDate.fill = GridBagConstraints.BOTH;
		gbc_startDate.insets = new Insets(0, 0, 0, 5);
		gbc_startDate.gridx = 2;
		gbc_startDate.gridy = 4;
		topShowPanel.add(startDate, gbc_startDate);
		
		lblShowEndDate = new JLabel("Date End:");
		lblShowEndDate.setForeground(Color.WHITE);
		lblShowEndDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowEndDate.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowEndDate = new GridBagConstraints();
		gbc_lblShowEndDate.anchor = GridBagConstraints.EAST;
		gbc_lblShowEndDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblShowEndDate.gridx = 4;
		gbc_lblShowEndDate.gridy = 4;
		topShowPanel.add(lblShowEndDate, gbc_lblShowEndDate);
		
		endDate = new JDateChooser();
		endDate.setBounds(new Rectangle(0, 0, 0, 50));
		endDate.setPreferredSize(new Dimension(100, 20));
		endDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		endDate.setForeground(new Color(44, 62, 80));
		endDate.setDateFormatString("yyyy-MM-dd");
		endDate.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_endDate = new GridBagConstraints();
		gbc_endDate.fill = GridBagConstraints.BOTH;
		gbc_endDate.gridx = 6;
		gbc_endDate.gridy = 4;
		topShowPanel.add(endDate, gbc_endDate);
		GroupLayout gl_showPaymentPanel = new GroupLayout(showPaymentPanel);
		gl_showPaymentPanel.setHorizontalGroup(
			gl_showPaymentPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(topShowPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
				.addComponent(centerShowPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
		);
		gl_showPaymentPanel.setVerticalGroup(
			gl_showPaymentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_showPaymentPanel.createSequentialGroup()
					.addComponent(topShowPanel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerShowPanel, GroupLayout.PREFERRED_SIZE, 442, Short.MAX_VALUE))
		);
		
		lblMaintainSecurityNotify = new JLabel("Security fee is 4.00. If customer didn't call for maintenance, maintain fee = 0");
		lblMaintainSecurityNotify.setForeground(new Color(255, 255, 0));
		lblMaintainSecurityNotify.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblMaintainSecurityNotify = new GridBagConstraints();
		gbc_lblMaintainSecurityNotify.fill = GridBagConstraints.VERTICAL;
		gbc_lblMaintainSecurityNotify.gridwidth = 5;
		gbc_lblMaintainSecurityNotify.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaintainSecurityNotify.gridx = 0;
		gbc_lblMaintainSecurityNotify.gridy = 5;
		centerShowPanel.add(lblMaintainSecurityNotify, gbc_lblMaintainSecurityNotify);
		
		txtShow_R_Price = new JTextField();
		txtShow_R_Price.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtShow_R_PriceKeyReleased(e);
			}
		});
		
		lblShowRoom = new JLabel("Room:");
		lblShowRoom.setForeground(Color.WHITE);
		lblShowRoom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowRoom.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowRoom = new GridBagConstraints();
		gbc_lblShowRoom.anchor = GridBagConstraints.EAST;
		gbc_lblShowRoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowRoom.gridx = 2;
		gbc_lblShowRoom.gridy = 6;
		centerShowPanel.add(lblShowRoom, gbc_lblShowRoom);
		txtShow_R_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_R_Price.setForeground(new Color(44, 62, 80));
		txtShow_R_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_R_Price.setColumns(10);
		GridBagConstraints gbc_txtShow_R_Price = new GridBagConstraints();
		gbc_txtShow_R_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtShow_R_Price.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_R_Price.gridx = 4;
		gbc_txtShow_R_Price.gridy = 6;
		centerShowPanel.add(txtShow_R_Price, gbc_txtShow_R_Price);
		
		txtShow_R_Total = new JTextField();
		txtShow_R_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_R_Total.setForeground(new Color(44, 62, 80));
		txtShow_R_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_R_Total.setColumns(10);
		GridBagConstraints gbc_txtShow_R_Total = new GridBagConstraints();
		gbc_txtShow_R_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtShow_R_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_R_Total.gridx = 6;
		gbc_txtShow_R_Total.gridy = 6;
		centerShowPanel.add(txtShow_R_Total, gbc_txtShow_R_Total);
		
		lblShowParking = new JLabel("Parking:");
		lblShowParking.setForeground(Color.WHITE);
		lblShowParking.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowParking.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowParking = new GridBagConstraints();
		gbc_lblShowParking.anchor = GridBagConstraints.EAST;
		gbc_lblShowParking.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowParking.gridx = 4;
		gbc_lblShowParking.gridy = 7;
		centerShowPanel.add(lblShowParking, gbc_lblShowParking);
		
		chckbxShowParking = new JCheckBox("");
		chckbxShowParking.addChangeListener(this::chckbxShowParkingStateChanged);
		chckbxShowParking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_chckbxShowParking = new GridBagConstraints();
		gbc_chckbxShowParking.fill = GridBagConstraints.BOTH;
		gbc_chckbxShowParking.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxShowParking.gridx = 5;
		gbc_chckbxShowParking.gridy = 7;
		centerShowPanel.add(chckbxShowParking, gbc_chckbxShowParking);
		
		txtShow_P_Total = new JTextField();
		txtShow_P_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_P_Total.setForeground(new Color(44, 62, 80));
		txtShow_P_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_P_Total.setColumns(10);
		GridBagConstraints gbc_txtShow_P_Total = new GridBagConstraints();
		gbc_txtShow_P_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_P_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtShow_P_Total.gridx = 6;
		gbc_txtShow_P_Total.gridy = 7;
		centerShowPanel.add(txtShow_P_Total, gbc_txtShow_P_Total);
		
		lblShowInternet = new JLabel("Internet:");
		lblShowInternet.setForeground(Color.WHITE);
		lblShowInternet.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowInternet.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowInternet = new GridBagConstraints();
		gbc_lblShowInternet.anchor = GridBagConstraints.EAST;
		gbc_lblShowInternet.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowInternet.gridx = 4;
		gbc_lblShowInternet.gridy = 8;
		centerShowPanel.add(lblShowInternet, gbc_lblShowInternet);
		
		txtShow_I_Total = new JTextField();
		txtShow_I_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_I_Total.setForeground(new Color(44, 62, 80));
		txtShow_I_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_I_Total.setColumns(10);
		GridBagConstraints gbc_txtShow_I_Total = new GridBagConstraints();
		gbc_txtShow_I_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_I_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtShow_I_Total.gridx = 6;
		gbc_txtShow_I_Total.gridy = 8;
		centerShowPanel.add(txtShow_I_Total, gbc_txtShow_I_Total);
		
		lblShowGarbage = new JLabel("Garbage:");
		lblShowGarbage.setForeground(Color.WHITE);
		lblShowGarbage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowGarbage.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowGarbage = new GridBagConstraints();
		gbc_lblShowGarbage.anchor = GridBagConstraints.EAST;
		gbc_lblShowGarbage.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowGarbage.gridx = 4;
		gbc_lblShowGarbage.gridy = 9;
		centerShowPanel.add(lblShowGarbage, gbc_lblShowGarbage);
		
		txtShow_G_Total = new JTextField();
		txtShow_G_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_G_Total.setForeground(new Color(44, 62, 80));
		txtShow_G_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShow_G_Total.setColumns(10);
		GridBagConstraints gbc_txtShow_G_Total = new GridBagConstraints();
		gbc_txtShow_G_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShow_G_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtShow_G_Total.gridx = 6;
		gbc_txtShow_G_Total.gridy = 9;
		centerShowPanel.add(txtShow_G_Total, gbc_txtShow_G_Total);
		
		lblShowTotal = new JLabel("Total:");
		lblShowTotal.setForeground(Color.WHITE);
		lblShowTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowTotal.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblShowTotal = new GridBagConstraints();
		gbc_lblShowTotal.anchor = GridBagConstraints.EAST;
		gbc_lblShowTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowTotal.gridx = 4;
		gbc_lblShowTotal.gridy = 11;
		centerShowPanel.add(lblShowTotal, gbc_lblShowTotal);
		
		txtShow_Total = new JTextField();
		txtShow_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtShow_Total.setForeground(Color.RED);
		txtShow_Total.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtShow_Total.setColumns(10);
		GridBagConstraints gbc_txtShow_Total = new GridBagConstraints();
		gbc_txtShow_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtShow_Total.fill = GridBagConstraints.BOTH;
		gbc_txtShow_Total.gridx = 6;
		gbc_txtShow_Total.gridy = 11;
		centerShowPanel.add(txtShow_Total, gbc_txtShow_Total);
		
		btnCalculate = new JButton("Calculate total");
		btnCalculate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalculate.addActionListener(this::btnCalculateActionPerformed);
		btnCalculate.setForeground(new Color(44, 62, 80));
		btnCalculate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnCalculate = new GridBagConstraints();
		gbc_btnCalculate.anchor = GridBagConstraints.WEST;
		gbc_btnCalculate.gridx = 6;
		gbc_btnCalculate.gridy = 12;
		centerShowPanel.add(btnCalculate, gbc_btnCalculate);
		showPaymentPanel.setLayout(gl_showPaymentPanel);
		
		monthlyCheckPanel = new JPanel();
		monthlyCheckPanel.setBackground(new Color(255, 253, 231));
		applicationPanel.add(monthlyCheckPanel, "monthly_check");
		
		topMCPanel = new JPanel();
		topMCPanel.setBackground(new Color(44, 62, 80));
		GridBagLayout gbl_topMCPanel = new GridBagLayout();
		gbl_topMCPanel.columnWidths = new int[]{0, 15, 161, 30, 0, 15, 0, 0};
		gbl_topMCPanel.rowHeights = new int[]{30, 15, 30, 30, 0};
		gbl_topMCPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_topMCPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		topMCPanel.setLayout(gbl_topMCPanel);
		
		lblMCId = new JLabel("Room ID:");
		lblMCId.setForeground(Color.WHITE);
		lblMCId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCId.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCId = new GridBagConstraints();
		gbc_lblMCId.fill = GridBagConstraints.VERTICAL;
		gbc_lblMCId.anchor = GridBagConstraints.EAST;
		gbc_lblMCId.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCId.gridx = 0;
		gbc_lblMCId.gridy = 0;
		topMCPanel.add(lblMCId, gbc_lblMCId);
		
		cbbMCId = new JComboBox();
		cbbMCId.addItemListener(this::cbbMCIdItemStateChanged);
		cbbMCId.setForeground(new Color(44, 62, 80));
		cbbMCId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_cbbMCId = new GridBagConstraints();
		gbc_cbbMCId.fill = GridBagConstraints.BOTH;
		gbc_cbbMCId.insets = new Insets(0, 0, 5, 5);
		gbc_cbbMCId.gridx = 2;
		gbc_cbbMCId.gridy = 0;
		topMCPanel.add(cbbMCId, gbc_cbbMCId);
		
		lblMCUsername = new JLabel("Customer Name:");
		lblMCUsername.setForeground(Color.WHITE);
		lblMCUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCUsername.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCUsername = new GridBagConstraints();
		gbc_lblMCUsername.anchor = GridBagConstraints.EAST;
		gbc_lblMCUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCUsername.gridx = 4;
		gbc_lblMCUsername.gridy = 0;
		topMCPanel.add(lblMCUsername, gbc_lblMCUsername);
		
		txtMCUsername = new JTextField();
		txtMCUsername.setEditable(false);
		txtMCUsername.setForeground(new Color(44, 62, 80));
		txtMCUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMCUsername.setColumns(10);
		GridBagConstraints gbc_txtMCUsername = new GridBagConstraints();
		gbc_txtMCUsername.fill = GridBagConstraints.BOTH;
		gbc_txtMCUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtMCUsername.gridx = 6;
		gbc_txtMCUsername.gridy = 0;
		topMCPanel.add(txtMCUsername, gbc_txtMCUsername);
		
		txt_MC_GetRANO = new JTextField();
		txt_MC_GetRANO.setVisible(false);
		txt_MC_GetRANO.setEnabled(false);
		txt_MC_GetRANO.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_MC_GetRANO.setForeground(new Color(44, 62, 80));
		txt_MC_GetRANO.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_MC_GetRANO.setColumns(10);
		GridBagConstraints gbc_txt_MC_GetRANO = new GridBagConstraints();
		gbc_txt_MC_GetRANO.insets = new Insets(0, 0, 5, 5);
		gbc_txt_MC_GetRANO.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_MC_GetRANO.gridx = 2;
		gbc_txt_MC_GetRANO.gridy = 1;
		topMCPanel.add(txt_MC_GetRANO, gbc_txt_MC_GetRANO);
		
		lblMCAddress = new JLabel("Address:");
		lblMCAddress.setForeground(Color.WHITE);
		lblMCAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCAddress.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCAddress = new GridBagConstraints();
		gbc_lblMCAddress.anchor = GridBagConstraints.EAST;
		gbc_lblMCAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCAddress.gridx = 0;
		gbc_lblMCAddress.gridy = 2;
		topMCPanel.add(lblMCAddress, gbc_lblMCAddress);
		
		txtMCAddress = new JTextField();
		txtMCAddress.setEditable(false);
		txtMCAddress.setForeground(new Color(44, 62, 80));
		txtMCAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMCAddress.setColumns(10);
		GridBagConstraints gbc_txtMCAddress = new GridBagConstraints();
		gbc_txtMCAddress.fill = GridBagConstraints.BOTH;
		gbc_txtMCAddress.insets = new Insets(0, 0, 5, 5);
		gbc_txtMCAddress.gridx = 2;
		gbc_txtMCAddress.gridy = 2;
		topMCPanel.add(txtMCAddress, gbc_txtMCAddress);
		
		lblMCPhoneNum = new JLabel("Phone Number:");
		lblMCPhoneNum.setForeground(Color.WHITE);
		lblMCPhoneNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCPhoneNum.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCPhoneNum = new GridBagConstraints();
		gbc_lblMCPhoneNum.anchor = GridBagConstraints.EAST;
		gbc_lblMCPhoneNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCPhoneNum.gridx = 4;
		gbc_lblMCPhoneNum.gridy = 2;
		topMCPanel.add(lblMCPhoneNum, gbc_lblMCPhoneNum);
		
		txtMCPhoneNum = new JTextField();
		txtMCPhoneNum.setEditable(false);
		txtMCPhoneNum.setForeground(new Color(44, 62, 80));
		txtMCPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMCPhoneNum.setColumns(10);
		GridBagConstraints gbc_txtMCPhoneNum = new GridBagConstraints();
		gbc_txtMCPhoneNum.fill = GridBagConstraints.BOTH;
		gbc_txtMCPhoneNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtMCPhoneNum.gridx = 6;
		gbc_txtMCPhoneNum.gridy = 2;
		topMCPanel.add(txtMCPhoneNum, gbc_txtMCPhoneNum);
		
		lblMCDateStart = new JLabel("Date Start:");
		lblMCDateStart.setForeground(Color.WHITE);
		lblMCDateStart.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCDateStart.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCDateStart = new GridBagConstraints();
		gbc_lblMCDateStart.anchor = GridBagConstraints.EAST;
		gbc_lblMCDateStart.insets = new Insets(0, 0, 0, 5);
		gbc_lblMCDateStart.gridx = 0;
		gbc_lblMCDateStart.gridy = 3;
		topMCPanel.add(lblMCDateStart, gbc_lblMCDateStart);
		
		MCStartDate = new JDateChooser();
		MCStartDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		MCStartDate.setForeground(new Color(44, 62, 80));
		MCStartDate.setDateFormatString("yyyy-MM-dd");
		MCStartDate.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_MCStartDate = new GridBagConstraints();
		gbc_MCStartDate.fill = GridBagConstraints.BOTH;
		gbc_MCStartDate.insets = new Insets(0, 0, 0, 5);
		gbc_MCStartDate.gridx = 2;
		gbc_MCStartDate.gridy = 3;
		topMCPanel.add(MCStartDate, gbc_MCStartDate);
		
		centerMCPanel = new JPanel();
		centerMCPanel.setBackground(new Color(44, 62, 80));
		GroupLayout gl_monthlyCheckPanel = new GroupLayout(monthlyCheckPanel);
		gl_monthlyCheckPanel.setHorizontalGroup(
			gl_monthlyCheckPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(topMCPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
				.addComponent(centerMCPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
		);
		gl_monthlyCheckPanel.setVerticalGroup(
			gl_monthlyCheckPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_monthlyCheckPanel.createSequentialGroup()
					.addComponent(topMCPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerMCPanel, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
		);
		GridBagLayout gbl_centerMCPanel = new GridBagLayout();
		gbl_centerMCPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_centerMCPanel.rowHeights = new int[]{0, 0, 0, 30, 0, 15, 0, 0, 0, 0, 30, 30, 30, 0, 0};
		gbl_centerMCPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_centerMCPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerMCPanel.setLayout(gbl_centerMCPanel);
		
		lblMCAmount = new JLabel("Amount:");
		lblMCAmount.setForeground(Color.WHITE);
		lblMCAmount.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCAmount.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCAmount = new GridBagConstraints();
		gbc_lblMCAmount.fill = GridBagConstraints.VERTICAL;
		gbc_lblMCAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCAmount.gridx = 2;
		gbc_lblMCAmount.gridy = 0;
		centerMCPanel.add(lblMCAmount, gbc_lblMCAmount);
		
		lblMCPrice = new JLabel("Price:");
		lblMCPrice.setForeground(Color.WHITE);
		lblMCPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCPrice.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCPrice = new GridBagConstraints();
		gbc_lblMCPrice.fill = GridBagConstraints.VERTICAL;
		gbc_lblMCPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCPrice.gridx = 4;
		gbc_lblMCPrice.gridy = 0;
		centerMCPanel.add(lblMCPrice, gbc_lblMCPrice);
		
		lblMCSubTotal = new JLabel("Sub Total:");
		lblMCSubTotal.setForeground(Color.WHITE);
		lblMCSubTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCSubTotal.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCSubTotal = new GridBagConstraints();
		gbc_lblMCSubTotal.fill = GridBagConstraints.VERTICAL;
		gbc_lblMCSubTotal.insets = new Insets(0, 0, 5, 0);
		gbc_lblMCSubTotal.gridx = 6;
		gbc_lblMCSubTotal.gridy = 0;
		centerMCPanel.add(lblMCSubTotal, gbc_lblMCSubTotal);
		
		txtMC_E_Amount = new JTextField();
		txtMC_E_Amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtMC_E_AmountKeyReleased(e);
			}
		});
		
		lblMCElectricity = new JLabel("Electricity:");
		lblMCElectricity.setForeground(Color.WHITE);
		lblMCElectricity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCElectricity.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCElectricity = new GridBagConstraints();
		gbc_lblMCElectricity.fill = GridBagConstraints.VERTICAL;
		gbc_lblMCElectricity.anchor = GridBagConstraints.EAST;
		gbc_lblMCElectricity.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCElectricity.gridx = 0;
		gbc_lblMCElectricity.gridy = 1;
		centerMCPanel.add(lblMCElectricity, gbc_lblMCElectricity);
		txtMC_E_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		txtMC_E_Amount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMC_E_Amount.setColumns(10);
		GridBagConstraints gbc_txtMC_E_Amount = new GridBagConstraints();
		gbc_txtMC_E_Amount.insets = new Insets(0, 0, 5, 5);
		gbc_txtMC_E_Amount.fill = GridBagConstraints.BOTH;
		gbc_txtMC_E_Amount.gridx = 2;
		gbc_txtMC_E_Amount.gridy = 1;
		centerMCPanel.add(txtMC_E_Amount, gbc_txtMC_E_Amount);
		
		txtMC_W_Amount = new JTextField();
		txtMC_W_Amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtMC_W_AmountKeyReleased(e);
			}
		});
		
		txtMC_E_Price = new JTextField();
		txtMC_E_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_E_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMC_E_Price.setColumns(10);
		GridBagConstraints gbc_txtMC_E_Price = new GridBagConstraints();
		gbc_txtMC_E_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtMC_E_Price.fill = GridBagConstraints.BOTH;
		gbc_txtMC_E_Price.gridx = 4;
		gbc_txtMC_E_Price.gridy = 1;
		centerMCPanel.add(txtMC_E_Price, gbc_txtMC_E_Price);
		
		txtMC_E_Total = new JTextField();
		txtMC_E_Total.setEditable(false);
		txtMC_E_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_E_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMC_E_Total.setColumns(10);
		GridBagConstraints gbc_txtMC_E_Total = new GridBagConstraints();
		gbc_txtMC_E_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtMC_E_Total.fill = GridBagConstraints.BOTH;
		gbc_txtMC_E_Total.gridx = 6;
		gbc_txtMC_E_Total.gridy = 1;
		centerMCPanel.add(txtMC_E_Total, gbc_txtMC_E_Total);
		
		lblMCWater = new JLabel("Water:");
		lblMCWater.setForeground(Color.WHITE);
		lblMCWater.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCWater.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCWater = new GridBagConstraints();
		gbc_lblMCWater.fill = GridBagConstraints.VERTICAL;
		gbc_lblMCWater.anchor = GridBagConstraints.EAST;
		gbc_lblMCWater.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCWater.gridx = 0;
		gbc_lblMCWater.gridy = 2;
		centerMCPanel.add(lblMCWater, gbc_lblMCWater);
		txtMC_W_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		txtMC_W_Amount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMC_W_Amount.setColumns(10);
		GridBagConstraints gbc_txtMC_W_Amount = new GridBagConstraints();
		gbc_txtMC_W_Amount.insets = new Insets(0, 0, 5, 5);
		gbc_txtMC_W_Amount.fill = GridBagConstraints.BOTH;
		gbc_txtMC_W_Amount.gridx = 2;
		gbc_txtMC_W_Amount.gridy = 2;
		centerMCPanel.add(txtMC_W_Amount, gbc_txtMC_W_Amount);
		
		txtMC_W_Price = new JTextField();
		txtMC_W_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_W_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMC_W_Price.setColumns(10);
		GridBagConstraints gbc_txtMC_W_Price = new GridBagConstraints();
		gbc_txtMC_W_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtMC_W_Price.fill = GridBagConstraints.BOTH;
		gbc_txtMC_W_Price.gridx = 4;
		gbc_txtMC_W_Price.gridy = 2;
		centerMCPanel.add(txtMC_W_Price, gbc_txtMC_W_Price);
		
		txtMC_W_Total = new JTextField();
		txtMC_W_Total.setEditable(false);
		txtMC_W_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_W_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMC_W_Total.setColumns(10);
		GridBagConstraints gbc_txtMC_W_Total = new GridBagConstraints();
		gbc_txtMC_W_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtMC_W_Total.fill = GridBagConstraints.BOTH;
		gbc_txtMC_W_Total.gridx = 6;
		gbc_txtMC_W_Total.gridy = 2;
		centerMCPanel.add(txtMC_W_Total, gbc_txtMC_W_Total);
		
		lblMCOthers = new JLabel("Maintain & Security:");
		lblMCOthers.setForeground(Color.WHITE);
		lblMCOthers.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCOthers.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCOthers = new GridBagConstraints();
		gbc_lblMCOthers.anchor = GridBagConstraints.EAST;
		gbc_lblMCOthers.fill = GridBagConstraints.VERTICAL;
		gbc_lblMCOthers.gridwidth = 3;
		gbc_lblMCOthers.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCOthers.gridx = 0;
		gbc_lblMCOthers.gridy = 4;
		centerMCPanel.add(lblMCOthers, gbc_lblMCOthers);
		
		txtMC_O_Price = new JTextField();
		txtMC_O_Price.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtMC_O_PriceKeyReleased(e);
			}
		});
		txtMC_O_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_O_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMC_O_Price.setColumns(10);
		GridBagConstraints gbc_txtMC_O_Price = new GridBagConstraints();
		gbc_txtMC_O_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtMC_O_Price.fill = GridBagConstraints.BOTH;
		gbc_txtMC_O_Price.gridx = 4;
		gbc_txtMC_O_Price.gridy = 4;
		centerMCPanel.add(txtMC_O_Price, gbc_txtMC_O_Price);
		
		txtMC_O_Total = new JTextField();
		txtMC_O_Total.setEditable(false);
		txtMC_O_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_O_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMC_O_Total.setColumns(10);
		GridBagConstraints gbc_txtMC_O_Total = new GridBagConstraints();
		gbc_txtMC_O_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtMC_O_Total.fill = GridBagConstraints.BOTH;
		gbc_txtMC_O_Total.gridx = 6;
		gbc_txtMC_O_Total.gridy = 4;
		centerMCPanel.add(txtMC_O_Total, gbc_txtMC_O_Total);
		
		lblMaintainSecurityNotify_1 = new JLabel("Security fee is 4.00. If customer didn't call for maintenance, maintain fee = 0");
		lblMaintainSecurityNotify_1.setForeground(Color.YELLOW);
		lblMaintainSecurityNotify_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblMaintainSecurityNotify_1 = new GridBagConstraints();
		gbc_lblMaintainSecurityNotify_1.gridwidth = 5;
		gbc_lblMaintainSecurityNotify_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaintainSecurityNotify_1.gridx = 0;
		gbc_lblMaintainSecurityNotify_1.gridy = 5;
		centerMCPanel.add(lblMaintainSecurityNotify_1, gbc_lblMaintainSecurityNotify_1);
		
		lblMCRoom = new JLabel("Room:");
		lblMCRoom.setForeground(Color.WHITE);
		lblMCRoom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCRoom.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCRoom = new GridBagConstraints();
		gbc_lblMCRoom.fill = GridBagConstraints.VERTICAL;
		gbc_lblMCRoom.anchor = GridBagConstraints.EAST;
		gbc_lblMCRoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCRoom.gridx = 2;
		gbc_lblMCRoom.gridy = 6;
		centerMCPanel.add(lblMCRoom, gbc_lblMCRoom);
		
		txtMC_R_Price = new JTextField();
		txtMC_R_Price.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtMC_R_PriceKeyReleased(e);
			}
		});
		txtMC_R_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_R_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_txtMC_R_Price = new GridBagConstraints();
		gbc_txtMC_R_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtMC_R_Price.fill = GridBagConstraints.BOTH;
		gbc_txtMC_R_Price.gridx = 4;
		gbc_txtMC_R_Price.gridy = 6;
		centerMCPanel.add(txtMC_R_Price, gbc_txtMC_R_Price);
		txtMC_R_Price.setColumns(10);
		
		txtMC_R_Total = new JTextField();
		txtMC_R_Total.setEditable(false);
		txtMC_R_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_R_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_txtMC_R_Total = new GridBagConstraints();
		gbc_txtMC_R_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtMC_R_Total.fill = GridBagConstraints.BOTH;
		gbc_txtMC_R_Total.gridx = 6;
		gbc_txtMC_R_Total.gridy = 6;
		centerMCPanel.add(txtMC_R_Total, gbc_txtMC_R_Total);
		txtMC_R_Total.setColumns(10);
		
		lbMCParking = new JLabel("Parking:");
		lbMCParking.setForeground(Color.WHITE);
		lbMCParking.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbMCParking.setBackground(Color.WHITE);
		GridBagConstraints gbc_lbMCParking = new GridBagConstraints();
		gbc_lbMCParking.fill = GridBagConstraints.VERTICAL;
		gbc_lbMCParking.anchor = GridBagConstraints.EAST;
		gbc_lbMCParking.insets = new Insets(0, 0, 5, 5);
		gbc_lbMCParking.gridx = 4;
		gbc_lbMCParking.gridy = 7;
		centerMCPanel.add(lbMCParking, gbc_lbMCParking);
		
		chckbxMCParking = new JCheckBox("");
		chckbxMCParking.addItemListener(this::chckbxMCParkingItemStateChanged);
		chckbxMCParking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_chckbxMCParking = new GridBagConstraints();
		gbc_chckbxMCParking.fill = GridBagConstraints.BOTH;
		gbc_chckbxMCParking.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMCParking.gridx = 5;
		gbc_chckbxMCParking.gridy = 7;
		centerMCPanel.add(chckbxMCParking, gbc_chckbxMCParking);
		
		txtMC_P_Total = new JTextField();
		txtMC_P_Total.setEditable(false);
		txtMC_P_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_P_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMC_P_Total.setColumns(10);
		GridBagConstraints gbc_txtMC_P_Total = new GridBagConstraints();
		gbc_txtMC_P_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtMC_P_Total.fill = GridBagConstraints.BOTH;
		gbc_txtMC_P_Total.gridx = 6;
		gbc_txtMC_P_Total.gridy = 7;
		centerMCPanel.add(txtMC_P_Total, gbc_txtMC_P_Total);
		
		lblMCInternet = new JLabel("Internet:");
		lblMCInternet.setForeground(Color.WHITE);
		lblMCInternet.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCInternet.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCInternet = new GridBagConstraints();
		gbc_lblMCInternet.fill = GridBagConstraints.VERTICAL;
		gbc_lblMCInternet.anchor = GridBagConstraints.EAST;
		gbc_lblMCInternet.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCInternet.gridx = 4;
		gbc_lblMCInternet.gridy = 8;
		centerMCPanel.add(lblMCInternet, gbc_lblMCInternet);
		
		txtMC_I_Total = new JTextField();
		txtMC_I_Total.setEditable(false);
		txtMC_I_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_I_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMC_I_Total.setColumns(10);
		GridBagConstraints gbc_txtMC_I_Total = new GridBagConstraints();
		gbc_txtMC_I_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtMC_I_Total.fill = GridBagConstraints.BOTH;
		gbc_txtMC_I_Total.gridx = 6;
		gbc_txtMC_I_Total.gridy = 8;
		centerMCPanel.add(txtMC_I_Total, gbc_txtMC_I_Total);
		
		lblMCGarbage = new JLabel("Garbage:");
		lblMCGarbage.setForeground(Color.WHITE);
		lblMCGarbage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCGarbage.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCGarbage = new GridBagConstraints();
		gbc_lblMCGarbage.fill = GridBagConstraints.VERTICAL;
		gbc_lblMCGarbage.anchor = GridBagConstraints.EAST;
		gbc_lblMCGarbage.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCGarbage.gridx = 4;
		gbc_lblMCGarbage.gridy = 9;
		centerMCPanel.add(lblMCGarbage, gbc_lblMCGarbage);
		
		txtMC_G_Total = new JTextField();
		txtMC_G_Total.setEditable(false);
		txtMC_G_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_G_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMC_G_Total.setColumns(10);
		GridBagConstraints gbc_txtMC_G_Total = new GridBagConstraints();
		gbc_txtMC_G_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtMC_G_Total.fill = GridBagConstraints.BOTH;
		gbc_txtMC_G_Total.gridx = 6;
		gbc_txtMC_G_Total.gridy = 9;
		centerMCPanel.add(txtMC_G_Total, gbc_txtMC_G_Total);
		
		lblMCTotal = new JLabel("Total:");
		lblMCTotal.setForeground(Color.WHITE);
		lblMCTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMCTotal.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMCTotal = new GridBagConstraints();
		gbc_lblMCTotal.anchor = GridBagConstraints.EAST;
		gbc_lblMCTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCTotal.gridx = 0;
		gbc_lblMCTotal.gridy = 11;
		centerMCPanel.add(lblMCTotal, gbc_lblMCTotal);
		
		txtMC_Total = new JTextField();
		txtMC_Total.setEditable(false);
		txtMC_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC_Total.setForeground(Color.RED);
		txtMC_Total.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtMC_Total.setColumns(10);
		GridBagConstraints gbc_txtMC_Total = new GridBagConstraints();
		gbc_txtMC_Total.gridwidth = 3;
		gbc_txtMC_Total.insets = new Insets(0, 0, 5, 5);
		gbc_txtMC_Total.fill = GridBagConstraints.BOTH;
		gbc_txtMC_Total.gridx = 2;
		gbc_txtMC_Total.gridy = 11;
		centerMCPanel.add(txtMC_Total, gbc_txtMC_Total);
		
		chckbxMC_Total = new JCheckBox("");
		chckbxMC_Total.addItemListener(this::chckbxMC_TotalItemStateChanged);
		GridBagConstraints gbc_chckbxMC_Total = new GridBagConstraints();
		gbc_chckbxMC_Total.fill = GridBagConstraints.VERTICAL;
		gbc_chckbxMC_Total.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMC_Total.gridx = 5;
		gbc_chckbxMC_Total.gridy = 11;
		centerMCPanel.add(chckbxMC_Total, gbc_chckbxMC_Total);
		
		txtCheck_MC_Total = new JTextField();
		txtCheck_MC_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCheck_MC_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCheck_MC_Total.setEditable(false);
		txtCheck_MC_Total.setColumns(10);
		GridBagConstraints gbc_txtCheck_MC_Total = new GridBagConstraints();
		gbc_txtCheck_MC_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtCheck_MC_Total.fill = GridBagConstraints.BOTH;
		gbc_txtCheck_MC_Total.gridx = 6;
		gbc_txtCheck_MC_Total.gridy = 11;
		centerMCPanel.add(txtCheck_MC_Total, gbc_txtCheck_MC_Total);
		
		btnMonthlyCheck = new JButton("Monthly Check");
		btnMonthlyCheck.addActionListener(this::btnMonthlyCheckActionPerformed);
		
		btnCalculate_2 = new JButton("Calculate total");
		btnCalculate_2.addActionListener(this::btnCalculate_2ActionPerformed);
		btnCalculate_2.setForeground(new Color(44, 62, 80));
		btnCalculate_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnCalculate_2 = new GridBagConstraints();
		gbc_btnCalculate_2.anchor = GridBagConstraints.EAST;
		gbc_btnCalculate_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnCalculate_2.gridx = 4;
		gbc_btnCalculate_2.gridy = 13;
		centerMCPanel.add(btnCalculate_2, gbc_btnCalculate_2);
		btnMonthlyCheck.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnMonthlyCheck = new GridBagConstraints();
		gbc_btnMonthlyCheck.gridx = 6;
		gbc_btnMonthlyCheck.gridy = 13;
		centerMCPanel.add(btnMonthlyCheck, gbc_btnMonthlyCheck);
		monthlyCheckPanel.setLayout(gl_monthlyCheckPanel);
		
		checkOutPanel = new JPanel();
		checkOutPanel.setBackground(new Color(255, 253, 231));
		applicationPanel.add(checkOutPanel, "check_out");
		
		topCOPanel = new JPanel();
		topCOPanel.setBackground(new Color(44, 62, 80));
		GridBagLayout gbl_topCOPanel = new GridBagLayout();
		gbl_topCOPanel.columnWidths = new int[]{0, 15, 161, 30, 0, 15, 0, 0};
		gbl_topCOPanel.rowHeights = new int[]{30, 10, 30, 30, 0};
		gbl_topCOPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_topCOPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		topCOPanel.setLayout(gbl_topCOPanel);
		
		lblCOId = new JLabel("Room ID:");
		lblCOId.setForeground(Color.WHITE);
		lblCOId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOId.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOId = new GridBagConstraints();
		gbc_lblCOId.fill = GridBagConstraints.VERTICAL;
		gbc_lblCOId.anchor = GridBagConstraints.EAST;
		gbc_lblCOId.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOId.gridx = 0;
		gbc_lblCOId.gridy = 0;
		topCOPanel.add(lblCOId, gbc_lblCOId);
		
		cbbCOId = new JComboBox();
		cbbCOId.addItemListener(this::cbbCOIdItemStateChanged);
		cbbCOId.setForeground(new Color(44, 62, 80));
		cbbCOId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_cbbCOId = new GridBagConstraints();
		gbc_cbbCOId.fill = GridBagConstraints.BOTH;
		gbc_cbbCOId.insets = new Insets(0, 0, 5, 5);
		gbc_cbbCOId.gridx = 2;
		gbc_cbbCOId.gridy = 0;
		topCOPanel.add(cbbCOId, gbc_cbbCOId);
		
		lblCOUsername = new JLabel("Customer Name:");
		lblCOUsername.setForeground(Color.WHITE);
		lblCOUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOUsername.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOUsername = new GridBagConstraints();
		gbc_lblCOUsername.anchor = GridBagConstraints.EAST;
		gbc_lblCOUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOUsername.gridx = 4;
		gbc_lblCOUsername.gridy = 0;
		topCOPanel.add(lblCOUsername, gbc_lblCOUsername);
		
		txtCOUsername = new JTextField();
		txtCOUsername.setForeground(new Color(44, 62, 80));
		txtCOUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCOUsername.setColumns(10);
		GridBagConstraints gbc_txtCOUsername = new GridBagConstraints();
		gbc_txtCOUsername.fill = GridBagConstraints.BOTH;
		gbc_txtCOUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtCOUsername.gridx = 6;
		gbc_txtCOUsername.gridy = 0;
		topCOPanel.add(txtCOUsername, gbc_txtCOUsername);
		
		txtGetRa_no = new JTextField();
		txtGetRa_no.setVisible(false);
		txtGetRa_no.setHorizontalAlignment(SwingConstants.TRAILING);
		txtGetRa_no.setForeground(new Color(44, 62, 80));
		txtGetRa_no.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtGetRa_no.setColumns(10);
		GridBagConstraints gbc_txtGetRa_no = new GridBagConstraints();
		gbc_txtGetRa_no.insets = new Insets(0, 0, 5, 5);
		gbc_txtGetRa_no.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGetRa_no.gridx = 2;
		gbc_txtGetRa_no.gridy = 1;
		topCOPanel.add(txtGetRa_no, gbc_txtGetRa_no);
		
		lblCOAddress = new JLabel("Address:");
		lblCOAddress.setForeground(Color.WHITE);
		lblCOAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOAddress.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOAddress = new GridBagConstraints();
		gbc_lblCOAddress.anchor = GridBagConstraints.EAST;
		gbc_lblCOAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOAddress.gridx = 0;
		gbc_lblCOAddress.gridy = 2;
		topCOPanel.add(lblCOAddress, gbc_lblCOAddress);
		
		txtCOAddress = new JTextField();
		txtCOAddress.setForeground(new Color(44, 62, 80));
		txtCOAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCOAddress.setColumns(10);
		GridBagConstraints gbc_txtCOAddress = new GridBagConstraints();
		gbc_txtCOAddress.fill = GridBagConstraints.BOTH;
		gbc_txtCOAddress.insets = new Insets(0, 0, 5, 5);
		gbc_txtCOAddress.gridx = 2;
		gbc_txtCOAddress.gridy = 2;
		topCOPanel.add(txtCOAddress, gbc_txtCOAddress);
		
		lblCOPhoneNum = new JLabel("Phone Number:");
		lblCOPhoneNum.setForeground(Color.WHITE);
		lblCOPhoneNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOPhoneNum.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOPhoneNum = new GridBagConstraints();
		gbc_lblCOPhoneNum.anchor = GridBagConstraints.EAST;
		gbc_lblCOPhoneNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOPhoneNum.gridx = 4;
		gbc_lblCOPhoneNum.gridy = 2;
		topCOPanel.add(lblCOPhoneNum, gbc_lblCOPhoneNum);
		
		txtCOPhoneNum = new JTextField();
		txtCOPhoneNum.setForeground(new Color(44, 62, 80));
		txtCOPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCOPhoneNum.setColumns(10);
		GridBagConstraints gbc_txtCOPhoneNum = new GridBagConstraints();
		gbc_txtCOPhoneNum.fill = GridBagConstraints.BOTH;
		gbc_txtCOPhoneNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtCOPhoneNum.gridx = 6;
		gbc_txtCOPhoneNum.gridy = 2;
		topCOPanel.add(txtCOPhoneNum, gbc_txtCOPhoneNum);
		
		lblCODateStart = new JLabel("Date Start:");
		lblCODateStart.setForeground(Color.WHITE);
		lblCODateStart.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCODateStart.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCODateStart = new GridBagConstraints();
		gbc_lblCODateStart.anchor = GridBagConstraints.EAST;
		gbc_lblCODateStart.insets = new Insets(0, 0, 0, 5);
		gbc_lblCODateStart.gridx = 0;
		gbc_lblCODateStart.gridy = 3;
		topCOPanel.add(lblCODateStart, gbc_lblCODateStart);
		
		COStartDate = new JDateChooser();
		COStartDate.setForeground(new Color(44, 62, 80));
		COStartDate.setDateFormatString("yyyy-MM-dd");
		COStartDate.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_COStartDate = new GridBagConstraints();
		gbc_COStartDate.fill = GridBagConstraints.BOTH;
		gbc_COStartDate.insets = new Insets(0, 0, 0, 5);
		gbc_COStartDate.gridx = 2;
		gbc_COStartDate.gridy = 3;
		topCOPanel.add(COStartDate, gbc_COStartDate);
		
		lblCODateEnd = new JLabel("Date End:");
		lblCODateEnd.setForeground(Color.WHITE);
		lblCODateEnd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCODateEnd.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCODateEnd = new GridBagConstraints();
		gbc_lblCODateEnd.anchor = GridBagConstraints.EAST;
		gbc_lblCODateEnd.insets = new Insets(0, 0, 0, 5);
		gbc_lblCODateEnd.gridx = 4;
		gbc_lblCODateEnd.gridy = 3;
		topCOPanel.add(lblCODateEnd, gbc_lblCODateEnd);
		
		COEndDate = new JDateChooser();
		COEndDate.setForeground(new Color(44, 62, 80));
		COEndDate.setDateFormatString("yyyy-MM-dd");
		COEndDate.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_COEndDate = new GridBagConstraints();
		gbc_COEndDate.fill = GridBagConstraints.BOTH;
		gbc_COEndDate.gridx = 6;
		gbc_COEndDate.gridy = 3;
		topCOPanel.add(COEndDate, gbc_COEndDate);
		
		centerCOPanel = new JPanel();
		centerCOPanel.setBackground(new Color(44, 62, 80));
		GridBagLayout gbl_centerCOPanel = new GridBagLayout();
		gbl_centerCOPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_centerCOPanel.rowHeights = new int[]{0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 30, 0, 30, 0, 0};
		gbl_centerCOPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0};
		gbl_centerCOPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerCOPanel.setLayout(gbl_centerCOPanel);
		
		lblCOAmount = new JLabel("Amount:");
		lblCOAmount.setForeground(Color.WHITE);
		lblCOAmount.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOAmount.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOAmount = new GridBagConstraints();
		gbc_lblCOAmount.fill = GridBagConstraints.VERTICAL;
		gbc_lblCOAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOAmount.gridx = 2;
		gbc_lblCOAmount.gridy = 0;
		centerCOPanel.add(lblCOAmount, gbc_lblCOAmount);
		
		lblCOPrice = new JLabel("Price:");
		lblCOPrice.setForeground(Color.WHITE);
		lblCOPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOPrice.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOPrice = new GridBagConstraints();
		gbc_lblCOPrice.fill = GridBagConstraints.VERTICAL;
		gbc_lblCOPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOPrice.gridx = 4;
		gbc_lblCOPrice.gridy = 0;
		centerCOPanel.add(lblCOPrice, gbc_lblCOPrice);
		
		lblCOSubTotal = new JLabel("Sub Total:");
		lblCOSubTotal.setForeground(Color.WHITE);
		lblCOSubTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOSubTotal.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOSubTotal = new GridBagConstraints();
		gbc_lblCOSubTotal.fill = GridBagConstraints.VERTICAL;
		gbc_lblCOSubTotal.insets = new Insets(0, 0, 5, 0);
		gbc_lblCOSubTotal.gridx = 6;
		gbc_lblCOSubTotal.gridy = 0;
		centerCOPanel.add(lblCOSubTotal, gbc_lblCOSubTotal);
		
		lblCOElectricity = new JLabel("Electricity:");
		lblCOElectricity.setForeground(Color.WHITE);
		lblCOElectricity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOElectricity.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOElectricity = new GridBagConstraints();
		gbc_lblCOElectricity.fill = GridBagConstraints.VERTICAL;
		gbc_lblCOElectricity.anchor = GridBagConstraints.EAST;
		gbc_lblCOElectricity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOElectricity.gridx = 0;
		gbc_lblCOElectricity.gridy = 1;
		centerCOPanel.add(lblCOElectricity, gbc_lblCOElectricity);
		
		txtCO_E_Amount = new JTextField();
		txtCO_E_Amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtCO_E_AmountKeyReleased(e);
			}
		});
		txtCO_E_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		txtCO_E_Amount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_E_Amount.setColumns(10);
		GridBagConstraints gbc_txtCO_E_Amount = new GridBagConstraints();
		gbc_txtCO_E_Amount.fill = GridBagConstraints.BOTH;
		gbc_txtCO_E_Amount.insets = new Insets(0, 0, 5, 5);
		gbc_txtCO_E_Amount.gridx = 2;
		gbc_txtCO_E_Amount.gridy = 1;
		centerCOPanel.add(txtCO_E_Amount, gbc_txtCO_E_Amount);
		
		txtCO_E_Price = new JTextField();
		txtCO_E_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_E_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_E_Price.setColumns(10);
		GridBagConstraints gbc_txtCO_E_Price = new GridBagConstraints();
		gbc_txtCO_E_Price.fill = GridBagConstraints.BOTH;
		gbc_txtCO_E_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtCO_E_Price.gridx = 4;
		gbc_txtCO_E_Price.gridy = 1;
		centerCOPanel.add(txtCO_E_Price, gbc_txtCO_E_Price);
		
		txtCO_E_Total = new JTextField();
		txtCO_E_Total.setEditable(false);
		txtCO_E_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_E_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_E_Total.setColumns(10);
		GridBagConstraints gbc_txtCO_E_Total = new GridBagConstraints();
		gbc_txtCO_E_Total.fill = GridBagConstraints.BOTH;
		gbc_txtCO_E_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtCO_E_Total.gridx = 6;
		gbc_txtCO_E_Total.gridy = 1;
		centerCOPanel.add(txtCO_E_Total, gbc_txtCO_E_Total);
		
		lblCOWater = new JLabel("Water:");
		lblCOWater.setForeground(Color.WHITE);
		lblCOWater.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOWater.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOWater = new GridBagConstraints();
		gbc_lblCOWater.fill = GridBagConstraints.VERTICAL;
		gbc_lblCOWater.anchor = GridBagConstraints.EAST;
		gbc_lblCOWater.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOWater.gridx = 0;
		gbc_lblCOWater.gridy = 2;
		centerCOPanel.add(lblCOWater, gbc_lblCOWater);
		
		txtCO_W_Amount = new JTextField();
		txtCO_W_Amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtCO_W_AmountKeyReleased(e);
			}
		});
		txtCO_W_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		txtCO_W_Amount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_W_Amount.setColumns(10);
		GridBagConstraints gbc_txtCO_W_Amount = new GridBagConstraints();
		gbc_txtCO_W_Amount.fill = GridBagConstraints.BOTH;
		gbc_txtCO_W_Amount.insets = new Insets(0, 0, 5, 5);
		gbc_txtCO_W_Amount.gridx = 2;
		gbc_txtCO_W_Amount.gridy = 2;
		centerCOPanel.add(txtCO_W_Amount, gbc_txtCO_W_Amount);
		
		txtCO_W_Price = new JTextField();
		txtCO_W_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_W_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_W_Price.setColumns(10);
		GridBagConstraints gbc_txtCO_W_Price = new GridBagConstraints();
		gbc_txtCO_W_Price.fill = GridBagConstraints.BOTH;
		gbc_txtCO_W_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtCO_W_Price.gridx = 4;
		gbc_txtCO_W_Price.gridy = 2;
		centerCOPanel.add(txtCO_W_Price, gbc_txtCO_W_Price);
		
		txtCO_W_Total = new JTextField();
		txtCO_W_Total.setEditable(false);
		txtCO_W_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_W_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_W_Total.setColumns(10);
		GridBagConstraints gbc_txtCO_W_Total = new GridBagConstraints();
		gbc_txtCO_W_Total.fill = GridBagConstraints.BOTH;
		gbc_txtCO_W_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtCO_W_Total.gridx = 6;
		gbc_txtCO_W_Total.gridy = 2;
		centerCOPanel.add(txtCO_W_Total, gbc_txtCO_W_Total);
		
		txtCO_R_Price = new JTextField();
		txtCO_R_Price.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtCO_R_TotalKeyReleased(e);
			}
		});
		
		lblCOOthers = new JLabel("Maintain & Security:");
		lblCOOthers.setForeground(Color.WHITE);
		lblCOOthers.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOOthers.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOOthers = new GridBagConstraints();
		gbc_lblCOOthers.fill = GridBagConstraints.VERTICAL;
		gbc_lblCOOthers.anchor = GridBagConstraints.EAST;
		gbc_lblCOOthers.gridwidth = 3;
		gbc_lblCOOthers.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOOthers.gridx = 0;
		gbc_lblCOOthers.gridy = 4;
		centerCOPanel.add(lblCOOthers, gbc_lblCOOthers);
		txtCO_R_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_R_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_R_Price.setColumns(10);
		GridBagConstraints gbc_txtCO_R_Price = new GridBagConstraints();
		gbc_txtCO_R_Price.fill = GridBagConstraints.BOTH;
		gbc_txtCO_R_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtCO_R_Price.gridx = 4;
		gbc_txtCO_R_Price.gridy = 4;
		centerCOPanel.add(txtCO_R_Price, gbc_txtCO_R_Price);
		
		txtCO_R_Total = new JTextField();
		txtCO_R_Total.setEditable(false);
		txtCO_R_Total.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtCO_R_TotalKeyReleased(e);
			}
		});
		txtCO_R_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_R_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_R_Total.setColumns(10);
		GridBagConstraints gbc_txtCO_R_Total = new GridBagConstraints();
		gbc_txtCO_R_Total.fill = GridBagConstraints.BOTH;
		gbc_txtCO_R_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtCO_R_Total.gridx = 6;
		gbc_txtCO_R_Total.gridy = 4;
		centerCOPanel.add(txtCO_R_Total, gbc_txtCO_R_Total);
		
		lblMaintainSecurityNotify_2 = new JLabel("Security fee is 4.00. If customer didn't call for maintenance, maintain fee = 0");
		lblMaintainSecurityNotify_2.setForeground(Color.YELLOW);
		lblMaintainSecurityNotify_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblMaintainSecurityNotify_2 = new GridBagConstraints();
		gbc_lblMaintainSecurityNotify_2.gridwidth = 5;
		gbc_lblMaintainSecurityNotify_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaintainSecurityNotify_2.gridx = 0;
		gbc_lblMaintainSecurityNotify_2.gridy = 5;
		centerCOPanel.add(lblMaintainSecurityNotify_2, gbc_lblMaintainSecurityNotify_2);
		
		txtCO_O_Price = new JTextField();
		txtCO_O_Price.setEditable(false);
		txtCO_O_Price.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtCO_O_PriceKeyReleased(e);
			}
		});
		
		lblCORoom = new JLabel("Room:");
		lblCORoom.setForeground(Color.WHITE);
		lblCORoom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCORoom.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCORoom = new GridBagConstraints();
		gbc_lblCORoom.fill = GridBagConstraints.VERTICAL;
		gbc_lblCORoom.anchor = GridBagConstraints.EAST;
		gbc_lblCORoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblCORoom.gridx = 2;
		gbc_lblCORoom.gridy = 6;
		centerCOPanel.add(lblCORoom, gbc_lblCORoom);
		txtCO_O_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_O_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_O_Price.setColumns(10);
		GridBagConstraints gbc_txtCO_O_Price = new GridBagConstraints();
		gbc_txtCO_O_Price.fill = GridBagConstraints.BOTH;
		gbc_txtCO_O_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txtCO_O_Price.gridx = 4;
		gbc_txtCO_O_Price.gridy = 6;
		centerCOPanel.add(txtCO_O_Price, gbc_txtCO_O_Price);
		
		txtCO_O_Total = new JTextField();
		txtCO_O_Total.setEditable(false);
		txtCO_O_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_O_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_O_Total.setColumns(10);
		GridBagConstraints gbc_txtCO_O_Total = new GridBagConstraints();
		gbc_txtCO_O_Total.fill = GridBagConstraints.BOTH;
		gbc_txtCO_O_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtCO_O_Total.gridx = 6;
		gbc_txtCO_O_Total.gridy = 6;
		centerCOPanel.add(txtCO_O_Total, gbc_txtCO_O_Total);
		
		lbCOParking = new JLabel("Parking:");
		lbCOParking.setForeground(Color.WHITE);
		lbCOParking.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbCOParking.setBackground(Color.WHITE);
		GridBagConstraints gbc_lbCOParking = new GridBagConstraints();
		gbc_lbCOParking.fill = GridBagConstraints.VERTICAL;
		gbc_lbCOParking.anchor = GridBagConstraints.EAST;
		gbc_lbCOParking.insets = new Insets(0, 0, 5, 5);
		gbc_lbCOParking.gridx = 4;
		gbc_lbCOParking.gridy = 7;
		centerCOPanel.add(lbCOParking, gbc_lbCOParking);
		
		chckbxCOParking = new JCheckBox("");
		chckbxCOParking.addItemListener(this::chckbxCOParkingItemStateChanged);
		GridBagConstraints gbc_chckbxCOParking = new GridBagConstraints();
		gbc_chckbxCOParking.fill = GridBagConstraints.BOTH;
		gbc_chckbxCOParking.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCOParking.gridx = 5;
		gbc_chckbxCOParking.gridy = 7;
		centerCOPanel.add(chckbxCOParking, gbc_chckbxCOParking);
		
		txtCO_P_Total = new JTextField();
		txtCO_P_Total.setEditable(false);
		txtCO_P_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_P_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_P_Total.setColumns(10);
		GridBagConstraints gbc_txtCO_P_Total = new GridBagConstraints();
		gbc_txtCO_P_Total.fill = GridBagConstraints.BOTH;
		gbc_txtCO_P_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtCO_P_Total.gridx = 6;
		gbc_txtCO_P_Total.gridy = 7;
		centerCOPanel.add(txtCO_P_Total, gbc_txtCO_P_Total);
		
		lblCOInternet = new JLabel("Internet:");
		lblCOInternet.setForeground(Color.WHITE);
		lblCOInternet.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOInternet.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOInternet = new GridBagConstraints();
		gbc_lblCOInternet.fill = GridBagConstraints.VERTICAL;
		gbc_lblCOInternet.anchor = GridBagConstraints.EAST;
		gbc_lblCOInternet.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOInternet.gridx = 4;
		gbc_lblCOInternet.gridy = 8;
		centerCOPanel.add(lblCOInternet, gbc_lblCOInternet);
		
		txtCO_I_Total = new JTextField();
		txtCO_I_Total.setEditable(false);
		txtCO_I_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_I_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_I_Total.setColumns(10);
		GridBagConstraints gbc_txtCO_I_Total = new GridBagConstraints();
		gbc_txtCO_I_Total.fill = GridBagConstraints.BOTH;
		gbc_txtCO_I_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtCO_I_Total.gridx = 6;
		gbc_txtCO_I_Total.gridy = 8;
		centerCOPanel.add(txtCO_I_Total, gbc_txtCO_I_Total);
		
		lblCOGarbage = new JLabel("Garbage:");
		lblCOGarbage.setForeground(Color.WHITE);
		lblCOGarbage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOGarbage.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOGarbage = new GridBagConstraints();
		gbc_lblCOGarbage.fill = GridBagConstraints.VERTICAL;
		gbc_lblCOGarbage.anchor = GridBagConstraints.EAST;
		gbc_lblCOGarbage.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOGarbage.gridx = 4;
		gbc_lblCOGarbage.gridy = 9;
		centerCOPanel.add(lblCOGarbage, gbc_lblCOGarbage);
		
		txtCO_G_Total = new JTextField();
		txtCO_G_Total.setEditable(false);
		txtCO_G_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_G_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_G_Total.setColumns(10);
		GridBagConstraints gbc_txtCO_G_Total = new GridBagConstraints();
		gbc_txtCO_G_Total.fill = GridBagConstraints.BOTH;
		gbc_txtCO_G_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txtCO_G_Total.gridx = 6;
		gbc_txtCO_G_Total.gridy = 9;
		centerCOPanel.add(txtCO_G_Total, gbc_txtCO_G_Total);
		
		lblCOTotal = new JLabel("Total:");
		lblCOTotal.setForeground(Color.WHITE);
		lblCOTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCOTotal.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCOTotal = new GridBagConstraints();
		gbc_lblCOTotal.anchor = GridBagConstraints.EAST;
		gbc_lblCOTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCOTotal.gridx = 0;
		gbc_lblCOTotal.gridy = 11;
		centerCOPanel.add(lblCOTotal, gbc_lblCOTotal);
		GroupLayout gl_checkOutPanel = new GroupLayout(checkOutPanel);
		gl_checkOutPanel.setHorizontalGroup(
			gl_checkOutPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(topCOPanel, GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
				.addComponent(centerCOPanel, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
		);
		gl_checkOutPanel.setVerticalGroup(
			gl_checkOutPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_checkOutPanel.createSequentialGroup()
					.addComponent(topCOPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerCOPanel, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
		);
		
		txtCO_Total = new JTextField();
		txtCO_Total.setEditable(false);
		txtCO_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_Total.setForeground(Color.RED);
		txtCO_Total.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtCO_Total.setColumns(10);
		GridBagConstraints gbc_txtCO_Total = new GridBagConstraints();
		gbc_txtCO_Total.gridwidth = 3;
		gbc_txtCO_Total.insets = new Insets(0, 0, 5, 5);
		gbc_txtCO_Total.fill = GridBagConstraints.BOTH;
		gbc_txtCO_Total.gridx = 2;
		gbc_txtCO_Total.gridy = 11;
		centerCOPanel.add(txtCO_Total, gbc_txtCO_Total);
		
		chckbxCO_Total = new JCheckBox("");
		chckbxCO_Total.addItemListener(this::chckbxCO_TotalItemStateChanged);
		GridBagConstraints gbc_chckbxCO_Total = new GridBagConstraints();
		gbc_chckbxCO_Total.fill = GridBagConstraints.VERTICAL;
		gbc_chckbxCO_Total.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCO_Total.gridx = 5;
		gbc_chckbxCO_Total.gridy = 11;
		centerCOPanel.add(chckbxCO_Total, gbc_chckbxCO_Total);
		
		txtCO_Check_Total_Status = new JTextField();
		txtCO_Check_Total_Status.setEditable(false);
		txtCO_Check_Total_Status.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCO_Check_Total_Status.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCO_Check_Total_Status.setColumns(10);
		GridBagConstraints gbc_txtCO_Check_Total_Status = new GridBagConstraints();
		gbc_txtCO_Check_Total_Status.insets = new Insets(0, 0, 5, 0);
		gbc_txtCO_Check_Total_Status.fill = GridBagConstraints.BOTH;
		gbc_txtCO_Check_Total_Status.gridx = 6;
		gbc_txtCO_Check_Total_Status.gridy = 11;
		centerCOPanel.add(txtCO_Check_Total_Status, gbc_txtCO_Check_Total_Status);
		
		btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(this::btnCheckOutActionPerformed);
		
		btnCalculate_1 = new JButton("Calculate total");
		btnCalculate_1.addActionListener(this::btnCalculate_1ActionPerformed);
		btnCalculate_1.setForeground(new Color(44, 62, 80));
		btnCalculate_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnCalculate_1 = new GridBagConstraints();
		gbc_btnCalculate_1.anchor = GridBagConstraints.EAST;
		gbc_btnCalculate_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnCalculate_1.gridx = 4;
		gbc_btnCalculate_1.gridy = 13;
		centerCOPanel.add(btnCalculate_1, gbc_btnCalculate_1);
		btnCheckOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnCheckOut = new GridBagConstraints();
		gbc_btnCheckOut.fill = GridBagConstraints.VERTICAL;
		gbc_btnCheckOut.gridx = 6;
		gbc_btnCheckOut.gridy = 13;
		centerCOPanel.add(btnCheckOut, gbc_btnCheckOut);
		checkOutPanel.setLayout(gl_checkOutPanel);
		centerPanel.setLayout(gl_centerPanel);

//		---------------------------------------------------------------------------------
		loadShowRoomId();
		loadPaymentInfo();
		showUtilityInfo();
		loadRoomIdForCheckOut();
		loadRoomIdForMonthlyCheck();
		showPaymentTable.setSurrendersFocusOnKeystroke(true);
		showPaymentTable.setAutoCreateRowSorter(true);
		var centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.LEFT);
		showPaymentTable.setDefaultRenderer(Object.class, centerRenderer);
	}
	
	// Xổ giá utility (SHOW, MONTHLY CHECK, CHECK OUT)
	public void showUtilityInfo() {
		var paymentDAO = new PaymentDAO();
		var uti_price = paymentDAO.getUtilityList();
		for (var item : uti_price) {
			if(item.getUtilitiy_id()==1) {
				txtShow_E_Price.setText(String.format("%02f", item.getUtility_price()).toString());
				txtMC_E_Price.setText(String.format("%02f", item.getUtility_price()).toString());
				txtCO_E_Price.setText(String.format("%02f", item.getUtility_price()).toString());
			} else if(item.getUtilitiy_id()==2) {
				txtShow_W_Price.setText(String.format("%02f", item.getUtility_price()).toString());
				txtMC_W_Price.setText(String.format("%02f", item.getUtility_price()).toString());
				txtCO_W_Price.setText(String.format("%02f", item.getUtility_price()).toString());
			} else if(item.getUtilitiy_id()==3) {
				txtShow_I_Total.setText(String.format("%02f", item.getUtility_price()).toString());
				txtMC_I_Total.setText(String.format("%02f", item.getUtility_price()).toString());
				txtCO_I_Total.setText(String.format("%02f", item.getUtility_price()).toString());
			} else {
				txtShow_G_Total.setText(String.format("%02f", item.getUtility_price()).toString());
				txtMC_G_Total.setText(String.format("%02f", item.getUtility_price()).toString());
				txtCO_G_Total.setText(String.format("%02f", item.getUtility_price()).toString());
			}
		}
	}
		
	// Hiển thị thông tin từ bảng Payment/Pay_Uti_Details
	protected void showPaymentTableMouseClicked(MouseEvent e) {
		var cp = (CardLayout) applicationPanel.getLayout();
		cp.show(applicationPanel, "show_payment");

		int rowIndex = showPaymentTable.getSelectedRow();
		
		try {
			startDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(showPaymentTable.getValueAt(rowIndex, 1).toString()));
			endDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(showPaymentTable.getValueAt(rowIndex, 2).toString()));
			txtShow_Total.setText(showPaymentTable.getValueAt(rowIndex, 3).toString());
			txtShowRoomId.setText(showPaymentTable.getValueAt(rowIndex, 4).toString());
			txtShowName.setText(showPaymentTable.getValueAt(rowIndex, 5).toString());
			txtShowPhoneNum.setText(showPaymentTable.getValueAt(rowIndex, 6).toString());
			txtShowAddress.setText(showPaymentTable.getValueAt(rowIndex, 7).toString());
			txtShowRa_no.setText(showPaymentTable.getValueAt(rowIndex, 8).toString());
			txtMonths.setText(showPaymentTable.getValueAt(rowIndex, 9).toString());
			
			
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Missing data, please check again");
		}
		loadShowRoomId();
	}
	
	public void loadPaymentInfo() {
		var model = new DefaultTableModel() {
			@Override
			public Class getColumnClass(int column){
				switch (column) {
				case 0: return String.class;	// payment_no
				case 1: return String.class;	// day_checkin
				case 2: return String.class;	// day_checkout
				case 3: return Double.class;	// total_amount
				case 4: return String.class;	// room_id
				case 5: return String.class;	// cus_name
				case 6: return String.class;	// cus_contactNo
				case 7: return String.class;	// cus_address
				case 8: return Integer.class;	// Ra_no
				case 9: return Integer.class;	// Month
				case 10: return Double.class;	// Room Price
				default:return String.class;
				}
			}
		};
		
		model.addColumn("Payment No.");
		model.addColumn("Day Start");
		model.addColumn("Day End");
		model.addColumn("Utility Price");
		model.addColumn("Room ID");
		model.addColumn("Customer name");
		model.addColumn("Phone");
		model.addColumn("Address");
		model.addColumn("RA NO.");
		model.addColumn("Month");
		model.addColumn("Room Price");
		
		var pi_dao = new PaymentInfoDAO();
		
		pi_dao.showPaymentInfo().forEach(
			pi->model.addRow(new Object[] {
					pi.getPi_payment_no(), pi.getPi_day_checkIn(), pi.getPi_day_checkOut(), pi.getPi_totalAmount(), pi.getPi_roomId(),
					pi.getPi_cusName(), pi.getPi_cusContactNo(), pi.getPi_cusAddress(), pi.getPi_ra_no(), pi.getPi_months(), pi.getPi_room_price()
			})
		);

		showPaymentTable.setModel(model);
			
		showPaymentTable.getColumnModel().getColumn(1).setMinWidth(0);
		showPaymentTable.getColumnModel().getColumn(1).setMaxWidth(0);
		showPaymentTable.getColumnModel().getColumn(1).setPreferredWidth(0);
			
		showPaymentTable.getColumnModel().getColumn(2).setMinWidth(0);
		showPaymentTable.getColumnModel().getColumn(2).setMaxWidth(0);
		showPaymentTable.getColumnModel().getColumn(2).setPreferredWidth(0);
		
		showPaymentTable.getColumnModel().getColumn(3).setMinWidth(0);
		showPaymentTable.getColumnModel().getColumn(3).setMaxWidth(0);
		showPaymentTable.getColumnModel().getColumn(3).setPreferredWidth(0);
		
		showPaymentTable.getColumnModel().getColumn(4).setMinWidth(0);
		showPaymentTable.getColumnModel().getColumn(4).setMaxWidth(0);
		showPaymentTable.getColumnModel().getColumn(4).setPreferredWidth(0);
		
		showPaymentTable.getColumnModel().getColumn(6).setMinWidth(0);
		showPaymentTable.getColumnModel().getColumn(6).setMaxWidth(0);
		showPaymentTable.getColumnModel().getColumn(6).setPreferredWidth(0);
		
		showPaymentTable.getColumnModel().getColumn(7).setMinWidth(0);
		showPaymentTable.getColumnModel().getColumn(7).setMaxWidth(0);
		showPaymentTable.getColumnModel().getColumn(7).setPreferredWidth(0);
		
		showPaymentTable.getColumnModel().getColumn(8).setMinWidth(0);
		showPaymentTable.getColumnModel().getColumn(8).setMaxWidth(0);
		showPaymentTable.getColumnModel().getColumn(8).setPreferredWidth(0);
		
		showPaymentTable.getColumnModel().getColumn(9).setMinWidth(0);
		showPaymentTable.getColumnModel().getColumn(9).setMaxWidth(0);
		showPaymentTable.getColumnModel().getColumn(9).setPreferredWidth(0);
		
		showPaymentTable.getColumnModel().getColumn(10).setMinWidth(0);
		showPaymentTable.getColumnModel().getColumn(10).setMaxWidth(0);
		showPaymentTable.getColumnModel().getColumn(10).setPreferredWidth(0);
	}
	
	
	// ----------------------------- SHOW Function -----------------------------------
	
	// Xổ id phòng vào comboBox (SHOW)
	public void loadShowRoomId() {
		var LSRI_payDAO = new PaymentDAO();
		var LSRI_payModel = new DefaultComboBoxModel<>();
		var LSRI_showRoomID = LSRI_payDAO.getShowRoomId();
		LSRI_payModel.addAll(LSRI_showRoomID);
	}

	// Nhập giá phòng -> total hiển thị giá (SHOW)
	protected void txtShow_R_PriceKeyReleased(KeyEvent e) {
		long final_num = 0;
		try {
			long date_amount = endDate.getCalendar().getTimeInMillis() - startDate.getCalendar().getTimeInMillis();
			final_num = date_amount / (1000 * 60 * 60 * 24);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter day Check Out");
		}
		try {
			var r_price = Double.parseDouble(txtShow_R_Price.getText());
			var r_total = r_price * final_num / 30;
			txtShow_R_Total.setText(String.format("%02f", r_total).toString());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter Room price");
		}
	}
	
	// Nhập số lượng điện -> total hiển thị giá (SHOW)
	protected void txtShow_E_AmountKeyReleased(KeyEvent e) {
		try {
			if(txtShow_E_Amount.getText()!=null) {
				var e_amount = Integer.parseInt(txtShow_E_Amount.getText());
				var e_price = Double.parseDouble(txtShow_E_Price.getText());
				var e_total = e_amount * e_price;
				txtShow_E_Total.setText(String.format("%02f", e_total).toString());
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter Electricity amount");
		}
	}
	
	// Nhập số lượng nước -> total hiển thị giá (SHOW)
	protected void txtShow_W_AmountKeyReleased(KeyEvent e) {
		try {
			if(txtShow_W_Amount.getText()!=null) {
				var w_amount = Integer.parseInt(txtShow_W_Amount.getText());
				var w_price = Double.parseDouble(txtShow_W_Price.getText());
				var w_total = w_amount * w_price;
				txtShow_W_Total.setText(String.format("%02f", w_total).toString());
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter Water amount");
		}
	}
	
	// Nhập giá bảo trì + bảo vệ -> total hiển thị giá (SHOW)
	protected void txtShow_O_PriceKeyReleased(KeyEvent e) {
		try {
			if(txtShow_O_Price.getText()!=null) {
				var o_price = Double.parseDouble(txtShow_O_Price.getText());
				var o_total = o_price + 0;
				txtShow_O_Total.setText(String.format("%02f", o_total).toString());
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter the price");
		}
	}
	
	// Check vào box đỗ xe -> total hiển thị giá (SHOW)
	protected void chckbxShowParkingStateChanged(ChangeEvent e) {
		if (chckbxShowParking.isSelected()) {
			txtShow_P_Total.setText("6.0");
		} else {
			txtShow_P_Total.setText("0.0");
		}
	}
	
	// Nút tính tổng tất cả các sub_total (Thành tiền) -> Total (SHOW)
	protected void btnCalculateActionPerformed(ActionEvent e) {
		Double show_total_price;
		try {
			show_total_price = Double.parseDouble(txtShow_R_Total.getText()) + Double.parseDouble(txtShow_E_Total.getText()) 
				+ Double.parseDouble(txtShow_W_Total.getText()) + Double.parseDouble(txtShow_I_Total.getText()) 
				+ Double.parseDouble(txtShow_P_Total.getText()) + Double.parseDouble(txtShow_G_Total.getText())
				+ Double.parseDouble(txtShow_O_Total.getText());
			txtShow_Total.setText(String.format("%02f", show_total_price).toString());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
	}
	
	// ----------------------------- MONTHLY CHECK Function -----------------------------------
	
	// Hiển thị panel (MONTHLY CHECK)
	protected void btnShowMonthlyCheckActionPerformed(ActionEvent e) {
		var cp = (CardLayout)applicationPanel.getLayout();
		cp.show(applicationPanel, "monthly_check");
	}
	
	// Xổ id phòng vào comboBox (MONTHLY CHECK)
	public void loadRoomIdForMonthlyCheck() {
		var LRIFMC_payDAO = new PaymentDAO();
		var LRIFMC_checkOutModel = new DefaultComboBoxModel<>();
		var LRIFMC_showRoomID = LRIFMC_payDAO.getCORoomId();
		LRIFMC_checkOutModel.addAll(LRIFMC_showRoomID);
		cbbMCId.setModel(LRIFMC_checkOutModel);
	}

	protected void cbbMCIdItemStateChanged(ItemEvent e) {
		var MC_index = cbbMCId.getSelectedIndex();
		
		var MC_roomID = cbbMCId.getSelectedItem();
		var MC_cus_dao = new CustomerDAO();
		var MC_get_cus = MC_cus_dao.getListCustomer();
		
		var MC_pay_DAO = new PaymentDAO();
		var MC_getRA = MC_pay_DAO.getRAList();
		
		var roomDAO = new RoomDAO();
		List<RoomList> getRoomPrice = new ArrayList<>();
		
		txtMCUsername.setText(MC_get_cus.get(MC_index).getCus_fullname());
		txtMCAddress.setText(MC_get_cus.get(MC_index).getCus_address());
		txtMCPhoneNum.setText(MC_get_cus.get(MC_index).getCus_contactNo());
		
		for (var item : MC_getRA) {
			if(MC_roomID.equals(item.getRoom_id())) {
				try {
					MCStartDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(item.getRa_dayIn().toString()));
					txt_MC_GetRANO.setText(String.valueOf(item.getRa_no()).toString());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}
		getRoomPrice.addAll(roomDAO.getListRoomList());
		for (var item2 : getRoomPrice) {
			if(MC_roomID.equals(item2.getRoom_id())) {
				txtMC_R_Price.setText(String.format("%02f", item2.getRoom_price()));
			}
		}
	}
	
	// Nhập giá phòng -> total hiển thị giá (MONTHLY CHECK)
	protected void txtMC_R_PriceKeyReleased(KeyEvent e) {
		try {
			var r_price = Double.parseDouble(txtMC_R_Price.getText());
			txtMC_R_Total.setText(String.format("%02f", r_price).toString());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter Room price");
		}
	}
	
	protected void txtMC_E_AmountKeyReleased(KeyEvent e) {
		try {
			if(txtMC_E_Amount.getText()!=null) {
				var e_amount = Integer.parseInt(txtMC_E_Amount.getText());
				var e_price = Double.parseDouble(txtMC_E_Price.getText());
				var e_total = e_amount * e_price;
				txtMC_E_Total.setText(String.format("%02f", e_total).toString());
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter Electricity amount");
		}
	}
	
	protected void txtMC_W_AmountKeyReleased(KeyEvent e) {
		try {
			if(txtMC_W_Amount.getText()!=null) {
				var w_amount = Integer.parseInt(txtMC_W_Amount.getText());
				var w_price = Double.parseDouble(txtMC_W_Price.getText());
				var w_total = w_amount * w_price;
				txtMC_W_Total.setText(String.format("%02f", w_total).toString());
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter Water amount");
		}
	}
	
	
	protected void txtMC_O_PriceKeyReleased(KeyEvent e) {
		try {
			if(txtMC_O_Price.getText()!=null) {
				var o_price = Double.parseDouble(txtMC_O_Price.getText());
				var o_total = o_price + 0;
				txtMC_O_Total.setText(String.format("%02f", o_total).toString());
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter the price");
		}
	}
	
	// Check vào box đỗ xe -> total hiển thị giá (MONTHLY CHECK)
	protected void chckbxMCParkingItemStateChanged(ItemEvent e) {
		if (chckbxMCParking.isSelected()) {
			txtMC_P_Total.setText("6.0");
		} else {
			txtMC_P_Total.setText("0.0");
		}
	}
	
	protected void btnCalculate_2ActionPerformed(ActionEvent e) {
		Double show_total_price;
		try {
			show_total_price = Double.parseDouble(txtMC_R_Total.getText()) + Double.parseDouble(txtMC_E_Total.getText()) 
				+ Double.parseDouble(txtMC_W_Total.getText()) + Double.parseDouble(txtMC_I_Total.getText()) 
				+ Double.parseDouble(txtMC_P_Total.getText()) + Double.parseDouble(txtMC_G_Total.getText())
				+ Double.parseDouble(txtMC_O_Total.getText());
				
			txtMC_Total.setText(String.format("%02f", show_total_price).toString());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
	}
		
	protected void chckbxMC_TotalItemStateChanged(ItemEvent e) {
		if(chckbxMC_Total.isSelected()) {
			txtCheck_MC_Total.setText("Paid");
		} else {
			txtCheck_MC_Total.setText("Unpaid");
		}
	}

	protected void btnMonthlyCheckActionPerformed(ActionEvent e) {
		// 1. Submit tbl_Payment
		var CO_pay = new Payments();
		var CO_payDAO = new PaymentDAO();
		
		String payment_no = null;
		List<Payment_no> str_list = CO_payDAO.getPaymentNo();
		String str = "";
		for (var getPayNumber : str_list) {
			str = getPayNumber.getPay_number();
		}
		
		payment_no = str.replaceAll("/", " ");
		String[] arr = payment_no.split(" ");
		int month = Integer.parseInt(arr[0]);
		int counter = Integer.parseInt(arr[1]);
		var currentMonth = new Date().getMonth();
		
		List<PaymentDetails> CO_detailList = new ArrayList<>();
		var CO_detailDAO = new PaymentDetailsDAO();
		
		try {
			if(currentMonth == month) {
				payment_no = String.format("%d/%04d", month, counter+1);
			} if(currentMonth > month) {
				counter = 0;
				payment_no = String.format("%d/%04d", currentMonth, counter+1);
			}
	        
			CO_pay.setPayment_no(payment_no);
			CO_pay.setRa_no(Integer.parseInt(txt_MC_GetRANO.getText()));
			CO_pay.setMonths(new Date().getMonth());
			CO_pay.setDayCheckIn(LocalDate.ofInstant(MCStartDate.getDate().toInstant(), ZoneId.systemDefault()));
			CO_pay.setDayCheckOut(LocalDate.now());
			CO_pay.setTotal_amount(Double.parseDouble(txtMC_Total.getText()));
			CO_pay.setStatus(chckbxMC_Total.isSelected());
			
			CO_payDAO.insertPayment(CO_pay);
			
			
			CO_detailList.add(new PaymentDetails(payment_no, 0, 1, Double.parseDouble(txtMC_R_Price.getText())));
			CO_detailList.add(new PaymentDetails(payment_no, 1, Integer.parseInt(txtMC_E_Amount.getText()), 
					Double.parseDouble(txtMC_E_Price.getText())));
			CO_detailList.add(new PaymentDetails(payment_no, 2, Integer.parseInt(txtMC_W_Amount.getText()), 
					Double.parseDouble(txtMC_W_Price.getText())));
			CO_detailList.add(new PaymentDetails(payment_no, 3, 1, Double.parseDouble(txtMC_I_Total.getText())));
			CO_detailList.add(new PaymentDetails(payment_no, 4, 1, Double.parseDouble(txtMC_P_Total.getText())));
			CO_detailList.add(new PaymentDetails(payment_no, 5, 1, Double.parseDouble(txtMC_G_Total.getText())));
			
			try {
				for(var paymentDetails : CO_detailList) {
					CO_detailDAO.insertPaymentDetail(paymentDetails);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
			
			JOptionPane.showMessageDialog(null, "Monthly check successful");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
		loadPaymentInfo();
	}
	
	
	// ----------------------------- CHECK OUT Function -----------------------------------

	// Hiển thị panel (CHECK OUT)
	protected void btnShowCheckOutActionPerformed(ActionEvent e) {
		var cp = (CardLayout)applicationPanel.getLayout();
		cp.show(applicationPanel, "check_out");
	}

	// Xổ id phòng vào comboBox (CHECK OUT)
	public void loadRoomIdForCheckOut() {
		var LRIFCO_payDAO = new PaymentDAO();
		var LRIFCO_checkOutModel = new DefaultComboBoxModel<>();
		var LRIFCO_showRoomID = LRIFCO_payDAO.getCORoomId();
		LRIFCO_checkOutModel.addAll(LRIFCO_showRoomID);
		cbbCOId.setModel(LRIFCO_checkOutModel);
	}
	
	// Check vào box để hiển thị thanh toán (PAID/UNPAID) (CHECK OUT)
	protected void chckbxCO_TotalItemStateChanged(ItemEvent e) {
		if(chckbxCO_Total.isSelected()) {
			txtCO_Check_Total_Status.setText("Paid");
		} else {
			txtCO_Check_Total_Status.setText("Unpaid");
		}
	}
	
	// Xổ thông tin từ comboBox (CHECK OUT)
	protected void cbbCOIdItemStateChanged(ItemEvent e) {
		var CO_index = cbbCOId.getSelectedIndex();
		var CO_cus_dao = new CustomerDAO();
		var CO_pay_DAO = new PaymentDAO();
		var CO_roomID = cbbCOId.getSelectedItem();
		var CO_getRA = CO_pay_DAO.getRAList();
		
		for (var item : CO_getRA) {
			if(CO_roomID.equals(item.getRoom_id())) {
				try {
					COStartDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(item.getRa_dayIn().toString()));
					txtGetRa_no.setText(String.format("%02f", item.getRa_no()).toString());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}
		var CO_get_cus = CO_cus_dao.getListCustomer();
		
		txtCOUsername.setText(CO_get_cus.get(CO_index).getCus_fullname());
		txtCOAddress.setText(CO_get_cus.get(CO_index).getCus_address());
		txtCOPhoneNum.setText(CO_get_cus.get(CO_index).getCus_contactNo());
	}
	
	// Room Price (CHECK OUT)
	protected void txtCO_R_TotalKeyReleased(KeyEvent e) {
		long date_amount = COEndDate.getCalendar().getTimeInMillis() - COStartDate.getCalendar().getTimeInMillis();
		var final_num = date_amount / (1000 * 60 * 60 * 24);

		try {
			var r_price = Double.parseDouble(txtCO_R_Price.getText());
			var r_total = r_price * final_num / 30;
				txtCO_R_Total.setText(String.format("%02f", r_total).toString());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter Room price");
		}
	}
	
	// Nhập số lượng điện -> total hiển thị giá (CHECK OUT)
	protected void txtCO_E_AmountKeyReleased(KeyEvent e) {
		try {
			if(txtCO_E_Amount.getText()!=null) {
				var e_amount = Integer.parseInt(txtCO_E_Amount.getText());
				var e_price = Double.parseDouble(txtCO_E_Price.getText());
				var e_total = e_amount * e_price;
				txtCO_E_Total.setText(String.format("%02f", e_total).toString());
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter Electricity amount");
		}
	}
	
	// Nhập số lượng nước -> total hiển thị giá (CHECK OUT)
	protected void txtCO_W_AmountKeyReleased(KeyEvent e) {
		try {
			if(txtCO_W_Amount.getText()!=null) {
				var w_amount = Integer.parseInt(txtCO_W_Amount.getText());
				var w_price = Double.parseDouble(txtCO_W_Price.getText());
				var w_total = w_amount * w_price;
				txtCO_W_Total.setText(String.format("%02f", w_total).toString());
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter Water amount");
		}
	}
	
	// Nhập giá bảo trì + bảo vệ -> total hiển thị giá (CHECK OUT)
	protected void txtCO_O_PriceKeyReleased(KeyEvent e) {
		try {
			if(txtCO_O_Price.getText()!=null) {
				var o_price = Double.parseDouble(txtCO_O_Price.getText());
				var o_total = o_price + 0;
				txtCO_O_Total.setText(String.format("%02f", o_total).toString());
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to enter the price");
		}
	}
	
	// Check box để hiển thị giá (CHECK OUT)
	protected void chckbxCOParkingItemStateChanged(ItemEvent e) {
		if (chckbxCOParking.isSelected()) {
			txtCO_P_Total.setText("6.0");
		} else {
			txtCO_P_Total.setText("0.0");
		}
	}
	
	protected void btnCalculate_1ActionPerformed(ActionEvent e) {
		Double show_total_price;
		try {
			show_total_price = Double.parseDouble(txtCO_R_Total.getText()) + Double.parseDouble(txtCO_E_Total.getText()) 
				+ Double.parseDouble(txtCO_W_Total.getText()) + Double.parseDouble(txtCO_I_Total.getText()) 
				+ Double.parseDouble(txtCO_P_Total.getText()) + Double.parseDouble(txtCO_G_Total.getText())
				+ Double.parseDouble(txtCO_O_Total.getText());
				
			txtCO_Total.setText(String.format("%02f", show_total_price).toString());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
	}
	
	// Thanh toán tiền khi Customer chuyển phòng / thanh toán tháng (CHECK OUT)
	protected void btnCheckOutActionPerformed(ActionEvent e) {
		var CO_pay = new Payments();
		var CO_payDAO = new PaymentDAO();

		String payment_no = null;
		List<Payment_no> str_list = CO_payDAO.getPaymentNo();
		String str = "";
		for (var getPayNumber : str_list) {
			str = getPayNumber.getPay_number();
		}
		
		payment_no = str.replaceAll("/", " ");
		String[] arr = payment_no.split(" ");
		int month = Integer.parseInt(arr[0]);
		int counter = Integer.parseInt(arr[1]);
		var currentMonth = new Date().getMonth();
		
		List<PaymentDetails> CO_detailList = new ArrayList<>();
		var CO_detailDAO = new PaymentDetailsDAO();

		try {
			if(currentMonth == month) {
				payment_no = String.format("%d/%04d", month, counter+1);
			} if(currentMonth > month) {
				counter = 0;
				payment_no = String.format("%d/%04d", currentMonth, counter+1);
			}
	        
			CO_pay.setPayment_no(payment_no);
			CO_pay.setRa_no(Integer.parseInt(txtGetRa_no.getText()));
			CO_pay.setMonths(new Date().getMonth());
			CO_pay.setDayCheckIn(LocalDate.ofInstant(COStartDate.getDate().toInstant(), ZoneId.systemDefault()));
			CO_pay.setDayCheckOut(LocalDate.ofInstant(COEndDate.getDate().toInstant(), ZoneId.systemDefault()));
			CO_pay.setTotal_amount(Double.parseDouble(txtCO_Total.getText()));
			CO_pay.setStatus(chckbxCO_Total.isSelected());
			
			CO_payDAO.insertPayment(CO_pay);
			

			CO_detailList.add(new PaymentDetails(payment_no, 0, 1, Double.parseDouble(txtCO_R_Price.getText())));
			CO_detailList.add(new PaymentDetails(payment_no, 1, Integer.parseInt(txtCO_E_Amount.getText()), 
					Double.parseDouble(txtCO_E_Price.getText())));
			CO_detailList.add(new PaymentDetails(payment_no, 2, Integer.parseInt(txtCO_W_Amount.getText()), 
					Double.parseDouble(txtCO_W_Price.getText())));
			CO_detailList.add(new PaymentDetails(payment_no, 3, 1, Double.parseDouble(txtCO_I_Total.getText())));
			CO_detailList.add(new PaymentDetails(payment_no, 4, 1, Double.parseDouble(txtCO_P_Total.getText())));
			CO_detailList.add(new PaymentDetails(payment_no, 5, 1, Double.parseDouble(txtCO_G_Total.getText())));
			
			try {
				for (var paymentDetails : CO_detailList) {
					CO_detailDAO.insertPaymentDetail(paymentDetails);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}
			
			
			var changeStatus = new RoomList();
			changeStatus.setRoom_status(false);
			changeStatus.setRoom_id(cbbCOId.getSelectedItem().toString());
			
			JOptionPane.showMessageDialog(null, "Check out successful");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
	}

}