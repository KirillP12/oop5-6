import java.io.*;

//вспомогательный класс для сохранения и загрузки группы в файл

public class GroupSaveLoadFile implements GroupSeveInterfase{

    private String fileAdress;

    public String getFileAdress() {
        return fileAdress;
    }

    public void setFileAdress(String fileAdress) {
        this.fileAdress = fileAdress;
    }

    public GroupSaveLoadFile(String fileAdress) {
        super();
        this.fileAdress = fileAdress;
    }

    @Override
    public void saveGroup(Group group) throws IOException {

        if(fileAdress == null){
            throw new IllegalArgumentException("nulPointer");
        }

        File resultFile = new File(fileAdress);

        if (!resultFile.exists()) { //если файла не существует
            if(resultFile.isDirectory()){ //если адрес новой директории
                resultFile.mkdir(); //создаем директорию
                resultFile = new File(fileAdress + "/result.stgroup"); //создаем файл с именем поумолчанию
            }
            else{ //если адрес нового файла
                try{
                    resultFile.createNewFile(); //создаем новый файл
                }
                catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        try(BufferedWriter f = new BufferedWriter(new FileWriter(resultFile))){
            f.write(group.getGroupName() + "\n");
            for(Student st: group.getGroupList()) {
                if(st!=null) {
                    f.write(st.printStudentToFile() + "\n");
                }
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }


    @Override
    public Group loadGroup() throws IOException {
        if (fileAdress == null) {
            throw new IllegalArgumentException("nulPointer");
        }
        int pointerIndex = fileAdress.lastIndexOf(".");
        String ext = fileAdress.substring(pointerIndex + 1);

        File groupFile = new File(fileAdress);
        if (!groupFile.exists() || !groupFile.isFile() || !ext.equals("stgroup")) {
            throw new IllegalArgumentException("файл не существует, или файл не stgroup");
        }

        Group groupFromFile = new Group();
        boolean groupNameInitialise = false;

        try(BufferedReader f = new BufferedReader(new FileReader(groupFile))){
            for(String str="";( str = f.readLine())!=null ; ) {
                if(!groupNameInitialise){
                    groupFromFile.setGroupName(str);
                    groupNameInitialise = true;
                    continue;
                }
                String[] s = str.split(";");
                String surname = s[0];
                String name = s[1];
                boolean sex = Boolean.parseBoolean(s[2]);
                int age = Integer.parseInt(s[3]);
                int height = Integer.parseInt(s[4]);
                int weight = Integer.parseInt(s[5]);
                int course = Integer.parseInt(s[6]);
                int studBook = Integer.parseInt(s[7]);
                double averageRating = Double.parseDouble(s[8]);

                groupFromFile.addStudent(new Student(surname,name,sex,course,studBook,averageRating,age,height,weight));
            }
        }
        catch(IOException e){
            System.out.println("Ошибка");
        }
        return groupFromFile;
    }

}