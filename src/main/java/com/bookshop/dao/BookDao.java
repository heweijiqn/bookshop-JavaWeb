package com.bookshop.dao;

import com.bookshop.pojo.Book;

import java.util.List;

@SuppressWarnings("all")
public interface BookDao {
    /**
     * 添加图书
     * @param book
     * @return
     */
    public int addBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);
    /**
     * 更新图书
     * @param book
     * @return
     */
    public int updateBook(Book book);
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
     * 查询当前页数据
     * @param begin
     * @param pageSize
     * @return
     */
    Integer queryForPageTotalCount();
    /**
     * 查询当前页数据
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryForPageItems(int begin, int pageSize);
    /**
     * 查询当前页数据
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
    /**
     * 查询当前页数据
     * @param begin
     * @param pageSize
     * @return
     */
    Integer queryForPageTotalCountByPrice(int min, int max);
}
