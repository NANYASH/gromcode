package core.lesson19;


import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        File[] files = new File[3];
        File[] files2 = new File[10];
        try {
            files = new File[]{new File(1, "Test1", "format1", 100),
                    new File(2, "Test2", "format2", 200),
                    new File(3, "Test3", "format3", 100),
                    new File(4, "Test3", "format3", 100)};
        } catch (Exception e) {
            e.printStackTrace();
        }
        Storage storage = new Storage(1, files, new String[]{"format1", "format2", "format3"}, "Kiev", 400);
        Storage storage1 = new Storage(2, files2, new String[]{"format1", "format2", "format3"}, "Odessa", 1000);
        try {
            //storage1.getFiles()[0] = new File(5, "Test1", "format1", 100);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            //Controller.put(storage1, new File(1,"Test4","format2",100));
            //controller.put(storage1, new File(5,"Test4","format2",100));
            //controller.delete(storage,new File(3, "Test1", "format1", 100));
            //controller.transferFile(storage,storage1,1);
            Controller.transferAll(storage, storage1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(storage.getFiles()));
        System.out.println(Arrays.toString(storage1.getFiles()));

    }
}
