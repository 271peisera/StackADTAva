public class LinkedStack<T> implements StackInterface<T>{
     
    private LLNode<T> stack;
    private int size; 
    
    public LinkedStack(){
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
        return stack.getInfo();
    }


  public T pop() throws StackUnderflowException {

        if(empty()){
            throw new StackUnderflowException("Stack is empty");
        }
        LLNode <T> submit = stack;
        LLNode <T> Temp = stack.getLink();
        stack = temp;
        return submit;
    }

    @Override
    public T push(T item) {
        
        LLNode<T> temp = new LLNode(item);
        if(size == 0 ){
            stack = temp;
        }
        else{
            temp.setLink(stack){
                stack = temp;
            }
        }
        size++;
        return item;
    }

    @Override
    public void clear() {

        stack = null;
        size = 0;
    }

    @Override
    public int search(Object o) {
        LLNode<T> temp = stack;
        int index = 1;
        if(size == 0){
        return -1;
       }
       
       else{
        while(temp != null){
            if(temp.getInfo() == o){
                return index;
            }
            index++;
        }
       }
       return -1;
        
    }

}