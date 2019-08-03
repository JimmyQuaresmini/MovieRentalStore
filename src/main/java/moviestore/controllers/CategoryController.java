package moviestore.controllers;

import java.time.LocalDateTime;
import moviestore.entities.Category;
import moviestore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jimmy
 */

@Controller
@RequestMapping("/category")
public class CategoryController {    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/all") 
    public @ResponseBody Iterable<Category> getAllCategories() { 
        return categoryService.getAllCategories();
    }
    
    @GetMapping("/add")
    public @ResponseBody String addCategory(@RequestParam int id, @RequestParam String name,
            @RequestParam LocalDateTime updated) {        
        categoryService.saveCategory(id, name, updated);
        return "Saved category";
    }
    
}
