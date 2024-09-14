//2131601 김보광 
import java.util.Scanner;

public class RPSGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer com = new Computer();
		User user = new User();
		int num_set=0; //게임 횟수 사용자 지정값 저장 변수 
		System.out.println("게임 횟수 지정:");
		Scanner sc = new Scanner(System.in);
		num_set = sc.nextInt();//게임횟수 입력
		Referee ref = new Referee(com, user,num_set);//입력받은 게임 횟수를 Referee 함수 매개변수로 전달
		
		int i=0; 
		ref.playStart();
		while(i<num_set) {
			int sign=ref.playing();//playing 메서드를 실행하고 실행값 변수에 저장
			if(sign==-1) {
				break; //만약 playing 메서드에서 -1 을 return 받으면 반복문 종료 
			}
			else {
				i++;
			}
		}
		ref.playStop();
	}

}
