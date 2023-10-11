package praktikum.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Addition {
         @JsonProperty("additional_info")
         private String additionalInfo;
         @JsonProperty("additional_number")
         private int additionalNumber;
}

