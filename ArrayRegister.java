package register;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
    /** register.Person array. */
    private Person[] persons;
    
    /** Number of persons in this register. */
    private int count;
    
    /**
     * Constructor creates an empty register with maximum size specified.
     * @param size maximum size of the register
     */
    public ArrayRegister(int size) {
        persons = new Person[size];
        count = 0;
    }
    
    /* (non-Javadoc)
	 * @see register.Register#getCount()
	 */
    @Override
	public int getCount() {
        return count;
    }
    
    /* (non-Javadoc)
	 * @see register.Register#getSize()
	 */
    @Override
	public int getSize() {
        return persons.length;
    }
    
    /* (non-Javadoc)
	 * @see register.Register#getPerson(int)
	 */
    @Override
	public Person getPerson(int index) {
        return persons[index];
    }

    /* (non-Javadoc)
	 * @see register.Register#addPerson(register.Person)
	 */
    @Override
	public void addPerson(Person person) {
    	
        persons[count] = person;
        count++;
    }       
    
   
    /* (non-Javadoc)
	 * @see register.Register#findPersonByName(java.lang.String)
	 */
    @Override
	public Person findPersonByName(String name) {
    	for(int i=0; i<getSize(); i++){
    		Person osoba = getPerson(i);
        	if(name.equals(osoba.getName()))
        		return getPerson(i);
        	}
    	return null;
    }
    
    
    /* (non-Javadoc)
	 * @see register.Register#findPersonByPhoneNumber(java.lang.String)
	 */
    @Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
    	for(int i=0; i<getSize(); i++){
    		Person osoba = getPerson(i);
        	if(phoneNumber.equals(osoba.getPhoneNumber())){
        		return getPerson(i);
        	}}
		return null;
    }
    
    //TODO: Implement the method removePerson
    /* (non-Javadoc)
	 * @see register.Register#removePerson(register.Person)
	 */
    @Override
	public void removePerson(Person person) {
        for(int i=0; i<getSize(); i++){
        	if(person.equals(getPerson(i))){
        		
//        		count -= 1;
        		
//       		Arrays.removeElement(register,person);
        	}
        
    }
}
}