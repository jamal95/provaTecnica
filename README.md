# provaTecnica
Prova técnica Limit Tecnologies
• Estructura del proyecto:
  – Configuración principal:
  
    ◦ El proyecto consiste en la arquitectura Spring MVC (Model, View, Controller) que utiliza
    hibernate para establecer las conexiones con la base de datos (relacionando los
    campos de una clase con los de una tabla de base de datos), en la carpeta principal
    (Web Pages) nos encontrarnos con un archivo redirect.jsp que nos muestra la página
    principal que contiene el login, en este caso no he creado ningún tipo de mapeo
    (controller) porque ya se crea por defecto por el sistema en el archivo dispatcherservlet
    (indexController).
    
    ◦ En la carpeta WEB-INF podemos encontrarnos principalmente con los siguientes
    archivos: applicationContext.xml, dispatcher-servlet y web.xml:
    
      ▪ applicationContext.xml: En este archivo se indican los paquetes que se van a
      escanear para ver que tipo de componente contiene cada archivo de cada paquete
      (controladores, componentes, etc.), también es el fichero que contiene la
      configuración de la conexión a la base de datos (driver, url, username y password)
      y finalmente nos encontramos con la configuración del sessionFactory que es la
      encargada de indicar que clases (entidades) pertenecen a cada tabla y relaciona
      los atributos de cada clase con los campos de las tablas, toda esta configuración se
      realiza a través de los beans (las relaciones entre los campos se indica en las
      clases DAO).
      
          ◦ Nota: Se pueden separar las configuraciones en diferentes archivos xml y
          acceder a ellos context-param (ubicación archivos) en el archivo web.xml.
          
    ▪ Dispatcher-servlet.xml: Este archivo en mi caso solo indica la ubicación del
    indexController.
    
    ▪ Web.xml: Podemos decir que este es el archivo mas imporante de los
    mencionados anteriormente, se encarga de indicar la ubicación de los archivos de
    configuración xml, también contiene la configuración para redirigir todas las
    peticiones a los servlets (en este caso controladores) que se solicitan a través de la
    url. El controlador recibe la petición mediante la anotación @RequestMapping.
    
    ▪ La carpeta resources contiene los archivos css y js.
  – Funcionamiento básico del programa (iré explicando con mas detalle la
  configuración de los controladores y clases DAO durante la explicación del
  funcionamiento):
  
    ◦ Al iniciar el programa nos redirige al index que contiene la vista para poder loguear y
    registrarse al sistema, cuando un usuario realiza alguna de las acciones de loguear,
    registrarse o desloguearse, el programa lo redirige al controlador UsersController que
    mediante la anotación @Autowired nos indica que clase o clases se van a usar para
    poder acceder a la base de datos (podemos usar esta anotación porque se ha
    configurado en el archivo applicationContext.xml mediante el sessionFactory). Una vez
    redirigido al controlador UsersController vamos a encontrarnos principalmente con 3
    métodos mediante los cuales podemos realizar las siguientes acciones:
    
    • Login: Obtiene los parámetros del formulario (username, password) y mediante
    la interface usersDao (explicaré mas adelante el funcionamiento de estas
    clases) obtenemos el usuario si existe, guardamos la sesión y nos redirigimos a
    la página principal (home), en caso de no encontrar el usuario se redirige a la
    pagina de login con la variable error.
    
    • Register: Este método tiene casi la misma funcionalidad que el método anterior
    pero en este caso en lugar de buscar el usuario (select) inserta un nuevo
    usuario con los parámetros recibidos, solo inserta el usuario en caso de no
    existir.
    
    • Logout: La función principal de este método es eliminar la sesión y
    desloguearse del sistema.
    
  ◦ Una vez iniciada la sesión podemos realizar dos acciones desde la vista home, generar
  un nuevo código promocional y ver los códigos creados, las dos opciones nos redirigen
  al controlador CodesContoller que tiene los siguientes métodos de la interface
  codesDao llamada mediante la anotación @Autowired. los métodos deleteCode y
  redeemCode los explicaré en el siguiente punto:
  
    • seeCodes: La función de este métdo es obtener el id del usuario que ha iniciado
    sesión y mediante este accede a la base de datos y obtiene los códigos
    generados.
    
    • GenerateCode: Este método lo que hace es generar un nuevo código
    promocional llamando al método generateRandomcode de este mism
    controlador, una vez obtenido el código va comprobando si existe en la base de
    datos y si no lo añade indicando el usuario a que pertenece.
    
    ◦ Una vez obtenidos los códigos promocionales el controlador nos redirige a la vista
    codes en la cual podemos canjear (redeem) un código o eliminarlo.
    
    • Si seleccionamos la opción de canjear el código el sistema nos redirige al
    método redeemCode del controlador CodesController, en este caso lo que
    hacemos es asignar al código (mediante el id) una 'S' al campo redeem para
    indicar que se ha bescambiado.
    
    • Y mediante la opción de eliminar el código lo que hacemos es redirigirnos al
    controlador CodesController y con el método deleteCode eliminamos el código
    mediante su id.
    
      ▪ Nota: Estas llamadas se hacen mediante AJAX para poder canjear o
      eliminar el código mostrando el resultado sin recargar la página.
      
    • Las clases UsersDAOImpl u Codes DAOImpl: són las clases que contienen los métodos
    para realizar cualquier de las acciones relacionadas con los usuaiors o códigos
    mencionadas anteriormente, implementan las interfaces CodesDao y UsersDao.
    
    • Finalmente tenemos los modelos que se encuentran en el paquete models, són las clases
    que basicamente la antoación @Entity indicamos que esta clase se va a usar como una
    entidad y la tabla con la que se relaciona en la base de datos se indica con la anotación
    @Table.
    
  ◦ Con la anotación @Column indicamos a que columna pertenece el campo
  
  ◦ Con la anotación @Id indicamos el campo id de la clase y le decimos que es
  autoincrement con la anotación @GenerateValue.
  
    • La relación con la clase Users y Codes se hace mediante la anotación
    ManyToOne en la clase Codes y la anotación OneToMany en la clase Users
    (Indicando que un usuario puede tener vários códigos promocionales pero un
    código solo pertenece a un usuario)
