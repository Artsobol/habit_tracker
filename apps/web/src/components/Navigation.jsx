import { Link, useLocation } from "react-router-dom";
import styled from "styled-components";

const navigationList = [
  {
    icon: '/icons/home.svg',
    iconActive: '/icons/home-active.svg',
    location: '/',
    title: 'home'
  },
  {
    icon: '/icons/add.svg',
    iconActive: '',
    title: 'add habit'
  },
  {
    icon: '/icons/calender.svg',
    iconActive: '/icons/calender-active.svg',
    location: '/calender',
    alt: 'calender'
  }
];

const Navigation = () => {
  const currentLocation = useLocation();

  return (
    <NavigationContainer>
      {navigationList.map((item, index) =>
        item.location ? (
          <Link
            key={index}
            to={item.location}
          >
            <img
              src={
                currentLocation.pathname === item.location && item.iconActive ?
                  item.iconActive : item.icon
              }
              alt={item.title}
            />
          </Link>
        ) : (
          <img key={index}
            src={item.icon}
            alt={item.title}
          />
        )
      )}
    </NavigationContainer>
  );
};

const NavigationContainer = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  gap: 50px;
  padding-inline: 63px;
  margin-bottom: 60px;
  margin-top: 54px;
`;

export default Navigation;