import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class GroupSaveLoadDelDataBase implements GroupSeveInterfase{

    private StudentsGroupDataBase dataBase;

    public GroupSaveLoadDelDataBase(StudentsGroupDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void saveGroup(Group group) throws IOException {
        dataBase.getListGroup().put(group.getGroupName(),group);
    }

    @Override
    public Group loadGroup() throws IOException {
        if(dataBase.getListGroup().size()!=0){
            Iterator<Map.Entry<String,Group>> iterator = dataBase.getListGroup().entrySet().iterator();
                Map.Entry<String, Group> pair = iterator.next();
                return pair.getValue();
        }
        System.out.println("База данных не пустая");
        return null;
    }

    public Group loadGroup(String name) throws IOException {
        if(dataBase.getListGroup().size()!=0){
            return dataBase.getListGroup().get(name);
        }
        System.out.println("База данных не пустая");
        return null;
    }

    public void deleteGroup(String name) throws IOException {
        if(dataBase.getListGroup().size()!=0 && dataBase.getListGroup().containsKey(name)){
            dataBase.getListGroup().remove(name);
            System.out.println("Группа была удалена");
        }
        else {
            System.out.println("Группа с этим именем не была найдена или база данных пуста");
        }
    }
}