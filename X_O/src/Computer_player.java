import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Computer_player extends Player{
    public Computer_player(char name) {
        super(name,"computer");
    }

    @Override
    public void play(Board board, ArrayList<Integer> chance) {
        System.out.println("player: "+Striker.name);
        Random r = new Random();
        int i=-1;
        boolean contains=false;
            for(int j : chance){
                X.moves.add(j);
                O.moves.add(j);
                if (Player.X.check_success()||Player.O.check_success()) {
                    contains=true;
                    i=j;
                    X.moves.removeLast();
                    O.moves.removeLast();
                    break;
                }
                X.moves.removeLast();
                O.moves.removeLast();
            }
            if (!contains){
                int random_index = r.nextInt(chance.size());
                i = chance.get(random_index);
            }
        System.out.println(i);
        Striker.moves.add(i);
        board.p[i].mod_value(Striker.name);  // Assuming mod_value modifies display_value in Posn class
        chance.remove((Integer) i);
        }

}
