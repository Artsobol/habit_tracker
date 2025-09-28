import styled from "styled-components";

const ProfilePage = () => {
  return (
    <>
      <ProfileContainer>
        <button>
          <img
            src="/icons/settings.svg"
          />
        </button>
        <UserContainer>
          <h3 style={{ paddingTop: "7px" }}>
            Username
          </h3>
          <img
            src="/icons/user.svg"
          />
          <Email className="h3">
            somemail@.com
          </Email>
        </UserContainer>
        <button>
          <img
            src="/icons/log-out.svg"
          />
        </button>
      </ProfileContainer>
    </>
  );
};

const ProfileContainer = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  margin: 23px;
`;

const UserContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  max-width: 150px;
  gap: 9px;
`;

const Email = styled.p`
  margin-top: 14px;
  font-size: 16px;
  text-align: center;
  overflow-wrap: anywhere; 
`;


export default ProfilePage;