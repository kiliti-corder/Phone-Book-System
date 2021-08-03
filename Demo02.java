package study.month07.day29.homework;

/**
 * @author alin
 * @version v1.0
 * @ProjectName Project01
 * @date 2021-08-03-3:13 AM
 */

import java.util.*;

/**
 * 作业2--电话本
 */

class Person{

    private String name;
    private String sex;
    private int age;
    private long phoneNumber;
    private long QQNumber;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getQQNumber() {
        return QQNumber;
    }

    public void setQQNumber(long QQNumber) {
        this.QQNumber = QQNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person() {
    }

    public Person(String name, String sex, int age, long phoneNumber, long QQNumber, String address) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.QQNumber = QQNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "姓名: " + name + ", 性别: " + sex + ",年龄: " + age + ", 手机号码: " + phoneNumber + ", QQ: " + QQNumber + ", 地址: " + address ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age ==person.age &&
                phoneNumber == person.phoneNumber &&
                QQNumber == person.QQNumber &&
                Objects.equals(name, person.name) &&
                Objects.equals(sex, person.sex) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, sex, age, phoneNumber, QQNumber, address);
    }


}

class PhoneManagerSystem{
    Scanner sc = new Scanner(System.in);
    //person p = new person();
    HashMap<String,Person> map = new HashMap<>();

    //系统
    public void show() throws InterruptedException{


        String ans02 = "";
        int ans ;
        boolean flag = true;
        while (true) {
            System.out.println("----------------电话本管理系统----------------");
            System.out.println("\t1.添加 2.删除 3.修改 4.查询所有 5.根据姓名查询 0.退出");
            System.out.println("----------------电话本管理系统----------------");
            System.out.println("请选择业务: ");
            Scanner sc = new Scanner(System.in);

            try {
                ans = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("您的输入有误!请重新输入!");
                continue;
            }
            if(ans == 1){
                /**
                 * 1.添加业务
                 *
                 */
                addPersonInfo();
                continue;
            } else if (ans == 2){
                /**
                 * 2.删除业务
                 */
                deletePersonAllInfo();
                continue;
            } else if (ans == 3){
                /**
                 * 3.修改业务
                 *
                 */
                alterPeronInfo();
                continue;
            } else if (ans == 4){
                /**
                 * 4.查询所有人的信息业务
                 *
                 */
                queryAllPersonInfo();
                continue;
            } else if (ans == 5){
                /**
                 * 5.根据姓名查询业务
                 */
                queryForName();
                continue;
            } else if (ans == 0){
                /**
                 * 0.退出
                 */
                System.out.println("感谢您的使用...");
                break;
            } else {
                System.out.println("您的输入有误!请重新输入!");
                continue;
            }


        }

    }

    /**
     * 1.添加业务
     */
    public void addPersonInfo() throws InterruptedException{
        String ans02 = "";

        boolean flag = true;
        while (flag) {
            System.out.println("姓名:");
            String name = sc.next();
            System.out.println("性别: ");
            String sex = sc.next();
            System.out.println("年龄: ");
            int age = sc.nextInt();
            System.out.println("手机号码: ");
            long phoneNumber = sc.nextLong();
            System.out.println("QQ号码:");
            long QQNumber = sc.nextLong();
            System.out.println("家庭住址:");
            String address = sc.next();
            map.put(name,new Person(name,sex,age,phoneNumber,QQNumber,address));
            // System.out.println(map.get(name));
            System.out.println("是否继续?(y/n)");
            ans02 = sc.next();
            if ("n".equals(ans02)){
                System.out.println("正在退出....");
                Thread.sleep(250);
                System.out.println("感谢您的使用...");
                break;
            } else if ("y".equals(ans02)){
                System.out.println("正在为您跳添加页面....");
                Thread.sleep(250);
            } else {
                System.out.println("您输入有误!正在为您跳转管理系统页面....");
                Thread.sleep(250);
                break;
            }
        }
    }

    /**
     * 2.删除业务
     */
    public void deletePersonAllInfo(){
        String name = "";
        String ans = "";
        boolean flag = true;
        while (flag) {
            System.out.println("请输入您要删除的用户的名字: ");
            name = sc.next();
            map.remove(name);
            System.out.println("删除成功!");
            System.out.println("是否继续删除?(y/n)");
            ans = sc.next();
            if ("y".equals(ans)){
                System.out.println("正在跳转删除页面...");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if ("n".equals(ans)){
                System.out.println("正在转跳管理主页面...");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            } else {
                System.out.println("您输入有误!正在为您转跳管理主页面...");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        //System.out.println(map);
    }

    /**
     * 3.修改信息业务
     */
    public void alterPeronInfo(){
        String name = "";
        String ans = "";
        String newName = "";
        String newSex = "";
        int newAge = 0;
        long newPhoneNumber = 0l;
        long newQQNumber = 0l;
        String newAddress = "";
        System.out.println("请输入您要修改的用户的姓名: ");
        name = sc.next();
        System.out.println("请输入新姓名: ");
        newName = sc.next();
        System.out.println("请输入新年龄: ");
        newAge = sc.nextInt();
        System.out.println("请输入新电话号码: ");
        newPhoneNumber = sc.nextLong();
        System.out.println("请输入新QQ号码: ");
        newQQNumber = sc.nextLong();
        System.out.println("请输入新地址: ");
        newAddress = sc.next();
        map.replace(name,map.get(name),new Person(newName,newSex,newAge,newPhoneNumber,newQQNumber,newAddress));
    }

    /**
     * 4.查询所有信息
     */
    public void queryAllPersonInfo(){
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()){
            String key = it.next();
            Person val = map.get(key);
            System.out.println(val);
        }
    }

    /**
     * 5.根据姓名查询
     */
    public void queryForName(){
        String name = "";
        String answer = "";
        boolean flag = true;
        while (flag) {
            System.out.println("请输入你要查询的用户的姓名:");
            name = sc.next();

            try {
                if (map.get(name).equals(null)){
                    System.out.println("您输入的姓名为空,请重新输入!");
                }
            } catch (NullPointerException e) {
                System.out.println("您输入的姓名为空,请重新输入!");
                continue;
            }
            System.out.println(map.get(name));

            System.out.println("是否继续查询?(y/n)");
            answer = sc.next();
            if ("y".equals(answer)){
                System.out.println("正在跳转查询页面...");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if ("n".equals(answer)){
                System.out.println("正在转跳管理主页面...");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            } else {
                System.out.println("您输入有误!正在为您转跳主页面...");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}

public class Demo02 {

    public static void main(String[] args) throws InterruptedException{
        PhoneManagerSystem pms = new PhoneManagerSystem();
        pms.show();
    }


}
