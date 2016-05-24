package RndObjects;

/**
 * (commentaires)
 *
 * @author Amalric Lombard de Buffières <amalric.debuffieres@icloud.com>
 * @version 1.0.0
 */
public class ObjectTest {

    private int arg1;
    private String arg2;

    public ObjectTest(int arg1, String arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }


    public int getArg1() {
        return arg1;
    }

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    @Override
    public String toString() {
        return "ObjectTest{" +
                "arg1=" + arg1 +
                ", arg2='" + arg2 + '\'' +
                '}';
    }
}
