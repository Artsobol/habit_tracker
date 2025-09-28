import styled from "styled-components";
import HabitsList from "../sections/HabitsList";
import list from '../constants/HABITS_DATA.json';
import DailyProgress from "../components/DailyProgress";
import CalendarRow from "../components/CalendarRow.jsx";

const HomePage = () => {
  return (
    <>
      <div style={{ paddingBlock: "14px", marginInline: "14px", marginBottom: "14px" }}>
        <User href="/profile">
          <img
            src="/icons/user.svg"
            alt="user"
            width="55px"
            height="32px"
          />
          <h3>
            Username
          </h3>
        </User>
      </div>
      <div>
        <CalendarRow />
      </div>

      <div style={{ marginInline: "31px", marginBottom: "25px", marginTop: "143px" }}>
        <DailyProgress />
      </div>
      <div style={{ marginInline: "23px" }}>
        <div style={{
          display: "flex",
          flexDirection: "row",
          justifyContent: "space-between",
          paddingBottom: "11px"
        }}>
          <h2 className="h4" style={{ paddingLeft: "10px" }}>
            Привычки
          </h2>
          <SeeAllLink
            style={{ paddingRight: "12px" }}
            href="/calendar"
          >
            Смотреть все
          </SeeAllLink>
        </div>

        <HabitsList list={list}/>
      </div>
    </>
  );
};

const SeeAllLink = styled.a`
  font-weight: 500;
  font-size: 10px;
  color: var(--color-gray-1);
`;

const User = styled.a`
  display: flex;
  flex-direction: row;
  align-items: center;
  gap: 5px;
`;

export default HomePage;
