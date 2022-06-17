package models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecondKeyDataLombok {
    @JsonProperty("id")
    private Integer idLombok;
    @JsonProperty("email")
    private String emailLombok;
    @JsonProperty("first_name")
    private String firstNameLombok;
    @JsonProperty("last_name")
    private String lastNameLombok;
    @JsonProperty("avatar")
    private String avatarLombok;
}
