//implementing the snake game as given in the question

import java.util.*;

public class SnakeGame
{	//method to calculate the position of the current player-

	public static int positionCalculator(int currPlayerPos, int dice, int row, int col, int board[][], int move[][])
	{
		int key=0;//to track the corresponding position inside the matrix
		/*for eg.- 0th position for(0,0), 7th position for (2,1)*/
		currPlayerPos+=dice;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				key++;
				if(currPlayerPos==key)
				{
					if(board[i][j]==1 || board[i][j]==2)
						currPlayerPos+=move[i][j];
					if(currPlayerPos<0)
						currPlayerPos=0;
				}
			}
		}

		return currPlayerPos;

	}
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		Random random= new Random();
		System.out.println("Enter the number of rows and columns for our board game:");
		int row=sc.nextInt(), col=sc.nextInt();
		int board[][]= new int[row][col];
		int move[][] = new int[row][col];

		//input the value board game 0/1/2

		System.out.println("Enter the value for our board game-\n*Enter 0 for neither a snake nor a ladder\n*Enter a 1 for a snake to be present\n*Enter a 2 for a ladder");

		//we ask for penalty or reward if the input is 1/2

		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				board[i][j]=sc.nextInt();

				//no change to be done if input is zero

				if(board[i][j]==1)
				{
					System.out.println("This represents a snake, so enter the penalty to move back");
					move[i][j]=sc.nextInt();
				}

				if(board[i][j]==2)
				{
					System.out.println("This represents a ladder, so enter the reward to move forward");
					move[i][j]=sc.nextInt();
				}
			}
		}

		//playing the game

		int size= row*col;//size of the game
		int player[]=new int[4];//array representing the players' positions
		boolean won=false;//to check if someone already won
		int dice=0;//random value when dice is rolled
		int  currPlayerPos=0;//Current position of the current player
		int i=0;//for the loop

		System.out.println("\nGame beigns");

		while(!won)
		{
			for(i=0;i<4;i++)
			{
				dice = random.nextInt(6) + 1;
				System.out.println("\nFor Player "+(i+1)+", value of dice: "+dice);
				currPlayerPos= player[i];
				player[i]=positionCalculator(currPlayerPos, dice, row, col, board, move);
				System.out.println("Current Value of Player:"+(i+1)+"="+currPlayerPos);
				if(player[i]>size)
				{
					System.out.println("\nRank 1 = Player "+(i+1));
					won=true;
					break;
				}
			}
		}
		//displaying ranks
		if(won)
		{
			player[i]=0;
			int rank=2;//as rank 1 has already been displayed
			int max=0;
			for(i=0;i<player.length;i++)
			{
				if(player[i]>max)
				{

					System.out.println("Rank "+rank+" = Player "+(i+1));
					max=0;
					rank++;
				}
			}
		}



	}
}