import React from "react";
import Text from "../Text/Text";
import * as S from "./WelcomeHome.styled";

export const WelcomeHomeConfig = {
  emptyLabel: "boas ivnsda",
  isEmpty: () => false,
  resourceType: "valtech/components/welcomehome",
};

type Button = {
  text: string;
  linkURL: string;
  isOpenOnSameWindow: boolean;
};

type WelcomeHomeProps = {
  title: string;
  description: string;
  imgReference: string;
  imgAlt: string;
  buttonCTA: Button;
  swapColumns: boolean;
};

export const WelcomeHome = ({
  title = "<h2>Bem vindo a Valtech_</h2>",
  description = "<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>",
  imgReference = "https://placehold.co/500x500",
  imgAlt = "Imagem gerada pela IA gencraft com o seguinte prompt 'desenhos geometricos em escala 500x500'",
  buttonCTA = {
    text: "Texto do botao CTA",
    linkURL: "#href",
    isOpenOnSameWindow: false,
  },
  swapColumns = false,
  ...props
}: WelcomeHomeProps) => {
  console.log(props);


  const openLink = (link: string) => {
    window.open(link, buttonCTA.isOpenOnSameWindow === false ? '_blank' : '_self');
  };
  return (
    <>
      <S.Container>
        <Text text={title} richText={true}></Text>

        <S.RowContent swapColumns={swapColumns}>
          <div>
            <Text text={description} richText={true}></Text>
            <button onClick={() => openLink(buttonCTA.linkURL)}>
              {buttonCTA.text}
            </button>
          </div>

          <img src={imgReference} alt={imgAlt} onClick={() => openLink(buttonCTA.linkURL)} />

        </S.RowContent>
      </S.Container>
    </>
  );
};
