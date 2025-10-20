package textGame.commonLib;

public class Puzzle {
	private String id;
	private String name;
	private String description;
	private String answer;
	private int attempts;
	private int roomNum;
	private Boolean complete = false;
	public Puzzle(String id, String name, String description,String answer,int attempts,int roomNum) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.answer = answer;
		this.attempts = attempts;
		this.roomNum = roomNum;
	}
	public String getName() {
		return name;
	}
	public String getQuestion() {
		return description;
	}
	public String getAnswer() {
		return answer;
	}
	public int getAttempts() {
		return attempts;
	}
	public Boolean getCompletion() {
		return complete;
	}
	public void markComplete() {
		complete = true;
	}
	public int getroomNum() {
		return roomNum;
	}
}
