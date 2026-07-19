import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Components/Home';
import TrainersList from './Components/TrainersList';
import TrainerDetail from './Components/TrainerDetail';
import { trainers } from './Components/TrainersMock';

function App() {
  return (
    <BrowserRouter>
        <div>
            <nav style={{ padding: '10px', backgroundColor: '#f0f0f0' }}>
                <Link to="/" style={{ marginRight: '10px' }}>Home</Link>
                <Link to="/trainers">Trainers List</Link>
            </nav>
            <div style={{ padding: '20px' }}>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/trainers" element={<TrainersList data={trainers} />} />
                    <Route path="/trainer/:id" element={<TrainerDetail />} />
                </Routes>
            </div>
        </div>
    </BrowserRouter>
  );
}

export default App;
