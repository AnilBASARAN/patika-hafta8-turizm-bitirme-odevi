import Turizm.business.LoginManager;
import Turizm.dao.LoginDao;
import Turizm.view.LoginGUI;

public class App {
    public static void main(String[] args) {



        LoginGUI run = new LoginGUI(new LoginManager(new LoginDao()));
    }
}