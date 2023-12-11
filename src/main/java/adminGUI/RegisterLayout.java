package adminGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.CustomerDAO;
import dao.ManagerDAO;
import dao.PaymentDAO;
import dao.PaymentDetailsDAO;
import dao.RegisterDAO;
import entity.PaymentDetails;
import entity.Payment_no;
import entity.Payments;
import entity.Register;
import entity.RoomList;
import entity.Room_Allocation;

public class RegisterLayout extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel headPanel;
	private JPanel sidePanel;
	private JPanel centerPanel;
	private JPanel headInfo;
	private JLabel lblCategory;
	private JPanel infoPanel;
	private JScrollPane scrollPane;
	private JPanel applicationPanel;
	private JTable showRegisterTable;
	private JButton btnAdd;
	private JPanel showRegisterPanel;
	private JPanel showPanel;
	private JLabel lblShowRoomId;
	private JComboBox cbbShowId;
	private JLabel lblShowCusName;
	private JTextField txtShowName;
	private JLabel lblShowDob;
	private JDateChooser showDob;
	private JLabel lblShowCusAddress;
	private JTextField txtShowAddress;
	private JLabel lblShowRegDate;
	private JDateChooser showRegDate;
	private JLabel lblShowCusPhoneNum;
	private JTextField txtShowPhoneNum;
	private JLabel lblShowDeposit;
	private JTextField txtShowDeposit;
	private JLabel lblShowMngName;
	private JTextField txtShowMngName;
	private JLabel lblDateMoveIn;
	private JDateChooser showDateMoveIn;
	private JButton btnSaveEdit;
	private JButton btnRoomAllocation;
	private JLabel lblFooterBrand;
	private JPanel addRegisterPanel;
	private JPanel addPanel;
	private JLabel lblAddRoomId;
	private JComboBox cbbAddId;
	private JLabel lblAddCusName;
	private JLabel lblAddCusDob;
	private JDateChooser addDob;
	private JLabel lblAddCusAddress;
	private JTextField txtAddAddress;
	private JLabel lblAddRegDate;
	private JDateChooser addRegDate;
	private JLabel lblAddCusPhoneNum;
	private JTextField txtAddPhoneNum;
	private JLabel lblAddDeposit;
	private JTextField txtAddDeposit;
	private JLabel lblAddMngName;
	private JButton btnSaveAdd;
	private JButton btnChangeRoom;
	private JPanel RAPanel;
	private JScrollPane scrollPane_1;
	private JTable showRATable;
	private JComboBox cbbAddCusName;
	private JComboBox cbbAddMngName;
	private JLabel lblShowRegister_no;
	private JTextField txtRegisterNo;
	private JPanel showPaymentPanel;
	private JPanel centerShowPanel;
	private JLabel lblAmount;
	private JLabel lblPrice;
	private JLabel lblSubTotal;
	private JLabel lblRoom;
	private JTextField txt_R_Price;
	private JTextField txt_R_Total;
	private JLabel lblElectricity;
	private JTextField txt_E_Amount;
	private JTextField txt_E_Price;
	private JTextField txt_E_Total;
	private JLabel lblWater;
	private JTextField txt_W_Amount;
	private JTextField txt_W_Price;
	private JTextField txt_W_Total;
	private JLabel lblOthers;
	private JTextField txt_O_Price;
	private JTextField txt_O_Total;
	private JLabel lblMaintainSecurityNotify;
	private JLabel lblParking;
	private JCheckBox chckbxParking;
	private JTextField txt_P_Total;
	private JLabel lblInternet;
	private JTextField txt_I_Total;
	private JLabel lblGarbage;
	private JTextField txt_G_Total;
	private JButton btnSubmit;
	private JLabel lblTotal;
	private JTextField txt_Total;
	private JPanel topShowPanel;
	private JLabel lblCheckRoomId;
	private JComboBox cbbCheckRoomId;
	private JLabel lblCheckCusName;
	private JTextField txtCheckCusName;
	private JLabel lblCheckAddress;
	private JTextField txtCheckAddress;
	private JLabel lblCheckPhoneNum;
	private JTextField txtCheckPhoneNum;
	private JLabel lblCheckStartDate;
	private JDateChooser checkStartDate;
	private JLabel lblCheckEndDate;
	private JDateChooser checkEndDate;

	public RegisterLayout() {
		setLayout(new BorderLayout(0, 0));

		headPanel = new JPanel();
		headPanel.setBackground(new Color(255, 253, 231));
		add(headPanel, BorderLayout.NORTH);

		headInfo = new JPanel();
		headInfo.setBackground(new Color(44, 62, 80));

		lblCategory = new JLabel("R E G I S T E R");
		lblCategory.setForeground(new Color(156, 204, 101));
		lblCategory.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_headInfo = new GroupLayout(headInfo);
		gl_headInfo.setHorizontalGroup(gl_headInfo.createParallelGroup(Alignment.LEADING).addGroup(gl_headInfo
				.createSequentialGroup().addGap(564).addComponent(lblCategory).addContainerGap(564, Short.MAX_VALUE)));
		gl_headInfo.setVerticalGroup(gl_headInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headInfo.createSequentialGroup().addContainerGap()
						.addComponent(lblCategory, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE).addContainerGap()));
		headInfo.setLayout(gl_headInfo);
		GroupLayout gl_headPanel = new GroupLayout(headPanel);
		gl_headPanel.setHorizontalGroup(gl_headPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headPanel.createSequentialGroup().addContainerGap()
						.addComponent(headInfo, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE).addContainerGap()));
		gl_headPanel.setVerticalGroup(gl_headPanel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_headPanel.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(headInfo, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		headPanel.setLayout(gl_headPanel);

		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(255, 253, 231));
		add(sidePanel, BorderLayout.WEST);

		infoPanel = new JPanel();
		infoPanel.setBackground(new Color(61, 75, 89));

		scrollPane = new JScrollPane();
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel.setHorizontalGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE));
		gl_infoPanel.setVerticalGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE));

		showRegisterTable = new JTable();
		showRegisterTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showRegisterTableMouseClicked(e);
			}
		});
		showRegisterTable.setRowHeight(30);
		showRegisterTable.setForeground(new Color(44, 62, 80));
		showRegisterTable.setFillsViewportHeight(true);
		showRegisterTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showRegisterTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setViewportView(showRegisterTable);
		infoPanel.setLayout(gl_infoPanel);

		btnAdd = new JButton("Add Register");
		btnAdd.addActionListener(this::btnAddActionPerformed);
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setForeground(new Color(44, 62, 80));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.setBackground(UIManager.getColor("Button.background"));

		btnSaveEdit = new JButton("Save Edit");
		btnSaveEdit.addActionListener(this::btnSaveEditActionPerformed);
		btnSaveEdit.setForeground(new Color(44, 62, 80));
		btnSaveEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSaveEdit.setBackground(UIManager.getColor("Button.background"));
		GroupLayout gl_sidePanel = new GroupLayout(sidePanel);
		gl_sidePanel.setHorizontalGroup(gl_sidePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_sidePanel.createSequentialGroup().addGap(10).addComponent(infoPanel,
						GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING,
						gl_sidePanel.createSequentialGroup().addContainerGap().addComponent(btnAdd)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSaveEdit)
								.addContainerGap(97, Short.MAX_VALUE)));
		gl_sidePanel
				.setVerticalGroup(gl_sidePanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_sidePanel.createSequentialGroup()
								.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE).addGap(13)
								.addGroup(gl_sidePanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSaveEdit))
								.addContainerGap()));
		sidePanel.setLayout(gl_sidePanel);

		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 253, 231));
		add(centerPanel, BorderLayout.CENTER);

		applicationPanel = new JPanel();
		applicationPanel.setBackground(new Color(44, 62, 80));

		lblFooterBrand = new JLabel("Copyright © 2023 Green Home. All rights reserved.");
		lblFooterBrand.setForeground(new Color(44, 62, 80));
		lblFooterBrand.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));

		btnRoomAllocation = new JButton("Room Allocation");
		btnRoomAllocation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRoomAllocation.addActionListener(this::btnRoomAllocationActionPerformed);
		btnRoomAllocation.setFont(new Font("Times New Roman", Font.BOLD, 15));

		btnChangeRoom = new JButton("Change Room");
		btnChangeRoom.addActionListener(this::btnChangeRoomActionPerformed);
		btnChangeRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChangeRoom.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
		gl_centerPanel.setHorizontalGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_centerPanel.createSequentialGroup().addContainerGap().addGroup(gl_centerPanel
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(applicationPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011,
								Short.MAX_VALUE)
						.addGroup(gl_centerPanel.createSequentialGroup().addComponent(btnRoomAllocation)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnChangeRoom)
								.addPreferredGap(ComponentPlacement.RELATED, 399, Short.MAX_VALUE).addComponent(
										lblFooterBrand, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		gl_centerPanel.setVerticalGroup(gl_centerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_centerPanel.createSequentialGroup()
						.addComponent(applicationPanel, GroupLayout.PREFERRED_SIZE, 573, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_centerPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFooterBrand, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(btnRoomAllocation).addComponent(btnChangeRoom))));
		applicationPanel.setLayout(new CardLayout(0, 0));

		showRegisterPanel = new JPanel();
		showRegisterPanel.setBackground(new Color(255, 253, 231));
		applicationPanel.add(showRegisterPanel, "show_register");

		showPanel = new JPanel();
		showPanel.setBackground(new Color(44, 62, 80));
		GridBagLayout gbl_showPanel = new GridBagLayout();
		gbl_showPanel.columnWidths = new int[] { 0, 15, 161, 30, 0, 15, 0, 0, 0 };
		gbl_showPanel.rowHeights = new int[] { 40, 30, 40, 30, 40, 30, 40, 30, 40, 0 };
		gbl_showPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_showPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		showPanel.setLayout(gbl_showPanel);

		lblShowRegister_no = new JLabel("Register No:");
		lblShowRegister_no.setForeground(Color.WHITE);
		lblShowRegister_no.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowRegister_no = new GridBagConstraints();
		gbc_lblShowRegister_no.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowRegister_no.gridx = 0;
		gbc_lblShowRegister_no.gridy = 0;
		showPanel.add(lblShowRegister_no, gbc_lblShowRegister_no);

		txtRegisterNo = new JTextField();
		txtRegisterNo.setEditable(false);
		txtRegisterNo.setForeground(new Color(44, 62, 80));
		txtRegisterNo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtRegisterNo.setColumns(10);
		txtRegisterNo.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtRegisterNo = new GridBagConstraints();
		gbc_txtRegisterNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtRegisterNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRegisterNo.gridx = 2;
		gbc_txtRegisterNo.gridy = 0;
		showPanel.add(txtRegisterNo, gbc_txtRegisterNo);

		lblShowCusName = new JLabel("Customer Name:");
		lblShowCusName.setForeground(Color.WHITE);
		lblShowCusName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowCusName = new GridBagConstraints();
		gbc_lblShowCusName.anchor = GridBagConstraints.EAST;
		gbc_lblShowCusName.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowCusName.gridx = 4;
		gbc_lblShowCusName.gridy = 0;
		showPanel.add(lblShowCusName, gbc_lblShowCusName);

		txtShowName = new JTextField();
		txtShowName.setEditable(false);
		txtShowName.setForeground(new Color(44, 62, 80));
		txtShowName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtShowName.setColumns(10);
		txtShowName.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtShowName = new GridBagConstraints();
		gbc_txtShowName.fill = GridBagConstraints.BOTH;
		gbc_txtShowName.gridwidth = 2;
		gbc_txtShowName.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowName.gridx = 6;
		gbc_txtShowName.gridy = 0;
		showPanel.add(txtShowName, gbc_txtShowName);

		lblShowRoomId = new JLabel("Room ID:");
		lblShowRoomId.setForeground(Color.WHITE);
		lblShowRoomId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowRoomId = new GridBagConstraints();
		gbc_lblShowRoomId.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowRoomId.anchor = GridBagConstraints.EAST;
		gbc_lblShowRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowRoomId.gridx = 0;
		gbc_lblShowRoomId.gridy = 2;
		showPanel.add(lblShowRoomId, gbc_lblShowRoomId);

		cbbShowId = new JComboBox();
		cbbShowId.setForeground(new Color(44, 62, 80));
		cbbShowId.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		cbbShowId.setBackground(Color.WHITE);
		GridBagConstraints gbc_cbbShowId = new GridBagConstraints();
		gbc_cbbShowId.fill = GridBagConstraints.BOTH;
		gbc_cbbShowId.insets = new Insets(0, 0, 5, 5);
		gbc_cbbShowId.gridx = 2;
		gbc_cbbShowId.gridy = 2;
		showPanel.add(cbbShowId, gbc_cbbShowId);

		lblShowCusAddress = new JLabel("Address:");
		lblShowCusAddress.setForeground(Color.WHITE);
		lblShowCusAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowCusAddress = new GridBagConstraints();
		gbc_lblShowCusAddress.anchor = GridBagConstraints.EAST;
		gbc_lblShowCusAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowCusAddress.gridx = 4;
		gbc_lblShowCusAddress.gridy = 2;
		showPanel.add(lblShowCusAddress, gbc_lblShowCusAddress);

		txtShowAddress = new JTextField();
		txtShowAddress.setEditable(false);
		txtShowAddress.setForeground(new Color(44, 62, 80));
		txtShowAddress.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtShowAddress.setColumns(10);
		txtShowAddress.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtShowAddress = new GridBagConstraints();
		gbc_txtShowAddress.fill = GridBagConstraints.BOTH;
		gbc_txtShowAddress.gridwidth = 2;
		gbc_txtShowAddress.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowAddress.gridx = 6;
		gbc_txtShowAddress.gridy = 2;
		showPanel.add(txtShowAddress, gbc_txtShowAddress);

		lblShowDob = new JLabel("Date of Birth:");
		lblShowDob.setForeground(Color.WHITE);
		lblShowDob.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowDob = new GridBagConstraints();
		gbc_lblShowDob.anchor = GridBagConstraints.EAST;
		gbc_lblShowDob.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowDob.gridx = 0;
		gbc_lblShowDob.gridy = 4;
		showPanel.add(lblShowDob, gbc_lblShowDob);

		showDob = new JDateChooser();
		showDob.setForeground(new Color(44, 62, 80));
		showDob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		showDob.setDateFormatString("yyyy-MM-dd");
		showDob.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_showDob = new GridBagConstraints();
		gbc_showDob.fill = GridBagConstraints.BOTH;
		gbc_showDob.insets = new Insets(0, 0, 5, 5);
		gbc_showDob.gridx = 2;
		gbc_showDob.gridy = 4;
		showPanel.add(showDob, gbc_showDob);

		lblShowCusPhoneNum = new JLabel("Phone Number:");
		lblShowCusPhoneNum.setForeground(Color.WHITE);
		lblShowCusPhoneNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowCusPhoneNum = new GridBagConstraints();
		gbc_lblShowCusPhoneNum.anchor = GridBagConstraints.EAST;
		gbc_lblShowCusPhoneNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowCusPhoneNum.gridx = 4;
		gbc_lblShowCusPhoneNum.gridy = 4;
		showPanel.add(lblShowCusPhoneNum, gbc_lblShowCusPhoneNum);

		txtShowPhoneNum = new JTextField();
		txtShowPhoneNum.setEditable(false);
		txtShowPhoneNum.setForeground(new Color(44, 62, 80));
		txtShowPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtShowPhoneNum.setColumns(10);
		txtShowPhoneNum.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtShowPhoneNum = new GridBagConstraints();
		gbc_txtShowPhoneNum.fill = GridBagConstraints.BOTH;
		gbc_txtShowPhoneNum.gridwidth = 2;
		gbc_txtShowPhoneNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowPhoneNum.gridx = 6;
		gbc_txtShowPhoneNum.gridy = 4;
		showPanel.add(txtShowPhoneNum, gbc_txtShowPhoneNum);

		lblShowDeposit = new JLabel("Deposit:");
		lblShowDeposit.setForeground(Color.WHITE);
		lblShowDeposit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowDeposit = new GridBagConstraints();
		gbc_lblShowDeposit.anchor = GridBagConstraints.EAST;
		gbc_lblShowDeposit.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowDeposit.gridx = 0;
		gbc_lblShowDeposit.gridy = 6;
		showPanel.add(lblShowDeposit, gbc_lblShowDeposit);

		txtShowDeposit = new JTextField();
		txtShowDeposit.setEditable(false);
		txtShowDeposit.setForeground(new Color(44, 62, 80));
		txtShowDeposit.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtShowDeposit.setColumns(10);
		txtShowDeposit.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtShowDeposit = new GridBagConstraints();
		gbc_txtShowDeposit.fill = GridBagConstraints.BOTH;
		gbc_txtShowDeposit.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowDeposit.gridx = 2;
		gbc_txtShowDeposit.gridy = 6;
		showPanel.add(txtShowDeposit, gbc_txtShowDeposit);

		lblShowMngName = new JLabel("Manager Name:");
		lblShowMngName.setForeground(Color.WHITE);
		lblShowMngName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowMngName = new GridBagConstraints();
		gbc_lblShowMngName.anchor = GridBagConstraints.EAST;
		gbc_lblShowMngName.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowMngName.gridx = 4;
		gbc_lblShowMngName.gridy = 6;
		showPanel.add(lblShowMngName, gbc_lblShowMngName);

		txtShowMngName = new JTextField();
		txtShowMngName.setEditable(false);
		txtShowMngName.setForeground(new Color(44, 62, 80));
		txtShowMngName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtShowMngName.setColumns(10);
		txtShowMngName.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtShowMngName = new GridBagConstraints();
		gbc_txtShowMngName.fill = GridBagConstraints.BOTH;
		gbc_txtShowMngName.gridwidth = 2;
		gbc_txtShowMngName.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowMngName.gridx = 6;
		gbc_txtShowMngName.gridy = 6;
		showPanel.add(txtShowMngName, gbc_txtShowMngName);

		RAPanel = new JPanel();
		GroupLayout gl_showRegisterPanel = new GroupLayout(showRegisterPanel);
		gl_showRegisterPanel.setHorizontalGroup(gl_showRegisterPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(showPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(RAPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE));
		gl_showRegisterPanel.setVerticalGroup(gl_showRegisterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_showRegisterPanel.createSequentialGroup()
						.addComponent(showPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(RAPanel, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)));

		lblShowRegDate = new JLabel("Register Date:");
		lblShowRegDate.setForeground(Color.WHITE);
		lblShowRegDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowRegDate = new GridBagConstraints();
		gbc_lblShowRegDate.anchor = GridBagConstraints.EAST;
		gbc_lblShowRegDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblShowRegDate.gridx = 0;
		gbc_lblShowRegDate.gridy = 8;
		showPanel.add(lblShowRegDate, gbc_lblShowRegDate);

		showRegDate = new JDateChooser();
		showRegDate.setForeground(new Color(44, 62, 80));
		showRegDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		showRegDate.setDateFormatString("yyyy-MM-dd");
		showRegDate.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_showRegDate = new GridBagConstraints();
		gbc_showRegDate.fill = GridBagConstraints.BOTH;
		gbc_showRegDate.insets = new Insets(0, 0, 0, 5);
		gbc_showRegDate.gridx = 2;
		gbc_showRegDate.gridy = 8;
		showPanel.add(showRegDate, gbc_showRegDate);

		lblDateMoveIn = new JLabel("Date Move In:");
		lblDateMoveIn.setForeground(Color.WHITE);
		lblDateMoveIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblDateMoveIn = new GridBagConstraints();
		gbc_lblDateMoveIn.anchor = GridBagConstraints.EAST;
		gbc_lblDateMoveIn.insets = new Insets(0, 0, 0, 5);
		gbc_lblDateMoveIn.gridx = 4;
		gbc_lblDateMoveIn.gridy = 8;
		showPanel.add(lblDateMoveIn, gbc_lblDateMoveIn);

		showDateMoveIn = new JDateChooser();
		showDateMoveIn.setForeground(new Color(44, 62, 80));
		showDateMoveIn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		showDateMoveIn.setDateFormatString("yyyy-MM-dd");
		showDateMoveIn.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_showDateMoveIn = new GridBagConstraints();
		gbc_showDateMoveIn.gridwidth = 2;
		gbc_showDateMoveIn.fill = GridBagConstraints.BOTH;
		gbc_showDateMoveIn.gridx = 6;
		gbc_showDateMoveIn.gridy = 8;
		showPanel.add(showDateMoveIn, gbc_showDateMoveIn);
		RAPanel.setLayout(new GridLayout(1, 0, 0, 0));

		scrollPane_1 = new JScrollPane();
		RAPanel.add(scrollPane_1);

		showRATable = new JTable();
		showRATable.setAutoCreateRowSorter(true);
		showRATable.setSurrendersFocusOnKeystroke(true);
		showRATable.setRowHeight(30);
		showRATable.setForeground(new Color(44, 62, 80));
		showRATable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		showRATable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showRATable.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(showRATable);
		showRegisterPanel.setLayout(gl_showRegisterPanel);

		addRegisterPanel = new JPanel();
		addRegisterPanel.setBackground(new Color(44, 62, 80));
		applicationPanel.add(addRegisterPanel, "add_register");

		addPanel = new JPanel();
		addPanel.setBackground(new Color(44, 62, 80));
		GridBagLayout gbl_addPanel = new GridBagLayout();
		gbl_addPanel.columnWidths = new int[] { 0, 15, 161, 30, 0, 15, 0, 0, 0 };
		gbl_addPanel.rowHeights = new int[] { 40, 30, 40, 30, 40, 30, 40, 30, 40, 0 };
		gbl_addPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_addPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		addPanel.setLayout(gbl_addPanel);

		lblAddRoomId = new JLabel("Room ID:");
		lblAddRoomId.setForeground(Color.WHITE);
		lblAddRoomId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddRoomId = new GridBagConstraints();
		gbc_lblAddRoomId.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddRoomId.anchor = GridBagConstraints.EAST;
		gbc_lblAddRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddRoomId.gridx = 0;
		gbc_lblAddRoomId.gridy = 0;
		addPanel.add(lblAddRoomId, gbc_lblAddRoomId);

		cbbAddId = new JComboBox();
		cbbAddId.setForeground(new Color(44, 62, 80));
		cbbAddId.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_cbbAddId = new GridBagConstraints();
		gbc_cbbAddId.fill = GridBagConstraints.BOTH;
		gbc_cbbAddId.insets = new Insets(0, 0, 5, 5);
		gbc_cbbAddId.gridx = 2;
		gbc_cbbAddId.gridy = 0;
		addPanel.add(cbbAddId, gbc_cbbAddId);

		lblAddCusName = new JLabel("Customer Name:");
		lblAddCusName.setForeground(Color.WHITE);
		lblAddCusName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddCusName = new GridBagConstraints();
		gbc_lblAddCusName.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddCusName.anchor = GridBagConstraints.EAST;
		gbc_lblAddCusName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddCusName.gridx = 4;
		gbc_lblAddCusName.gridy = 0;
		addPanel.add(lblAddCusName, gbc_lblAddCusName);

		cbbAddCusName = new JComboBox();
		cbbAddCusName.addItemListener(this::cbbAddCusNameItemStateChanged);
		cbbAddCusName.setForeground(new Color(44, 62, 80));
		cbbAddCusName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_cbbAddCusName = new GridBagConstraints();
		gbc_cbbAddCusName.gridwidth = 2;
		gbc_cbbAddCusName.insets = new Insets(0, 0, 5, 0);
		gbc_cbbAddCusName.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbAddCusName.gridx = 6;
		gbc_cbbAddCusName.gridy = 0;
		addPanel.add(cbbAddCusName, gbc_cbbAddCusName);

		lblAddCusDob = new JLabel("Date of Birth:");
		lblAddCusDob.setForeground(Color.WHITE);
		lblAddCusDob.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddCusDob = new GridBagConstraints();
		gbc_lblAddCusDob.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddCusDob.anchor = GridBagConstraints.EAST;
		gbc_lblAddCusDob.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddCusDob.gridx = 0;
		gbc_lblAddCusDob.gridy = 2;
		addPanel.add(lblAddCusDob, gbc_lblAddCusDob);

		addDob = new JDateChooser();
		addDob.setForeground(new Color(44, 62, 80));
		addDob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		addDob.setDateFormatString("yyyy-MM-dd");
		addDob.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_addDob = new GridBagConstraints();
		gbc_addDob.fill = GridBagConstraints.BOTH;
		gbc_addDob.insets = new Insets(0, 0, 5, 5);
		gbc_addDob.gridx = 2;
		gbc_addDob.gridy = 2;
		addPanel.add(addDob, gbc_addDob);

		lblAddCusAddress = new JLabel("Address:");
		lblAddCusAddress.setForeground(Color.WHITE);
		lblAddCusAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddCusAddress = new GridBagConstraints();
		gbc_lblAddCusAddress.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddCusAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddCusAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddCusAddress.gridx = 4;
		gbc_lblAddCusAddress.gridy = 2;
		addPanel.add(lblAddCusAddress, gbc_lblAddCusAddress);

		txtAddAddress = new JTextField();
		txtAddAddress.setEditable(false);
		txtAddAddress.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtAddAddress.setColumns(10);
		GridBagConstraints gbc_txtAddAddress = new GridBagConstraints();
		gbc_txtAddAddress.fill = GridBagConstraints.BOTH;
		gbc_txtAddAddress.gridwidth = 2;
		gbc_txtAddAddress.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddAddress.gridx = 6;
		gbc_txtAddAddress.gridy = 2;
		addPanel.add(txtAddAddress, gbc_txtAddAddress);

		lblAddRegDate = new JLabel("Register Date:");
		lblAddRegDate.setForeground(Color.WHITE);
		lblAddRegDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddRegDate = new GridBagConstraints();
		gbc_lblAddRegDate.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddRegDate.anchor = GridBagConstraints.EAST;
		gbc_lblAddRegDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddRegDate.gridx = 0;
		gbc_lblAddRegDate.gridy = 4;
		addPanel.add(lblAddRegDate, gbc_lblAddRegDate);

		addRegDate = new JDateChooser();
		addRegDate.setForeground(new Color(44, 62, 80));
		addRegDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		addRegDate.setDateFormatString("yyyy-MM-dd");
		addRegDate.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_addRegDate = new GridBagConstraints();
		gbc_addRegDate.fill = GridBagConstraints.BOTH;
		gbc_addRegDate.insets = new Insets(0, 0, 5, 5);
		gbc_addRegDate.gridx = 2;
		gbc_addRegDate.gridy = 4;
		addPanel.add(addRegDate, gbc_addRegDate);

		lblAddCusPhoneNum = new JLabel("Phone Number:");
		lblAddCusPhoneNum.setForeground(Color.WHITE);
		lblAddCusPhoneNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddCusPhoneNum = new GridBagConstraints();
		gbc_lblAddCusPhoneNum.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddCusPhoneNum.anchor = GridBagConstraints.EAST;
		gbc_lblAddCusPhoneNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddCusPhoneNum.gridx = 4;
		gbc_lblAddCusPhoneNum.gridy = 4;
		addPanel.add(lblAddCusPhoneNum, gbc_lblAddCusPhoneNum);

		txtAddPhoneNum = new JTextField();
		txtAddPhoneNum.setEditable(false);
		txtAddPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtAddPhoneNum.setColumns(10);
		GridBagConstraints gbc_txtAddPhoneNum = new GridBagConstraints();
		gbc_txtAddPhoneNum.fill = GridBagConstraints.BOTH;
		gbc_txtAddPhoneNum.gridwidth = 2;
		gbc_txtAddPhoneNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddPhoneNum.gridx = 6;
		gbc_txtAddPhoneNum.gridy = 4;
		addPanel.add(txtAddPhoneNum, gbc_txtAddPhoneNum);

		lblAddDeposit = new JLabel("Deposit:");
		lblAddDeposit.setForeground(Color.WHITE);
		lblAddDeposit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddDeposit = new GridBagConstraints();
		gbc_lblAddDeposit.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddDeposit.anchor = GridBagConstraints.EAST;
		gbc_lblAddDeposit.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddDeposit.gridx = 0;
		gbc_lblAddDeposit.gridy = 6;
		addPanel.add(lblAddDeposit, gbc_lblAddDeposit);

		txtAddDeposit = new JTextField();
		txtAddDeposit.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtAddDeposit.setColumns(10);
		GridBagConstraints gbc_txtAddDeposit = new GridBagConstraints();
		gbc_txtAddDeposit.fill = GridBagConstraints.BOTH;
		gbc_txtAddDeposit.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddDeposit.gridx = 2;
		gbc_txtAddDeposit.gridy = 6;
		addPanel.add(txtAddDeposit, gbc_txtAddDeposit);

		lblAddMngName = new JLabel("Manager Name:");
		lblAddMngName.setForeground(Color.WHITE);
		lblAddMngName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddMngName = new GridBagConstraints();
		gbc_lblAddMngName.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddMngName.anchor = GridBagConstraints.EAST;
		gbc_lblAddMngName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddMngName.gridx = 4;
		gbc_lblAddMngName.gridy = 6;
		addPanel.add(lblAddMngName, gbc_lblAddMngName);

		cbbAddMngName = new JComboBox();
		cbbAddMngName.setForeground(new Color(44, 62, 80));
		cbbAddMngName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_cbbAddMngName = new GridBagConstraints();
		gbc_cbbAddMngName.gridwidth = 2;
		gbc_cbbAddMngName.insets = new Insets(0, 0, 5, 5);
		gbc_cbbAddMngName.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbAddMngName.gridx = 6;
		gbc_cbbAddMngName.gridy = 6;
		addPanel.add(cbbAddMngName, gbc_cbbAddMngName);

		btnSaveAdd = new JButton("Save Add");
		btnSaveAdd.addActionListener(this::btnSaveAddActionPerformed);
		btnSaveAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSaveAdd.setForeground(new Color(44, 62, 80));
		btnSaveAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSaveAdd.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_btnSaveAdd = new GridBagConstraints();
		gbc_btnSaveAdd.anchor = GridBagConstraints.WEST;
		gbc_btnSaveAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveAdd.gridx = 6;
		gbc_btnSaveAdd.gridy = 8;
		addPanel.add(btnSaveAdd, gbc_btnSaveAdd);
		GroupLayout gl_addRegisterPanel = new GroupLayout(addRegisterPanel);
		gl_addRegisterPanel.setHorizontalGroup(gl_addRegisterPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(addPanel, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE));
		gl_addRegisterPanel.setVerticalGroup(gl_addRegisterPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(addPanel, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE));
		addRegisterPanel.setLayout(gl_addRegisterPanel);

		showPaymentPanel = new JPanel();
		showPaymentPanel.setBackground(new Color(255, 253, 231));
		applicationPanel.add(showPaymentPanel, "show_payment");

		centerShowPanel = new JPanel();
		centerShowPanel.setBackground(new Color(44, 62, 80));
		GridBagLayout gbl_centerShowPanel = new GridBagLayout();
		gbl_centerShowPanel.columnWidths = new int[] { 0, 15, 48, 15, 0, 15, 0, 0 };
		gbl_centerShowPanel.rowHeights = new int[] { 30, 0, 25, 25, 30, 25, 0, 25, 20, 10, 30, 0, 0 };
		gbl_centerShowPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_centerShowPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		centerShowPanel.setLayout(gbl_centerShowPanel);

		lblAmount = new JLabel("Amount:");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAmount.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblAmount = new GridBagConstraints();
		gbc_lblAmount.fill = GridBagConstraints.VERTICAL;
		gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount.gridx = 2;
		gbc_lblAmount.gridy = 0;
		centerShowPanel.add(lblAmount, gbc_lblAmount);

		lblPrice = new JLabel("Price:");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPrice.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.fill = GridBagConstraints.VERTICAL;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 4;
		gbc_lblPrice.gridy = 0;
		centerShowPanel.add(lblPrice, gbc_lblPrice);

		lblSubTotal = new JLabel("Sub Total:");
		lblSubTotal.setForeground(Color.WHITE);
		lblSubTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSubTotal.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblSubTotal = new GridBagConstraints();
		gbc_lblSubTotal.fill = GridBagConstraints.VERTICAL;
		gbc_lblSubTotal.insets = new Insets(0, 0, 5, 0);
		gbc_lblSubTotal.gridx = 6;
		gbc_lblSubTotal.gridy = 0;
		centerShowPanel.add(lblSubTotal, gbc_lblSubTotal);

		lblElectricity = new JLabel("Electrictity:");
		lblElectricity.setForeground(Color.WHITE);
		lblElectricity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblElectricity.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblElectricity = new GridBagConstraints();
		gbc_lblElectricity.anchor = GridBagConstraints.EAST;
		gbc_lblElectricity.insets = new Insets(0, 0, 5, 5);
		gbc_lblElectricity.gridx = 0;
		gbc_lblElectricity.gridy = 1;
		centerShowPanel.add(lblElectricity, gbc_lblElectricity);

		txt_E_Amount = new JTextField();
		txt_E_Amount.setToolTipText("kW/h");
		txt_E_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_E_Amount.setForeground(new Color(44, 62, 80));
		txt_E_Amount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_E_Amount.setColumns(10);
		GridBagConstraints gbc_txt_E_Amount = new GridBagConstraints();
		gbc_txt_E_Amount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_E_Amount.insets = new Insets(0, 0, 5, 5);
		gbc_txt_E_Amount.gridx = 2;
		gbc_txt_E_Amount.gridy = 1;
		centerShowPanel.add(txt_E_Amount, gbc_txt_E_Amount);

		txt_E_Price = new JTextField();
		txt_E_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_E_Price.setForeground(new Color(44, 62, 80));
		txt_E_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_E_Price.setColumns(10);
		GridBagConstraints gbc_txt_E_Price = new GridBagConstraints();
		gbc_txt_E_Price.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_E_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txt_E_Price.gridx = 4;
		gbc_txt_E_Price.gridy = 1;
		centerShowPanel.add(txt_E_Price, gbc_txt_E_Price);

		txt_E_Total = new JTextField();
		txt_E_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_E_Total.setForeground(new Color(44, 62, 80));
		txt_E_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_E_Total.setEditable(false);
		txt_E_Total.setColumns(10);
		GridBagConstraints gbc_txt_E_Total = new GridBagConstraints();
		gbc_txt_E_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_E_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txt_E_Total.gridx = 6;
		gbc_txt_E_Total.gridy = 1;
		centerShowPanel.add(txt_E_Total, gbc_txt_E_Total);

		lblWater = new JLabel("Water:");
		lblWater.setForeground(Color.WHITE);
		lblWater.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblWater.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblWater = new GridBagConstraints();
		gbc_lblWater.anchor = GridBagConstraints.EAST;
		gbc_lblWater.insets = new Insets(0, 0, 5, 5);
		gbc_lblWater.gridx = 0;
		gbc_lblWater.gridy = 2;
		centerShowPanel.add(lblWater, gbc_lblWater);

		txt_W_Amount = new JTextField();
		txt_W_Amount.setToolTipText("cm3");
		txt_W_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_W_Amount.setForeground(new Color(44, 62, 80));
		txt_W_Amount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_W_Amount.setColumns(10);
		GridBagConstraints gbc_txt_W_Amount = new GridBagConstraints();
		gbc_txt_W_Amount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_W_Amount.insets = new Insets(0, 0, 5, 5);
		gbc_txt_W_Amount.gridx = 2;
		gbc_txt_W_Amount.gridy = 2;
		centerShowPanel.add(txt_W_Amount, gbc_txt_W_Amount);

		txt_W_Price = new JTextField();
		txt_W_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_W_Price.setForeground(new Color(44, 62, 80));
		txt_W_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_W_Price.setColumns(10);
		GridBagConstraints gbc_txt_W_Price = new GridBagConstraints();
		gbc_txt_W_Price.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_W_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txt_W_Price.gridx = 4;
		gbc_txt_W_Price.gridy = 2;
		centerShowPanel.add(txt_W_Price, gbc_txt_W_Price);

		txt_W_Total = new JTextField();
		txt_W_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_W_Total.setForeground(new Color(44, 62, 80));
		txt_W_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_W_Total.setEditable(false);
		txt_W_Total.setColumns(10);
		GridBagConstraints gbc_txt_W_Total = new GridBagConstraints();
		gbc_txt_W_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_W_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txt_W_Total.gridx = 6;
		gbc_txt_W_Total.gridy = 2;
		centerShowPanel.add(txt_W_Total, gbc_txt_W_Total);

		lblOthers = new JLabel("Maintain & Security:");
		lblOthers.setForeground(Color.WHITE);
		lblOthers.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOthers.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblOthers = new GridBagConstraints();
		gbc_lblOthers.anchor = GridBagConstraints.EAST;
		gbc_lblOthers.gridwidth = 3;
		gbc_lblOthers.insets = new Insets(0, 0, 5, 5);
		gbc_lblOthers.gridx = 0;
		gbc_lblOthers.gridy = 4;
		centerShowPanel.add(lblOthers, gbc_lblOthers);

		txt_O_Price = new JTextField();
		txt_O_Price.setToolTipText("");
		txt_O_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_O_Price.setForeground(new Color(44, 62, 80));
		txt_O_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_O_Price.setColumns(10);
		GridBagConstraints gbc_txt_O_Price = new GridBagConstraints();
		gbc_txt_O_Price.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_O_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txt_O_Price.gridx = 4;
		gbc_txt_O_Price.gridy = 4;
		centerShowPanel.add(txt_O_Price, gbc_txt_O_Price);

		txt_O_Total = new JTextField();
		txt_O_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_O_Total.setForeground(new Color(44, 62, 80));
		txt_O_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_O_Total.setEditable(false);
		txt_O_Total.setColumns(10);
		GridBagConstraints gbc_txt_O_Total = new GridBagConstraints();
		gbc_txt_O_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_O_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txt_O_Total.gridx = 6;
		gbc_txt_O_Total.gridy = 4;
		centerShowPanel.add(txt_O_Total, gbc_txt_O_Total);

		lblMaintainSecurityNotify = new JLabel(
				"Security fee is 4.00. If customer didn't call for maintenance, maintain fee = 0");
		lblMaintainSecurityNotify.setForeground(Color.YELLOW);
		lblMaintainSecurityNotify.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblMaintainSecurityNotify = new GridBagConstraints();
		gbc_lblMaintainSecurityNotify.fill = GridBagConstraints.VERTICAL;
		gbc_lblMaintainSecurityNotify.gridwidth = 5;
		gbc_lblMaintainSecurityNotify.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaintainSecurityNotify.gridx = 0;
		gbc_lblMaintainSecurityNotify.gridy = 5;
		centerShowPanel.add(lblMaintainSecurityNotify, gbc_lblMaintainSecurityNotify);

		lblRoom = new JLabel("Room:");
		lblRoom.setForeground(Color.WHITE);
		lblRoom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRoom.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblRoom = new GridBagConstraints();
		gbc_lblRoom.anchor = GridBagConstraints.EAST;
		gbc_lblRoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoom.gridx = 2;
		gbc_lblRoom.gridy = 6;
		centerShowPanel.add(lblRoom, gbc_lblRoom);

		txt_R_Price = new JTextField();
		txt_R_Price.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_R_Price.setForeground(new Color(44, 62, 80));
		txt_R_Price.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_R_Price.setColumns(10);
		GridBagConstraints gbc_txt_R_Price = new GridBagConstraints();
		gbc_txt_R_Price.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_R_Price.insets = new Insets(0, 0, 5, 5);
		gbc_txt_R_Price.gridx = 4;
		gbc_txt_R_Price.gridy = 6;
		centerShowPanel.add(txt_R_Price, gbc_txt_R_Price);

		txt_R_Total = new JTextField();
		txt_R_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_R_Total.setForeground(new Color(44, 62, 80));
		txt_R_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_R_Total.setEditable(false);
		txt_R_Total.setColumns(10);
		GridBagConstraints gbc_txt_R_Total = new GridBagConstraints();
		gbc_txt_R_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_R_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txt_R_Total.gridx = 6;
		gbc_txt_R_Total.gridy = 6;
		centerShowPanel.add(txt_R_Total, gbc_txt_R_Total);

		lblParking = new JLabel("Parking:");
		lblParking.setForeground(Color.WHITE);
		lblParking.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblParking.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblParking = new GridBagConstraints();
		gbc_lblParking.anchor = GridBagConstraints.EAST;
		gbc_lblParking.insets = new Insets(0, 0, 5, 5);
		gbc_lblParking.gridx = 4;
		gbc_lblParking.gridy = 7;
		centerShowPanel.add(lblParking, gbc_lblParking);

		chckbxParking = new JCheckBox("");
		GridBagConstraints gbc_chckbxParking = new GridBagConstraints();
		gbc_chckbxParking.fill = GridBagConstraints.BOTH;
		gbc_chckbxParking.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxParking.gridx = 5;
		gbc_chckbxParking.gridy = 7;
		centerShowPanel.add(chckbxParking, gbc_chckbxParking);

		txt_P_Total = new JTextField();
		txt_P_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_P_Total.setForeground(new Color(44, 62, 80));
		txt_P_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_P_Total.setEditable(false);
		txt_P_Total.setColumns(10);
		GridBagConstraints gbc_txt_P_Total = new GridBagConstraints();
		gbc_txt_P_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_P_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txt_P_Total.gridx = 6;
		gbc_txt_P_Total.gridy = 7;
		centerShowPanel.add(txt_P_Total, gbc_txt_P_Total);

		lblInternet = new JLabel("Internet:");
		lblInternet.setForeground(Color.WHITE);
		lblInternet.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblInternet.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblInternet = new GridBagConstraints();
		gbc_lblInternet.anchor = GridBagConstraints.EAST;
		gbc_lblInternet.insets = new Insets(0, 0, 5, 5);
		gbc_lblInternet.gridx = 4;
		gbc_lblInternet.gridy = 8;
		centerShowPanel.add(lblInternet, gbc_lblInternet);

		txt_I_Total = new JTextField();
		txt_I_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_I_Total.setForeground(new Color(44, 62, 80));
		txt_I_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_I_Total.setEditable(false);
		txt_I_Total.setColumns(10);
		GridBagConstraints gbc_txt_I_Total = new GridBagConstraints();
		gbc_txt_I_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_I_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txt_I_Total.gridx = 6;
		gbc_txt_I_Total.gridy = 8;
		centerShowPanel.add(txt_I_Total, gbc_txt_I_Total);

		lblGarbage = new JLabel("Garbage:");
		lblGarbage.setForeground(Color.WHITE);
		lblGarbage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblGarbage.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblGarbage = new GridBagConstraints();
		gbc_lblGarbage.anchor = GridBagConstraints.EAST;
		gbc_lblGarbage.insets = new Insets(0, 0, 5, 5);
		gbc_lblGarbage.gridx = 4;
		gbc_lblGarbage.gridy = 9;
		centerShowPanel.add(lblGarbage, gbc_lblGarbage);

		txt_G_Total = new JTextField();
		txt_G_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_G_Total.setForeground(new Color(44, 62, 80));
		txt_G_Total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_G_Total.setEditable(false);
		txt_G_Total.setColumns(10);
		GridBagConstraints gbc_txt_G_Total = new GridBagConstraints();
		gbc_txt_G_Total.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_G_Total.insets = new Insets(0, 0, 5, 0);
		gbc_txt_G_Total.gridx = 6;
		gbc_txt_G_Total.gridy = 9;
		centerShowPanel.add(txt_G_Total, gbc_txt_G_Total);

		btnSubmit = new JButton("Change");
		btnSubmit.addActionListener(this::btnSubmitActionPerformed);
		btnSubmit.setForeground(new Color(44, 62, 80));
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 11;
		centerShowPanel.add(btnSubmit, gbc_btnSubmit);

		lblTotal = new JLabel("Total:");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotal.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 4;
		gbc_lblTotal.gridy = 11;
		centerShowPanel.add(lblTotal, gbc_lblTotal);

		txt_Total = new JTextField();
		txt_Total.setHorizontalAlignment(SwingConstants.TRAILING);
		txt_Total.setForeground(Color.RED);
		txt_Total.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txt_Total.setEditable(false);
		txt_Total.setColumns(10);
		GridBagConstraints gbc_txt_Total = new GridBagConstraints();
		gbc_txt_Total.fill = GridBagConstraints.BOTH;
		gbc_txt_Total.gridx = 6;
		gbc_txt_Total.gridy = 11;
		centerShowPanel.add(txt_Total, gbc_txt_Total);

		topShowPanel = new JPanel();
		topShowPanel.setBackground(new Color(44, 62, 80));
		GridBagLayout gbl_topShowPanel = new GridBagLayout();
		gbl_topShowPanel.columnWidths = new int[] { 0, 10, 161, 30, 0, 10, 0, 0 };
		gbl_topShowPanel.rowHeights = new int[] { 30, 10, 30, 10, 30, 0 };
		gbl_topShowPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_topShowPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		topShowPanel.setLayout(gbl_topShowPanel);

		lblCheckRoomId = new JLabel("Room ID:");
		lblCheckRoomId.setForeground(Color.WHITE);
		lblCheckRoomId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckRoomId.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCheckRoomId = new GridBagConstraints();
		gbc_lblCheckRoomId.fill = GridBagConstraints.VERTICAL;
		gbc_lblCheckRoomId.anchor = GridBagConstraints.EAST;
		gbc_lblCheckRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckRoomId.gridx = 0;
		gbc_lblCheckRoomId.gridy = 0;
		topShowPanel.add(lblCheckRoomId, gbc_lblCheckRoomId);

		cbbCheckRoomId = new JComboBox();
		cbbCheckRoomId.setForeground(new Color(44, 62, 80));
		cbbCheckRoomId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_cbbCheckRoomId = new GridBagConstraints();
		gbc_cbbCheckRoomId.fill = GridBagConstraints.BOTH;
		gbc_cbbCheckRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_cbbCheckRoomId.gridx = 2;
		gbc_cbbCheckRoomId.gridy = 0;
		topShowPanel.add(cbbCheckRoomId, gbc_cbbCheckRoomId);

		lblCheckCusName = new JLabel("Customer Name:");
		lblCheckCusName.setForeground(Color.WHITE);
		lblCheckCusName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckCusName.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCheckCusName = new GridBagConstraints();
		gbc_lblCheckCusName.anchor = GridBagConstraints.EAST;
		gbc_lblCheckCusName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckCusName.gridx = 4;
		gbc_lblCheckCusName.gridy = 0;
		topShowPanel.add(lblCheckCusName, gbc_lblCheckCusName);

		txtCheckCusName = new JTextField();
		txtCheckCusName.setForeground(new Color(44, 62, 80));
		txtCheckCusName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCheckCusName.setColumns(10);
		GridBagConstraints gbc_txtCheckCusName = new GridBagConstraints();
		gbc_txtCheckCusName.fill = GridBagConstraints.BOTH;
		gbc_txtCheckCusName.insets = new Insets(0, 0, 5, 0);
		gbc_txtCheckCusName.gridx = 6;
		gbc_txtCheckCusName.gridy = 0;
		topShowPanel.add(txtCheckCusName, gbc_txtCheckCusName);

		lblCheckAddress = new JLabel("Address:");
		lblCheckAddress.setForeground(Color.WHITE);
		lblCheckAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckAddress.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCheckAddress = new GridBagConstraints();
		gbc_lblCheckAddress.anchor = GridBagConstraints.EAST;
		gbc_lblCheckAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckAddress.gridx = 0;
		gbc_lblCheckAddress.gridy = 2;
		topShowPanel.add(lblCheckAddress, gbc_lblCheckAddress);

		txtCheckAddress = new JTextField();
		txtCheckAddress.setForeground(new Color(44, 62, 80));
		txtCheckAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCheckAddress.setColumns(10);
		GridBagConstraints gbc_txtCheckAddress = new GridBagConstraints();
		gbc_txtCheckAddress.fill = GridBagConstraints.BOTH;
		gbc_txtCheckAddress.insets = new Insets(0, 0, 5, 5);
		gbc_txtCheckAddress.gridx = 2;
		gbc_txtCheckAddress.gridy = 2;
		topShowPanel.add(txtCheckAddress, gbc_txtCheckAddress);

		lblCheckPhoneNum = new JLabel("Phone Number:");
		lblCheckPhoneNum.setForeground(Color.WHITE);
		lblCheckPhoneNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckPhoneNum.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCheckPhoneNum = new GridBagConstraints();
		gbc_lblCheckPhoneNum.anchor = GridBagConstraints.EAST;
		gbc_lblCheckPhoneNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckPhoneNum.gridx = 4;
		gbc_lblCheckPhoneNum.gridy = 2;
		topShowPanel.add(lblCheckPhoneNum, gbc_lblCheckPhoneNum);

		txtCheckPhoneNum = new JTextField();
		txtCheckPhoneNum.setForeground(new Color(44, 62, 80));
		txtCheckPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCheckPhoneNum.setColumns(10);
		GridBagConstraints gbc_txtCheckPhoneNum = new GridBagConstraints();
		gbc_txtCheckPhoneNum.fill = GridBagConstraints.BOTH;
		gbc_txtCheckPhoneNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtCheckPhoneNum.gridx = 6;
		gbc_txtCheckPhoneNum.gridy = 2;
		topShowPanel.add(txtCheckPhoneNum, gbc_txtCheckPhoneNum);

		lblCheckStartDate = new JLabel("Date Start:");
		lblCheckStartDate.setForeground(Color.WHITE);
		lblCheckStartDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckStartDate.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCheckStartDate = new GridBagConstraints();
		gbc_lblCheckStartDate.anchor = GridBagConstraints.EAST;
		gbc_lblCheckStartDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblCheckStartDate.gridx = 0;
		gbc_lblCheckStartDate.gridy = 4;
		topShowPanel.add(lblCheckStartDate, gbc_lblCheckStartDate);

		checkStartDate = new JDateChooser();
		checkStartDate.setPreferredSize(new Dimension(100, 20));
		checkStartDate.setForeground(new Color(44, 62, 80));
		checkStartDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		checkStartDate.setDateFormatString("yyyy-MM-dd");
		checkStartDate.setBounds(new Rectangle(0, 0, 0, 50));
		checkStartDate.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_checkStartDate = new GridBagConstraints();
		gbc_checkStartDate.fill = GridBagConstraints.BOTH;
		gbc_checkStartDate.insets = new Insets(0, 0, 0, 5);
		gbc_checkStartDate.gridx = 2;
		gbc_checkStartDate.gridy = 4;
		topShowPanel.add(checkStartDate, gbc_checkStartDate);

		lblCheckEndDate = new JLabel("Date End:");
		lblCheckEndDate.setForeground(Color.WHITE);
		lblCheckEndDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckEndDate.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCheckEndDate = new GridBagConstraints();
		gbc_lblCheckEndDate.anchor = GridBagConstraints.EAST;
		gbc_lblCheckEndDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblCheckEndDate.gridx = 4;
		gbc_lblCheckEndDate.gridy = 4;
		topShowPanel.add(lblCheckEndDate, gbc_lblCheckEndDate);

		checkEndDate = new JDateChooser();
		checkEndDate.setPreferredSize(new Dimension(100, 20));
		checkEndDate.setForeground(new Color(44, 62, 80));
		checkEndDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		checkEndDate.setDateFormatString("yyyy-MM-dd");
		checkEndDate.setBounds(new Rectangle(0, 0, 0, 50));
		checkEndDate.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_checkEndDate = new GridBagConstraints();
		gbc_checkEndDate.fill = GridBagConstraints.BOTH;
		gbc_checkEndDate.gridx = 6;
		gbc_checkEndDate.gridy = 4;
		topShowPanel.add(checkEndDate, gbc_checkEndDate);
		GroupLayout gl_showPaymentPanel = new GroupLayout(showPaymentPanel);
		gl_showPaymentPanel.setHorizontalGroup(gl_showPaymentPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(topShowPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
				.addComponent(centerShowPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE));
		gl_showPaymentPanel.setVerticalGroup(gl_showPaymentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_showPaymentPanel.createSequentialGroup()
						.addComponent(topShowPanel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(centerShowPanel, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)));
		showPaymentPanel.setLayout(gl_showPaymentPanel);
		centerPanel.setLayout(gl_centerPanel);

//		---------------------------------------------------------------------------------
		loadRegister();
		addRoomId();
		loadCusName();
		loadMngName();
		showRegisterTable.setSurrendersFocusOnKeystroke(true);
		showRegisterTable.setAutoCreateRowSorter(true);
		var centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.LEFT);
		showRegisterTable.setDefaultRenderer(Object.class, centerRenderer);
	}

	// ------------------------ REGISTER Functions --------------------------------

	// Hiển thị thông tin từ tbl_Register -> bảng
	public void loadRegister() {
		var LR_model = new DefaultTableModel() {
			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class; // cus_fullname
				case 1:
					return LocalDate.class; // cus_dob
				case 2:
					return String.class; // contact_no
				case 3:
					return String.class; // cus_address
				case 4:
					return String.class; // mng_fullname
				case 5:
					return Integer.class; // deposit
				case 6:
					return LocalDate.class; // register_day
				case 7:
					return Integer.class; // register_no
				default:
					return String.class;
				}
			}
		};

		LR_model.addColumn("Customer");
		LR_model.addColumn("Date of birth");
		LR_model.addColumn("Phone");
		LR_model.addColumn("Address");
		LR_model.addColumn("Manager");
		LR_model.addColumn("Deposit");
		LR_model.addColumn("Register date");
		LR_model.addColumn("Register No.");

		new RegisterDAO().show_register()
				.forEach(sr -> LR_model.addRow(new Object[] { sr.getSr_cus_fullname(), sr.getSr_cus_dob(),
						sr.getSr_cus_address(), sr.getSr_cus_contactNo(), sr.getSr_mng_fullname(), sr.getSr_deposit(),
						sr.getSr_register_day(), sr.getSr_register_no() }));

		showRegisterTable.setModel(LR_model);

		showRegisterTable.getColumnModel().getColumn(1).setMinWidth(0);
		showRegisterTable.getColumnModel().getColumn(1).setMaxWidth(0);
		showRegisterTable.getColumnModel().getColumn(1).setPreferredWidth(0);

		showRegisterTable.getColumnModel().getColumn(2).setMinWidth(0);
		showRegisterTable.getColumnModel().getColumn(2).setMaxWidth(0);
		showRegisterTable.getColumnModel().getColumn(2).setPreferredWidth(0);

		showRegisterTable.getColumnModel().getColumn(3).setMinWidth(0);
		showRegisterTable.getColumnModel().getColumn(3).setMaxWidth(0);
		showRegisterTable.getColumnModel().getColumn(3).setPreferredWidth(0);

		showRegisterTable.getColumnModel().getColumn(4).setMinWidth(0);
		showRegisterTable.getColumnModel().getColumn(4).setMaxWidth(0);
		showRegisterTable.getColumnModel().getColumn(4).setPreferredWidth(0);

		showRegisterTable.getColumnModel().getColumn(5).setMinWidth(0);
		showRegisterTable.getColumnModel().getColumn(5).setMaxWidth(0);
		showRegisterTable.getColumnModel().getColumn(5).setPreferredWidth(0);

		showRegisterTable.getColumnModel().getColumn(6).setMinWidth(0);
		showRegisterTable.getColumnModel().getColumn(6).setMaxWidth(0);
		showRegisterTable.getColumnModel().getColumn(6).setPreferredWidth(0);

		showRegisterTable.getColumnModel().getColumn(7).setMinWidth(0);
		showRegisterTable.getColumnModel().getColumn(7).setMaxWidth(0);
		showRegisterTable.getColumnModel().getColumn(7).setPreferredWidth(0);
	}

	// ------------------------ SHOW Function --------------------------------

	// Chọn bảng -> Xổ thông tin trong tbl_Register (SHOW)
	protected void showRegisterTableMouseClicked(MouseEvent e) {
		var cp = (CardLayout) applicationPanel.getLayout();
		cp.show(applicationPanel, "show_register");

		int rowIndex = showRegisterTable.getSelectedRow();

		try {
			txtShowName.setText(showRegisterTable.getValueAt(rowIndex, 0).toString());
			try {
				showDob.setDate(
						new SimpleDateFormat("yyyy-MM-dd").parse(showRegisterTable.getValueAt(rowIndex, 1).toString()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			txtShowPhoneNum.setText(showRegisterTable.getValueAt(rowIndex, 2).toString());
			txtShowAddress.setText(showRegisterTable.getValueAt(rowIndex, 3).toString());
			txtShowMngName.setText(showRegisterTable.getValueAt(rowIndex, 4).toString());
			txtShowDeposit.setText(showRegisterTable.getValueAt(rowIndex, 5).toString());
			try {
				showRegDate.setDate(
						new SimpleDateFormat("yyyy-MM-dd").parse(showRegisterTable.getValueAt(rowIndex, 6).toString()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			txtRegisterNo.setText(showRegisterTable.getValueAt(rowIndex, 7).toString());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Missing data, please check again");
		}
		showRoomId();
	}

	// Lưu thông tin sau khi thay đổi thông tin (SHOW)
	protected void btnSaveEditActionPerformed(ActionEvent e) {
		var SE_reg = new Register();
		var SE_regDAO = new RegisterDAO();
		var SE_cusList = new CustomerDAO().getListCustomer();
		var SE_mngList = new ManagerDAO().getListManager();
		try {
			SE_reg.setCus_id(SE_cusList.get(cbbAddCusName.getSelectedIndex()).getCus_id());
			SE_reg.setMng_id(SE_mngList.get(cbbAddMngName.getSelectedIndex()).getMng_id());
			SE_reg.setRegister_day(LocalDate.ofInstant(addRegDate.getDate().toInstant(), ZoneId.systemDefault()));
			SE_reg.setDeposit(Integer.parseInt(txtAddDeposit.getText()));
			SE_regDAO.insertRegisList(SE_reg);

			JOptionPane.showMessageDialog(null, "Edit successful");

			loadRegister();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
	}

	// Hiển thị room ID ra comboBox (SHOW)
	public void showRoomId() {
		var SRI_regisDAO = new RegisterDAO();
		var SRI_roomModel = new DefaultComboBoxModel<>();
		var SRI_showRoomID = SRI_regisDAO.getRoomId();
		SRI_roomModel.addAll(SRI_showRoomID);
		cbbShowId.setModel(SRI_roomModel);
	}

	// ------------------------ ADD Function --------------------------------

	// Hiển thị panel (ADD)
	protected void btnAddActionPerformed(ActionEvent e) {
		var cp = (CardLayout) applicationPanel.getLayout();
		cp.show(applicationPanel, "add_register");
	}

	// Xổ room ID vào comboBox (ADD)
	public void addRoomId() {
		var ARID_regisDAO = new RegisterDAO();
		var ARID_roomModel = new DefaultComboBoxModel<>();
		var ARID_showRoomID = ARID_regisDAO.getRoomId();
		ARID_roomModel.addAll(ARID_showRoomID);
		cbbAddId.setModel(ARID_roomModel);
	}

	// Xổ Customer name vào comboBox (ADD)
	public List<String> loadCusName() {
		List<String> load_cusList = new ArrayList<>();
		var load_cusDAO = new CustomerDAO();
		var load_listCus = load_cusDAO.getListCustomer();
		var load_cusModel = new DefaultComboBoxModel<>();

		for (var item : load_listCus) {
			load_cusList.add(item.getCus_fullname());
		}
		load_cusModel.addAll(load_cusList);
		cbbAddCusName.setModel(load_cusModel);
		return load_cusList;
	}

	// Xổ Manager name vào comboBox (ADD)
	public List<String> loadMngName() {
		List<String> load_mngList = new ArrayList<>();
		var load_mngDAO = new ManagerDAO();
		var load_listMng = load_mngDAO.getListManager();
		var load_mngModel = new DefaultComboBoxModel<>();

		for (var item : load_listMng) {
			load_mngList.add(item.getMng_fullname());
		}
		load_mngModel.addAll(load_mngList);
		cbbAddMngName.setModel(load_mngModel);
		return load_mngList;
	}

	// Khi chọn Customer, các thông tin phụ sẽ được xổ ra (ADD)
	protected void cbbAddCusNameItemStateChanged(ItemEvent e) {
		var cbb_cusInfo = new CustomerDAO().getListCustomer();

		txtAddPhoneNum.setText(cbb_cusInfo.get(cbbAddCusName.getSelectedIndex()).getCus_contactNo());
		txtAddAddress.setText(cbb_cusInfo.get(cbbAddCusName.getSelectedIndex()).getCus_address());
		try {
			addDob.setDate(new SimpleDateFormat("yyyy-MM-dd")
					.parse(cbb_cusInfo.get(cbbAddCusName.getSelectedIndex()).getCus_dob().toString()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

	// Lưu thông tin Customer sau khi thêm vào Database (ADD)
	protected void btnSaveAddActionPerformed(ActionEvent e) {
		var SA_reg = new Register();
		var SA_regDAO = new RegisterDAO();
		var SA_getCus = new CustomerDAO().getListCustomer();
		var SA_getMng = new ManagerDAO().getListManager();
		try {
			SA_reg.setCus_id(SA_getCus.get(cbbAddCusName.getSelectedIndex()).getCus_id());
			SA_reg.setMng_id(SA_getMng.get(cbbAddMngName.getSelectedIndex()).getMng_id());
			SA_reg.setRegister_day(LocalDate.ofInstant(addRegDate.getDate().toInstant(), ZoneId.systemDefault()));
			SA_reg.setDeposit(Integer.parseInt(txtAddDeposit.getText()));
			SA_regDAO.insertRegisList(SA_reg);

			JOptionPane.showMessageDialog(null, "Add successful");

			addRoomId();
			loadRegister();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
	}

	// ------------------------ Room Allocation Function
	// --------------------------------

	// Lưu thông tin vào tbl_Room_Allocation
	protected void btnRoomAllocationActionPerformed(ActionEvent e) {
		var RA_ra = new Room_Allocation();
		var RA_rl = new RoomList();
		var RA_regDAO = new RegisterDAO();
		try {
			RA_ra.setRoom_id(cbbShowId.getSelectedItem().toString());
			RA_ra.setRegister_no(Integer.parseInt(txtRegisterNo.getText()));
			RA_ra.setRa_dayIn(LocalDate.ofInstant(showDateMoveIn.getDate().toInstant(), ZoneId.systemDefault()));

			RA_rl.setRoom_status(true);
			RA_rl.setRoom_id(cbbShowId.getSelectedItem().toString());

			RA_regDAO.insertRA(RA_ra);
			RA_regDAO.changeRoomStatus(RA_rl);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
	}

	protected void btnChangeRoomActionPerformed(ActionEvent e) {
		var cp = (CardLayout) applicationPanel.getLayout();
		cp.show(applicationPanel, "show_payment");
	}

	protected void btnSubmitActionPerformed(ActionEvent e) {
		var CR_pay = new Payments();
		var CR_payDAO = new PaymentDAO();

		String payment_no = null;
		List<Payment_no> str_list = CR_payDAO.getPaymentNo();
		String str = "";
		for (var getPayNumber : str_list) {
			str = getPayNumber.getPay_number();
		}

		payment_no = str.replaceAll("/", " ");
		String[] arr = payment_no.split(" ");
		int month = Integer.parseInt(arr[0]);
		int counter = Integer.parseInt(arr[1]);
		var currentMonth = new Date().getMonth();

		List<PaymentDetails> CR_detailList = new ArrayList<>();
		var CR_detailDAO = new PaymentDetailsDAO();

		try {
			if (currentMonth == month) {
				payment_no = String.format("%d/%04d", month, counter + 1);
			}
			if (currentMonth > month) {
				counter = 0;
				payment_no = String.format("%d/%04d", currentMonth, counter + 1);
			}
			CR_pay.setPayment_no(payment_no);
			CR_pay.setMonths(new Date().getMonth());
			CR_pay.setDayCheckIn(LocalDate.ofInstant(checkStartDate.getDate().toInstant(), ZoneId.systemDefault()));
			CR_pay.setDayCheckOut(LocalDate.ofInstant(checkEndDate.getDate().toInstant(), ZoneId.systemDefault()));
			CR_pay.setTotal_amount(Double.parseDouble(txt_Total.getText()));

			CR_payDAO.insertPayment(CR_pay);

			CR_detailList.add(new PaymentDetails(payment_no, 0, 1, Double.parseDouble(txt_R_Price.getText())));
			CR_detailList.add(new PaymentDetails(payment_no, 1, Integer.parseInt(txt_E_Amount.getText()),
					Double.parseDouble(txt_E_Price.getText())));
			CR_detailList.add(new PaymentDetails(payment_no, 2, Integer.parseInt(txt_W_Amount.getText()),
					Double.parseDouble(txt_W_Price.getText())));
			CR_detailList.add(new PaymentDetails(payment_no, 3, 1, Double.parseDouble(txt_I_Total.getText())));
			CR_detailList.add(new PaymentDetails(payment_no, 4, 1, Double.parseDouble(txt_P_Total.getText())));
			CR_detailList.add(new PaymentDetails(payment_no, 5, 1, Double.parseDouble(txt_G_Total.getText())));
			try {
				for (var paymentDetails : CR_detailList) {
					CR_detailDAO.insertPaymentDetail(paymentDetails);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
			}

			var changeStatus = new RoomList();
			changeStatus.setRoom_status(true);
			changeStatus.setRoom_id(cbbShowId.getSelectedItem().toString());
			CR_payDAO.changeRoomStatus(changeStatus);

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
	}
}
