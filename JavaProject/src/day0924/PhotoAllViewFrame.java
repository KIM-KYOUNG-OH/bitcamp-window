package day0924;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PhotoAllViewFrame  extends JFrame{
	//������ ����Ʈ�� �޾ƿ�
	List<String> photoList=new ArrayList<String>();
	
	public PhotoAllViewFrame(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(900, 100, 510, 600);//������ġx,y,ũ�� w,h
		this.getContentPane().setBackground(Color.white);//���������� �ִ� �г��� ���� ����
		//this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
//		this.setVisible(true);//���̰� �ϱ�
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		int x=20,y=50;
		for(int i=0;i<photoList.size();i++)
		{
			String photo=photoList.get(i);
			Image image=new ImageIcon(photo).getImage();
			g.drawImage(image, x, y, 150,180,this);	
			g.drawRect(x, y,150,180);//�׵θ���(���൵��)
			x+=160;
			if((i+1)%3==0)//���ٿ� 3���� ���
			{
				y+=190;
				x=20;
			}
		}
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		PhotoAllViewFrame add=new PhotoAllViewFrame("photo");
//	}

}







