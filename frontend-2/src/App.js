import './App.module.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeComponent from './components/HomeComponent';
import SubirDataComponent from './components/SubirDataComponent';
import SubirPorcentajeComponent from './components/SubirPorcentajeComponent';
import ProveedorComponent from './components/ProveedorComponent';
import UploadProveedor from './components/UploadProveedor';

function App() {
  return (
    <div>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeComponent />} />
        <Route path= "/subir-data" element={<SubirDataComponent />} />
        <Route path= "/subir-porcentaje" element={<SubirPorcentajeComponent />} />
        <Route path= "/proveedores" element={<ProveedorComponent />} />
        <Route path= "/subir-proveedor" element={<UploadProveedor />} />
      </Routes>
    </BrowserRouter>
  </div>
  );
}

export default App;
