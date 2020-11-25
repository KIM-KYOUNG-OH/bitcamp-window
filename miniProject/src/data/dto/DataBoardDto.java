package data.dto;

import java.sql.Timestamp;

import data.dao.DataBoardDao;

public class DataBoardDto {
	private String num;
	private String myid;
	private String subject;
	private String files;
	private String content;
	private int readcount;
	private Timestamp writeday;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getMyid() {
		return myid;
	}
	public void setMyid(String myid) {
		this.myid = myid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
	// �̹��� ������ �ϳ��� ������ true ��ȯ
	public boolean isFileInPicture() {
		boolean b = false;
		String []ext = {"jpg","png","jpeg","gif"};
		String []files = this.getFiles().split(",");
		exit:
		for(String file: files) {
			for(String e:ext) {
				// Ȯ���� e�� ������� true: Ȯ���ڰ� �빮���� ��쵵
				// �����Ƿ� ���ϸ��� �ϴ� ������ ��� �ҹ��ڷ� ������
				// ���� Ȯ���ڷ� �������� Ȯ���ϱ�
				if(file.toLowerCase().endsWith(e)) {
					b=true;
					break exit;
				}
			}
		}
		return b;
	}
	
	// �̹��� ������ �����ϰ� �Ϲ������� �Ѱ��� ������� true
	public boolean isFileInGeneral() {
		boolean b = false;
		String ext = "jpg,png,jpeg,gif";
		String []files = this.getFiles().split(",");
		for(String file: files) {
			// Ȯ���� ���
			int dot = file.indexOf(".");
			String fileExt = file.substring(dot+1);// ��Ʈ ������������ ������ ����
			// System.out.println(fileExt);
			// ���� Ȯ���ڰ� ext�ȿ� �ִ��� Ȯ��
			// �̹����� ������� true�̹Ƿ�
			// �ݴ�� �̹����� �ƴҰ�� false�� �ȴ�
			// false�϶� ��ȯ�� �Ϲ������� �ִٴ� �ǹ̷� true��ȯ
			boolean find = ext.toLowerCase().contains(fileExt);
			if(!find) {
				b=true;
				break;
			}
		}
		return b;
	}
	
	// ��� ���� ��ȯ
	public int getAnswerCount() {
		DataBoardDao dao = new DataBoardDao();
		return dao.getAnswerList(num).size();
	}
}


































