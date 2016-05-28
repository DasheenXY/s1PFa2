package game;

public  abstract class GameItem {
	char name;
	public GameItem(char c){
	this.name=c;
	}
	
	public abstract void display();
}