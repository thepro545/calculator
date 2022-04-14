package pro.sky.calculator.Service;

import pro.sky.calculator.Exceptions.NotFoundException;

import java.util.Arrays;

public class StringListImp implements StringList {
    private String[] array = new String[5];
    private int size = 0;

    @Override
    public String add(String item) {
        checkItems(item);
        array[size] = item;
        size++;
        return item;

    }

    @Override
    public String add(int index, String item) {
        checkItems(item);
        checkIndex(index);
        add(item);
        array[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkItems(item);
        checkIndexMax(index);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkItems(item);
        int solve = -1;
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                solve = i;
                break;
            }
        }

        if (solve != -1) {
            remove(solve);
        } else {
            throw new NotFoundException("Not Found");
        }

        return item;
    }

    @Override
    public String remove(int index) {
        String element = checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public boolean contains(String item) {
        checkItems(item);
        boolean equal = false;
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                equal = true;
                break;
            }
        }
        return equal;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            return false;
        }
        boolean result = true;
        if (this.size != otherList.size()) {
            result = false;
        } else {
            for (int i = 0; i < this.size; i++) {
                if(!this.get(i).equals(otherList.get(i))){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean result = true;
        for (String check: array) {
            if(check != null) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        array = new String[10];
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[this.size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.get(i);
        }
        return newArray;
    }

    public String checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        return array[index];
    }
    public String checkIndexMax(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        return array[index];
    }
    public String checkItems(String item) {
        if (item == null) {
            throw new NullPointerException("Нельзя использовать Null");
        }
        return item;
    }

    @Override
    public String toString() {
        return "StringListImp{" +
                "array=" + Arrays.toString(array) +
                ", \n size=" + size +
                '}';
    }
}
