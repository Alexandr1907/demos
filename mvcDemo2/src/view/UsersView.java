package view;

import controller.Controller;
import model.ModelData;

public class UsersView implements View {
    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList()) System.out.println("All deleted users:");
        else System.out.println("All users:");

        modelData.getUsers().forEach(e -> System.out.println("\t" + e));
        String separator = "===================================================";
        System.out.println(separator);
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    public void fireEventOpenUserEditForm(long id) {controller.onOpenUserEditForm(id);
    }

}
