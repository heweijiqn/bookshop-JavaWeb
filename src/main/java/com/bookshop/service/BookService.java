package com.bookshop.service;

import com.bookshop.pojo.Book;
import com.bookshop.pojo.Page;

import java.util.List;

@SuppressWarnings("all")
public interface BookService {

    /**
     * 添加图书
     * @param book
     */
    public void addBook(Book book);
    /**
     * 根据id删除图书
     * @param id
     */
    public void deleteBookById(Integer id);
    /**
     * 更新图书
     * @param book
     */
    public void updateBook(Book book);
    /**
     * 根据id查询图书
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);
    /**
     * 查询全部图书
     * @return
     */
    public List<Book> queryBooks();
    /**
     * 查询总记录数
     * @return
     */
    public  Object queryValue();
    /**
     * 分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Book> page(int pageNo, int pageSize);
    /**
     * 分页
     * @param pageNo
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
