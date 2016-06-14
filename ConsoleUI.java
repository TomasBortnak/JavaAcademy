package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /** register.Register of persons. */
    private Register register;
    
    /**
     * In JDK 6 use Console class instead.
     * @see readLine()
     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Menu options.
     */
    private enum Option {
        PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
    };
    
    public ConsoleUI(Register register) {
        this.register = register;
    }
    
    public void run() {
        while (true) {
            switch (showMenu()) {
                case PRINT:
                    printRegister();
                    break;
                case ADD:
                    addToRegister();
                    break;
                case UPDATE:
                    updateRegister();
                    break;
                case REMOVE:
                    removeFromRegister();
                    break;
                case FIND:
                    findInRegister();
                    break;
                case EXIT:
                    return;
            }
        }
    }
    
    private String readLine() {
        //In JDK 6.0 and above Console class can be used
        //return System.console().readLine();
        
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    private Option showMenu() {
        System.out.println("Menu.");
        for (Option option : Option.values()) {
            System.out.printf("%d. %s%n", option.ordinal() + 1, option);
        }
        System.out.println("-----------------------------------------------");
        
        int selection = -1;
        do {
            System.out.println("Option: ");
            selection = Integer.parseInt(readLine());
        } while (selection <= 0 || selection > Option.values().length);
        
        return Option.values()[selection - 1];
    }
    
   
    private void printRegister() {
        for(int i=0; i<register.getCount(); i++){
        	Person osoba = register.getPerson(i);
        	System.out.println(i+1 + " " + osoba.getName() + " (" + osoba.getPhoneNumber() + ") ");
        }
    }
    
    private void addToRegister() {
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();
//        for(int i=0; i<register.getSize(); i++){
//    		Person osoba = register.getPerson(i);
//        	if((name.equals(osoba.getName())) || (phoneNumber.equals(osoba.getPhoneNumber()))){
//        		System.out.println("Person with used name or phone number alredy exist");
//        	}else{
//        		
//        	}
//        }
        register.addPerson(new Person(name, phoneNumber));
        
    }
    
   
    private void updateRegister() {
    	System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index - 1);
        register.removePerson(person);
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();
        
        register.addPerson(new Person(name, phoneNumber));
    }
    
    
    private void findInRegister() {
    	System.out.println("1 Find person by name");
    	System.out.println("2 Find person by nubmer");
    	int index = Integer.parseInt(readLine());
    	if(index == 1){
    		System.out.println("Enter name: ");
    		String name = readLine();
    		register.findPersonByName(name);
    		System.out.println(register.findPersonByName(name).getName() + " (" + register.findPersonByName(name).getPhoneNumber() + ") ");
    	}
    	if(index==2){
    		System.out.println("Enter phone number; ");
    		String phoneNumber = readLine();
    		register.findPersonByPhoneNumber(phoneNumber);
    		System.out.println(register.findPersonByPhoneNumber(phoneNumber).getName() + " (" + register.findPersonByPhoneNumber(phoneNumber).getPhoneNumber() + ") ");
    	}
    }
    
    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index - 1);
        register.removePerson(person);
    }

}
