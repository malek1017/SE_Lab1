package part3;

public class NameGetter {
    private final Database database;

    public NameGetter(Database database) {
        this.database = database;
    }

    public void connect() {
        database.connect("", "", "");
    }

    /**
     * @param id unique id to identify the user
     * @return the name of the user or null if not connected or not found
     */
    public String getName(int id) {
        return database.getName(id);
    }
}
