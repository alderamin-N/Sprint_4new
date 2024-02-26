import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {

    String maleValue = "Самец";
    @Mock
    Feline feline;

    @Test
    public void getFoodVerifyTest() throws Exception {
        Lion lion = new Lion(maleValue, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Трава", "Различные растения"));
        Assert.assertEquals(List.of("Трава", "Различные растения"), lion.getFood());
    }

    @Test
    public void getKittensTest() throws Exception{
        Lion lion = new Lion(maleValue, feline);
        Mockito.when(feline.getKittens()).thenReturn(10);
        Assert.assertEquals((10),lion.getKittens());
    }

}
