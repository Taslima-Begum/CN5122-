<<<<<<< HEAD
import java.awt.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;

public class files extends JFrame {

	JFileChooser fc;

	public files() {
	
		setBounds(100, 100, 512, 325);
		fc = new JFileChooser(FileSystemView.getFileSystemView());
		fc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File selectedFile = fc.getSelectedFile();
				if(selectedFile.length()>50) {
					JOptionPane.showMessageDialog(null, "File too large. Maximum size:", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						FileInputStream fis = new FileInputStream(selectedFile);
						BufferedInputStream bis = new BufferedInputStream(fis);
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			}
		});
		fc.setDialogTitle("Send a file");
		setContentPane(fc);
		setVisible(true);
		setLocationRelativeTo(null);
	}

=======
import java.awt.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;

public class files extends JFrame {

	JFileChooser fc;

	public files() {
	
		setBounds(100, 100, 512, 325);
		fc = new JFileChooser(FileSystemView.getFileSystemView());
		fc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File selectedFile = fc.getSelectedFile();
				if(selectedFile.length()>50) {
					JOptionPane.showMessageDialog(null, "File too large. Maximum size:", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						FileInputStream fis = new FileInputStream(selectedFile);
						BufferedInputStream bis = new BufferedInputStream(fis);
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			}
		});
		fc.setDialogTitle("Send a file");
		setContentPane(fc);
		setVisible(true);
		setLocationRelativeTo(null);
	}

>>>>>>> a0fa085f58d915215188a0bb98f0e2bb8742b9f0
}