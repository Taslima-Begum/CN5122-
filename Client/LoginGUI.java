<<<<<<< HEAD


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LoginGUI implements ActionListener{

	 static JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField = new JPasswordField();
	JButton loginBtn = new JButton("Login");
	String salt = BCrypt.gensalt();
	JButton registerBtn = new JButton("Register");
	MainActivityGUI window;
	public LoginGUI() {
	
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 250));
		frame.setBounds(100, 100, 521, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		loginBtn.addActionListener(this);
		loginBtn.setBounds(124, 286, 89, 23);
		frame.getContentPane().add(loginBtn);

		registerBtn.setBounds(276, 286, 89, 23);
		registerBtn.addActionListener(this);
		frame.getContentPane().add(registerBtn);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setBounds(124, 80, 76, 14);
		frame.getContentPane().add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(125, 105, 240, 28);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PASSWORD:");
		lblNewLabel.setBounds(124, 162, 76, 22);
		frame.getContentPane().add(lblNewLabel);
		
		
		passwordField.setBounds(125, 195, 240, 28);
		frame.getContentPane().add(passwordField);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginBtn) {
			Message m = new Message("[LOGIN]",usernameField.getText(),BCrypt.hashpw(passwordField.getText(), salt));
			Communication.send(m);
		}
		if(e.getSource()==registerBtn) {
			frame.setVisible(false);
			RegisterGUI r = new RegisterGUI();
		
			
		}
		
	}
}
=======
package Client;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LoginGUI implements ActionListener{

	static JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField = new JPasswordField();
	private JButton loginBtn = new JButton("Login");
	private String salt = BCrypt.gensalt();
	private JButton registerBtn = new JButton("Register");
	private static JLabel errorLabel;
	
	public LoginGUI() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 250));
		frame.setBounds(100, 100, 521, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		loginBtn.addActionListener(this);
		loginBtn.setBounds(275, 316, 89, 23);
		frame.getContentPane().add(loginBtn);

		registerBtn.setBounds(125, 316, 89, 23);
		registerBtn.addActionListener(this);
		frame.getContentPane().add(registerBtn);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setBounds(124, 187, 76, 14);
		frame.getContentPane().add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(124, 202, 240, 28);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PASSWORD:");
		lblNewLabel.setBounds(124, 241, 76, 22);
		frame.getContentPane().add(lblNewLabel);
		
		
		passwordField.setBounds(124, 261, 240, 28);
		frame.getContentPane().add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBounds(107, 31, 270, 129);
		frame.getContentPane().add(panel);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(218, 350, 46, 14);
		frame.getContentPane().add(errorLabel);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginBtn) {
			Communication.send(new Message("LOGIN",usernameField.getText(),BCrypt.hashpw(passwordField.getText(), salt)));
		}
		if(e.getSource()==registerBtn) {
			RegisterGUI r = new RegisterGUI();
		}
		
	}
}
>>>>>>> ce77366b3ec70f731b58bae5fa0255ec2e23d551
