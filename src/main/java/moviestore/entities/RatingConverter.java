package moviestore.entities;

import java.util.stream.Stream;
import javax.persistence.Converter;
import javax.persistence.AttributeConverter;

/**
 * Converts Rating enums to and from Database
 * 
 * @author Jimmy
 */

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        if (rating == null) {
            return null;
        }
        return rating.getActualRating();
    }
    
    @Override
    public Rating convertToEntityAttribute(String actualRating) {
        if (actualRating == null) {
            return null;
        }
        
        return Stream.of(Rating.values())
                .filter(r -> r.getActualRating().equals(actualRating))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
