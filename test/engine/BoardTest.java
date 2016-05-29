package engine;

import org.junit.Assert;
import org.junit.Test;
import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roberto on 26/05/16.
 */
public class BoardTest {
    private Board board;

    public BoardTest() {
        this.board = new Board();
    }

    @Test
    public void board_squares_from_H1_to_H1() {
        Coordinate c = new Coordinate(Coordinate.ROW.H, 1);

        //Expected
        ArrayList<Square> expect = new ArrayList<>();
        expect.add(new Square(Square.COLOR.WHITE, c));

        //Result
        ArrayList<Square> result = new ArrayList<>(board.getSquares(c,c));

        //Then
        Assert.assertEquals(expect,result);
    }

    @Test
    public void board_squares_from_H1_to_H5() {
        Coordinate start = new Coordinate(Coordinate.ROW.H, 1);
        Coordinate end = new Coordinate(Coordinate.ROW.H, 5);

        //Expected
        ArrayList<Square> expect = new ArrayList<>();
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 1)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.H, 2)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 3)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.H, 4)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 5)));

        //Result
        ArrayList<Square> result = new ArrayList<>(board.getSquares(start,end));

        //Then
        Assert.assertEquals(expect,result);
    }

    @Test
    public void board_squares_from_H5_to_H1() {
        Coordinate start = new Coordinate(Coordinate.ROW.H, 5);
        Coordinate end = new Coordinate(Coordinate.ROW.H, 1);

        //Expected
        ArrayList<Square> expect = new ArrayList<>();
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 5)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.H, 4)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 3)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.H, 2)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 1)));

        //Result
        ArrayList<Square> result = new ArrayList<>(board.getSquares(start,end));

        //Then
        Assert.assertEquals(expect,result);
    }

    @Test
    public void board_squares_from_H8_to_H4() {
        Coordinate start = new Coordinate(Coordinate.ROW.H, 8);
        Coordinate end = new Coordinate(Coordinate.ROW.H, 4);

        //Expected
        ArrayList<Square> expect = new ArrayList<>();
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.H, 8)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 7)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.H, 6)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 5)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.H, 4)));

        //Result
        ArrayList<Square> result = new ArrayList<>(board.getSquares(start,end));

        //Then
        Assert.assertEquals(expect,result);
    }

    @Test
    public void board_squares_from_H4_to_H8() {
        Coordinate start = new Coordinate(Coordinate.ROW.H, 4);
        Coordinate end = new Coordinate(Coordinate.ROW.H, 8);

        //Expected
        ArrayList<Square> expect = new ArrayList<>();
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.H, 4)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 5)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.H, 6)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 7)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.H, 8)));

        //Result
        ArrayList<Square> result = new ArrayList<>(board.getSquares(start,end));

        //Then
        Assert.assertEquals(expect,result);
    }

    @Test
    public void board_squares_from_A1_to_E1() {
        Coordinate start = new Coordinate(Coordinate.ROW.A, 1);
        Coordinate end = new Coordinate(Coordinate.ROW.E, 1);

        //Expected
        ArrayList<Square> expect = new ArrayList<>();
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.A, 1)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.B, 1)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.C, 1)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.D, 1)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.E, 1)));


        //Result
        ArrayList<Square> result = new ArrayList<>(board.getSquares(start,end));

        //Then
        Assert.assertEquals(expect,result);
    }

    @Test
    public void board_squares_from_E1_to_A1() {
        Coordinate start = new Coordinate(Coordinate.ROW.E, 1);
        Coordinate end = new Coordinate(Coordinate.ROW.A, 1);

        //Expected
        ArrayList<Square> expect = new ArrayList<>();
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.E, 1)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.D, 1)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.C, 1)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.B, 1)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.A, 1)));


        //Result
        ArrayList<Square> result = new ArrayList<>(board.getSquares(start,end));

        //Then
        Assert.assertEquals(expect,result);
    }

    @Test
    public void board_squares_from_H1_to_D1() {
        Coordinate start = new Coordinate(Coordinate.ROW.H, 1);
        Coordinate end = new Coordinate(Coordinate.ROW.D, 1);

        //Expected
        ArrayList<Square> expect = new ArrayList<>();
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 1)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.G, 1)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.F, 1)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.E, 1)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.D, 1)));


        //Result
        ArrayList<Square> result = new ArrayList<>(board.getSquares(start,end));

        //Then
        Assert.assertEquals(expect,result);
    }

    @Test
    public void board_squares_from_D1_to_H1() {
        Coordinate start = new Coordinate(Coordinate.ROW.D, 1);
        Coordinate end = new Coordinate(Coordinate.ROW.H, 1);

        //Expected
        ArrayList<Square> expect = new ArrayList<>();
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.D, 1)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.E, 1)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.F, 1)));
        expect.add(new Square(Square.COLOR.BLACK, new Coordinate(Coordinate.ROW.G, 1)));
        expect.add(new Square(Square.COLOR.WHITE, new Coordinate(Coordinate.ROW.H, 1)));


        //Result
        ArrayList<Square> result = new ArrayList<>(board.getSquares(start,end));

        //Then
        Assert.assertEquals(expect,result);
    }

}
