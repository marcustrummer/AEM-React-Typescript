import styled from "styled-components";

interface RowContentProps {
  swapColumns: boolean;
}
export const Container = styled.div`
    display: flex;
    flex-direction: column;
    gap: 11px;
    align-items: center;
`;
export const RowContent = styled.div<RowContentProps>`
  display: flex;
  flex-direction: ${props => props.swapColumns ? 'row-reverse' : 'row'};
  gap: 11px;
  align-items: center;

  @media (max-width: 768px) {
    flex-direction: ${props => props.swapColumns ? 'column-reverse' : 'column'};

  }

  img {
    width: 500px;
    border-radius: 2%;
  }

  button{
    align-items: center;
    -webkit-appearance: none;
    border: none;
    cursor: pointer;
    display: inline-flex;
    font-size: .875rem;
    font-weight: 500;
    margin-bottom: .625rem;
    outline: none;
    overflow: hidden;
    padding: 1rem 2rem;
    position: relative;
    text-transform: uppercase;
    vertical-align: middle;
    white-space: nowrap;
    border-radius: 2%;
  }

`;
