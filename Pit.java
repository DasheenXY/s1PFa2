package game;

public class Pit extends GameItem{

	public Pit(char c){
		super(c);
	}
	
	public void display(){
		System.out.print(name);
	}
}