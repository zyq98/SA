package com.aliyun.mns.communication;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
//package awtDemo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
//import javax.swing.UIManager;
import javax.swing.JTextField;

import com.aliyun.mns.sample.Queue.ProducerDemo;
import com.aliyun.mns.sample.Queue.ComsumerDemo;

public class p2p extends JFrame implements ActionListener, 
MouseListener{
     // private int Sidesize=16;
	  private JButton jb1;  //发送
	  private JButton jb2;  //接收
	  
	  private JTextArea jt1;
	  private JTextArea jt2;
	  
	  private JLabel jtheme;

	public void init() {
		this.getContentPane().setBackground(new Color(178,200,187));
		
		
		      jtheme.setFont(new Font("Calibri",Font.BOLD,36));
		     jtheme.setText("Point to Point");
		     jtheme.setBounds(30, 20, 500, 30);
		     this.add(jtheme);
		     
		  
		        jb1.setMargin(new java.awt.Insets(0,0,0,0)); 
		        jb1.setBackground(new Color(69,137,148));
		     jb1.addActionListener(this);
		      //  jb[i][j].addMouseListener(this);
		        jb1.setName("jb1");
		        jb1.setBounds(400,100,100,30);  //设置位置
		        this.add(jb1);
		        

		        jb2.setMargin(new java.awt.Insets(0,0,0,0)); 
		        jb2.setBackground(new Color(69,137,148));
		        jb2.addActionListener(this);
		      //  jb[i][j].addMouseListener(this);
		        jb2.setName("jb2");
		        jb2.setBounds(400,200,100,30);  //设置位置
		        this.add(jb2);
		        
		        jt1.setBounds(80,100,300,90);
		        jt1.setBackground(new Color(255,245,247));
		        this.add(jt1);
		        
		        jt2.setBounds(80,200,300,90);
		        jt2.setBackground(new Color(255,245,247));
		        this.add(jt2);
		        
		        
		        this.setSize(550, 400);
		        this.setLocation(700, 100);
		        this.setResizable(false);
		        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		        this.setVisible(true);
	}
	
	
	public p2p(String title) {
		super(title);
		  this.setLayout(null);  //不使用布局管理器，每个控件的位置用setBounds设定
		    jb1 = new JButton("send");    // 初始化各种对象
		    jb2=new JButton("receive");
		    
		    jt1=new JTextArea();
		    jt2=new JTextArea();
		    
		    jtheme=new JLabel();

	}
     public static void main(String[] args) {
    	 p2p test=new p2p("piont to point");
    	 test.init();
    	 
    	 
    	// ProducerDemo produce=new ProducerDemo();
    	// produce.set("Hello,somobody!");
    	// produce.produce();
    	 
    	// ComsumerDemo comsume=new ComsumerDemo();
    	// comsume.comsume();
    	// comsume.get(com);
    	 
    	 
	}
     public void actionPerformed(ActionEvent e) {  //行为捕捉
    	    Object obj = e.getSource();
    	    int x, y;
    	    if ((obj instanceof JButton) == false) {
    	    
    	      return;
    	    }
    	    String tmp = ((JButton) obj).getName();  //得到所点击按钮的名称
    	    if(tmp=="jb1") {   //发送
    	   	 
    	    	String s=jt1.getText();
    	    	if(!s.equals("")) {
    	    	 ProducerDemo produce=new ProducerDemo();
    	    	 produce.set(s);
    	    	produce.produce();
    	    		jt1.setText("\""+s+" \" has been sent successfully");
    	    	}
    	    	else {
    	    		jt1.setText("Please write something down.");
    	    	}
    	    	
    	    }
    	    else if(tmp=="jb2") {
    	    	
    	    	String s="";
    	    	 ComsumerDemo comsume=new ComsumerDemo();
    	    	 comsume.comsume();
    	    	
    	    	if(! comsume.get(s).equals("")) {
    	    		
    	    	jt2.setText("Messages are received as follow :\n"+ comsume.get(s));
    	    	}
    	    	else {
    	    		jt2.setText("No message is received temporary:\n"+ comsume.get(s));
    	    	}
    	    	
    	    }
    	    
    	    
    	  }
     public void mouseClicked(MouseEvent e) {
    	 
     }
     public void mousePressed(MouseEvent e) {
     }
     @Override
     public void mouseReleased(MouseEvent e) {
     }
     @Override
   public void mouseEntered(MouseEvent e) {
     }
     @Override
     public void mouseExited(MouseEvent e) {
     }
}
