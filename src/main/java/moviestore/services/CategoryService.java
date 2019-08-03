package moviestore.services;

import java.time.LocalDateTime;
import moviestore.entities.Category;
import moviestore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jimmy
 */

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public void saveCategory(int id, String name, LocalDateTime updated) {
        Category c = new Category();
        c.setCategory_id(id);
        c.setName(name);
        c.setLast_update(updated);
        categoryRepository.save(c);
    }
}
