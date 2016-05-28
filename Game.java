package game;
import java.util.*;

public class Game {
	Random num = new Random();
	int gn=num.nextInt(3)+1;
	private GameItem[][] board = new GameItem[4][4];
	private GameItem temp;
	
	private GameItem[][] setBoard(){
		int countP=0;
		int countG=0;
		int countCG=0;
		int wx=num.nextInt(4);
		int wy=num.nextInt(4);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
					board[wx][wy]=new Wumpus('W');
			}
		}
		do{
			int x=num.nextInt(4);
			int y=num.nextInt(4);
			if(board[x][y]==null){
				board[x][y]=new Pit('P');
				countP++;
			}
		}while(countP<3);
		do{
			int x=num.nextInt(4);
			int y=num.nextInt(4);
			if(board[x][y]==null){
				board[x][y]=new Gold('G');
				countG++;
			}
		}while(countG<gn);
		do{
			int x=num.nextInt(4);
			int y=num.nextInt(4);
			if(board[x][y]==null){
				board[x][y]=new ClearGround('.');
				countCG++;
			}
		}while(countCG<11-gn);
		return board;
	}
	
	private void display(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.print(" ");
				if(board[i][j]!=null)
				board[i][j].display();
				if(board[i][j]==null)
					System.out.print("*");
			}System.out.println();
		}
	}
	
	private void senseNearby(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(board[i][j]==null){
					if((i!=0&&board[i-1][j].name=='W')||(i==0&&board[3][j].name=='W'))
						System.out.println("There is a vile smell upward");
					if((j!=0&&board[i][j-1].name=='W')||(j==0&&board[i][3].name=='W'))
						System.out.println("There is a vile smell on your left");
					if((i!=3&&board[i+1][j].name=='W')||(i==3&&board[0][j].name=='W'))
						System.out.println("There is a vile smell downward");
					if((j!=3&&board[i][j+1].name=='W')||(j==3&&board[i][0].name=='W'))
						System.out.println("There is a vile smell on your right");
					if((i!=0&&board[i-1][j].name=='P')||(i==0&&board[3][j].name=='P'))
						System.out.println("There is a breeze upward");
					if((j!=0&&board[i][j-1].name=='P')||(j==0&&board[i][3].name=='P'))
						System.out.println("There is a breeze on your left");
					if((i!=3&&board[i+1][j].name=='P')||(i==3&&board[0][j].name=='P'))
						System.out.println("There is a breeze downward");
					if((j!=3&&board[i][j+1].name=='P')||(j==3&&board[i][0].name=='P'))
						System.out.println("There is a breeze on your right");
					if((i!=0&&board[i-1][j].name=='G')||(i==0&&board[3][j].name=='G'))
						System.out.println("There is a faint glitter upward");
					if((j!=0&&board[i][j-1].name=='G')||(j==0&&board[i][3].name=='G'))
						System.out.println("There is a faint glitter on your left");
					if((i!=3&&board[i+1][j].name=='G')||(i==3&&board[0][j].name=='G'))
						System.out.println("There is a faint glitter downward");
					if((j!=3&&board[i][j+1].name=='G')||(j==3&&board[i][0].name=='G'))
						System.out.println("There is a faint glitter on your right");
				}
			}
		}
	}
	
	private GameItem[][] moveUp(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(board[i][j]==null){
					temp=board[i][j];
					board[i][j]=new ClearGround('.');
					if(i!=0){
						board[i-1][j]=temp;
					}
					else if(i==0){
						board[3][j]=temp;
						i=3;
					}
				}
			}
		}
		return board;
	}
	
	private GameItem[][] moveDown(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(board[i][j]==null){
					temp=board[i][j];
					board[i][j]=new ClearGround('.');
					if(i!=3){
						board[i+1][j]=temp;
						i=3;
					}
					else if(i==3)
						board[0][j]=temp;
				}
			}
		}
		return board;
	}
	
	private GameItem[][] moveLeft(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(board[i][j]==null){
					temp=board[i][j];
					board[i][j]=new ClearGround('.');
					if(j!=0)
					board[i][j-1]=temp;
					else if(j==0){
						board[i][3]=temp;
						j=3;
						}
				}
			}
		}
		return board;
	}
	
	private GameItem[][] moveRight(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(board[i][j]==null){
					temp=board[i][j];
					board[i][j]=new ClearGround('.');
					if(j!=3){
						board[i][j+1]=temp;
						j=3;
					}
					else if(j==3)
						board[i][0]=temp;
				}
			}
		}
		return board;
	}
	
	private int countW(){
		int count=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(board[i][j]!=null&&board[i][j].name=='W'){
					count++;
				}
			}
		}return count;
	}
	
	private int countP(){
		int count=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(board[i][j]!=null&&board[i][j].name=='P'){
					count++;
				}
			}
		}return count;
	}
	
	private int countG(){
		int count=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(board[i][j]!=null&&board[i][j].name=='G'){
					count++;
				}
			}
		}return count;
	}
	
	private void menu(){
		System.out.println(" =====Wumpus=====");
		System.out.println("1.Move player left");
		System.out.println("2.Move player right");
		System.out.println("3.Move player up");
		System.out.println("4.Move player down");
		System.out.println("5.Quit\n");
	}
	
	public void runGame(){
		int m;
		Scanner read = new Scanner(System.in);
		setBoard();
		do{
			System.out.println("****************");
			display();
			senseNearby();
			System.out.println("Current collected gold : "+(gn-countG()));
			System.out.println();
			menu(); 
			System.out.print("Enter your choice: ");
			m=read.nextInt();
			switch(m){
			case 1 : moveLeft();
					 break;
			case 2 : moveRight();
					 break;
			case 3 : moveUp();
					 break;
			case 4 : moveDown();
					 break;
			case 5 : break;
			}
			if(countW()==0){
				System.out.println("Died! You are eaten by Wumpus!");
			};
			if(countP()!=3){
				System.out.println("Died! You are falling into a pit!");
			}
			if(countG()==0){
				System.out.println("Win! You collect all gold!");
				System.out.println("Total collected gold : "+(gn-countG()));
				display();
			}
		}while(m!=5&&countW()==1&&countP()==3&&countG()!=0);
		read.close();
	}
}