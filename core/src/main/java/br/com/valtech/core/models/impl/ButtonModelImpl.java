package br.com.valtech.core.models.impl;

import br.com.valtech.core.models.ButtonModel;
import lombok.Getter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = Resource.class,
    adapters = ButtonModel.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Getter
public class ButtonModelImpl implements ButtonModel {

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String linkURL;

    @ValueMapValue
    private Boolean isOpenOnSameWindow;

    
}
