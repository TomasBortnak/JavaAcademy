package register;


/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Register register = new ArrayRegister(20);

        register.addPerson(new Person("Janko Hrasko", "0900123456"));
        register.addPerson(new Person("Tomas Bortnak", "0906148456"));
        register.addPerson(new Person("Milan Klucar", "0903115736"));
        register.addPerson(new Person("Juraj Jonas", "0902457826"));

        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
    }
}
