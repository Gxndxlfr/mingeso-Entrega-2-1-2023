import React, { Component } from "react";
import styled from "styled-components";
import { createGlobalStyle } from 'styled-components'


export default function Home(){
    
    return (
        <div>
            <GlobalStyle />
            <HomeStyle>
                <h1 className="text-center"> <b>MilkStgo</b></h1>
                <div class="box-area">
                    <div class="single-box">
                        <a href="/subir-data">
                            <div class="img-area">
                            </div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Cargar Acopio</strong></span>
                        </div>
                    </div>
                    <div class="single-box">
                        <a href="/proveedores">
                            <div class="img-area">
                            </div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Ver Proveedores</strong></span>
                        </div>
                    </div>
                    <div class="single-box">
                        <a href="/subir-porcentaje">
                            <div class="img-area"></div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Cargar Porcentajes</strong></span>
                        </div>
                    </div>
                    <div class="single-box">
                        <a href="/planilla-sueldos">
                            <div class="img-area"></div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Planilla de sueldos</strong></span>
                            <p></p>
                        </div>
                    </div>
                    
                    
                </div>
            </HomeStyle>
        </div>
    );
}



const GlobalStyle = createGlobalStyle`
    body { 
        background-color: #262626;
`
const HomeStyle = styled.nav`

.text-center {
    text-align: center;
    justify-content: center;
    padding-top: 8px;
    color: #fff;
}

.box-area{
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
}

.single-box{
    position: relative;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 400px;
    height: auto;
    border-radius: 4px;
    background-color: #fff;
    text-align: center;
    margin: 20px;
    padding: 20px;
    transition: .3s
}

.img-area{
    display: flex;
    justify-content: center;
    align-items: center;
    width: 80px;
    height: 80px;
    border: 6px solid #ddd;
    border-radius: 50%;
    padding: 20px;
    -webkit-background-size: cover;
    background-size: cover;
    background-position: center center;
}

.single-box:nth-child(1) .img-area{
    background-image: url(https://img.freepik.com/vector-premium/chat-archivo-documento-texto-comentando-o-editando-documentos-linea-ilustracion-dibujos-animados-plana_101884-838.jpg)
}

.header-text{
    font-size: 24px;
    font-weight: 500;
    line-height: 48px;
}
.img-text p{
    font-size: 15px;
    font-weight: 400;
    line-height: 30px;
}
.single-box:hover{
    background: #e84393;
    color: #fff;}

.single-box:nth-child(2) .img-area{
    background-image: url(http://static1.squarespace.com/static/55c7a3e2e4b0fa365689d8aa/55e0aceae4b0643202e59629/55e322ade4b077beb0266329/1590769127854/?format=1500w)
}
.single-box:nth-child(3) .img-area{
    background-image: url(https://img.freepik.com/foto-gratis/promocion-signo-porcentaje-mano-o-icono-venta-descuento-o-simbolo-representacion-3d-fondo-purpura_56104-1497.jpg?w=900&t=st=1680460810~exp=1680461410~hmac=796ad9976321adfb3a08f169a6b7a68d175e9c871140eebb46d138e0de4e4872)
}
.single-box:nth-child(4) .img-area{
    background-image: url(https://cdn-icons-png.flaticon.com/512/299/299396.png?w=826&t=st=1680490305~exp=1680490905~hmac=af5768d90fa501b4e81e046efec0a16aa3761acc913f44b8268699597e211c06)
}
.single-box:nth-child(5) .img-area{
    background-image: url(https://media.istockphoto.com/vectors/agreement-contract-and-offer-color-line-icon-proposal-linear-vector-vector-id1271477227?k=20&m=1271477227&s=612x612&w=0&h=XOSF2ISnfGJZ7bb-fU7rRdDJzTKehDmOF9kcJ5gIEmA=)
}
.login-box{
    cursor: pointer;
}
`