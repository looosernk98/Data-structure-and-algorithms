public class client{
    public static void main(String[] args) throws Exception{
        linkedList ll = new linkedList();
        for(int i = 1; i  <= 20; i++){
            ll.addLast(i*10);
        }

        System.out.println(ll);

    }
}