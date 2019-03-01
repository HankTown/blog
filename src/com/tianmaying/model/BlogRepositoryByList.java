package com.tianmaying.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class BlogRepositoryByList implements BlogRepository {
    private static final String FOLDER = "TMY-BLOG"; // 保存文件的文件夹名称
    private static final String SEPARATOR = "---"; // id和title的分隔符
    private static BlogRepository blogRepository;
    private static List<Blog> blogs = new ArrayList<Blog>();
    
    static {
        User user = UserRepository.getByUsername("david");
        blogs.add(new Blog("Java Web实战训练", "如何快速提高编程实战经验？如何一步一步完整一个真正的项目？如何成为Web全栈工程师？如何找到一群一起进步的人？快来天码营把握先机！和一流的工程师一起做实战项目，是快速掌握一门技术的最好方法！或者你可以尝试一个更加轻量级的Spring MVC实战训练或者使用MyBatis开发问答网站。", user));
        blogs.add(new Blog("Java入门基础教程", "将Java的入门基础知识贯穿在一个实例中，逐步深入，帮助你快速进入Java编程的世界！更加体系化地学习Java开发请参考Java Web实战训练。为了巩固Java编程基础，你也可以尝试Java贪吃蛇游戏的编程练习。", user));
        blogs.add(new Blog("打造功能完整的博客系统：Spring MVC实战入门", "Spring MVC实战入门训练，以一个博客系统为例，将Spring MVC的核心知识融入到实战当中，让你真正掌握基于Spring MVC开发实战项目的能力。请参考天码营学员的成长和作品", user));
        blogs.add(new Blog("Java贪吃蛇的设计与实现", "了解用面向对象的方式来编程解决问题，学习如何设计类，如何选择数据结构以及Java多线程与界面编程的基础知识。练习完成之后，你会发现你编写了一个具有良好扩展性的代码，可以方便地添加更多高级功能，真正提高Java程序设计的能力。现在报名参加，还能赢取精品图书。", user));
    }

    public static BlogRepository instance() {
        if (blogRepository == null) {
            blogRepository = new BlogRepositoryByList();
        }
        return blogRepository;
    }

    private BlogRepositoryByList() {
    }

    @Override
    public void add(Blog blog) {
        blogs.add(blog);
    }

    @Override
    public Blog getBlogById(long id) {
        for (Blog blog : blogs) {
            if (blog.getId() == id) {
                return blog;
            }
        }
        return null;
    }

    @Override
    public void remove(long id) {
        for (Blog blog : blogs) {
            if (blog.getId() == id) {
                blogs.remove(blog);
                return;
            }
        }
    }

    @Override
    public List<Blog> getAll() {
        return blogs;
    }

    @Override
    public void loadData() throws BlogAppException {
        File dir = new File(FOLDER);
        List<File> files = (List<File>) FileUtils.listFiles(dir, null, true);
        for (File f : files) {
            try {
                String fileName[] = f.getName().split("---");
                String content = FileUtils.readFileToString(f, "utf-8");
                Blog blog = new Blog(fileName[1], content);
                blog.setId(Long.parseLong(fileName[0]));

                blogRepository.add(blog);
            } catch (IOException e) {
                e.printStackTrace();
                BlogAppException be = new BlogAppException("load");
                be.initCause(e);
                throw be;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                BlogAppException be = new BlogAppException("load");
                be.initCause(e);
                throw be;
            }
        }
    }

    @Override
    public void saveData() throws BlogAppException {
        for (Blog blog : BlogRepositoryByList.instance().getAll()) {
            String fileName = Long.toString(blog.getId()) + SEPARATOR
                    + blog.getTitle();
            try {
                FileUtils.write(new File(FOLDER + File.separator + fileName),
                        blog.getContent(), "utf-8");
            } catch (IOException e) {
                e.printStackTrace();
                BlogAppException be = new BlogAppException("save");
                be.initCause(e);
                throw be;
            }
        }
    }
}