package jdbc.lesson4.hw;


public class Demo {
    public static void main(String[] args) throws Exception {


        Storage storage = new Storage(1, "txt,jpg", "Kiev", 1200);
        Storage storage2 = new Storage(2, "txt,jpg", "Kiev", 1200);
        Storage storage3 = new Storage(5, "txt,jpg", "Kiev", 1200);
        //File file = new File(1,"test1","txt",100,1);
        File file3 = new File(1, "test3", "jpg", 12, 2);


        //StorageDAO.save(storage3);
        //FileDAO.save(GenericDAO.getConnection(),file3);
        //System.out.println(FileDAO.getFilesByStorageID(1));
        Controller controller = new Controller();
        //controller.put(storage,file3);
        //controller.delete(storage,file3);
        controller.transferAll(storage2, storage);
        //controller.transferFile(storage2,storage,3);
        GenericDAO genericDAO = new FileDAO();
        FileDAO fileDAO = new FileDAO();
        //System.out.println(fileDAO.findById(1));


    }
}
