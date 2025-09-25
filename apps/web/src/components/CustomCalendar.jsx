import { useState, useEffect, useRef } from "react";
import styled from "styled-components";

const weekdays = ["Вс", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб"];
const today = new Date();

const CustomCalendar = () => {
  const [selectedDay, setSelectedDay] = useState(today.getDate());
  const daysInMonth = new Date(today.getFullYear(), today.getMonth() + 1, 0).getDate();
  const days = Array.from({ length: daysInMonth }, (_, i) => i + 1);

  const daysRowRef = useRef(null);
  const selectedDayRef = useRef(null);

  useEffect(() => {
    if (selectedDayRef.current && daysRowRef.current) {
      selectedDayRef.current.scrollIntoView({ behavior: "auto", inline: "start" });
    }
  }, []);

  return (
    <div>
      <CalendarDesign>
        <First />
        <div>
          <Second/>
          <div style={{display: "flex", flexDirection: "row", justifyContent:"flex-end", alignItems: "flex-end"}}>
            <FooterDay>День:</FooterDay>
          </div>
        </div>
        <div>
          <Third />
          <div style={{ display: "flex", flexDirection: "row", alignItems: "end",
          paddingTop: "5px",
          paddingLeft: "5px",
          }}>
            <FooterDayNumber>{selectedDay}</FooterDayNumber>
          <img
          style={{marginBottom: "-4px"}}
            src='/icons/calendar-day-design.svg'
            alt=''
          />
          </div>
        </div>

      </CalendarDesign>
      <CalendarContainer>
        <DaysRow ref={daysRowRef}>
          {days.map((day) => {
            const date = new Date(today.getFullYear(), today.getMonth(), day);
            const weekday = weekdays[date.getDay()];
            const isSelected = selectedDay === day;

            return (
              <DayItem
                key={day}
                ref={isSelected ? selectedDayRef : null}
                selected={isSelected}
                onClick={() => setSelectedDay(day)}
              >
                <DayNumber>{day}</DayNumber>
                <DayWeekday>{weekday}</DayWeekday>
              </DayItem>
            );
          })}
        </DaysRow>
      </CalendarContainer>
    </div>
  );
};

const CalendarContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0;
  padding: 0;
  position: relative;
`;

const DaysRow = styled.div`
  display: flex;
  background-color: var(--color-black);
  gap: 10px;
  height: 59px;
  position: absolute;
  top: 20px;
  z-index: 2;
  margin-bottom: 20px;
  padding-inline: 10px;

  overflow-x: auto;
  width: 100%;
  scrollbar-width: none;
  -ms-overflow-style: none;
  &::-webkit-scrollbar {
    display: none;
  }
`;

const DayItem = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 38px;
  height: 54px;
  gap: 6px;
  cursor: pointer;
  background-color: white;
  font-weight: 400;
  margin-top: ${({ selected }) => (selected ? "5px" : "0")};
  flex-shrink: 0;
  transition: background-color 0.2s, margin-top 0.2s;
`;

const DayNumber = styled.span`
  font-family: var(--font-family);
  font-weight: 500;
  font-size: 16px;
  color: #212020;
`;

const DayWeekday = styled.span`
  font-weight: 400;
  font-size: 12px;
  color: #b6b2b2;
`;

const CalendarDesign = styled.div`
  display: grid;
  grid-template-columns: calc(100% * 161 / 390) calc(100% * 121 / 390) calc(100% * 108 / 390);
  position: absolute;
  left: 0;
  right: 0;
  z-index: 1;
`;

const First = styled.div`
  background-color: var(--color-black);
  height: 93px;
  width: 100%;
`;

const Second = styled.div`
  background-color: var(--color-black);
  height: 93px;
  width: 100%;
  margin-top: 10px;
`;

const Third = styled.div`
  background-color: var(--color-black);
  height: 85px;
  width: 100%;
`;

const FooterDayNumber = styled.div`
  background-color: var(--color-black);
  color: var(--color-white);
  font-family: var(--font-family);
  font-weight: 900;
  font-size: 20px;
  width: 70px;
  height: 33px;
  display: flex;
  align-items: flex-end;
  justify-content: flex-end;
  padding-right: 7px;
`;

const FooterDay = styled.div`
  font-family: var(--font-family);
  font-weight: 500;
  font-size: 10px;
  color: var(--color-black);
  margin-top: 10px;
`;


export default CustomCalendar;
