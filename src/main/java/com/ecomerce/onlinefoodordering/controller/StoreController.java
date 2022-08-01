package com.ecomerce.onlinefoodordering.controller;

import com.ecomerce.onlinefoodordering.Enum.ProductStatus;
import com.ecomerce.onlinefoodordering.model.Product;
import com.ecomerce.onlinefoodordering.model.Store;
import com.ecomerce.onlinefoodordering.service.CategoryService;
import com.ecomerce.onlinefoodordering.service.Category_ProductService;
import com.ecomerce.onlinefoodordering.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Value("${file.path}")
    String path;
    @Autowired
    Category_ProductService category_productService;


    @GetMapping("")
    public String  index(){
        return "/store/store-homepage";
    }

    @GetMapping("/add-product")
    public String getFormAddProduct(Model model,
                                    @RequestParam(name = "status",required = false) boolean status){
        if(status){
            model.addAttribute("status",true);
        }
        model.addAttribute("product",new Product());
        model.addAttribute("category",categoryService.getListCategory());
        return "/store/add-product";
    }

    @PostMapping("/add-product")
    public String submitProduct(@Valid @ModelAttribute Product product,
                                @RequestParam(name = "img",required = false)MultipartFile img,
                                Model model,
                                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/store/add-product";
        }



        product.setProductStatus(ProductStatus.Available);
        if (!img.isEmpty()) {
            product.setProductImage(img.getOriginalFilename());
            try {
                FileCopyUtils.copy(img.getBytes()
                        , new File(path + img.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        productService.addProduct(product);
        Product addedProduct = productService.findByProductName(product.getProductName());

        product.getCategory()
                .stream().forEach(c->{

                    category_productService.add(c.getCategory(),addedProduct);
                });
        return getFormAddProduct(model,true);
    }

    @GetMapping("/my-product")
    String getListProduct(Model model){
        model.addAttribute("list",productService.getAllProduct().
                stream().filter(p -> !p.getProductStatus().equals(ProductStatus.Deleted)).collect(Collectors.toList()));
        return "store/my-product";
    }

    @GetMapping("/edit-product/{ProductId}")
    public String geteditform(Model model,@PathVariable int ProductId){
        model.addAttribute("product",productService.getById(ProductId));
        return "store/edit-product-form";
    }

    @PostMapping("/submitedit/{ProductId}")
    public String submitedit (@ModelAttribute Product product,
                              @PathVariable(name = "ProductId") int ProductId,
                              Model model){
        Product editproduct = productService.getById(ProductId);
        editproduct.setProductName(product.getProductName());
        editproduct.setProductPrice(product.getProductPrice());
        productService.updateProduct(product,ProductId);
        return getListProduct(model);

    }
    @GetMapping("/remove-product/{ProductId}")
    public String removeproduct(Model model,@PathVariable int ProductId){
        productService.removeProduct(ProductId);
        return getListProduct(model);
    }

    @GetMapping("/freeze-product/{ProductId}")
    public String freezeproduct(Model model, @PathVariable int ProductId){
        productService.freezeProduct(ProductId);
        return getListProduct(model);

    }

    @GetMapping("open-product/{ProductId}")
    public String  openProduct(Model model,@PathVariable int ProductId){
        productService.openProduct(ProductId);
        return getListProduct(model);
    }
}
