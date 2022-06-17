package models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecondKeySupportLombok {
    @JsonProperty("url")
    private String urlLombok;
    @JsonProperty("text")
    private String textLombok;

}
