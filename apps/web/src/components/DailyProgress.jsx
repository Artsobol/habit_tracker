import styled from "styled-components";

const DailyProgress = () => {
  return (
    <DailyProgressContainer>
      <DailyProgressIconContainer>
        <img
          src="/icons/daily-progress-zaglushka.svg"
          alt='daily progress'
        />
        <p className="h4">
          25%
        </p>
      </DailyProgressIconContainer>
      <DailyProgressTextContainer>
        <h3 className="h4">
          Дневной прогресс!
        </h3>
        <p className="p-gray">
          1 из 5 выполнено
        </p>
      </DailyProgressTextContainer>
    </DailyProgressContainer>
  );
};

const DailyProgressContainer = styled.div`
  max-width: 128px;
  display: grid;
  grid-template-columns: 28px 95px;
  gap: 10px;
`

const DailyProgressIconContainer = styled.div`
  max-width: 28px;
  display: flex;
  flex-direction: column;
  align-items: start;
  gap: 3px;
`

const DailyProgressTextContainer = styled.div`
  display: flex;
  flex-direction: column;
  gap: 7px;
`


export default DailyProgress;

