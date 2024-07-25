import java.io.IOException;

public interface GroupSaveInterface {

    public void saveGroup(Group group)throws IOException;

    public Group loadGroup() throws IOException;

}