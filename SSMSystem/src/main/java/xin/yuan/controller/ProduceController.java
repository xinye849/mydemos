package xin.yuan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xin.yuan.domain.Product;
import xin.yuan.service.ProductService;

import java.util.List;

/**产品控制类
 * @authorknightx
 * @create2019/5/4
 * @since 1.0.0
 */
@Controller
@RequestMapping("/product")
public class ProduceController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/saveProduct")
    public String saveProduct(Product product) throws Exception {
        productService.savePorduct(product);
        return "redirect:/product/findAll";


    }

    @RequestMapping("/productAdd")
    public String productAddUI(){
        return "productAdd";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }
}
