
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NewChatGUI extends JFrame implements ActionListener {

	private JPanel contentPane = new JPanel();
	JTextField chatNameField = new JTextField();
	JLabel lblNewLabel = new JLabel("Start a new Chat");
	JButton nextBtn = new JButton("Next");
	JLabel lblEnterChatName = new JLabel("Chat Name:");
	JLabel errorLabel = new JLabel("");
	chatGUI a;
	
	public NewChatGUI() {
		setBounds(100, 100, 552, 438);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		contentPane.setLayout(null);
		lblNewLabel.setBounds(99, 9, 314, 45);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
	
		nextBtn.addActionListener(this);
		nextBtn.setBounds(405, 335, 95, 29);
		contentPane.add(nextBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 80, 468, 208);
		
		panel.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel);
		chatNameField.setBounds(151, 339, 209, 20);
		contentPane.add(chatNameField);
		chatNameField.setColumns(10);
		lblEnterChatName.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblEnterChatName.setBounds(60, 339, 81, 20);
		contentPane.add(lblEnterChatName);
		errorLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		errorLabel.setForeground(Color.RED);
		

		errorLabel.setBounds(151, 367, 209, 14);
		contentPane.add(errorLabel);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==nextBtn) {
			if(chatNameField.getText().equals("")) {
				errorLabel.setText("Error! Please enter Chat name");
			}
			else {
				a =new chatGUI(chatNameField.getText());
				chats.addchat(a);
				setVisible(false);
			}
			
		}
	}
}