
public class Referee {
	private Computer com;
	private User user;
	private int win;
	private int lose;
	private int draw;
	private int step;
	private int num_set; 
	private int pre_win;// 10% 승리 조건을 담은 변수 
	public Referee(Computer com, User user,int num_set) {
		this.com = com;
		this.user = user;
		this.num_set = num_set; //메서드로 불러온 값 멤버 변수에 저장  
		this.pre_win=(num_set*3)/10;//승리 조건 -> Ex) 20(설정횟수)*3 / 10 = 6 
	}
	public void playStart() {
		this.win = 0;
		this.lose = 0;
		this.draw = 0;
		this.step = 0;
	}
	public int playing() {
		this.step++;
		int com = this.com.getInput();
		int user = this.user.getInput();
		judgment(com, user);
		resultPrint();
		
		//실행횟수가 3회 이하인 경우 승리하지 않아도 조건승리가 되는 에러 때문에 사용 ->  this.pre_win=(num_set*3)/10; 때문 
		if(this.win>1 || ((this.num_set==3 || this.num_set==2) && this.win==1)) { 
			if(this.win>=this.pre_win) {//따라서 3판이상 진행시 2판 이상 승리해야 조건승리가 발동 하도록 함
				System.out.println("★ 조건승리: "+this.num_set+"번중 30% 승리 ★");
				return -1; //반복문을 종료 시키는 용도 -> 게임이 끝났다는것을 전달 
			}
		}
		
		return step;
	}
	
	public void playStop() {
		System.out.println("======최종 결과=======");
		result();
	}
	
	private void result() {
		System.out.println("승리: "+this.win+
				", 패배: "+this.lose+", 비김: "+this.draw);
	}
	private void judgment(int com, int user) {
		System.out.println("컴: "+change(com)+", 나: "+change(user));
		if(user-com == 0) {
			System.out.println("비김");
			this.draw++;
		}
		else if( (user-com == 1) || (user-com == -2) ) {
			System.out.println("승리");
			this.win++;
		}
		else {
			System.out.println("패배");
			this.lose++;
		}
	}
	
	private void resultPrint() {
		System.out.println("횟수: "+this.step+"/"+this.num_set); //설정된 게임 횟수로 수정 
		result();
	}
	public String change(int number) { //"가위 바위 보" 를 숫자 대신 문자로 출력해 주는 함수  
		if(number==0) {
			return "가위";
		}
		else if(number==1) {
			return "바위";
		}
		else {
			return "보";
		}
	}
}
