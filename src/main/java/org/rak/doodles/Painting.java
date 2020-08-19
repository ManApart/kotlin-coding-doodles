package org.rak.doodles;

public class Painting {

    public static void useMeWithoutAClass(){

    }


    public boolean doThing(Pixel pixel) {
        float x = pixel.getX();
        pixel.setIndex(10);
        return false;
    }

    public String evaluate(int number, boolean specialCase) {
        if (number <= 0) {
            return "Bad Value";
        } else if (number == 1) {
            if (specialCase) {
                return "Special number one!";
            } else {
                return "Single";
            }
        } else if (number == 2) {
            return "Double";
        } else {
            return "Default";
        }
    }

}
