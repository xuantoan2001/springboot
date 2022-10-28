package com.xuantoan.springboot.service.impl;

import com.xuantoan.springboot.entity.ProductEntity;
import com.xuantoan.springboot.repository.ProductRepository;
import com.xuantoan.springboot.service.IProductService;
import com.xuantoan.springboot.utils.FileReadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.xuantoan.springboot.config.Common.PATH_IMAGE;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> findAll() {
        List<ProductEntity> list =  productRepository.findAll();
        for(ProductEntity i:list){
            i.setProductImage(ConventProductImg(i.getProductImage()));
        }
        return list;
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        ProductEntity old = new ProductEntity();
        if(product.getId() != null){
            old = productRepository.getById(product.getId());
        }
        //int oi = product.getProductImage().length();
        if(product.getProductImage().length() == 0){
            product.setProductImage(old.getProductImage());
        }
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
         productRepository.deleteById(id);
    }

    @Override
    public ProductEntity getProductById(Long id) {
        ProductEntity pd = productRepository.getById(id);
        pd.setProductImage(ConventProductImg(pd.getProductImage()));
        return pd;
    }

    public String ConventProductImg(String conventProductImg) {

        if(conventProductImg.contains("https://")){
            return conventProductImg;
        }else {
            try {
               return "data:image/png;base64,"+FileReadUtils.readFile(PATH_IMAGE, conventProductImg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return conventProductImg;
    }
}
