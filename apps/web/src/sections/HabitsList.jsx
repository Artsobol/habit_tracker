import styled from "styled-components";
import Habit from "../components/Habit";

const HabitsList = ({ list }) => {
  return (
    <Container>
      {list.map((item, index) => (
        <Habit
          key={index}
          title={item.title}
          info={item.info}
          isDone={item.isDone}
        />
      ))}
    </Container>
  );
};

const Container = styled.div`
  display: flex;
  flex-direction: column;
  gap: 8px;
`;

export default HabitsList;