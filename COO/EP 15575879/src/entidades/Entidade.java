package entidades;

public abstract class Entidade extends Movel {
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;
    public static final int EXPLODING = 2;

    public int state;


    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    
    public abstract double getRadius();



}