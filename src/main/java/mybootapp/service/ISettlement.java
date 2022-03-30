package mybootapp.service;

public interface ISettlement {
	
	default void settle(int amountOfPerson, int amountOfGroup) {};

}
