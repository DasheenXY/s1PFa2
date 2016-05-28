package game;

public class ClearGround extends GameItem{

	public ClearGround(char c){
		super(c);
	}
	
	public void display(){
		System.out.print(name);
	}
}