package com.morgan.product.controller;

import com.morgan.common.ResponseVo;
import com.morgan.common.dto.CartDTO;
import com.morgan.common.dto.ProductResp;
import com.morgan.product.Vo.ProductVo;
import com.morgan.product.entity.Category;
import com.morgan.product.entity.Product;
import com.morgan.product.service.CategoryService;
import com.morgan.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/",""})
    public ResponseVo<ProductVo> list(){
        List<Product> products = productService.findSaleAll();
        List<Integer> categoryType = products.stream()
                .map(Product::getCategoryType)
                .collect(Collectors.toList());

        List<Category> categories = categoryService.findByTypeIn(categoryType);

        List<ProductVo> productVos = new ArrayList<>();
        for (Category category : categories){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(category.getName());
            productVo.setCategoryType(category.getType());
            List<ProductVo.ProductInfoVo> productInfoVos = new ArrayList<>();
            for (Product product : products){
                if(product.getCategoryType().equals(category.getType())){
                    ProductVo.ProductInfoVo productInfoVo = new ProductVo.ProductInfoVo();
                    BeanUtils.copyProperties(product,productInfoVo);
                    productInfoVos.add(productInfoVo);
                }
            }
            productVo.setProductInfoVos(productInfoVos);
            productVos.add(productVo);
        }

        return ResponseVo.successResponse(productVos);
    }

    @PostMapping("/decreaseStock")
    public void  decreaseStock(@RequestBody  List<CartDTO> cartDTOS){
        productService.decreaseStock(cartDTOS);
    }

    @PostMapping("/listForOrder")
    public List<ProductResp> listForOrder(@RequestBody List<Integer> ids){
        return productService.findList(ids);
    }
}
