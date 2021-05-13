package part3;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Assert;

public class NameGetterTest {
    private final String fakeName = "Malik";
    private final Database fakeDatabase = new Database() {
        private boolean isConnected;

        @Override
        public boolean connect(String address, String userName, String password) {
            isConnected = true;
            return true;
        }

        @Override
        public void disconnect() {
            isConnected = false;
        }

        @Override
        public boolean isConnected() {
            return isConnected;
        }

        @Override
        public String getName(int id) {
            if (isConnected) {
                return fakeName;
            } else {
                return null;
            }
        }
    };

    @Test
    public void getNameReturnsNullWithoutConnectingFirst() {
        var nameGetter = new NameGetter(fakeDatabase);

        var name = nameGetter.getName(0);

        Assert.assertNull(name);
    }

    @Test
    public void disconnectingAfterConnectingSuccessfullyDisconnectsFromTheDatabase() {
        var nameGetter = new NameGetter(fakeDatabase);

        nameGetter.connect();
        var connectionStatusAfterConnecting = fakeDatabase.isConnected();
        nameGetter.disconnect();
        var connectionStatusAfterDisconnecting = fakeDatabase.isConnected();

        Assert.assertNotEquals(connectionStatusAfterConnecting, connectionStatusAfterDisconnecting);
        Assert.assertFalse(connectionStatusAfterDisconnecting);
    }

    @Test
    public void connectSuccessfullyConnectsToTheDatabase() {
        var nameGetter = new NameGetter(fakeDatabase);

        nameGetter.connect();
        var isConnected = fakeDatabase.isConnected();

        Assert.assertTrue(isConnected);
    }

    @Test
    public void getNameReturnsCorrectNameWhenConnected() {
        var expectedName = fakeName;
        var nameGetter = new NameGetter(fakeDatabase);

        nameGetter.connect();
        final String actualName = nameGetter.getName(0);

        Assert.assertEquals(expectedName, actualName);
    }

}