<%@ page contentType="text/html" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Informacion Registro</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <section>
    <h2>Info de Datos Id  ${d.getId()} </h2>
    <p>Nombre: ${d.getNombre()}</p>
    <p>Apellido: ${d.getApellido()}</p>
    <p>Contacto: ${d.getContacto()}</p>
    </section>
</body>
</html>