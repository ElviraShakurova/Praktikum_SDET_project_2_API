package praktikum.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityResponse {
    private int id;
    private String title;
    private boolean verified;
    private Addition addition;
    @JsonProperty("important_numbers")
    private List<Integer> importantNumbers;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Addition {
        private int id;
        @JsonProperty("additional_info")
        private String additionalInfo;
        @JsonProperty("additional_number")
        private int additionalNumber;
    }
}
