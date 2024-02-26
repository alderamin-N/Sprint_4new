import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat (feline);
       Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception{
        Cat cat1 = new Cat(feline);
        Mockito.when(cat1.getFood()).thenReturn(List.of("Трава", "Различные растения"));
        assertEquals((List.of("Трава", "Различные растения")), cat1.getFood());
    }

}
