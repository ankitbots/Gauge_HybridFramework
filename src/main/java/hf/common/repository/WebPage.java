package hf.common.repository;

/**
 * Created by AnkitNigam on 07/27/2018.
 */

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name="page")
@XmlAccessorType(XmlAccessType.FIELD)
public class WebPage {
    @XmlElement(name = "uiElements")
    private WebPageElement webPageElement;
    @XmlAttribute(name = "name")
    private String pageName;
}
