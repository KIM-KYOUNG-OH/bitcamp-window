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
	
	// 이미지 파일이 하나라도 있으면 true 반환
	public boolean isFileInPicture() {
		boolean b = false;
		String []ext = {"jpg","png","jpeg","gif"};
		String []files = this.getFiles().split(",");
		exit:
		for(String file: files) {
			for(String e:ext) {
				// 확장자 e로 끝날경우 true: 확장자가 대문자인 경우도
				// 있으므로 파일명을 일단 무조건 모두 소문자로 변경후
				// 위의 확장자로 끝나는지 확인하기
				if(file.toLowerCase().endsWith(e)) {
					b=true;
					break exit;
				}
			}
		}
		return b;
	}
	
	// 이미지 파일을 제외하고 일반파일이 한개라도 있을경우 true
	public boolean isFileInGeneral() {
		boolean b = false;
		String ext = "jpg,png,jpeg,gif";
		String []files = this.getFiles().split(",");
		for(String file: files) {
			// 확장자 얻기
			int dot = file.indexOf(".");
			String fileExt = file.substring(dot+1);// 도트 다음번지부터 끝까지 추출
			// System.out.println(fileExt);
			// 파일 확장자가 ext안에 있는지 확인
			// 이미지가 있을경우 true이므로
			// 반대로 이미지가 아닐경우 false가 된다
			// false일때 반환은 일반파일이 있다는 의미로 true반환
			boolean find = ext.toLowerCase().contains(fileExt);
			if(!find) {
				b=true;
				break;
			}
		}
		return b;
	}
	
	// 댓글 갯수 반환
	public int getAnswerCount() {
		DataBoardDao dao = new DataBoardDao();
		return dao.getAnswerList(num).size();
	}
}


































