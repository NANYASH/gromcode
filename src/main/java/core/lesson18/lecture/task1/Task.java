package core.lesson18.lecture.task1;


public class Task {
    public static void main(String[] args) {
        Storage storage1 = new CodeStorage();
        storage1.setFiles(new java.lang.String[]{"test1", "test2", "test3", "test4"});
        Storage storage2 = new FileStorage();
        storage2.setFiles(new java.lang.String[]{"test1.1", "test2.1", "test3.1", "test4.1", "test5.1"});
        Storage storage3 = new PictureStorage();

        printer(storage1);
        printer(storage2);
        printer(storage3);
    }

    public static void printer(Storage storage) {
        try {
            System.out.println("5th name is" + storage.getFiles()[5]);
        } catch (Exception e) {
            System.err.println("5th name can not be found...");
        }
    }
}
