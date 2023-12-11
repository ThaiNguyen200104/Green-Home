package login;

import java.awt.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import adminGUI.AdminMain;
import dao.UserDAO;
import entity.User;
import managerGUI.ManagerMain;
import salerGUI.SalerMain;

public class LoginLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel form;
	private JLabel lblBrand1;
	private JLabel lblUserName;
	private JTextField txtUserName;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JPanel mainPanel;
	private JPanel brandPanel;
	private JLabel lblBrand2;
	private JLabel lblBrand3;
	private JLabel lblBrand4;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					var frame = new LoginLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LoginLayout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginLayout.class.getResource("/icons/jframeIcon.png")));
		setType(Type.POPUP);
		setResizable(false);
		setPreferredSize(new Dimension(1600, 900));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setMaximumSize(new Dimension(1600, 900));
		setTitle("Green Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 62, 80));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		form = new JPanel();
		form.setBorder(null);
		form.setBackground(new Color(44, 62, 80));
		form.setBounds(6, 6, 1572, 849);
		contentPane.add(form);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(44, 62, 80));
		
		brandPanel = new JPanel();
		brandPanel.setBackground(new Color(44, 62, 80));
		GroupLayout gl_form = new GroupLayout(form);
		gl_form.setHorizontalGroup(
			gl_form.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_form.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_form.createParallelGroup(Alignment.LEADING)
						.addComponent(brandPanel, GroupLayout.DEFAULT_SIZE, 1560, Short.MAX_VALUE)
						.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_form.setVerticalGroup(
			gl_form.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_form.createSequentialGroup()
					.addGap(149)
					.addComponent(brandPanel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(301, Short.MAX_VALUE))
		);
		
		lblBrand1 = new JLabel("W E L C O M E  T O");
		lblBrand1.setFont(new Font("Arial", Font.BOLD, 40));
		lblBrand1.setForeground(new Color(255, 255, 255));
		
		lblBrand2 = new JLabel("G R E E N");
		lblBrand2.setForeground(new Color(156, 204, 101));
		lblBrand2.setFont(new Font("Arial", Font.BOLD, 40));
		
		lblBrand3 = new JLabel("H O M E");
		lblBrand3.setForeground(new Color(255, 255, 255));
		lblBrand3.setFont(new Font("Arial", Font.BOLD, 40));
		
		lblBrand4 = new JLabel("APARTMENTS FOR RENT");
		lblBrand4.setForeground(new Color(255, 253, 231));
		lblBrand4.setFont(new Font("Arial", Font.PLAIN, 30));
		GroupLayout gl_brandPanel = new GroupLayout(brandPanel);
		gl_brandPanel.setHorizontalGroup(
			gl_brandPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_brandPanel.createSequentialGroup()
					.addContainerGap(417, Short.MAX_VALUE)
					.addGroup(gl_brandPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_brandPanel.createSequentialGroup()
							.addComponent(lblBrand1)
							.addGap(18)
							.addComponent(lblBrand2)
							.addGap(18)
							.addComponent(lblBrand3))
						.addGroup(gl_brandPanel.createSequentialGroup()
							.addGap(180)
							.addComponent(lblBrand4)
							.addPreferredGap(ComponentPlacement.RELATED, 193, GroupLayout.PREFERRED_SIZE)))
					.addGap(403))
		);
		gl_brandPanel.setVerticalGroup(
			gl_brandPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_brandPanel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_brandPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBrand1)
						.addComponent(lblBrand2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBrand3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblBrand4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		brandPanel.setLayout(gl_brandPanel);
		
		txtUserName = new JTextField();
		txtUserName.setForeground(new Color(255, 255, 255));
		txtUserName.setBackground(new Color(61, 75, 89));
		txtUserName.setCaretColor(new Color(9, 15, 8));
		txtUserName.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtUserName.setToolTipText("Enter your username");
		txtUserName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(new Color(255, 255, 255));
		txtPassword.setBackground(new Color(61, 75, 89));
		txtPassword.setCaretColor(new Color(9, 15, 8));
		txtPassword.setToolTipText("Enter your password");
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtPassword.setEchoChar('*');
		
		lblUserName = new JLabel("Username:");
		lblUserName.setForeground(new Color(255, 255, 255));
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 30));
		
		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 30));
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this::btnLoginActionPerformed);
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(61, 75, 89));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(542)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLogin)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(lblUserName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(lblPassword)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(541, Short.MAX_VALUE))
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogin)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		mainPanel.setLayout(gl_mainPanel);
		form.setLayout(gl_form);
	}
	
	protected void btnLoginActionPerformed(ActionEvent e) {
		List<User> user =  new ArrayList<>();
		var dao = new UserDAO();
		user.addAll(dao.getUserList());
		
		String usrname_input = txtUserName.getText();
		String usrpsw_input =  new String(txtPassword.getPassword());
		
		if(usrname_input.isEmpty() || usrpsw_input.isEmpty()) {
		      JOptionPane.showMessageDialog(null, "Username or password cannot be empty!");
		      return;
		}
		
		for(var item : user) {
			if(item.getUsr_name().equals(usrname_input) && item.getUsr_pw().equals(usrpsw_input)) {
		        
				if(item.getUsr_type().equals("Admin")) {
					
		    		var adminMain = new AdminMain();
		    		adminMain.setVisible(true);
		    		this.dispose();
		    		
				} else if(item.getUsr_type().equals("Manager")) {

					var managerMain = new ManagerMain();
					managerMain.setVisible(true);
		    		this.dispose();
					
		    	} else {
		    		var salerMain = new SalerMain();
					salerMain.setVisible(true);
		    		this.dispose();
		    	}
		    	return;
			}
		}
		JOptionPane.showMessageDialog(null, "Username or password are incorrect");
	}
}
