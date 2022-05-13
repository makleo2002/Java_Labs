package com.company;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Pair<T,M>{
    private T first;
    private M second;
    final T getFirst(){
        return first;
    }
    final M getSecond(){
        return second;
    }
    final void setFirst(T m){
        this.first=m;
    }
    final void setSecond(M i){
        this.second=i;
    }
    protected Pair(){}
    public Pair(T max,M index){
        this.first=max;
        this.second=index;

    }
    public static <T,M>  Pair make_pair(T max,M index){
        return new Pair<T,M>(max,index);
    }
    final void show(){
        System.out.print(first+" ");
        System.out.print(second+" ");
    }

}


class Bag {
    private  Object[] mas ;

    public Object[] getMas() {
        return mas;
    }

    public Bag(int n) {
       mas=new Object [n];
    }

    public void add(Object num) {
        int count = -1;
        boolean flag = false;
        int r = (int) Math.round(Math.random() * (mas.length - 1));
        while (!flag) {
            for (int k = 0; k < mas.length; k++) {
                if (mas[k] == null) {
                    if(r == k) {
                        mas[k]=num;
                        System.out.println("Предмет " + mas[k] + " добавлен в мешок");
                        flag = true;
                        break;
                    }
                } else  count++;
            }
            r = (int) Math.round(Math.random() * (mas.length - 1));
            if (mas.length - 1 == count) {
                System.out.println("Мешок полон");
                break;
            }
        }
    }

    public Object remove() {
        boolean flag = false;
        Object tmp=null;
        if (mas.length == 0) return tmp;
        while (!flag) {
            int r = (int) Math.round(Math.random() * (mas.length - 1));
            for (int k = 0; k < mas.length; k++) {
                if (mas[k] != null && r == k) {
                    tmp = mas[k];
                    System.out.println("Предмет " + mas[k] + " удален");
                    mas[k]=null;
                    flag = true;
                    break;
                }
            }
        }
        return tmp;
    }

    public final Object retElem(int i) {
        return mas[i];
    }

    public final int retSize() {
        return mas.length;
    }

    public void show() {
        for (Object i : mas) {
            if(i!=null)
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

    class PairBag {
      private final Bag bag;
      public final Bag getBag() {return bag;}
      public  PairBag(int n) {
          bag=new Bag(n);
        }

       public void add(Object num,Object num1) {
            int count = -1;
            boolean flag = false;
            Pair pair1 = Pair.make_pair(num,num1);
            int r = (int) Math.round(Math.random() * (bag.getMas().length - 1));
            while (!flag) {
                for (int k = 0; k < bag.getMas().length; k++) {
                    if (bag.getMas()[k] == null) {
                        if(r==k) {
                            bag.getMas()[k]=pair1;
                            System.out.println("Пара значений ");
                            pair1.show();
                            System.out.print("добавлена в мешок");
                            System.out.println();
                            flag = true;
                            break;
                        }
                    } else count++;
                }
                r = (int) Math.round(Math.random() * (bag.getMas().length - 1));
                if (bag.getMas().length - 1 == count) {
                    System.out.println("Мешок полон");
                    break;
                }
            }
        }
       public Object remove() {
            boolean flag = false;
            Pair tmp = new Pair();
            if (bag.getMas().length == 0) return tmp;
            while (!flag) {
                int R = (int) Math.round(Math.random() * (bag.getMas().length - 1));
                for (int k = 0; k < bag.getMas().length; k++) {
                    if (bag.getMas()[k] != null && R == k) {
                        tmp = (Pair)bag.getMas()[k];
                        System.out.println("Пара значений ");
                        ((Pair<?, ?>) bag.getMas()[k]).show();
                        System.out.print(" удалена");
                        bag.getMas()[k]=null;
                        flag = true;
                        break;
                    }
                }
            }
            return tmp;
        }
        public final Object retElem(int i) {
            return bag.getMas()[i];
        }
        public final int retSize(){return this.bag.retSize();}
        public void show() {
            for (int i=0;i<bag.getMas().length;i++) {
                if(bag.getMas()[i]!=null)
                System.out.print(bag.getMas()[i] + " ");
            }
            System.out.println();
        }
    }

class GPairBag<T1, T2> {
    private PairBag pairBag;

    public GPairBag(int length) {
        this.pairBag = new PairBag(length);
    }

    public int retSize() {
        return this.pairBag.retSize();
    }


    public void add(T1 value1, T2 value2) {
        this.pairBag.add(value1, value2);
    }

    public void remove() {
        this.pairBag.remove();
    }

    public Pair<T1, T2> ret(int i) {
        return (Pair<T1, T2>) this.pairBag.retElem(i);
    }
}

class GenericPairBag<T1,T2>{
    ArrayList<Pair<T1,T2>> mas;
    public  GenericPairBag(int n) {
        mas=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            mas.set(i,null);
        }
    }

    public void add(T1 num,T2 num1) {
        int count = -1;
        boolean flag = false;
        Pair pair1 = Pair.make_pair(num,num1);
        int r = (int) Math.round(Math.random() * (mas.size() - 1));
        while (!flag) {
            for (int k = 0; k < mas.size(); k++) {
                if (mas.get(k) == null) {
                    if(r==k) {
                        mas.set(k,pair1);
                        System.out.println("Пара значений ");
                        pair1.show();
                        System.out.print("добавлена в мешок");
                        System.out.println();
                        flag = true;
                        break;
                    }
                } else count++;
            }
            r = (int) Math.round(Math.random() * (mas.size() - 1));
            if (mas.size() - 1 == count) {
                System.out.println("Мешок полон");
                break;
            }
        }
    }
    public Pair remove() {
        boolean flag = false;
        Pair tmp = new Pair();
        if (mas.size() == 0) return tmp;
        while (!flag) {
            int R = (int) Math.round(Math.random() * (mas.size() - 1));
            for (int k = 0; k < mas.size(); k++) {
                if (mas.get(k) != null && R == k) {
                    tmp = mas.get(k);
                    System.out.println("Пара значений ");
                    mas.get(k).show();
                    System.out.print(" удалена");
                    mas.set(k,null);
                    flag = true;
                    break;
                }
            }
        }
        return tmp;
    }
    public final Pair retElem(int i) {
        return mas.get(i);
    }
    public final int retSize(){return mas.size();}
    public void show() {
        for (int i=0;i<mas.size();i++) {
            if(mas.get(i)!=null)
                System.out.print(mas.get(i) + " ");
        }
        System.out.println();
    }
}

    class DList<T1, T2> {

        private ArrayList<T1> m_arr;
        private ArrayList<ArrayList<T2>> m_list_arr;

        public DList() {
            m_arr = new ArrayList<>();
            m_list_arr = new ArrayList<>();
        }

        public void addList(T1 list_id, ArrayList<T2> arr) {
            if (!m_arr.contains(list_id))                       //if the id is not the list1
            {
                m_arr.add(list_id);                             //add id to the list1
                m_list_arr.add(arr);                            //add the list to the m_list_arr
            } else {
                int ind = m_arr.indexOf(list_id);           //if the id is already int the list1, find index of that id

                m_list_arr.add(ind, arr);                    //add the list to the respective list in m_list_arr
            }
        }

        public void deleteList(int i) {
            if (i >= 0) {
                if (i < m_arr.size()) {
                    m_arr.remove(i);
                    m_list_arr.remove(i);
                } else {
                    System.out.println("Индекс должен быть меньше чем " + m_arr.size());
                }
            } else {
                System.out.println("Индекс не должен быть отрицательным");
            }
        }

        public void deleteList(T1 id) {
            if (m_arr.contains(id))                 //if m_arr contains the id, find its index and delete it
            {
                int ind = m_arr.indexOf(id);
                m_arr.remove(ind);
                m_list_arr.remove(ind);
            } else {
                System.out.println("Здесь нет такого элемента");
            }

        }

        public ArrayList<T2> getList(int i) {
            ArrayList<T2> temp_list = null;

            if (i >= 0) {
                if (i < m_arr.size()) {
                    temp_list = m_list_arr.get(i);
                } else {
                    System.out.println("Индекс должен быть меньше чем " + m_arr.size());
                }
            } else {
                System.out.println("Индекс должен быть неотрицательным");
            }

            return temp_list;
        }

        public ArrayList<T2> getList(T1 id) {
            ArrayList<T2> temp_list = null;

            if (m_arr.contains(id)) {
                temp_list = m_list_arr.get(m_arr.indexOf(id));
            } else {
                System.out.println("Здесь нет элемента с таким значением");
            }

            return temp_list;
        }
    }

class AWM {

    private Integer[] coins;

    public AWM(Integer[] arr_coins) {
        coins = arr_coins;
    }

    public ArrayList<Integer> GetMoneySet(int amount_money) {
        int sum = 0;
        ArrayList<Integer> arr_coins = new ArrayList<>();

        Arrays.sort(coins);

        System.out.println("After sorting: ");
        System.out.println(Arrays.toString(coins));

        int temp = amount_money;

        for (int j = coins.length - 1; j >= 0; j--) {
            if (temp - coins[j] >= 0)
            {
                arr_coins.add(coins[j]);
                temp -= coins[j];
            }
        }

        return arr_coins;
    }
}

class Person {
    private String firstName;
    private String lastname;
    private int age;

    public Person(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public Person(String firstName, String lastname, int age) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastname() {
        return this.lastname;
    }

    public int getAge() {
        return this.age;
    }

    public void view() {
        System.out.println("First name: " + this.firstName);
        System.out.println("Last name: " + this.lastname);
        System.out.println("Age: " + this.age);
    }
}

abstract class HashFunction<K> {
    protected final int size;

    public abstract int hash(K var1);

    public HashFunction(int size) {
        this.size = size;
    }
}
class StrHashFunction<K> extends HashFunction<K> {
    public StrHashFunction(int size) {
        super(size);
    }

    public int hash(K key) {
        int p = 53,p_pow=1;
        Integer hash=0;
        char[] arr = key.toString().toCharArray();
        for(var i:arr){
            hash += (i - 'a' + 1) * p_pow;
            p_pow *= p;
        }

        return hash%size;
    }
}
class HashTable<K, T> {
    private final ArrayList<ArrayList<Pair<K, T>>> table;
    private final StrHashFunction<K> func;
    private final int size;

    public HashTable(int n) {
        this.size = n;
        this.func = new StrHashFunction(this.size);
        this.table = new ArrayList(this.size);

        for(int i = 0; i < n; ++i) {
            this.table.add(new ArrayList());
        }

    }

    public T find(K key) {
        int index = this.func.hash(key);
        Iterator var3 = (this.table.get(index)).iterator();

        Pair l;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            l = (Pair)var3.next();
        } while(!l.getFirst().equals(key));

        return (T) l.getSecond();
    }

    public void add(K key, T value) {
        int hash = this.func.hash(key);
        (this.table.get(hash)).add(new Pair(key, value));
    }

    public boolean delete(K key) {
        int index = this.func.hash(key);
        T del = this.find(key);
        if (del == null) {
            return false;
        } else {
            (this.table.get(index)).remove(key);
            return true;
        }
    }
}
    public class Main {

        public static void main(String[] args) {

            Pair.make_pair(5, "s");
            Pair pair=new Pair<>();
            pair.setFirst(1);
            pair.setSecond("cat");
            pair.show();
            System.out.println();
            Bag bag = new Bag(5);
            bag.add(5);
            bag.add(1);
            bag.add(52);
            bag.add(-6);
            bag.add(3);
            bag.add(3);
            bag.add(4);
            bag.add(8);
            System.out.println(bag.retSize());
            System.out.println();
            System.out.println(bag.retElem(1));
            System.out.println();
            bag.show();
            bag.remove();
            bag.show();
            bag.remove();
            bag.show();
            bag.remove();
            bag.show();


            PairBag pairbag = new PairBag(5);
            pairbag.add(7, "cats");
            pairbag.add(5, "dogs");
            pairbag.add(10, "parrots");
            pairbag.add(2, "bears");
            pairbag.add(1, "tiger");
            pairbag.show();


            DList list=new DList<>();
            ArrayList<Integer> list1=new ArrayList<>();
            list1.add(1);
            list1.add(2);
            list1.add(5);
            list1.add(10);

           list.addList(15,list1);
        }
    }



