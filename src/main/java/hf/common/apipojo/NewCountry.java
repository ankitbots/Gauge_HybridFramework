package hf.common.apipojo;

/**
 * Created by AnkitNigam on 7/29/2018.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "alpha2_code",
        "alpha3_code"
})
@Data
public class NewCountry {

    @JsonProperty("name")
    private String name;
    @JsonProperty("alpha2_code")
    private String alpha2Code;
    @JsonProperty("alpha3_code")
    private String alpha3Code;
}