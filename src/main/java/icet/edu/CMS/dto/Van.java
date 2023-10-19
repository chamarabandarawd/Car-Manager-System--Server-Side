package icet.edu.CMS.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Van {

    private Long id;
    private String name;
    private String price;
    private String description;
    private String imgUrl;
    private String type;
    private String hostId;
}
