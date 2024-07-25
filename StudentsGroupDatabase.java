import java.io.*;
import java.util.HashMap;

public class StudentsGroupDataBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private HashMap<String,Group> listGroup = new HashMap<String,Group>();

    public StudentsGroupDataBase() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public HashMap<String, Group> getListGroup() {
        return listGroup;
    }

    //не работает если ввести новую директорию с файлом!
    public void saveDataBase(String fileAdres){
        if(fileAdres == null){
            throw new IllegalArgumentException("nulPointer");
        }
        File resultFile = new File(fileAdres);


        try{
            if (!resultFile.exists()) {  //файла не существует
                if(resultFile.getParent()!=null) {
                    File folder = new File(resultFile.getParent());
                    folder.mkdirs(); //новая директория
                }
                resultFile.createNewFile(); //новый файл
            }
        }
        catch(IOException e){
            System.out.println(e);
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileAdres))){
            oos.writeObject(this);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public static StudentsGroupDataBase loadDataBase(String fileAdres){
        if(fileAdres == null){
            throw new IllegalArgumentException("nulPointer");
        }
        StudentsGroupDataBase dataBase = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileAdres))){
            dataBase = (StudentsGroupDataBase) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        return dataBase;
    }
}