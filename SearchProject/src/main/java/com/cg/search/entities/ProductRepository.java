package com.cg.search.entities;


import java.awt.print.Book;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.envers.tools.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@SuppressWarnings("unchecked")
public class ProductRepository
{
   @Autowired
   private SessionFactory mySessionFactory;

   @Transactional
   public void indexBooks() throws Exception
   {
      try
      {
         Session session = mySessionFactory.getCurrentSession();
      
         //FullTextSession fullTextSession = Search.getFullTextSession(session);
         //fullTextSession.createIndexer().startAndWait();
      }
      catch(Exception e)
      {
         throw e;
      }
   }
   
   @Transactional
   public void addBookToDB(String bookTitle, String bookDescription, String bookAuthor)
   {
      Session session = mySessionFactory.getCurrentSession();
      
      Book book = new Book();
 
      UUID x = UUID.randomUUID();
      
      Date dateNow = new Date();
      /*((Product) book).setId(x.toString());
      book.setAuthor(bookAuthor);
      book.setDescription(bookDescription);
      book.setTitle(bookTitle);
      book.setCreateDate(dateNow);
      book.setUpdateDate(dateNow);
      */
      session.saveOrUpdate(book);
   }
   
   @Transactional
   public List<Book> searchForBook(String searchText) throws Exception
   {
 /*     try
      {
         Session session = mySessionFactory.getCurrentSession();
         
         //FullTextSession fullTextSession = Search.getFullTextSession(session);

         Object fullTextSession;
		QueryBuilder qb = ((Object) fullTextSession).getSearchFactory()
          .buildQueryBuilder().forEntity(Book.class).get();
         org.apache.lucene.search.Query query = ((Object) qb)
           .keyword().onFields("description", "title", "author")
           .matching(searchText)
           .createQuery();

         Object query1;
		org.hibernate.Query hibQuery = 
            ((Object) fullTextSession).createFullTextQuery(query1, Book.class);

         List<Book> results = hibQuery.list();
         return results;
      }
      catch(Exception e)
      {
         throw e;
      }*/
   }

public void addProductToDB(Object productTitle, Object productDescription,
		Object productTitle2) {
	// TODO Auto-generated method stub
	
}

public List<Product> searchForProduct(String searchText) {
	// TODO Auto-generated method stub
	return null;
}
}
