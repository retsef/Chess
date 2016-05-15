package engine;

/**
 * Created by roberto on 15/05/16.
 */
public class Coordinate {
    public enum ROW {
        A,B,C,D,E,F,G,H;
        @Override
        public String toString() {
            switch(this) {
                case A: return "A";
                case B: return "B";
                case C: return "C";
                case D: return "D";
                case E: return "E";
                case F: return "F";
                case G: return "G";
                case H: return "H";
                default: throw new IllegalArgumentException();
            }
        }
    }

    private ROW row;
    private int column;

    public Coordinate(ROW row, int column) {
        this.row = row;
        this.column = column;
    }

    public Coordinate(String coordinate) {
        String[] res = coordinate.split(",");
        this.row = ROW.valueOf(res[0]);
        this.column = Integer.parseInt(res[1]);
    }

    public ROW getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return row.toString()+","+column;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;

        Coordinate c = (Coordinate) obj;
        return this.toString().equals(c.toString());
    }

    @Override
    public int hashCode() {
        return this.row.hashCode()+this.column;
    }
}
