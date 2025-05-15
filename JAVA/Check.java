public class Check 
{
    static String Admin[]={"1234","2341","5678","8901"};
    static String password[]={"abc","bcd","def","fgh"};
    static String username[]={"admin1","admin2","admin3","admin4"};

    public String check(String us,String pass)
    {
        for(int i=0;i<Admin.length;i++)
        {
            if( Admin[i].equals(us))
            {
                if(password[i].equals(pass))
                {
                    return username[i];
                }
            }
        }
        return "false";
    }
}
