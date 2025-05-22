package exeception;
/*
 * 1) 일반 예외 - 컴파일러가 에러를 알려줌.
 * 2) 실행 예외 - 실행시점에 에러가 발생하는경우
 */
public class ExceptionExe {
	
	public static void main(String[] args) {  //try_catch
		String numStr = "a";
		int num = 0;
		try {
			num = Integer.parseInt(numStr);
		} catch(NumberFormatException e) {  //catch 구문에 예외가 발생하면 실행할 코드
			System.out.println("예외발생.");
		}
		
		System.out.println(num);   //a를 Int로 바꾸려면 에러발생 그밑으론 실행도 못하게됨.
		
		
			try {
				Class.forName("java.util.Scanner123");  //Class.forName 객체가 있으면 반환 없으면 null? 처리 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();					//error 코드의 흔적을 보여줌
			}
		 
			System.out.println("일반예외발생."); //일반예외는 이클립스가 try catch로 씌울지 물어봄
		
		System.out.println("end of prog.");
	}
	
}
