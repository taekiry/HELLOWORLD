package reviewClass;

/*
 * 글번호, 제목, 내용, 작성자
 * getter, setter 작성
 * 기본생성자, 전체 매개값 생성자
 */
//Review4 , exe, App 3개만든 이유

public class Review4 {
	
	//필드
	int storyNo;
	String title1;
	String content1;
	String writer1;
	
	
	//기본생성자
	public Review4() {
		
	}
	//전체생성자
	public Review4(int storyNo, String title1, String content1, String writer1) {
		super();
		this.storyNo = storyNo;
		this.title1 = title1;
		this.content1 = content1;
		this.writer1 = writer1;
	}
	
	// setter & getter
	public int getStoryNo() {
		return storyNo;
	}
	public void setStoryNo(int storyNo) {
		this.storyNo = storyNo;
	}
	public String getTitle1() {
		return title1;
	}
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getWriter1() {
		return writer1;
	}
	public void setWriter1(String writer1) {
		this.writer1 = writer1;
	}
	
	public void showInfo() {
		System.out.printf("%3d %12s %3s\n",storyNo,title1,writer1);
	}
	
	public void showInfoAll() {
		System.out.printf("글번호 : %d\n제목 : %s\n내용 : %s\n글쓴이 : %s\n",
				storyNo,title1,content1,writer1);
	}
}//end class review4
