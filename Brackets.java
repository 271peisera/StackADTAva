public class Brackets
{
    public static void main(String[] args)
    {
        System.out.println("Should be true");
        System.out.println(checkBrackets(" "));
        System.out.println(checkBrackets("{}"));
        System.out.println(checkBrackets("{}{}"));
        System.out.println(checkBrackets("{{}}"));
        System.out.println(checkBrackets("{{{}{{}}}}"));

        System.out.println("\nShould be false");
        System.out.println(checkBrackets("{"));
        System.out.println(checkBrackets("}{"));
        System.out.println(checkBrackets("{}}{"));
        System.out.println(checkBrackets("{{}"));
        System.out.println(checkBrackets("{{}}}{}"));
    }
    
    public static boolean checkBrackets(String b)
    {
        if(b.length() == 0 || b.substring(0,1).equals(" ")){
            return true;
        }
        if(b.length() % 2 != 0 || b.substring(0, 1).equals("}"))
        {
            return false;
        }
        ArrayStack<String> temp = new ArrayStack<String>();
        for(int i = 0; i < b.length(); i++)
        {
            String item = b.substring(i, i + 1);
            if(item.equals("{")){
                temp.push(item);
            }
            if(item.equals("}")){
                if(temp.empty()){
                    return false;
                }
                 temp.pop();
                
            }

        }
        return temp.empty();


    
    }
}
