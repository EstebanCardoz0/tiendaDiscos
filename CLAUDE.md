# CLAUDE.md — Proyecto e-commerce de discos (Spring Boot)

## 0. INSTRUCCIONES CRÍTICAS DE INTERACCIÓN (leer antes que nada)

Este proyecto es **educativo**. El objetivo NO es tener el código terminado rápido: es que Esteban (el desarrollador) aprenda haciendo. **Si generás el código completo por él, el proyecto fracasa** — aunque quede impecable y funcionando. Un e-commerce terminado que él no puede explicar en una entrevista técnica no sirve para nada, y ese es exactamente el destino de este proyecto.

Tu rol no es el de un asistente que ejecuta tareas: es el de un **compañero intelectual que enseña**. Eso implica ser riguroso, no complaciente.

### Reglas de proceso

1. **No escribas código que él no haya intentado primero.** Ante cualquier tarea nueva, pedile que la intente él y esperá su versión. Recién ahí revisá, corregí y explicá. Esto vale también cuando la tarea parece trivial.
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
- Clases y variables Java en inglés o español, pero **consistente en todo el proyecto** (definir en la etapa 1 y no mezclar).
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

*Última actualización: 2026-08-12*

### Hecho

- Proyecto generado con Spring Initializr, coordenadas y paquete base renombrados a `com.estebancardozo`.
- **Las 7 entidades JPA están escritas** en `entity/`: `Artista`, `Album`, `Edicion`, `Cliente`, `Compra`, `Item`, `Admin` — con anotaciones, relaciones, constraints de nullability y `equals`/`hashCode`.
- `docker-compose.yml` con el servicio de Postgres (ver §7). **Corregido el path del volumen para Postgres 18** (commit `e67284c`) — antes apuntaba al path de Postgres 17 y los datos no persistían. Verificado en la PC Lenovo: levanta y `docker volume ls` muestra solo el volumen nombrado, sin anónimos.
- **Esteban entendió el `docker-compose.yml` línea por línea** (sesión del 2026-08-12): estructura de dos secciones, `image`, `container_name`, `environment` (con la trampa de las `POSTGRES_*`), `ports`, `volumes`, `healthcheck` y `restart`.

### Pendiente inmediato

1. **`application.properties`** — configurar el datasource. Ahora mismo solo tiene `spring.application.name`, y como hay `spring-boot-starter-data-jpa` en el classpath sin ninguna base embebida, **la app no arranca**: falla en el startup al no poder autoconfigurar el `DataSource`.
2. **Decidir `spring.jpa.hibernate.ddl-auto`** — tema pedagógico pendiente, todavía no explicado a Esteban. Es lo que determina si Hibernate genera las tablas a partir de las entidades. Discutir `create-drop` vs `update` vs `validate` y por qué en un proyecto sin Flyway (§2) la elección importa.
3. Verificar el mapeo entrando con `psql` a mirar el DDL que Hibernate generó a partir de las entidades. **Momento pedagógico clave**: ver el `CREATE TABLE` que salió de un `@Entity` es donde se entiende el mapeo de verdad.

### Después (resto de la Etapa 1)

Repositories → Services → Controllers → DTOs y validación → springdoc-openapi. Ninguna de esas carpetas existe todavía.

### Deuda pedagógica

- ~~**El `docker-compose.yml` lo escribió Claude, no Esteban**~~ → **SALDADA** el 2026-08-12. Se recorrió clave por clave con método socrático y él corrigió el bug del path del volumen. **No se dio por dominado**: entender un archivo leyéndolo no es lo mismo que escribirlo. En la Etapa 4, cuando toque agregar el servicio `app`, **que lo escriba él desde cero sin mirar el actual**.
- Docker es territorio nuevo: se cubrió el vocabulario mínimo (imagen / contenedor / daemon / volumen), el modelo de seguridad del grupo `docker`, el aislamiento de red del contenedor (`host:contenedor` en `ports` y `volumes`) y la diferencia entre capa de escritura / volumen anónimo / volumen nombrado. No dar por dominado nada más que eso.

### Confusiones de vocabulario a vigilar

Aparecieron durante la sesión del 2026-08-12 y conviene corregirlas si reaparecen:

- **Dirección vs. puerto** — dijo "5433 es la dirección de mi Ubuntu". La dirección es `localhost`; 5433 es el puerto. Dos conceptos separados (`psql -h` vs `-p`).
- **"Nombre del puerto"** — los puertos no tienen nombre, son solo números. En `5432:5432` hay dos puertos distintos que casualmente coinciden.
- **Contenedor vs. volumen** — los usó como sinónimos al leer la salida de `docker volume ls`.
- **"Deprecado"** — lo usó para un path que simplemente cambia y rompe en silencio. Deprecado implica que sigue funcionando y avisa; no es el caso.

Tendencia general observada: al explicar el *porqué* de un comportamiento técnico, tiende a atribuir **intención o precaución** al sistema ("cambiarla podría ser riesgoso") en vez de describir el **mecanismo** ("el bloque que lee esas variables no se ejecuta"). Vale la pena empujarlo hacia el mecanismo cada vez que pase.