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
		players[0].scorePoint = 0; //포인트 초기화
		players[1].scorePoint = 0;
	}

	@Override
	public void resetGame(Player[] players) {
		players[0].scoreGame = 0; //게임 초기화
		players[1].scoreGame = 0;
	}

	@Override
	public void scorePoint(Player[] players, int set) {
		boolean end = false;
		do{
			Random rnd = new Random();
			int p = rnd.nextInt(2);
			
			pointWinner(p, players); //p의 값이 1인가 2인가에 따라 해당 선수의 포인트를 증가
			
			if( (players[0].scorePoint == 3) && (players[1].scorePoint == 3) ){ //40 : 40
				System.out.print("(듀스!)");
			} else if( (players[0].scorePoint == 4) && (players[1].scorePoint==4) ){ //40A : 40A
				players[0].scorePoint--; //점수 감소
				players[1].scorePoint--;
				System.out.print("(듀스!)");
			}
			
			System.out.println();
			display.dispScoreBoard(players); //현재 스코어 출력
			
			end = scoreSet(players, set); //승자가 나올 경우
			enter();
			
		}while(!end); //승자가 나오지 않으면 (end가 false면) 반복
	}

	public void scoreGame(Player[] players) {
		if((players[0].scorePoint == 4) && (players[1].scorePoint < 3)){ //포인트 차이 2 이상
			enter();
			players[0].scoreGame++;//선수 1 게임 승 올리기
			resetPoint(players); //포인트 초기화
			System.out.printf(" GAME 승리 : %s 선수\n",players[0].name);
			display.dispScoreBoard(players);
		} else if((players[1].scorePoint == 4) && (players[0].scorePoint < 3)){ //포인트 차이 2 이상
			enter();
			players[1].scoreGame++;//선수 2 게임 승 올리기
			resetPoint(players);
			System.out.printf(" GAME 승리 : %s 선수\n",players[1].name);
			display.dispScoreBoard(players);
		} else if(players[0].scorePoint == 5){ // 40A : 30이하
			enter();
			players[0].scoreGame++;//선수 1 게임 승 올리기
			resetPoint(players);
			System.out.printf(" GAME 승리 : %s 선수\n",players[0].name);
			display.dispScoreBoard(players);
		} else if(players[1].scorePoint == 5){			
			enter();
			players[1].scoreGame++;//선수 2 게임 승 올리기
			resetPoint(players);
			System.out.printf(" GAME 승리 : %s 선수\n",players[1].name);
			display.dispScoreBoard(players);
		}
	}

	public boolean scoreSet(Player[] players, int set) {
		int halfSet = (int) Math.ceil((double)set / 2.0); // set의 반
		scoreGame(players); //게임 구하는 메소드를 먼저 실행
		if((players[0].scoreGame == 6) && (players[1].scoreGame < 5)){ // 5 : 5
			enter();
			players[0].scoreSet++;//선수 1 세트 승 올리기
			resetGame(players); //게임 초기화
			System.out.printf(" SET 승리 : %s 선수\n",players[0].name);
			display.dispScoreBoard(players);
		} else if((players[1].scoreGame == 6) && (players[0].scoreGame < 5)){
			enter();
			players[1].scoreSet++;//선수 2 세트 승 올리기
			resetGame(players);
			System.out.printf(" SET 승리 : %s 선수\n",players[1].name);
			display.dispScoreBoard(players);
		} else if(players[0].scoreGame > 6 && (players[0].scoreGame - players[1].scoreGame == 2)){ //게임 차이 2 이상 
			enter();
			players[0].scoreSet++;//선수 1 세트 승 올리기
			resetGame(players);
			System.out.printf(" SET 승리 : %s 선수\n",players[0].name);
			display.dispScoreBoard(players);
		} else if(players[1].scoreGame > 6 && (players[1].scoreGame - players[0].scoreGame == 2)){	
			enter();
			players[1].scoreSet++;//선수 2 세트 승 올리기	
			resetGame(players);
			System.out.printf(" SET 승리 : %s 선수\n",players[1].name);
			display.dispScoreBoard(players);
		}
		
		if(players[0].scoreSet == halfSet || players[1].scoreSet == halfSet){ //세트의 반 이상 이겼다면
			enter();
			display.dispWinner(players, halfSet);
			return true;
		}
		return false;
	}

	public void pointWinner(int p, Player[] players){ 
		if(p == 0){//선수 1이 이겼을 때
			players[0].scorePoint++;
			System.out.printf(" point 획득 : %s 선수 ",players[0].name);
			
		} else if(p == 1){ //선수 2가 이겼을 때
			players[1].scorePoint++;
			System.out.printf(" point 획득 : %s 선수 ",players[1].name);
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
