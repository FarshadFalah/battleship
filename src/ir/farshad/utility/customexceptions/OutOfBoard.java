package ir.farshad.utility.customexceptions;

public class OutOfBoard extends Exception{
    @Override
    public String getMessage() {
        return "اعداد وارد شده خارج از محدوده صفحه میباشد";
    }
}
