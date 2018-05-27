# SportTEC3

El objetivo de este proyecto es crear una aplicación en Android que consuma recursos de un servidor web creado en Node.js y utilice MongoDB como el repositorio de datos NoSQL.

### Requerimientos del sistema (Servidor):
- Sistema Operativo: Linux 16.X o superior, Windows 7,8.x y 10.
- Memoria RAM: 8GB (recomendado).
- Procesador: Intel Core i3 o superior, o AMD Ryzen.
- Espacio en Disco: 100MB.
- Acceso a Internet.
- Software adicional:
- - Adobe Photoshop CC (opcional).
- - Atom o Sublime3 (opcional).
- - Chrome.
- - Postman (opcional).
### Requerimientos del sistema (Cliente: Aplicación):
-   Sistema Operativo  **Android**  version minima 4.2 (Jelly Bean, API level 17) o hasta la version maxima 8.1 (Oreo, API level 27).
-   Memoria RAM 1.5GB o superior.
-   Espacio de almacenamiento 200MB.
-   Pantalla de 4.5" o superior.
-   Acceso a Internet.
-   Camara digital.

## Graphql

Similar a un API RESTful, trabajara junto a NodeJS, Express y Mongo DB, justam,ente para hacer las consultas o querys a la base de datos. 

## Node JS

NodeJS permitirá crear un servidor que facilitara la comunicación entre la aplicación y la base datos para acciones como envío y recibimiento de datos en tiempo real.

## Express

Express es el Framework que facilitara el trabajo sobre NodeJS

## MongoDB

MongoDB es la base de datos a utilizar desde el proyecto.
### Instalar MongoDB en Linux
- Primero importaremos la llave para el repositorio oficial de MongoDB.
```javascript
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2930ADAE8CAF5059EE73BB4B58712A2291FA4AD5
```
- Debemos agregar los detalles del repositorio de Mongo de tal manera que `apt` pueda saber de donde descargar los paquetes:
```javascript
echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu xenial/mongodb-org/3.6 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.6.list
```
- Después de agregar los detalles del repositorio, debemos actualizar la lista de paquetes:
```javascript
sudo apt-get update
```
- Ahora podemos instalar el propio paquete de MongoDB:
```javascript
sudo apt-get install -y mongodb-org
```
- Instalar un version especifica de Mongo:
```javascript
sudo apt-get install -y mongodb-org=3.6.4 mongodb-org-server=3.6.4 mongodb-org-shell=3.6.4 mongodb-org-mongos=3.6.4 mongodb-org-tools=3.6.4
```
- Vamos a crear un archivo de unidad para administrar el servicio de MongoDB. Crearemos un archivo de configuración llamado `mongodb.service` en el directorio `/etc/systemd/system`:
```java
sudo nano /etc/systemd/system/mongodb.service
```
- Pegue el siguiente contenido, después guarde y cierre el archivo:
```java
[Unit]
Description=High-performance, schema-free document-oriented database
After=network.target

[Service]
User=mongodb
ExecStart=/usr/bin/mongod --quiet --config /etc/mongod.conf

[Install]
WantedBy=multi-user.target
```
- Lo siguiente, será iniciar el servicio recién creado:
```java
sudo service mongod start
```
- Para verificar que el proceso [`mongod`](https://docs.mongodb.com/manual/reference/program/mongod/#bin.mongod "bin.mongod") ha iniciado correctamente se puede ir al archivo ubicado en `/var/log/mongodb/mongod.log` y verificar que exista la linea:
```java
[initandlisten] waiting for connections on port 27017
```
- Puedes detener el servicio de la siguiente forma:
```java
sudo service mongod stop
```
Puedes reiniciar el servicio de la siguiente manera:
```java
sudo service mongod restart
```
## Mongoose
