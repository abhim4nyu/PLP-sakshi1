package com.cg.search.controller;



import java.util.ArrayList;
import java.util.List;




import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.search.entities.Product;
import com.cg.search.entities.ProductRepository;

@Controller
public class Control
{
   private static Logger _logger = Logger.getLogger(Controller.class);
   
   @Autowired
   private ProductRepository _repo;
   
   @RequestMapping(value = "/welcome", method = RequestMethod.GET)
   public ModelAndView welcome() throws Exception
   {
    

      ModelAndView mav = new ModelAndView("hello");
      mav.addObject("message", "Hello World!");
      return mav;
   }

   @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
   public ModelAndView addProductPage()
   {
      ModelAndView mav = new ModelAndView("addProduct", "command", new ProductModel());
      return mav;
   }
   
   @RequestMapping(value = "/addProductToDB", method = RequestMethod.POST)
   public ModelAndView addProductToDB(
      @ModelAttribute("ProductModel")
      ProductModel ProductInfo
   ) throws Exception
   {
      _logger.info(ProductInfo.getProductTitle());
      _logger.info(ProductInfo.getProductDescription());
      _logger.info(ProductInfo.getProductTitle());
      
      _repo.addProductToDB(
         ProductInfo.getProductTitle(),
         ProductInfo.getProductDescription(),
         ProductInfo.getProductTitle()
      );
      
      ModelAndView mav = new ModelAndView("done");
      mav.addObject("message", "Add Product to DB successfully");
      return mav;
   }
   
   @RequestMapping(value = "/search", method = RequestMethod.GET)
   public ModelAndView searchPage()
   {
      ModelAndView mav = new ModelAndView("search");
      return mav;
   }

   @RequestMapping(value = "/doSearch", method = RequestMethod.POST)
   public ModelAndView search(
      @RequestParam("searchText")
      String searchText
   ) throws Exception
   {
      List<Product> allFound = _repo.searchForProduct(searchText);
      List<ProductModel> ProductModels = new ArrayList<ProductModel>();
      
      for (Product b : allFound)
      {
         ProductModel bm = new ProductModel();
       //  bm.setProductAuthor(b.getAuthor());
         //bm.setProductDescription(b.getDescription());
         //bm.setProductTitle(b.getTitle());
         
         ProductModels.add(bm);
      }
      
      ModelAndView mav = new ModelAndView("foundProducts");
      mav.addObject("foundProducts", ProductModels);
      return mav;
   }
}