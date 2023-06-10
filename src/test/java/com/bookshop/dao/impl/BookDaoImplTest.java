package com.bookshop.dao.impl;

import com.bookshop.dao.BookDao;
import com.bookshop.pojo.Book;
import com.bookshop.pojo.Page;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class BookDaoImplTest {

    private BookDao bookDao = new BookDaoImpl();

    /*
    * 1.添加图书
     */
    @Test
    void addBook() {
        bookDao.addBook(new Book(null,"为什么这么帅！", "191125", new BigDecimal(9999),1100000,0,null));

    }
    /*
    * 2.删除图书
     */

    @Test
    void deleteBookById() {
        bookDao.deleteBookById(21);
    }
    /*
    * 3.修改图书
     */
    @Test
    void updateBook() {
        bookDao.updateBook(new Book(21,"这么帅！", "国哥", new BigDecimal(9999),1100000,0,null));
    }

    /*
    * 4.查询图书
     */
    @Test
    void queryBookById() {
        System.out.println( bookDao.queryBookById(21) );
    }

    /*
    * 5.查询所有图书
     */
    @Test
    void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    /*
    * 6.查询总记录数
     */
    @Test
    void queryForPageTotalCount() {
        System.out.println( bookDao.queryForPageTotalCount() );
    }

    /*
    * 7.查询当前页数据
     */
    @Test
    void queryForPageTotalCountByPrice() {
        System.out.println( bookDao.queryForPageTotalCountByPrice(10, 50) );
    }

    /*
    * 8.价格区间查询
     */
    @Test
    void queryForPageItemsByPrice() {
        for (Book book : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE, 10, 50)) {
            System.out.println(book);
        }

    }

    /*
    * 9.分页查询
     */
    @Test
    void queryForPageItems() {
        for (Book book : bookDao.queryForPageItems(8, Page.PAGE_SIZE)) {
            System.out.println(book);
        }
    }

}