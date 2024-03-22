package com.jdbc.app8.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jdbc.app8.action.User;

public class LoginFrame extends Frame implements ActionListener {

	Label l1,l2;
	TextField tf1,tf2;
	Button b;
	String status="";
	public LoginFrame() {
		this.setVisible(true);
		this.setSize(500,500 );
		this.setTitle("Login Frame");
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	
	l1=new Label("USERNAME");
	l2=new Label("PASSWORD");
	tf1=new TextField(20);
	tf2=new TextField(20);
	tf2.setEchoChar('*');
	b=new Button("Login");
	b.addActionListener(this);
	
	Font f=new Font("arial",Font.BOLD,20);
	l1.setFont(f);
	
	tf1.setFont(f);
	l2.setFont(f);
	
	tf2.setFont(f);
	b.setFont(f);
	
	this.add(l1);	this.add(tf1);
	this.add(l2);this.add(tf2);

	
	this.add(b);
	
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String uname=tf1.getText();
		String upwd=tf2.getText();
		User u=new User();
		status=u.checkLogin(uname,upwd);
		repaint();
	}
 public void paint(Graphics g) {
	 Font f=new Font("arial",Font.BOLD,30);
	 g.setFont(f);
	 g.drawString("Status :"+status, 50,100);
 }
}
