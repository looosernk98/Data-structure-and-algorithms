
public class client{
    public static void main(String[] args) throws Exception{
        exper1();
    }

    public static void exper1()throws Exception{
       Stack<Integer> st= new Stack();

       for(int i=0; i<10; i++){
           st.push((int)Math.random()*100);
       }
    }
}