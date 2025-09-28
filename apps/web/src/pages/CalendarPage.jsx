import {useState} from "react";
import styled from "styled-components";
import CalendarFull from "../components/CalendarFull.jsx";
import list from '../constants/HABITS_DATA.json';
import HabitsList from "../sections/HabitsList.jsx";

const CalendarPage = () => {
  const [date, setDate] = useState(new Date());

  const currentMonth = capitalize(
    date.toLocaleDateString("ru-RU", {
      month: "long",
    })
  );

  function capitalize(str) {
    if (!str) return "";
    return str.charAt(0).toUpperCase() + str.slice(1);
  }

  return (
    <>
      <CalendarContainer>
        <CalendarHeader>
          <h2 className="h3" style={{paddingLeft: "48px"}}>Календарь</h2>
          <MonthButton>{currentMonth}</MonthButton>
        </CalendarHeader>
        <CalendarFull
          setDate={setDate}
          date={date}
        />
      </CalendarContainer>
      <HabitsContainer>
        <h2 className="h3" style={{paddingLeft: "54px", marginBottom: "22px"}}>
          Активные привычки
        </h2>
        <HabitsList list={list} inCalendar={true}/>
      </HabitsContainer>
    </>
  );
};

const MonthButton = styled.button`
  font-weight: 500;
  font-size: 16px;
  text-align: right;
  color: #cccaca;
`;

const CalendarContainer = styled.div`
  margin-top: 23px;
  margin-bottom: 34px;
  padding-inline: 26px;
`;

const CalendarHeader = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 12px;
`;

const HabitsContainer = styled.div`
  padding-inline: 20px;
  margin-bottom: 72px;
`

export default CalendarPage;
