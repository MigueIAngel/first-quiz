package org.velezreyes.quiz.question6;





public class VendingMachineImpl implements VendingMachine {

    private static VendingMachine instance;
    private int moneyInserted;  // Variable para llevar un registro del dinero insertado.

    private VendingMachineImpl() {
        // Constructor privado para evitar la creación de instancias desde fuera de la clase.
        moneyInserted = 0;  // Inicializar el dinero insertado a cero.
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachineImpl();
        }
        return instance;
    }

    @Override
    public void insertQuarter() {
        // Implementar la inserción de dinero (por ejemplo, aumentar moneyInserted en función del valor de la moneda).
        moneyInserted += 25; // Asumiendo que cada moneda de 25 centavos.
    }

    @Override
public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if ("ScottCola".equals(name)) {
        if (moneyInserted >= 75) {
            moneyInserted -= 75;
            return new ConcreteDrink("ScottCola", true); // Usar ConcreteDrink en lugar de la interfaz Drink.
        } else {
            throw new NotEnoughMoneyException();
        }
    } else if("KarenTea".equals(name)){
      if (moneyInserted>=100){
      return new ConcreteDrink("KarenTea", false);
      } else {
        throw new NotEnoughMoneyException();
      }
    }
    else {
        throw new UnknownDrinkException();
    }
}

}

