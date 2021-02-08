package tennis;

interface IScore {
	/*초기화 메소드
	  포인트 계산 메소드
	  게임 계산 메소드
	  세트 계산 메소드
	  승자 계산 메소드*/
	
	void reset(Player [] players); //초기화
	void resetPoint(Player [] players); //포인트 초기화
	void resetGame(Player [] players); //게임 초기화
	
	void scorePoint(Player[] players, int set); //point 계산
	void scoreGame(Player[] players);  //point에 따른 game 계산
	boolean scoreSet(Player[] players, int set); //game에 따른 set 계산
	
}
