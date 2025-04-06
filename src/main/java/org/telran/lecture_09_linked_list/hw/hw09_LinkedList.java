package org.telran.lecture_09_linked_list.hw;

// Закончите все методы, которые не успели на занятии

public class hw09_LinkedList {
    public static void main(String[] args) {
        // Пример использования
        LinkedList myList = new LinkedList();
        myList.append(1);
        myList.append(2);
        myList.append(4);
        myList.print();
        // Вставка элемента в начало
        myList.insertAt(0, 0);  // Вставим 0 на позицию 0 (в начало)
        System.out.println("Список после вставки 0 в начало:");
        myList.print(); // Ожидаемый вывод: 0 -> 1 -> 2 -> 4 -> null

        // Вставка элемента в середину
        myList.insertAt(3, 3);  // Вставим 3 на позицию 3 (между 2 и 4)
        System.out.println("Список после вставки 3 в середину:");
        myList.print(); // Ожидаемый вывод: 0 -> 1 -> 2 -> 3 -> 4 -> null

        // Вставка элемента в конец
        myList.insertAt(5, 5);  // Вставим 5 на последнюю позицию
        System.out.println("Список после вставки 5 в конец:");
        myList.print(); // Ожидаемый вывод: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null

        // Попытка вставить элемент по недопустимому индексу
        myList.insertAt(10, 10);  // Вставка по индексу 10 (недопустимый индекс)

        // Удаление элемента по индексу 0 (удаление головы)
        Integer removed = myList.removeAt(0);
        System.out.println("Удален элемент: " + removed);
        System.out.println("Список после удаления первого элемента:");
        myList.print(); // Ожидаемый вывод: 1-> 2 -> 3 -> 4 -> 5 ->null

        // Удаление элемента по индексу 1 (удаление второго элемента, который теперь в индексе 1)
        removed = myList.removeAt(1);
        System.out.println("Удален элемент: " + removed);
        System.out.println("Список после удаления элемента по индексу 1:");
        myList.print(); // Ожидаемый вывод: 1 -> 3 -> 4 -> 5 ->null

        // Удаление последнего элемента (по индексу 3)
        removed = myList.removeAt(3);
        System.out.println("Удален элемент: " + removed);
        System.out.println("Список после удаления последнего элемента:");
        myList.print(); // Ожидаемый вывод: 2 -> null

        // Попытка удалить элемент по недопустимому индексу 5
        removed = myList.removeAt(5);  // Удаление по индексу, который выходит за границы
        System.out.println("Удален элемент: " + removed); // Ожидаемый вывод: null

        // Удаление элемента по значению (например, 3)
        removed = myList.remove(3);
        System.out.println("Удален элемент: " + removed);
        System.out.println("Список после удаления элемента 3:");
        myList.print(); // Ожидаемый вывод: 1 -> 4 -> null

        // Удаление элемента, которого нет в списке
        removed = myList.remove(5); // Элемента 5 нет в списке
        System.out.println("Удален элемент: " + removed);  // Ожидаемый вывод: null

        // Размер списка
        System.out.println("Размер списка: " + myList.getSize()); // Ожидаемый вывод: 1
        System.out.print("Содержимое списка: ");
        myList.print(); // Ожидаемый вывод:1 -> 4 -> null



        // Удаление последнего элемента по значению (например, 3)
        removed = myList.remove(4);
        System.out.println("Удален элемент: " + removed);
        System.out.println("Список после удаления последнего элемента 4:");
        myList.print(); // Ожидаемый вывод: 1 -> null

        // Очищаем список
        myList.clear();

        // Проверяем, пуст ли список после очистки
        System.out.println("Список пуст после очистки? " + myList.isEmpty()); // Ожидаемый вывод: true

        // Проверяем размер списка после очистки
        System.out.println("Размер списка после очистки: " + myList.getSize()); // Ожидаемый вывод: 0

        // Пытаемся вывести содержимое списка после очистки
        System.out.print("Содержимое списка после очистки: ");
        myList.print(); // Ожидаемый вывод: null
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Добавление элемента в конец списка
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Вставка элемента в начало списка
    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

     //Вставка элемента по индексу
    public void insertAt(int data, int index) {
        if (index < 0 || index > size){
                    System.out.println("Index out of bounds");
                    return;
                }
        if (index == 0) {
            prepend(data);
        } else if (index == size) {
            append(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            Node previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            newNode.next = current;
            previous.next = newNode;
            size++;
        }
    }
//    public void insertAt(int data, int index) {
//        if (index < 0 || index > size) {
//            System.out.println("Index out of bounds");
//            return;
//        }
//
//        Node newNode = new Node(data);
//
//        // Вставка в начало списка
//        if (index == 0) {
//            newNode.next = head;
//            head = newNode;
//            if (tail == null) { // Если список был пуст
//                tail = head;
//            }
//        }
//        // Вставка в конец списка
//        else if (index == size) {
//            newNode.next = null;
//            tail.next = newNode;
//            tail = newNode;
//        }
//        // Вставка в середину списка
//        else {
//            Node current = head;
//            for (int i = 0; i < index - 1; i++) {
//                current = current.next;
//            }
//            newNode.next = current.next;
//            current.next = newNode;
//        }
//
//        size++; // Увеличиваем размер списка
//    }



    // Удаление элемента по значению
    public Integer remove(int data) {
        Node current = head;
        Node previous = null;

        // Поиск элемента в списке
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        // Если элемент не найден
        if (current == null) {
            return null;
        }

        // Если элемент находится в начале списка
        if (previous == null) {
            head = current.next;
            if (head == null) { // Если список стал пустым
                tail = null;
            }
        } else {
            previous.next = current.next;
            if (current == tail) { // Если элемент был последним
                tail = previous;
            }
        }

        size--;
        return current.data;
    }

    // Удаление элемента по индексу
    public Integer removeAt(int index) {
        if (index < 0 || index >= size) {
                    System.out.println("Index out of bounds");
                    return null;
                }

                if (index == 0) {
                    if (head == null) return null;
                    Integer data = head.data;
                    head = head.next;
                    if (head == null) {
                        tail = null;
                    }
                    size--;
                    return data;
                }

                Node current = head;
                Node previous = null;
                for (int i = 0; i < index; i++) {
                    previous = current;
                    current = current.next;
                }

                previous.next = current.next;
                if (current == tail) {
                    tail = previous;
                }
                size--;
                return current.data;
    }

    // Получение элемента по индексу
    public Integer getAt(int index) {
        if (index < 0 || index >= size) {
                    System.out.println("Index out of bounds");
                    return null;
                }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Проверка, пустой ли список
    public boolean isEmpty() {
        return size == 0;
    }

    // Получение размера списка
    public int getSize() {
        return size;
    }

    // Очистка списка
    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }

    // Вывод списка в консоль
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}