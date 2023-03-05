package ir.farshad.utility.customexceptions;

public class ShiponShip extends Exception{
    @Override
    public String getMessage() {
        return "در این مکان کشتی وجود دارد";
    }
}
