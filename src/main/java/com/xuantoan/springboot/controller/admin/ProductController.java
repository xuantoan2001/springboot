package com.xuantoan.springboot.controller.admin;

import com.xuantoan.springboot.entity.CategoryEntity;
import com.xuantoan.springboot.entity.ProductEntity;
import com.xuantoan.springboot.service.ICategoryService;
import com.xuantoan.springboot.service.IProductService;
import com.xuantoan.springboot.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.xuantoan.springboot.config.Common.PATH_IMAGE;

@Controller
@RequestMapping("admin")
public class ProductController{
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;


    @RequestMapping(value = {"/product/list","/product"})
    public String list(Model model) {
        List<ProductEntity> products = productService.findAll();

        model.addAttribute("products", products);


        return "admin/product/list";
    }
    @RequestMapping("/product/new")
    public String newForm(Model model) {
        List<CategoryEntity> categories = categoryService.findAll();
        model.addAttribute("product", new ProductEntity());
        model.addAttribute("categories", categories);
        return "admin/product/add";
    }
    @RequestMapping(value = "/product/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Long productrId, Model model) {
        ProductEntity product = productService.getProductById(productrId);
        if(product != null){
            model.addAttribute("product", product);
        }
        List<CategoryEntity> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/product/add";
    }

    @RequestMapping(value = "product/save", method = RequestMethod.POST)
    public String save(ProductEntity product,@RequestParam("image") MultipartFile multipartFile) {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setProductImage(fileName);


        String uploadDir = PATH_IMAGE;

        try {
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        productService.save(product);
        return "redirect:/admin/product";
    }
    @RequestMapping(value = "product/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Long productId, Model model) {
        productService.delete(productId);
        return "redirect:/admin/product";
    }
}
