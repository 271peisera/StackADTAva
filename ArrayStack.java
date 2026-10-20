import java.util.Arrays;
import java.util.Objects;

public class ArrayStack<T> implements StackInterface<T>{
     
    private T[] stack;
    private int size; 
    
    public ArrayStack(){
        this.stack = (T[])new Object[4];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {

        if (size == 0){
            return true;
        }
        return false;
    }


    @Override
    public T peek() throws StackUnderflowException {
        if(empty()){
            throw new StackUnderflowException("Stack is empty");
        }
        return (stack[size-1]);
    }


  public T pop() throws StackUnderflowException {

        if(empty()){
            throw new StackUnderflowException("Stack is empty");
        }
        T remove = stack[size-1];
        stack[size - 1] = null;
        size--;
        if(size < stack.length / 4 && stack.length > 4){
            halfLength();
        }
        return(remove);
    }

    @Override
    public T push(T item) {
        if (size == stack.length) {
            doubleLength();
        }
        stack[size] = item;
        size++;
        return item;
    }

    @Override
    public void clear() {

        while(size > 0){
            stack[size - 1] = null;
            size--;
        }
        size = 0;
    }

    @Override
    public int search(Object o) {
        for(int i = size - 1; i >= 0; i--){
            if(Objects.equals(stack[i], o)){
                return size - i;
            }
        }
        return -1;
        
    }

    public void doubleLength(){
        int length = stack.length;
        T[] newStack = (T[]) new Object[length * 2];
        for(int i = 0; i < length; i++){
            newLog[i] = log[i];
        }
        log = newLog;
    }

    public void halfLength(){
        int length = log.length;
        T[] newLog = (T[]) new Object[length / 2];
        for(int i = 0; i < length / 2; i++){
            newLog[i] = log[i];
        }
        log = newLog;
    }

    

}
