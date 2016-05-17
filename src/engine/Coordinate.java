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


    /**
     * Funzioni di confronto
     */
    public boolean isBeforRow(Coordinate c) {
        return isBeforeRow(c.getRow());
    }

    public boolean isAfterRow(Coordinate c) {
        return isAfterRow(c.getRow());
    }

    public boolean isBeforeRow(ROW row) {
        int current_row = this.getRow().ordinal();
        int request_row = row.ordinal();

        return request_row-current_row > 0;
    }

    public boolean isAfterRow(ROW row) {
        int current_row = this.getRow().ordinal();
        int request_row = row.ordinal();

        return current_row-request_row > 0;
    }

    public boolean isOnFirstRow() {
        return this.getRow().equals(ROW.A);
    }

    public boolean isOnLastRow() {
        return this.getRow().equals(ROW.H);
    }



    public boolean isBeforeColumn(int column) {
        int current_column = this.getColumn();
        int request_column = column;

        return request_column-current_column > 0;
    }

    public boolean isAfterColumn(int column) {
        int current_column = this.getColumn();
        int request_column = column;

        return current_column-request_column > 0;
    }

    public boolean isBeforeColumn(Coordinate c) {
        return isBeforeColumn(c.getColumn());
    }

    public boolean isAfterColumn(Coordinate c) {
        return isAfterColumn(c.getColumn());
    }

    public boolean isOnFirstColumn() {
        return this.getColumn() == 1;
    }

    public boolean isOnLastColumn() {
        return this.getColumn() == 8;
    }

}
