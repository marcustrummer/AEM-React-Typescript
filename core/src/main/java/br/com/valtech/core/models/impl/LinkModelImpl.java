package br.com.valtech.core.models.impl;

import br.com.valtech.core.models.LinkModel;
import lombok.Getter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = Resource.class,
        adapters = LinkModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Getter
public class LinkModelImpl implements LinkModel {

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String linkURL;

    @ValueMapValue
    private String linkURLDataContext;

    @ValueMapValue
    private Boolean isOpenOnNewWindow;

    @ValueMapValue
    private Boolean hasModal;

}
