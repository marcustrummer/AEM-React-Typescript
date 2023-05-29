package br.com.valtech.core.models.impl;

import br.com.valtech.core.models.ButtonModel;
import br.com.valtech.core.models.WelcomeHomeModel;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(AemContextExtension.class)
class WelcomeHomeModelImplTest {
    private final AemContext ctx = new AemContext();

    private static final String ROOT = "/content";
    private static final String TEST_BASE = ROOT + "/welcomehome";

    @BeforeEach
    void setUp() throws Exception {
        ctx.addModelsForClasses(WelcomeHomeModelImpl.class);
        ctx.load().json("/br/com/valtech/core/models/impl/WelcomeHomeModelImplTest.json", ROOT);
    }

    @Test
    public void testGetTitle() {
        final String expected = "<h2>Bem vindo a Valtech_</h2>";

        WelcomeHomeModel welcomehome = getWelcomeHomeModelUnderTest();

        String actual = welcomehome.getTitle();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetDescription() {
        final String expected = "<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>";

        WelcomeHomeModel welcomehome = getWelcomeHomeModelUnderTest();

        String actual = welcomehome.getDescription();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetButtonCTA() {

        WelcomeHomeModel welcomehome = getWelcomeHomeModelUnderTest();

        final String textExpected = "Texto do botao CTA";

        final String linkURLExpected = "https://www.valtech.com/pt-br/";

        final boolean isOpenOnSameWindow = true;

        ButtonModel buttonCTA = welcomehome.getButtonCTA();

        assertEquals(textExpected, buttonCTA.getText());
        assertEquals(linkURLExpected, buttonCTA.getLinkURL());
        assertEquals(isOpenOnSameWindow, buttonCTA.getIsOpenOnSameWindow());
    }

    @Test
    public void testGetSwapColumns() {
        final boolean expected = true;

        WelcomeHomeModel welcomehome = getWelcomeHomeModelUnderTest();

        boolean actual = welcomehome.getSwapColumns();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetImgReference() {
        final String expected = "/content/dam/valtech/Purple Triangle 0.png";

        WelcomeHomeModel welcomehome = getWelcomeHomeModelUnderTest();

        String actual = welcomehome.getImgReference();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetImgAlt() {
        final String expected = "Imagem gerada pela IA gencraft com o seguinte prompt 'desenhos geometricos em escala 500x500'";

        WelcomeHomeModel welcomehome = getWelcomeHomeModelUnderTest();

        String actual = welcomehome.getImgAlt();

        assertEquals(expected, actual);
    }

    @Test
    void testGetResourceType() {

        final String expected = "valtech/components/welcomehome";

        WelcomeHomeModel welcomehome = getWelcomeHomeModelUnderTest();

        String actual = welcomehome.getExportedType();

        assertEquals(expected, actual);
    }

    private WelcomeHomeModel getWelcomeHomeModelUnderTest() {
        ctx.currentResource(TEST_BASE);
        return ctx.request().adaptTo(WelcomeHomeModel.class);
    }
}