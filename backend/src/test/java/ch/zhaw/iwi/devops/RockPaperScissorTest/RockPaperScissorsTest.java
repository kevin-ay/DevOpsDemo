package ch.zhaw.iwi.devops.RockPaperScissorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.zhaw.iwi.devops.RockPaperScissors.RockPaperScissors;

public class RockPaperScissorsTest {

    private static RockPaperScissors rps;

    @BeforeEach
    public void setUp() throws Exception {
        rps = new RockPaperScissors();
    }

    @Test
    public void testGetMoveNameSchere() {
        String test = rps.getMoveName(1);
        assertEquals("Schere", test);
    }

    @Test
    public void TestGetMoveNameStein() {
        String test = rps.getMoveName(2);
        assertEquals("Stein", test);
    }

    @Test
    public void TestGetMoveNamePapier() {
        String test = rps.getMoveName(3);
        assertEquals("Papier", test);
    }

    @Test
    // Computer 1 | Papier vs Stein
    public void testWinEvalPaperCP1() {
        String test3and2 = rps.winEvaluation(3, 2);
        assertEquals("Computer 1 (Papier) gewinnt", test3and2);
    }

    @Test
    // Computer 1 | Stein vs Schere
    public void testWinEvalStoneCP1() {
        String test2and1 = rps.winEvaluation(2, 1);
        assertEquals("Computer 1 (Stein) gewinnt", test2and1);
    }

    @Test
    // Computer 1 | Schere vs Papier
    public void testWinEvalScissorsCP1() {
        String test1and3 = rps.winEvaluation(1, 3);
        assertEquals("Computer 1 (Schere) gewinnt", test1and3);
    }

    @Test
    // Computer 2 | Papier vs Stein
    public void testWinEvalPaperCP2() {
        String test3and2 = rps.winEvaluation(2, 3);
        assertEquals("Computer 2 (Papier) gewinnt", test3and2);
    }

    @Test
    // Computer 2 | Stein vs Schere
    public void testWinEvalStoneCP2() {
        String test2and1 = rps.winEvaluation(1, 2);
        assertEquals("Computer 2 (Stein) gewinnt", test2and1);
    }

    @Test
    // Computer 2 | Schere vs Papier
    public void testWinEvalScissorsCP2() {
        String test1and3 = rps.winEvaluation(3, 1);
        assertEquals("Computer 2 (Schere) gewinnt", test1and3);
    }

    @Test
    public void testDrawSchere() {
        String draw = rps.winEvaluation(1, 1);
        assertEquals("Unentschieden", draw);
    }

    @Test
    public void testDrawStein() {
        String draw = rps.winEvaluation(2, 2);
        assertEquals("Unentschieden", draw);
    }

    @Test
    public void testDrawPapier() {
        String draw = rps.winEvaluation(3, 3);
        assertEquals("Unentschieden", draw);
    }
}