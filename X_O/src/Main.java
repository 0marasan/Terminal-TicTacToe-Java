import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void GAME(Player player1,Player player2){
        ArrayList<Integer> chance = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            chance.add(i);
        }
        Player.Striker = player1;
        Board board=new Board();
        board.display();
        while (!chance.isEmpty()) {
            Player.Striker.play(board, chance);
            board.display();
            if (Player.Striker.check_success()) {
                Player.Winner=Player.Striker;
                break;
            }
            Player.switch_striker();

        }
        Player.game_over();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board  board;
        boolean exit = false;
        int menu;
        while(!exit) {
            System.out.println("Menu");
            System.out.println("1:player v player");
            System.out.println("2:player v computer");
            System.out.println("3:EXIT");
            menu=sc.nextInt();
            switch (menu) {
                case (1):{
                    System.out.println("player1 name:");
                    String player1_name=sc.next();
                    Player player1 = new Player('X',player1_name);
                    System.out.println("player2 name:");
                    String player2_name=sc.next();
                    Player player2 = new Player('O',player2_name);
                    GAME(player1,player2);
                    break;
                }

                case(2): {
                    System.out.println("player name:");
                    String player_name=sc.next();
                    Player player1 = new Player('X',player_name);
                    Computer_player player2 = new Computer_player('O');
                    GAME(player1,player2);
                    break;
                }
                case (3):{
                    exit=true;
                    break;
                }
                default:
                    exit=true;
            }
        }
    }
}