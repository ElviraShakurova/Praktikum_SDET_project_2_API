package praktikum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class EntityListResponse {
          private List<EntityResponse> entity;
}
