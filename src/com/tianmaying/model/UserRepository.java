package com.tianmaying.model;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static List<User> users = new ArrayList<>();
    
    static {
        users.add(new User("david@tianmaying.com", "david", "111111","天码营技术学习平台创始人"));
        users.add(new User("ricky@tianmaying.com", "ricky", "222222", "天码营技术总监，全栈程序员, DevOps，超级工具控"));
        users.add(new User("cliff@tianmaying.com", "cliff", "333333","传说中的快刀手，北大计算机应用与设计协会前理事长"));
        users.add(new User("harttle@tianmaying.com", "harttle", "444444","北大物理系出身的Linux极客，追求极致简单，武术发烧友"));
    }
    
    public static List<User> getAll() {
        return users;
    }
    
    public static User getByUsername(String username) {
        return users.stream()
                .filter(e -> e.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
    
    public static void add(User user) {
        users.add(user);
    }
}