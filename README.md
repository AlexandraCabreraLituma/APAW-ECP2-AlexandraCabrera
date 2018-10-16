# Arquitectura de un mini API-Rest simulado
> Este proyecto pretende ser un ejemplo sencillo de arquitectura de un API-Rest simulado para comprender las capas que intervienen y la organización de los diferentes tipos de test, con integración continua y control de la calidad del código
> #### [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
> #### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*

## Tecnologías necesarias
* Java
* Maven
* GitHub

## Diseño de entidades
![themes-entities-class-diagram](https://github.com/AlexandraCabreraLituma/APAW-ECP2-AlexandraCabrera/blob/master/AlexandraCabreraUml.png)

## API
### POST /users
#### Parámetros del cuerpo
- `nie`: String (**requerido**)
- `firstName`: String (**requerido**)
- `lastName`: String

#### Respuesta
- 200 OK
  - `nie`: String
- 403 BAD_REQUEST

---

### POST /teams
#### Parámetros del cuerpo
- `id`: String (**requerido**)
- `name`: String (**requerido**)
- `nick`: String
- `player`: List<player>
- `trainerNie`: String (**requerido**)

#### Respuesta
- 200 OK
  - `id`: String
- 403 BAD_REQUEST

---

### POST /players
#### Parámetros del cuerpo
- `nie`: String (**requerido**)
- `firstName`: String (**requerido**)
- `lastName`: String
- `number`: Integer
- `position`: Position (**requerido**)

#### Respuesta
- 200 OK
  - `nie`: String
- 403 BAD_REQUEST

---

### GET /trainers
#### Respuesta
- 200 OK
  - [{nie:String,name:String}]

---
### PATH /teams/{id}/players
#### Parámetros del cuerpo
- `players`: <List> (**requerido**)
#### Respuesta
- 200 OK
- 403 BAD_REQUEST
- 404 NOT_FOUND
---

### PUT /players/{nie}
#### Parámetros del cuerpo
- `nie`: String (**requerido**)
- `firstName`: String (**requerido**)
- `lastName`: String
- `number`: Integer
- `position`: Position (**requerido**)
#### Respuesta
- 200 OK
- 403 BAD_REQUEST
- 404 NOT_FOUND
---

### DELETE /teams/{id}
#### Respuesta
- 200 OK
---
### GET /teams/{id}/average

##### Autor: Alexandra Cabrera

