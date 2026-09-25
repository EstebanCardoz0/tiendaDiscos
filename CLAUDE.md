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
12.b. **Datos de ejemplo:** usar **Red Hot Chili Peppers, Jamiroquai y Rage Against the Machine** (y sus discos) en los `curl` de prueba, fixtures y ejemplos, en vez de bandas genéricas. *(Pedido explícito de Esteban, 2026-09-25.)*
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

### Etapa 7 — Pagos con Mercado Pago (agregada el 2026-09-11)

Va **después del CI**, deliberadamente. Es un *plus* sobre un proyecto terminado: no cubre ningún hueco del CV (§1) y compite por tiempo con las etapas que sí los cubren. Un checkout funcionando sin un solo test dice lo contrario de lo que el proyecto quiere decir.

- Crear la preferencia de pago (llamada HTTP saliente hacia la API de MP)
- Endpoint de webhook: MP hace un `POST` a una URL propia cuando cambia el estado del pago
- **Idempotencia del webhook**: MP reintenta si no recibe `200` a tiempo; el mismo aviso puede llegar varias veces y el stock no puede descontarse más de una vez
- Verificar que el aviso viene de MP (el endpoint es público por necesidad)
- Sandbox con usuarios y tarjetas de prueba. En desarrollo el webhook no llega a `localhost`: hace falta un túnel (ngrok), cuya URL cambia en cada reinicio

**Lo que se adelanta a la Etapa 1** (barato hoy, carísimo después): ver la decisión del flujo de compra en §8.

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

  Criterio ante la duda: **si la palabra la inventó el dominio, va en español; si viene del framework o del patrón, va en inglés.** Ejemplos: `ArtistaService.findByNombre(String nombre)`, `GET /api/ediciones/{id}`.

  *Aplicación del criterio, decidida el 2026-09-16:* las excepciones del proyecto terminaron **enteramente en inglés** (`NotFoundException`, `InvalidReferenceException`), porque son genéricas y ningún sustantivo del dominio aparece en el nombre — la entidad viaja como parámetro. La forma mixta (`EdicionNotFoundException`) sería la correcta si hubiera una excepción por entidad, que es justamente lo que se descartó (ver §8).

  La mezcla dentro de un mismo identificador (`findByNombre`) es inevitable y está bien: el prefijo lo impone Spring Data, el sufijo tiene que ser el nombre exacto del atributo Java.

- **Nada de `ñ` ni tildes en identificadores**, aunque Java y Postgres los acepten. Se rompen según la codificación de la consola, el log de CI o el contenedor (aparecen como `?` en los mensajes de error). Por eso el campo de contraseña se llama `clave` y no `contraseña`.

- **Cuidado con las palabras reservadas de SQL al nombrar atributos.** `user` hizo fallar el `CREATE TABLE` de `Admin` y `Cliente` sin detener el arranque de la app. Lista oficial: https://www.postgresql.org/docs/current/sql-keywords-appendix.html
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

Si vuelve la duda de si no convenía instalar Postgres a mano, la distinción que zanja el tema: **Docker ahorra la *instalación*, no la *configuración*.** Los tres valores del compose (usuario, contraseña, base) son los mismos conceptos que se configurarían a mano.

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

### Requisitos de la máquina (Windows)

En Windows el entorno es **Docker Desktop**, con dos diferencias respecto de Ubuntu que ya costaron tiempo:

**1. El daemon no arranca solo.** En Ubuntu Docker es un servicio de systemd; en Windows el daemon vive dentro de Docker Desktop, que es una aplicación de escritorio. **Hay que abrirla a mano** antes de cualquier `docker ...`. Si no está abierta, el síntoma es:

```
failed to connect to the docker API at npipe:////./pipe/dockerDesktopLinuxEngine
```

Eso significa que el cliente `docker` se ejecutó bien pero no encontró al daemon del otro lado del named pipe. No es un problema del proyecto.

**2. ⚠️ Hay un PostgreSQL 18 instalado nativamente que compite por el puerto 5432.**

Windows permite que dos procesos escuchen el mismo puerto en distintas interfaces, así que **ninguno de los dos falla al arrancar**: el contenedor levanta, `pg_isready` responde `healthy`, y sin embargo las conexiones que entran desde afuera llegan al Postgres nativo, que no tiene el usuario `tienda`.

Síntoma: `FATAL: password authentication failed for user "tienda"` (`SQLState 28P01`) desde la app, mientras `docker exec -it tienda-discos-db psql -U tienda -d tienda_discos` funciona perfecto.

**Por qué engaña:** Postgres devuelve el mismo mensaje cuando el rol no existe que cuando la contraseña es incorrecta (deliberado, para no filtrar qué usuarios existen). Y `docker exec` entra por el socket local, que el `pg_hba.conf` de la imagen resuelve con `trust` — **nunca verifica la contraseña**, así que no prueba nada.

Diagnóstico:

```powershell
Get-Process -Id (Get-NetTCPConnection -LocalPort 5432 -State Listen).OwningProcess
```

Si aparece un proceso `postgres` además de `com.docker.backend`, es este caso.

**El servicio está detenido y en arranque `Manual`** (no desinstalado, no se borró ninguna base). Así quedó:

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

**Probar endpoints desde PowerShell:** `curl` es un **alias de `Invoke-WebRequest`**, no el programa — los flags estilo curl (`-H`, `-d`, `-X`) fallan con un error de enlace de parámetros. Hay que invocar el binario real y frenar el parseo de PowerShell con `--%`:

```powershell
curl.exe --% -i -X POST http://localhost:8080/api/artistas -H "Content-Type: application/json" -d "{\"nombre\":\"Blur\",\"pais\":\"Reino Unido\"}"
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

**Por qué es traicionero:** no falla. El contenedor levanta, `pg_isready` responde, podés crear tablas. Pero el volumen nombrado queda vacío y los datos reales van a un **volumen anónimo**, que se pierde en el primer `docker compose down`.

**Lección transferible, más importante que el detalle de Docker:** que un archivo de configuración arranque sin errores no prueba que esté bien. Este bug sobrevivió justamente porque se validó con el criterio "levanta y responde".

### Sincronizar la otra PC

Si una máquina había levantado el contenedor **antes** del fix del path del volumen, `up -d` no alcanza: sigue teniendo el volumen `postgres_data` vacío y volúmenes anónimos huérfanos con los datos viejos. Hay que limpiar:

```bash
docker compose down -v   # borra contenedor + volumen nombrado
docker volume ls         # revisar ANTES de prune (ver advertencia)
docker volume prune      # borra los anónimos huérfanos
```

⚠️ `prune` borra **todos** los volúmenes sin usar de la máquina, no solo los de este proyecto. Si hay otros proyectos con contenedores parados, se llevan puestos sus datos. Si `docker volume ls` no devuelve ninguna fila, no hay nada que limpiar.

### Datos

Los datos viven en un volumen Docker con nombre (`postgres_data`), no en el repo. **Las dos PCs no comparten datos**: cada una tiene su propio volumen local. Lo que se sincroniza por Git es el esquema (vía las entidades JPA) y el código, nunca el contenido de las tablas.

Todo lo que necesita la otra PC para levantar un entorno idéntico (nombre del contenedor, credenciales, puerto, imagen) vive dentro del `docker-compose.yml` versionado. No hay nada que configurar a mano: `git pull` y listo.

---

## 8. ESTADO ACTUAL (actualizar al cerrar cada sesión de trabajo)

> **Qué va acá y qué no.** Este archivo es contexto para Claude, no una bitácora de desarrollo. Va lo que **trasciende la sesión**: decisiones tomadas y su porqué, qué falta, qué no está dominado, patrones de trabajo. **No** van hashes de commits, salidas de comandos, narraciones de qué se hizo cada día ni fechas de cada cambio — eso ya está en el historial de Git.

### Qué existe

`entity/` (las 7) · `repository/` (las 7, interfaces vacías) · `service/` (`ArtistaService`, `AlbumService`) · `controller/` (`ArtistaController`, `AlbumController`) · `dto/` (`ArtistaRequest`, `ArtistaResponse`, `AlbumRequest`, `AlbumResponse`) · `exception/` (`NotFoundException`, `InvalidReferenceException`, `GlobalExceptionHandler`) · `docker-compose.yml` · `application.properties`.

**`Album` está cerrado de punta a punta salvo springdoc**, y los cinco endpoints se probaron **ejecutándolos**, no leyéndolos: `POST` con `201` + `Location` y los seis campos con valor, `GET` de la colección y por id, `PUT` con `200`, `DELETE` con `204` **seguido de un `GET` que devuelve `404`** (el `204` sale del controller y no prueba que la fila se haya borrado — en este proyecto ya hubo un `delete` que no borraba). También se ejecutaron los tres caminos de error: `404` por id en la URL, `422` por `artistaId` inexistente en el cuerpo, y `400` de validación con el mapa `errores`.

**`Artista` está cerrado de punta a punta** y probado con `curl`: `GET` de la colección, `GET` por id, `POST` con `201` y `Location`, `PUT`, `DELETE` con `204`, el `404` traducido a `ProblemDetail`, DTOs de entrada y salida en los cinco endpoints, y validación con `400` + detalle por campo. Es el corte vertical de referencia: replicar esa forma en las otras seis entidades.

**springdoc-openapi** (`3.1.1`, la línea que soporta Boot 4 — la `2.x` es de Boot 3) sirve Swagger UI en `/swagger-ui.html` y el documento en `/v3/api-docs`. Los cinco endpoints de `Artista` están anotados; el título de la API sale de un `@OpenAPIDefinition` en `TiendaDiscosApplication`.

No existe todavía: `config/`.

### Decisiones vigentes (no reabrir)

**De configuración:**

- **`ddl-auto=create`** para la Etapa 1. Descartados: `update` (nunca borra ni modifica columnas, arrastra el esquema viejo tras cada rename) y `validate` (no crea nada). `create` en vez de `create-drop` para poder inspeccionar el DDL con `psql` después de apagar la app. **Revisar esta elección al llegar a la Etapa 3** (tests) y a la 6.
- **Zona horaria UTC** en la JVM (`-Duser.timezone=UTC` en el `spring-boot-maven-plugin`). Se guardan instantes absolutos; la conversión a hora local es problema del cliente.
- **Idioma de identificadores** → ver §6.

**Del flujo de compra** (decidido el 2026-09-11, diseñado enteramente por Esteban vía preguntas; ver Etapa 7 en §5):

El pago con Mercado Pago es **asincrónico**: entre que el cliente arranca el checkout y se sabe si pagó pasan minutos, o no se sabe nunca. `Compra` se escribe **ya con esta forma**, aunque la integración llegue en la Etapa 7 — meter estados a un flujo de compra ya escrito y testeado es reescribirlo.

| Decisión | Alternativa descartada y por qué |
|---|---|
| **Reserva de stock**: columna `reservado` (entero) en `edicion`. Disponible = `stock - reservado` | Un booleano `no_disponible`: es **derivado** de esos dos números, y guardar lo derivado permite que la base acepte filas contradictorias que ningún `if` impide. Se guarda lo que no se puede recalcular (como `Item.precio_unitario`), no lo que sí |
| El `stock` se descuenta **solo al acreditarse el pago**; antes solo sube `reservado` | Descontar al crear la compra: el que abandona el checkout se lleva stock real |
| **`enum` de estado** en `Compra`, con `@Enumerated(EnumType.STRING)`: `RESERVADA`, `EN_VERIFICACION`, `CONFIRMADA`, `RECHAZADA`, `EXPIRADA` | (a) `boolean pagada`: tres situaciones distintas comprimidas en el mismo `false`. Cuando un booleano necesita un tercer valor, no va un segundo booleano. (b) `ORDINAL`: guarda la posición, reordenar el enum corrompe los datos viejos en silencio |
| Criterio para admitir un estado: **hay un evento observable que lleva a él y un comportamiento distinto en él** | Se cayó `PAGADA` ("el cliente envió el pago"): ningún canal informa eso. La app solo observa tres cosas — un request de su cliente, un webhook de MP, y su reloj |
| La reserva vencida la libera una **tarea programada** (`@Scheduled` + `@EnableScheduling`) que pasa a `EXPIRADA` | Esperar un request que no va a llegar (el cliente cerró la pestaña). Un timeout no se espera: se verifica. Un hilo que pregunta cada minuto, no mil hilos dormidos |
| **`@Version` en `Edicion`**, igual que antes | El conflicto se adelantó de `stock` a `reservado`, pero `@Version` protege **la fila**, no la columna. Y mejora el escenario de la Etapa 2: dos personas apretando "comprar" a la vez es más frecuente que dos webhooks simultáneos |

**De las excepciones** (decididas el 2026-09-16; reemplazan lo que antes se anotó como `ReferenciaInvalidaException`):

Quedan **dos clases, genéricas, y no crecen más** — no hay una excepción por entidad. Las dos reciben `(String entity, Long id)` y arman su propio mensaje ("No se encontró X con el id N"):

| Clase | Status | Cuándo |
|---|---|---|
| `NotFoundException` | `404` | El id ausente venía en la **URL** (`GET /api/albumes/7`) |
| `InvalidReferenceException` | `422` | El id ausente venía en el **cuerpo** (`POST /api/albumes` con `artistaId` inexistente) |

| Decisión | Alternativa descartada y por qué |
|---|---|
| Una `NotFoundException` genérica en vez de siete (`ArtistaNotFoundException`, `AlbumNotFoundException`, …). `ArtistaNotFoundException` **se borró** | Siete clases solo valen la pena si alguien las distingue: un `catch` o un `@ExceptionHandler` que haga algo diferente con cada una. Como las siete dan el mismo `404` con el mismo cuerpo, el handler terminaría con siete métodos idénticos — un concepto escrito siete veces. **Ojo con la justificación: no es "ahorrar código"** (siete clases de cinco líneas no son un problema de volumen). El criterio es *unificar cuando la repetición no representa una diferencia real* |
| Que sigan siendo **dos** y no una sola | Tienen el cuerpo casi idéntico, pero el handler las manda a códigos distintos. Que el `detail` diga lo mismo es aceptable: toda la información que las separa viaja en el `status` |
| El nombre de la entidad como **literal** (`new NotFoundException("Artista", id)`) | `Artista.class.getSimpleName()`: recupera la verificación del compilador, pero ata el texto de cara al cliente al nombre de la clase Java — renombrar una entidad es refactor interno y no debería cambiar una respuesta HTTP. **Costo asumido: un typo en el literal no lo detecta nadie.** Ya pasó (`"Arista"`): compila, arranca, devuelve el `422` correcto y manda una palabra inventada |
| Nombres de clase en **inglés** (`NotFoundException`, `InvalidReferenceException`) | `ReferenciaInvalidaException`: "referencia inválida" no es vocabulario de una disquería, es vocabulario de programación. La regla de §6 lo manda a inglés. En `EdicionNotFoundException` el español era `Edicion`, que sí es del dominio — al desaparecer la entidad del nombre, desaparece el español |
| `HttpStatus.UNPROCESSABLE_CONTENT` | `UNPROCESSABLE_ENTITY`: las dos existen en `spring-web` 7 y valen 422, pero el RFC 9110 renombró el status a "Unprocessable Content" en 2022 |

**De la capa service** (decididas sobre `ArtistaService`, son la plantilla para los otros seis):

| Decisión | Alternativa descartada y por qué |
|---|---|
| Inyección por **constructor**, campo `final` | `@Autowired` sobre el campo: obliga a *reflection* para instanciar la clase en un test unitario. Con constructor, el test es `new ArtistaService(mock)`. Además el `final` garantiza no-null por el lenguaje, no por Spring |
| Sin `@Autowired` en el constructor | Innecesario con un único constructor (doc oficial). Sí hace falta si hay varios |
| Excepción `extends RuntimeException` | *Checked*: obligaría a `throws` en todas las firmas hacia arriba para algo de lo que nadie puede recuperarse. Mismo criterio que la jerarquía `DataAccessException` de Spring |
| La excepción arma su propio mensaje (el constructor recibe los datos crudos, hoy `(String entity, Long id)`) | Recibir el `String` ya armado: el texto se duplica en cada `throw` y se desincroniza. Importa porque ese mensaje no se queda en el log — termina en el `detail` del `ProblemDetail` que lee el cliente |
| El mensaje evita el artículo: **"No se encontró X con el id N"** | "el X con el id N no fue encontrado": al ser `X` un parámetro, el artículo no puede concordar en género — sale "el Edicion", "el Compra". Es el costo de generalizar: lo que se vuelve parámetro deja de poder influir en el resto de la frase. La voz pasiva refleja lo esquiva |
| `findById` devuelve `Artista` o lanza | Devolver `Optional` (válida, pero obliga a repetir el desenvuelto en cada controller) y devolver `null` (descartada: el tipo miente y el NPE aparece lejos del origen) |
| `PUT` con **reemplazo total** | Actualización parcial: al deserializar JSON, `null` no distingue "campo ausente" de "borrá este campo". Si se quiere parcial de verdad, va un `PATCH` aparte |
| `update` toma `(Long id, Artista)` y hace `setId(id)` | El id del cuerpo: la URL manda. Sin el `setId`, `save` inserta una fila nueva |
| `delete` verifica y lanza `404` | Silencio idempotente. Descartado: el catálogo es público (§4), no hay enumeración de recursos que ocultar. La idempotencia del RFC 9110 es sobre el **estado del servidor**, no sobre el código de respuesta |
| Retornos sin texto de interfaz (`void` en `delete`) | Devolver `"Artista borrado exitosamente"`: el service no sabe que HTTP existe |

**De los services con FK** (decididas sobre `AlbumService`, el 2026-09-16; son la plantilla para `Edicion`, `Compra` e `Item`):

| Decisión | Alternativa descartada y por qué |
|---|---|
| El service recibe **la entidad a medio armar más el id crudo**: `save(Album album, Long idArtista)`, `update(Long id, Album album, Long idArtista)` | (a) `save(Album album)` como en `Artista`: el controller no puede completar `album.setArtista(...)` porque tiene un `Long` y la entidad espera un `Artista`, y resolverlo exigiría darle un repositorio al controller. (b) `save(AlbumRequest request)`: ata el service a la capa web — ningún test ni job podría usarlo sin fabricar objetos HTTP |
| El service **necesita un repositorio por cada FK que resuelve**: `AlbumService` inyecta `AlbumRepository` + `ArtistaRepository` | Que un service dependa de más de un repositorio no es olor a diseño: la operación "crear álbum" toca dos tablas. Escala hacia arriba — `CompraService` va a necesitar tres o cuatro |
| `save`/`update` **completan la entidad recibida** (`album.setArtista(artista)`) | Construir un `Album` nuevo copiando campo por campo: duplica la lista de campos. Cuando la entidad gane uno, hay que acordarse de agregarlo también ahí — compila igual y el campo llega `null` a la base. Es el patrón "todos menos uno" institucionalizado en el código. (Y `@AllArgsConstructor` incluye el `id`, así que el constructor tiene un parámetro más de los que uno cuenta) |
| Vocabulario de métodos **distinto por capa**: controller `getAll/getById/create/update/delete` (verbos HTTP), service `findAll/findById/save/update/delete` (verbos de persistencia, los de `JpaRepository`) | Usar los mismos en las dos: los nombres son la primera barrera contra que el service empiece a devolver DTOs y códigos de estado. Que `update` y `delete` coincidan en ambas capas no invalida la regla |

**De la capa controller y del manejo de errores:**

| Decisión | Por qué |
|---|---|
| URL = recurso, nunca acción: `/api/artistas`, en plural, sin verbos | El verbo lo aporta el método HTTP. `/artistas/get` lo duplica y habilita absurdos como `POST /artistas/get` |
| `@GetMapping` pelado, nunca `@GetMapping("/")` | Desde Spring Framework 6 el *trailing slash matching* está en `false`: con `"/"` la ruta pasa a ser `/api/artistas/` y `/api/artistas` devuelve `404` |
| `POST` devuelve `201` + cabecera `Location` | El `200` no dice que se haya creado nada. El `Location` evita que el cliente tenga que hurgar el JSON para saber dónde quedó el recurso |
| La URI del `Location` sale de `ServletUriComponentsBuilder.fromCurrentRequest()` | Escribirla a mano duplica la ruta que ya está en `@RequestMapping`: si cambia, la cabecera miente sin que nada falle |
| `DELETE` devuelve `204` sin cuerpo | No hay nada que devolver; el estado lo dice todo |
| Errores como `ProblemDetail` (RFC 9457), no como `String` | Devolver texto hace que la API conteste JSON cuando todo va bien y `text/plain` cuando falla: el cliente se rompe justo en el caso de error |
| **`404` solo cuando el id ausente está en la URL; `422` cuando está en el cuerpo** (decidido el 2026-09-15 sobre `POST /api/albumes` con un `artistaId` inexistente) | (a) `404` para los dos: con `POST /api/albumes` el *target resource* del RFC 9110 **existe** — el cliente no puede distinguir "te equivocaste de endpoint" de "el id del body no apunta a nada". (b) `400`: ya está ocupado por `MethodArgumentNotValidException`, y con su propia forma (la propiedad `errores`); reusarlo obliga al cliente a mirar el cuerpo para saber cuál de los dos le tocó. El criterio que los separa: el `400` se detecta leyendo el request, el `422` requiere ir a la base |

**De la capa DTO y la validación** (decididas sobre `Artista`, son la plantilla para las otras seis):

| Decisión | Alternativa descartada y por qué |
|---|---|
| **Dos DTOs** por entidad: `ArtistaRequest` (entra: `nombre`, `pais`) y `ArtistaResponse` (sale: `id`, `nombre`, `pais`) | Uno solo: el `id` es **obligatorio** en la salida (sin él el cliente no puede armar ninguna URL) e **imposible** en la entrada (el cliente no puede saber un id que Postgres no generó todavía). Un campo así no cabe en una clase sin mentir en uno de los dos contratos |
| DTOs como `record`, sin Lombok | Clase con `@Getter`/`@Setter`: los records ya dan campos `final`, constructor canónico, accessors y `equals`/`hashCode`. Las entidades sí siguen con Lombok porque JPA exige constructor vacío y campos mutables |
| Lista blanca: el `id` **no existe** como componente de `ArtistaRequest` | `artista.setId(null)` en el controller o `@JsonIgnore` en la entidad: tapan el agujero del `id` enumerando prohibiciones, y meten anotaciones de la capa web dentro de la entidad. Sin componente, Jackson no tiene dónde poner el valor — cerrado por construcción |
| `@NotBlank` sobre `nombre` (no `@NotNull` ni `@NotEmpty`) | Las otras dos aceptan `"   "`, que no sirve como nombre de artista |
| El `PUT` reusa `ArtistaRequest` | Un DTO propio: al ser reemplazo total, el `PUT` pide los mismos campos con las mismas reglas que el `POST`. **Si alguna vez se agrega un `PATCH`, ese sí necesita el suyo**: ahí `@NotBlank` sería incorrecto, porque "campo ausente" significaría "dejalo como está" |
| El mapeo vive en el **controller** (`private ArtistaResponse toResponse(Artista)`) | (a) Que el service reciba/devuelva DTOs: lo ataría a HTTP y ningún job ni test podría usarlo sin fabricar objetos de la capa web. (b) Un `ArtistaResponse.from(artista)` estático: obligaría al DTO a importar la entidad. (c) `ArtistaMapper`/MapStruct: resuelve el problema de otra escala — se sube a eso cuando aparezca un segundo consumidor del mapeo, no antes |
| Errores de validación → `ProblemDetail` con propiedad extra `errores` (mapa campo → mensaje) | Devolver solo el primer error: el validador ya los detectó todos, y un formulario con tres campos malos obligaría a tres viajes al servidor |
| Usar siempre el **retorno** de `save()`, nunca el objeto que se le pasó | La javadoc lo pide explícitamente. Hoy "funciona" leer el argumento porque `persist()` muta la instancia, pero `merge()` devuelve **otra** y la original queda detached |

**De los DTOs con relaciones** (decididas sobre `Album`, el 2026-09-15; son la plantilla para `Edicion`, `Compra` e `Item`):

`Request` y `Response` **no son simétricos**, y las FKs son donde eso se ve. Identificar y mostrar son trabajos distintos.

| Decisión | Alternativa descartada y por qué |
|---|---|
| **Entra el id plano**: `AlbumRequest` lleva `Long artistaId` | El nombre del artista: no identifica (nada impide dos filas "Blur" — ver pendiente 3) y además es mutable, así que una referencia por nombre queda apuntando a nada tras un rename. El id no cambia nunca, y el cliente ya lo tiene: se lo dio el `ArtistaResponse` de cualquier `GET` anterior |
| **Sale el DTO anidado**: `AlbumResponse` lleva `ArtistaResponse artista` | (a) Solo `artistaId`: un cliente que lista 20 álbumes necesita 20 requests más para poder escribir "Blur" en pantalla. (b) Solo `String artista` (el nombre): puede mostrarlo pero no linkear a `/api/artistas/7`, ni filtrar, ni navegar — el mismo argumento que puso el `id` en `ArtistaResponse`. (c) Campos planos (`artistaId` + `artistaNombre`): **no escala** — en `EdicionResponse` obliga a `albumId`, `albumTitulo` y `albumArtistaNombre`, con dos niveles de prefijo. Anidado, `EdicionResponse` lleva un `AlbumResponse` y listo |
| Anidar `ArtistaResponse` **no es un problema de seguridad** | Es un DTO, no la entidad, y sus tres campos son públicos por §4 (el catálogo se lee sin autenticar). El riesgo real de anidar es **acoplamiento** (un campo nuevo en `ArtistaResponse` aparece solo en todos los `AlbumResponse`), que es otra cosa. Donde el reflejo de "no exponer" sí va a valer es en `ClienteResponse`, por `clave` |
| El tipo del componente lo manda el dominio, no la anotación disponible | Pasó al revés: `anio` se declaró `String` para poder usarle `@NotBlank`. Un `String` acepta `"mil novecientos noventa y cuatro"`, pasa la validación, y explota al convertirlo en el service. Cuando una anotación "no compila" sobre un tipo, la anotación es la equivocada |
| `@NotNull` para todo lo que no es texto (`Integer anio`, `Long artistaId`); `@NotBlank` solo sobre `String` | `@NotBlank` sobre un `Integer` **compila** (verificado): el compilador solo mira que la anotación esté en un lugar permitido. El tipo lo valida Hibernate Validator en runtime → `UnexpectedTypeException: HV000030` → `500` en el primer `POST` |

**De la documentación de la API** (decididas sobre `Artista`, son la plantilla para las otras seis):

Springdoc genera el documento por **análisis estático**: lee tipos y anotaciones, nunca ejecuta el método. Todo lo que este proyecto desacopló a propósito le queda invisible — el status vive dentro del `ResponseEntity`, el `404` vive en el `GlobalExceptionHandler`, la propiedad `errores` se agrega con `setProperty` en runtime, y el aplanado del JSON lo decide `ProblemDetailJacksonMixin`, no la clase `ProblemDetail`. Por eso lo inferido hay que corregirlo **a mano**, y esa corrección es duplicación que puede desincronizarse sin que nada falle.

| Decisión | Alternativa descartada y por qué |
|---|---|
| Criterio de qué anotar: **solo lo que cambia el código que el cliente tiene que escribir** (el `201` + `Location`, el `204`, los `404`, los `400` de validación) | (a) No anotar nada: la doc anuncia `200` donde el código devuelve `201`/`204`, y omite todos los errores. (b) Anotar todo: veinte anotaciones que repiten obviedades son pasivo puro — nadie las revisa cuando cambia el código. `GET /api/artistas` no lleva ninguna, porque lo inferido ya es correcto |
| Declarar `content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class))` en cada `4xx` | Declarar el código sin `content`: springdoc rellena con el tipo de retorno del método y documenta un `ArtistaResponse` como cuerpo del error. **Anotar a medias empeora la mentira**: antes omitía el `404`, después lo afirmaba con un cuerpo falso |
| El `400` queda con el schema genérico de `ProblemDetail`, sin mostrar `errores` | Un DTO propio de error solo para la documentación: crea una segunda fuente de verdad que hay que sincronizar a mano con el handler, para ganar precisión únicamente en un *ejemplo*. El contrato (`problem+json`) ya es correcto |
| Metadata (título, versión) con `@OpenAPIDefinition` sobre `TiendaDiscosApplication` | Un `@Bean OpenAPI` en `config/`: una clase entera para tres strings. No hay propiedad de `application.properties` que lo haga |

⚠️ Dos `@ApiResponse` con el mismo `responseCode` **no dan error de compilación**: el documento OpenAPI es un mapa por código, así que el segundo pisa al primero en silencio. Ya pasó una vez.

### Pendiente inmediato

1. Las otras seis entidades, replicando el corte vertical de `Artista` (service → controller → DTOs → excepción → método en `GlobalExceptionHandler` → anotaciones de springdoc). **`Compra` y `Edicion` arrastran la decisión del flujo de compra** (enum de estado, `reservado`, `@Version`): no escribirlas sin leerla.
2. **Las anotaciones de springdoc de `AlbumController`** — el arranque de la próxima sesión, y lo único que le falta a `Album`. Es una pasada entera por su cuenta: se dejó deliberadamente para empezarla fresco, porque springdoc es lo que más lo satura (§ patrones). La consigna acordada sigue en pie: **sin mirar `ArtistaController`**.
3. **Pendiente del manejo de errores**: `GlobalExceptionHandler` atiende `NotFoundException`, `InvalidReferenceException` y `MethodArgumentNotValidException`. Cualquier **otra** excepción sigue terminando en `500` con el stack trace en el cuerpo (lo activa `spring-boot-devtools` con `server.error.include-stacktrace=always`).
4. **Sin restricción de unicidad en ningún lado.** Hoy se pueden crear cincuenta artistas llamados "Blur". Si se decide que `nombre` sea único, va en la columna (`@Column(unique = true)`), no en un `if` del service: entre el `SELECT` y el `INSERT` hay una ventana de carrera — el mismo problema que la Etapa 2 ataca con el stock.

### Deuda pedagógica (lo que NO está dominado)

- **`docker-compose.yml`**: lo escribió Claude. En la Etapa 4, cuando toque agregar el servicio `app`, **que lo escriba él desde cero sin mirar el actual**.
- ~~**`ArtistaService.update()`**~~ **SALDADA (2026-09-16).** Escribió `AlbumService.update` completo y solo, sin mirar el de `Artista`, con la estructura correcta (verificar existencia → `setId` → resolver FK → `save`). El único error fue de excepción, no de estructura (ver abajo).
- **Docker**: solo el vocabulario mínimo (imagen / contenedor / daemon / volumen), el grupo `docker`, `ports`/`volumes`. Nada más.
- **`BigDecimal` se compara con `compareTo()`, no con `equals()`** — avisar cuando escriba tests (Etapa 3).
- **`GlobalExceptionHandler`**: se trabó y pidió el código hecho ("no entiendo nada lo que me pedís"). Territorio nuevo — `@RestControllerAdvice` y `@ExceptionHandler` no los había visto nunca. **Parcialmente saldada (2026-09-16):** escribió el handler de `InvalidReferenceException` mirando el molde y migró el del `404`, los dos sin errores. Falta que escriba uno **sin mirar** el de al lado.
- **Java vs. JavaScript en el nivel de la sintaxis**: escribió `` super(`No se encontró ${entity}...`) `` — *template literals* de JS. Java no tiene interpolación (los *String Templates*, JEP 430/459, fueron preview en 21 y 22 y se **retiraron en la 23**): va concatenación con `+`, o `String.format`. Al corregirlo escribió `+ " id"` entre comillas creyendo que era la variable, y no pudo ver el error solo ni descomponiendo la línea en operandos — hubo que explicar directamente que **las comillas son la frontera entre texto y código**. Vigilar: es la confusión de base que arrastra del stack anterior.
- **`Optional`**: sabe usarlo cuando copia el molde, no cuando lo escribe solo. Dos errores el mismo día: asignó `artistaRepo.findById(id)` directo a un `Artista` (es `Optional<Artista>`), y escribió `orElseThrow(new X(...))` sin la lambda. El compilador lo dijo textual: `required: Supplier<? extends X> / found: InvalidReferenceException`. El concepto que falta es que `orElseThrow` **no recibe una excepción, recibe una receta para fabricarla** — y que por eso solo se construye si el `Optional` vino vacío.
- **`@Version` y optimistic locking (Etapa 2): el terreno ya está preparado.** Razonó solo el escenario de *lost update* con dos hilos y entendió que el `CHECK` no lo detecta (los dos escriben 0, nunca -1). Retomar desde ahí, no desde cero.
- **DTOs y validación**: las **decisiones** las tomó y justificó bien solo (dos DTOs, `@NotBlank`, reusar el `Request` en el `PUT`, mapeo en el controller). El **código** necesitó andamiaje en casi todos los pasos: pidió el código hecho para `@Valid`, para el `ArtistaResponse` en `create` y para el handler de validación. **Segundo intento (`AlbumController`, 2026-09-25): sigue sin saldarse.** Cableó los cinco endpoints sin mirar `ArtistaController`, pero el `create` necesitó **seis rondas** de corrección (recibía la entidad en vez del DTO, `@NotBlank` en vez de `@Valid`, `@Valid` mal ubicado, el nombre `post`→`save`→`create`, un parámetro `Long idArtista` suelto, el retorno de `save` descartado, y dos setters faltantes). `getById`, `delete` y —tras señalarle el problema de capas— `update` sí salieron con pistas mínimas. Reintentar con `Edicion`.
- **Anotaciones de springdoc**: mismo perfil que con los DTOs. Las **decisiones** las tomó y justificó bien (qué anotar y qué no, dejar el `400` con el schema genérico). El **código** se trabó dos veces y hubo que servirlo hecho: la sintaxis de `headers = @Header(...)`, y dónde ubicar un `@ApiResponse` nuevo dentro de un `@ApiResponses` que ya existía. Saldarlo con la segunda entidad: que anote sus cinco endpoints sin mirar `ArtistaController`.
- **Bean Validation más allá de `@NotBlank`**: no conocía `@NotNull` y propuso `nullable` (que no es una anotación, sino un atributo de `@Column` — confusión de capas, ver abajo). La familia por tipo (`@NotNull` / `@NotEmpty` / `@NotBlank`) se explicó una vez; `@Min`/`@Max` se mencionaron pero **no se usaron todavía** (quedó pendiente decidir si `anio` lleva rango).
- **DTOs con relaciones (`Album`)**: las **decisiones** las tomó bien y una la razonó solo de punta a punta (que cinco excepciones con el mismo cuerpo no distinguen nada). El **código** siguió necesitando corrección: escribió `String anio` **dos veces** —en el `Request` y después en el `Response`— aunque la entidad dice `Integer` y ya se le había señalado.
- **El mapeo entidad → DTO (`toResponse`)**: no lo recordaba de `Artista` ("me olvidé cómo se hacía con los DTO responses"), aunque sí recordaba **que existía un método para estandarizar la respuesta**. Guiado en dos pasos (primero la firma sola, después el cuerpo) lo escribió bien, incluido el orden de los componentes del record. **No dominado**: el andamiaje fue la partición en pasos, no el código. Reintentar con `Edicion`, que tiene la misma forma (un `AlbumResponse` anidado).
- **Streams**: segunda vez (`getAll` de `Album`). Eligió el stream sobre el bucle y dio un motivo propio ("menos verboso"), pero dijo directamente **"no sé la sintaxis"** y hubo que servirla. La escribió bien a la primera con el molde delante. Lo que funcionó para explicarla: partir del `map` de JS y nombrar las tres diferencias (`.stream()` primero, `->` en vez de `=>`, `.toList()` al final porque el stream no es una lista). Aún no vio `Collectors` ni las *method references* (`this::toResponse`), que es la forma idiomática de la lambda que quedó en los dos `getAll`.
- **Records**: primera vez. Entendió qué genera el compilador y por qué van sin Lombok, pero no escribió ninguno sin modelo a la vista salvo `ArtistaResponse`.

### Cómo trabaja Esteban — patrones observados

- **Saltea las preguntas de verificación.** Responde la salida de un comando en vez de la pregunta, o pasa de largo. Repreguntar explícitamente; no darlo por entendido porque siguió adelante.
- **Ante la repregunta, responde con la conclusión y pide confianza** ("está todo eso, confía en mí") en vez de contestar el contenido. Conviene **reformular la pregunta como parte del trabajo siguiente**, donde la respuesta se usa para algo, en lugar de insistir de frente.
- **⚠️ Razona la opción correcta en la conversación y escribe la otra en el código.** Elige lanzar una excepción y escribe `orElse(null)`; concluye `RuntimeException` y escribe `extends Exception`. No es falta de comprensión: el hábito viejo gana cuando la atención está en la sintaxis. Contramedida acordada: que relea el método completo contra la decisión antes de pasarlo.
- **Corrige la línea señalada y se lleva puesta la anterior.** Pedirle que relea el método entero, no la línea.
- **⚠️ Aplica un cambio en todos los lugares menos uno.** El patrón más frecuente y el más costoso: de "son tres cambios" hace dos; de "reemplazá las cuatro ocurrencias" reemplaza tres; el que falta suele ser la **firma del método**, porque la atención está en el cuerpo. Aparece incluso cuando se le advierte en el mismo mensaje. **Contramedida acordada (mecánica, no de atención): al terminar, buscar en el archivo la cadena que debía desaparecer (`Ctrl+F`). Si aparece, no terminó.** Al pedirle una tarea de este tipo, decirle de antemano **cuántos** cambios son.
  **La contramedida no se usó ninguna de las dos veces que hizo falta** (2026-09-16, migrando `ArtistaService` a `NotFoundException`): con la lista de los cuatro lugares escrita en el mensaje, hizo 1 de 4 y avisó; corregido, hizo 3 de 4 y volvió a avisar. Sí funciona **mostrarle la salida del `grep`**: con las tres ocurrencias listadas delante, las cerró sin más ayuda. Conclusión práctica: pedirle la búsqueda no alcanza, hay que hacerla y pegarle el resultado.
  **2026-09-25, con la lista numerada delante: hizo 2 de 4** (le quedaron el nombre del método y el `ResponseEntity`), y en la ronda siguiente cambió `post` por `save` —el verbo de la capa *service*— en vez de `create`. **Lo que sí funcionó: dibujarle la firma con flechas señalando cada punto pendiente**, uno debajo del otro. Con eso cerró los tres de una.
  **Contramedida de diseño que sí funcionó sola:** al cambiar la firma de la excepción de un parámetro a dos, cualquier `throw` olvidado dejó de compilar. Cuando se pueda, darle al refactor una forma que el compilador pueda verificar — y **borrar la clase vieja al final**, que convierte cualquier resto en un error de build.
- **Da por verificado lo que no se ejecutó.** Probó una refactorización con la tabla vacía: `[]` y `404`, dos respuestas correctas y cero llamadas al método que acababa de extraer. Antes de aceptar una prueba como válida, preguntarle **cuántas veces corrió la línea que cambió**.
- **⚠️ "Listo" no significa listo.** El 2026-09-16 dijo "listo" cuatro veces: una sin haber guardado el archivo (el disco tenía la versión vieja), dos con el build roto, una sin haber corrido la búsqueda que se le había pedido. **Contramedida: no aceptar un "listo" sin leer el archivo en disco, y pedirle la última línea del build** ("¿qué dijo, `SUCCESS` o `FAILURE`?"). Cuando se le preguntó explícitamente, contestó bien.
  **Reincidió el 2026-09-25**: dijo "listo" sobre un método que no compilaba (había borrado la línea que creaba la variable del `return`) y sin haber corrido el build que se le había pedido en el mismo mensaje. La contramedida funciona y hay que usarla **todas** las veces: leer el archivo y pedir la última línea.
  Variante nueva del mismo patrón: **corre el comando y no contesta la pregunta.** Cuando se le pide predecir algo *antes* de ejecutarlo, tiende a ejecutar y pegar la salida. La salida no prueba comprensión — la máquina ya sabía la respuesta. Repreguntar con un molde a completar ("*en el primero el id venía en ___, en el segundo en ___*") sí funcionó.
- **Deja código viejo comentado** en vez de borrarlo, e **importa dos veces la misma clase** (el IDE lo agrega y él además lo escribe). Señalarlo cada vez: para lo primero está Git; para lo segundo, mirar la lista de imports antes de aceptar la sugerencia del IDE.
- **Pide el código hecho antes que intentarlo** (ver regla 1.b). Aceptable para sintaxis; **no** para decisiones de diseño — ahí hay que hacerlo elegir y justificar.
- **Vuelve a preguntar comandos ya dados** (`docker compose up`, entrar a `psql`). Los junta en `bd.txt`; apuntarlo ahí y, más adelante, al README.
- **Al explicar mecanismos, atribuye intención al sistema** ("quiere protegerme") en vez de describir el mecanismo. Empujarlo al mecanismo cada vez.
- **Se satura con sesiones largas sobre un mismo tema** ("ya me abruma todo esto", dicho después de una hora seguida de springdoc). No es falta de interés: llega igual al final, pero las últimas decisiones las toma por cansancio. Ofrecer el corte antes de que lo pida, y cerrar con algo mecánico y sin trampas en vez de con una decisión de diseño.
- **✅ Lo que sí funciona para que razone solo: mostrarle el código de la opción mala, no discutirla en abstracto.** Con las cinco excepciones, escritas una debajo de la otra con el cuerpo idéntico, llegó solo a la conclusión correcta. Antes, con la misma disyuntiva planteada como dos opciones descritas, había elegido la cara sin poder dar el criterio. Usar esto en vez de insistir con preguntas.
- **Ante territorio completamente nuevo, la secuencia socrática lo frustra en vez de ayudarlo.** Señal de alarma: cuando empieza a contestar "¿cómo es?" o "¿cómo lo cambio?" en lugar de intentar, conviene pasar a explicación directa, con el código servido y explicado línea por línea. Retomar las preguntas después, sobre lo ya escrito.

### Errores conceptuales corregidos (vigilar si reaparecen)

- Creyó que **`not null` garantiza que el stock no sea negativo**. Son tres cosas distintas: existencia del valor (`not null`), tipo (`integer`) y rango (`CHECK`).
- Buscó una anotación de validación llamada **`nullable`**. No existe: `nullable` es un **atributo de `@Column`/`@JoinColumn`** (JPA), que genera el `NOT NULL` del `CREATE TABLE` y lo hace cumplir Postgres en cada `INSERT`. `@NotNull` es Bean Validation, la ejecuta Hibernate Validator sobre el JSON deserializado, antes de que el service toque nada. Mismo valor prohibido, distinto ejecutor, distinto momento, y **distinto alcance**: `@NotNull` solo cubre lo que entra por HTTP — un test, otro service o la tarea `@Scheduled` lo esquivan, y ahí la única defensa es la columna.
- Al declarar `toResponse`, le pasó los **campos sueltos** (`String titulo, String discografica, String genero, Long artistaId`) en vez de la entidad. Preguntado de dónde saldría entonces el `pais` del artista, contestó "del `artistaId`". Un `Long` es el número `7`: para llegar a `"Reino Unido"` hace falta un `SELECT`, y eso metería un repositorio en el controller. Lo que lo zanjó fue mirar la entidad: el campo no es `Long artistaId`, es **`Artista artista`** — en la tabla hay un número (`@JoinColumn`), en el objeto hay un `Artista` entero, y esa traducción es el trabajo de Hibernate. Corolario que conviene repetir: el `Request` lleva el id plano porque es lo único que el cliente tiene; el `Response` sale del objeto ya resuelto. **Además, el patrón "todos menos uno" de siempre**: de los seis campos del `AlbumResponse`, los parámetros sueltos cubrían cuatro.
- En el `POST`, declaró el parámetro del body como **`Album` (la entidad)** teniendo `AlbumRequest` ya importado. El criterio que lo zanjó no fue la regla ("no exponer entidades") sino **ver el JSON que cada tipo obliga a mandar**: con `Album`, el cliente manda un `id` que no le corresponde y un `artista` anidado entero cuyo `nombre` y `pais` el service ignora. **El tipo del parámetro *es* el contrato público de la API** — Jackson deserializa en lo que diga la firma.
- Declaró `Long idArtista` como **segundo parámetro suelto, sin anotación**, y se lo pasó al service. Spring resuelve un parámetro simple sin anotar desde la **query string**, o sea que esperaría `POST /api/albumes?idArtista=7` y en la práctica llega `null`. El dato ya venía adentro del `AlbumRequest` (`request.artistaId()`). La asimetría que hay que repetir: el *service* pide el id suelto porque no sabe nada de DTOs; **desarmar el DTO es el trabajo del controller**.
- Puso **`@NotBlank` sobre el `AlbumRequest`** para activar la validación. `@NotBlank` es solo para `String`: compila y explota en runtime (`HV000030` → `500`), igual que cuando se le puso a un `Integer`. La que va es **`@Valid`**, que no valida el objeto sino que le dice a Spring "entrá adentro y ejecutá las validaciones de sus campos". Aparte, la escribió **entre el tipo y el nombre** (`AlbumRequest @Valid album`): las anotaciones de un parámetro van todas **antes del tipo**.
- Predijo **`404`** para un `POST` sin `titulo`. Es `400`: no falta ningún recurso, está mal el contenido del request. Los tres se separan por **dónde se detecta el problema**: el `400` leyendo el request, el `422` yendo a la base, el `404` porque la URL no apunta a nada.
- Usó **"deserializa"** para hablar de la respuesta. Deserializar es JSON → objeto (entrada); serializar es objeto → JSON (salida).
- Escribió el `PUT` como `findById` + setters + `save`, **esquivando `AlbumService.update`**, que él mismo había escrito la sesión anterior. Funciona (el `Album` ya trae el `id`, así que `save` hace `UPDATE`), pero deja un método público del service sin llamar y muda la secuencia de persistencia al controller. Lo que lo zanjó fue la pregunta por el futuro: *si mañana `update` tuviera que rechazar años futuros, ¿tu `PUT` se enteraría?* — contestó "no" solo. **Síntoma general a vigilar: un método del service que nadie invoca.**
- Creyó que **`AlbumResponse` no necesitaba importar `ArtistaResponse` "porque es un record"**. Es porque están en el mismo paquete. Contraejemplo que lo zanjó: `Album` (clase normal, no record) usa `Artista` sin importarlo. `import` no carga nada — es una abreviatura de nombres para el compilador.
- Creyó que **`validate` valida y después aplica**. No aplica nunca nada.
- Creyó que si a una dependencia le falta `<version>`, **Maven usa la más nueva**. No: el pom es inválido y el build falla antes de leer una línea de Java (`'dependencies.dependency.version' ... is missing`). Un build tiene que ser reproducible; elegir "la última" haría que el mismo commit compile distinto cada día.
- Creyó que el `<parent>` **solo fija la versión de Spring**. Trae un `dependencyManagement` con cientos de pares artefacto → versión, terceros incluidos (Postgres, Lombok, Testcontainers, Jackson). Contraejemplo que lo zanja: esas tres no llevan `<version>` en el pom y no son de Spring. No agrega dependencias: solo fija la versión de las que uno declara — y lo que no está en la lista (springdoc) hay que versionarlo a mano.
- Creyó que **un repositorio es "los métodos tipo get, getAll"**. Es una interfaz de `repository/`, una por entidad, que el service recibe por constructor. Acto seguido, creyó que `AlbumRepository` podía traerle un `Artista`: el primer genérico de `JpaRepository<Album, Long>` **es la tabla con la que habla**, y `albumRepo.findById(7L)` devuelve `Optional<Album>`, no `Optional<Artista>`.
- **No sabía qué es la "firma" de un método** (todo lo anterior a la llave: visibilidad, tipo de retorno, nombre y parámetros). Vocabulario básico que faltaba; conviene no usarlo sin haberlo definido. Nota útil que sí entendió: la firma es lo único que ve quien llama, por eso es decisión de diseño y el cuerpo es detalle.
- Creyó que **sin `@Service` el error aparece al compilar**. Aparece **al arrancar**: `javac` solo verifica tipos y no sabe qué es inyección de dependencias; el que no encuentra el bean es Spring al armar el contexto (`UnsatisfiedDependencyException` → `NoSuchBeanDefinitionException`). Otro caso de "¿quién lo hace?".
- Llamó **"más eficiente"** a completar la entidad recibida en vez de construir otra copiando campos. No cambia el rendimiento (la JVM asigna objetos chicos a costo despreciable y el viaje a la base domina por órdenes de magnitud): lo que cambia es que hay **una sola lista de campos en vez de dos**. No es más rápido, es menos frágil.
- Confundió `private` con la visibilidad de paquete (`private` es solo la clase; la de paquete es la que no lleva modificador).
- Llamó "azúcar sintáctico" a `Optional`. No lo es: cambia el tipo y las garantías del compilador, no la sintaxis.
- Confusión de capas: preguntó si `create-drop` era "algo de Docker o de Postgres". Es de Hibernate. Ante cualquier comportamiento raro, insistir en **"¿quién lo hace?"** antes que "¿dónde pasa?".
- De sesiones anteriores: dirección vs. puerto, "nombre del puerto", contenedor vs. volumen.

### Hilo conductor pedagógico del proyecto

Casi todos los bugs encontrados hasta ahora tienen la misma forma: **el sistema arranca, responde, y está mal.** El `ddl-auto` sin definir, el Postgres nativo compitiendo por el 5432, el `CREATE TABLE` que falla como `WARN`, el volumen de Docker montado en el path viejo, el `orElse(null)`, el `delete` que no borraba, y toda la tanda de springdoc (la doc anunciando `200` donde el código devuelve `201`, el `404` documentado con un cuerpo que la API nunca manda, el `@ApiResponse` duplicado que pisa al anterior en silencio).

De ahí los dos métodos que conviene sostener: **predecir antes de mirar**, y **verificar por el camino que falla**, no por otro. Corolario: "levanta y responde" nunca es criterio de que algo esté bien.

**⚠️ `BUILD SUCCESS` tampoco es criterio — y esta trampa es del entorno, no de Esteban** (encontrada el 2026-09-16). La extensión de Java de VSCode compila en background y deja los `.class` de `target/` más nuevos que los `.java`. Maven entonces informa:

```
[INFO] Nothing to compile - all classes are up to date.
[INFO] BUILD SUCCESS
```

sobre **cero archivos**, con dos errores de compilación reales en el código. `mvn clean compile` los mostró. **Usar siempre `clean` para verificar**: un `BUILD SUCCESS` no dice "tu código está bien", dice "no falló ninguna de las tareas que corrí" — y si la tarea fue *nada*, el éxito es vacío.

Ejemplos nuevos de la misma familia, los dos del 2026-09-16: `super(... + " id")` con la variable entre comillas (sale el texto `id` en vez del número, y el `+` entre strings no tiene forma de fallar), y el literal `"Arista"` sin la `t` (compila, arranca, devuelve el `422` correcto, y le manda una palabra inventada al cliente).

**Un ejemplar más, y esta vez el que predijo mal fue Claude** (2026-09-18): `AlbumController.java` está **sin la línea `package`**. Claude afirmó "este archivo no compila" y `mvn clean compile` devolvió `BUILD SUCCESS`. `javac` no exige que la carpeta coincida con el `package` — eso lo exige después quien busca la clase por su nombre completo, y Maven le pasa la lista de fuentes explícita. El daño real es otro y es peor, porque es silencioso: la clase queda en el **paquete default**, fuera del árbol donde arranca el `@ComponentScan` de Spring Boot (`com.estebancardozo.tiendadiscos` y hacia abajo). La app levanta, no hay ningún error, y el `@RestController` simplemente no se registra. Es el mismo diagnóstico que el `CREATE TABLE` fallando como `WARN`. Moraleja doble: **"no compila" y "no funciona" son afirmaciones distintas** —y la pregunta útil sigue siendo "¿quién lo hace?": el que se queja del package no es el compilador, es el que carga clases.

El desenlace redondea el contraste: al agregar la línea, la puso **en el medio de los imports** y ahí sí el build falló, con seis errores seguidos de `class, interface, annotation type, enum, record, method or field expected`. Un `package` **mal ubicado** es un error de sintaxis y lo ve el compilador; un `package` **ausente** es sintaxis perfectamente válida. (El orden *package → imports → tipos* lo fija el [JLS §7.3](https://docs.oracle.com/javase/specs/jls/se25/html/jls-7.html#jls-7.3), no una convención de estilo.) Y una vez corregido, la verificación que cierra el caso no fue `BUILD SUCCESS` sino un `GET /api/albumes` devolviendo `200`: sin el `package`, ese endpoint habría dado `404` con la app arrancada y el log limpio.

**Y una advertencia de método para Claude** (mismo día): afirmó que el `404` y el `422` respondían con `Content-Type` distinto, basándose en una **salida pegada a la que le faltaba una línea**. Reproducidos los dos requests, los dos mandaban `application/problem+json`. Una salida copiada no es evidencia hasta que se reproduce — la misma regla que se le exige a él, aplicada al material de diagnóstico.