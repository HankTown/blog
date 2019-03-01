package com.tianmaying.model;

import java.util.List;

public interface BlogRepository {

    public void add(Blog blog);

    public Blog getBlogById(long id);

    public void remove(long id);

    public List<Blog> getAll();

    public void loadData() throws BlogAppException;

    public void saveData() throws BlogAppException;
}