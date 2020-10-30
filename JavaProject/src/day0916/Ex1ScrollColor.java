package day0916;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

public class Ex1ScrollColor  extends JFrame{
	JScrollBar sbRed,sbGreen,sbBlue;
	JLabel lblRed,lblGreen,lblBlue;
	int red=223,green=196,blue=219;
	JLabel lblColor;

	public Ex1ScrollColor(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 300);//������ġx,y,ũ�� w,h
		this.getContentPane().setBackground(Color.white);//���������� �ִ� �г��� ���� ����
		//this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}

	public void setDesign()
	{
		this.setLayout(null);
		//�տ� ���� �κ�
		JLabel lbl1=new JLabel("Red");
		lbl1.setBounds(10, 20, 40, 20);
		this.add(lbl1);

		JLabel lbl2=new JLabel("Green");
		lbl2.setBounds(10, 100, 40, 20);
		this.add(lbl2);

		JLabel lbl3=new JLabel("Blue");
		lbl3.setBounds(10, 180, 40, 20);
		this.add(lbl3);

		//��ũ�ѹ� �κ�
		sbRed=new JScrollBar(JScrollBar.HORIZONTAL, red, 1, 0, 256);
		sbRed.setBounds(70, 20, 200, 20);
		this.add(sbRed);

		sbGreen=new JScrollBar(JScrollBar.HORIZONTAL, green, 1, 0, 256);
		sbGreen.setBounds(70, 100, 200, 20);
		this.add(sbGreen);

		sbBlue=new JScrollBar(JScrollBar.HORIZONTAL, blue, 1, 0, 256);
		sbBlue.setBounds(70, 180, 200, 20);
		this.add(sbBlue);

		//��-���� ��ºκ�
		lblRed=new JLabel(String.valueOf(red),JLabel.CENTER);
		lblRed.setBounds(280, 20, 40, 20);
		lblRed.setBorder(new LineBorder(Color.red));
		this.add(lblRed);

		lblGreen=new JLabel(String.valueOf(green),JLabel.CENTER);
		lblGreen.setBounds(280, 100, 40, 20);
		lblGreen.setBorder(new LineBorder(Color.green));
		this.add(lblGreen);

		lblBlue=new JLabel(String.valueOf(blue),JLabel.CENTER);
		lblBlue.setBounds(280, 180, 40, 20);
		lblBlue.setBorder(new LineBorder(Color.blue));
		this.add(lblBlue);

		//���� �� �κ�
		lblColor=new JLabel();
		lblColor.setOpaque(true);//���������
		lblColor.setBackground(new Color(red,green,blue));
		lblColor.setBounds(340, 20, 130, 180);
		this.add(lblColor);

		//red ��ũ�ѹ� �̺�Ʈ
		sbRed.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				//��ũ�ѵ� ���尪�� red������ ����
				red=sbRed.getValue();//��ũ���ϴ� ���簪���� ��ȯ
				//�󺧿� ���
				lblRed.setText(String.valueOf(red));
				//Į�� Ŭ���� ������ ���� ���� ����
				Color color=new Color(red,green,blue);
				lblColor.setBackground(color);
			}
		});

		//green
		sbGreen.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				//��ũ�ѵ� ���尪�� red������ ����
				green=sbGreen.getValue();//��ũ���ϴ� ���簪���� ��ȯ
				//�󺧿� ���
				lblGreen.setText(String.valueOf(green));
				//Į�� Ŭ���� ������ ���� ���� ����
				Color color=new Color(red,green,blue);
				lblColor.setBackground(color);
			}
		});
		//blue
		sbBlue.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				//��ũ�ѵ� ���尪�� red������ ����
				blue=sbBlue.getValue();//��ũ���ϴ� ���簪���� ��ȯ
				//�󺧿� ���
				lblBlue.setText(String.valueOf(blue));
				//Į�� Ŭ���� ������ ���� ���� ����
				Color color=new Color(red,green,blue);
				lblColor.setBackground(color);
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex1ScrollColor("����ǥ");
	}

}






