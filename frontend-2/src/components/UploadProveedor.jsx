import React, { useState } from "react";
import NavbarComponent3 from "./NavbarComponent3";
import styled from "styled-components";
import ProveedorService from "../services/ProveedorService";
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import swal from 'sweetalert';

export default function JustificativoComponent(props){

    const initialState = {
        rut: "",
        fecha: "",
        codigo: "",
        nombre: "",
        categoria: ""
    };

    const [input, setInput] = useState(initialState);
    
    const changeCodigoHandler = event => {
        setInput({ ...input, codigo: event.target.value });
        console.log(input.codigo);
    };

    const changeNombreHandler = event => {
        setInput({ ...input, nombre: event.target.value });
        console.log(input.nombre);
    };

    const changeCategoriaHandler = event => {
        setInput({ ...input, categoria: event.target.value });
        console.log(input.categoria);
    };
    
    //ddddddddddddddddddddd
    const changeRutHandler = event => {
        setInput({ ...input, rut: event.target.value });
        console.log(input.rut);
    };
    const changeFechaHandler = event => {
        setInput({ ...input, fecha: event.target.value });
        console.log(input.fecha);
    };


    const ingresarProveedor = e => {
        e.preventDefault();
        swal({
            title: "¿Está seguro de que deseas agregar el nuevo proveedor?",
            text: "Una vez enviado, no podrá ser modificado.",
            icon: "warning",
            buttons: ["Cancelar", "Enviar"],
            dangerMode: true
        }).then(respuesta=>{
            if(respuesta){
                swal("Proveedor agregado correctamente!", {icon: "success", timer: "3000"});
                let proveedor = { codigo: input.codigo, nombre: input.nombre, categoria: input.categoria};
                console.log(input.codigo)
                console.log(input.nombre)
                console.log(input.categoria)
                console.log("proveedor => " + JSON.stringify(proveedor));
                ProveedorService.ingresarProveedor(proveedor).then(
                    (res) => {
                    }
                  );
                }
            else{
                swal({text: "Proveedor no agregado.", icon: "error"});
            }
        });
    };
    

    return(
            
            <Styles>
            <div className="home">
                <NavbarComponent3 />
                    <div className="mainclass">
                        <div className="form1">
                            <h1 className="text-center"><b>Proveedor</b></h1>
                            <div className="formcontainer">
                                <hr></hr>
                                <div className="container">
                                    <Form> 
                                        <Form.Group className="mb-3" controlId="codigo" value = {input.codigo} onChange={changeCodigoHandler}>
                                            <Form.Label>Código de Proveedor</Form.Label>
                                            <Form.Control type="rut" placeholder="" />
                                        </Form.Group>

                                        <Form.Group className="mb-3" controlId="nombre" value = {input.nombre} onChange={changeNombreHandler}>
                                            <Form.Label>Nombre de Proveedor</Form.Label>
                                            <Form.Control type="fecha" placeholder="" />
                                        </Form.Group>

                                        <Form.Group className="mb-3" controlId="categoria" value = {input.categoria} onChange={changeCategoriaHandler}>
                                            <Form.Label>Rut del empleado</Form.Label>
                                            <Form.Control type="categoria" placeholder="A-B-C-D" />
                                        </Form.Group>
                                    </Form>
                                </div>
                                <Button className="boton" onClick={ingresarProveedor}>Registrar Proveedor</Button>
                            </div>
                        </div>
                    </div>
                
            </div>
            </Styles>
        )
    }


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

.home{
    background-color: #006992;
    margin: 0;
    padding: 0;
}

.mainclass{
    margin-top: 20px;
    display: flex;
    justify-content: center;
    font-family: Roboto, Arial, sans-serif;
    font-size: 15px;
}

.form1{
    border: 9px solid #CED0CE;
    background-color: #DADDD8;
    width: 50%;
    padding: 36px;
}

input[type=rut], input[type=fecha] {
    width: 100%;
    padding: 16px 8px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

Button {
    background-color: #42bfbb;
    color: white;
    padding: 14px 0;
    margin: 10px 0;
    border: none;
    cursor: grabbing;
    width: 100%;
}

Button:hover {
    opacity: 0.8;
}

.formcontainer {
    text-align: left;
    margin: 24px 100px 9px;
}

.container {
    padding: 24px 0;
    text-align:left;
}

span.psw {
    float: right;
    padding-top: 0;
    padding-right: 15px;
}
`