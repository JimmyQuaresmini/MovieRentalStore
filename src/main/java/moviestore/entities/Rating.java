package moviestore.entities;

/**
 *
 * @author Jimmy
 */

public enum Rating {
    G("G"), PG("PG"), PG13("PG-13"), R("R"), NC17("NC-17");
    
    private String actualRating;
    
    private Rating(String actualRating) {
        this.actualRating = actualRating;
    }
    
    public String getActualRating() {
        return actualRating;
    }
}
