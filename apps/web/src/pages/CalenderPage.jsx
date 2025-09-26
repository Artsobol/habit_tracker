import { useState } from "react";
import Calendar from "react-calendar";
import styled from "styled-components";

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

  function getTileClass({ date: tileDate, view }) {
    if (view === "month") {
      const today = new Date();
      today.setHours(0, 0, 0, 0);
      if (tileDate < today) {
        return "past-day-black";
      }
      if (tileDate > today) {
        return "past-day-gray";
      }
    }
    return null;
  }

  return (
    <CalendarContainer>
      <CalendarHeader>
        <h2 className="h3" style={{ paddingLeft: "48px" }}>Календарь</h2>
        <MonthButton>{currentMonth}</MonthButton>
      </CalendarHeader>
      <StyledCalendarWrapper>
        <Calendar
          onChange={setDate}
          value={date}
          navigationLabel={null}
          nextLabel={null}
          next2Label={null}
          prevLabel={null}
          prev2Label={null}
          tileClassName={getTileClass}
        />
      </StyledCalendarWrapper>
    </CalendarContainer>
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

const StyledCalendarWrapper = styled.div`
  .react-calendar {
    border: none;
    font-family: inherit;
  }

  .react-calendar__navigation {
    display: none;
  }

  .react-calendar__tile {
    width: 36px;
    height: 44px;
    background: #ededed;
  }

  .react-calendar__month-view__days {
    display: grid !important;
    grid-template-columns: repeat(7, 1fr);
    column-gap: 14px;
    row-gap: 10px;
    font-weight: 500;
    font-size: 16px;
    color: var(--color-black);
  }

  .past-day-gray {
    background-image: url("/icons/calendar-day-gray.svg");
  }

  .past-day-black {
    background-image: url("/icons/calendar-day-black.svg");
  }
  
  .react-calendar__month-view__weekdays {
    display: grid !important;
    grid-template-columns: repeat(7, 1fr);
    gap: 14px;
    text-align: center;
    margin-bottom: 11px;
  }

  .react-calendar__month-view__weekdays abbr {
    text-transform: capitalize;
    text-decoration: none;
    font-weight: 400;
    font-size: 12px;
    color: #b6b2b2;
    display: inline-block;
    width: 100%;
  }
`;

export default CalendarPage;
