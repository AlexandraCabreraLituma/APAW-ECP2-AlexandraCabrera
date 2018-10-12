package api.entities;

public enum Position {
    GUARD('G'),
    CENTER('C'),
    FOWARD('F');

    private char value;

    private Position(char value){
        this.value = value;
    }

    public String toString() {
        return ""+value;
    }

}
