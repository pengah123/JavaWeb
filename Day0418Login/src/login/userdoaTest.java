package login;


import org.junit.Test;

public class userdoaTest {

    @Test
    public void testLogin() throws Exception {
        User user=new User();
        user.setName("lisi");
        user.setPassword("abcdefg");
        userdoa doa = new userdoa();
        User loginuser = doa.login(user);
        System.out.println(loginuser);
    }
}
