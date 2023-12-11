package managerGUI;

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

import dao.ManagerDAO;
import entity.Manager;

public class Mng_ManagerLayout extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel headPanel;
	private JPanel sidePanel;
	private JPanel centerPanel;
	private JPanel headInfo;
	private JLabel lblCategory;
	private JPanel infoPanel;
	private JScrollPane scrollPane;
	private JPanel applicationPanel;
	private JPanel buttonPanel;
	private JButton btnAddMng;
	private JButton btnSaveEdit;
	private JButton btnDeleteMng;
	private JPanel detailPanel;
	private JLabel lblFooterBrand;
	private JPanel showManagerPanel;
	private JPanel addManagerPanel;
	private JPanel topInfoPanel;
	private JPanel centerInfoPanel;
	private JLabel lblShowId;
	private JLabel lblShowName;
	private JLabel lblShowGender;
	private JLabel lblShowDob;
	private JLabel lblShowPhoneNum;
	private JLabel lblShowIdCardNum;
	private JLabel lblShowPosition;
	private JLabel lblShowDayIn;
	private JButton btnChoosePicture;
	private JPanel topAddPanel;
	private JPanel centerAddPanel;
	private JPanel addPicturePanel;
	private JLabel lblAddPicture;
	private JLabel lblAddGender;
	private JLabel lblAddDob;
	private JLabel lblAddName;
	private JTextField txtAddFullName;
	private JLabel lblAddPhoneNum;
	private JLabel lblAddPosition;
	private JLabel lblAddIdCardNum;
	private JLabel lblAddDayIn;
	private JTextField txtAddPhoneNum;
	private JTextField txtAddIdCardNum;
	private JPanel showPicturePanel;
	private JTable showMngTable;
	private JLabel lblShowAddress;
	private JDateChooser addDob;
	private JLabel lblAddAddress;
	private JScrollPane showScrollPane;
	private JTextArea textAreaShowAddress;
	private JScrollPane addScrollPane;
	private JTextArea textAreaAddAddress;
	private JComboBox cbbAddPosition;
	private JDateChooser addDayIn;
	private JDateChooser showDob;
	private JCheckBox chckbxShowGender;
	private JTextField txtShowGender;
	private JDateChooser showDayIn;
	private String fileName = null;
	private String driveAfter = null;
	private String driveBefore = null;
	private String fileBefore = null;
	private JButton btnSaveAdd;
	private JCheckBox chckbxAddGender;
	private JTextField txtAddGender;
	private JLabel lblShowPicture;
	private JTextField txtShowPhoneNum;
	private JTextField txtShowIdCardNum;
	private JTextField txtShowName;
	private JTextField txtShowPosition;
	private JButton btnEditPicture;
	private JTextField txtShowId;

	public Mng_ManagerLayout() {
		setLayout(new BorderLayout(0, 0));
		
		headPanel = new JPanel();
		headPanel.setBackground(new Color(255, 253, 231));
		add(headPanel, BorderLayout.NORTH);
		
		headInfo = new JPanel();
		headInfo.setBackground(new Color(44, 62, 80));
		
		lblCategory = new JLabel("M A N A G E R");
		lblCategory.setForeground(new Color(156, 204, 101));
		lblCategory.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_headInfo = new GroupLayout(headInfo);
		gl_headInfo.setHorizontalGroup(
			gl_headInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headInfo.createSequentialGroup()
					.addGap(572)
					.addComponent(lblCategory)
					.addContainerGap(571, Short.MAX_VALUE))
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
				.addGroup(gl_headPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(headInfo, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
		);
		gl_infoPanel.setVerticalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
		);
		
		showMngTable = new JTable();
		showMngTable.setFillsViewportHeight(true);
		showMngTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showMngTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showMngTableMouseClicked(e);
			}
		});
		showMngTable.setRowHeight(30);
		showMngTable.setShowHorizontalLines(true);
		showMngTable.setBackground(new Color(255, 255, 255));
		showMngTable.setForeground(new Color(44, 62, 80));
		showMngTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setViewportView(showMngTable);
		infoPanel.setLayout(gl_infoPanel);
		GroupLayout gl_sidePanel = new GroupLayout(sidePanel);
		gl_sidePanel.setHorizontalGroup(
			gl_sidePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_sidePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
		);
		gl_sidePanel.setVerticalGroup(
			gl_sidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sidePanel.createSequentialGroup()
					.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
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
					.addComponent(applicationPanel, GroupLayout.PREFERRED_SIZE, 1026, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_centerPanel.setVerticalGroup(
			gl_centerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_centerPanel.createSequentialGroup()
					.addComponent(applicationPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(44, 62, 80));
		
		btnAddMng = new JButton("Add Manager");
		btnAddMng.addActionListener(this::btnAddMngActionPerformed);
		btnAddMng.setForeground(new Color(44, 62, 80));
		btnAddMng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		btnSaveEdit = new JButton("Save Edit");
		btnSaveEdit.addActionListener(e -> btnSaveEditActionPerformed(e));
		btnSaveEdit.setForeground(new Color(44, 62, 80));
		btnSaveEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		btnDeleteMng = new JButton("Delete Manager");
		btnDeleteMng.addActionListener(this::btnDeleteMngActionPerformed);
		btnDeleteMng.setForeground(new Color(44, 62, 80));
		btnDeleteMng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		btnSaveAdd = new JButton("Save Add");
		btnSaveAdd.addActionListener(this::btnSaveAddActionPerformed);
		btnSaveAdd.setForeground(new Color(44, 62, 80));
		btnSaveAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
		gl_buttonPanel.setHorizontalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAddMng, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addGap(50)
					.addComponent(btnSaveAdd, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addGap(55)
					.addComponent(btnSaveEdit, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addGap(50)
					.addComponent(btnDeleteMng, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_buttonPanel.setVerticalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_buttonPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeleteMng, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSaveEdit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddMng, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSaveAdd, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
					.addGap(7))
		);
		buttonPanel.setLayout(gl_buttonPanel);
		
		detailPanel = new JPanel();
		detailPanel.setBackground(new Color(44, 62, 80));
		
		lblFooterBrand = new JLabel("Copyright © 2023 Green Home. All rights reserved.");
		lblFooterBrand.setForeground(new Color(156, 204, 101));
		lblFooterBrand.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		GroupLayout gl_applicationPanel = new GroupLayout(applicationPanel);
		gl_applicationPanel.setHorizontalGroup(
			gl_applicationPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_applicationPanel.createSequentialGroup()
					.addGroup(gl_applicationPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_applicationPanel.createSequentialGroup()
							.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFooterBrand, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
						.addComponent(detailPanel, GroupLayout.PREFERRED_SIZE, 1023, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_applicationPanel.setVerticalGroup(
			gl_applicationPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_applicationPanel.createSequentialGroup()
					.addComponent(detailPanel, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
					.addGroup(gl_applicationPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_applicationPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_applicationPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFooterBrand, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
		);
		detailPanel.setLayout(new CardLayout(0, 0));
		
		showManagerPanel = new JPanel();
		showManagerPanel.setBackground(new Color(44, 62, 80));
		detailPanel.add(showManagerPanel, "show_Mng");
		
		topInfoPanel = new JPanel();
		topInfoPanel.setBackground(new Color(44, 62, 80));
		
		centerInfoPanel = new JPanel();
		centerInfoPanel.setBackground(new Color(44, 62, 80));
		
		showPicturePanel = new JPanel();
		showPicturePanel.setBackground(new Color(44, 62, 80));
		GroupLayout gl_showManagerPanel = new GroupLayout(showManagerPanel);
		gl_showManagerPanel.setHorizontalGroup(
			gl_showManagerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_showManagerPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(showPicturePanel, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_showManagerPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(topInfoPanel, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
						.addComponent(centerInfoPanel, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_showManagerPanel.setVerticalGroup(
			gl_showManagerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_showManagerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_showManagerPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(showPicturePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addGroup(gl_showManagerPanel.createSequentialGroup()
							.addComponent(topInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centerInfoPanel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
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
				.addComponent(lblShowPicture, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
				.addGroup(gl_showPicturePanel.createSequentialGroup()
					.addGap(107)
					.addComponent(btnEditPicture)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_showPicturePanel.setVerticalGroup(
			gl_showPicturePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_showPicturePanel.createSequentialGroup()
					.addComponent(lblShowPicture, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnEditPicture)
					.addContainerGap())
		);
		showPicturePanel.setLayout(gl_showPicturePanel);
		GridBagLayout gbl_centerInfoPanel = new GridBagLayout();
		gbl_centerInfoPanel.columnWidths = new int[]{0, 10, 48, 0};
		gbl_centerInfoPanel.rowHeights = new int[]{40, 25, 40, 25, 40, 25, 40, 25, 0, 0};
		gbl_centerInfoPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_centerInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		centerInfoPanel.setLayout(gbl_centerInfoPanel);
		
		lblShowPhoneNum = new JLabel("Phone Number:");
		lblShowPhoneNum.setForeground(Color.WHITE);
		lblShowPhoneNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowPhoneNum = new GridBagConstraints();
		gbc_lblShowPhoneNum.anchor = GridBagConstraints.EAST;
		gbc_lblShowPhoneNum.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowPhoneNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowPhoneNum.gridx = 0;
		gbc_lblShowPhoneNum.gridy = 0;
		centerInfoPanel.add(lblShowPhoneNum, gbc_lblShowPhoneNum);
		
		txtShowPhoneNum = new JTextField();
		txtShowPhoneNum.setBackground(new Color(255, 255, 255));
		txtShowPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtShowPhoneNum.setForeground(new Color(44, 62, 80));
		GridBagConstraints gbc_txtShowPhoneNum = new GridBagConstraints();
		gbc_txtShowPhoneNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowPhoneNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowPhoneNum.gridx = 2;
		gbc_txtShowPhoneNum.gridy = 0;
		centerInfoPanel.add(txtShowPhoneNum, gbc_txtShowPhoneNum);
		txtShowPhoneNum.setColumns(10);
		
		lblShowPosition = new JLabel("Position:");
		lblShowPosition.setForeground(Color.WHITE);
		lblShowPosition.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowPosition = new GridBagConstraints();
		gbc_lblShowPosition.anchor = GridBagConstraints.EAST;
		gbc_lblShowPosition.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowPosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowPosition.gridx = 0;
		gbc_lblShowPosition.gridy = 2;
		centerInfoPanel.add(lblShowPosition, gbc_lblShowPosition);
		
		txtShowPosition = new JTextField();
		txtShowPosition.setForeground(new Color(44, 62, 80));
		txtShowPosition.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtShowPosition.setColumns(10);
		txtShowPosition.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txtShowPosition = new GridBagConstraints();
		gbc_txtShowPosition.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowPosition.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowPosition.gridx = 2;
		gbc_txtShowPosition.gridy = 2;
		centerInfoPanel.add(txtShowPosition, gbc_txtShowPosition);
		
		lblShowIdCardNum = new JLabel("ID Card Number:");
		lblShowIdCardNum.setForeground(Color.WHITE);
		lblShowIdCardNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowIdCardNum = new GridBagConstraints();
		gbc_lblShowIdCardNum.anchor = GridBagConstraints.EAST;
		gbc_lblShowIdCardNum.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowIdCardNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowIdCardNum.gridx = 0;
		gbc_lblShowIdCardNum.gridy = 4;
		centerInfoPanel.add(lblShowIdCardNum, gbc_lblShowIdCardNum);
		
		txtShowIdCardNum = new JTextField();
		txtShowIdCardNum.setBackground(new Color(255, 255, 255));
		txtShowIdCardNum.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtShowIdCardNum.setForeground(new Color(44, 62, 80));
		GridBagConstraints gbc_txtShowIdCardNum = new GridBagConstraints();
		gbc_txtShowIdCardNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowIdCardNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowIdCardNum.gridx = 2;
		gbc_txtShowIdCardNum.gridy = 4;
		centerInfoPanel.add(txtShowIdCardNum, gbc_txtShowIdCardNum);
		txtShowIdCardNum.setColumns(10);
		
		lblShowDayIn = new JLabel("Day In:");
		lblShowDayIn.setForeground(Color.WHITE);
		lblShowDayIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowDayIn = new GridBagConstraints();
		gbc_lblShowDayIn.anchor = GridBagConstraints.EAST;
		gbc_lblShowDayIn.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowDayIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowDayIn.gridx = 0;
		gbc_lblShowDayIn.gridy = 6;
		centerInfoPanel.add(lblShowDayIn, gbc_lblShowDayIn);
		
		showDayIn = new JDateChooser();
		showDayIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showDayIn.setForeground(new Color(44, 62, 80));
		showDayIn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		showDayIn.setDateFormatString("yyyy-MM-dd");
		showDayIn.setBackground(new Color(44, 62, 80));
		GridBagConstraints gbc_showDayIn = new GridBagConstraints();
		gbc_showDayIn.insets = new Insets(0, 0, 5, 0);
		gbc_showDayIn.fill = GridBagConstraints.BOTH;
		gbc_showDayIn.gridx = 2;
		gbc_showDayIn.gridy = 6;
		centerInfoPanel.add(showDayIn, gbc_showDayIn);
		
		lblShowAddress = new JLabel("Address:");
		lblShowAddress.setForeground(new Color(255, 255, 255));
		lblShowAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowAddress = new GridBagConstraints();
		gbc_lblShowAddress.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowAddress.anchor = GridBagConstraints.EAST;
		gbc_lblShowAddress.insets = new Insets(0, 0, 0, 5);
		gbc_lblShowAddress.gridx = 0;
		gbc_lblShowAddress.gridy = 8;
		centerInfoPanel.add(lblShowAddress, gbc_lblShowAddress);
		
		showScrollPane = new JScrollPane();
		GridBagConstraints gbc_showScrollPane = new GridBagConstraints();
		gbc_showScrollPane.fill = GridBagConstraints.BOTH;
		gbc_showScrollPane.gridx = 2;
		gbc_showScrollPane.gridy = 8;
		centerInfoPanel.add(showScrollPane, gbc_showScrollPane);
		
		textAreaShowAddress = new JTextArea();
		textAreaShowAddress.setForeground(new Color(44, 62, 80));
		textAreaShowAddress.setTabSize(10);
		textAreaShowAddress.setRows(3);
		textAreaShowAddress.setLineWrap(true);
		textAreaShowAddress.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textAreaShowAddress.setBackground(new Color(255, 255, 255));
		showScrollPane.setViewportView(textAreaShowAddress);
		GridBagLayout gbl_topInfoPanel = new GridBagLayout();
		gbl_topInfoPanel.columnWidths = new int[]{0, 10, 25, 98, 30, 0, 10, 0, 0};
		gbl_topInfoPanel.rowHeights = new int[]{40, 25, 40, 25, 0};
		gbl_topInfoPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_topInfoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		topInfoPanel.setLayout(gbl_topInfoPanel);
		
		lblShowId = new JLabel("ID:");
		lblShowId.setForeground(Color.WHITE);
		lblShowId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowId = new GridBagConstraints();
		gbc_lblShowId.anchor = GridBagConstraints.EAST;
		gbc_lblShowId.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowId.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowId.gridx = 0;
		gbc_lblShowId.gridy = 0;
		topInfoPanel.add(lblShowId, gbc_lblShowId);
		
		txtShowId = new JTextField();
		txtShowId.setForeground(new Color(44, 62, 80));
		txtShowId.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtShowId.setColumns(10);
		txtShowId.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtShowId = new GridBagConstraints();
		gbc_txtShowId.gridwidth = 2;
		gbc_txtShowId.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowId.gridx = 2;
		gbc_txtShowId.gridy = 0;
		topInfoPanel.add(txtShowId, gbc_txtShowId);
		
		lblShowName = new JLabel("Full Name:");
		lblShowName.setForeground(Color.WHITE);
		lblShowName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowName = new GridBagConstraints();
		gbc_lblShowName.anchor = GridBagConstraints.EAST;
		gbc_lblShowName.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowName.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowName.gridx = 5;
		gbc_lblShowName.gridy = 0;
		topInfoPanel.add(lblShowName, gbc_lblShowName);
		
		txtShowName = new JTextField();
		txtShowName.setBackground(new Color(255, 255, 255));
		txtShowName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtShowName.setForeground(new Color(44, 62, 80));
		GridBagConstraints gbc_txtShowName = new GridBagConstraints();
		gbc_txtShowName.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowName.gridx = 7;
		gbc_txtShowName.gridy = 0;
		topInfoPanel.add(txtShowName, gbc_txtShowName);
		txtShowName.setColumns(10);
		
		lblShowGender = new JLabel("Gender:");
		lblShowGender.setForeground(Color.WHITE);
		lblShowGender.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowGender = new GridBagConstraints();
		gbc_lblShowGender.anchor = GridBagConstraints.EAST;
		gbc_lblShowGender.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowGender.gridx = 0;
		gbc_lblShowGender.gridy = 2;
		topInfoPanel.add(lblShowGender, gbc_lblShowGender);
		
		chckbxShowGender = new JCheckBox("");
		chckbxShowGender.addChangeListener(this::chckbxGenderStateChanged);
		chckbxShowGender.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_chckbxShowGender = new GridBagConstraints();
		gbc_chckbxShowGender.fill = GridBagConstraints.BOTH;
		gbc_chckbxShowGender.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxShowGender.gridx = 2;
		gbc_chckbxShowGender.gridy = 2;
		topInfoPanel.add(chckbxShowGender, gbc_chckbxShowGender);
		
		txtShowGender = new JTextField();
		txtShowGender.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_txtShowGender = new GridBagConstraints();
		gbc_txtShowGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowGender.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowGender.gridx = 3;
		gbc_txtShowGender.gridy = 2;
		topInfoPanel.add(txtShowGender, gbc_txtShowGender);
		txtShowGender.setColumns(10);
		
		lblShowDob = new JLabel("Date of Birth:");
		lblShowDob.setForeground(Color.WHITE);
		lblShowDob.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowDob = new GridBagConstraints();
		gbc_lblShowDob.anchor = GridBagConstraints.EAST;
		gbc_lblShowDob.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowDob.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowDob.gridx = 5;
		gbc_lblShowDob.gridy = 2;
		topInfoPanel.add(lblShowDob, gbc_lblShowDob);
		
		showDob = new JDateChooser();
		showDob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		showDob.setBackground(new Color(44, 62, 80));
		showDob.setForeground(new Color(44, 62, 80));
		showDob.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showDob.setDateFormatString("yyyy-MM-dd");
		GridBagConstraints gbc_showDob = new GridBagConstraints();
		gbc_showDob.insets = new Insets(0, 0, 5, 0);
		gbc_showDob.fill = GridBagConstraints.BOTH;
		gbc_showDob.gridx = 7;
		gbc_showDob.gridy = 2;
		topInfoPanel.add(showDob, gbc_showDob);
		showManagerPanel.setLayout(gl_showManagerPanel);
		
		addManagerPanel = new JPanel();
		addManagerPanel.setBackground(new Color(44, 62, 80));
		detailPanel.add(addManagerPanel, "add_Mng");
		
		topAddPanel = new JPanel();
		topAddPanel.setBackground(new Color(44, 62, 80));
		
		centerAddPanel = new JPanel();
		centerAddPanel.setBackground(new Color(44, 62, 80));
		
		addPicturePanel = new JPanel();
		addPicturePanel.setBackground(new Color(44, 62, 80));
		GroupLayout gl_addManagerPanel = new GroupLayout(addManagerPanel);
		gl_addManagerPanel.setHorizontalGroup(
			gl_addManagerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_addManagerPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(addPicturePanel, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_addManagerPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(topAddPanel, GroupLayout.PREFERRED_SIZE, 654, Short.MAX_VALUE)
						.addComponent(centerAddPanel, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_addManagerPanel.setVerticalGroup(
			gl_addManagerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_addManagerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_addManagerPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(addPicturePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_addManagerPanel.createSequentialGroup()
							.addComponent(topAddPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centerAddPanel, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
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
				.addComponent(lblAddPicture, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
				.addGroup(gl_addPicturePanel.createSequentialGroup()
					.addGap(100)
					.addComponent(btnChoosePicture)
					.addContainerGap(102, Short.MAX_VALUE))
		);
		gl_addPicturePanel.setVerticalGroup(
			gl_addPicturePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_addPicturePanel.createSequentialGroup()
					.addComponent(lblAddPicture, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
					.addGap(17)
					.addComponent(btnChoosePicture)
					.addContainerGap())
		);
		addPicturePanel.setLayout(gl_addPicturePanel);
		GridBagLayout gbl_centerAddPanel = new GridBagLayout();
		gbl_centerAddPanel.columnWidths = new int[]{0, 10, 0, 0};
		gbl_centerAddPanel.rowHeights = new int[]{40, 25, 40, 25, 40, 25, 40, 25, 0, 0};
		gbl_centerAddPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_centerAddPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		txtAddPhoneNum = new JTextField();
		txtAddPhoneNum.setForeground(new Color(44, 62, 80));
		txtAddPhoneNum.setBackground(new Color(255, 255, 255));
		txtAddPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_txtAddPhoneNum = new GridBagConstraints();
		gbc_txtAddPhoneNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddPhoneNum.fill = GridBagConstraints.BOTH;
		gbc_txtAddPhoneNum.gridx = 2;
		gbc_txtAddPhoneNum.gridy = 0;
		centerAddPanel.add(txtAddPhoneNum, gbc_txtAddPhoneNum);
		txtAddPhoneNum.setColumns(10);
		
		lblAddPosition = new JLabel("Position:");
		lblAddPosition.setForeground(new Color(255, 255, 255));
		lblAddPosition.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddPosition = new GridBagConstraints();
		gbc_lblAddPosition.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddPosition.anchor = GridBagConstraints.EAST;
		gbc_lblAddPosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddPosition.gridx = 0;
		gbc_lblAddPosition.gridy = 2;
		centerAddPanel.add(lblAddPosition, gbc_lblAddPosition);
		
		cbbAddPosition = new JComboBox();
		cbbAddPosition.setModel(new DefaultComboBoxModel(new String[] {"", "Manager", "Saler"}));
		cbbAddPosition.setMaximumRowCount(10);
		cbbAddPosition.setForeground(new Color(44, 62, 80));
		cbbAddPosition.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbbAddPosition.setBackground(new Color(255, 253, 231));
		GridBagConstraints gbc_cbbAddPosition = new GridBagConstraints();
		gbc_cbbAddPosition.insets = new Insets(0, 0, 5, 0);
		gbc_cbbAddPosition.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbAddPosition.gridx = 2;
		gbc_cbbAddPosition.gridy = 2;
		centerAddPanel.add(cbbAddPosition, gbc_cbbAddPosition);
		
		lblAddIdCardNum = new JLabel("ID Card Number:");
		lblAddIdCardNum.setForeground(new Color(255, 255, 255));
		lblAddIdCardNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddIdCardNum = new GridBagConstraints();
		gbc_lblAddIdCardNum.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddIdCardNum.anchor = GridBagConstraints.EAST;
		gbc_lblAddIdCardNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddIdCardNum.gridx = 0;
		gbc_lblAddIdCardNum.gridy = 4;
		centerAddPanel.add(lblAddIdCardNum, gbc_lblAddIdCardNum);
		
		txtAddIdCardNum = new JTextField();
		txtAddIdCardNum.setForeground(new Color(44, 62, 80));
		txtAddIdCardNum.setBackground(new Color(255, 255, 255));
		txtAddIdCardNum.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_txtAddIdCardNum = new GridBagConstraints();
		gbc_txtAddIdCardNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddIdCardNum.fill = GridBagConstraints.BOTH;
		gbc_txtAddIdCardNum.gridx = 2;
		gbc_txtAddIdCardNum.gridy = 4;
		centerAddPanel.add(txtAddIdCardNum, gbc_txtAddIdCardNum);
		txtAddIdCardNum.setColumns(10);
		
		lblAddDayIn = new JLabel("Day In:");
		lblAddDayIn.setForeground(new Color(255, 255, 255));
		lblAddDayIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddDayIn = new GridBagConstraints();
		gbc_lblAddDayIn.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddDayIn.anchor = GridBagConstraints.EAST;
		gbc_lblAddDayIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddDayIn.gridx = 0;
		gbc_lblAddDayIn.gridy = 6;
		centerAddPanel.add(lblAddDayIn, gbc_lblAddDayIn);
		
		addDayIn = new JDateChooser();
		addDayIn.setBackground(new Color(44, 62, 80));
		addDayIn.setDateFormatString("yyyy-MM-dd");
		addDayIn.setForeground(new Color(44, 62, 80));
		addDayIn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_addDayIn = new GridBagConstraints();
		gbc_addDayIn.insets = new Insets(0, 0, 5, 0);
		gbc_addDayIn.fill = GridBagConstraints.BOTH;
		gbc_addDayIn.gridx = 2;
		gbc_addDayIn.gridy = 6;
		centerAddPanel.add(addDayIn, gbc_addDayIn);
		
		lblAddAddress = new JLabel("Address:");
		lblAddAddress.setForeground(new Color(255, 255, 255));
		lblAddAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddAddress = new GridBagConstraints();
		gbc_lblAddAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddAddress.insets = new Insets(0, 0, 0, 5);
		gbc_lblAddAddress.gridx = 0;
		gbc_lblAddAddress.gridy = 8;
		centerAddPanel.add(lblAddAddress, gbc_lblAddAddress);
		
		addScrollPane = new JScrollPane();
		GridBagConstraints gbc_addScrollPane = new GridBagConstraints();
		gbc_addScrollPane.fill = GridBagConstraints.BOTH;
		gbc_addScrollPane.gridx = 2;
		gbc_addScrollPane.gridy = 8;
		centerAddPanel.add(addScrollPane, gbc_addScrollPane);
		
		textAreaAddAddress = new JTextArea();
		textAreaAddAddress.setTabSize(10);
		textAreaAddAddress.setRows(3);
		textAreaAddAddress.setLineWrap(true);
		textAreaAddAddress.setForeground(new Color(44, 62, 80));
		textAreaAddAddress.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textAreaAddAddress.setBackground(new Color(255, 255, 255));
		addScrollPane.setViewportView(textAreaAddAddress);
		GridBagLayout gbl_topAddPanel = new GridBagLayout();
		gbl_topAddPanel.columnWidths = new int[]{0, 10, 25, 90, 30, 78, 10, 215, 0};
		gbl_topAddPanel.rowHeights = new int[]{40, 25, 40, 25, 0};
		gbl_topAddPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_topAddPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		topAddPanel.setLayout(gbl_topAddPanel);
		
		lblAddName = new JLabel("Full Name:");
		lblAddName.setForeground(new Color(255, 255, 255));
		lblAddName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddName = new GridBagConstraints();
		gbc_lblAddName.anchor = GridBagConstraints.EAST;
		gbc_lblAddName.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddName.gridx = 0;
		gbc_lblAddName.gridy = 0;
		topAddPanel.add(lblAddName, gbc_lblAddName);
		
		txtAddFullName = new JTextField();
		txtAddFullName.setForeground(new Color(44, 62, 80));
		txtAddFullName.setBackground(new Color(255, 255, 255));
		txtAddFullName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_txtAddFullName = new GridBagConstraints();
		gbc_txtAddFullName.gridwidth = 6;
		gbc_txtAddFullName.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddFullName.fill = GridBagConstraints.BOTH;
		gbc_txtAddFullName.gridx = 2;
		gbc_txtAddFullName.gridy = 0;
		topAddPanel.add(txtAddFullName, gbc_txtAddFullName);
		txtAddFullName.setColumns(10);
		
		lblAddGender = new JLabel("Gender:");
		lblAddGender.setForeground(new Color(255, 255, 255));
		lblAddGender.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddGender = new GridBagConstraints();
		gbc_lblAddGender.anchor = GridBagConstraints.EAST;
		gbc_lblAddGender.fill = GridBagConstraints.VERTICAL;
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
		gbc_lblAddDob.anchor = GridBagConstraints.EAST;
		gbc_lblAddDob.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddDob.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddDob.gridx = 5;
		gbc_lblAddDob.gridy = 2;
		topAddPanel.add(lblAddDob, gbc_lblAddDob);
		
		addDob = new JDateChooser();
		addDob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		addDob.setForeground(new Color(44, 62, 80));
		addDob.setBackground(new Color(44, 62, 80));
		addDob.setDateFormatString("yyyy-MM-dd");
		GridBagConstraints gbc_addDob = new GridBagConstraints();
		gbc_addDob.insets = new Insets(0, 0, 5, 0);
		gbc_addDob.fill = GridBagConstraints.BOTH;
		gbc_addDob.gridx = 7;
		gbc_addDob.gridy = 2;
		topAddPanel.add(addDob, gbc_addDob);
		addManagerPanel.setLayout(gl_addManagerPanel);
		applicationPanel.setLayout(gl_applicationPanel);
		centerPanel.setLayout(gl_centerPanel);
		
//		---------------------------------------------------------------------------------
		loadMng();
		showMngTable.setSurrendersFocusOnKeystroke(true);
		showMngTable.setAutoCreateRowSorter(true);
		var centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.LEFT);
		showMngTable.setDefaultRenderer(Object.class, centerRenderer);
	}

	protected void btnDeleteMngActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "You don't have enough permission to do this!");
//		var dao = new ManagerDAO();
//		var mng = new Manager();
//		try {
//			mng.setMng_id(Integer.parseInt(txtShowId.getText()));
//			dao.deleteManager(mng);
//			JOptionPane.showMessageDialog(null, "Deleted");
//		} catch (Exception e2) {
//			JOptionPane.showMessageDialog(null, "You have to select a manager");
//		}
//		loadMng();
	}
	
	public void loadMng() {		
		var model = new DefaultTableModel() {
			@Override
			public Class getColumnClass(int column){
				switch (column) {
				case 0: return Integer.class;	//ID
				case 1: return String.class;	// Name
				case 2: return String.class;	// DOB
				case 3: return Boolean.class;	// Gender
				case 4: return String.class;	// Position
				case 5: return String.class;	// ID card number
				case 6: return String.class;	// Phone number
				case 7: return String.class;	// Address
				case 8: return ImageIcon.class;	// Picture
				case 9: return String.class;	// Day in
				default:return String.class;
				}
			}
			
			@Override
			public boolean isCellEditable(int row, int col) {
				switch (col) {
				case 8: return false;
				default:return true;
				}
			}
		};

		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Date of birth");
		model.addColumn("Gender");
		model.addColumn("Position");
		model.addColumn("ID card number");
		model.addColumn("Phone number");
		model.addColumn("Address");
		model.addColumn("Picture");
		model.addColumn("Day in");
		
		var dao = new ManagerDAO();
		
		dao.getListManager().forEach(
			mng->model.addRow(new Object[] {
				mng.getMng_id(), mng.getMng_fullname(), mng.getMng_dob(), mng.isMng_gender(), mng.getMng_position(), mng.getMng_IDNo(), 
				mng.getMng_contactNo(), mng.getMng_address(), new ImageIcon(new ImageIcon(mng.getMng_picture()).getImage()
					.getScaledInstance(120, 600, Image.SCALE_SMOOTH)), mng.getMng_dayIn()
			})
		);
		
		showMngTable.setModel(model);
		
		showMngTable.getColumnModel().getColumn(0).setMinWidth(0);
		showMngTable.getColumnModel().getColumn(0).setMaxWidth(0);
		showMngTable.getColumnModel().getColumn(0).setPreferredWidth(0);
		
		showMngTable.getColumnModel().getColumn(2).setMinWidth(0);
		showMngTable.getColumnModel().getColumn(2).setMaxWidth(0);
		showMngTable.getColumnModel().getColumn(2).setPreferredWidth(0);
		
		showMngTable.getColumnModel().getColumn(3).setMinWidth(0);
		showMngTable.getColumnModel().getColumn(3).setMaxWidth(0);
		showMngTable.getColumnModel().getColumn(3).setPreferredWidth(0);
		
		showMngTable.getColumnModel().getColumn(4).setMinWidth(0);
		showMngTable.getColumnModel().getColumn(4).setMaxWidth(0);
		showMngTable.getColumnModel().getColumn(4).setPreferredWidth(0);
		
		showMngTable.getColumnModel().getColumn(5).setMinWidth(0);
		showMngTable.getColumnModel().getColumn(5).setMaxWidth(0);
		showMngTable.getColumnModel().getColumn(5).setPreferredWidth(0);
		
		showMngTable.getColumnModel().getColumn(6).setMinWidth(0);
		showMngTable.getColumnModel().getColumn(6).setMaxWidth(0);
		showMngTable.getColumnModel().getColumn(6).setPreferredWidth(0);
		
		showMngTable.getColumnModel().getColumn(7).setMinWidth(0);
		showMngTable.getColumnModel().getColumn(7).setMaxWidth(0);
		showMngTable.getColumnModel().getColumn(7).setPreferredWidth(0);
		
		showMngTable.getColumnModel().getColumn(8).setMinWidth(0);
		showMngTable.getColumnModel().getColumn(8).setMaxWidth(0);
		showMngTable.getColumnModel().getColumn(8).setPreferredWidth(0);
		
		showMngTable.getColumnModel().getColumn(9).setMinWidth(0);
		showMngTable.getColumnModel().getColumn(9).setMaxWidth(0);
		showMngTable.getColumnModel().getColumn(9).setPreferredWidth(0);
	}
	
	protected void showMngTableMouseClicked(MouseEvent e) {
		var cp = (CardLayout)detailPanel.getLayout();
		cp.show(detailPanel, "show_Mng");
		
		int rowIndex = showMngTable.getSelectedRow();
		try {
			txtShowId.setText(showMngTable.getValueAt(rowIndex, 0).toString());
			txtShowName.setText(showMngTable.getValueAt(rowIndex, 1).toString());
			try {
				showDob.setDate(new SimpleDateFormat("yyyy-MM-dd")
					.parse(showMngTable.getValueAt(rowIndex, 2).toString()));
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "Invalid data");
			}
			chckbxShowGender.setSelected(showMngTable.getValueAt(rowIndex, 3).toString().equals("true")?true:false);
			txtShowPosition.setText(showMngTable.getValueAt(rowIndex, 4).toString());
			txtShowIdCardNum.setText(showMngTable.getValueAt(rowIndex, 5).toString());
			txtShowPhoneNum.setText(showMngTable.getValueAt(rowIndex, 6).toString());
			textAreaShowAddress.setText(showMngTable.getValueAt(rowIndex, 7).toString());
			lblShowPicture.setIcon(new ImageIcon(((ImageIcon)showMngTable.getValueAt(rowIndex, 8)).getImage()
				.getScaledInstance(342, 471, Image.SCALE_SMOOTH)));
			try {
				showDayIn.setDate(new SimpleDateFormat("yyyy-MM-dd")
					.parse(showMngTable.getValueAt(rowIndex, 9).toString()));
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "Invalid data");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Missing data, please check again");
		}
	}
	
	// Thay đổi trạng thái của checkBox Gender
	protected void chckbxGenderStateChanged(ChangeEvent e) {
		if (chckbxShowGender.isSelected()) {
			txtShowGender.setText("Male");
		} else {
			txtShowGender.setText("Female");
		}
	}
	
	// Show form add Manager
	protected void btnAddMngActionPerformed(ActionEvent e) {
		var cp = (CardLayout)detailPanel.getLayout();
		cp.show(detailPanel, "add_Mng");
	}
		
	protected void chckbxAddGenderStateChanged(ChangeEvent e) {
		if (chckbxAddGender.isSelected()) {
			txtAddGender.setText("Male");
		} else {
			txtAddGender.setText("Female");
		}
	}
	
	protected void btnChoosePictureActionPerformed(ActionEvent e) {
		var chooser = new JFileChooser("C:\\Users\\quang\\Hình ảnh");
//		var chooser = new JFileChooser(System.getProperty("user.home") + "\\pictures");
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
	
	protected void btnSaveAddActionPerformed(ActionEvent e) {
		var mng = new Manager();
		var dao = new ManagerDAO();
		
		try {
			mng.setMng_fullname(txtAddFullName.getText());
			mng.setMng_dob(LocalDate.ofInstant(addDob.getDate().toInstant(), ZoneId.systemDefault()));
			mng.setMng_gender(chckbxAddGender.isSelected());
			mng.setMng_position(cbbAddPosition.getSelectedItem().toString());
			mng.setMng_IDNo(txtAddIdCardNum.getText());
			mng.setMng_contactNo(txtAddPhoneNum.getText());
			mng.setMng_address(textAreaAddAddress.getText());
			
			var image = new BufferedImage(lblAddPicture.getWidth(), lblAddPicture.getHeight(), BufferedImage.TYPE_INT_RGB);
			var g2d = image.createGraphics();
			lblAddPicture.printAll(g2d);
			g2d.dispose();

			var fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			if(fileName!=null) {
				var imagesDirectory = new File("images");
			    if(!imagesDirectory.exists()) {
			        imagesDirectory.mkdir();
			    } try {
			    	var outputFile = new File(imagesDirectory, fileName);
					ImageIO.write(image, "png, jpg", outputFile);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					mng.setMng_picture("images/" + fileName);
			} else {
				mng.setMng_picture("images/room.jpg");
			}
			mng.setMng_dayIn(LocalDate.ofInstant(addDayIn.getDate().toInstant(), ZoneId.systemDefault()));
			
			dao.insertManager(mng);
			JOptionPane.showMessageDialog(null, "Add successful");
			
			txtAddFullName.setText(null);
			addDob.setDate(null);
			txtAddGender.setText(null);
			chckbxAddGender.setSelected(false);
			cbbAddPosition.setSelectedItem(null);
			txtAddIdCardNum.setText(null);
			txtAddPhoneNum.setText(null);
			textAreaAddAddress.setText(null);
			addDayIn.setDate(null);
			
		} catch (Exception e2) {
			if(lblAddPicture.getIcon()==null) {
				JOptionPane.showMessageDialog(null, "Please add a picture");
			}
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
		loadMng();
	}
	
	protected void btnSaveEditActionPerformed(ActionEvent e) {
		var mng = new Manager();
		var dao = new ManagerDAO();
		
		try {
			mng.setMng_fullname(txtShowName.getText());
			mng.setMng_gender(chckbxShowGender.isSelected());
			if(fileName!=null) {
				driveAfter = System.getProperty("user.dir") +"\\images";
				var pathBefore = Paths.get(driveBefore);
				var pathAfter = Paths.get(driveAfter);
				try {
					Files.copy(pathBefore, pathAfter.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				mng.setMng_picture("images/" + fileName);
			} else {
				mng.setMng_picture(fileBefore);
			}
			mng.setMng_dob(LocalDate.ofInstant(showDob.getDate().toInstant(),ZoneId.systemDefault()));
			mng.setMng_dayIn(LocalDate.ofInstant(showDayIn.getDate().toInstant(),ZoneId.systemDefault()));
			mng.setMng_id(Integer.parseInt(txtShowId.getText()));
			
			dao.updateManager(mng);
			JOptionPane.showMessageDialog(null, "Edit successful");
			
			fileName = null;
			lblShowPicture.setIcon(null);
			txtShowName.setText(null);
			showDob.setDate(null);
			txtShowGender.setText(null);
			chckbxShowGender.setSelected(false);
			txtShowPosition.setText(null);
			txtShowIdCardNum.setText(null);
			txtShowPhoneNum.setText(null);
			textAreaShowAddress.setText(null);
			showDayIn.setDate(null);
			
		} catch (Exception e2) {
			if(lblShowPicture.getIcon()==null) {
				JOptionPane.showMessageDialog(null, "Please add a picture");
			}
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
		loadMng();
	}
	
	protected void btnEditPictureActionPerformed(ActionEvent e) {
		var chooser = new JFileChooser("C:\\Users\\quang\\Hình ảnh");
//		var chooser = new JFileChooser(System.getProperty("user.home") + "\\pictures");
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
}
