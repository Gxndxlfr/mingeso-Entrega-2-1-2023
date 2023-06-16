import './App.module.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeComponent from './components/HomeComponent';
import SubirDataComponent from './components/SubirDataComponent';
import SubirPorcentajeComponent from './components/SubirPorcentajeComponent';
function App() {
  return (
    <div>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeComponent />} />
        <Route path= "/subir-data" element={<SubirDataComponent />} />
        <Route path= "/subir-porcentaje" element={<SubirPorcentajeComponent />} />
      </Routes>
    </BrowserRouter>
  </div>
  );
}

export default App;
