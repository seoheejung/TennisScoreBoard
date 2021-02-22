package tennis;

//출력 클래스
public class Display implements IDisplay{
	String [] scoreName = { "00", "15", "30", "40", "40A", "40AA" };
	
	@Override
	public void dispScoreBoard(Player[] players) { //현재의 스코어보드를 화면에 출력
		TopLine(37);
		MiddleLine(37);
		System.out.printf("%c [Player]\t[POINT]\t[GAME]\t[SET] %c\n",5,5);
		System.out.printf("%c ----------------------------------- %c\n",5,5);
		System.out.printf("%c  %s\t %s\t %d\t %d    %c\n",
				5,players[0].getName(),scoreName[players[0].getScorePoint()],players[0].getScoreGame(),players[0].getScoreSet(),5);
		System.out.printf("%c  %s\t %s\t %d\t %d    %c\n",
				5,players[1].getName(),scoreName[players[1].getScorePoint()],players[1].getScoreGame(),players[1].getScoreSet(),5);
		MiddleLine(37);
		BottomLine(37);
	}

	public void dispWinner(Player[] players, int halfSet) { //최종 스코어보드를 화면에 출력
		System.out.println("\n\t   ******* 시합 종료 *******   \t");
		TopLine(45);
		MiddleLine(45);
		System.out.printf("%c [Player]\t[POINT]\t[GAME]\t[SET]\t[Win] %c\n",5,5);
		System.out.printf("%c ------------------------------------------- %c\n",5,5);
		if(players[0].getScoreSet() == halfSet){
			System.out.printf("%c  %s\t %s\t %d\t %d\t ★   %c\n",
					5, players[0].getName(), scoreName[players[0].getScorePoint()], players[0].getScoreGame(), players[0].getScoreSet(), 5);
			System.out.printf("%c  %s\t %s\t %d\t %d\t      %c\n",
					5, players[1].getName(), scoreName[players[1].getScorePoint()], players[1].getScoreGame(), players[1].getScoreSet(), 5);
		} else if( players[1].getScoreSet() == halfSet){
			System.out.printf("%c  %s\t %s\t %d\t %d\t      %c\n",
					5, players[0].getName(), scoreName[players[0].getScorePoint()], players[0].getScoreGame(), players[0].getScoreSet(), 5);
			System.out.printf("%c  %s\t %s\t %d\t %d\t ★   %c\n",
					5, players[1].getName(), scoreName[players[1].getScorePoint()], players[1].getScoreGame(), players[1].getScoreSet(), 5);
		}
		MiddleLine(45);
		BottomLine(45);
	}

	public static void dispPlayerInfo(Player[] players){ //선수 정보를 화면에 출력
		TopLine(25);
		System.out.printf("%c\t[선수 정보]\t  %c\n",5,5);
		System.out.printf("%c ----------------------- %c\n",5,5);
		for (int i = 0; i < players.length; i++) {
			System.out.printf("%c %d번 선수 이름 : %s  %c\n", 5, i+1, players[i].getName(), 5);
		}
		BottomLine(25);
		System.out.println("    테니스 시작 (enter)");
	}

	public static void TopLine(int value) { 
		System.out.printf("%c",1);
		for(int i = 0; i < value; i++){
			System.out.printf("%c",6);
		}
		System.out.printf("%c\n",2);
	}

	public static void MiddleLine(int value) {
		System.out.printf("%c",5);
		for(int j = 0; j < value; j++){
			System.out.printf("%c",0);
		}
		System.out.printf("%c\n",5);
	}

	public static void BottomLine(int value) {
		System.out.printf("%c",3);
		for(int i = 0; i < value; i++){
			System.out.printf("%c",6);
		}
		System.out.printf("%c\n",4);
	}

	public static void Intro() {
		TopLine(40);
		System.out.printf("%c",5);
		String intro = "테니스 스코어보드";
		for(int i = 0; i < 24; i++){
			if(i == 11){
				System.out.printf("%s",intro);
			}else{
				System.out.printf("%c",0);
			}
		}
		System.out.printf("%c\n",5);
		BottomLine(40);
	}

}
