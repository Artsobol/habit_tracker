import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage.jsx";
import CalenderPage from "./pages/CalendarPage.jsx";
import ProfilePage from "./pages/ProfilePage.jsx";
import Navigation from "./components/Navigation.jsx";
import './styles/index.js';
import CalendarPage from "./pages/CalendarPage.jsx";

function App() {
  return (
    <>
      <Router>
        <main>
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/profile" element={<ProfilePage />} />
            <Route path="/calendar" element={<CalendarPage />} />
          </Routes>
        </main>
        <Navigation/>
      </Router>
    </>
  );
}

export default App;
