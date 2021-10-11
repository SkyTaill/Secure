package ru.gb.ProductRep;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.conf.User;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")

public class ProductController {
    private final User user=new User();
    private final String admin=user.getAdminRights();
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseBody
    public List<Product> list() {
        return productService.findAll();

    }

    @GetMapping("{id}")
    @ResponseBody
    public Optional<Product> findById(@PathVariable long id) {
        return productService.findById(id);
    }


  //  @Secured({"ADMIN"})
    @GetMapping("/admin/user")
    @ResponseBody
    public User findUser() {

        return user;
    }

    //@Secured({"/admin/add"})
    @PostMapping("/admin/add")
    public Product add(@RequestBody Product product) {
        System.out.println(product);
        Product productLocal = productService.save(product);
        return productLocal;
    }


}
