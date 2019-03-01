package com.tianmaying.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    private static List<Project> projects = new ArrayList<>();
    
    static {
        projects.add(new Project("Onboard", "Onboard是一个使用Java和OSGi技术开发的新一代敏捷软件开发协作平台", "http://onboard.cn", "./img/onboard.png"));
        projects.add(new Project("天码营", "descript致力于打造新一代的技术学习服务平台，提供创新并且专业的内容、工具与服务，帮助学习者实现个人价值", "http://tianmaying.com", "./img/tmy.png"));
        projects.add(new Project("OSGi中文社区", "OSGi中文社区是国内最具影响力的Java模块化开发技术社区,有数万OSGi从业人员在网站上学习和交流", "http://osgi.com.cn", "./img/catty.jpeg"));
    }
    
    public static List<Project> getAll() {
        return projects;
    }
    
    public static Project getByName(String projectname) {
        return projects.stream()
                .filter(e -> e.getName().equals(projectname))
                .findFirst()
                .orElse(null);
    }
    
    public static void add(Project project) {
        projects.add(project);
    }
}