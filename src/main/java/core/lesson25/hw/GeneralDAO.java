package core.lesson25.hw;


public class GeneralDAO<T> {
    private T[] array;

    public GeneralDAO() {
        this.array = (T[]) new Object[10];
    }

    public T save(T instance) throws Exception {
        validate(instance);
        int index = findFreeSpace(array);
        array[index] = instance;
        return array[index];
    }

    public T[] getAll() {
        T[] notNullArray = (T[]) new Object[getNumberOfElements()];
        int index = 0;
        for (T instance : array) {
            if (instance != null) {
                notNullArray[index] = instance;
                index++;
            }
        }
        return notNullArray;
    }

    public void validate(T instance) throws Exception {
        if (instance == null) throw new Exception("Null cannot be saved.");
        for (T instance1 : array) {
            if (instance1 != null && instance1.equals(instance)) {
                throw new Exception("Such element already exists.");
            }

        }
    }

    public int getNumberOfElements() {
        int counter = 0;
        for (T instance : array) {
            if (instance != null)
                counter++;
        }
        return counter;
    }

    public int findFreeSpace(T array[]) throws Exception {
        int index = 0;
        for (T instance : array) {
            if (instance == null)
                return index;
            index++;
        }
        throw new Exception("Not enough space. Instance cannot be added.");
    }

}
