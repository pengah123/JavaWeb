package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.util.*;

public class jsonTest {
    @Test
    public void test1() throws Exception {
        Person person = new Person();
        person.setName("jack");
        person.setAge(13);
        person.setGender("male");
        person.setBirth(new Date());
//        java 转json ,创建一个Mapper对象
        ObjectMapper map = new ObjectMapper();
        String s = map.writeValueAsString(person);
        System.out.println(s);
    }

    @Test
    public void test2() throws Exception {
        Person person = new Person();
        person.setName("jack");
        person.setAge(13);
        person.setGender("male");
        person.setBirth(new Date());
        Person person1 = new Person();
        person.setName("Rose");
        person.setAge(13);
        person.setGender("female");
        person.setBirth(new Date());

        List<Person> list=new ArrayList<Person>();
        list.add(person);
        list.add(person1);
//        java 转json ,创建一个Mapper对象
        ObjectMapper map = new ObjectMapper();
        String s = map.writeValueAsString(list);
        System.out.println(s);
    }

    @Test
    public void test3() throws Exception {
        Map<String,Object> maps=new HashMap<String,Object>();
        maps.put("name","jack");
        maps.put("age",13);
        maps.put("gender","female");
//        java 转json ,创建一个Mapper对象
        ObjectMapper map = new ObjectMapper();
        String s = map.writeValueAsString(maps);
        System.out.println(s);
    }

    @Test
    public void test4() throws Exception {
       String s="{\"gender\":\"female\",\"name\":\"jack\",\"age\":13}";
//        java 转json ,创建一个Mapper对象
        ObjectMapper map = new ObjectMapper();

        Person person = new Person();
        Person person1 = map.readValue(s, person.getClass());
        System.out.println(person1.toString());
    }
}
