package hw11;
import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by tonchief on 12/18/2016.
 *
 * HW11. Используя PhantomReference написать Factory, которsй контролирует создание объекта
 * некоторого класса A(количество созданных в памяти объектов не должно превышать определенного
 * количества, которое задается через конструктор Factory)
 */

public class PhantomRef<T> {
        int currentCount;
        int removedCount;
        private int LIMIT;
        private Function<String,T> conctructor;
        private ReferenceQueue<T> queue = new ReferenceQueue<>();
        private List<Reference<? extends T>> referenceList = new ArrayList<>();

        PhantomRef(int limit, Function<String,T> conctructor) {
            this.LIMIT = limit;
            this.conctructor = conctructor;
        }

        public T getNewInstance(String name)  {
            while (true) {
                if (currentCount < LIMIT) {
                    return	newInstance(name);
                } else {
                    System.gc();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Reference<? extends T> ref = null;
                    try {
                        ref = queue.remove(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (ref != null) {
                        currentCount--;
                        removedCount++;
                        referenceList.remove(ref);
                        ref.clear();
                    }
                }
            }
        }

        private T newInstance(String name) {
            T instance = conctructor.apply(name);
            PhantomReference<T> ref = new PhantomReference<>(instance, queue);
            referenceList.add(ref);
            currentCount++;
            return instance;
        }

        public static void main(String[] args) {
        }
    }




