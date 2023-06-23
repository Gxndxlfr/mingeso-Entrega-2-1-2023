import React, { Component } from "react";
import NavbarComponent from "./NavbarComponent";
import styled from "styled-components";

class PlanillaComponent extends Component{
    constructor(props) {
        super(props);
        this.state = {
          planilla: [],
        };
    }

    componentDidMount() {
        fetch("http://localhost:8080/planilla")
          .then((response) => response.json())
          .then((data) => this.setState({ planilla: data }));
      }

      render(){
        return(
            <div className="home">
                <NavbarComponent />
                <Styles>
                    <h1 className="text-center"> <b>Reporte de Planilla de Pagos ($CLP)</b></h1>
                    <div className="f">
                        <table border="1" class="content-table">
                            <thead>

                                <tr><th width="10%">Quincena</th>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                    <th>Total KLS Leche</th>
                                    <th>Nro. Días que envio leche</th>
                                    <th>Promedio diario KLS leche</th>
                                    <th>%Variación Leche</th>
                                    <th>%Grasa</th>
                                    <th>%Variación Grasa</th>
                                    <th>%Solidos Totales</th>
                                    <th>%Variación ST</th>
                                    <th>Pago Leche</th>
                                    <th>Pago Grasa</th>
                                    <th>Pago Solidos Totales</th>
                                    <th>Bonificación por frecuencia</th>
                                    <th>Dcto. Variación Leche</th>
                                    <th>Dcto. Variación Grasa</th>
                                    <th>Dcto. Variación ST</th>
                                    <th>Pago Total</th>
                                    <th>Monto Retención</th>
                                    <th>Monto Final</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.planilla.map((planilla) => (
                                    <tr key={planilla.ID}>
                                        <td>{planilla.quincena}</td>
                                        <td>{planilla.codigo}</td>
                                        <td>{planilla.nombre}</td>
                                        <td>{planilla.klsLeche}</td>
                                        <td>{planilla.cantDias}</td>
                                        <td>{planilla.promedioKlsLeche}</td>
                                        <td>{planilla.varLeche}</td>
                                        <td>{planilla.Grasa}</td>
                                        <td>{planilla.varGrasa}</td>
                                        <td>{planilla.St}</td>
                                        <td>{planilla.varSt}</td>
                                        <td>{planilla.pagoLeche}</td>
                                        <td>{planilla.pagoGrasa}</td>
                                        <td>{planilla.pagoSt}</td>
                                        <td>{planilla.bonificacionFrecuencia}</td>
                                        <td>{planilla.descuentoLeche}</td>
                                        <td>{planilla.descuentoGrasa}</td>
                                        <td>{planilla.descuentoSt}</td>
                                        <td>{planilla.pagoTotal}</td>
                                        <td>{planilla.retencion}</td>
                                        <td>{planilla.pagoFinal}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </Styles>
            </div>
        )
    }
}

export default PlanillaComponent;

const Styles = styled.div`


.text-center {
    text-align: center;
    justify-content: center;
    padding-top: 8px;
    font-family: "Arial Black", Gadget, sans-serif;
    font-size: 30px;
    letter-spacing: 0px;
    word-spacing: 2px;
    color: #000000;
    font-weight: 700;
    text-decoration: none solid rgb(68, 68, 68);
    font-style: normal;
    font-variant: normal;
    text-transform: uppercase;
}

.f{
    justify-content: center;
    align-items: center;
    display: flex;
}
*{
    font-family: sans-serif;
    box-sizing: content-box;
    margin: 0;
    padding: 0;
}
.content-table{
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.8em;
    min-width: 200px;
    border-radius: 5px 5px 0 0;
    overflow: hidden;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
    margin-left: 4%;
    margin-right: 4%;
}
.content-table thead tr{
    background-color: #009879;
    color: #ffffff;
    text-align: center;
    font-weight: bold;
}
.content-table th,
.content-table td{
    padding: 12px 15px;
    text-align: center;
}
.content-table tbody tr{
    border-bottom: 1px solid #dddddd;
}
.content-table tbody tr:nth-of-type(even){
    background-color: #f3f3f3;
}
.content-table tbody tr:last-of-type{
    border-bottom: 2px solid #009879;
}
.content-table tbody tr.active-row{
    font-weight: bold;
    color: #009879;
}
`