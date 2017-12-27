
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class chatGUI extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	JTextArea messages;
	JTextArea listOfUsers ;
	JLabel ChatName;
	JButton sendBtn = new JButton("Send");
	JTextArea text = new JTextArea();
	JButton attachFileBtn;
	
	public chatGUI(String chatName){	

		setBounds(100, 100, 596, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 40));
		panel_2.setMinimumSize(new Dimension(23, 29));
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		ChatName = new JLabel(chatName);
		panel_2.add(ChatName);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setEnabled(false);
		splitPane_2.setPreferredSize(new Dimension(179, 37));
		splitPane.setLeftComponent(splitPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane_2.setLeftComponent(scrollPane_1);
		
		messages = new JTextArea();
		messages.setEditable(false);
		scrollPane_1.setViewportView(messages);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		splitPane_2.setRightComponent(scrollPane_2);
		
		listOfUsers = new JTextArea();
		listOfUsers.setEditable(false);
		scrollPane_2.setViewportView(listOfUsers);
		splitPane_2.setDividerLocation(375);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton emojiBtn = new JButton(":)");
		panel_3.add(emojiBtn);
		
		attachFileBtn = new JButton("Send File");
		attachFileBtn.addActionListener(this);
		panel_3.add(attachFileBtn);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_3.add(btnNewButton_4);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setEnabled(false);
		panel.add(splitPane_1, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setRightComponent(panel_1);
		
		sendBtn.addActionListener(this);
		sendBtn.setBounds(10, 21, 87, 38);
		panel_1.setLayout(null);
		panel_1.add(sendBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane);
		
		text.setText("Enter text here....");
		text.setMargin(new Insets(10, 10, 10, 10));
		scrollPane.setViewportView(text);
		splitPane_1.setDividerLocation(450);
		splitPane.setDividerLocation(250);
		setContentPane(contentPane);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public String getChatName() {
		return ChatName.getText();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sendBtn) {
		}
		if(e.getSource()==attachFileBtn) {
			files f=new files();
		}
	}
	
	public String toString() {
		return getChatName();
	}
	
	

}