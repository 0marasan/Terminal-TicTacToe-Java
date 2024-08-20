public class Posn {
    int posn_no;
    String display_value;
    boolean mod ;

    public Posn(int posn_no) {
        this.posn_no = posn_no;
        this.display_value=String.valueOf(posn_no);
        this.mod=false;
    }
    public void mod_value(char x){
        if(!this.mod) {
            if (x=='X') {
                this.display_value = "X";
            } else {
                this.display_value = "O";
            }
            this.mod=true;
        }
    }

}
