package lab6;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * Custom generic linked list implementation for MusicComposition objects
 * Implements List interface with a singly linked list data structure
 * 
 * @param <T> the type of elements in the list (extends MusicComposition)
 */
public class MusicCompositionList<T extends MusicComposition> implements List<T> {
  // Inner node class for singly linked list
  private class Node {
      T data;
      Node next;

      Node(T data) {
          this.data = data;
          this.next = null;
      }
  }

  // Head of the linked list
  private Node head;
  // Size of the list
  private int size;

  /**
   * Default constructor
   * Creates an empty list
   */
  public MusicCompositionList() {
      head = null;
      size = 0;
  }

  /**
   * Constructor that creates a list with a single element
   * 
   * @param element first element to be added to the list
   */
  public MusicCompositionList(T element) {
      head = new Node(element);
      size = 1;
  }

  /**
   * Constructor that creates a list from an existing collection
   * 
   * @param collection collection of elements to be added to the list
   */
  public MusicCompositionList(Collection<? extends T> collection) {
      this();
      addAll(collection);
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
  public boolean contains(Object o) {
      Node current = head;
      while (current != null) {
          if (current.data.equals(o)) {
              return true;
          }
          current = current.next;
      }
      return false;
  }

  @Override
  public Iterator<T> iterator() {
      return new Iterator<T>() {
          private Node current = head;

          @Override
          public boolean hasNext() {
              return current != null;
          }

          @Override
          public T next() {
              if (!hasNext()) {
                  throw new NoSuchElementException();
              }
              T data = current.data;
              current = current.next;
              return data;
          }
      };
  }

  @Override
  public Object[] toArray() {
      Object[] array = new Object[size];
      Node current = head;
      for (int i = 0; i < size; i++) {
          array[i] = current.data;
          current = current.next;
      }
      return array;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <E> E[] toArray(E[] a) {
      if (a.length < size) {
          a = (E[]) new Object[size];
      }
      
      Node current = head;
      for (int i = 0; i < size; i++) {
          a[i] = (E) current.data;
          current = current.next;
      }
      
      if (a.length > size) {
          a[size] = null;
      }
      
      return a;
  }

  @Override
  public boolean add(T e) {
      Node newNode = new Node(e);
      
      if (head == null) {
          head = newNode;
      } else {
          Node current = head;
          while (current.next != null) {
              current = current.next;
          }
          current.next = newNode;
      }
      
      size++;
      return true;
  }

  @Override
  public boolean remove(Object o) {
      if (head == null) return false;

      // Check if head needs to be removed
      if (head.data.equals(o)) {
          head = head.next;
          size--;
          return true;
      }

      // Search for the node to remove
      Node current = head;
      Node previous = null;
      while (current != null) {
          if (current.data.equals(o)) {
              previous.next = current.next;
              size--;
              return true;
          }
          previous = current;
          current = current.next;
      }

      return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
      for (Object element : c) {
          if (!contains(element)) {
              return false;
          }
      }
      return true;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
      for (T element : c) {
          add(element);
      }
      return !c.isEmpty();
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
      // This implementation is less efficient for linked list
      if (index < 0 || index > size) {
          throw new IndexOutOfBoundsException();
      }

      for (T element : c) {
          add(index, element);
          index++;
      }
      return !c.isEmpty();
  }

  @Override
  public boolean removeAll(Collection<?> c) {
      boolean modified = false;
      for (Object element : c) {
          while (remove(element)) {
              modified = true;
          }
      }
      return modified;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
      boolean modified = false;
      Node current = head;
      Node previous = null;

      while (current != null) {
          if (!c.contains(current.data)) {
              if (previous == null) {
                  head = current.next;
              } else {
                  previous.next = current.next;
              }
              size--;
              modified = true;
          } else {
              previous = current;
          }
          current = current.next;
      }

      return modified;
  }

  @Override
  public void clear() {
      head = null;
      size = 0;
  }

  @Override
  public T get(int index) {
      if (index < 0 || index >= size) {
          throw new IndexOutOfBoundsException();
      }

      Node current = head;
      for (int i = 0; i < index; i++) {
          current = current.next;
      }
      return current.data;
  }

  @Override
  public T set(int index, T element) {
      if (index < 0 || index >= size) {
          throw new IndexOutOfBoundsException();
      }

      Node current = head;
      for (int i = 0; i < index; i++) {
          current = current.next;
      }

      T oldElement = current.data;
      current.data = element;
      return oldElement;
  }

  @Override
  public void add(int index, T element) {
      if (index < 0 || index > size) {
          throw new IndexOutOfBoundsException();
      }

      Node newNode = new Node(element);

      if (index == 0) {
          newNode.next = head;
          head = newNode;
      } else {
          Node current = head;
          for (int i = 0; i < index - 1; i++) {
              current = current.next;
          }
          newNode.next = current.next;
          current.next = newNode;
      }

      size++;
  }

  @Override
  public T remove(int index) {
      if (index < 0 || index >= size) {
          throw new IndexOutOfBoundsException();
      }

      T removedElement;
      if (index == 0) {
          removedElement = head.data;
          head = head.next;
      } else {
          Node current = head;
          for (int i = 0; i < index - 1; i++) {
              current = current.next;
          }
          removedElement = current.next.data;
          current.next = current.next.next;
      }

      size--;
      return removedElement;
  }

  @Override
  public int indexOf(Object o) {
      Node current = head;
      for (int i = 0; i < size; i++) {
          if (current.data.equals(o)) {
              return i;
          }
          current = current.next;
      }
      return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
      int lastIndex = -1;
      Node current = head;
      for (int i = 0; i < size; i++) {
          if (current.data.equals(o)) {
              lastIndex = i;
          }
          current = current.next;
      }
      return lastIndex;
  }

  @Override
  public ListIterator<T> listIterator() {
      throw new UnsupportedOperationException("ListIterator not implemented");
  }

  @Override
  public ListIterator<T> listIterator(int index) {
      throw new UnsupportedOperationException("ListIterator not implemented");
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
      if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
          throw new IndexOutOfBoundsException();
      }

      MusicCompositionList<T> subList = new MusicCompositionList<>();
      Node current = head;
      for (int i = 0; i < fromIndex; i++) {
          current = current.next;
      }

      for (int i = fromIndex; i < toIndex; i++) {
          subList.add(current.data);
          current = current.next;
      }

      return subList;
  }
}