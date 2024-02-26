import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLionParametrized {

    private final String maleValue;
    private final boolean isHaveMane;
    Feline feline;

    public TestLionParametrized(String maleValue, boolean isHaveMane){
        this.maleValue = maleValue;
        this.isHaveMane = isHaveMane;
    }
    @Parameterized.Parameters
    public static Object[][] testLion() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void test() throws Exception {
        Lion lion = new Lion(maleValue, feline);
        Assert.assertEquals(lion.doesHaveMane(), isHaveMane);
    }
}
