<<<<<<< HEAD

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.ListCellRenderer;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Label;
import java.awt.List;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import javax.swing.ListSelectionModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class MainActivityGUI implements ActionListener, ListSelectionListener {

	 static JFrame frame;
	 JList<chatGUI> chatList;
	 static DefaultListModel<chatGUI> d;
	 JButton Change;
	 NewChatGUI newChat;
	 JButton newChatBtn;
	 ArrayList<String> onlineUsers;
	 ArrayList<String> offlineUsers;
	public MainActivityGUI(ArrayList<String> onlineUsers, ArrayList<String>offlineUsers) {
		initialize();
		frame.setVisible(true);
		this.onlineUsers=onlineUsers;
		this.offlineUsers=offlineUsers;
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
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setEnabled(false);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setLeftComponent(splitPane_2);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_2.setRightComponent(splitPane_4);
		
		JLabel label = new JLabel("< Online Users >");
		splitPane_4.setLeftComponent(label);
		
		JPanel panel_1 = new JPanel();
		splitPane_4.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		DefaultListModel<String> a= new DefaultListModel<String>();
		JList<String> onlineList = new JList<String>(a);
		
		for(String q:onlineUsers) {
			a.addElement(q);
		}
		
		panel_1.add(onlineList, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 30));
		splitPane_2.setLeftComponent(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
//		ImageIcon userIcon = new ImageIcon(getClass().getResource("/images/user.png"));
		JLabel lblUsername = new JLabel("Screen name");
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
		
		JPanel panel_2 = new JPanel();
		splitPane_5.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		DefaultListModel<String> v= new DefaultListModel<String>();
		JList<String> offlineList = new JList<String>(v);
		for(String q:offlineUsers) {
			v.addElement(q);
		}
		panel_2.add(offlineList, BorderLayout.CENTER);
		
		newChat = new NewChatGUI();
		newChat.setVisible(false);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setEnabled(false);
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_3);
		
		newChatBtn = new JButton("+New chat");
		newChatBtn.addActionListener(this);
		splitPane_3.setLeftComponent(newChatBtn);
		
		JPanel panel = new JPanel();
		splitPane_3.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		d = new DefaultListModel<chatGUI>();
		chatList = new JList<chatGUI>(d);
		chatList.setFixedCellHeight(30);
		chatList.addListSelectionListener(this);

		chatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(chatList, BorderLayout.CENTER);
		splitPane.setDividerLocation(500);
		
		frame.setLocationRelativeTo(null);
		
	}
	
	 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newChatBtn) {
			newChat.chatNameField.setText("");
			newChat.setVisible(true);
		}
		
	}
	
	public void valueChanged(ListSelectionEvent e) {
		if(chatList.getSelectedIndex()!=-1) {
			chats.listChats.get((chatList.getSelectedIndex())).setVisible(true);
		}
	}
//	private static void addPopup(Component component, final JPopupMenu popup) {
//		component.addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
//			public void mouseReleased(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
//			private void showMenu(MouseEvent e) {
//				popup.show(e.getComponent(), e.getX(), e.getY());
//			}
//		});
//	}

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


	
=======

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.ListCellRenderer;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Label;
import java.awt.List;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import javax.swing.ListSelectionModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class MainActivityGUI implements ActionListener, ListSelectionListener {

	 static JFrame frame;
	 JList<chatGUI> chatList;
	 static DefaultListModel<chatGUI> d;
	 JButton Change;
	 NewChatGUI newChat;
	 JButton newChatBtn;
	 ArrayList<String> onlineUsers;
	 ArrayList<String> offlineUsers;
	public MainActivityGUI(ArrayList<String> onlineUsers, ArrayList<String>offlineUsers) {
		initialize();
		frame.setVisible(true);
		this.onlineUsers=onlineUsers;
		this.offlineUsers=offlineUsers;
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
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setEnabled(false);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setLeftComponent(splitPane_2);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_2.setRightComponent(splitPane_4);
		
		JLabel label = new JLabel("< Online Users >");
		splitPane_4.setLeftComponent(label);
		
		JPanel panel_1 = new JPanel();
		splitPane_4.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		DefaultListModel<String> a= new DefaultListModel<String>();
		JList<String> onlineList = new JList<String>(a);
		
		for(String q:onlineUsers) {
			a.addElement(q);
		}
		
		panel_1.add(onlineList, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 30));
		splitPane_2.setLeftComponent(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
//		ImageIcon userIcon = new ImageIcon(getClass().getResource("/images/user.png"));
		JLabel lblUsername = new JLabel("Screen name");
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
		
		JPanel panel_2 = new JPanel();
		splitPane_5.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		DefaultListModel<String> v= new DefaultListModel<String>();
		JList<String> offlineList = new JList<String>(v);
		for(String q:offlineUsers) {
			v.addElement(q);
		}
		panel_2.add(offlineList, BorderLayout.CENTER);
		
		newChat = new NewChatGUI();
		newChat.setVisible(false);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setEnabled(false);
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_3);
		
		newChatBtn = new JButton("+New chat");
		newChatBtn.addActionListener(this);
		splitPane_3.setLeftComponent(newChatBtn);
		
		JPanel panel = new JPanel();
		splitPane_3.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		d = new DefaultListModel<chatGUI>();
		chatList = new JList<chatGUI>(d);
		chatList.setFixedCellHeight(30);
		chatList.addListSelectionListener(this);

		chatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(chatList, BorderLayout.CENTER);
		splitPane.setDividerLocation(500);
		
		frame.setLocationRelativeTo(null);
		
	}
	
	 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newChatBtn) {
			newChat.chatNameField.setText("");
			newChat.setVisible(true);
		}
		
	}
	
	public void valueChanged(ListSelectionEvent e) {
		if(chatList.getSelectedIndex()!=-1) {
			chats.listChats.get((chatList.getSelectedIndex())).setVisible(true);
		}
	}
//	private static void addPopup(Component component, final JPopupMenu popup) {
//		component.addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
//			public void mouseReleased(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
//			private void showMenu(MouseEvent e) {
//				popup.show(e.getComponent(), e.getX(), e.getY());
//			}
//		});
//	}

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


	
>>>>>>> a0fa085f58d915215188a0bb98f0e2bb8742b9f0
}