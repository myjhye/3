package com.sist.client;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;
// Network 
public class WaitForm extends JPanel{
	JTable table;
	DefaultTableModel model;
	JTextArea ta;
	JTextField tf;
	JButton b1,b2;
    public WaitForm()
    {
    	String[] col={"ID","Name","Sex"};
    	String[][] row=new String[0][3];
    	model=new DefaultTableModel(row,col);
    	table=new JTable(model);
    	JScrollPane js1=new JScrollPane(table);
    	
    	ta=new JTextArea();
    	ta.setEditable(false);
    	JScrollPane js2=new JScrollPane(ta);
    	
    	tf=new JTextField();
    	
    	b1=new JButton("쪽지보내기");
    	b2=new JButton("정보보기");
    	
    	// 배치
    	setLayout(null);// 사용자 정의
    	js2.setBounds(0, 15, 250, 250);
    	add(js2);
    	
    	tf.setBounds(0, 270, 250, 30);
    	add(tf);
    	
    	js1.setBounds(0, 320 , 250, 250);
    	add(js1);
    	
    	JPanel p=new JPanel();
    	p.add(b1);
    	p.add(b2);
    	p.setBounds(0, 580, 250, 35);
    	add(p);
    	
    }
}