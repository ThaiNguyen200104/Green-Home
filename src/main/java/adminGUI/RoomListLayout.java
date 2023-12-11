package adminGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.RoomDAO;
import entity.RoomList;
import helper.Regex;
import helper.Valid;

public class RoomListLayout extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel headPanel;
	private JPanel sidePanel;
	private JPanel centerPanel;
	private JPanel headInfo;
	private JLabel lblCategory;
	private JPanel applicationPanel;
	private JPanel infoPanel;
	private JScrollPane scrollPane;
	private JTable roomList;
	private JPanel showRoomPanel;
	private JLabel lblShowRoomId;
	private JLabel lblShowBuilding;
	private JLabel lblShowFloor;
	private JLabel lblShowRoomArea;
	private JTextField txtShowRoomId;
	private JTextField txtShowBuilding;
	private JLabel lblShowRoomStatus;
	private JLabel lblShowRoomPrice;
	private JLabel lblShowRoomType;
	private JTextField txtShowFloor;
	private JTextField txtShowRoomArea;
	private JTextField txtShowRoomPrice;
	private JComboBox cbbShowRoomType;
	private JCheckBox chckbxStatus;
	private JLabel lblStatus;
	private JPanel addRoomPanel;
	private JLabel lblAddRoomId;
	private JTextField txtAddRoomId;
	private JLabel lblAddRoomArea;
	private JTextField txtAddArea;
	private JLabel lblAddBuilding;
	private JTextField txtAddBuilding;
	private JLabel lblAddRoomStatus;
	private JCheckBox chckbxAddStatus;
	private JLabel lblAddStatus;
	private JLabel lblAddFloor;
	private JTextField txtAddFloor;
	private JLabel lblAddRoomPrice;
	private JTextField txtAddPrice;
	private JLabel lblAddRoomType;
	private JComboBox cbbAddRoomType;
	private JPanel buttonPanel;
	private JButton btnAddRoom;
	private JButton btnSaveAdd;
	private JButton btnSaveEdit;
	private JLabel lblFooterBrand;

	public RoomListLayout() {
		setBounds(new Rectangle(0, 0, 1360, 748));
		setLayout(new BorderLayout(0, 0));
		
		headPanel = new JPanel();
		headPanel.setBackground(new Color(255, 253, 231));
		add(headPanel, BorderLayout.NORTH);
		
		headInfo = new JPanel();
		headInfo.setBackground(new Color(44, 62, 80));
		
		lblCategory = new JLabel("R O O M   L I S T");
		lblCategory.setForeground(new Color(156, 204, 101));
		lblCategory.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_headInfo = new GroupLayout(headInfo);
		gl_headInfo.setHorizontalGroup(
			gl_headInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headInfo.createSequentialGroup()
					.addGap(552)
					.addComponent(lblCategory)
					.addContainerGap(551, Short.MAX_VALUE))
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
			gl_headPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_headPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(headInfo, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
					.addContainerGap())
		);
		headPanel.setLayout(gl_headPanel);
		
		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(255, 253, 231));
		add(sidePanel, BorderLayout.WEST);
		
		infoPanel = new JPanel();
		GroupLayout gl_sidePanel = new GroupLayout(sidePanel);
		gl_sidePanel.setHorizontalGroup(
			gl_sidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sidePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
		);
		gl_sidePanel.setVerticalGroup(
			gl_sidePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_sidePanel.createSequentialGroup()
					.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		scrollPane = new JScrollPane();
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel.setHorizontalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
		);
		gl_infoPanel.setVerticalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
		);
		
		roomList = new JTable();
		roomList.setRowHeight(30);
		roomList.setFillsViewportHeight(true);
		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				roomListMouseClicked(e);
			}
		});
		roomList.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		roomList.setForeground(new Color(44, 62, 80));
		scrollPane.setViewportView(roomList);
		infoPanel.setLayout(gl_infoPanel);
		sidePanel.setLayout(gl_sidePanel);
		
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 253, 231));
		add(centerPanel, BorderLayout.CENTER);
		
		applicationPanel = new JPanel();
		applicationPanel.setBackground(new Color(255, 253, 231));
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(255, 253, 231));
		
		btnAddRoom = new JButton("Add Room");
		btnAddRoom.addActionListener(this::btnAddRoomActionPerformed);
		btnAddRoom.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		btnSaveAdd = new JButton("Save Add");
		btnSaveAdd.addActionListener(this::btnSaveAddActionPerformed);
		btnSaveAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		btnSaveEdit = new JButton("Save Edit");
		btnSaveEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
		gl_buttonPanel.setHorizontalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAddRoom)
					.addGap(18)
					.addComponent(btnSaveAdd)
					.addGap(18)
					.addComponent(btnSaveEdit)
					.addContainerGap(663, Short.MAX_VALUE))
		);
		gl_buttonPanel.setVerticalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(gl_buttonPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddRoom)
						.addComponent(btnSaveAdd)
						.addComponent(btnSaveEdit))
					.addContainerGap())
		);
		buttonPanel.setLayout(gl_buttonPanel);
		
		lblFooterBrand = new JLabel("Copyright © 2023 Green Home. All rights reserved.");
		lblFooterBrand.setForeground(new Color(44, 62, 80));
		lblFooterBrand.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
		gl_centerPanel.setHorizontalGroup(
			gl_centerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFooterBrand, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addComponent(applicationPanel, GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
							.addGap(10))))
		);
		gl_centerPanel.setVerticalGroup(
			gl_centerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addComponent(applicationPanel, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_centerPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFooterBrand, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		showRoomPanel = new JPanel();
		showRoomPanel.setBackground(new Color(44, 62, 80));
		
		addRoomPanel = new JPanel();
		addRoomPanel.setVisible(false);
		addRoomPanel.setBackground(new Color(44, 62, 80));
		GridBagLayout gbl_addRoomPanel = new GridBagLayout();
		gbl_addRoomPanel.columnWidths = new int[]{0, 10, 0, 30, 67, 10, 0, 0};
		gbl_addRoomPanel.rowHeights = new int[]{40, 30, 40, 30, 40, 30, 40, 0};
		gbl_addRoomPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_addRoomPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addRoomPanel.setLayout(gbl_addRoomPanel);
		
		lblAddRoomId = new JLabel("Room ID:");
		lblAddRoomId.setForeground(Color.WHITE);
		lblAddRoomId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddRoomId = new GridBagConstraints();
		gbc_lblAddRoomId.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddRoomId.anchor = GridBagConstraints.EAST;
		gbc_lblAddRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddRoomId.gridx = 0;
		gbc_lblAddRoomId.gridy = 0;
		addRoomPanel.add(lblAddRoomId, gbc_lblAddRoomId);
		
		txtAddRoomId = new JTextField();
		txtAddRoomId.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtAddRoomId.setColumns(10);
		txtAddRoomId.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtAddRoomId = new GridBagConstraints();
		gbc_txtAddRoomId.fill = GridBagConstraints.BOTH;
		gbc_txtAddRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddRoomId.gridx = 2;
		gbc_txtAddRoomId.gridy = 0;
		addRoomPanel.add(txtAddRoomId, gbc_txtAddRoomId);
		
		lblAddRoomArea = new JLabel("Area:");
		lblAddRoomArea.setForeground(Color.WHITE);
		lblAddRoomArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddRoomArea = new GridBagConstraints();
		gbc_lblAddRoomArea.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddRoomArea.anchor = GridBagConstraints.EAST;
		gbc_lblAddRoomArea.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddRoomArea.gridx = 4;
		gbc_lblAddRoomArea.gridy = 0;
		addRoomPanel.add(lblAddRoomArea, gbc_lblAddRoomArea);
		
		txtAddArea = new JTextField();
		txtAddArea.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtAddArea.setColumns(10);
		txtAddArea.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtAddArea = new GridBagConstraints();
		gbc_txtAddArea.fill = GridBagConstraints.BOTH;
		gbc_txtAddArea.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddArea.gridx = 6;
		gbc_txtAddArea.gridy = 0;
		addRoomPanel.add(txtAddArea, gbc_txtAddArea);
		
		lblAddBuilding = new JLabel("Building:");
		lblAddBuilding.setForeground(Color.WHITE);
		lblAddBuilding.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddBuilding = new GridBagConstraints();
		gbc_lblAddBuilding.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddBuilding.anchor = GridBagConstraints.EAST;
		gbc_lblAddBuilding.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddBuilding.gridx = 0;
		gbc_lblAddBuilding.gridy = 2;
		addRoomPanel.add(lblAddBuilding, gbc_lblAddBuilding);
		
		txtAddBuilding = new JTextField();
		txtAddBuilding.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtAddBuilding.setColumns(10);
		txtAddBuilding.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtAddBuilding = new GridBagConstraints();
		gbc_txtAddBuilding.fill = GridBagConstraints.BOTH;
		gbc_txtAddBuilding.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddBuilding.gridx = 2;
		gbc_txtAddBuilding.gridy = 2;
		addRoomPanel.add(txtAddBuilding, gbc_txtAddBuilding);
		
		lblAddRoomStatus = new JLabel("Status:");
		lblAddRoomStatus.setForeground(Color.WHITE);
		lblAddRoomStatus.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddRoomStatus = new GridBagConstraints();
		gbc_lblAddRoomStatus.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddRoomStatus.anchor = GridBagConstraints.EAST;
		gbc_lblAddRoomStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddRoomStatus.gridx = 4;
		gbc_lblAddRoomStatus.gridy = 2;
		addRoomPanel.add(lblAddRoomStatus, gbc_lblAddRoomStatus);
		
		chckbxAddStatus = new JCheckBox("");
		chckbxAddStatus.addChangeListener(this::chckbxAddStatusStateChanged);
		chckbxAddStatus.setBackground(Color.WHITE);
		GridBagConstraints gbc_chckbxAddStatus = new GridBagConstraints();
		gbc_chckbxAddStatus.fill = GridBagConstraints.BOTH;
		gbc_chckbxAddStatus.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAddStatus.gridx = 5;
		gbc_chckbxAddStatus.gridy = 2;
		addRoomPanel.add(chckbxAddStatus, gbc_chckbxAddStatus);
		
		lblAddStatus = new JLabel("");
		lblAddStatus.setOpaque(true);
		lblAddStatus.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAddStatus.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblAddStatus = new GridBagConstraints();
		gbc_lblAddStatus.fill = GridBagConstraints.BOTH;
		gbc_lblAddStatus.insets = new Insets(0, 0, 5, 0);
		gbc_lblAddStatus.gridx = 6;
		gbc_lblAddStatus.gridy = 2;
		addRoomPanel.add(lblAddStatus, gbc_lblAddStatus);
		
		lblAddFloor = new JLabel("Floor:");
		lblAddFloor.setForeground(Color.WHITE);
		lblAddFloor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddFloor = new GridBagConstraints();
		gbc_lblAddFloor.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddFloor.anchor = GridBagConstraints.EAST;
		gbc_lblAddFloor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddFloor.gridx = 0;
		gbc_lblAddFloor.gridy = 4;
		addRoomPanel.add(lblAddFloor, gbc_lblAddFloor);
		
		txtAddFloor = new JTextField();
		txtAddFloor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtAddFloor.setColumns(10);
		txtAddFloor.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtAddFloor = new GridBagConstraints();
		gbc_txtAddFloor.fill = GridBagConstraints.BOTH;
		gbc_txtAddFloor.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddFloor.gridx = 2;
		gbc_txtAddFloor.gridy = 4;
		addRoomPanel.add(txtAddFloor, gbc_txtAddFloor);
		
		lblAddRoomPrice = new JLabel("Price:");
		lblAddRoomPrice.setForeground(Color.WHITE);
		lblAddRoomPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddRoomPrice = new GridBagConstraints();
		gbc_lblAddRoomPrice.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddRoomPrice.anchor = GridBagConstraints.EAST;
		gbc_lblAddRoomPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddRoomPrice.gridx = 4;
		gbc_lblAddRoomPrice.gridy = 4;
		addRoomPanel.add(lblAddRoomPrice, gbc_lblAddRoomPrice);
		
		txtAddPrice = new JTextField();
		txtAddPrice.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtAddPrice.setColumns(10);
		txtAddPrice.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtAddPrice = new GridBagConstraints();
		gbc_txtAddPrice.fill = GridBagConstraints.BOTH;
		gbc_txtAddPrice.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddPrice.gridx = 6;
		gbc_txtAddPrice.gridy = 4;
		addRoomPanel.add(txtAddPrice, gbc_txtAddPrice);
		
		lblAddRoomType = new JLabel("Room Type:");
		lblAddRoomType.setForeground(Color.WHITE);
		lblAddRoomType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddRoomType = new GridBagConstraints();
		gbc_lblAddRoomType.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddRoomType.anchor = GridBagConstraints.EAST;
		gbc_lblAddRoomType.insets = new Insets(0, 0, 0, 5);
		gbc_lblAddRoomType.gridx = 0;
		gbc_lblAddRoomType.gridy = 6;
		addRoomPanel.add(lblAddRoomType, gbc_lblAddRoomType);
		
		cbbAddRoomType = new JComboBox();
		cbbAddRoomType.setModel(new DefaultComboBoxModel(new String[] {"", "Single", "Double", "Family"}));
		cbbAddRoomType.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		cbbAddRoomType.setBackground(Color.WHITE);
		GridBagConstraints gbc_cbbAddRoomType = new GridBagConstraints();
		gbc_cbbAddRoomType.fill = GridBagConstraints.BOTH;
		gbc_cbbAddRoomType.insets = new Insets(0, 0, 0, 5);
		gbc_cbbAddRoomType.gridx = 2;
		gbc_cbbAddRoomType.gridy = 6;
		addRoomPanel.add(cbbAddRoomType, gbc_cbbAddRoomType);
		GridBagLayout gbl_showRoomPanel = new GridBagLayout();
		gbl_showRoomPanel.columnWidths = new int[]{0, 10, 0, 30, 0, 10, 0, 0};
		gbl_showRoomPanel.rowHeights = new int[]{40, 30, 40, 30, 40, 30, 40, 0};
		gbl_showRoomPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_showRoomPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		showRoomPanel.setLayout(gbl_showRoomPanel);
		
		lblShowRoomId = new JLabel("Room ID:");
		lblShowRoomId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowRoomId.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblShowRoomId = new GridBagConstraints();
		gbc_lblShowRoomId.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowRoomId.anchor = GridBagConstraints.EAST;
		gbc_lblShowRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowRoomId.gridx = 0;
		gbc_lblShowRoomId.gridy = 0;
		showRoomPanel.add(lblShowRoomId, gbc_lblShowRoomId);
		
		txtShowRoomId = new JTextField();
		txtShowRoomId.setBackground(new Color(255, 255, 255));
		txtShowRoomId.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_txtShowRoomId = new GridBagConstraints();
		gbc_txtShowRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowRoomId.fill = GridBagConstraints.BOTH;
		gbc_txtShowRoomId.gridx = 2;
		gbc_txtShowRoomId.gridy = 0;
		showRoomPanel.add(txtShowRoomId, gbc_txtShowRoomId);
		txtShowRoomId.setColumns(10);
		
		lblShowRoomArea = new JLabel("Area:");
		lblShowRoomArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowRoomArea.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblShowRoomArea = new GridBagConstraints();
		gbc_lblShowRoomArea.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowRoomArea.anchor = GridBagConstraints.EAST;
		gbc_lblShowRoomArea.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowRoomArea.gridx = 4;
		gbc_lblShowRoomArea.gridy = 0;
		showRoomPanel.add(lblShowRoomArea, gbc_lblShowRoomArea);
		
		txtShowRoomArea = new JTextField();
		txtShowRoomArea.setBackground(new Color(255, 255, 255));
		txtShowRoomArea.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_txtShowRoomArea = new GridBagConstraints();
		gbc_txtShowRoomArea.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowRoomArea.fill = GridBagConstraints.BOTH;
		gbc_txtShowRoomArea.gridx = 6;
		gbc_txtShowRoomArea.gridy = 0;
		showRoomPanel.add(txtShowRoomArea, gbc_txtShowRoomArea);
		txtShowRoomArea.setColumns(10);
		
		lblShowBuilding = new JLabel("Building:");
		lblShowBuilding.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowBuilding.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblShowBuilding = new GridBagConstraints();
		gbc_lblShowBuilding.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowBuilding.anchor = GridBagConstraints.EAST;
		gbc_lblShowBuilding.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowBuilding.gridx = 0;
		gbc_lblShowBuilding.gridy = 2;
		showRoomPanel.add(lblShowBuilding, gbc_lblShowBuilding);
		
		txtShowBuilding = new JTextField();
		txtShowBuilding.setBackground(new Color(255, 255, 255));
		txtShowBuilding.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_txtShowBuilding = new GridBagConstraints();
		gbc_txtShowBuilding.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowBuilding.fill = GridBagConstraints.BOTH;
		gbc_txtShowBuilding.gridx = 2;
		gbc_txtShowBuilding.gridy = 2;
		showRoomPanel.add(txtShowBuilding, gbc_txtShowBuilding);
		txtShowBuilding.setColumns(10);
		
		lblShowRoomStatus = new JLabel("Status:");
		lblShowRoomStatus.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowRoomStatus.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblShowRoomStatus = new GridBagConstraints();
		gbc_lblShowRoomStatus.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowRoomStatus.anchor = GridBagConstraints.EAST;
		gbc_lblShowRoomStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowRoomStatus.gridx = 4;
		gbc_lblShowRoomStatus.gridy = 2;
		showRoomPanel.add(lblShowRoomStatus, gbc_lblShowRoomStatus);
		
		chckbxStatus = new JCheckBox("");
		chckbxStatus.addChangeListener(this::chckbxStatusStateChanged);
		chckbxStatus.setBackground(new Color(255, 255, 255));
		chckbxStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_chckbxStatus = new GridBagConstraints();
		gbc_chckbxStatus.fill = GridBagConstraints.BOTH;
		gbc_chckbxStatus.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxStatus.gridx = 5;
		gbc_chckbxStatus.gridy = 2;
		showRoomPanel.add(chckbxStatus, gbc_chckbxStatus);
		
		lblStatus = new JLabel("");
		lblStatus.setOpaque(true);
		lblStatus.setBackground(new Color(255, 255, 255));
		lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.fill = GridBagConstraints.BOTH;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 0);
		gbc_lblStatus.gridx = 6;
		gbc_lblStatus.gridy = 2;
		showRoomPanel.add(lblStatus, gbc_lblStatus);
		
		lblShowFloor = new JLabel("Floor:");
		lblShowFloor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowFloor.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblShowFloor = new GridBagConstraints();
		gbc_lblShowFloor.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowFloor.anchor = GridBagConstraints.EAST;
		gbc_lblShowFloor.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowFloor.gridx = 0;
		gbc_lblShowFloor.gridy = 4;
		showRoomPanel.add(lblShowFloor, gbc_lblShowFloor);
		
		txtShowFloor = new JTextField();
		txtShowFloor.setBackground(new Color(255, 255, 255));
		txtShowFloor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_txtShowFloor = new GridBagConstraints();
		gbc_txtShowFloor.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowFloor.fill = GridBagConstraints.BOTH;
		gbc_txtShowFloor.gridx = 2;
		gbc_txtShowFloor.gridy = 4;
		showRoomPanel.add(txtShowFloor, gbc_txtShowFloor);
		txtShowFloor.setColumns(10);
		
		lblShowRoomPrice = new JLabel("Price:");
		lblShowRoomPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowRoomPrice.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblShowRoomPrice = new GridBagConstraints();
		gbc_lblShowRoomPrice.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowRoomPrice.anchor = GridBagConstraints.EAST;
		gbc_lblShowRoomPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowRoomPrice.gridx = 4;
		gbc_lblShowRoomPrice.gridy = 4;
		showRoomPanel.add(lblShowRoomPrice, gbc_lblShowRoomPrice);
		
		txtShowRoomPrice = new JTextField();
		txtShowRoomPrice.setBackground(new Color(255, 255, 255));
		txtShowRoomPrice.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_txtShowRoomPrice = new GridBagConstraints();
		gbc_txtShowRoomPrice.insets = new Insets(0, 0, 5, 0);
		gbc_txtShowRoomPrice.fill = GridBagConstraints.BOTH;
		gbc_txtShowRoomPrice.gridx = 6;
		gbc_txtShowRoomPrice.gridy = 4;
		showRoomPanel.add(txtShowRoomPrice, gbc_txtShowRoomPrice);
		txtShowRoomPrice.setColumns(10);
		
		lblShowRoomType = new JLabel("Room Type:");
		lblShowRoomType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowRoomType.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblShowRoomType = new GridBagConstraints();
		gbc_lblShowRoomType.fill = GridBagConstraints.VERTICAL;
		gbc_lblShowRoomType.anchor = GridBagConstraints.EAST;
		gbc_lblShowRoomType.insets = new Insets(0, 0, 0, 5);
		gbc_lblShowRoomType.gridx = 0;
		gbc_lblShowRoomType.gridy = 6;
		showRoomPanel.add(lblShowRoomType, gbc_lblShowRoomType);
		
		cbbShowRoomType = new JComboBox();
		cbbShowRoomType.setModel(new DefaultComboBoxModel(new String[] {"", "Single", "Double", "Family"}));
		cbbShowRoomType.setBackground(new Color(255, 255, 255));
		cbbShowRoomType.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_cbbShowRoomType = new GridBagConstraints();
		gbc_cbbShowRoomType.insets = new Insets(0, 0, 0, 5);
		gbc_cbbShowRoomType.fill = GridBagConstraints.BOTH;
		gbc_cbbShowRoomType.gridx = 2;
		gbc_cbbShowRoomType.gridy = 6;
		showRoomPanel.add(cbbShowRoomType, gbc_cbbShowRoomType);
		applicationPanel.setLayout(new CardLayout(0, 0));
		applicationPanel.add(showRoomPanel, "show_room");
		applicationPanel.add(addRoomPanel, "add_room");
		centerPanel.setLayout(gl_centerPanel);
		
//		---------------------------------------------------------------------------------
		loadRoomList();
		roomList.setSurrendersFocusOnKeystroke(true);
		roomList.setAutoCreateRowSorter(true);
		var centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.LEFT);
		roomList.setDefaultRenderer(Object.class, centerRenderer);
	}
	
	public void loadRoomList() {
		var model = new DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int column){
				switch (column) {
				case 0: return String.class;	// Room ID
				case 1: return Integer.class;	// Building
				case 2: return Integer.class;	// Floor
				case 3: return String.class;	// Room Type
				case 4: return Integer.class;	// Room Price
				case 5: return Double.class;	// Room Area
				case 6: return Boolean.class;	// Room Status
				default:return String.class;
				}
			}
		};

		model.addColumn("Room ID");
		model.addColumn("Building");
		model.addColumn("Floor");
		model.addColumn("Room Type");
		model.addColumn("Room Price");
		model.addColumn("Room Area");
		model.addColumn("Room Status");
		
		var dao = new RoomDAO();
		
		dao.getListRoomList().forEach(
			room->model.addRow(new Object[] {
					room.getRoom_id(), room.getBuilding(), room.getStorey(), room.getRoom_type(), room.getRoom_price(), room.getRoom_area(), 
					room.isRoom_status()
			})
		);
		
		roomList.setModel(model);
		
		roomList.getColumnModel().getColumn(1).setMinWidth(0);
		roomList.getColumnModel().getColumn(1).setMaxWidth(0);
		roomList.getColumnModel().getColumn(1).setPreferredWidth(0);
		
		roomList.getColumnModel().getColumn(2).setMinWidth(0);
		roomList.getColumnModel().getColumn(2).setMaxWidth(0);
		roomList.getColumnModel().getColumn(2).setPreferredWidth(0);
		
		roomList.getColumnModel().getColumn(3).setMinWidth(0);
		roomList.getColumnModel().getColumn(3).setMaxWidth(0);
		roomList.getColumnModel().getColumn(3).setPreferredWidth(0);
		
		roomList.getColumnModel().getColumn(4).setMinWidth(0);
		roomList.getColumnModel().getColumn(4).setMaxWidth(0);
		roomList.getColumnModel().getColumn(4).setPreferredWidth(0);
		
		roomList.getColumnModel().getColumn(5).setMinWidth(0);
		roomList.getColumnModel().getColumn(5).setMaxWidth(0);
		roomList.getColumnModel().getColumn(5).setPreferredWidth(0);
		
		roomList.getColumnModel().getColumn(6).setMinWidth(0);
		roomList.getColumnModel().getColumn(6).setMaxWidth(0);
		roomList.getColumnModel().getColumn(6).setPreferredWidth(0);
	}
	
	protected void btnAddRoomActionPerformed(ActionEvent e) {
		var cp = (CardLayout)applicationPanel.getLayout();
		cp.show(applicationPanel, "add_room");
	}
	
	protected void btnSaveAddActionPerformed(ActionEvent e) {
		var room = new RoomList();
		var dao = new RoomDAO();
		try {
			room.setRoom_id(txtAddRoomId.getText());
			room.setBuilding(txtAddBuilding.getText());
			room.setStorey(Integer.parseInt(txtAddFloor.getText()));
			room.setRoom_type(cbbAddRoomType.getSelectedItem().toString());
			room.setRoom_price(Integer.parseInt(txtAddPrice.getText()));
			room.setRoom_area(Double.parseDouble(txtAddArea.getText()));
			room.setRoom_status(chckbxAddStatus.isSelected());
			
			dao.insertRoomList(room);
			
			JOptionPane.showMessageDialog(null, "Add successfull");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
		loadRoomList();
	}
	
	protected void btnSaveEditActionPerformed(ActionEvent e) {
		var room = new RoomList();
		var dao = new RoomDAO();
		try {
			room.setBuilding(txtShowBuilding.getText());
			room.setStorey(Integer.parseInt(txtShowFloor.getText()));
			room.setRoom_type(cbbShowRoomType.getSelectedItem().toString());
			room.setRoom_price(Integer.parseInt(txtShowRoomPrice.getText()));
			room.setRoom_area(Double.parseDouble(txtShowRoomArea.getText()));
			room.setRoom_status(chckbxStatus.isSelected());
			room.setRoom_id(txtShowRoomId.getText());
			
			dao.updateRoomList(room);
			
			JOptionPane.showMessageDialog(null, "Edit successful");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
		loadRoomList();
	}
	
	protected void roomListMouseClicked(MouseEvent e) {
		var cp = (CardLayout)applicationPanel.getLayout();
		cp.show(applicationPanel, "show_room");
		
		int rowIndex = roomList.getSelectedRow();
		try {
			txtShowRoomId.setText(roomList.getValueAt(rowIndex, 0).toString());
			txtShowBuilding.setText(roomList.getValueAt(rowIndex, 1).toString());
			txtShowFloor.setText(roomList.getValueAt(rowIndex, 2).toString());
			cbbShowRoomType.setSelectedItem(roomList.getValueAt(rowIndex, 3).toString());
			txtShowRoomPrice.setText(roomList.getValueAt(rowIndex, 4).toString());
			txtShowRoomArea.setText(roomList.getValueAt(rowIndex, 5).toString());
			chckbxStatus.setSelected(roomList.getValueAt(rowIndex, 6).toString().equals("true")?true:false);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Missing data, please check again");
		}
	}
	
	protected void chckbxStatusStateChanged(ChangeEvent e) {
		if (chckbxStatus.isSelected()) {
			lblStatus.setText("Available");
		} else {
			lblStatus.setText("Unavailable");
		}
	}
	
	protected void chckbxAddStatusStateChanged(ChangeEvent e) {
		if (chckbxAddStatus.isSelected()) {
			lblAddStatus.setText("Available");
		} else {
			lblAddStatus.setText("Unavailable");
		}
	}
}
