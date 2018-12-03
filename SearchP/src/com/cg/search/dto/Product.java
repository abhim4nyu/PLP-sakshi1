package com.cg.search.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.jboss.logging.annotations.Field;

@Entity

@Table(name = "Product")
public class Product
{
   @Id
   @Column(name = "id")
   private String id;
   
   @Column(name = "title", nullable= false, length = 128)

   private String title;
   
   @Column(name = "description", nullable= false, length = 256)

   private String description;
   
   @Column(name = "author", nullable= false, length = 64)

   private String author;
   
   @Column(name = "createdate", nullable= false)
   private Date createDate;
   
   @Column(name = "updatedate", nullable= false)
   private Date updateDate;

   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public String getAuthor()
   {
      return author;
   }

   public void setAuthor(String author)
   {
      this.author = author;
   }

   public Date getCreateDate()
   {
      return createDate;
   }

   public void setCreateDate(Date createDate)
   {
      this.createDate = createDate;
   }

   public Date getUpdateDate()
   {
      return updateDate;
   }

   public void setUpdateDate(Date updateDate)
   {
      this.updateDate = updateDate;
   }
}