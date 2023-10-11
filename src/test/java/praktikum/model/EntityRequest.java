package praktikum.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityRequest {

    private String title;

    private boolean verified;

    private Addition addition;

    @JsonProperty("important_numbers")

    private List<Integer> importantNumbers;
}
