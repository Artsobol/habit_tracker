import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home.jsx";
import CalenderPage from "./pages/CalendarPage.jsx";
import Profile from "./pages/Profile.jsx";
import Navigation from "./components/Navigation.jsx";
import './styles/index.js';

function App() {
  return (
    <>
      <Router>
        <main>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/calender" element={<CalenderPage />} />
          </Routes>
        </main>
        <Navigation/>
      </Router>
    </>
  );
}

export default App;
