package tennis;

import java.io.*;
import java.util.*;

public class Score implements IScore{
	Display display = new Display();
	public Score() { }

	@Override
	public void reset(Player[] players) {
		players[0] = new Player(); //새로운 객체를 생성하여 모두 초기화
		players[1] = new Player(); 
	}

	@Override
	public void resetPoint(Player[] players) {
		players[0].setScorePoint(0); //포인트 초기화
		players[1].setScorePoint(0);
	}

	@Override
	public void resetGame(Player[] players) {
		players[0].setScoreGame(0); //게임 초기화
		players[1].setScoreGame(0);
	}

	@Override
	public void scorePoint(Player[] players, int set) {
		boolean end = false;
		do{
			Random rnd = new Random();
			int p = rnd.nextInt(2);
			
			pointWinner(p, players); //p의 값이 1인가 2인가에 따라 해당 선수의 포인트를 증가
			
			if( (players[0].getScorePoint() == 3) && (players[1].getScorePoint() == 3) ){ //40 : 40
				System.out.print("(듀스!)");
			} else if( (players[0].getScorePoint() == 4) && (players[1].getScorePoint()==4) ){ //40A : 40A
				players[0].setScorePoint(players[0].getScorePoint()-1); //점수 감소
				players[1].setScorePoint(players[1].getScorePoint()-1);
				System.out.print("(듀스!)");
			}
			
			System.out.println();
			display.dispScoreBoard(players); //현재 스코어 출력
			
			end = scoreSet(players, set); //승자가 나올 경우
			enter();
			
		}while(!end); //승자가 나오지 않으면 (end가 false면) 반복
	}

	public void scoreGame(Player[] players) {
		if((players[0].getScorePoint() == 4) && (players[1].getScorePoint() < 3)){ //포인트 차이 2 이상
			enter();
			players[0].setScoreGame(players[0].getScoreGame()+1); //선수 1 게임 승 올리기
			resetPoint(players); //포인트 초기화
			System.out.printf(" GAME 승리 : %s 선수\n",players[0].getName());
			display.dispScoreBoard(players);
		} else if((players[1].getScorePoint() == 4) && (players[0].getScorePoint() < 3)){ //포인트 차이 2 이상
			enter();
			players[1].setScoreGame(players[1].getScoreGame()+1); //선수 2 게임 승 올리기
			resetPoint(players);
			System.out.printf(" GAME 승리 : %s 선수\n",players[1].getName());
			display.dispScoreBoard(players);
		} else if(players[0].getScorePoint() == 5){ // 40A : 30이하
			enter();
			players[0].setScoreGame(players[0].getScoreGame()+1); //선수 1 게임 승 올리기
			resetPoint(players);
			System.out.printf(" GAME 승리 : %s 선수\n",players[0].getName());
			display.dispScoreBoard(players);
		} else if(players[1].getScorePoint() == 5){			
			enter();
			players[1].setScoreGame(players[1].getScoreGame()+1); //선수 2 게임 승 올리기
			resetPoint(players);
			System.out.printf(" GAME 승리 : %s 선수\n",players[1].getName());
			display.dispScoreBoard(players);
		}
	}

	public boolean scoreSet(Player[] players, int set) {
		int halfSet = (int) Math.ceil((double)set / 2.0); // set의 반
		scoreGame(players); //게임 구하는 메소드를 먼저 실행
		if((players[0].getScoreGame() == 6) && (players[1].getScoreGame() < 5)){ // 5 : 5
			enter();
			players[0].setScoreSet(players[0].getScoreSet()+1); //선수 1 세트 승 올리기
			resetGame(players); //게임 초기화
			System.out.printf(" SET 승리 : %s 선수\n",players[0].getName());
			display.dispScoreBoard(players);
		} else if((players[1].getScoreGame() == 6) && (players[0].getScoreGame() < 5)){
			enter();
			players[1].setScoreSet(players[1].getScoreSet()+1); //선수 2 세트 승 올리기
			resetGame(players);
			System.out.printf(" SET 승리 : %s 선수\n",players[1].getName());
			display.dispScoreBoard(players);
		} else if(players[0].getScoreGame() > 6 && (players[0].getScoreGame() - players[1].getScoreGame() == 2)){ //게임 차이 2 이상 
			enter();
			players[0].setScoreSet(players[0].getScoreSet()+1); //선수 1 세트 승 올리기
			resetGame(players);
			System.out.printf(" SET 승리 : %s 선수\n",players[0].getName());
			display.dispScoreBoard(players);
		} else if(players[1].getScoreGame() > 6 && (players[1].getScoreGame() - players[0].getScoreGame() == 2)){	
			enter();
			players[1].setScoreSet(players[1].getScoreSet()+1); //선수 2 세트 승 올리기	
			resetGame(players);
			System.out.printf(" SET 승리 : %s 선수\n",players[1].getName());
			display.dispScoreBoard(players);
		}
		
		if(players[0].getScoreSet() == halfSet || players[1].getScoreSet() == halfSet){ //세트의 반 이상 이겼다면
			enter();
			display.dispWinner(players, halfSet);
			return true;
		}
		return false;
	}

	public void pointWinner(int p, Player[] players){ 
		if(p == 0){//선수 1이 이겼을 때
			players[0].setScorePoint(players[0].getScorePoint()+1);
			System.out.printf(" point 획득 : %s 선수 ",players[0].getName());
			
		} else if(p == 1){ //선수 2가 이겼을 때
			players[1].setScorePoint(players[1].getScorePoint()+1);
			System.out.printf(" point 획득 : %s 선수 ",players[1].getName());
		}
	}
	
	public static void enter(){
		try {
			System.in.read();
			System.in.skip(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
