package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Category;
import moviestore.repositories.CategoryRepository;
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
    private CategoryRepository categoryRepository;
    
    @GetMapping("/all") //TODO: fix recursive error here
    public @ResponseBody Iterable<Category> getAllCategories() { 
        return categoryRepository.findAll();
    }
    
    @GetMapping("/add")
    public @ResponseBody String addCategory(@RequestParam int id, @RequestParam String name,
            @RequestParam LocalDateTime updated) {
        Category c = new Category();
        c.setCategory_id(id);
        c.setName(name);
        c.setLast_update(updated);
        categoryRepository.save(c);
        return "Saved category";
    }
    
}
