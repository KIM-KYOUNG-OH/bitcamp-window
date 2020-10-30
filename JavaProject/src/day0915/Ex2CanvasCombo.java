package day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex2CanvasCombo  extends JFrame implements ActionListener{
	
	String []title= {"��","��","�簢��","�̹���","���ڿ�"};
	JComboBox<String> combo;
	SelectDraw draw;
	int idx=4;//�ʱⰪ�� ���ڿ�
	String imageName="D:\\java0901\\image\\�Ϳ��� ������\\c7.png";
	Image image;
	Color fcolor;
	int x,y;
	
	public Ex2CanvasCombo(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 400, 500);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//������ �ε����� ������� idx�� ����
		idx=combo.getSelectedIndex();
		//ĵ�ٽ��� paint �޼��� ȣ��
		draw.repaint();
	}
	
	//������ ����� ��ġ�� �����ִ� �޼���
	public void changeColorAndPosition()
	{
		int r=(int)(Math.random()*256);//0~255
		int gr=(int)(Math.random()*256);//0~255
		int b=(int)(Math.random()*256);//0~255
		//��ġ�� �����ϰ�
		x=(int)(Math.random()*300);//0~299
		y=(int)(Math.random()*300)+50;//50~349
		
		fcolor=new Color(r, gr, b);
	}
	
	//ĵ�ٽ� ���� Ŭ����
	class SelectDraw extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			switch (idx) {
			case 0://��		
				for(int i=1;i<=30;i++)
				{
					changeColorAndPosition();
					g.setColor(fcolor);//���� ����
					g.drawLine(x, y, x+200,y);
				}
				break;
			case 1://��	
				for(int i=1;i<=30;i++)
				{
					changeColorAndPosition();
					g.setColor(fcolor);//��ä������ ����
					g.fillOval(x, y, 50, 50);
				}
				break;
			case 2://�簢��
				for(int i=1;i<=30;i++)
				{
					changeColorAndPosition();
					g.setColor(fcolor);//�簢��ä������ ��a��
					g.fillRect(x, y, 50, 50);
				}
				break;
			case 3://�̹���
				image=new ImageIcon(imageName).getImage();
				for(int i=1;i<=5;i++)
				{
					changeColorAndPosition();
					g.drawImage(image, x, y, 100, 150, this);
				}
				break;
			case 4://���ڿ�
			{
				changeColorAndPosition();//�����ϰ� ����� ��ġ���ϱ�
				g.setColor(fcolor);//���ڻ� ����
				g.setFont(new Font("Comic Sans MS",Font.BOLD,22));//�۲� ����
				g.drawString("Happy Day", x, y);//ĵ�ٽ��� ���ڿ� ���
				break;
			}
			}
		}
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		JLabel lbl=new JLabel("Select ComboBox");
		lbl.setBounds(10, 10, 150, 30);
		this.add(lbl);
		
		combo=new JComboBox<String>(title);
		combo.setSelectedIndex(idx);//�ʱⰪ ����
		combo.setBounds(180, 10, 100, 30);
		this.add(combo);
		combo.addActionListener(this);//�̺�Ʈ
		
		//ĵ�ٽ� �߰�
		draw=new SelectDraw();
		draw.setBounds(0, 80, 400, 400);
		this.add(draw);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex2CanvasCombo("�׷��� ����");
	}

}




