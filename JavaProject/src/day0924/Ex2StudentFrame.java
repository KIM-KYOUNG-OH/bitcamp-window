package day0924;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Ex2StudentFrame  extends JFrame implements ActionListener{
	JButton btnInsert;
	AddStudent addFrame=new AddStudent("�����߰�");
	//dao ����
	StudentDao dao=new StudentDao();

	//�̸������ ����� List(awt)
	List lstNames;
	//��ü ����Ÿ�� ������ List(util)
	java.util.List<StudentDto> list=new ArrayList<StudentDto>();

	//��� Ŭ���� ����Ÿ ��½�Ű�� ���� ���� ����
	DrawPhoto drawPhoto=new DrawPhoto();
	JLabel lblName,lblHp,lblAddr,lblAge,lblWriteDay;
	Image photoImage;

	//����
	JButton btnDelete;

	//����
	JButton btnUpdate;
	UpdateStudent updateFrame=new UpdateStudent("��������");
	
	//���� ��ƺ���
	JButton btnPhotoView;

	public Ex2StudentFrame(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 500);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}

	public void setDesign()
	{
		this.setLayout(null);
		//�߰� ��ư
		btnInsert=new JButton("�л������߰�");
		btnInsert.setBounds(10, 10, 130, 25);
		this.add(btnInsert);
		//�̺�Ʈ
		btnInsert.addActionListener(this);
		//�߰����� add ��ư�̺�Ʈ
		addFrame.btnAdd.addActionListener(this);

		//awt.List �߰�
		lstNames=new List();
		JScrollPane jsp=new JScrollPane(lstNames);
		jsp.setBounds(10, 100, 130, 300);
		this.add(jsp);
		this.writeNames();

		//�л� ����Ÿ ����ϱ� ���� ������Ʈ�� ��ġ�ϱ�
		photoImage=new ImageIcon("D:\\java0901\\image\\�Ϳ��� ������\\c1.png").getImage();//�׽�Ʈ���̹���
		drawPhoto.setBounds(180, 100, 120, 140);
		this.add(drawPhoto);

		//�̸�
		lblName=new JLabel("�̸� : xxxx");
		lblName.setBounds(180, 270, 200, 30);
		this.add(lblName);

		//�ڵ���
		lblHp=new JLabel("�ڵ��� : xxxx");
		lblHp.setBounds(180, 300, 200, 30);
		this.add(lblHp);

		//�ּ�
		lblAddr=new JLabel("��  �� : xxxx");
		lblAddr.setBounds(180, 330, 200, 30);
		this.add(lblAddr);

		//����
		lblAge=new JLabel("��  �� : xxxx");
		lblAge.setBounds(180, 360, 200, 30);
		this.add(lblAge);

		//�����
		lblWriteDay=new JLabel("����� : xxxxxxxxx",JLabel.CENTER);
		lblWriteDay.setBounds(150, 50, 250, 30);
		lblWriteDay.setBorder(new LineBorder(Color.gray,2));
		this.add(lblWriteDay);

		//��� Ŭ����
		lstNames.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//������ �ε��� ���
				int idx=lstNames.getSelectedIndex();
				//System.out.println(idx);
				//idx ������ dto�� list ���� ������
				StudentDto dto=list.get(idx);
				//�̹��� ���
				photoImage=new ImageIcon(dto.getPhoto()).getImage();
				//����Ŭ������ paint �޼��� ȣ��
				drawPhoto.repaint();

				//�̸�,�ڵ���,�ּ�,����,��Ͻð� ���
				//����:���̿��� ����⵵ ������ Calendar ����غ���
				//��Ͻð��� yyyy-MM-dd HH:mm �������� ����ϱ�
				lblName.setText("��  �� : "+dto.getName());
				lblHp.setText("�ڵ��� : "+dto.getHp());
				lblAddr.setText("��  �� : "+dto.getAddr());

				//���� ���
				//���� �⵵
				Calendar cal=Calendar.getInstance();
				int currYear=cal.get(Calendar.YEAR);
				int age=currYear-dto.getBirthyear()+1;
				lblAge.setText("��  ��  : "+String.valueOf(age)+" ��");

				//������
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

				//TimeZone tz=TimeZone.getTimeZone("America/New_York");
				//sdf.setTimeZone(tz);
				lblWriteDay.setText("����� : "+sdf.format(dto.getWriteday()));				
			}
		});	

		//���� ��ư �߰�
		btnDelete=new JButton("�л���������");
		btnDelete.setBounds(150, 10, 130, 25);
		btnDelete.addActionListener(this);//�̺�Ʈ
		this.add(btnDelete);

		//���� ��ư �߰�
		btnUpdate=new JButton("�л���������");
		btnUpdate.setBounds(290, 10, 130, 25);
		btnUpdate.addActionListener(this);//�̺�Ʈ
		updateFrame.btnUpdate.addActionListener(this);//�������� �ִ� ������ư
		this.add(btnUpdate);
		
		//���� ��ƺ���
		btnPhotoView=new JButton("���� ��ƺ���");
		btnPhotoView.setBounds(250, 400, 200, 30);
		this.add(btnPhotoView);
		btnPhotoView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PhotoAllViewFrame photo=new PhotoAllViewFrame("������ƺ���");
				for(StudentDto dto:list)
				{
					photo.photoList.add(dto.getPhoto());//������ �߰�
				}
				photo.setVisible(true);
			}
		});
	}

	//list �� �̸� ����ϱ� ���� �޼���
	public void writeNames()
	{
		//���� ���â�� �̸��� ��� ������ �ҷ�����
		lstNames.removeAll();
		//db���� ����Ÿ ��������
		list=dao.getAllDatas();
		//��Ͽ� �߰�
		for(StudentDto dto:list)
		{
			lstNames.add(dto.getName());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btnInsert)//db�߰� ��ư
		{
			addFrame.setVisible(true);
		}else if(ob==addFrame.btnAdd)//�߰��������� �߰���ư
		{
			//addFrame ���� �Է��� �� ��������
			String name=addFrame.txtName.getText();
			String photo=addFrame.lblPhoto.getText();
			String hp=addFrame.txtHp.getText();
			String addr=addFrame.txtAddr.getText();
			String birth=addFrame.cbBirth.getSelectedItem().toString();
			if(name.length()==0 || photo.length()==0 || hp.length()==0||addr.length()==0)
			{
				JOptionPane.showMessageDialog(this, "�Է¾��� �׸��� �ֽ��ϴ�");
				return;//�޼��� ����
			}

			//dto������ �� �־��ֱ�
			StudentDto dto=new StudentDto();
			dto.setName(name);
			dto.setAddr(addr);
			dto.setHp(hp);
			dto.setPhoto(photo);
			dto.setBirthyear(Integer.parseInt(birth));

			//insert �޼��� ȣ���ϱ�
			dao.studentInsert(dto);
			//��� �ٽ� ���
			this.writeNames();

			//�Է°� �ʱ�ȭ�ϱ�
			addFrame.txtName.setText("");
			addFrame.txtHp.setText("");
			addFrame.txtAddr.setText("");
			addFrame.lblPhoto.setText("");

			//�߰������� �Ⱥ��̰� ó���ϱ�
			addFrame.setVisible(false);
		}else if(ob==btnDelete)//������ư
		{
			//��Ͽ��� ������ �ε���
			int idx=lstNames.getSelectedIndex();			
			//������
			String item=lstNames.getSelectedItem();			
			System.out.println(idx+","+item);//-1,null

			//���þ�������� -1,null ���� ������� �ᵵ �������
			if(idx==-1)
			{
				JOptionPane.showMessageDialog(this, "������ �̸��� ��Ͽ��� �����ϼ���");
				return;//�޼��� ����				
			}

			//���� �޼��� ȣ��
			dao.studentDelete(item);
			//��� �ٽ� ���
			this.writeNames();
		}else if(ob==btnUpdate)//�л�����������ư
		{
			//��Ͽ��� ������ �ε����� ��´�
			int idx=lstNames.getSelectedIndex();
			//idx�� -1�̸� "���" �޼����� �޼�������
			if(idx==-1)
			{
				JOptionPane.showMessageDialog(this, "������ �̸��� �������ּ���");
				return;
			} 
			//list ���� idx�� �ִ� dto ������
			StudentDto dto=list.get(idx);		
			//dto �� ������ �������� num ������ �ؽ�Ʈ,�󺧿� ��½�Ű��(�⵵�� �޺��ڽ���)
			updateFrame.num=dto.getNum();
			updateFrame.txtName.setText(dto.getName());
			updateFrame.txtHp.setText(dto.getHp());
			updateFrame.txtAddr.setText(dto.getAddr());
			updateFrame.lblPhoto.setText(dto.getPhoto());
			updateFrame.cbBirth.setSelectedItem(dto.getBirthyear());
			//������ ���̰� �ϱ�
			updateFrame.setVisible(true);
					
		}else if(ob==updateFrame.btnUpdate)//�������� ������ư
		{
			//���������� ����Ÿ �о dto�� ���(num ����)
			StudentDto dto=new StudentDto();
			dto.setNum(updateFrame.num);
			dto.setName(updateFrame.txtName.getText());
			dto.setHp(updateFrame.txtHp.getText());
			dto.setAddr(updateFrame.txtAddr.getText());
			dto.setPhoto(updateFrame.lblPhoto.getText());
			dto.setBirthyear(Integer.parseInt(updateFrame.cbBirth.getSelectedItem().toString()));
			
			//dao �� ���� �޼��� ȣ��
			dao.studentUpdate(dto);
			
			//�������� �Ⱥ��̰� ó��
			updateFrame.setVisible(false);
			
			//��� �ٽ� ����ϴ� �޼��� ȣ��
			this.writeNames();
		}
	}

	//�̹��� ����ϱ� ���� ���� Ŭ����
	class DrawPhoto extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			//�̹��� ���
			g.drawImage(photoImage, 0, 0, 120, 140, this);//��ġ�� ���߿� �����ϱ�
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2StudentFrame ex=new Ex2StudentFrame("�л�����");
	}

}








