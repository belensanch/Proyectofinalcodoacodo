package com.mycompany.web.models;

import java.io.Serializable;

public class Datos implements Serializable {
        private int Id;
        private String Nombre,Apellido,Contacto;

        public Datos(){
    
        }
    
        public int getId(){
            return Id;
        }
    
        public void setId(int nuevoId){
            this.Id = nuevoId;
        }
    
        /**
         * @return
         */
        public String getNombre(){
            return Nombre;
        }
    
        public void setNombre(String nuevoNombre){
            this.Nombre = nuevoNombre;
        }
    
        public String getApellido(){
            return Apellido;
        }
    
        public void setApellido(String nuevoApellido){
            this.Apellido = nuevoApellido;
        }
    
        public String getContacto(){
            return Contacto;
        }
    
        public void setContacto(String nuevoContacto){
            this.Contacto = nuevoContacto;
        }
    }

