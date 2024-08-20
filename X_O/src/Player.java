import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    char name;
    String player_name;
    static Player X;
    static Player O;
    static Player Striker;
    ArrayList<Integer> moves;
    static ArrayList<Integer>[] l = new ArrayList[8];
    static Player Winner=null;

    static {
        // Static initialization block for the ArrayLists
        for (int i = 0; i < l.length; i++) {
            l[i] = new ArrayList<>();
        }

        // Populate each ArrayList with specific values
        l[0].add(0);
        l[0].add(1);
        l[0].add(2);

        l[1].add(3);
        l[1].add(4);
        l[1].add(5);

        l[2].add(6);
        l[2].add(7);
        l[2].add(8);

        l[3].add(0);
        l[3].add(3);
        l[3].add(6);

        l[4].add(1);
        l[4].add(4);
        l[4].add(7);

        l[5].add(2);
        l[5].add(5);
        l[5].add(8);

        l[6].add(0);
        l[6].add(4);
        l[6].add(8);

        l[7].add(2);
        l[7].add(4);
        l[7].add(6);
    }

    public Player(char name,String player_name) {
        this.player_name=player_name;
        if (name == 'X') {
            this.name = name;
            X = this;
        } else if (name == 'O') {
            this.name = name;
            O = this;
        }
        this.moves = new ArrayList<>();
    }

    public static void switch_striker() {
        if (Striker == X) {
            Striker = O;
        } else {
            Striker = X;
        }
    }
    public  void play(Board board,ArrayList<Integer> chance) {
        Scanner in = new Scanner(System.in);
        System.out.println("player "+Striker.name+":"+ Striker.player_name);
        while (true){
            System.out.println("Enter the position:");
            int i = in.nextInt();
            if (chance.contains(i)) {
                Striker.moves.add(i);
                board.p[i].mod_value(Striker.name);  // Assuming mod_value modifies display_value in Posn class
                chance.remove((Integer) i);  // Remove the position from the available chances
                break;
            } else {
                System.out.println("Invalid position, try again.");
            }
        }
    }

    public  boolean check_success() {
        for (ArrayList<Integer> pattern : l) {
            if (this.moves.containsAll(pattern)) {
                return true;
            }
        }
        return false;
    }
    public static void game_over(){
        System.out.println("GAME OVER");
        if(Winner==null){
            System.out.println("DRAW");
        }
        else {
            System.out.println("THE WINNER IS "+Winner.player_name);
            Winner=null;
        }
    }
}
