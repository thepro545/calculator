package pro.sky.calculator.Service;

import pro.sky.calculator.Exceptions.NotFoundException;

import java.util.Arrays;

public class StringListImp implements StringList {
    private Integer[] array = new Integer[5];
    private int size = 0;

    @Override
    public Integer add(Integer item) {
        checkItems(item);
        array[size] = item;
        size++;
        return item;

    }

    @Override
    public Integer add(int index, Integer item) {
        checkItems(item);
        checkIndex(index);
//        System.arraycopy(array, index, size, index+1, size - index);
        add(item);
        array[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkItems(item);
        checkIndexMax(index);
        array[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkItems(item);
        Integer indexCheck = indexOf(item);
        if (indexCheck != -1) {
            removeIndex(indexCheck);
        } else {
            throw new NotFoundException("Not Found");
        }

        return item;
    }

    @Override
    public Integer removeIndex(int index) {
        int element = checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public boolean contains(Integer item) {
        checkItems(item);
        sortInsertion(array);
        return findBin(item);
    }

    @Override
    public Integer indexOf(Integer item) {
        checkItems(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer lastIndexOf(Integer item) {
        checkItems(item);
        for (int i = size - 1; i >= 0; i--) {
            if (item == array[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            return false;
        }
        return Arrays.equals(toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        array = new Integer[0];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
//        Integer[] newArray = new Integer[this.size];
//        for (int i = 0; i < newArray.length; i++) {
//            newArray[i] = this.get(i);
//        }
        return Arrays.copyOf(array, size);
    }

    public Integer checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        return array[index];
    }


    public void sortInsertion(Integer[] arr) {

        for (int i = 1; i < arr.length; i++) {
//            if( arr[i] != null) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
//            }
        }
    }

    private boolean findBin(Integer item) {
        checkItems(item);
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(array[mid])) {
                return true;
            }

            if (item < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void checkIndexMax(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
    }

    private void checkItems(Integer item) {
        if (item == null) {
            throw new NullPointerException("Нельзя использовать Null");
        }
    }

    @Override
    public String toString() {
        return "StringListImp{" +
                "array=" + Arrays.toString(array) +
                ", \n size=" + size +
                '}';
    }
}
