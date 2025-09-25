import { useState } from "react";
import styled from "styled-components";

const Habit = (props) => {
  const { title, info, notifications, isDone = false } = props;

  const [clicked, setClicked] = useState(isDone);

  const handleClick = () => {
    setClicked((prev) => !prev);
  };

  return (
    <HabitContainer>
      <div style={{ display: "flex", flexDirection: "column" }}>
        <h4>
          {title}
        </h4>
        <HabitInfo>
          {info}
        </HabitInfo>
      </div>
      <Button $clicked={clicked} onClick={handleClick}>
        <img
          src={clicked ? "/icons/button-icon-done.svg" : "/icons/button-icon.svg"}
          alt="habit icon"
        />
      </Button>
    </HabitContainer>
  );
};

const Button = styled.button`
  display: flex;
  align-items: center;
  justify-content: flex-start;
  width: 32px;

  background: "transparent";
  cursor: pointer;

  img {
    width: auto;
    height: 28px;
  }
`;

const HabitContainer = styled.div`
  min-width: 200px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding-block: 11px;
  padding-inline: 7px;
  border: 4px solid #ededed;
`;

const HabitInfo = styled.div`
  font-family: var(--font-family);
  font-weight: 400;
  font-size: 10px;
  color: var(--color-gray-1);
  padding-top: 7px;
`;

export default Habit;
