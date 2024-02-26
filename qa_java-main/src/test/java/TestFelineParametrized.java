import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestFelineParametrized {
    private final int actualResult;
    private final int expectedResult;

    public TestFelineParametrized(int actualResult, int expectedResult){
        this.actualResult = actualResult;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] testFeline() {
        return new Object[][]{
                {2, 2},
                {1, 1},
                {3, 3}
        };
    }

    @Test
    public void test() {
        Feline feline = new Feline();
        assertEquals(expectedResult, feline.getKittens(actualResult));
    }
}
