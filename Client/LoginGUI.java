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
>>>>>>> a0fa085f58d915215188a0bb98f0e2bb8742b9f0
