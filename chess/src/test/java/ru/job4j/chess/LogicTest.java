package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = FigureNotFoundException.class)
    public void ifNoFigureMoveTrowE() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bBishop = new BishopBlack(Cell.B1);
        logic.add(bBishop);
        logic.move(Cell.A1, Cell.C3);
    }

    @Test (expected = OccupiedCellException.class)
    public void ifOcupiedCellMoveTrowE() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bBishop = new BishopBlack(Cell.B1);
        Figure pawn = new PawnBlack(Cell.C2);
        logic.add(bBishop);
        logic.add(pawn);
        logic.move(Cell.B1, Cell.D3);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void ifWrongWayMoveTrowE() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bBishop = new BishopBlack(Cell.B1);
        logic.add(bBishop);
        logic.move(Cell.B1, Cell.B3);
    }
}