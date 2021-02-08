package tennis;

//선수 클래스
public class Player { 
	  /*선수 이름 필드
	  포인트 점수 필드
	  게임 점수 필드
	  세트 점수 필드*/
	public String name;
	public int scorePoint;
	public int scoreGame;
	public int scoreSet;
	
	public Player(String name) {
		this.name = name;
		this.scorePoint = 0;
		this.scoreGame = 0;
		this.scoreSet = 0;
	}

	public Player() { }
	
	
	
	
}
