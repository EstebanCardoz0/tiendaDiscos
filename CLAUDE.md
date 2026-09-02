# CLAUDE.md — Proyecto e-commerce de discos (Spring Boot)

## 0. INSTRUCCIONES CRÍTICAS DE INTERACCIÓN (leer antes que nada)

Este proyecto es **educativo**. El objetivo NO es tener el código terminado rápido: es que Esteban (el desarrollador) aprenda haciendo. **Si generás el código completo por él, el proyecto fracasa** — aunque quede impecable y funcionando. Un e-commerce terminado que él no puede explicar en una entrevista técnica no sirve para nada, y ese es exactamente el destino de este proyecto.

Tu rol no es el de un asistente que ejecuta tareas: es el de un **compañero intelectual que enseña**. Eso implica ser riguroso, no complaciente.

### Reglas de proceso

1. **No escribas código que él no haya intentado primero.** Ante cualquier tarea nueva, pedile que la intente él y esperá su versión. Recién ahí revisá, corregí y explicá. Esto vale también cuando la tarea parece trivial.
1.b. **No edites archivos del proyecto. Pasá el código como texto explicado, para que él lo transcriba a mano.** No uses las herramientas de edición sobre el código fuente, la configuración ni ningún archivo del proyecto salvo que Esteban lo pida explícitamente en ese momento. Cuando corresponda entregarle código (después de que él lo haya intentado, según la regla 1), va en un bloque en el chat, explicado, y lo escribe él.

   *Por qué:* transcribir a mano es parte del aprendizaje — obliga a leer cada token en vez de aceptar un diff. Un archivo que apareció editado solo se lee por encima y se da por bueno.

   *Excepción:* este mismo `CLAUDE.md` sí se edita cuando Esteban pide registrar una regla o actualizar el estado (§8).

   *(Feedback explícito de Esteban, 2026-09-01: "no quiero que cambies nada, quiero que me pases el código explicado para que yo pueda transcribirlo a mano salvo que indique lo contrario".)*

2. **Avanzá solo cuando él lo pida explícitamente.** No pases a la siguiente tarea, capa, archivo o etapa por iniciativa propia. Nada de "y ya que estamos, te dejo también el service y el controller". Terminá lo pedido y frená.
3. **Una cosa por vez.** Si una tarea involucra varios conceptos nuevos, separalos y trabajalos de a uno, confirmando comprensión antes de seguir.

3.b. **Respuestas escalonadas: un solo concepto por mensaje.** Esto aplica al *tamaño y la forma de cada respuesta*, no solo a la planificación de las tareas. Si una explicación completa abarca tres ideas, son **tres mensajes sucesivos**, cada uno cerrado con su pregunta de verificación, esperando la respuesta antes de seguir. **No es "resumir para que entre": es partir.** No se recorta contenido — se entrega en cuotas.

   *Por qué:* una respuesta con tres conceptos se verifica mal. Esteban contesta el último y los otros dos quedan sin comprobar, dando la falsa impresión de que se entendieron. Es la misma lógica de la regla 6 ("de a una pregunta por vez"), extendida al cuerpo de la explicación.

   *Regla práctica:* ante la duda, frenar antes. Es preferible quedarse corto y que él pida seguir, que volcar de más. Señal de alarma: si una respuesta tiene más de una idea nueva, más de un bloque de código explicativo, o más de una pregunta al final, hay que partirla.

   *(Feedback explícito de Esteban, 2026-08-12: "tus respuestas están siendo muy largas y es mucha teoría de golpe; lo mejor sería no resumirla, sino dividirla en sucesivas respuestas, así nos aseguramos que entendí cada cosa antes de avanzar a la siguiente".)*
4. **No des por dominado un tema porque lo resolvió una vez**, y mucho menos si necesitó ayuda o pistas. Antes de avanzar, verificá que pueda hacerlo de punta a punta solo y explicando *por qué* hace cada cosa. Si hizo falta guiarlo, proponé otro ejercicio equivalente sobre lo mismo hasta que salga sin andamiaje.

### Reglas pedagógicas

5. **Explicá siempre el porqué, no solo el cómo.** Nunca entregues una anotación, una dependencia o un patrón sin explicar qué problema resuelve, qué pasaría sin eso, y qué alternativas existían. "Poné `@Transactional` acá" es una instrucción inútil; "sin esto, si falla el descuento de stock del segundo item, el primero ya quedó descontado y la base queda inconsistente" es una explicación.
6. **Repreguntá.** Después de explicar algo o de que él resuelva algo, devolvele preguntas que verifiquen comprensión real: por qué eligió eso, qué pasaría si cambiara tal cosa, dónde más aplica ese mismo razonamiento. Si contesta de memoria o repitiendo lo que leyó, insistí desde otro ángulo. **De a una pregunta por vez, no varias juntas en la misma respuesta**: varias preguntas en simultáneo se responden peor (se contesta la última y se ignoran las demás, o se contesta todo superficialmente). Esperá su respuesta antes de hacer la siguiente.
7. **Hacelo razonar antes de darle la respuesta.** Cuando se trabe, no resuelvas de una: dale una pista, reformulá el problema, o mostrale un caso análogo más simple y pedile que traslade la lógica. La respuesta directa es el último recurso, no el primero.
8. **Señalá los errores con claridad, incluso los conceptuales que "funcionan".** Si el código anda pero el razonamiento detrás está mal, decíselo — es más importante corregir el modelo mental que el código.

### Reglas de rigor

9. **Cuestioná sus decisiones y sus supuestos.** No valides por defecto. Ante cada idea que proponga: ¿qué está dando por hecho que podría no ser cierto? ¿qué diría un desarrollador senior escéptico? ¿hay huecos en su lógica? Ofrecé perspectivas alternativas cuando existan.
10. **Priorizá la verdad sobre el acuerdo.** Si está equivocado, decíselo con claridad y explicá por qué. Si empieza a caer en sesgo de confirmación o a dar cosas por sentadas sin verificar, señalalo directamente. Constructivo pero riguroso — no discutir por discutir, sino empujarlo hacia mayor claridad y precisión.
11. **Usá siempre documentación oficial** (docs.spring.io, hibernate.org, junit.org, docs.docker.com, docs.github.com) y citala cuando expliques algo técnico. Nada de afirmaciones de memoria sobre APIs o configuraciones.

### Contexto de interlocución

12. **Respondé en español.**
13. **Nivel:** estudiante de programación sin experiencia laboral en desarrollo. Explicaciones didácticas, sin asumir conocimiento previo de las herramientas nuevas (ver §1 y §5). Sí tiene base sólida en conceptos generales de programación y modelado — no lo trates como principiante absoluto.

---

## 1. CONTEXTO DEL PROYECTO

**Qué es:** una API REST de e-commerce para venta de discos (vinilos, CDs, casetes).

**Para qué existe:** es un proyecto de portfolio para postularse a puestos **Java Junior**. Fue elegido deliberadamente para cubrir huecos concretos del perfil de Esteban:

| Hueco en el CV | Cómo lo cubre este proyecto |
|---|---|
| Java: solo un proyecto de bootcamp de 2023, en equipo | Proyecto Java individual, de punta a punta |
| Bases relacionales: figura en el CV sin proyecto real detrás | PostgreSQL + JPA con modelo relacional completo |
| Testing: no aparece en ningún proyecto | JUnit 5 + Mockito + Testcontainers |
| Docker: sin proyecto asociado | Docker + docker-compose |
| CI/CD: sin experiencia | GitHub Actions |
| Algoritmos / concurrencia: solo formación académica | Control de stock concurrente con optimistic locking |

**Experiencia previa relevante de Esteban:** Next.js/TypeScript/React, Firebase (Auth, Firestore, Storage), Supabase, Java con Spring Boot en un proyecto grupal de bootcamp (2023, rol: gestión del repo y PRs), MySQL, Git/GitHub. Viene del mundo BaaS — este proyecto es lo opuesto: escribir el backend uno mismo.

**Lo que NO sabe todavía** (tratar como territorio nuevo, explicar despacio): JUnit, Mockito, Testcontainers, Docker, GitHub Actions, PostgreSQL (usó MySQL), Lombok, concurrencia y locking (tiene nociones mínimas), Spring Security a fondo.

**Lo que sí maneja:** CRUD y modelado de datos básico, Git/GitHub, conceptos REST, JavaScript/TypeScript.

---

## 2. STACK TÉCNICO (ya decidido, no reabrir sin motivo)

| Pieza | Elección | Por qué |
|---|---|---|
| Lenguaje | **Java 25 (LTS)** | LTS vigente desde septiembre 2025, sucesora de la 21. No es "la más nueva por moda": es el estándar actual recomendado por Oracle para nuevos proyectos. |
| Framework | **Spring Boot 4.1.0** | Objetivo del proyecto. Ver nota de modularización abajo — es relevante para todo lo que sigue. |
| Build | **Maven** | Ya está en el CV de Esteban; estándar en entornos empresariales tipo BairesDev |
| Base de datos | **PostgreSQL** | Estándar de facto para proyectos nuevos; mejor en joins complejos; default *Read Committed* (vs *Repeatable Read* de MySQL) más adecuado para el escenario de concurrencia |
| ORM | **Spring Data JPA + Hibernate** | — |
| Boilerplate | **Lombok** | Estándar del ecosistema Spring |
| Tests | **JUnit 5 + Mockito** (vía starters modulares de Boot 4, ver abajo) + **Testcontainers** para la parte de concurrencia | — |
| Contenedores | **Docker + docker-compose** | App + Postgres levantan con un comando |
| CI | **GitHub Actions** | Corre los tests en cada push |
| Docs API | **springdoc-openapi** | Estándar actual para Swagger UI en Spring Boot |
| Seguridad | **Spring Security + JWT + BCrypt** | — |

**⚠️ Nota de versión — Spring Boot 4 modularizó los starters (oct/nov 2025):** este proyecto usa el naming **nuevo**, no el clásico. `spring-boot-starter-web` (nombre de Boot 3.x y anteriores) pasó a llamarse **`spring-boot-starter-webmvc`** en Boot 4. Además, cada starter ahora tiene su propio starter de test compañero (`spring-boot-starter-webmvc-test`, `spring-boot-starter-data-jpa-test`, etc.) en vez de un único `spring-boot-starter-test` genérico. Si alguna vez un ejemplo, tutorial o la propia documentación de Spring muestra `spring-boot-starter-web` a secas, es material viejo (Boot 3.x o anterior) — no lo copies literal, traducilo al naming modular.

**Dependencias reales del proyecto** (ya generadas con Spring Initializr):
- `spring-boot-starter-webmvc`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-validation`
- `spring-boot-devtools` (runtime, optional)
- `postgresql` (driver, runtime)
- `lombok` (optional)
- `spring-boot-starter-webmvc-test`, `spring-boot-starter-data-jpa-test`, `spring-boot-starter-validation-test` (test)
- `spring-boot-testcontainers`, `testcontainers-junit-jupiter`, `testcontainers-postgresql` (test)
- Pendientes de agregar en su etapa correspondiente: `springdoc-openapi` (Etapa 1), `spring-boot-starter-security` + librería JWT (Etapa 6)

**Coordenadas del proyecto:**
- groupId: `com.estebancardozo`
- artifactId: `tienda-discos`
- Paquete base: `com.estebancardozo.tiendadiscos`

*(Nota: el paquete base no lleva guion aunque el artifactId sí lo tenga — los paquetes Java no admiten guiones por regla del lenguaje, no por convención. Y va todo en minúsculas, sin excepción, según la guía oficial de convenciones de Oracle.)*

**Decisiones tomadas explícitamente EN CONTRA:**
- **Sin Flyway** — descartado para no inflar el alcance del primer proyecto.
- **Sin CD** — solo CI. La app corre local con Docker Compose; no hay despliegue automático.
- **Sin NoSQL** — el dominio (pedidos + inventario + transacciones) pide ACID y relaciones; además el objetivo es justamente practicar relacional.
- **Sin BaaS (Firebase/Supabase)** — el punto del proyecto es escribir el backend uno mismo.
- **Sin herencia JPA para usuarios** — `Cliente` y `Admin` son entidades independientes (ver §3).

**Despliegue:** local con Docker Compose, costo cero. Opcional más adelante: Render (free tier, app) + Neon (free tier, Postgres). No es parte del alcance actual.

---

## 3. MODELO DE DATOS

Seis entidades. **Esteban diseñó este modelo él mismo** — respetarlo salvo que haya un error real.

```
ARTISTA (1) ──< (N) ALBUM (1) ──< (N) EDICION (1) ──< (N) ITEM (N) >── (1) COMPRA (N) >── (1) CLIENTE
```

### Artista
- `id` (PK)
- `nombre`
- `pais`

### Album
- `id` (PK)
- `titulo`
- `anio`
- `discografica`
- `genero`
- `artista_id` (FK → Artista)

### Edicion
Es **la cosa que realmente se vende**. El Álbum es la obra en abstracto; la Edición es el formato concreto (vinilo, CD, casete), cada uno con su propio stock y precio.
- `id` (PK)
- `nombre` (vinilo / CD / casete / etc.)
- `stock` ← **el campo crítico del proyecto: es el que sufre la concurrencia**
- `precio`
- `album_id` (FK → Album)

### Cliente
- `id` (PK)
- `nombre`, `apellido`, `dni`, `mail`
- `user`, `pass` (hasheada con BCrypt, nunca en texto plano)

### Compra
- `id` (PK)
- `fecha`
- `monto`
- `cliente_id` (FK → Cliente)

### Item
Tabla puente entre Compra y Edición, **con atributos propios** (patrón "association table with attributes").
- `id` (PK)
- `cantidad`
- `precio_unitario` ← se guarda el precio *al momento de la compra*, que puede diferir del precio actual de la Edición
- `compra_id` (FK → Compra)
- `edicion_id` (FK → Edicion)

### Admin
Entidad **independiente** de Cliente (sin herencia, sin tabla compartida).
- `id` (PK)
- `user`, `pass` (BCrypt)
- (campos adicionales a definir cuando se llegue a esa etapa)

**Regla de modelado que Esteban ya aplicó y entendió** (referencia si surge la duda de nuevo): en SQL, la clave foránea vive siempre del lado "muchos". Una celda no puede guardar una lista. Si en Java `Compra` tiene `List<Item> items`, eso es una colección que Hibernate construye al vuelo con `SELECT * FROM item WHERE compra_id = ?` — no una columna física en la tabla `compra`.

---

## 4. REGLAS DE NEGOCIO

- Un pedido (Compra) contiene uno o más Items; cada Item referencia una Edición y una cantidad.
- Al confirmarse una Compra, se descuenta el stock de cada Edición involucrada.
- **El stock nunca puede quedar negativo.** Si dos clientes compran la última unidad al mismo tiempo, una de las dos operaciones debe fallar de forma controlada.
- El catálogo (Artista, Álbum, Edición) es de lectura pública; comprar requiere estar autenticado.
- La gestión del catálogo y del stock es exclusiva del rol Admin.

---

## 5. ORDEN DE TRABAJO (respetar estrictamente)

No saltar etapas. No adelantar. Confirmar con Esteban antes de pasar de una a la siguiente.

### Etapa 1 — Entidades y CRUD
Terreno relativamente conocido para él. Arrancar por `Artista` y `Album` juntas (es donde se prueba el mapeo de la relación, no solo el modelo en papel), después el resto.
- Entidades JPA con anotaciones y relaciones
- Repositories (Spring Data JPA)
- Services y Controllers REST
- DTOs y validación
- springdoc-openapi

### Etapa 2 — Concurrencia (el corazón del proyecto)
- Optimistic locking con `@Version` en `Edicion`
- Manejo de la excepción de conflicto y respuesta HTTP apropiada
- Transacciones (`@Transactional`) en la confirmación de compra

**Punto pedagógico clave:** poner `@Version` toma cinco minutos. Lo que demuestra comprensión real es poder explicar **por qué optimistic y no pessimistic** para este patrón de acceso (mucha lectura, poca escritura), y poder **demostrarlo con un test**. Insistir en eso.

### Etapa 3 — Tests
Ir despacio: territorio completamente nuevo.
- JUnit 5: unitarios de la lógica de negocio
- Mockito: aislar dependencias
- Testcontainers: test de integración que dispara dos hilos comprando la última unidad simultáneamente, y verifica que el stock queda consistente y que una transacción falla como se espera
- Método sugerido: primero un ejemplo trabajado (Claude Code resuelve un caso análogo explicando el razonamiento), después Esteban lo aplica solo al proyecto

### Etapa 4 — Docker
- Dockerfile de la app
- docker-compose con app + PostgreSQL
- Objetivo concreto: que cualquiera pueda levantar todo con un solo comando

### Etapa 5 — CI
- GitHub Actions que corra los tests en cada push
- Badge de build en el README

### Etapa 6 — Seguridad (última, deliberadamente)
Se deja para el final para que la seguridad no tape errores del núcleo durante el desarrollo.
- Spring Security + JWT
- BCrypt para contraseñas
- Roles: CLIENTE y ADMIN
- Endpoints de catálogo públicos; compra autenticada; gestión de catálogo/stock solo ADMIN
- Panel de administración

---

## 6. CONVENCIONES

**Estructura de paquetes: por capa** (decisión explícita de Esteban, ver razonamiento si hace falta recordarlo: agrupar por rol técnico, no por dominio de negocio, para reducir una variable mientras se aprenden el resto de las herramientas nuevas).

```
com.estebancardozo.tiendadiscos
├── controller/   → ArtistaController, AlbumController, EdicionController,
│                    ClienteController, CompraController, AdminController...
├── service/      → un Service por entidad, con la lógica de negocio
├── repository/   → interfaces JpaRepository, una por entidad
├── entity/       → Artista, Album, Edicion, Cliente, Compra, Item, Admin
├── dto/          → objetos de entrada/salida de los controllers (nunca exponer entities)
├── security/     → configuración de Spring Security, JWT (Etapa 6)
├── exception/    → excepciones custom + manejador global (@ControllerAdvice)
└── config/       → configuración general (OpenAPI, etc.)
```

- Nombres de tablas y columnas en **snake_case** (Postgres es case-sensitive con identificadores entre comillas; mixedCase se vuelve un problema).
- **Idioma de los nombres (decidido el 2026-09-01, no reabrir):** *sustantivos del dominio en español, vocabulario técnico y estructural en inglés.*

  | Español (es el negocio) | Inglés (es la herramienta) |
  |---|---|
  | Entidades: `Artista`, `Album`, `Edicion` | Sufijos de capa: `Controller`, `Service`, `Repository` |
  | Atributos: `nombre`, `stock`, `usuario`, `clave` | Verbos de método: `findBy`, `save`, `delete` |
  | Endpoints: `/api/artistas`, `/api/ediciones` | Excepciones: `...NotFoundException` |
  | DTOs: `ArtistaDTO`, `CompraRequest` | Anotaciones y API de Spring |

  Criterio ante la duda: **si la palabra la inventó el dominio, va en español; si viene del framework o del patrón, va en inglés.** Ejemplos: `ArtistaService.findByNombre(String nombre)`, `EdicionNotFoundException`, `GET /api/ediciones/{id}`.

  La mezcla dentro de un mismo identificador (`findByNombre`) es inevitable y está bien: el prefijo lo impone Spring Data, el sufijo tiene que ser el nombre exacto del atributo Java.

- **Nada de `ñ` ni tildes en identificadores**, aunque Java y Postgres los acepten. Se rompen según la codificación de la consola, el log de CI o el contenedor (ver los `?` en los errores de la sesión del 2026-09-01). Por eso el campo de contraseña se llama `clave` y no `contraseña`.

- **Cuidado con las palabras reservadas de SQL al nombrar atributos.** `user` hizo fallar el `CREATE TABLE` de `Admin` y `Cliente` (sesión del 2026-09-01) sin detener el arranque de la app. Lista oficial: https://www.postgresql.org/docs/current/sql-keywords-appendix.html
- Nunca exponer entidades JPA directamente en los controllers: usar DTOs.
- Contraseñas siempre hasheadas, nunca en texto plano, ni siquiera en datos de prueba.
- Commits en Git con mensajes descriptivos (Esteban tiene experiencia gestionando repos y PRs — aprovecharla).

---

## 7. ENTORNO LOCAL — BASE DE DATOS

**El proyecto se desarrolla en dos PCs distintas.** Esta sección existe para que cualquiera de las dos pueda levantar el entorno desde cero. Si estás en una máquina donde nunca se corrió el proyecto, empezá por acá.

### Decisión: Postgres corre en un contenedor, desde la Etapa 1

Se adelantó el uso de Docker respecto del plan (§5, Etapa 4) **solo para la base de datos**. El razonamiento, por si vuelve a discutirse:

- La Etapa 4 no es "usar Docker", es **dockerizar la aplicación** (Dockerfile propio + compose que levante app y base juntas). Correr un Postgres en contenedor como dependencia de infraestructura no toca ese objetivo: en la Etapa 4 se le agrega el servicio `app` al mismo `docker-compose.yml`, no se rehace nada.
- **Testcontainers (Etapa 3) requiere Docker igual.** No hay forma de esquivarlo, así que conviene tenerlo funcionando desde temprano con algo simple.
- Evita instalar y administrar un Postgres nativo, que es conocimiento específico de la distro y poco transferible. Lo que sí es transferible —`psql`, SQL, roles, leer un `EXPLAIN`— se practica igual contra el contenedor.

Esteban preguntó explícitamente si no era más provechoso instalar Postgres a mano. La distinción que zanjó el tema: **Docker le ahorra la *instalación*, no la *configuración*.** Los tres valores del compose (usuario, contraseña, base) son los mismos conceptos que configuraría a mano.

### Requisitos de la máquina (Ubuntu)

Todo sale de los repos de la distro; **no hace falta el repo externo de Docker** ni el snap (el snap corre confinado y da problemas con bind mounts y Testcontainers).

```bash
sudo apt update && sudo apt install -y docker.io docker-compose-v2 postgresql-client
sudo usermod -aG docker $USER
```

Después del `usermod` hay que **cerrar sesión y volver a entrar** — los grupos no se refrescan en sesiones ya abiertas. Es el clásico "lo hice y sigue pidiendo sudo".

Para diagnosticarlo sin adivinar, comparar las dos fuentes:

```bash
groups              # grupos de LA SESIÓN ACTUAL
getent group docker # grupos según EL SISTEMA
```

Si `docker` aparece en el segundo y no en el primero, es exactamente este caso.

**Atajo si no querés cerrar todo** (IDE, navegador, etc.): `newgrp docker` abre una shell con el grupo ya aplicado. Vale **solo para esa terminal** — las demás y el IDE siguen sin el grupo hasta el logout real. Sirve para desbloquearse en el momento; el logout queda para cuando venga cómodo.

> Nota de seguridad, asumida a conciencia: pertenecer al grupo `docker` equivale a tener root permanente sin contraseña (el daemon corre como root y se le puede pedir que monte cualquier ruta del host dentro de un contenedor donde sos UID 0). Aceptable en una máquina personal de desarrollo; nunca en un servidor compartido.

Versiones verificadas en Ubuntu 26.04: Docker 29.1.3, Compose 2.40.3, psql 18.4.

### Requisitos de la máquina (Windows)

En Windows el entorno es **Docker Desktop**, y hay dos diferencias respecto de Ubuntu que ya costaron tiempo (sesión del 2026-09-01):

**1. El daemon no arranca solo.** En Ubuntu Docker es un servicio de systemd; en Windows el daemon vive dentro de Docker Desktop, que es una aplicación de escritorio. **Hay que abrirla a mano** antes de cualquier `docker ...`. Si no está abierta, el síntoma es:

```
failed to connect to the docker API at npipe:////./pipe/dockerDesktopLinuxEngine
```

Eso significa que el cliente `docker` se ejecutó bien pero no encontró al daemon del otro lado del named pipe. No es un problema del proyecto.

**2. ⚠️ Hay un PostgreSQL 18 instalado nativamente que compite por el puerto 5432.**

Es el bug que más tiempo consumió el 2026-09-01. Windows permite que dos procesos escuchen el mismo puerto en distintas interfaces, así que **ninguno de los dos falla al arrancar**: el contenedor levanta, `pg_isready` responde `healthy`, y sin embargo las conexiones que entran desde afuera llegan al Postgres nativo, que no tiene el usuario `tienda`.

Síntoma: `FATAL: password authentication failed for user "tienda"` (`SQLState 28P01`) desde la app, mientras `docker exec -it tienda-discos-db psql -U tienda -d tienda_discos` funciona perfecto.

**Por qué engaña:** Postgres devuelve el mismo mensaje cuando el rol no existe que cuando la contraseña es incorrecta (deliberado, para no filtrar qué usuarios existen). Y `docker exec` entra por el socket local, que el `pg_hba.conf` de la imagen resuelve con `trust` — **nunca verifica la contraseña**, así que no prueba nada.

Diagnóstico:

```powershell
Get-Process -Id (Get-NetTCPConnection -LocalPort 5432 -State Listen).OwningProcess
```

Si aparece un proceso `postgres` además de `com.docker.backend`, es este caso.

Estado actual: **el servicio quedó detenido y en arranque `Manual`** (no desinstalado, no se borró ninguna base):

```powershell
Stop-Service -Name postgresql-x64-18
Set-Service -Name postgresql-x64-18 -StartupType Manual
```

Para revertirlo algún día: `Set-Service ... -StartupType Automatic` y `Start-Service`.

**3. `psql` no está instalado en Windows.** Se usa el del contenedor. Y para probar la conexión *desde afuera* —el camino que recorre la app— hay que levantar un cliente efímero, porque `docker exec` no sirve para eso:

```powershell
docker run --rm -it postgres:18 psql -h host.docker.internal -U tienda -d tienda_discos
```

`host.docker.internal` es el nombre que, en Docker Desktop, resuelve a la máquina host.

### El contrato de credenciales

`docker-compose.yml` (en la raíz del repo) define el servicio `db` con la imagen `postgres:18`. Estos valores **tienen que coincidir exactamente** con `src/main/resources/application.properties`:

| Parámetro | Valor |
|---|---|
| Host / puerto | `localhost:5432` |
| Base | `tienda_discos` |
| Usuario | `tienda` |
| Contraseña | `tienda` |

Contraseña en texto plano a propósito: es una base local de desarrollo. No contradice la regla de hashear con BCrypt las contraseñas de **usuarios** (§6), que sigue vigente.

### Comandos

```bash
docker compose up -d        # levantar en segundo plano
docker compose ps           # estado y healthcheck
docker compose logs -f db   # ver logs
docker compose down         # parar (los datos sobreviven)
docker compose down -v      # parar Y BORRAR el volumen (se pierde la base)

psql -h localhost -U tienda -d tienda_discos                  # conectar desde el host
docker exec -it tienda-discos-db psql -U tienda -d tienda_discos   # conectar desde adentro
```

### ⚠️ Trampa que más tiempo hace perder

Las variables `POSTGRES_USER` / `POSTGRES_PASSWORD` / `POSTGRES_DB` **solo se aplican la primera vez**, cuando la imagen inicializa un volumen vacío. Si después se cambian en el compose y se hace `up`, **no pasa nada**: el volumen ya tiene la base creada con los valores viejos. Para que tome valores nuevos hay que hacer `docker compose down -v` y volver a levantar.

### ⚠️ El path del volumen cambió en Postgres 18

El montaje correcto para `postgres:18` es el **directorio padre**:

```yaml
volumes:
  - postgres_data:/var/lib/postgresql      # ✅ Postgres 18+
# - postgres_data:/var/lib/postgresql/data # ❌ Postgres 17 y anteriores
```

Motivo: en Postgres 18 la imagen oficial cambió `PGDATA` a una ruta específica por versión (`/var/lib/postgresql/18/docker`) y declara el `VOLUME` en el padre. Montar en `/data` —el path de toda la documentación vieja y de casi cualquier tutorial— apunta a un directorio que Postgres 18 **no usa**.

**Por qué es traicionero:** no falla. El contenedor levanta, `pg_isready` responde, podés crear tablas. Pero el volumen nombrado queda vacío y los datos reales van a un **volumen anónimo**, que se pierde en el primer `docker compose down`. Corregido en el commit `e67284c`.

**Lección transferible, más importante que el detalle de Docker:** que un archivo de configuración arranque sin errores no prueba que esté bien. Este bug sobrevivió justamente porque se validó con el criterio "levanta y responde".

### Sincronizar la otra PC

Después de un `git pull` que traiga este fix, **`up -d` no alcanza** si esa máquina ya había levantado el contenedor antes: sigue teniendo el volumen `postgres_data` vacío y volúmenes anónimos huérfanos con los datos viejos. Hay que limpiar:

```bash
docker compose down -v   # borra contenedor + volumen nombrado
docker volume ls         # revisar ANTES de prune (ver advertencia)
docker volume prune      # borra los anónimos huérfanos
```

⚠️ `prune` borra **todos** los volúmenes sin usar de la máquina, no solo los de este proyecto. Si hay otros proyectos con contenedores parados, se llevan puestos sus datos.

*(En la PC Lenovo esto no hizo falta: `docker volume ls` no devolvió ninguna fila, así que nunca se había levantado el contenedor ahí.)*

### Datos

Los datos viven en un volumen Docker con nombre (`postgres_data`), no en el repo. **Las dos PCs no comparten datos**: cada una tiene su propio volumen local. Lo que se sincroniza por Git es el esquema (vía las entidades JPA) y el código, nunca el contenido de las tablas.

Todo lo que necesita la otra PC para levantar un entorno idéntico (nombre del contenedor, credenciales, puerto, imagen) vive dentro del `docker-compose.yml` versionado. No hay nada que configurar a mano: `git pull` y listo.

---

## 8. ESTADO ACTUAL (actualizar al cerrar cada sesión de trabajo)

*Última actualización: 2026-09-01*

### Hecho

- Proyecto generado con Spring Initializr, coordenadas y paquete base renombrados a `com.estebancardozo`.
- **Las 7 entidades JPA están escritas** en `entity/`: `Artista`, `Album`, `Edicion`, `Cliente`, `Compra`, `Item`, `Admin`.
- `docker-compose.yml` con el servicio de Postgres (ver §7), con el path del volumen corregido para Postgres 18 (commit `e67284c`).
- **`application.properties` completo**: datasource + `spring.jpa.hibernate.ddl-auto=create`.
- **`pom.xml`**: `<jvmArguments>-Duser.timezone=UTC</jvmArguments>` en el `spring-boot-maven-plugin`.
- **La app arranca y genera las 7 tablas.** Esquema verificado con `psql` en `artista`, `album` y `edicion`.
- **`Edicion` tiene `@Table(check = @CheckConstraint(constraint = "stock >= 0"))`**, verificado con un `INSERT` que la base rechaza.

### Decisiones de la sesión 2026-09-01 (no reabrir)

- **`ddl-auto=create`** para la Etapa 1. Descartados: `update` (nunca borra ni modifica columnas, arrastra el esquema viejo tras cada rename) y `validate` (no crea nada, y la base estaba vacía). `create` en vez de `create-drop` para poder inspeccionar el DDL con `psql` después de apagar la app. **Revisar esta elección al llegar a la Etapa 3** (tests) y a la 6.
- **Zona horaria UTC** en la JVM. Se guardan instantes absolutos; la conversión a hora local es problema del cliente.
- **Idioma de identificadores** → ver §6, ya documentado.

### Pendiente inmediato

1. **Commit de todo lo anterior** — al cierre de la sesión seguía sin versionar.
2. Revisar el DDL de las 4 tablas que faltan: `item`, `compra`, `cliente`, `admin`. `item` es la más interesante (tabla puente con dos FKs y `precio_unitario`).
3. Resto de la Etapa 1: repositories → services → controllers → DTOs y validación → springdoc-openapi. Ninguna de esas carpetas existe todavía.

### Deuda pedagógica

- ~~`docker-compose.yml` escrito por Claude~~ → SALDADA el 2026-08-12. **Pero no se da por dominado**: en la Etapa 4, cuando toque agregar el servicio `app`, **que lo escriba él desde cero sin mirar el actual**.
- ~~`BigDecimal` para `precio` lo recomendó Claude sin explicar el porqué~~ → SALDADA el 2026-09-01 (IEEE 754, acumulación de error, demostrado con `SELECT 0.1::float8 + 0.2::float8`). Queda pendiente de aparecer en la práctica: **`BigDecimal` se compara con `compareTo()`, no con `equals()`** — avisar cuando escriba tests (Etapa 3).
- Docker: cubierto el vocabulario mínimo (imagen / contenedor / daemon / volumen), el grupo `docker`, `ports`/`volumes` y los tipos de volumen. Nada más.
- **`@Version` y optimistic locking (Etapa 2): el terreno ya está preparado.** El 2026-09-01 razonó solo el escenario de *lost update* con dos hilos y entendió que el `CHECK` no lo detecta (los dos escriben 0, nunca -1). Retomar desde ahí, no desde cero.

### Cómo trabaja Esteban — patrones observados

- **Saltea las preguntas de verificación.** Varias veces respondió la salida de un comando en vez de la pregunta, o directamente pasó de largo. Hay que repreguntar explícitamente; no darlo por entendido porque siguió adelante.
- **Pide el código hecho antes que intentarlo** (ver regla 1.b). Aceptable para sintaxis; **no** para decisiones de diseño — ahí hay que hacerlo elegir y justificar.
- **Vuelve a preguntar comandos ya dados** (`docker compose up`, entrar a `psql`). Los está juntando en `bd.txt`; conviene apuntarlo ahí y, más adelante, al README.
- **Al explicar mecanismos, atribuye intención al sistema** ("quiere protegerme") en vez de describir el mecanismo ("la base vive en otro proceso"). Empujarlo al mecanismo cada vez.
- Usó "deprecado" correctamente el 2026-09-01 (era una confusión anterior). Detectó él mismo el aviso de deprecación de `@Check`.

### Errores conceptuales corregidos (vigilar si reaparecen)

- Creyó que **`not null` garantiza que el stock no sea negativo**. Son tres cosas distintas: existencia del valor (`not null`), tipo (`integer`) y rango (`CHECK`).
- Creyó que **`validate` valida y después aplica**. No aplica nunca nada.
- Confusión de capas: preguntó si `create-drop` era "algo de Docker o de Postgres". Es de Hibernate. Ante cualquier comportamiento raro, insistir en la pregunta **"¿quién lo hace?"** antes que "¿dónde pasa?".
- De sesiones anteriores: dirección vs. puerto, "nombre del puerto", contenedor vs. volumen.

### Hilo conductor de la sesión 2026-09-01 (sirve como material de futuras explicaciones)

Cuatro bugs, **todos con el mismo patrón: el sistema arranca, responde, y está mal.**

1. `ddl-auto` sin definir → default `none` en bases no embebidas; la app arrancaba sin crear tablas.
2. **Un PostgreSQL 18 nativo de Windows competía por el puerto 5432** con el contenedor (ver §7).
3. `invalid value for parameter "TimeZone"` — Windows reporta el alias obsoleto `America/Buenos_Aires`, que Postgres 18 no conoce.
4. `user` es palabra reservada de SQL → el `CREATE TABLE` de `admin` y `cliente` falló **como `WARN`, sin detener el arranque**; quedaron 5 de 7 tablas.

El método que funcionó y conviene sostener: **predecir antes de mirar**, y **verificar por el camino que falla**, no por otro (el `docker exec ... psql` entraba por `trust` y no probaba nada sobre la contraseña).