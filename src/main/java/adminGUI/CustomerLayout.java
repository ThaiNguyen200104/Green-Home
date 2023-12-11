package adminGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.CustomerDAO;
import entity.Customer;

public class CustomerLayout extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel headPanel;
	private JPanel sidePanel;
	private JPanel centerPanel;
	private JPanel headInfo;
	private JLabel lblCategory;
	private JPanel infoPanel;
	private JScrollPane scrollPane;
	private JPanel applicationPanel;
	private JPanel detailPanel;
	private JPanel showCusPanel;
	private JPanel addCusPanel;
	private JPanel topShowPanel;
	private JPanel centerShowPanel;
	private JLabel lblShowId;
	private JLabel lblShowName;
	private JLabel lblShowGender;
	private JLabel lblShowDob;
	private JLabel lblShowPhoneNum;
	private JLabel lblShowAddress;
	private JLabel lblShowIdCardNum;
	private JPanel buttonPanel;
	private JButton btnSaveAdd;
	private JButton btnSaveEdit;
	private JButton btnDeleteCus;
	private JLabel lblFooterBrand;
	private JPanel showPicturePanel;
	private JLabel lblShowPicture;
	private JTable showCusTable;
	private JPanel addPicturePanel;
	private JPanel topAddPanel;
	private JLabel lblAddPicture;
	private JButton btnChoosePicture;
	private JLabel lblAddId;
	private JLabel lblAddGender;
	private JTextField txtAddCusId;
	private JLabel lblAddFullName;
	private JLabel lblAddDob;
	private JTextField txtAddCusFullName;
	private JDateChooser addDobChooser;
	private JPanel centerAddPanel;
	private JLabel lblAddPhoneNum;
	private JLabel lblAddIdCardNum;
	private JScrollPane showScrollPane;
	private JTextArea textAreaShowAddress;
	private JLabel lblAddAddress;
	private JTextField txtAddCusPhoneNum;
	private JTextField txtAddCusIdCardNum;
	private JScrollPane addScrollPane;
	private JTextArea textAreaAddAddress;
	private JButton btnAddCus;
	private JCheckBox chckbxGender;
	private JTextField txtCusShowGender;
	private JTextField txtShowCusName;
	private JDateChooser dobCusChooser;
	private JTextField txtShowCusPhoneNum;
	private JCheckBox chckbxAddGender;
	private JTextField txtAddGender;
	private JButton btnEditPicture;
	private JTextField txtShowCusIdCardNum;
	private String fileName = null;
	private String driveAfter = null;
	private String driveBefore = null;
	private String fileBefore = null;
	private JTextField txtShowCusId;

	public CustomerLayout() {
		setLayout(new BorderLayout(0, 0));
		
		headPanel = new JPanel();
		headPanel.setBackground(new Color(255, 253, 231));
		add(headPanel, BorderLayout.NORTH);
		
		headInfo = new JPanel();
		headInfo.setBackground(new Color(44, 62, 80));
		
		lblCategory = new JLabel("C U S T O M E R");
		lblCategory.setForeground(new Color(156, 204, 101));
		lblCategory.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_headInfo = new GroupLayout(headInfo);
		gl_headInfo.setHorizontalGroup(
			gl_headInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headInfo.createSequentialGroup()
					.addGap(559)
					.addComponent(lblCategory)
					.addContainerGap(559, Short.MAX_VALUE))
		);
		gl_headInfo.setVerticalGroup(
			gl_headInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCategory, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
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
		
		showCusTable = new JTable();
		showCusTable.setFillsViewportHeight(true);
		showCusTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showCusTable.setRowHeight(30);
		showCusTable.setForeground(new Color(44, 62, 80));
		showCusTable.setBackground(new Color(255, 255, 255));
		showCusTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		showCusTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showCusTableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(showCusTable);
		infoPanel.setLayout(gl_infoPanel);
		GroupLayout gl_sidePanel = new GroupLayout(sidePanel);
		gl_sidePanel.setHorizontalGroup(
			gl_sidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sidePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
		);
		gl_sidePanel.setVerticalGroup(
			gl_sidePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
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
					.addComponent(applicationPanel, GroupLayout.PREFERRED_SIZE, 1026, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_centerPanel.setVerticalGroup(
			gl_centerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_centerPanel.createSequentialGroup()
					.addComponent(applicationPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		detailPanel = new JPanel();
		detailPanel.setBackground(new Color(44, 62, 80));
		
		lblFooterBrand = new JLabel("Copyright © 2023 Green Home. All rights reserved.");
		lblFooterBrand.setForeground(new Color(156, 204, 101));
		lblFooterBrand.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(44, 62, 80));
		
		btnSaveAdd = new JButton("Save Add");
		btnSaveAdd.addActionListener(this::btnSaveAddActionPerformed);
		btnSaveAdd.setForeground(new Color(44, 62, 80));
		btnSaveAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSaveAdd.setBackground(new Color(240, 240, 240));
		
		btnSaveEdit = new JButton("Save Edit");
		btnSaveEdit.addActionListener(this::btnSaveEditActionPerformed);
		btnSaveEdit.setForeground(new Color(44, 62, 80));
		btnSaveEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSaveEdit.setBackground(new Color(240, 240, 240));
		
		btnDeleteCus = new JButton("Delete Customer");
		btnDeleteCus.addActionListener(this::btnDeleteCusActionPerformed);
		btnDeleteCus.setForeground(new Color(44, 62, 80));
		btnDeleteCus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDeleteCus.setBackground(new Color(240, 240, 240));
		
		btnAddCus = new JButton("Add Customer");
		btnAddCus.addActionListener(this::btnAddCusActionPerformed);
		btnAddCus.setForeground(new Color(44, 62, 80));
		btnAddCus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAddCus.setBackground(new Color(240, 240, 240));
		GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
		gl_buttonPanel.setHorizontalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAddCus, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
					.addGap(39)
					.addComponent(btnSaveAdd, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addGap(44)
					.addComponent(btnSaveEdit, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addGap(41)
					.addComponent(btnDeleteCus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_buttonPanel.setVerticalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDeleteCus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_buttonPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAddCus, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
							.addComponent(btnSaveAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSaveEdit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(7))
		);
		buttonPanel.setLayout(gl_buttonPanel);
		GroupLayout gl_applicationPanel = new GroupLayout(applicationPanel);
		gl_applicationPanel.setHorizontalGroup(
			gl_applicationPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_applicationPanel.createSequentialGroup()
					.addGroup(gl_applicationPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(detailPanel, GroupLayout.PREFERRED_SIZE, 1032, Short.MAX_VALUE)
						.addGroup(gl_applicationPanel.createSequentialGroup()
							.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFooterBrand, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_applicationPanel.setVerticalGroup(
			gl_applicationPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_applicationPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(detailPanel, GroupLayout.PREFERRED_SIZE, 562, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_applicationPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblFooterBrand, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		detailPanel.setLayout(new CardLayout(0, 0));
		
		showCusPanel = new JPanel();
		showCusPanel.setBackground(new Color(44, 62, 80));
		detailPanel.add(showCusPanel, "show_cus");
		
		topShowPanel = new JPanel();
		topShowPanel.setBackground(new Color(44, 62, 80));
		
		centerShowPanel = new JPanel();
		centerShowPanel.setBackground(new Color(44, 62, 80));
		
		showPicturePanel = new JPanel();
		showPicturePanel.setBackground(new Color(44, 62, 80));
		GroupLayout gl_showCusPanel = new GroupLayout(showCusPanel);
		gl_showCusPanel.setHorizontalGroup(
			gl_showCusPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_showCusPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(showPicturePanel, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_showCusPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(topShowPanel, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
						.addComponent(centerShowPanel, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_showCusPanel.setVerticalGroup(
			gl_showCusPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_showCusPanel.createSequentialGroup()
					.addGroup(gl_showCusPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(showPicturePanel, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
						.addGroup(gl_showCusPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(topShowPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centerShowPanel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		lblShowPicture = new JLabel("");
		lblShowPicture.setOpaque(true);
		lblShowPicture.setBackground(new Color(44, 62, 80));
		
		btnEditPicture = new JButton("Choose a picture");
		btnEditPicture.addActionListener(this::btnEditPictureActionPerformed);
		btnEditPicture.setForeground(new Color(44, 62, 80));
		btnEditPicture.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEditPicture.setBackground(UIManager.getColor("Button.background"));
		GroupLayout gl_showPicturePanel = new GroupLayout(showPicturePanel);
		gl_showPicturePanel.setHorizontalGroup(
			gl_showPicturePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblShowPicture, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
				.addGroup(gl_showPicturePanel.createSequentialGroup()
					.addGap(110)
					.addComponent(btnEditPicture)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		gl_showPicturePanel.setVerticalGroup(
			gl_showPicturePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_showPicturePanel.createSequentialGroup()
					.addComponent(lblShowPicture, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addComponent(btnEditPicture)
					.addContainerGap())
		);
		showPicturePanel.setLayout(gl_showPicturePanel);
		GridBagLayout gbl_centerShowPanel = new GridBagLayout();
		gbl_centerShowPanel.columnWidths = new int[]{0, 10, 48, 0};
		gbl_centerShowPanel.rowHeights = new int[]{0, 25, 0, 25, 0, 0};
		gbl_centerShowPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_centerShowPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		centerShowPanel.setLayout(gbl_centerShowPanel);
		
		lblShowPhoneNum = new JLabel("Phone Number:");
		lblShowPhoneNum.setForeground(Color.WHITE);
		lblShowPhoneNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowPhoneNum = new GridBagConstraints();
		gbc_lblShowPhoneNum.anchor = GridBagConstraints.EAST;
		gbc_lblShowPhoneNum.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowPhoneNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowPhoneNum.gridx = 0;
		gbc_lblShowPhoneNum.gridy = 0;
		centerShowPanel.add(lblShowPhoneNum, gbc_lblShowPhoneNum);
		
		txtShowCusPhoneNum = new JTextField();
		txtShowCusPhoneNum.setForeground(new Color(44, 62, 80));
		txtShowCusPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtShowCusPhoneNum.setColumns(10);
		txtShowCusPhoneNum.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txtShowCusPhoneNum = new GridBagConstraints();
		gbc_txtShowCusPhoneNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowCusPhoneNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowCusPhoneNum.gridx = 2;
		gbc_txtShowCusPhoneNum.gridy = 0;
		centerShowPanel.add(txtShowCusPhoneNum, gbc_txtShowCusPhoneNum);
		
		lblShowIdCardNum = new JLabel("ID Card Number:");
		lblShowIdCardNum.setForeground(Color.WHITE);
		lblShowIdCardNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowIdCardNum = new GridBagConstraints();
		gbc_lblShowIdCardNum.anchor = GridBagConstraints.EAST;
		gbc_lblShowIdCardNum.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowIdCardNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowIdCardNum.gridx = 0;
		gbc_lblShowIdCardNum.gridy = 2;
		centerShowPanel.add(lblShowIdCardNum, gbc_lblShowIdCardNum);
		
		txtShowCusIdCardNum = new JTextField();
		txtShowCusIdCardNum.setForeground(new Color(44, 62, 80));
		txtShowCusIdCardNum.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtShowCusIdCardNum.setColumns(10);
		txtShowCusIdCardNum.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txtShowCusIdCardNum = new GridBagConstraints();
		gbc_txtShowCusIdCardNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowCusIdCardNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowCusIdCardNum.gridx = 2;
		gbc_txtShowCusIdCardNum.gridy = 2;
		centerShowPanel.add(txtShowCusIdCardNum, gbc_txtShowCusIdCardNum);
		
		lblShowAddress = new JLabel("Address :");
		lblShowAddress.setForeground(Color.WHITE);
		lblShowAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowAddress = new GridBagConstraints();
		gbc_lblShowAddress.anchor = GridBagConstraints.EAST;
		gbc_lblShowAddress.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowAddress.insets = new Insets(0, 0, 0, 5);
		gbc_lblShowAddress.gridx = 0;
		gbc_lblShowAddress.gridy = 4;
		centerShowPanel.add(lblShowAddress, gbc_lblShowAddress);
		
		showScrollPane = new JScrollPane();
		GridBagConstraints gbc_showScrollPane = new GridBagConstraints();
		gbc_showScrollPane.fill = GridBagConstraints.BOTH;
		gbc_showScrollPane.gridx = 2;
		gbc_showScrollPane.gridy = 4;
		centerShowPanel.add(showScrollPane, gbc_showScrollPane);
		
		textAreaShowAddress = new JTextArea();
		textAreaShowAddress.setForeground(new Color(44, 62, 80));
		textAreaShowAddress.setTabSize(10);
		textAreaShowAddress.setSelectionColor(new Color(156, 204, 101));
		textAreaShowAddress.setSelectedTextColor(new Color(61, 75, 89));
		textAreaShowAddress.setRows(8);
		textAreaShowAddress.setLineWrap(true);
		textAreaShowAddress.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textAreaShowAddress.setBackground(new Color(255, 255, 255));
		showScrollPane.setViewportView(textAreaShowAddress);
		GridBagLayout gbl_topShowPanel = new GridBagLayout();
		gbl_topShowPanel.columnWidths = new int[]{0, 10, 22, 80, 30, 0, 10, 0, 0};
		gbl_topShowPanel.rowHeights = new int[]{40, 25, 40, 25, 0};
		gbl_topShowPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_topShowPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		topShowPanel.setLayout(gbl_topShowPanel);
		
		lblShowId = new JLabel("ID:");
		lblShowId.setForeground(Color.WHITE);
		lblShowId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowId = new GridBagConstraints();
		gbc_lblShowId.anchor = GridBagConstraints.EAST;
		gbc_lblShowId.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowId.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowId.gridx = 0;
		gbc_lblShowId.gridy = 0;
		topShowPanel.add(lblShowId, gbc_lblShowId);
		
		txtShowCusId = new JTextField();
		txtShowCusId.setForeground(new Color(44, 62, 80));
		txtShowCusId.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtShowCusId.setColumns(10);
		txtShowCusId.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtShowCusId = new GridBagConstraints();
		gbc_txtShowCusId.gridwidth = 2;
		gbc_txtShowCusId.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowCusId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowCusId.gridx = 2;
		gbc_txtShowCusId.gridy = 0;
		topShowPanel.add(txtShowCusId, gbc_txtShowCusId);
		
		lblShowName = new JLabel("Full Name:");
		lblShowName.setForeground(Color.WHITE);
		lblShowName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowName = new GridBagConstraints();
		gbc_lblShowName.anchor = GridBagConstraints.EAST;
		gbc_lblShowName.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowName.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowName.gridx = 5;
		gbc_lblShowName.gridy = 0;
		topShowPanel.add(lblShowName, gbc_lblShowName);
		
		txtShowCusName = new JTextField();
		txtShowCusName.setForeground(new Color(44, 62, 80));
		txtShowCusName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtShowCusName.setColumns(10);
		txtShowCusName.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txtShowCusName = new GridBagConstraints();
		gbc_txtShowCusName.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowCusName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowCusName.gridx = 7;
		gbc_txtShowCusName.gridy = 0;
		topShowPanel.add(txtShowCusName, gbc_txtShowCusName);
		
		lblShowGender = new JLabel("Gender:");
		lblShowGender.setForeground(Color.WHITE);
		lblShowGender.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowGender = new GridBagConstraints();
		gbc_lblShowGender.anchor = GridBagConstraints.EAST;
		gbc_lblShowGender.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowGender.gridx = 0;
		gbc_lblShowGender.gridy = 2;
		topShowPanel.add(lblShowGender, gbc_lblShowGender);
		
		chckbxGender = new JCheckBox("");
		chckbxGender.addChangeListener(this::chckbxGenderStateChanged);
		chckbxGender.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_chckbxGender = new GridBagConstraints();
		gbc_chckbxGender.fill = GridBagConstraints.BOTH;
		gbc_chckbxGender.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGender.gridx = 2;
		gbc_chckbxGender.gridy = 2;
		topShowPanel.add(chckbxGender, gbc_chckbxGender);
		
		txtCusShowGender = new JTextField();
		txtCusShowGender.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtCusShowGender.setColumns(10);
		GridBagConstraints gbc_txtCusShowGender = new GridBagConstraints();
		gbc_txtCusShowGender.insets = new Insets(0, 0, 5, 5);
		gbc_txtCusShowGender.fill = GridBagConstraints.BOTH;
		gbc_txtCusShowGender.gridx = 3;
		gbc_txtCusShowGender.gridy = 2;
		topShowPanel.add(txtCusShowGender, gbc_txtCusShowGender);
		
		lblShowDob = new JLabel("Date of Birth:");
		lblShowDob.setForeground(Color.WHITE);
		lblShowDob.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowDob = new GridBagConstraints();
		gbc_lblShowDob.anchor = GridBagConstraints.EAST;
		gbc_lblShowDob.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowDob.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowDob.gridx = 5;
		gbc_lblShowDob.gridy = 2;
		topShowPanel.add(lblShowDob, gbc_lblShowDob);
		
		dobCusChooser = new JDateChooser();
		dobCusChooser.setForeground(new Color(44, 62, 80));
		dobCusChooser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dobCusChooser.setDateFormatString("yyyy-MM-dd");
		dobCusChooser.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_dobCusChooser = new GridBagConstraints();
		gbc_dobCusChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dobCusChooser.fill = GridBagConstraints.BOTH;
		gbc_dobCusChooser.gridx = 7;
		gbc_dobCusChooser.gridy = 2;
		topShowPanel.add(dobCusChooser, gbc_dobCusChooser);
		showCusPanel.setLayout(gl_showCusPanel);
		
		addCusPanel = new JPanel();
		addCusPanel.setBackground(new Color(44, 62, 80));
		detailPanel.add(addCusPanel, "add_cus");
		
		addPicturePanel = new JPanel();
		addPicturePanel.setBackground(new Color(44, 62, 80));
		
		topAddPanel = new JPanel();
		topAddPanel.setBackground(new Color(44, 62, 80));
		
		centerAddPanel = new JPanel();
		centerAddPanel.setBackground(new Color(44, 62, 80));
		GroupLayout gl_addCusPanel = new GroupLayout(addCusPanel);
		gl_addCusPanel.setHorizontalGroup(
			gl_addCusPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_addCusPanel.createSequentialGroup()
					.addComponent(addPicturePanel, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_addCusPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(centerAddPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(topAddPanel, GroupLayout.PREFERRED_SIZE, 675, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_addCusPanel.setVerticalGroup(
			gl_addCusPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_addCusPanel.createSequentialGroup()
					.addGroup(gl_addCusPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(addPicturePanel, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
						.addGroup(gl_addCusPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(topAddPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centerAddPanel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)))
					.addContainerGap())
		);
		GridBagLayout gbl_centerAddPanel = new GridBagLayout();
		gbl_centerAddPanel.columnWidths = new int[]{0, 10, 0, 0};
		gbl_centerAddPanel.rowHeights = new int[]{0, 25, 0, 25, 0, 0, 0};
		gbl_centerAddPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_centerAddPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		centerAddPanel.setLayout(gbl_centerAddPanel);
		
		lblAddPhoneNum = new JLabel("Phone Number:");
		lblAddPhoneNum.setForeground(new Color(255, 255, 255));
		lblAddPhoneNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddPhoneNum = new GridBagConstraints();
		gbc_lblAddPhoneNum.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddPhoneNum.anchor = GridBagConstraints.EAST;
		gbc_lblAddPhoneNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddPhoneNum.gridx = 0;
		gbc_lblAddPhoneNum.gridy = 0;
		centerAddPanel.add(lblAddPhoneNum, gbc_lblAddPhoneNum);
		
		txtAddCusPhoneNum = new JTextField();
		txtAddCusPhoneNum.setForeground(new Color(44, 62, 80));
		txtAddCusPhoneNum.setBackground(new Color(255, 255, 255));
		txtAddCusPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_txtAddCusPhoneNum = new GridBagConstraints();
		gbc_txtAddCusPhoneNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddCusPhoneNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddCusPhoneNum.gridx = 2;
		gbc_txtAddCusPhoneNum.gridy = 0;
		centerAddPanel.add(txtAddCusPhoneNum, gbc_txtAddCusPhoneNum);
		txtAddCusPhoneNum.setColumns(10);
		
		lblAddIdCardNum = new JLabel("ID Card Number:");
		lblAddIdCardNum.setForeground(new Color(255, 255, 255));
		lblAddIdCardNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddIdCardNum = new GridBagConstraints();
		gbc_lblAddIdCardNum.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddIdCardNum.anchor = GridBagConstraints.EAST;
		gbc_lblAddIdCardNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddIdCardNum.gridx = 0;
		gbc_lblAddIdCardNum.gridy = 2;
		centerAddPanel.add(lblAddIdCardNum, gbc_lblAddIdCardNum);
		
		txtAddCusIdCardNum = new JTextField();
		txtAddCusIdCardNum.setForeground(new Color(44, 62, 80));
		txtAddCusIdCardNum.setBackground(new Color(255, 255, 255));
		txtAddCusIdCardNum.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_txtAddCusIdCardNum = new GridBagConstraints();
		gbc_txtAddCusIdCardNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddCusIdCardNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddCusIdCardNum.gridx = 2;
		gbc_txtAddCusIdCardNum.gridy = 2;
		centerAddPanel.add(txtAddCusIdCardNum, gbc_txtAddCusIdCardNum);
		txtAddCusIdCardNum.setColumns(10);
		
		lblAddAddress = new JLabel("Address:");
		lblAddAddress.setForeground(new Color(255, 255, 255));
		lblAddAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddAddress = new GridBagConstraints();
		gbc_lblAddAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddAddress.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddAddress.gridx = 0;
		gbc_lblAddAddress.gridy = 4;
		centerAddPanel.add(lblAddAddress, gbc_lblAddAddress);
		
		addScrollPane = new JScrollPane();
		GridBagConstraints gbc_addScrollPane = new GridBagConstraints();
		gbc_addScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_addScrollPane.fill = GridBagConstraints.BOTH;
		gbc_addScrollPane.gridx = 2;
		gbc_addScrollPane.gridy = 4;
		centerAddPanel.add(addScrollPane, gbc_addScrollPane);
		
		textAreaAddAddress = new JTextArea();
		textAreaAddAddress.setForeground(new Color(44, 62, 80));
		textAreaAddAddress.setTabSize(10);
		textAreaAddAddress.setSelectionColor(new Color(156, 204, 101));
		textAreaAddAddress.setSelectedTextColor(new Color(61, 75, 89));
		textAreaAddAddress.setRows(8);
		textAreaAddAddress.setLineWrap(true);
		textAreaAddAddress.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textAreaAddAddress.setBackground(new Color(255, 255, 255));
		addScrollPane.setViewportView(textAreaAddAddress);
		GridBagLayout gbl_topAddPanel = new GridBagLayout();
		gbl_topAddPanel.columnWidths = new int[]{0, 10, 17, 106, 30, 0, 10, 0, 0};
		gbl_topAddPanel.rowHeights = new int[]{0, 25, 0, 25, 0};
		gbl_topAddPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_topAddPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		topAddPanel.setLayout(gbl_topAddPanel);
		
		lblAddId = new JLabel("ID:");
		lblAddId.setForeground(new Color(255, 255, 255));
		lblAddId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddId = new GridBagConstraints();
		gbc_lblAddId.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddId.anchor = GridBagConstraints.EAST;
		gbc_lblAddId.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddId.gridx = 0;
		gbc_lblAddId.gridy = 0;
		topAddPanel.add(lblAddId, gbc_lblAddId);
		
		txtAddCusId = new JTextField();
		txtAddCusId.setEditable(false);
		txtAddCusId.setForeground(new Color(44, 62, 80));
		txtAddCusId.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtAddCusId.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txtAddCusId = new GridBagConstraints();
		gbc_txtAddCusId.gridwidth = 2;
		gbc_txtAddCusId.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddCusId.fill = GridBagConstraints.BOTH;
		gbc_txtAddCusId.gridx = 2;
		gbc_txtAddCusId.gridy = 0;
		topAddPanel.add(txtAddCusId, gbc_txtAddCusId);
		txtAddCusId.setColumns(10);
		
		lblAddFullName = new JLabel("Full Name:");
		lblAddFullName.setForeground(new Color(255, 255, 255));
		lblAddFullName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddFullName = new GridBagConstraints();
		gbc_lblAddFullName.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddFullName.anchor = GridBagConstraints.EAST;
		gbc_lblAddFullName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddFullName.gridx = 5;
		gbc_lblAddFullName.gridy = 0;
		topAddPanel.add(lblAddFullName, gbc_lblAddFullName);
		
		txtAddCusFullName = new JTextField();
		txtAddCusFullName.setForeground(new Color(44, 62, 80));
		txtAddCusFullName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtAddCusFullName.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txtAddCusFullName = new GridBagConstraints();
		gbc_txtAddCusFullName.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddCusFullName.fill = GridBagConstraints.BOTH;
		gbc_txtAddCusFullName.gridx = 7;
		gbc_txtAddCusFullName.gridy = 0;
		topAddPanel.add(txtAddCusFullName, gbc_txtAddCusFullName);
		txtAddCusFullName.setColumns(10);
		
		lblAddGender = new JLabel("Gender:");
		lblAddGender.setForeground(new Color(255, 255, 255));
		lblAddGender.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddGender = new GridBagConstraints();
		gbc_lblAddGender.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddGender.anchor = GridBagConstraints.EAST;
		gbc_lblAddGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddGender.gridx = 0;
		gbc_lblAddGender.gridy = 2;
		topAddPanel.add(lblAddGender, gbc_lblAddGender);
		
		chckbxAddGender = new JCheckBox("");
		chckbxAddGender.addChangeListener(this::chckbxAddGenderStateChanged);
		chckbxAddGender.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_chckbxAddGender = new GridBagConstraints();
		gbc_chckbxAddGender.fill = GridBagConstraints.BOTH;
		gbc_chckbxAddGender.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAddGender.gridx = 2;
		gbc_chckbxAddGender.gridy = 2;
		topAddPanel.add(chckbxAddGender, gbc_chckbxAddGender);
		
		txtAddGender = new JTextField();
		txtAddGender.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtAddGender.setColumns(10);
		GridBagConstraints gbc_txtAddGender = new GridBagConstraints();
		gbc_txtAddGender.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddGender.gridx = 3;
		gbc_txtAddGender.gridy = 2;
		topAddPanel.add(txtAddGender, gbc_txtAddGender);
		
		lblAddDob = new JLabel("Date of Birth:");
		lblAddDob.setForeground(new Color(255, 255, 255));
		lblAddDob.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddDob = new GridBagConstraints();
		gbc_lblAddDob.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddDob.anchor = GridBagConstraints.EAST;
		gbc_lblAddDob.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddDob.gridx = 5;
		gbc_lblAddDob.gridy = 2;
		topAddPanel.add(lblAddDob, gbc_lblAddDob);
		
		addDobChooser = new JDateChooser();
		addDobChooser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		addDobChooser.setDateFormatString("yyyy/MM/dd");
		addDobChooser.setForeground(new Color(44, 62, 80));
		addDobChooser.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_addDobChooser = new GridBagConstraints();
		gbc_addDobChooser.insets = new Insets(0, 0, 5, 0);
		gbc_addDobChooser.fill = GridBagConstraints.BOTH;
		gbc_addDobChooser.gridx = 7;
		gbc_addDobChooser.gridy = 2;
		topAddPanel.add(addDobChooser, gbc_addDobChooser);
		
		lblAddPicture = new JLabel("");
		lblAddPicture.setOpaque(true);
		lblAddPicture.setBackground(new Color(44, 62, 80));
		
		btnChoosePicture = new JButton("Choose a picture");
		btnChoosePicture.addActionListener(this::btnChoosePictureActionPerformed);
		btnChoosePicture.setForeground(new Color(44, 62, 80));
		btnChoosePicture.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnChoosePicture.setBackground(new Color(240, 240, 240));
		GroupLayout gl_addPicturePanel = new GroupLayout(addPicturePanel);
		gl_addPicturePanel.setHorizontalGroup(
			gl_addPicturePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblAddPicture, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
				.addGroup(gl_addPicturePanel.createSequentialGroup()
					.addGap(99)
					.addComponent(btnChoosePicture)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		gl_addPicturePanel.setVerticalGroup(
			gl_addPicturePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addPicturePanel.createSequentialGroup()
					.addComponent(lblAddPicture, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnChoosePicture)
					.addGap(13))
		);
		addPicturePanel.setLayout(gl_addPicturePanel);
		addCusPanel.setLayout(gl_addCusPanel);
		applicationPanel.setLayout(gl_applicationPanel);
		centerPanel.setLayout(gl_centerPanel);
		
//		---------------------------------------------------------------------------------
		loadCus();
		showCusTable.setSurrendersFocusOnKeystroke(true);
		showCusTable.setAutoCreateRowSorter(true);
		var centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.LEFT);
		showCusTable.setDefaultRenderer(Object.class, centerRenderer);
	}
	
	// Hiển thị panel (Add customer)
	protected void btnAddCusActionPerformed(ActionEvent e) {
		var cp = (CardLayout)detailPanel.getLayout();
		cp.show(detailPanel, "add_cus");
	}
	
	protected void btnDeleteCusActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Are you sure you want to do this?");
		var dao = new CustomerDAO();
		var cus = new Customer();
		try {
			cus.setCus_id(Integer.parseInt(txtShowCusId.getText()));
			
			dao.deleteCustomer(cus);
			
			JOptionPane.showMessageDialog(null, "Deleted");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "You have to select a customer");
		}
		loadCus();
	}
	
	// Xổ thông tin từ tbl_customer ra bảng
	public void loadCus() {
		var LC_model = new DefaultTableModel() {
			@Override
			public Class getColumnClass(int column){
				switch (column) {
				case 0: return Integer.class;	// ID
				case 1: return String.class;	// Name
				case 2: return String.class;	// DOB
				case 3: return Boolean.class;	// Gender
				case 4: return String.class;	// ID card number
				case 5: return String.class;	// Phone number
				case 6: return String.class;	// Country
				case 7: return ImageIcon.class;	// Picture
				default:return String.class;
				}
			}
			
			@Override
			public boolean isCellEditable(int row, int col) {
				switch (col) {
				case 7: return false;
				default:return true;
				}
			}
		};
		
		LC_model.addColumn("ID");
		LC_model.addColumn("Name");
		LC_model.addColumn("Date of birth");
		LC_model.addColumn("Gender");
		LC_model.addColumn("ID card number");
		LC_model.addColumn("Phone number");
		LC_model.addColumn("Country");
		LC_model.addColumn("Picture");
		var cus_dao = new CustomerDAO();
		
		cus_dao.getListCustomer().forEach(
			cus->LC_model.addRow(new Object[] {
				cus.getCus_id(), cus.getCus_fullname(), cus.getCus_dob(), cus.isGender(), cus.getCus_IDNo(), cus.getCus_contactNo(), 
				cus.getCus_address(), new ImageIcon(new ImageIcon(cus.getCus_picture()).getImage()
					.getScaledInstance(120, 600, Image.SCALE_SMOOTH))
			})
		);
		
		showCusTable.setModel(LC_model);
		
		showCusTable.getColumnModel().getColumn(0).setMinWidth(0);
		showCusTable.getColumnModel().getColumn(0).setMaxWidth(0);
		showCusTable.getColumnModel().getColumn(0).setPreferredWidth(0);
		
		showCusTable.getColumnModel().getColumn(2).setMinWidth(0);
		showCusTable.getColumnModel().getColumn(2).setMaxWidth(0);
		showCusTable.getColumnModel().getColumn(2).setPreferredWidth(0);
		
		showCusTable.getColumnModel().getColumn(3).setMinWidth(0);
		showCusTable.getColumnModel().getColumn(3).setMaxWidth(0);
		showCusTable.getColumnModel().getColumn(3).setPreferredWidth(0);
		
		showCusTable.getColumnModel().getColumn(4).setMinWidth(0);
		showCusTable.getColumnModel().getColumn(4).setMaxWidth(0);
		showCusTable.getColumnModel().getColumn(4).setPreferredWidth(0);
		
		showCusTable.getColumnModel().getColumn(5).setMinWidth(0);
		showCusTable.getColumnModel().getColumn(5).setMaxWidth(0);
		showCusTable.getColumnModel().getColumn(5).setPreferredWidth(0);
		
		showCusTable.getColumnModel().getColumn(6).setMinWidth(0);
		showCusTable.getColumnModel().getColumn(6).setMaxWidth(0);
		showCusTable.getColumnModel().getColumn(6).setPreferredWidth(0);
		
		showCusTable.getColumnModel().getColumn(7).setMinWidth(0);
		showCusTable.getColumnModel().getColumn(7).setMaxWidth(0);
		showCusTable.getColumnModel().getColumn(7).setPreferredWidth(0);
	}
	
	// ----------------------------------- SHOW -------------------------------------------
	
	// Chọn bảng -> Xổ thông tin ra (SHOW)
	protected void showCusTableMouseClicked(MouseEvent e) {
		var cp = (CardLayout)detailPanel.getLayout();
		cp.show(detailPanel, "show_cus");
		
		int rowIndex = showCusTable.getSelectedRow();
		
		try {
			txtShowCusId.setText(showCusTable.getValueAt(rowIndex, 0).toString());
			txtShowCusName.setText(showCusTable.getValueAt(rowIndex, 1).toString());
			try {
				dobCusChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(showCusTable.getValueAt(rowIndex, 2).toString()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			chckbxGender.setSelected(showCusTable.getValueAt(rowIndex, 3).toString().equals("true")?true:false);
			txtShowCusIdCardNum.setText(showCusTable.getValueAt(rowIndex, 4).toString());
			txtShowCusPhoneNum.setText(showCusTable.getValueAt(rowIndex, 5).toString());
			textAreaShowAddress.setText(showCusTable.getValueAt(rowIndex, 6).toString());
			lblShowPicture.setIcon(new ImageIcon(((ImageIcon)showCusTable.getValueAt(rowIndex, 7))
				.getImage().getScaledInstance(342, 471, Image.SCALE_SMOOTH)));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Missing data, please check again");
		}
	}
	
	// Check vào box Gender (Male/Female) (SHOW)
	protected void chckbxGenderStateChanged(ChangeEvent e) {
		if (chckbxGender.isSelected()) {
			txtCusShowGender.setText("Male");
		} else {
			txtCusShowGender.setText("Female");
		}
	}
	
	// Lưu thông tin vào Database sau khi sửa thông tin Customer (EDIT)
	protected void btnSaveEditActionPerformed(ActionEvent e) {
		var cus = new Customer();
		var dao = new CustomerDAO();
		try {
			cus.setCus_fullname(txtShowCusName.getText());
			cus.setCus_dob(LocalDate.ofInstant(dobCusChooser.getDate().toInstant(), ZoneId.systemDefault()));
			cus.setGender(chckbxGender.isSelected());
			cus.setCus_IDNo(txtShowCusIdCardNum.getText());
			cus.setCus_contactNo(txtShowCusPhoneNum.getText());
			cus.setCus_address(textAreaShowAddress.getText());
			if(fileName!=null) {
				driveAfter = System.getProperty("user.dir") + "\\images";
				var pathBefore = Paths.get(driveBefore);
				var pathAfter = Paths.get(driveAfter);
				try {
					Files.copy(pathBefore, pathAfter.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				cus.setCus_picture("images/" + fileName);
			} else {
				cus.setCus_picture(fileBefore);
			}
			cus.setCus_id(Integer.parseInt(txtShowCusId.getText()));
			
			dao.updateCustomer(cus);
			
			JOptionPane.showMessageDialog(null, "Edit successful");
			
		} catch (Exception e2) {
			if(lblShowPicture.getIcon()==null) {
				JOptionPane.showMessageDialog(null, "Please add a picture");
			}
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
		lblShowPicture.setIcon(null);
		dobCusChooser.setDate(null);
		txtCusShowGender.setText(null);
		txtShowCusId.setText(null);
		txtShowCusIdCardNum.setText(null);
		txtShowCusName.setText(null);
		txtShowCusPhoneNum.setText(null);
		textAreaShowAddress.setText(null);
		
		loadCus();
	}
	
	// Chọn nút để thay đổi hình và lưu vào Database (EDIT)
	protected void btnEditPictureActionPerformed(ActionEvent e) {
//		var chooser = new JFileChooser(System.getProperty("user.home") + "\\pictures");
		var chooser = new JFileChooser("C:\\Users\\quang\\Hình ảnh");
		chooser.setDialogTitle("Open image");
		chooser.setFileFilter(new FileNameExtensionFilter("image (jpg, png)", "jpg", "png"));
		chooser.setAcceptAllFileFilterUsed(false);
		var result = chooser.showOpenDialog(null);
		if(result==JFileChooser.APPROVE_OPTION) {
			var f = chooser.getSelectedFile();
			fileName = f.getName();
			driveBefore = f.getAbsolutePath();
			lblShowPicture.setIcon(new ImageIcon(new ImageIcon(f.getAbsolutePath()).getImage()
				.getScaledInstance(342, 471, Image.SCALE_SMOOTH)));
		}
	}
	
	
	// ----------------------------------- ADD -------------------------------------------
	
	// Lưu thông tin vào Database sau khi thêm thông tin Customer (ADD)
	protected void btnSaveAddActionPerformed(ActionEvent e) {
		var dao = new CustomerDAO();
		var cus = new Customer();
		try {
			cus.setCus_fullname(txtAddCusFullName.getText());
			cus.setCus_dob(LocalDate.ofInstant(addDobChooser.getDate().toInstant(), ZoneId.systemDefault()));
			cus.setGender(chckbxGender.isSelected());
			cus.setCus_IDNo(txtAddCusIdCardNum.getText());
			cus.setCus_contactNo(txtAddCusPhoneNum.getText());
			cus.setCus_address(textAreaAddAddress.getText());
				
			var image = new BufferedImage(lblAddPicture.getWidth(), lblAddPicture.getHeight(), BufferedImage.TYPE_INT_RGB);
			var g2d = image.createGraphics();
			lblAddPicture.printAll(g2d);
			g2d.dispose();
			
			var fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

			if (fileName!=null) {
				var imagesDirectory = new File("images");
				if (!imagesDirectory.exists()) {
					imagesDirectory.mkdir();
				} try {
					var outputFile = new File(imagesDirectory, fileName);
					ImageIO.write(image, "png", outputFile);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					cus.setCus_picture("images/" + fileName);
			} else {
				cus.setCus_picture("images/room.jpg");
			}
			dao.insertCustomer(cus);
			JOptionPane.showMessageDialog(null, "Add successful");
			
		} catch (Exception e2) {
			if(lblAddPicture.getIcon()==null) {
				JOptionPane.showMessageDialog(null, "Please add a picture");
			}
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
		lblAddPicture.setIcon(null);
		txtAddCusFullName.setText(null);
		txtAddCusId.setText(null);
		txtAddCusIdCardNum.setText(null);
		txtAddCusPhoneNum.setText(null);
		txtAddGender.setText(null);
		addDobChooser.setDate(null);
		textAreaAddAddress.setText(null);
		
		loadCus();
	}
		
	// Check vào box Gender (Male/Female) (ADD)
	protected void chckbxAddGenderStateChanged(ChangeEvent e) {
		if (chckbxAddGender.isSelected()) {
			txtAddGender.setText("Male");
		} else {
			txtAddGender.setText("Female");
		}
	}
	
	// Chọn nút để thay đổi hình và lưu vào Database (ADD)
	protected void btnChoosePictureActionPerformed(ActionEvent e) {
		var chooser = new JFileChooser("C:\\Users\\quang\\Hình ảnh");
//		var chooser = new JFileChooser(System.getProperty("user.home")+ "\\pictures");
		chooser.setDialogTitle("Open image");
		chooser.setFileFilter(new FileNameExtensionFilter("image (jpg, png)", "jpg", "png"));
		chooser.setAcceptAllFileFilterUsed(false);
		var result = chooser.showOpenDialog(null);
		if(result==JFileChooser.APPROVE_OPTION) {
			var f = chooser.getSelectedFile();
			fileName = f.getName();
			driveBefore = f.getAbsolutePath();
			lblAddPicture.setIcon(new ImageIcon(new ImageIcon(f.getAbsolutePath()).getImage()
				.getScaledInstance(342, 471, Image.SCALE_SMOOTH)));
		}
	}
	
}
