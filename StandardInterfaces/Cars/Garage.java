package StandardInterfaces.Cars;

import java.util.Iterator;

public class Garage implements Iterable<Car>{

    private Car[] cars;

    public Garage(int size) {
        cars = new Car[size];
    }

    public void putCar(Car unit, int i) throws ErrorBoxException {
        int index = i - 1;
        if (index < 0 || index >= cars.length) {
            throw new ErrorBoxException("Неверный номер бокса: " + i);
        }
        if (cars[index] != null) {
    throw new ErrorBoxException ("Бокс " + i + " уже занят");
        }
        cars[index] = unit;
    }

    public Car getCar(int i) throws ErrorBoxException {
        int index = i - 1;
        if (index < 0 || index >= cars.length) {
throw new ErrorBoxException("Неверный номер бокса: " + i);
        }
        if (cars[index] == null) {
            throw new ErrorBoxException("Бокс " + i + " пуст");
        }
        Car car = cars[index];
        cars[index] = null;
        return car;
        }

    public boolean isFree(int number) throws ErrorBoxException {
int index = number - 1;
if (index < 0 || index > cars.length) {
    throw new ErrorBoxException("Неверный номер бокса: " + number);
}
return cars[index] == null;
    }

    public int getFreeBoxNumber() {
        for (int i = cars.length - 1; i >= 0; i--) {
       if (cars[i] == null) {
           return i + 1;
       }
        }
    return -1;
}

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
        private int index = cars.length - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
                public Car next() {
return cars[index--];
        }
    };
}
}
