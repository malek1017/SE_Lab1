package part3;

public interface Database {

    boolean connect(String address, String userName, String password);

    void disconnect();

    boolean isConnected();

    String getName(int id);
}
