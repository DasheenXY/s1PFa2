package game;

public class Wumpus extends GameItem{
	
	public Wumpus(char c){
		super(c);
	}
	
	public void display(){
		System.out.print(name);
	}
}