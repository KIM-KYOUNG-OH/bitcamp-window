package day0924;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PhotoAllViewFrame  extends JFrame{
	//사진명만 리스트에 받아옴
	List<String> photoList=new ArrayList<String>();
	
	public PhotoAllViewFrame(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(900, 100, 510, 600);//시작위치x,y,크기 w,h
		this.getContentPane().setBackground(Color.white);//프레임위에 있는 패널의 색상 변경
		//this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
//		this.setVisible(true);//보이게 하기
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
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
			g.drawRect(x, y,150,180);//테두리선(안줘도됨)
			x+=160;
			if((i+1)%3==0)//한줄에 3개씩 출력
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







