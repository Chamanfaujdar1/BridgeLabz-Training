import java.util.*;
public class SnakesAndLadders {
	public static final int NO_PLAY = 0;
	public static final int LADDER = 1;
	public static final int SNAKE = 2;
	public static final int WINNING_POSITION = 100;
	public static void main(String[] args) {
		System.out.println("Welcome to Ladder and Snake Game.");
		
		int player1Position = 0;
		int player2Position = 0;
		int dieRollCount = 0;
		
		boolean isPlayer1Turn = true;
		
		Random random = new Random();
		
		while(player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
			int currentPosition = isPlayer1Turn ? player1Position : player2Position;
			String playerName = isPlayer1Turn ? "Player1" : "Player2";
			
			boolean playAgain = false;
			dieRollCount++;
			
			int dieValue = random.nextInt(6)+1;
			int option = random.nextInt(3);
			
			switch(option) {
			case LADDER:
				if(currentPosition + dieValue <= WINNING_POSITION) {
					currentPosition += dieValue;
				}
				playAgain = true;
				break;
				
			case SNAKE:
				currentPosition -= dieValue;
				if(currentPosition < 0) {
					currentPosition = 0;
				}
				break;
				
			case NO_PLAY:
			default:
				break;
			}
			
			System.out.println(playerName + " rolled: " + dieValue + " | Option: " + getOptionName(option) + " | New Position: " + currentPosition);
			
			if(isPlayer1Turn) {
				player1Position = currentPosition;
			}
			else {
				player2Position = currentPosition;
			}
			
			if(currentPosition == WINNING_POSITION) {
				System.out.println(playerName + " WON THE GAME");
				break;
			}
			
			if(!playAgain) {
				isPlayer1Turn = !isPlayer1Turn;
			}else {
				System.out.println(playerName + " got a LADDER! Rolling again....");
			}
		}
		
		System.out.println("Total Die Rolls: " + dieRollCount);
	}
	
	public static String getOptionName(int option) {
		switch(option) {
		case LADDER: return "LADDER";
		case SNAKE: return "SNAKE";
		default: return "NO PLAY";
		}
	}
}