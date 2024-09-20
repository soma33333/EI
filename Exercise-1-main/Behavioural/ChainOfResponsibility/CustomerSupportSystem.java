package Behavioural.ChainOfResponsibility;
abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String issue);
}

class Level1Support extends SupportHandler {
    @Override
    public void handleRequest(String issue) {
        if (issue.equals("Password Reset")) {
            System.out.println("Level 1 Support handled the issue: " + issue);
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(issue);
            }
        }
    }
}

class Level2Support extends SupportHandler {
    @Override
    public void handleRequest(String issue) {
        if (issue.equals("Software Installation")) {
            System.out.println("Level 2 Support handled the issue: " + issue);
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(issue);
            }
        }
    }
}

class ManagerSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue) {
        if (issue.equals("Network Issue")) {
            System.out.println("Manager handled the issue: " + issue);
        } else {
            System.out.println("Issue not handled: " + issue);
        }
    }
}

public class CustomerSupportSystem {
    public static void main(String[] args) {

        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler manager = new ManagerSupport();

        level1.setNextHandler(level2);
        level2.setNextHandler(manager);

        level1.handleRequest("Password Reset");
        level1.handleRequest("Software Installation");
        level1.handleRequest("Network Issue");
        level1.handleRequest("Unknown Issue");
    }
}
