package structural.proxy;

interface User {
    void displayUserDetails();
}

class RealUser implements User {
    private String userId;

    public RealUser(String userId) {
        this.userId = userId;
        loadFromDatabase();
    }

    private void loadFromDatabase() {
        System.out.println("Loading user details from the database for user ID: " + userId);
    }

    public void displayUserDetails() {
        System.out.println("Displaying user details for user ID: " + userId);
    }
}

class UserProxy implements User {
    private String userId;
    private RealUser realUser;

    public UserProxy(String userId) {
        this.userId = userId;
    }

    public void displayUserDetails() {

        if (realUser == null) {
            realUser = new RealUser(userId);
        }
        realUser.displayUserDetails();
    }
}

public class LazyDatabaseAccess {
    public static void main(String[] args) {
        User userProxy = new UserProxy("U12345");

        // User details are only loaded when needed
        System.out.println("User proxy created, details not loaded yet.");
        userProxy.displayUserDetails();
        userProxy.displayUserDetails();
    }
}
