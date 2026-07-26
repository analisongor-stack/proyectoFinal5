/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinal5;

/**
 *
 * @author USER
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.util.Scanner;
/**
 *
 * @author GRUPO 5
 */

public class ProyectoGrupo5 {

    // Variables globales (equivalentes a las variables del Algoritmo principal en PSeInt)
    static Scanner scanner = new Scanner(System.in);
    
    static String[][] usuarios = new String[1000][6];
    static String[][] publicaciones = new String[1000][11];
    static String[][] administradores = new String[10][5];
    
    static int totalUsuarios = 0;
    static int totalPublicaciones = 0;
    static int totalAdmins = 0;

    // Helper para leer enteros sin el problema del salto de línea
    static int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        return valor;
    }

    //======================================================
    // ACCESO DE ADMINISTRADOR
    //======================================================
    static int ValidarAdministrador() {
        int posicionEncontrada = -1;
        System.out.println("===== ACCESO ADMINISTRADOR =====");
        System.out.println("Correo administrador:");
        String correo = scanner.nextLine();
        
        System.out.println("Clave:");
        String clave = scanner.nextLine();

        for (int i = 0; i < totalAdmins; i++) {
            if (administradores[i][2].equals(correo) && administradores[i][3].equals(clave)) {
                posicionEncontrada = i;
            }
        }

        if (posicionEncontrada != -1) {
            System.out.println("Acceso concedido. Bienvenido/a " + administradores[posicionEncontrada][0]);
        } else {
            System.out.println("Acceso denegado. Credenciales incorrectas.");
        }
        return posicionEncontrada;
    }

    //======================================================
    // FUNCIONES DE VALIDACION
    //======================================================
    static boolean CorreoExiste(String correo) {
        boolean existe = false;
        int i = 0;
        while (i < totalUsuarios) {
            if (usuarios[i][3].equals(correo)) {
                existe = true;
            }
            i++;
        }
        return existe;
    }

    static boolean ValidarCorreoInstitucional(String correo) {
        String dominio = "@utmachala.edu.ec";
        if (correo.length() >= dominio.length()) {
            String terminacion = correo.substring(correo.length() - dominio.length());
            if (terminacion.equals(dominio)) {
                return true;
            }
        }
        return false;
    }

    static int BuscarUsuario(String correo) {
        int posicion = -1;
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i][3].equals(correo)) {
                posicion = i;
            }
        }
        return posicion;
    }

    //======================================================
    // REGISTRO DE USUARIOS
    //======================================================
    static void RegistrarUsuario() {
        String nombre, carrera = "", semestre = "", correo;
        int opcion3, opcion4, opcion5;
        boolean correoValido, verificar, repetido;

        if (totalUsuarios >= 1000) {
            System.out.println("No hay espacio para mas usuarios.");
            return;
        }

        System.out.println("\n===== REGISTRO DE USUARIO =====");

        do {
            System.out.println("Ingrese nombre:");
            nombre = scanner.nextLine();
        } while (nombre.isEmpty());

        do {
            System.out.println("Seleccione la facultad:");
            System.out.println("1. Ciencias Empresariales");
            System.out.println("2. Ciencias Agropecuarias");
            System.out.println("3. Ciencias Quimicas y de la Salud");
            System.out.println("4. Ciencias Sociales");
            System.out.println("5. Ingenieria Civil");
            opcion3 = leerEntero();
            
            verificar = false;
            switch (opcion3) {
                case 1:
                    do {
                        verificar = false;
                        System.out.println("Seleccione carrera: ");
                        System.out.println("1. Administracion de Empresas");
                        System.out.println("2. Comercio Exterior");
                        System.out.println("3. Contabilidad y Auditoria");
                        System.out.println("4. Economia");
                        System.out.println("5. Mercadotecnia");
                        System.out.println("6. Turismo");
                        System.out.println("7. Finanzas y Negocios Digitales");
                        System.out.println("8. Gestion de la Innovacion");
                        opcion4 = leerEntero();
                        switch (opcion4) {
                            case 1: carrera = "Administracion de Empresas"; verificar = true; break;
                            case 2: carrera = "Comercio Exterior"; verificar = true; break;
                            case 3: carrera = "Contabilidad y Auditoria"; verificar = true; break;
                            case 4: carrera = "Economia"; verificar = true; break;
                            case 5: carrera = "Mercadotecnia"; verificar = true; break;
                            case 6: carrera = "Turismo"; verificar = true; break;
                            case 7: carrera = "Finanzas y Negocios Digitales"; verificar = true; break;
                            case 8: carrera = "Gestion de la Innovacion"; verificar = true; break;
                            default: System.out.println("Opcion Invalida");
                        }
                    } while (!verificar);
                    break;
                case 2:
                    do {
                        verificar = false;
                        System.out.println("Seleccione carrera: ");
                        System.out.println("1. Agronomia\n2. Agropecuaria\n3. Acuicultura\n4. Medicina Veterinaria");
                        opcion4 = leerEntero();
                        switch (opcion4) {
                            case 1: carrera = "Agronomia"; verificar = true; break;
                            case 2: carrera = "Agropecuaria"; verificar = true; break;
                            case 3: carrera = "Acuicultura"; verificar = true; break;
                            case 4: carrera = "Medicina Veterinaria"; verificar = true; break;
                            default: System.out.println("Opcion Invalida");
                        }
                    } while (!verificar);
                    break;
                case 3:
                    do {
                        verificar = false;
                        System.out.println("Seleccione carrera: ");
                        System.out.println("1. Ingenieria en Alimentos\n2. Enfermeria\n3. Ingenieria Quimica\n4. Medicina\n5. Psicologia Clinica");
                        opcion4 = leerEntero();
                        switch (opcion4) {
                            case 1: carrera = "Ingenieria en Alimentos"; verificar = true; break;
                            case 2: carrera = "Enfermeria"; verificar = true; break;
                            case 3: carrera = "Ingenieria Quimica"; verificar = true; break;
                            case 4: carrera = "Medicina"; verificar = true; break;
                            case 5: carrera = "Psicologia Clinica"; verificar = true; break;
                            default: System.out.println("Opcion Invalida");
                        }
                    } while (!verificar);
                    break;
                case 4:
                    do {
                        verificar = false;
                        System.out.println("Seleccione la carrera");
                        System.out.println("1. Derecho\n2. Artes Plasticas\n3. Comunicacion\n4. Educacion Basica\n5. Educacion Inicial\n6. Trabajo Social");
                        opcion4 = leerEntero();
                        switch (opcion4) {
                            case 1: carrera = "Derecho"; verificar = true; break;
                            case 2: carrera = "Artes Plasticas"; verificar = true; break;
                            case 3: carrera = "Comunicacion"; verificar = true; break;
                            case 4: carrera = "Educacion Basica"; verificar = true; break;
                            case 5: carrera = "Educacion Inicial"; verificar = true; break;
                            case 6: carrera = "Trabajo Social"; verificar = true; break;
                            default: System.out.println("Opcion Invalida");
                        }
                    } while (!verificar);
                    break;
                case 5:
                    do {
                        verificar = false;
                        System.out.println("Seleccione la carrera");
                        System.out.println("1. Ingenieria Civil\n2. Tecnologias de la informacion\n3. Ingenieria Ambiental\n4. Ciencias de Datos");
                        opcion4 = leerEntero();
                        switch (opcion4) {
                            case 1: carrera = "Ingenieria Civil"; verificar = true; break;
                            case 2: carrera = "Tecnologias de la informacion"; verificar = true; break;
                            case 3: carrera = "Ingenieria Ambiental"; verificar = true; break;
                            case 4: carrera = "Ciencias de Datos"; verificar = true; break;
                            default: System.out.println("Opcion Invalida");
                        }
                    } while (!verificar);
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (!verificar);

        do {
            verificar = false;
            System.out.println("Ingrese semestre (1 al 10):");
            opcion5 = leerEntero();
            if (opcion5 >= 1 && opcion5 <= 10) {
                semestre = String.valueOf(opcion5);
                verificar = true;
            } else {
                System.out.println("Opcion Invalida");
            }
        } while (!verificar);

        do {
            System.out.println("Ingrese correo institucional:");
            correo = scanner.nextLine();
            correoValido = ValidarCorreoInstitucional(correo);
            if (!correoValido) {
                System.out.println("Correo invalido.\nDebe terminar en @utmachala.edu.ec");
            }
        } while (!correoValido);

        repetido = CorreoExiste(correo);

        if (repetido) {
            System.out.println("El usuario ya existe.\nRegistro cancelado.");
        } else {
            usuarios[totalUsuarios][0] = nombre;
            usuarios[totalUsuarios][1] = carrera;
            usuarios[totalUsuarios][2] = semestre;
            usuarios[totalUsuarios][3] = correo;
            usuarios[totalUsuarios][4] = "ACTIVA";
            usuarios[totalUsuarios][5] = "0";
            
            totalUsuarios++;
            System.out.println("\nUsuario registrado correctamente.");
        }
    }

    //======================================================
    // MOSTRAR USUARIOS
    //======================================================
    static void MostrarUsuarios() {
        if (totalUsuarios == 0) {
            System.out.println("No existen usuarios registrados.");
        } else {
            for (int i = 0; i < totalUsuarios; i++) {
                System.out.println("\n===================================");
                System.out.println("POSICION: " + i);
                System.out.println("Nombre: " + usuarios[i][0]);
                System.out.println("Carrera: " + usuarios[i][1]);
                System.out.println("Semestre: " + usuarios[i][2]);
                System.out.println("Correo: " + usuarios[i][3]);
                System.out.println("Estado: " + usuarios[i][4]);
                System.out.println("Publicaciones: " + usuarios[i][5]);
            }
        }
    }

    //======================================================
    // CAMBIAR ESTADO DE USUARIO
    //======================================================
    static void CambiarEstadoUsuario() {
        System.out.println("Ingrese correo:");
        String correo = scanner.nextLine();
        
        int posicion = BuscarUsuario(correo);
        
        if (posicion == -1) {
            System.out.println("Usuario no encontrado.");
        } else {
            System.out.println("1. Activar\n2. Suspender");
            int opcion = leerEntero();
            
            if (opcion == 1) {
                usuarios[posicion][4] = "ACTIVA";
                System.out.println("Usuario activado.");
            } else if (opcion == 2) {
                usuarios[posicion][4] = "SUSPENDIDA";
                System.out.println("Usuario suspendido.");
            }
        }
    }

    //======================================================
    // INICIO DE SESION
    //======================================================
    static int ValidarUsuario() {
        int posicionEncontrada = -1;
        System.out.println("\n===== INICIO DE SESION =====");
        System.out.println("Ingrese correo institucional:");
        String correo = scanner.nextLine();

        if (!ValidarCorreoInstitucional(correo)) {
            System.out.println("Solo se permiten correos @utmachala.edu.ec");
        } else {
            int posicion = BuscarUsuario(correo);

            if (posicion == -1) {
                System.out.println("Correo no registrado.");
            } else {
                if (usuarios[posicion][4].equals("SUSPENDIDA")) {
                    System.out.println("Usuario suspendido.");
                } else {
                    int codigo;
                    do {
                        System.out.println("Ingrese codigo de acceso (Ej: 1234):");
                        codigo = leerEntero();
                    } while (codigo != 1234);

                    posicionEncontrada = posicion;
                    System.out.println("Acceso concedido.");
                }
            }
        }
        return posicionEncontrada;
    }

    //======================================================
    // FUNCIONES DE FECHAS Y PRIORIDADES
    //======================================================
    static boolean FechaValida(String fecha) {
        if (fecha.length() == 10) {
            if (fecha.charAt(2) == '/' && fecha.charAt(5) == '/') {
                return true;
            }
        }
        return false;
    }

    static int DiasRestantes() {
        System.out.println("Ingrese dias restantes para vencimiento:");
        int dias = leerEntero();
        if (dias < 0) dias = 0;
        return dias;
    }

    static int CalcularPuntaje(String categoria, String alcance, int dias) {
        int puntaje = 0;
        switch (categoria) {
            case "ACADEMICA": puntaje += 40; break;
            case "EVENTOS": puntaje += 30; break;
            case "AVISOS": puntaje += 20; break;
            case "GENERAL": puntaje += 10; break;
        }
        
        switch (alcance) {
            case "ALTO": puntaje += 30; break;
            case "MEDIO": puntaje += 20; break;
            case "BAJO": puntaje += 10; break;
        }
        
        if (dias <= 1) puntaje += 30;
        else if (dias <= 7) puntaje += 20;
        else puntaje += 10;
        
        return puntaje;
    }

    static String CalcularPrioridad(String categoria, String alcance, int dias) {
        int puntaje = CalcularPuntaje(categoria, alcance, dias);
        if (puntaje >= 80) return "ALTA";
        else if (puntaje >= 50) return "MEDIA";
        else return "BAJA";
    }

    static String GenerarJustificacion(String prioridad) {
        if (prioridad.equals("ALTA")) return "Publicacion urgente y proxima a vencer";
        else if (prioridad.equals("MEDIA")) return "Publicacion relevante con tiempo moderado";
        else return "Publicacion informativa de baja prioridad";
    }

    //======================================================
    // CREAR PUBLICACION (ESTUDIANTES)
    //======================================================
    static void CrearPublicacion(int posicionUsuario) {
        String categoria = "", titulo, descripcion, fechaPublicacion, fechaVencimiento, alcance = "";
        int dias, opcion3;
        boolean verificar;

        System.out.println("\n===== CREAR PUBLICACION =====");
        
        if (posicionUsuario == -1 || usuarios[posicionUsuario][4].equals("SUSPENDIDA")) {
            System.out.println("Error de usuario.");
            return;
        }

        do {
            verificar = false;
            System.out.println("Categoria:\n1. ACADEMICA\n2. EVENTOS\n3. AVISOS\n4. GENERAL");
            opcion3 = leerEntero();
            switch (opcion3) {
                case 1: categoria = "ACADEMICA"; verificar = true; break;
                case 2: categoria = "EVENTOS"; verificar = true; break;
                case 3: categoria = "AVISOS"; verificar = true; break;
                case 4: categoria = "GENERAL"; verificar = true; break;
                default: System.out.println("Categoria invalida");
            }
        } while (!verificar);

        do {
            System.out.println("Titulo:");
            titulo = scanner.nextLine();
        } while (titulo.isEmpty());

        do {
            System.out.println("Descripcion:");
            descripcion = scanner.nextLine();
        } while (descripcion.isEmpty());

        do {
            System.out.println("Fecha publicacion (dd/mm/aaaa):");
            fechaPublicacion = scanner.nextLine();
        } while (!FechaValida(fechaPublicacion));

        do {
            System.out.println("Fecha vencimiento (dd/mm/aaaa):");
            fechaVencimiento = scanner.nextLine();
        } while (!FechaValida(fechaVencimiento));

        do {
            verificar = false;
            System.out.println("Alcance:\n1. ALTO\n2. MEDIO\n3. BAJO");
            opcion3 = leerEntero();
            switch (opcion3) {
                case 1: alcance = "ALTO"; verificar = true; break;
                case 2: alcance = "MEDIO"; verificar = true; break;
                case 3: alcance = "BAJO"; verificar = true; break;
                default: System.out.println("Invalido");
            }
        } while (!verificar);

        dias = DiasRestantes();
        String prioridad = CalcularPrioridad(categoria, alcance, dias);
        String justificacion = GenerarJustificacion(prioridad);

        publicaciones[totalPublicaciones][0] = usuarios[posicionUsuario][0];
        publicaciones[totalPublicaciones][1] = usuarios[posicionUsuario][1];
        publicaciones[totalPublicaciones][2] = categoria;
        publicaciones[totalPublicaciones][3] = titulo;
        publicaciones[totalPublicaciones][4] = descripcion;
        publicaciones[totalPublicaciones][5] = fechaPublicacion;
        publicaciones[totalPublicaciones][6] = fechaVencimiento;
        publicaciones[totalPublicaciones][7] = alcance;
        publicaciones[totalPublicaciones][8] = prioridad;
        publicaciones[totalPublicaciones][9] = "ACTIVA";
        publicaciones[totalPublicaciones][10] = justificacion;

        int pubs = Integer.parseInt(usuarios[posicionUsuario][5]);
        usuarios[posicionUsuario][5] = String.valueOf(pubs + 1);
        
        totalPublicaciones++;

        System.out.println("\nPublicacion creada correctamente.");
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Justificacion: " + justificacion);
    }

    //======================================================
    // CREAR PUBLICACION (ADMINISTRADOR)
    //======================================================
    static void CrearPublicacionAdmin(int posicionAdmin) {
        String categoria = "", titulo, descripcion, fechaPublicacion, fechaVencimiento, alcance = "";
        int dias, opcion3;
        boolean verificar;

        System.out.println("\n===== CREAR PUBLICACION (ADMINISTRADOR) =====");
        
        if (posicionAdmin == -1) {
            System.out.println("Error de acceso.");
            return;
        }

        do {
            verificar = false;
            System.out.println("Categoria:\n1. ACADEMICA\n2. EVENTOS\n3. AVISOS\n4. GENERAL");
            opcion3 = leerEntero();
            switch (opcion3) {
                case 1: categoria = "ACADEMICA"; verificar = true; break;
                case 2: categoria = "EVENTOS"; verificar = true; break;
                case 3: categoria = "AVISOS"; verificar = true; break;
                case 4: categoria = "GENERAL"; verificar = true; break;
                default: System.out.println("Categoria invalida");
            }
        } while (!verificar);

        do {
            System.out.println("Titulo:");
            titulo = scanner.nextLine();
        } while (titulo.isEmpty());

        do {
            System.out.println("Descripcion:");
            descripcion = scanner.nextLine();
        } while (descripcion.isEmpty());

        do {
            System.out.println("Fecha publicacion (dd/mm/aaaa):");
            fechaPublicacion = scanner.nextLine();
        } while (!FechaValida(fechaPublicacion));

        do {
            System.out.println("Fecha vencimiento (dd/mm/aaaa):");
            fechaVencimiento = scanner.nextLine();
        } while (!FechaValida(fechaVencimiento));

        do {
            verificar = false;
            System.out.println("Alcance:\n1. ALTO\n2. MEDIO\n3. BAJO");
            opcion3 = leerEntero();
            switch (opcion3) {
                case 1: alcance = "ALTO"; verificar = true; break;
                case 2: alcance = "MEDIO"; verificar = true; break;
                case 3: alcance = "BAJO"; verificar = true; break;
                default: System.out.println("Invalido");
            }
        } while (!verificar);

        dias = DiasRestantes();
        String prioridad = CalcularPrioridad(categoria, alcance, dias);
        String justificacion = GenerarJustificacion(prioridad);

        publicaciones[totalPublicaciones][0] = administradores[posicionAdmin][0];
        publicaciones[totalPublicaciones][1] = administradores[posicionAdmin][1]; // Cargo
        publicaciones[totalPublicaciones][2] = categoria;
        publicaciones[totalPublicaciones][3] = titulo;
        publicaciones[totalPublicaciones][4] = descripcion;
        publicaciones[totalPublicaciones][5] = fechaPublicacion;
        publicaciones[totalPublicaciones][6] = fechaVencimiento;
        publicaciones[totalPublicaciones][7] = alcance;
        publicaciones[totalPublicaciones][8] = prioridad;
        publicaciones[totalPublicaciones][9] = "ACTIVA";
        publicaciones[totalPublicaciones][10] = justificacion;

        int pubs = Integer.parseInt(administradores[posicionAdmin][4]);
        administradores[posicionAdmin][4] = String.valueOf(pubs + 1);
        
        totalPublicaciones++;

        System.out.println("\nPublicacion creada correctamente.");
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Justificacion: " + justificacion);
    }

    //======================================================
    // MOSTRAR TODAS LAS PUBLICACIONES
    //======================================================
    static void MostrarPublicaciones() {
        if (totalPublicaciones == 0) {
            System.out.println("No existen publicaciones.");
        } else {
            for (int i = 0; i < totalPublicaciones; i++) {
                System.out.println("\n================================");
                System.out.println("Autor: " + publicaciones[i][0]);
                System.out.println("Carrera/Cargo: " + publicaciones[i][1]);
                System.out.println("Categoria: " + publicaciones[i][2]);
                System.out.println("Titulo: " + publicaciones[i][3]);
                System.out.println("Descripcion: " + publicaciones[i][4]);
                System.out.println("Fecha Publicacion: " + publicaciones[i][5]);
                System.out.println("Fecha Vencimiento: " + publicaciones[i][6]);
                System.out.println("Alcance: " + publicaciones[i][7]);
                System.out.println("Prioridad: " + publicaciones[i][8]);
                System.out.println("Estado: " + publicaciones[i][9]);
                System.out.println("Justificacion:\n" + publicaciones[i][10]);
            }
        }
    }

    //======================================================
    // NOTIFICACIONES, ARCHIVAR Y ESTADISTICAS
    //======================================================
    static void EnviarNotificaciones() {
        if (totalPublicaciones == 0) {
            System.out.println("No existen publicaciones.");
        } else {
            for (int i = 0; i < totalPublicaciones; i++) {
                if (publicaciones[i][2].equals("ACADEMICA") && publicaciones[i][8].equals("ALTA") && publicaciones[i][9].equals("ACTIVA")) {
                    System.out.println("\n===== NOTIFICACION =====");
                    System.out.println("Titulo:\n" + publicaciones[i][3]);
                    System.out.println("Motivo:\n" + publicaciones[i][10]);
                }
            }
        }
    }

    static void ArchivarPublicaciones() {
        if (totalPublicaciones == 0) {
            System.out.println("No existen publicaciones.");
        } else {
            for (int i = 0; i < totalPublicaciones; i++) {
                System.out.println("\nPublicacion:\n" + publicaciones[i][3]);
                System.out.println("Expiro? (SI/NO)");
                String respuesta = scanner.nextLine().toUpperCase();
                
                if (respuesta.equals("SI")) {
                    publicaciones[i][9] = "ARCHIVADA";
                } else {
                    publicaciones[i][9] = "ACTIVA";
                }
            }
        }
    }

    static void UsuarioMasActivo() {
        int mayor = -1;
        int posicion = -1;
        
        for (int i = 0; i < totalUsuarios; i++) {
            int pubs = Integer.parseInt(usuarios[i][5]);
            if (pubs > mayor) {
                mayor = pubs;
                posicion = i;
            }
        }
        
        if (posicion != -1) {
            System.out.println("\n===== USUARIO MAS ACTIVO =====");
            System.out.println("Nombre: " + usuarios[posicion][0]);
            System.out.println("Carrera: " + usuarios[posicion][1]);
            System.out.println("Publicaciones: " + usuarios[posicion][5]);
        }
    }

    static void PublicacionesPorCategoria() {
        int academicas = 0, eventos = 0, avisos = 0, general = 0;
        
        for (int i = 0; i < totalPublicaciones; i++) {
            switch (publicaciones[i][2]) {
                case "ACADEMICA": academicas++; break;
                case "EVENTOS": eventos++; break;
                case "AVISOS": avisos++; break;
                case "GENERAL": general++; break;
            }
        }
        System.out.println("\n===== POR CATEGORIA =====");
        System.out.println("ACADEMICAS: " + academicas);
        System.out.println("EVENTOS: " + eventos);
        System.out.println("AVISOS: " + avisos);
        System.out.println("GENERAL: " + general);
    }

    static void PorcentajeUsuariosActivos() {
        int activos = 0;
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i][4].equals("ACTIVA")) activos++;
        }
        if (totalUsuarios > 0) {
            double porcentaje = (activos * 100.0) / totalUsuarios;
            System.out.println("\nPorcentaje usuarios activos: " + String.format("%.2f", porcentaje) + "%");
        }
    }

    static void PorcentajeArchivadas() {
        int archivadas = 0;
        for (int i = 0; i < totalPublicaciones; i++) {
            if (publicaciones[i][9].equals("ARCHIVADA")) archivadas++;
        }
        if (totalPublicaciones > 0) {
            double porcentaje = (archivadas * 100.0) / totalPublicaciones;
            System.out.println("\nPorcentaje archivadas: " + String.format("%.2f", porcentaje) + "%");
        }
    }

    static void PorcentajeCategorias() {
        int academicas = 0, eventos = 0, avisos = 0, generales = 0;
        for (int i = 0; i < totalPublicaciones; i++) {
            switch (publicaciones[i][2]) {
                case "ACADEMICA": academicas++; break;
                case "EVENTOS": eventos++; break;
                case "AVISOS": avisos++; break;
                case "GENERAL": generales++; break;
            }
        }
        if (totalPublicaciones > 0) {
            System.out.println("\n===== PORCENTAJES =====");
            System.out.println("ACADEMICAS: " + ((academicas * 100.0) / totalPublicaciones) + "%");
            System.out.println("EVENTOS: " + ((eventos * 100.0) / totalPublicaciones) + "%");
            System.out.println("AVISOS: " + ((avisos * 100.0) / totalPublicaciones) + "%");
            System.out.println("GENERAL: " + ((generales * 100.0) / totalPublicaciones) + "%");
        }
    }

    static void Estadisticas() {
        System.out.println("\n===== ESTADISTICAS =====");
        System.out.println("Usuarios registrados: " + totalUsuarios);
        System.out.println("Publicaciones registradas: " + totalPublicaciones);
        
        PorcentajeUsuariosActivos();
        PorcentajeArchivadas();
        PorcentajeCategorias();
        PublicacionesPorCategoria();
        UsuarioMasActivo();
    }

    //======================================================
    // METODO PRINCIPAL (MAIN)
    //======================================================
    public static void main(String[] args) {
        
        // USUARIOS PRECARGADOS
        usuarios[0] = new String[]{"Juan Perez", "Software", "3", "juan@utmachala.edu.ec", "ACTIVA", "0"};
        usuarios[1] = new String[]{"Maria Lopez", "Sistemas", "5", "maria@utmachala.edu.ec", "ACTIVA", "0"};
        usuarios[2] = new String[]{"Carlos Vega", "Tecnologias de la Informacion", "2", "carlos@utmachala.edu.ec", "ACTIVA", "0"};
        usuarios[3] = new String[]{"Ana Torres", "Software", "4", "ana@utmachala.edu.ec", "ACTIVA", "0"};
        usuarios[4] = new String[]{"Luis Moran", "Tecnologias de la Informacion", "1", "luis@utmachala.edu.ec", "ACTIVA", "0"};
        totalUsuarios = 5;
        
        // ADMINISTRADORES PRECARGADOS
        administradores[0] = new String[]{"Admin General", "Administracion de Plataforma", "admin@utmachala.edu.ec", "Admin123", "0"};
        administradores[1] = new String[]{"Director Academico", "Direccion UTMACH", "director@utmachala.edu.ec", "Director123", "0"};
        administradores[2] = new String[]{"Coordinador Estudiantil", "Coordinacion UTMACH", "coordinador@utmachala.edu.ec", "Coord123", "0"};
        administradores[3] = new String[]{"Decano de Facultad", "Decanato UTMACH", "decano@utmachala.edu.ec", "Decano123", "0"};
        totalAdmins = 4;
        
        boolean salirSistema = false;
        int opcion, opcion2, opcion3;
        int posicionUsuarioActual, posicionAdminActual;

        do {
            System.out.println("\n====================================");
            System.out.println(" PLATAFORMA UNIVERSITARIA UTMACH ");
            System.out.println("====================================");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Iniciar sesion (Estudiante)");
            System.out.println("3. Administrador");
            System.out.println("4. Salir");
            System.out.println("====================================");
            
            opcion = leerEntero();
            
            switch (opcion) {
                case 1:
                    RegistrarUsuario();
                    break;
                case 2:
                    posicionUsuarioActual = ValidarUsuario();
                    if (posicionUsuarioActual != -1) {
                        do {
                            System.out.println("\n====================================");
                            System.out.println(" MENU PRINCIPAL ESTUDIANTE ");
                            System.out.println("====================================");
                            System.out.println("1. Crear publicacion");
                            System.out.println("2. Mostrar publicaciones");
                            System.out.println("3. Mostrar usuarios");
                            System.out.println("4. Enviar notificaciones");
                            System.out.println("5. Archivar publicaciones");
                            System.out.println("6. Cerrar sesion");
                            System.out.println("====================================");
                            
                            opcion2 = leerEntero();
                            
                            switch (opcion2) {
                                case 1: CrearPublicacion(posicionUsuarioActual); break;
                                case 2: MostrarPublicaciones(); break;
                                case 3: MostrarUsuarios(); break;
                                case 4: EnviarNotificaciones(); break;
                                case 5: ArchivarPublicaciones(); break;
                                case 6: System.out.println("Sesion cerrada."); break;
                                default: System.out.println("Opcion invalida.");
                            }
                        } while (opcion2 != 6);
                    }
                    break;
                case 3:
                    posicionAdminActual = ValidarAdministrador();
                    if (posicionAdminActual != -1) {
                        do {
                            System.out.println("\n====================================");
                            System.out.println(" MENU PRINCIPAL ADMINISTRADOR");
                            System.out.println("====================================");
                            System.out.println("1. Crear publicacion");
                            System.out.println("2. Mostrar publicaciones");
                            System.out.println("3. Mostrar usuarios");
                            System.out.println("4. Cambiar estado usuario");
                            System.out.println("5. Enviar notificaciones");
                            System.out.println("6. Archivar publicaciones");
                            System.out.println("7. Estadisticas");
                            System.out.println("8. Cerrar sesion");
                            System.out.println("====================================");
                            
                            opcion2 = leerEntero();
                            
                            switch (opcion2) {
                                case 1: CrearPublicacionAdmin(posicionAdminActual); break;
                                case 2: MostrarPublicaciones(); break;
                                case 3: MostrarUsuarios(); break;
                                case 4: CambiarEstadoUsuario(); break;
                                case 5: EnviarNotificaciones(); break;
                                case 6: ArchivarPublicaciones(); break;
                                case 7:
                                    do {
                                        System.out.println("\n====================================");
                                        System.out.println(" MENU ESTADISTICAS ");
                                        System.out.println("====================================");
                                        System.out.println("1. Estadisticas Generales");
                                        System.out.println("2. Usuario mas activo");
                                        System.out.println("3. Publicaciones por categoria");
                                        System.out.println("4. Porcentaje usuarios activos");
                                        System.out.println("5. Porcentaje publicaciones archivadas");
                                        System.out.println("6. Porcentaje por categoria");
                                        System.out.println("7. Salir");
                                        System.out.println("====================================");
                                        
                                        opcion3 = leerEntero();
                                        
                                        switch (opcion3) {
                                            case 1: Estadisticas(); break;
                                            case 2: UsuarioMasActivo(); break;
                                            case 3: PublicacionesPorCategoria(); break;
                                            case 4: PorcentajeUsuariosActivos(); break;
                                            case 5: PorcentajeArchivadas(); break;
                                            case 6: PorcentajeCategorias(); break;
                                            case 7: System.out.println("Saliendo de Estadisticas."); break;
                                            default: System.out.println("Opcion invalida.");
                                        }
                                    } while (opcion3 != 7);
                                    break;
                                case 8: System.out.println("Sesion cerrada."); break;
                                default: System.out.println("Opcion invalida.");
                            }
                        } while (opcion2 != 8);
                    }
                    break;
                case 4:
                    salirSistema = true;
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (!salirSistema);

        System.out.println("\nPrograma finalizado.");
        scanner.close();
    }
}