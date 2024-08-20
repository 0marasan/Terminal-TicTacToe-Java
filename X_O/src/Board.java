public class Board {
//    Posn p1 = new Posn(1);
//    Posn p2 = new Posn(2);
//    Posn p3 = new Posn(3);
//    Posn p4 = new Posn(4);
//    Posn p5 = new Posn(5);
//    Posn p6 = new Posn(6);
//    Posn p7 = new Posn(7);
//    Posn p8 = new Posn(8);
    Posn[] p = new Posn[9];

    public Board() {
        for (int i = 0; i < 9; i++) {
            p[i]=new Posn(i);
        }
    }

    public void display(){
        for (int i = 0; i < 9; i+=3) {
            System.out.println(p[i].display_value+" | "+p[i+1].display_value+" | "+p[i+2].display_value);
            if(i<6){
                System.out.println("--+---+--");
            }
        }

    }
}
