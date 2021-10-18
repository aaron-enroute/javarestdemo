Java REST Demo 

Este proyecto pretende abarcar los conceptos básicos de un proyecto de WebServices sobre una plataforma Java, utilizando herramientas 
(Springboot, Lombok, Mockito) que simplifican y reducen la cantidad de código utilizado, por tanto, haciendolo legible y más fácil de 
mantener. Se realizan operaciones de extracción y modificación via REST a una base de datos MySQL.  
 
Los métodos y su funcionalidad se describen a continuación:

	retrieveAllUsers: Obtiene una lista de los empleados contratados después del 01-01-1990.
	retrieveUser: Obtiene un solo empleado a traves de su ID, enviado como parámetro en la URL.
	updateUser: modifica los datos de un solo empleado, a traves de su ID, enviado como parámetro en la URL.

Testing️

Se añadió la clase src/test/java/com/enroute/ws/javarestdemo/EmployeeControllerTest.java, donde se evalua el registro del empleado
10017 en la base de datos y se compara con un mock de la información esperada para ese mismo Usuario.

Construido con️ Springboot, Lombok, Mockito

Springboot - El framework para simplificar la programación de la aplicación. Las dependencias especiales usadas por el proyecto:
	JPA - Utilizado para la lectura de Empleados de la base de datos a través de repositorios
	WEB - da la funcionalidad para una aplicación RESTful
	MySQL Driver - Usado para la conexión a la base de datos "employees"
Lombok - Utilizado para crear los beans y queries basandose en el nombre de las tablas/columnas de la base de datos
Mockito - Usado para generar los mocks para prueas unitarias sobre los metodos.

Autores
Aarón Acosta
Javier Zepeda️

Versiones
0.1 versión inicial
0.2 
	correcciones
	implementación de Lombok
0.3 
	Implementación de Mockito
