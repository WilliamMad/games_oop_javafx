package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void positionA6isA6() {
        Cell cell = Cell.A6;
        Cell position = new BishopBlack(cell).position();
        assertThat(position, is(cell));
    }

    @Test
    public void copyA6isA6() {
        Figure bBishop = new BishopBlack(Cell.A6);
        assertThat(bBishop.position(), is(bBishop.copy(Cell.A6).position()));
    }

    @Test
    public void ifC1G5wayIsD2E3F4G5() {
        Figure bBishop = new BishopBlack(Cell.C1);
        Cell[] way = bBishop.way(Cell.G5);
        assertArrayEquals(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}, way);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void ifC1G6wayIsNotDiagonal() {
        Figure bBishop = new BishopBlack(Cell.C1);
        Cell[] way = bBishop.way(Cell.G6);
    }
}