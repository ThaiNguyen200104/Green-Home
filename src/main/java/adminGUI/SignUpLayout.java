package adminGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.UserDAO;
import entity.User;

public class SignUpLayout extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel headPanel;
	private JPanel centerPanel;
	private JPanel headInfo;
	private JLabel lblSIG;
	private JPanel applicationPanel;
	private JPanel addUserPanel;
	private JLabel lblAddUsername;
	private JTextField txtAddUsername;
	private JLabel lblAddPassword;
	private JPasswordField addPassword;
	private JButton btnAdd;
	private JPanel editUserPanel;
	private JLabel lblEditUsername;
	private JTextField txtEditUsername;
	private JLabel lblEditPassword;
	private JPasswordField editPassword;
	private JButton btnEdit;
	private JLabel lblAddRewritePass;
	private JPasswordField addRewritePass;
	private JDateChooser userCreateDate;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable userTable;
	private JLabel lblEditUserType;
	private JComboBox cbbUserType;
	private JDateChooser editCreateDate;
	private JLabel lblEditId;

	public SignUpLayout() {
		setLayout(new BorderLayout(0, 0));
		
		headPanel = new JPanel();
		headPanel.setBackground(new Color(255, 253, 231));
		add(headPanel, BorderLayout.NORTH);
		
		headInfo = new JPanel();
		headInfo.setBackground(new Color(44, 62, 80));
		
		lblSIG = new JLabel("S I G N U P");
		lblSIG.setForeground(new Color(156, 204, 101));
		lblSIG.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_headInfo = new GroupLayout(headInfo);
		gl_headInfo.setHorizontalGroup(
			gl_headInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headInfo.createSequentialGroup()
					.addGap(593)
					.addComponent(lblSIG)
					.addContainerGap(592, Short.MAX_VALUE))
		);
		gl_headInfo.setVerticalGroup(
			gl_headInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSIG, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
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
					.addComponent(headInfo, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
					.addContainerGap())
		);
		headPanel.setLayout(gl_headPanel);
		
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 253, 231));
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		applicationPanel = new JPanel();
		applicationPanel.setBackground(new Color(255, 253, 231));
		centerPanel.add(applicationPanel);
		
		addUserPanel = new JPanel();
		addUserPanel.setBackground(new Color(44, 62, 80));
		addUserPanel.setForeground(new Color(44, 62, 80));
		addUserPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(156, 204, 101), new Color(160, 160, 160)), "Sign Up Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(156, 204, 101)));
		
		editUserPanel = new JPanel();
		editUserPanel.setForeground(new Color(44, 62, 80));
		editUserPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(156, 204, 101), new Color(160, 160, 160)), "Edit User", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(156, 204, 101)));
		editUserPanel.setBackground(new Color(44, 62, 80));
		GridBagLayout gbl_editUserPanel = new GridBagLayout();
		gbl_editUserPanel.columnWidths = new int[]{0, 15, 0, 30, 0, 15, 0, 0};
		gbl_editUserPanel.rowHeights = new int[]{0, 15, 0, 15, 0};
		gbl_editUserPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_editUserPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		editUserPanel.setLayout(gbl_editUserPanel);
		
		lblEditUsername = new JLabel("Username:");
		lblEditUsername.setForeground(Color.WHITE);
		lblEditUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblEditUsername = new GridBagConstraints();
		gbc_lblEditUsername.fill = GridBagConstraints.VERTICAL;
		gbc_lblEditUsername.anchor = GridBagConstraints.EAST;
		gbc_lblEditUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditUsername.gridx = 0;
		gbc_lblEditUsername.gridy = 0;
		editUserPanel.add(lblEditUsername, gbc_lblEditUsername);
		
		txtEditUsername = new JTextField();
		txtEditUsername.setForeground(new Color(44, 62, 80));
		txtEditUsername.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtEditUsername.setColumns(10);
		GridBagConstraints gbc_txtEditUsername = new GridBagConstraints();
		gbc_txtEditUsername.fill = GridBagConstraints.BOTH;
		gbc_txtEditUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtEditUsername.gridx = 2;
		gbc_txtEditUsername.gridy = 0;
		editUserPanel.add(txtEditUsername, gbc_txtEditUsername);
		
		lblEditPassword = new JLabel("Password:");
		lblEditPassword.setForeground(Color.WHITE);
		lblEditPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblEditPassword = new GridBagConstraints();
		gbc_lblEditPassword.fill = GridBagConstraints.VERTICAL;
		gbc_lblEditPassword.anchor = GridBagConstraints.EAST;
		gbc_lblEditPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditPassword.gridx = 4;
		gbc_lblEditPassword.gridy = 0;
		editUserPanel.add(lblEditPassword, gbc_lblEditPassword);
		
		editPassword = new JPasswordField();
		editPassword.setColumns(1);
		editPassword.setEchoChar('*');
		editPassword.setForeground(new Color(44, 62, 80));
		editPassword.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_editPassword = new GridBagConstraints();
		gbc_editPassword.fill = GridBagConstraints.BOTH;
		gbc_editPassword.insets = new Insets(0, 0, 5, 0);
		gbc_editPassword.gridx = 6;
		gbc_editPassword.gridy = 0;
		editUserPanel.add(editPassword, gbc_editPassword);
		
		panel = new JPanel();
		GroupLayout gl_applicationPanel = new GroupLayout(applicationPanel);
		gl_applicationPanel.setHorizontalGroup(
			gl_applicationPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_applicationPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_applicationPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(addUserPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(editUserPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_applicationPanel.setVerticalGroup(
			gl_applicationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_applicationPanel.createSequentialGroup()
					.addComponent(addUserPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(editUserPanel, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		lblEditUserType = new JLabel("Choose user type:");
		lblEditUserType.setForeground(Color.WHITE);
		lblEditUserType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblEditUserType = new GridBagConstraints();
		gbc_lblEditUserType.fill = GridBagConstraints.VERTICAL;
		gbc_lblEditUserType.anchor = GridBagConstraints.EAST;
		gbc_lblEditUserType.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditUserType.gridx = 0;
		gbc_lblEditUserType.gridy = 2;
		editUserPanel.add(lblEditUserType, gbc_lblEditUserType);
		
		cbbUserType = new JComboBox();
		cbbUserType.setModel(new DefaultComboBoxModel(new String[] {"", "Manager", "Saler"}));
		cbbUserType.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbbUserType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_cbbUserType = new GridBagConstraints();
		gbc_cbbUserType.insets = new Insets(0, 0, 5, 5);
		gbc_cbbUserType.fill = GridBagConstraints.BOTH;
		gbc_cbbUserType.gridx = 2;
		gbc_cbbUserType.gridy = 2;
		editUserPanel.add(cbbUserType, gbc_cbbUserType);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(this::btnEditActionPerformed);
		btnEdit.setForeground(new Color(44, 62, 80));
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnEdit.gridx = 4;
		gbc_btnEdit.gridy = 2;
		editUserPanel.add(btnEdit, gbc_btnEdit);
		
		editCreateDate = new JDateChooser();
		editCreateDate.setVisible(false);
		
		lblEditId = new JLabel("");
		lblEditId.setEnabled(false);
		lblEditId.setVisible(false);
		GridBagConstraints gbc_lblEditId = new GridBagConstraints();
		gbc_lblEditId.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditId.gridx = 5;
		gbc_lblEditId.gridy = 2;
		editUserPanel.add(lblEditId, gbc_lblEditId);
		editCreateDate.setEnabled(false);
		GridBagConstraints gbc_editCreateDate = new GridBagConstraints();
		gbc_editCreateDate.insets = new Insets(0, 0, 5, 0);
		gbc_editCreateDate.fill = GridBagConstraints.BOTH;
		gbc_editCreateDate.gridx = 6;
		gbc_editCreateDate.gridy = 2;
		editUserPanel.add(editCreateDate, gbc_editCreateDate);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		userTable = new JTable();
		userTable.setSurrendersFocusOnKeystroke(true);
		userTable.setRowHeight(30);
		userTable.setForeground(new Color(44, 62, 80));
		userTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		userTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userTable.setAutoCreateRowSorter(true);
		userTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userTableMouseClicked(e);
			}
		});
		userTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(userTable);
		GridBagLayout gbl_addUserPanel = new GridBagLayout();
		gbl_addUserPanel.columnWidths = new int[]{0, 15, 0, 30, 0, 15, 0, 0};
		gbl_addUserPanel.rowHeights = new int[]{0, 15, 0, 15, 0};
		gbl_addUserPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_addUserPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addUserPanel.setLayout(gbl_addUserPanel);
		
		lblAddUsername = new JLabel("Username:");
		lblAddUsername.setForeground(new Color(255, 255, 255));
		lblAddUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddUsername = new GridBagConstraints();
		gbc_lblAddUsername.anchor = GridBagConstraints.EAST;
		gbc_lblAddUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddUsername.gridx = 0;
		gbc_lblAddUsername.gridy = 0;
		addUserPanel.add(lblAddUsername, gbc_lblAddUsername);
		
		txtAddUsername = new JTextField();
		txtAddUsername.setForeground(new Color(44, 62, 80));
		txtAddUsername.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_txtAddUsername = new GridBagConstraints();
		gbc_txtAddUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddUsername.fill = GridBagConstraints.BOTH;
		gbc_txtAddUsername.gridx = 2;
		gbc_txtAddUsername.gridy = 0;
		addUserPanel.add(txtAddUsername, gbc_txtAddUsername);
		txtAddUsername.setColumns(10);
		
		lblAddPassword = new JLabel("Password:");
		lblAddPassword.setForeground(Color.WHITE);
		lblAddPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddPassword = new GridBagConstraints();
		gbc_lblAddPassword.anchor = GridBagConstraints.EAST;
		gbc_lblAddPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddPassword.gridx = 4;
		gbc_lblAddPassword.gridy = 0;
		addUserPanel.add(lblAddPassword, gbc_lblAddPassword);
		
		addPassword = new JPasswordField();
		addPassword.setColumns(1);
		addPassword.setEchoChar('*');
		addPassword.setForeground(new Color(44, 62, 80));
		addPassword.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_addPassword = new GridBagConstraints();
		gbc_addPassword.insets = new Insets(0, 0, 5, 0);
		gbc_addPassword.fill = GridBagConstraints.BOTH;
		gbc_addPassword.gridx = 6;
		gbc_addPassword.gridy = 0;
		addUserPanel.add(addPassword, gbc_addPassword);
		
		lblAddRewritePass = new JLabel("Confirm password:");
		lblAddRewritePass.setForeground(Color.WHITE);
		lblAddRewritePass.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddRewritePass = new GridBagConstraints();
		gbc_lblAddRewritePass.anchor = GridBagConstraints.EAST;
		gbc_lblAddRewritePass.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddRewritePass.gridx = 0;
		gbc_lblAddRewritePass.gridy = 2;
		addUserPanel.add(lblAddRewritePass, gbc_lblAddRewritePass);
		
		addRewritePass = new JPasswordField();
		addRewritePass.setForeground(new Color(44, 62, 80));
		addRewritePass.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		addRewritePass.setEchoChar('*');
		GridBagConstraints gbc_addRewritePass = new GridBagConstraints();
		gbc_addRewritePass.insets = new Insets(0, 0, 5, 5);
		gbc_addRewritePass.fill = GridBagConstraints.BOTH;
		gbc_addRewritePass.gridx = 2;
		gbc_addRewritePass.gridy = 2;
		addUserPanel.add(addRewritePass, gbc_addRewritePass);
		
		userCreateDate = new JDateChooser();
		userCreateDate.setEnabled(false);
		userCreateDate.setVisible(false);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this::btnAddActionPerformed);
		btnAdd.setForeground(new Color(44, 62, 80));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 4;
		gbc_btnAdd.gridy = 2;
		addUserPanel.add(btnAdd, gbc_btnAdd);
		GridBagConstraints gbc_userCreateDate = new GridBagConstraints();
		gbc_userCreateDate.insets = new Insets(0, 0, 5, 0);
		gbc_userCreateDate.fill = GridBagConstraints.BOTH;
		gbc_userCreateDate.gridx = 6;
		gbc_userCreateDate.gridy = 2;
		addUserPanel.add(userCreateDate, gbc_userCreateDate);
		applicationPanel.setLayout(gl_applicationPanel);

		loadUser();
	}
	
	public void loadUser() {
		var model = new DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int column){
				switch (column) {
				case 0: return Integer.class;	// ID
				case 1: return String.class;	// Name
				case 2: return String.class;	// Password
				case 3: return String.class;	// User_type
				default:return String.class;
				}
			}
			
			@Override
			public boolean isCellEditable(int row, int col) {
				switch (col) {
				case 2: return false;
				default:return true;
				}
			}
		};

		model.addColumn("ID");
		model.addColumn("Username");
		model.addColumn("Password");
		model.addColumn("User Type");
		model.addColumn("Created Date");
		
		var dao = new UserDAO();
		
		dao.getUserList().forEach(
			usr->model.addRow(new Object[] {
					usr.getUsr_id(), usr.getUsr_name(), usr.getUsr_pw(), usr.getUsr_type(),
					usr.getUsr_create_day()
			})
		);
		
		userTable.setModel(model);
		
		userTable.getColumnModel().getColumn(2).setMinWidth(0);
		userTable.getColumnModel().getColumn(2).setMaxWidth(0);
		userTable.getColumnModel().getColumn(2).setPreferredWidth(0);

	}
	
	protected void btnAddActionPerformed(ActionEvent e) {
		var usr = new User();
		var dao = new UserDAO();
		
		try {
			usr.setUsr_name(txtAddUsername.getText());		
			if(addPassword.getText().equals(addRewritePass.getText()) ) {
				usr.setUsr_pw(addPassword.getText().toString());
			} else {
				JOptionPane.showMessageDialog(null, "Comfirm password isn't match");
				return;
			}
			usr.setUsr_type("Manager");
			usr.setUsr_create_day(LocalDate.now());

			dao.insertUserList(usr);
			
			JOptionPane.showMessageDialog(null, "Add successful");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
		loadUser();
	}
	
	protected void userTableMouseClicked(MouseEvent e) {
		int rowIndex = userTable.getSelectedRow();
		try {
			lblEditId.setText(userTable.getValueAt(rowIndex, 0).toString());
			txtEditUsername.setText(userTable.getValueAt(rowIndex, 1).toString());
			editPassword.setText(userTable.getValueAt(rowIndex, 2).toString());
			cbbUserType.setSelectedItem(userTable.getValueAt(rowIndex, 3).toString());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Missing data, please check again");
		}
	}
	
	protected void btnEditActionPerformed(ActionEvent e) {
		var usr = new User();
		var dao = new UserDAO();
		try {
			usr.setUsr_name(txtEditUsername.getText());
			usr.setUsr_pw(editPassword.getText().toString());
			usr.setUsr_type(cbbUserType.getSelectedItem().toString());
			usr.setUsr_create_day(LocalDate.now());
			usr.setUsr_id(Integer.parseInt(lblEditId.getText()));
			dao.updateUserList(usr);
			
			JOptionPane.showMessageDialog(null, "Edit successful");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something went wrong, please check again");
		}
		loadUser();
	}
}
