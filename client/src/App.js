import './App.css';
import Frontpage from "./pages/Frontpage";
import Students from "./pages/Students";
import Courses from "./pages/Courses";
import {BrowserRouter as Router, Route, Routes, Link} from "react-router-dom";

function App() {
    return (
    <Router>
        <div>
            <h1>Opiskelijatietojärjestelmä</h1>
            <nav>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/students">Students</Link>
                    </li>
                    <li>
                        <Link to="/courses">Courses</Link>
                    </li>
                </ul>
            </nav>
            <Routes>
                <Route path="/" element={<Frontpage/>}/>
                <Route path="/students" element={<Students/>}/>
                <Route path="/courses" element={<Courses/>}/>
            </Routes>
        </div>
    </Router>
)
    ;
}

export default App;