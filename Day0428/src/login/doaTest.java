package login;

public class doaTest {
    public static void main(String[] args) {
        UserDoa userDoa = new UserDoa();
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("12345");
        User user1 = userDoa.login(user);
        System.out.println(user1.toString());
    }
}
