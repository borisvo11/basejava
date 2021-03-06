/**
 * Array based storage for Resumes
 */
//Реализуйте методы save, get, delete, clear, getAll, size
// в классе ArrayStorage, организовав хранение резюме в массиве
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++)
            storage[i] = null;
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++)
            if (storage[i].uuid.equals(uuid))
                return storage[i];
        return null;
    }

    void delete(String uuid) {
        int cursor = 0;
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                cursor = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            for (int i = cursor; i < size - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[size] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++)
            resumes[i] = storage[i];
        return resumes;
    }

    int size() {
        return size;
    }
}
