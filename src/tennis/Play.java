package tennis;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Play implements IPlay{
	int set;
	char ch = 'y';
	Player[] players = new Player[2]; //클래스 배열 생성(선수 2명)
	Score scores = new Score(); //점수 계산 객체 생성
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void play() throws IOException { //실행 메소드
		do {
			do {												
				System.out.print(" > 세트 수 설정 (3 or 5) : ");
				set = scanner.nextInt();
				if(set == 3 || set == 5) break;	
				System.out.println("   잘못된 세트 수 입니다");
			} while (true);
			
			setMatch(players, set, scanner, scores); //시합 시작

			do {												
				System.out.print(" > replay? (Y or N) : ");
				ch = (char) System.in.read(); System.in.skip(2);
				if(Character.toUpperCase(ch) == 'Y' || Character.toUpperCase(ch) == 'N') break;	
				System.out.println("   잘못 입력하였습니다.");
			} while (true);

		} while (Character.toUpperCase(ch) == 'Y');
		System.exit(-1); //종료
	}

	private void setMatch(Player[] players, int set, Scanner scanner, Score scores) {
		makeName(players);
		Display.dispPlayerInfo(players); //선수 정보
		//엔터치면 계속 게임
		Score.enter();
		scores.scorePoint(players, set);
	}

	private void makeName(Player[] players){ //선수 이름 생성 메소드 
		String regex = "[가-힣]{3}"; //3글자만 입력 가능
		boolean result;
		for(int i=0; i<2; i++){
			System.out.printf(" > 선수 %d 이름 입력(3글자 한글) : ",i+1);
			String name = scanner.next();
			result = Pattern.matches(regex, name);
			if(result){
				players[i] = new Player(name);
			}else{
				System.out.printf("\n * 선수 %d 다시 입력해주세요\n", i+1);
				i--;
			}
		}
	}

}
