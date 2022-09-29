import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class PixelTest {

    @Test
    public void nullPointer(){
        Pixel pixel = null;
        pixel.getX(); //Throws null pointer!
    }

    @Test
    public void reflection(){
        Pixel pixel = new Pixel(0, 0, 0);
        for (Method method : pixel.getClass().getMethods()){
            System.out.println(method.getName());
        }
    }

}
