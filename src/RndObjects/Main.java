package RndObjects;

/**
 * (commentaires)
 *
 * @author Amalric Lombard de Buffières <amalric.debuffieres@icloud.com>
 * @version 1.0.0
 */
public class Main {
    public static void main(String args[]) {

        /*Object test0 = new ObjectTest(0, "0");

        ObjectTest test1 = new ObjectTest(1, "1");

        ObjectTest test2 = test1;

        test2.setArg1(2);
        test2.setArg2("2");

        System.out.println("0 = " + test0.toString());
        System.out.println("1 = " + test1.toString());
        System.out.println("2 = " + test2.toString());

        ObjectTest test3 = test1;

        test1.setArg1(1);
        test1.setArg2("1");

        System.out.println("\n\n");
        System.out.println("0 = " + test0.toString());
        System.out.println("1 = " + test1.toString());
        System.out.println("2 = " + test2.toString());
        System.out.println("3 = " + test3.toString());**/




        /*
        ObjectTest things = new ObjectTest(1, "A");
        System.out.println(things.toString());

        ObjectTest thing2 = things;

        modifyThings(things);

        System.out.println(thing2.toString());
        */



        ObjectTest thing1 = new ObjectTest(1, "A");

        ObjectTest thing2 = new ObjectTest(2, "B");

        ObjectTest thing3 = thing2;

        modifyThings(thing2);

        System.out.println("thing2 : " + thing2.toString());
        System.out.println("thing3 : " + thing3.toString());

        thing3 = thing1;

        thing2.setArg1(5);
        thing2.setArg2("E");


        System.out.println("");
        System.out.println("thing2 : " + thing2.toString());
        System.out.println("thing3 : " + thing3.toString());


















    }


    public static void modifyThings(ObjectTest objectTest) {
        objectTest.setArg1(4);
        objectTest.setArg2("D");
    }







}
