package tennis;

//선수 클래스
public class Player { 
	private String name; // 선수 이름 필드
	private int scorePoint; // 포인트 점수 필드
	private int scoreGame; // 게임 점수 필드
	private int scoreSet; // 세트 점수 필드
	
	public Player(String name) {
		this.name = name;
		this.scorePoint = 0;
		this.scoreGame = 0;
		this.scoreSet = 0;
	}

	public Player() { }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScorePoint() {
		return scorePoint;
	}

	public void setScorePoint(int scorePoint) {
		this.scorePoint = scorePoint;
	}

	public int getScoreGame() {
		return scoreGame;
	}

	public void setScoreGame(int scoreGame) {
		this.scoreGame = scoreGame;
	}

	public int getScoreSet() {
		return scoreSet;
	}

	public void setScoreSet(int scoreSet) {
		this.scoreSet = scoreSet;
	}
	
	
	
	
}
