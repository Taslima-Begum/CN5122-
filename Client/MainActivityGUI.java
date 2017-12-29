package Client;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainActivityGUI implements ActionListener, ListSelectionListener {

	 static JFrame frame;
	 JList<chatGUI> chatList;
	 static DefaultListModel<chatGUI> d;
	 JButton Change;
	 NewChatGUI newChat;
	 JButton newPrivateChatBtn;
	 static ArrayList<String> onlineUsers;
	 static ArrayList<String> offlineUsers;
	 JList<String> onlineList;
	 chatGUI chat;
	 JButton newGroupChatBtn;
	 JButton deleteChatBtn;
	 static String screenName="Test";
	 JPanel panel ;
	 JSplitPane splitPane_3;
	 JPanel p ;
	 JButton cancelDeleteBtn;
	 
	public MainActivityGUI(ArrayList<String> onlineUsers, ArrayList<String>offlineUsers) {
		MainActivityGUI.onlineUsers=onlineUsers;
		MainActivityGUI.offlineUsers=offlineUsers;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 873, 589);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCustomize = new JMenu("Customize");
		mnCustomize.setBackground(Color.GRAY);
		menuBar.add(mnCustomize);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		mnCustomize.add(menuItem);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About");
		mnHelp.add(mntmNewMenuItem);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setEnabled(false);
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setEnabled(false);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setLeftComponent(splitPane_2);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setEnabled(false);
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_2.setRightComponent(splitPane_4);
		
		JLabel label = new JLabel("< Online Users >");
		splitPane_4.setLeftComponent(label);
		
		
		DefaultListModel<String> a= new DefaultListModel<String>();
		onlineList = new JList<String>(a);
		JScrollPane scrollPane_1 = new JScrollPane(onlineList);
		onlineList.addListSelectionListener(this);
		onlineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for(String q:MainActivityGUI.onlineUsers) {
				a.addElement(q);
		}
		splitPane_4.setRightComponent(scrollPane_1);
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 30));
		splitPane_2.setLeftComponent(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
//		ImageIcon userIcon = new ImageIcon(getClass().getResource("/images/user.png"));
		JLabel lblUsername = new JLabel("Screen name: "+screenName);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_3.add(lblUsername, BorderLayout.CENTER);
		
		Change = new JButton("Change");
		panel_3.add(Change, BorderLayout.EAST);
		Change.addActionListener(this);
		
		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setEnabled(false);
		splitPane_5.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setRightComponent(splitPane_5);
		
		JLabel label_1 = new JLabel("<Off-line Users >");
		splitPane_5.setLeftComponent(label_1);
		
		DefaultListModel<String> v= new DefaultListModel<String>();
		JList<String> offlineList = new JList<String>(v);	
		JScrollPane scrollPane_2 = new JScrollPane(offlineList);
		for(String q:offlineUsers) {
				v.addElement(q);
		}
		splitPane_5.setRightComponent(scrollPane_2);
		splitPane_1.setDividerLocation(275);
		
		splitPane_3 = new JSplitPane();
		splitPane_3.setEnabled(false);
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_3);
		
		panel = new JPanel();
		splitPane_3.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		d = new DefaultListModel<chatGUI>();
		chatList = new JList<chatGUI>(d);
		chatList.setFixedCellHeight(30);
		chatList.addListSelectionListener(this);
		chatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(chatList, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		splitPane_3.setLeftComponent(panel_5);
		
		newPrivateChatBtn = new JButton("+ New Private Chat");
		newPrivateChatBtn.addActionListener(this);
		panel_5.add(newPrivateChatBtn);
		
		newGroupChatBtn = new JButton("+ New Group Chat");
		panel_5.add(newGroupChatBtn);
		
		deleteChatBtn = new JButton("- Delete Chat");
		panel_5.add(deleteChatBtn);
		deleteChatBtn.addActionListener(this);
		newGroupChatBtn.addActionListener(this);
		splitPane.setDividerLocation(500);
		p =new JPanel();
		p.setLayout(new BorderLayout());
		cancelDeleteBtn = new JButton("Cancel");
		cancelDeleteBtn.addActionListener(this);
		p.add(new JLabel("Please select chat to delete:"),BorderLayout.CENTER);
		p.add(cancelDeleteBtn,BorderLayout.EAST);
		panel.add(p,BorderLayout.NORTH);
		p.setVisible(false);
		frame.setLocationRelativeTo(null);
	}
	
	 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newGroupChatBtn) {
			newChat = new NewChatGUI("group");
		}
		if(e.getSource()==newPrivateChatBtn) {
			newChat = new NewChatGUI("private");
		}
		if(e.getSource()==deleteChatBtn) {
			p.setVisible(true);
		}
		if(e.getSource()==cancelDeleteBtn) {
			p.setVisible(false);
		}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		if(onlineList.getSelectedIndex()!=-1) {
			boolean exists=false;
			for(chatGUI a :chats.listChats) {
				if(a.getChatName().equals(onlineList.getSelectedValue())){
					a.setVisible(true);
					exists=true;
				}
			}
			if(!exists) {
			chat =new chatGUI(NewChatGUI.createChatRoomName(onlineList.getSelectedValue()));
			chats.addchat(chat);
			}
			onlineList.clearSelection();
		}

		if(chatList.getSelectedIndex()!=-1) {
			if(p.isVisible()) {
				int res = JOptionPane.showConfirmDialog(null, "Are You Sure you want to delete "+chatList.getSelectedValue()+" ?", "Error", JOptionPane.YES_NO_OPTION);
				if(res==JOptionPane.YES_OPTION) {
					chats.removechat(chatList.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Chat deleted!", "", JOptionPane.ERROR_MESSAGE);
				}
				p.setVisible(false);
			}
			else {
			chats.listChats.get(chatList.getSelectedIndex()).setVisible(true);
			}
			chatList.clearSelection();
		}
		
	}
	
	

//	@Override
//	public Component getListCellRendererComponent(JList<? extends chatGUI> list, chatGUI chat, int index, boolean isSelected,
//			boolean cellHasFocus) {
//		ImageIcon i = new ImageIcon(getClass().getResource("/images/chat.png"));
//		JLabel a= new JLabel(chat.getChatName(),i,JLabel.LEFT);
//		if(isSelected) {
//			chats.listChats.get(index).setVisible(true);
//		}
//		isSelected=false;
//		return a;
//	}


	
}