import './App.module.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeComponent from './components/HomeComponent.jsx';
import SubirDataComponent from './components/SubirDataComponent.jsx';
function App() {
  return (
    <div>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeComponent />} />
        <Route path= "/subir-archivo" element={<SubirDataComponent />} />
      </Routes>
    </BrowserRouter>
  </div>
  );
}

export default App;
