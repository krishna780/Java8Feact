package Application.FiltersJson;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Employee {
    int id;
    String name;
    String salary;
    String dept;
}
