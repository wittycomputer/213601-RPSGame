import java.util.Scanner;

public class User {
	public int getInput() {
		int num = 0;
		while(true) {
			System.out.println("가위(0) 바위(1) 보(2):");
			Scanner sc = new Scanner(System.in);
			num = sc.nextInt();
			if(num < 0 || num > 2) {
				System.out.println("잘못입력, 다시 입력");
			}
			else {
				break;
			}
		}
		return num;
	}
}
