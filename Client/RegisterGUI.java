<<<<<<< HEAD

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterGUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton btnRegister;

	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel lblRegister = new JLabel("Register");
		panel_2.add(lblRegister);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JLabel lblScreenName = new JLabel("Screen Name:");
		panel_3.add(lblScreenName);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblUsername = new JLabel("UserName:");
		panel.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Password:");
		panel_1.add(lblNewLabel);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		btnRegister = new JButton("Register");
		panel_4.add(btnRegister);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegister) {
			 
		}
		
	}

=======
package Client;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class RegisterGUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnRegister;
	private JTextField usernameField, passwordField, screenNameField, confirmPasswordField;
	private JLabel errorLabel;

	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		usernameField = new JTextField();
		usernameField.setBounds(223, 135, 125, 20);
		contentPane.add(usernameField);
		usernameField.setHorizontalAlignment(SwingConstants.LEFT);
		usernameField.setColumns(10);

		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(133, 138, 80, 14);
		contentPane.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(143, 171, 70, 14);
		contentPane.add(lblNewLabel);

		JLabel lblScreenName = new JLabel("Screen Name:");
		lblScreenName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScreenName.setBounds(123, 105, 90, 14);
		contentPane.add(lblScreenName);

		JLabel lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(179, 45, 73, 14);
		contentPane.add(lblRegister);

		btnRegister = new JButton("Register");
		btnRegister.setBounds(179, 268, 93, 20);
		btnRegister.addActionListener(this);
		contentPane.add(btnRegister);

		passwordField = new JTextField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setColumns(10);
		passwordField.setBounds(223, 168, 125, 20);
		contentPane.add(passwordField);

		screenNameField = new JTextField();
		screenNameField.setHorizontalAlignment(SwingConstants.LEFT);
		screenNameField.setColumns(10);
		screenNameField.setBounds(223, 102, 125, 20);
		contentPane.add(screenNameField);

		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmPassword.setBounds(68, 202, 145, 14);
		contentPane.add(lblConfirmPassword);

		confirmPasswordField = new JTextField();
		confirmPasswordField.setHorizontalAlignment(SwingConstants.LEFT);
		confirmPasswordField.setColumns(10);
		confirmPasswordField.setBounds(223, 199, 125, 20);
		contentPane.add(confirmPasswordField);

		errorLabel = new JLabel("");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setBounds(123, 243, 225, 14);
		contentPane.add(errorLabel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegister) {
			if(usernameField.getText().isEmpty()||screenNameField.getText().isEmpty()||passwordField.getText().isEmpty()||confirmPasswordField.getText().isEmpty()) {
				errorLabel.setText("Incomplete fields");
			}
			if(usernameField.getText().contains("_")) {
				errorLabel.setText("Invalid \"_\" character entered.");
			}
			else {
				if(!passwordField.getText().equals(confirmPasswordField.getText())) {
					errorLabel.setText("Passwords do not match");
				}
				else {
					Message m = new Message("REGISTER",screenNameField.getText(),usernameField.getText(),confirmPasswordField.getText());
					Communication.send(m);
				}
			}
		}
	}
>>>>>>> ce77366b3ec70f731b58bae5fa0255ec2e23d551
}