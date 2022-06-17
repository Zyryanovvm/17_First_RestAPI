package models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FirstKeyLombok {
    @JsonProperty("data")
    private SecondKeyDataLombok dataLombok;
    @JsonProperty("support")
    private SecondKeySupportLombok supportLombok;
}
