package br.com.valtech.core.models;

public interface LinkModel {

    String getText();
    String getLinkURL();
    String getLinkURLDataContext();

    Boolean getIsOpenOnNewWindow();

    Boolean getHasModal();

}
