import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {
    @Spy
    Feline feline;

    @Test
    public void getFoodVerifyTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).eatMeat();
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Трава", "Различные растения"));
        Assert.assertEquals(List.of("Трава", "Различные растения"), feline.getFood("Хищник"));
    }

    @Test
    public void countKittens(){
        Mockito.when(feline.getKittens()).thenReturn(2);
        Assert.assertEquals(2, feline.getKittens());
    }

    @Test
    public void familyTest(){
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }


}
