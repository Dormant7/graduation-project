package gsp;
/**
 * 梅冬
 */
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

//import project.hello.TextKeyListener;
import java.io.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GUI extends Frame implements ActionListener{
	 
	 int value = 2;
     JFrame f;
     JTextArea ta, tb;   //ta用于显示打开的内容
     JButton btn, btn1;
     JLabel jlb;
     JTextField jtf;
     FileDialog fd;
     File file1 = null;
     
     //构造函数开始
     public GUI()
     {
    	  //初始化各个组件
          btn = new JButton("打开文件");
          btn1 = new JButton("运行程序");
          ta = new JTextArea(20,20);
          tb = new JTextArea(20,28);
          jlb = new JLabel("最小阈值");
          jtf = new JTextField(10);   
          
          btn.addActionListener(this );  //给按钮btn添加事件监听器
          btn1.addActionListener(this);   //给按钮btn1添加行为
         // jtf.addKeyListener(this);  //给文本框添加按键事件监听器
     }
     
      //给按钮btn添加行为
    	    
      public void actionPerformed(ActionEvent e){  
                  
    	   if (e.getActionCommand().equals("打开文件")) { //单击打开按钮时   
              fd = new FileDialog(f,"Open",FileDialog.LOAD);
              fd.setVisible(true);   //创建并显示打开文件对话框
               
              try {   //以缓冲区方式读取文件内容
               
                  file1 = new File(fd.getDirectory(),fd.getFile());
                  FileReader fr = new FileReader(file1);
                  BufferedReader br = new BufferedReader(fr);
                  String aline;
                  while ((aline=br.readLine()) != null)//按行读取文本
                  ta.append(aline+"\r\n");
                  fr.close();
                  br.close();
                  }
                  catch (IOException ioe){
                  System.out.println(ioe);
                  }
            }         
   //     }          
              
   
     
   
       //给按钮btn1添加事件监听器
    //   public void actionPerformed(ActionEvent e){
      else if(e.getActionCommand().equals("运行程序")) 
    	   try {
    	    String s = jtf.getText();
    	    value=Integer.parseInt(s);
       	 //System.out.println(s);
    	   GSP gsp = new GSP(this.value); 
    	   ArrayList<Sequence> result = gsp.getSequences();
    	   
           String encoding="GBK";
           File file=new File("d:\\data.txt");
           if(file.isFile() && file.exists()){ //判断文件是否存在
               InputStreamReader read = new InputStreamReader(
               new FileInputStream(file),encoding);//考虑到编码格式
               BufferedReader bufferedReader = new BufferedReader(read);
               String lineTxt = null;
               while((lineTxt = bufferedReader.readLine()) != null){
            	   tb.append(lineTxt + "\r\n");
               }
               read.close();
               file.delete();
           }else{
              System.out.println("找不到指定的文件");
              }
          } catch (Exception p) {
            System.out.println("读取文件内容出错");
            p.printStackTrace();
         }
      }
  
      public void show()
      { 
    	  
           f = new JFrame("GSP算法");         //初始化对象f
           f.setSize(580,460);               //设置窗口f的大小
         //设置布局管理器为FlowLayout
           f.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
           f.add(btn);  
           f.add(jlb);
           f.add(jtf);
           f.add(btn1);
           f.add(ta);  
           f.add(tb);
           f.setResizable(false);
       //////
     	  ImageIcon img = new ImageIcon("0.jpg");
     	  JLabel imgLabel = new JLabel(img);
     	  f.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
     	  imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
     	  //////
           f.setLocation(300,300);
           f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
           f.setVisible(true);                //设置窗口f可视
    }
     public static void main(String[] args) {
  		// TODO Auto-generated method stub
  	//  GSP gsp = new GSP(2);

      //ArrayList<Sequence> result = gsp.getSequences();
        GUI iof = new GUI();//创建并初始化IOtest对象iof
     //   iof.show();
        
        iof.show();
     }
      
}

