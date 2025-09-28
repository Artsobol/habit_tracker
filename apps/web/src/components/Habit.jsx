import { useState } from "react";
import styled from "styled-components";

const Habit = (props) => {
  const {
    title,
    info,
    inCalendar = false,
    isDone = false
  } = props;

  const [clicked, setClicked] = useState(isDone);

  const handleClick = () => {
    setClicked((prev) => !prev);
  };

  return (
    <>
    <HabitContainer>
      <div style={{ display: "flex", flexDirection: "column", paddingBlock: "11px",
        paddingInline: "7px"}}>
        <h4>
          {title}
        </h4>
        <p className="p-gray" style={{ paddingTop: "7px" }}>
          {info}
        </p>
      </div>
      {!inCalendar && (
        <Button $clicked={clicked} onClick={handleClick} style={{marginRight:"7px"}}>
          <img
            src={clicked ? "/icons/button-icon-done.svg" : "/icons/button-icon.svg"}
            alt="habit icon"
          />
        </Button>
      )}
      {inCalendar && (
        <CountContainer>
          3
        </CountContainer>
      )}

    </HabitContainer>

    </>
  );
};

const Button = styled.button`
  display: flex;
  align-items: center;
  justify-content: flex-start;
  width: 32px;

  background: transparent;
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
  
  border: 4px solid #ededed;
`;

const CountContainer = styled.span`
  font-weight: 900;
  font-size: 20px;
  margin-right: 3px;
  
  margin-top: auto;
`

export default Habit;
